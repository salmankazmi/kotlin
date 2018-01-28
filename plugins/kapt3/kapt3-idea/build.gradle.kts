
apply { plugin("kotlin") }
apply { plugin("jps-compatible") }

jvmTarget = "1.6"

dependencies {
    compile(projectDist(":kotlin-stdlib"))
    compile(project(":compiler:frontend"))
    compile(project(":idea")) { isTransitive = false }
    compile(project(":idea:kotlin-gradle-tooling"))
    compile(project(":kotlin-annotation-processing"))
    compile(ideaSdkDeps("openapi", "external-system-rt"))
    compile(ideaPluginDeps("gradle-core", "gradle-tooling-api", "gradle", plugin = "gradle"))
    compile(ideaPluginDeps("android", "android-common", "sdklib", "sdk-common", "sdk-tools", plugin = "android"))
}

sourceSets {
    "main" { projectDefault() }
    "test" {}
}

val jar = runtimeJar()

ideaPlugin {
    from(jar)
}
