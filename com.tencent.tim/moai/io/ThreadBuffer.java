package moai.io;

import android.util.Log;

import java.lang.ref.SoftReference;
import java.lang.reflect.Array;

/**
 * 一个线程安全/内存友好的快速缓冲。
 *
 * <h5>场景一</h5>
 * 大部分时候，我们需要一个临时的 byte 数组，char 数组等，用于放一些临时的数据。
 * 这个时候往往简单做就是 new 一个新的。实际上，这部分对象只存在于当前方法体，对于很多应用场景，
 * 这个对象实际上并没有必要回收，如果有比他更小的缓冲区申请，可以继续使用这个数组。
 *
 * <h5>场景二</h5>
 * 有些时候我们需要申请一个动态扩展的数组，总是需要自己再 new 一个，然后复制一份，这个动作其实可以重用一下。
 *
 * <h5>场景三</h5>
 * 有些临时缓冲可能很大，很多实现都是放在成员变量甚至局部变量已方便复用，内存不足的时候，这些因为是强引用而没法释放。
 *
 * <h5>快速使用</h5>
 * 通过 {@link #bytes(int)} / {@link #chars(int)} / {@link #ints(int)} 快速申请一块缓冲区。然后通过
 * {@link #array()} / {@link #array(int)} 的方式获取特定大小的缓冲。
 */
public class ThreadBuffer<T> extends ThreadLocal<SoftReference<T>> {

    private static final String TAG = "ThreadBuffer";

    public static ThreadBuffer<byte[]> bytes(int capacity) {
        return new ThreadBuffer<>(byte.class, capacity);
    }

    public static ThreadBuffer<char[]> chars(int capacity) {
        return new ThreadBuffer<>(char.class, capacity);
    }

    public static ThreadBuffer<int[]> ints(int capacity) {
        return new ThreadBuffer<>(int.class, capacity);
    }

    private final int initCapacity;
    private int capacity;

    private final Class type;

    public ThreadBuffer(Class type, int capacity) {
        this.capacity = capacity;
        this.initCapacity = capacity;
        this.type = type;
    }

    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @SuppressWarnings("unchecked")
    protected T create(int capacity) {
        return (T)Array.newInstance(type, capacity);
    }
    protected boolean isEnough(T t, int size) {
        return Array.getLength(t) > size;
    }

    @Override
    protected SoftReference<T> initialValue() {
        return new SoftReference<>(create(capacity));
    }

    public T array(int size) {
        T t = get().get();
        if (t == null || !isEnough(t, size)) {
            if (t == null) {
                Log.d(TAG, "garbage collected, realloc one.");
            } else {
                Log.d(TAG, "expanding buffer from " + Array.getLength(t) + " to " + size + ".");
            }
            setCapacity(Math.max(initCapacity, size * 2));
            set(initialValue());
            return array(size);
        }
        return t;
    }

    public T array() {
        SoftReference<T> st = get();
        T t = st.get();
        if (t == null) {
            Log.d(TAG, "garbage collected, realloc one.");
            set(initialValue());
            return array();
        }
        return t;
    }
}
