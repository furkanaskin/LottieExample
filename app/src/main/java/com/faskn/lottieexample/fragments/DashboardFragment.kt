package com.faskn.lottieexample.fragments


import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.faskn.lottieexample.R
import com.faskn.lottieexample.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_dashboard.*


class DashboardFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_github.visibility = View.GONE
        av_like_animation.visibility = View.GONE

        av_like_animation.setAnimation("like.json")
        fab.setOnClickListener {
            tv_github.visibility = View.VISIBLE
            av_like_animation.visibility = View.VISIBLE

            av_like_animation.playAnimation()


            val animationFadeIn = AnimationUtils.loadAnimation(this.context, R.anim.fade_in)
            tv_github.startAnimation(animationFadeIn)
            av_like_animation.startAnimation(animationFadeIn)

            val animationFadeOut = AnimationUtils.loadAnimation(this.context, R.anim.fade_out)

            object : CountDownTimer(3000, 1000) {
                override fun onFinish() {
                    tv_github.startAnimation(animationFadeOut)
                    av_like_animation.startAnimation(animationFadeOut)
                }

                override fun onTick(millisUntilFinished: Long) {
                }
            }.start()
        }
    }
}
