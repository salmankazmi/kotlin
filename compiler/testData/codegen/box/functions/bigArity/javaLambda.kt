// WITH_RUNTIME
// TARGET_BACKEND: JVM
// FILE: J.java

import kotlin.jvm.functions.Arity;
import kotlin.jvm.functions.FunctionN;

public class J {
    // TODO: test field, parameter
    @Arity(30)
    public static FunctionN<String> get() {
        return new FunctionN<String>() {
            @Override
            public String invoke(Object... args) {
                return "OK";
            }

            @Override
            public int getArity() {
                return 30;
            }
        };
    }
}

// FILE: K.kt

class A

fun call(f: (A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A) -> String): String {
    val a = A()
    return f(a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a)
}

fun box(): String {
    val l = J.get()
    if (l !is Function30<*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *>) return "Fail 30"
    if (l is Function31<*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *>) return "Fail 31"

    return call(l)
}
