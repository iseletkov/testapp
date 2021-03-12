package ru.psu.mobile.example1.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.psu.mobile.example1.model.CComment

import org.threeten.bp.format.DateTimeFormatter
import ru.psu.mobile.example1.R

class CRVAdapterComments(
    private val onClick: (CComment) -> Unit
)                                           : RecyclerView.Adapter<CRVAdapterComments.ViewHolder>()
{
    private var items: List<CComment>       = listOf()
    private val formatter                   = DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy")

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(
        view: View,
        onClick: (CComment) -> Unit
    ) : RecyclerView.ViewHolder(view) {
        val tv_author: TextView = view.findViewById(R.id.textView_author)
        val tv_text: TextView = view.findViewById(R.id.textView_text)
        val tv_time: TextView = view.findViewById(R.id.textView_time)
        private var comment: CComment? = null

        init {
            tv_text.setOnClickListener {
                comment?.let {
                    onClick(it)
                }
            }
        }
        fun bind(
            comment: CComment,
            formatter: DateTimeFormatter
        ) {
            this.comment = comment

            // Get element from your dataset at this position and replace the
            // contents of the view with that element
            tv_author.text = comment.author
            tv_text.text = comment.text
            tv_time.text =comment.time.format(formatter)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.rvitem_comments, viewGroup, false)


        return ViewHolder(view, onClick)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.bind(items[position], formatter)

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = items.size

    fun setWords(items: List<CComment>) {
        this.items = items
        notifyDataSetChanged()
    }

}
