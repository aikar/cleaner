# cleaner
Abstraction around sun.misc.Cleaner and java.lang.ref.Cleaner so you can support Java 8 and 9+ without worry.

# Usage
 - REPO: https://repo.aikar.co/content/groups/aikar/
 - GROUP: co.aikar
 - ARTIFACT: cleaner
 - VERSION: `1.0-SNAPSHOT`

```java
class Example {
    private final byte[] LARGE_BUFFER = BufferPool.acquire(2048*1024);
    public Example() {
        co.aikar.cleaner.Cleaner.register(this, () -> {
          BufferPool.release(LARGE_BUFFER);
        });
    }
}
```
