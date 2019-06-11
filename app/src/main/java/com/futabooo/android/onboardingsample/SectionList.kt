package com.futabooo.android.onboardingsample

import android.util.Log
import com.xwray.groupie.Item
import com.xwray.groupie.Section

class SectionList(
  list: List<ListItem>
) : Section() {
  init {
    val items = mutableListOf<Item<*>>()
    (list).mapTo(items) { listItem ->
      ItemListItem(
        text = listItem.name,
        onClick = { text ->
          Log.d("SectionListOnClick", text)
        }
      )
    }
    update(items)
  }
}