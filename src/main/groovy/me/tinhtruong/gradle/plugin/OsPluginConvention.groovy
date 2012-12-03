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

class OsPluginConvention {

    private final String os
    private final boolean is64bit

    public OsPluginConvention() {
        os = System.getProperty("os.name").toLowerCase()
        if (isWindows()) {
            is64bit = (System.getenv("ProgramFiles(x86)") != null);
        } else {
            is64bit = (System.getProperty("os.arch").indexOf("64") != -1);
        }
    }

    private boolean isWindows() {
        return os.indexOf("win") >= 0
    }

    private boolean isMacOs() {
        return os.indexOf("mac") >= 0
    }

    private boolean isUnix() {
        return os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0 || os.indexOf("aix") > 0
    }

    private boolean isSunOs() {
        return os.indexOf("sunos") >= 0
    }

    def windows(Closure closure) {
        if (isWindows()) {
            closure.delegate = this
            closure()
        }
    }

    def macOs(Closure closure) {
        if (isMacOs()) {
            closure.delegate = this
            closure()
        }
    }

    def unix(Closure closure) {
        if (isUnix()) {
            closure.delegate = this
            closure()
        }
    }

    def sunOs(Closure closure) {
        if (isSunOs()) {
            closure.delegate = this
            closure()
        }
    }

    def x86(Closure closure) {
        if (!is64bit) {
            closure.delegate = this
            closure()
        }
    }

    def x86_64(Closure closure) {
        if (is64bit) {
            closure.delegate = this
            closure()
        }
    }
}
