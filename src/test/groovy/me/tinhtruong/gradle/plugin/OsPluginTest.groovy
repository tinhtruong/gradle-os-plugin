/**
 Copyright 2012 Tinh Truong

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package me.tinhtruong.gradle.plugin

import org.junit.Test
import org.gradle.testfixtures.ProjectBuilder

import static org.junit.Assert.*
import static org.hamcrest.Matchers.*

class OsPluginTest {

    @Test
    public void shouldRegisterConventionWhenApply() {
        def project = ProjectBuilder.builder().build()
        def plugin = new OsPlugin()
        plugin.apply(project)

        assertThat(project.convention.plugins.os, instanceOf(OsPluginConvention))
    }
}
