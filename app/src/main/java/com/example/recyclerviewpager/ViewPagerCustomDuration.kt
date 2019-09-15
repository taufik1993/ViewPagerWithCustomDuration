package com.example.recyclerviewpager

import android.content.Context
import android.util.AttributeSet
import android.view.animation.Interpolator
import java.lang.reflect.AccessibleObject.setAccessible
import androidx.viewpager.widget.ViewPager


class ViewPagerCustomDuration : ViewPager {

    private var mScroller: ScrollerCustomDuration? = null

    constructor(context: Context) : super(context) {
        scrollInitViewPager()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        scrollInitViewPager()
    }

    private fun scrollInitViewPager() {
        try {
            val scroller = ViewPager::class.java.getDeclaredField("mScroller")
            scroller.isAccessible = true
            val interpolator = ViewPager::class.java.getDeclaredField("sInterpolator")
            interpolator.isAccessible = true
            mScroller = ScrollerCustomDuration(context, interpolator.get(null) as Interpolator)
            scroller.set(this, mScroller)
        } catch (e: Exception) {
        }

    }
}