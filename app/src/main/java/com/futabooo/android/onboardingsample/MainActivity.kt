package com.futabooo.android.onboardingsample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.futabooo.android.onboardingsample.databinding.ActivityMainBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder

class MainActivity : AppCompatActivity() {

  private val binding by lazy {
    DataBindingUtil.setContentView<ActivityMainBinding>(
      this,
      R.layout.activity_main
    )
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val list = listOf(
      ItemText("1") {

      },
      ItemImage(getDrawable(android.R.drawable.ic_menu_gallery)),
      ItemText("2") {

      },
      ItemList(
        items = listOf(
          ListItem("in RecyclerView 1"),
          ListItem("in RecyclerView 2"),
          ListItem("in RecyclerView 3"),
          ListItem("in RecyclerView 4"),
          ListItem("in RecyclerView 5"),
          ListItem("in RecyclerView 6"),
          ListItem("in RecyclerView 7")
        ),
        linearLayoutManager = LinearLayoutManager(this)
      ),
      ItemText("3") {
      }
    )

    val groupAdapter = GroupAdapter<ViewHolder>()

    binding.viewPager.isUserInputEnabled = false
    binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    binding.viewPager.adapter = groupAdapter
    binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
      override fun onPageScrollStateChanged(state: Int) {
        super.onPageScrollStateChanged(state)
        Log.d("ViewPager2", "onPageScrollStateChanged: $state")
      }

      override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        super.onPageScrolled(position, positionOffset, positionOffsetPixels)
        Log.d(
          "ViewPager2",
          "onPageScrolled: position= $position, positionOffset= $positionOffset, positionOffsetPixels=$positionOffsetPixels"
        )
      }

      override fun onPageSelected(position: Int) {
        super.onPageSelected(position)
        Log.d("ViewPager2", "onPageSelected: $position")
        binding.header.text = position.toString()
        when (val item = list[position]) {
          is ItemText -> {
          }
          is ItemImage -> {
          }
        }
      }
    })

    binding.button.setOnClickListener {
      val currentItem = binding.viewPager.currentItem
      binding.viewPager.currentItem = currentItem + 1
    }

    groupAdapter.addAll(list)
  }

  override fun onBackPressed() {
    val currentItem = binding.viewPager.currentItem
    if (currentItem == 0) {
      super.onBackPressed()
    } else {
      binding.viewPager.currentItem = currentItem - 1
    }
  }
}
