package com.dcr.practicedraw1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_page.*
import kotlinx.android.synthetic.main.fragment_page.view.*

/**
 * @author dcr
 * @date 2020/6/2  17:49
 */
class PageFragment : Fragment() {
    @LayoutRes
    var sampleLayoutRes: Int = 0

    @LayoutRes
    var practiceLayoutRes: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_page, container, false)
        val sampleStub = view.sampleStub
        sampleStub.layoutResource = sampleLayoutRes
        sampleStub.inflate()
        val practiceStub = view.practiceStub
        practiceStub.layoutResource = practiceLayoutRes
        practiceStub.inflate()
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sampleLayoutRes = arguments?.get("sampleLayoutRes") as Int
        practiceLayoutRes = arguments?.get("practiceLayoutRes") as Int
    }
}

// 这里的实现不知道是不是最优的，这里没有写成 companion object 的方式，而是写成了 top-level 的函数
fun newPageFragmentInstance(
    @LayoutRes sampleLayoutRes: Int,
    @LayoutRes practiceLayoutRes: Int
): PageFragment {
    val args = Bundle()
    args.putInt("sampleLayoutRes", sampleLayoutRes)
    args.putInt("practiceLayoutRes", practiceLayoutRes)

    val fragment = PageFragment()
    fragment.arguments = args
    return fragment
}