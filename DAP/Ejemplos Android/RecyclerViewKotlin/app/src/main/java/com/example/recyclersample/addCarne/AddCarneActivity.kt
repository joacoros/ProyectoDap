/*
 * Copyright (C) 2020 The Android Open Source Project
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

package com.example.recyclersample.addCarne

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclersample.R
import com.google.android.material.textfield.TextInputEditText

const val CARNE_NAME = "name"
const val CARNE_DESCRIPTION = "description"

class AddCarneActivity : AppCompatActivity() {
    private lateinit var addCarneName: TextInputEditText
    private lateinit var addCarneDescription: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_carne_layout)

        findViewById<Button>(R.id.done_button).setOnClickListener {
            addFlower()
        }
        addCarneName = findViewById(R.id.add_flower_name)
        addCarneDescription = findViewById(R.id.add_flower_description)
    }

    private fun addFlower() {
        val resultIntent = Intent()

        if (addCarneName.text.isNullOrEmpty() || addCarneDescription.text.isNullOrEmpty()) {
            setResult(Activity.RESULT_CANCELED, resultIntent)
        } else {
            val name = addCarneName.text.toString()
            val description = addCarneDescription.text.toString()
            resultIntent.putExtra(CARNE_NAME, name)
            resultIntent.putExtra(CARNE_DESCRIPTION, description)
            setResult(Activity.RESULT_OK, resultIntent)
        }
        finish()
    }
}