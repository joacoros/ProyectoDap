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

@file:JvmName("CarneKt")

package com.example.recyclersample.data

import android.content.res.Resources
import com.example.recyclersample.R

/* Returns initial list of flowers. */
fun flowerList(resources: Resources): List<Carne> {
    return listOf(
        Carne(
            id = 1,
            name = resources.getString(R.string.carne1_name),
            image = R.drawable.bife,
            description = resources.getString(R.string.carne1_description)
        ),
        Carne(
            id = 2,
            name = resources.getString(R.string.carne2_name),
            image = R.drawable.churrasco,
            description = resources.getString(R.string.carne2_description)
        ),
        Carne(
            id = 3,
            name = resources.getString(R.string.carne3_name),
            image = R.drawable.entrana,
            description = resources.getString(R.string.carne3_description)
        ),
        Carne(
            id = 4,
            name = resources.getString(R.string.carne4_name),
            image = R.drawable.vacio,
            description = resources.getString(R.string.carne4_description)
        ),
        Carne(
            id = 5,
            name = resources.getString(R.string.carne5_name),
            image = R.drawable.pica,
            description = resources.getString(R.string.carne5_description)
        ),
        Carne(
            id = 6,
            name = resources.getString(R.string.carne6_name),
            image = R.drawable.ojodebife,
            description = resources.getString(R.string.carne6_description)
        )
    )
}