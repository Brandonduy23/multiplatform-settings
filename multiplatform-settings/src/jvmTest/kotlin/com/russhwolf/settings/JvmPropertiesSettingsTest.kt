/*
 * Copyright 2019 Russell Wolf
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.russhwolf.settings

import org.junit.Test
import java.util.Properties
import kotlin.test.assertEquals

@UseExperimental(ExperimentalJvm::class)
class JvmPropertiesSettingsTest : BaseSettingsTest(
    platformFactory = object : Settings.Factory {
        val properties = Properties()

        override fun create(name: String?): JvmPropertiesSettings {
            return JvmPropertiesSettings(properties)
        }
    },
    hasNamedInstances = false,
    hasListeners = false
) {
    @Test
    fun constructor_properties() {
        val properties = Properties()
        val settings = JvmPropertiesSettings(properties)
        properties["a"] = "value"
        assertEquals("value", settings["a", ""])
    }
}