package com.futabooo.android.onboardingsample

import com.futabooo.android.onboardingsample.databinding.ItemListItemBinding
import com.xwray.groupie.databinding.BindableItem

data class ItemListItem(
  val text: String,
  val onClick: (text: String) -> Unit
) : BindableItem<ItemListItemBinding>(text.hashCode().toLong()) {
  override fun getLayout(): Int = R.layout.item_list_item

  override fun bind(viewBinding: ItemListItemBinding, position: Int) {
    viewBinding.itemListItemText.text = text
    viewBinding.itemListItemText.setOnClickListener {
      onClick(text)
    }
  }
}