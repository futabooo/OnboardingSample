package com.futabooo.android.onboardingsample

import com.futabooo.android.onboardingsample.databinding.ItemTextBinding
import com.xwray.groupie.databinding.BindableItem

data class ItemText(
  val text: String,
  val onPageScrolled: () -> Unit
) : BindableItem<ItemTextBinding>(text.hashCode().toLong()) {
  override fun getLayout(): Int = R.layout.item_text

  override fun bind(viewBinding: ItemTextBinding, position: Int) {
    viewBinding.itemText.text = text
  }
}