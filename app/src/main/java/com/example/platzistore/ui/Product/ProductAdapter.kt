package com.example.platzistore.ui.Product



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.platzistore.databinding.ItemProductBinding
import com.example.platzistore.model.data.product.ResponseProduct


class ProductAdapter(var listener:Listener):ListAdapter<ResponseProduct, ProductAdapter.ProductViewHolder> (COMPARATOR) {

    interface Listener{
        fun productClick(ProductID:Int)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
           ItemProductBinding .inflate(LayoutInflater.from(parent.context), parent, false)

        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        getItem(position).let {
            holder.binding.productTitle.text = it.title
            holder.binding.productDescription.text = it.description
            holder.binding.productPrice.text = "Price : $${it.price}"

            it.images?.get(0)?.let { img_url ->
                holder.binding.productImage.load(img_url)
            }





            it.category?.let { ctg ->
                holder.binding.categoryName.text = ctg.name
            }

            holder.itemView.setOnClickListener {_ ->
            listener.productClick(it.id)
            }

        }




    }

    class ProductViewHolder(val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {

        val COMPARATOR = object : DiffUtil.ItemCallback<ResponseProduct>() {
            override fun areItemsTheSame(
                oldItem: ResponseProduct, newItem: ResponseProduct
            ): Boolean {

                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: ResponseProduct, newItem: ResponseProduct
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }


    }
}