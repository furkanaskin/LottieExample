package com.faskn.lottieexample.fragments


import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.faskn.lottieexample.R
import com.faskn.lottieexample.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_splash.*


class SplashFragment : BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        av_splash_animation.setAnimation("preloader.json")
        av_splash_animation.playAnimation()

        object : CountDownTimer(4000, 1000) {
            override fun onFinish() {
                navigate(R.id.action_splashFragment_to_dashboardFragment)
            }

            override fun onTick(millisUntilFinished: Long) {
            }
        }.start()
    }

    private fun navigate(action: Int) {
        view?.let { _view ->
            Navigation.findNavController(_view).navigate(action)
        }
    }

}












