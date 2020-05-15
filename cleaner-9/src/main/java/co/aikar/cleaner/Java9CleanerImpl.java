package co.aikar.cleaner;

import java.lang.ref.Cleaner;

public class Java9CleanerImpl {
    private static final Cleaner cleaner = Cleaner.create();
    public static void clean(Object object, Runnable run) {
        cleaner.register(object, run);
    }
}
