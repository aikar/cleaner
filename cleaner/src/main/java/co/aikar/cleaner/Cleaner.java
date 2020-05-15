package co.aikar.cleaner;

public class Cleaner {
    public interface CleanerAPI {
        void register(Object obj, Runnable run);
    }
    static CleanerAPI create() {
        try {
            Class.forName("java.lang.ref.Cleaner");
            return Java9CleanerImpl::clean;
        } catch (ClassNotFoundException ignored) {
            try {
                Class.forName("sun.misc.Cleaner");
                return Java8CleanerImpl::clean;
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("No cleaner method supported");
            }
        }
    }

    private static final CleanerAPI api = create();

    public static void register(Object obj, Runnable run) {
        api.register(obj, run);
    }

}
