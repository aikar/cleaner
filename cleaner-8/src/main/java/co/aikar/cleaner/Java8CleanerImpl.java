package co.aikar.cleaner;

import sun.misc.Cleaner;

public class Java8CleanerImpl {
    public static void clean(Object object, Runnable run) {
        Cleaner.create(object, run);
    }
}
