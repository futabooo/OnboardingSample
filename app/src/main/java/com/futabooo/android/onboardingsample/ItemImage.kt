package com.futabooo.android.onboardingsample

import android.graphics.drawable.Drawable
import com.futabooo.android.onboardingsample.databinding.ItemImageBinding
import com.xwray.groupie.databinding.BindableItem

data class ItemImage(
  val image: Drawable?
) : BindableItem<ItemImageBinding>(image.hashCode().toLong()) {
  override fun getLayout(): Int = R.layout.item_image

  override fun bind(viewBinding: ItemImageBinding, position: Int) {
    viewBinding.itemImage.setImageDrawable(image)
  }
}