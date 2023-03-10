package com.example.homework_20

import android.content.Context
import android.graphics.Rect
import android.util.DisplayMetrics
import android.view.Display
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemOffsetDecoration(private val context: Context): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val offset = 10.fromDpToPixels(context)
        with(outRect){
            left = offset
            right = offset
            top = offset
            bottom = offset
        }
    }

    private fun Int.fromDpToPixels(context: Context): Int {
        val density = context.resources.displayMetrics.densityDpi
        val pixelsInDp = density/DisplayMetrics.DENSITY_DEFAULT
        return this * pixelsInDp
    }
}