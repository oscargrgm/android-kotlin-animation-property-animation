/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.propertyanimation

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.addListener

class MainActivity : AppCompatActivity() {

    lateinit var star: ImageView
    lateinit var rotateButton: Button
    lateinit var translateButton: Button
    lateinit var scaleButton: Button
    lateinit var fadeButton: Button
    lateinit var colorizeButton: Button
    lateinit var showerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        star = findViewById(R.id.star)
        rotateButton = findViewById(R.id.rotateButton)
        translateButton = findViewById(R.id.translateButton)
        scaleButton = findViewById(R.id.scaleButton)
        fadeButton = findViewById(R.id.fadeButton)
        colorizeButton = findViewById(R.id.colorizeButton)
        showerButton = findViewById(R.id.showerButton)

        rotateButton.setOnClickListener {
            rotater()
        }

        translateButton.setOnClickListener {
            translater()
        }

        scaleButton.setOnClickListener {
            scaler()
        }

        fadeButton.setOnClickListener {
            fader()
        }

        colorizeButton.setOnClickListener {
            colorizer()
        }

        showerButton.setOnClickListener {
            shower()
        }
    }

    private fun rotater() {
        val animator = ObjectAnimator.ofFloat(star, View.ROTATION, -360f, 0f).apply {
            duration = ONE_SECOND
            disableDuringAnimation(rotateButton)
        }
        animator.start()
    }

    private fun translater() {
        val animator = ObjectAnimator.ofFloat(star, View.TRANSLATION_X, 200f).apply {
            repeatCount = ONCE
            repeatMode = ObjectAnimator.REVERSE
            disableDuringAnimation(translateButton)
        }
        animator.start()
    }

    private fun scaler() {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 4f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 4f)

        val animator = ObjectAnimator.ofPropertyValuesHolder(star, scaleX, scaleY).apply {
            repeatCount = ONCE
            repeatMode = ObjectAnimator.REVERSE
            disableDuringAnimation(scaleButton)
        }
        animator.start()
    }

    private fun fader() {
    }

    private fun colorizer() {
    }

    private fun shower() {
    }

    private fun ObjectAnimator.disableDuringAnimation(view: View) {
        addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {
                view.isEnabled = false
            }

            override fun onAnimationEnd(animation: Animator?) {
                view.isEnabled = true
            }

            override fun onAnimationCancel(animation: Animator?) {}

            override fun onAnimationRepeat(animation: Animator?) {}
        })
    }

    private companion object {
        private const val ONE_SECOND: Long = 1000L
        private const val ONCE: Int = 1
    }
}
