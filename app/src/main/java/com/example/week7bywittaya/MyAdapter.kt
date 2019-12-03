package com.example.week7bywittaya

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.model_layout.view.*
import java.lang.Exception
import java.security.AccessControlContext

class MyAdapter(var dataList : List<DataModel>,var context: Context)
    : RecyclerView.Adapter<ViewHoleder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoleder {
        return ViewHoleder(LayoutInflater.from(context).inflate(R.layout.model_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHoleder, position: Int) {
        try{
            holder?.textView.text = dataList.get(position).title
            Glide.with(context).load(dataList.get(position).url).into(holder?.imageView)
        }catch (errorVar: Exception){
            Log.e("Error", errorVar.message)
        }

    }

}
class ViewHoleder(view:View): RecyclerView.ViewHolder(view){
    var imageView = view.img_photo
    var textView = view.tv_title
}