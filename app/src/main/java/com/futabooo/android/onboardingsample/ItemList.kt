package com.futabooo.android.onboardingsample

import androidx.recyclerview.widget.LinearLayoutManager
import com.futabooo.android.onboardingsample.databinding.ItemListBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import com.xwray.groupie.databinding.BindableItem

data class ItemList(
  private val items: List<ListItem>,
  private val linearLayoutManager: LinearLayoutManager
) : BindableItem<ItemListBinding>() {
  override fun getLayout(): Int = R.layout.item_list

  override fun bind(viewBinding: ItemListBinding, position: Int) {
    val groupAdapter = GroupAdapter<ViewHolder>()
    viewBinding.itemList.layoutManager = linearLayoutManager
    viewBinding.itemList.adapter = groupAdapter

    groupAdapter.add(SectionList(items))
  }
}