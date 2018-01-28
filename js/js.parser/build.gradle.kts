
apply { plugin("kotlin") }
apply { plugin("jps-compatible") }

dependencies {
    compile(project(":compiler:util"))
    compile(project(":js:js.ast"))
    compile(ideaSdkCoreDeps("intellij-core"))
}

sourceSets {
    "main" { projectDefault() }
    "test" {}
}

