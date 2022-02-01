package moai.io;

import java.nio.IntBuffer;

import okio.Buffer;

/**
 * Created by ayangxu.
 */
public class ExpandableIntBuffer {
    public static ExpandableIntBuffer allocate() {
        return new ExpandableIntBuffer();
    }

    private Buffer buffer;

    private ExpandableIntBuffer() {
        buffer = new Buffer();
    }

    public void put(int num) {
        buffer.writeInt(num);
    }

    public IntBuffer finish() {
        IntBuffer b = IntBuffer.allocate((int)buffer.size()/4);
        while (!buffer.exhausted()) {
            b.put(buffer.readInt());
        }
        b.flip();
        return b;
    }
}