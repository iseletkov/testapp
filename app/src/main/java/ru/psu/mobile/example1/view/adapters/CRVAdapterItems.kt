package ru.psu.mobile.example1.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.psu.mobile.example1.R
import ru.psu.mobile.example1.model.CItem

class CRVAdapterItems(
    private val list                        : List<CItem>
)                                           : RecyclerView.Adapter<CRVAdapterItems.ViewHolder>()
{
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.textView_Name)
        val tvDescription: TextView = view.findViewById(R.id.textView_Description)
        val pbValue: ProgressBar = view.findViewById(R.id.progressBar_Value)
        init {
            // Define click listener for the ViewHolder's View.
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.rvitem_itemlist, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.tvName.text = list[position].name
        viewHolder.tvDescription.text = list[position].description
        viewHolder.pbValue.progress = list[position].value
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = list.size



}
