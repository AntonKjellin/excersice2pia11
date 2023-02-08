package dev.kjellin.excersice2pia11

import android.icu.text.Transliterator.Position
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(val mList : Array<String>, val onItemClicked : (String) -> Unit) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val rowText : TextView

        init{
          rowText  = view.findViewById(R.id.rowTV)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        Log.i("pia11debug", "Skapa Rad")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rad, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = mList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i("pia11debug", "RITA RAD " + position)
        holder.rowText.text = mList[position]

        holder.itemView.setOnClickListener{
            onItemClicked(mList[position])
        }

        }

    }
