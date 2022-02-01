package moai.core.utilities;

import com.google.common.base.Preconditions;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import okio.Buffer;

/**
 * Created by ayangxu.
 */
public class Indexes {
    //region 数组
    public static class InvalidArrayException extends RuntimeException {
        InvalidArrayException(int pre, int current) {
            super(String.format("index array should be sorted. pre %d > current %d", pre, current));
        }
        InvalidArrayException() {
            super("index array is empty");
        }
    }

    static void checkArray(int[] arr) {
        if (arr == null) throw new NullPointerException("index array should not be null");
        if (arr.length == 0) throw new InvalidArrayException();
        int last = 0;
        for (int i : arr) {
            if (last > i) throw new InvalidArrayException(last, i);
            last = i;
        }
    }
    public static void checkOffsetAndCount(int arrayLength, int offset, int count) {
        if ((offset | count) < 0 || offset > arrayLength || arrayLength - offset < count) {
            throw new ArrayIndexOutOfBoundsException("length=" + arrayLength +
                    "; regionStart=" + offset + "; regionLength=" + count);
        }
    }
    //endregion
    //region int/byte 转换（不压缩）
    public static byte[] encodeIndex(int[] arr) {
        checkArray(arr);
        ByteBuffer b = ByteBuffer.allocate(arr.length * 4);
        for (int i : arr) {
            b.putInt(i);
        }
        return b.array();
    }

    public static int[] decodeIndex(byte[] arr) {
        ByteBuffer b = ByteBuffer.wrap(arr);
        int[] out = new int[arr.length / 4];
        for (int i = 0; i < out.length; i++) {
            out[i] = b.getInt();
        }
        return out;
    }
    //endregion
    //region 数字差异压缩
    public static int[] encodeDelta(int[] arr) {
        if (arr.length == 0) return arr;
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] -= arr[i-1];
        }
        return arr;
    }

    public static int[] decodeDelta(int[] arr) {
        if (arr.length == 0) return arr;
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i-1];
        }
        return arr;
    }
    //endregion
    //region 重复数字压缩
    public static int[] encodeRepeat(IntBuffer buffer) {
        return encodeRepeat(buffer.array(), buffer.position(), buffer.limit());
    }
    public static int[] encodeRepeat(int[] arr, int from, int length) {
        if (length <= 0) return arr;
        Buffer buffer = new Buffer();
        buffer.writeInt(length);
        int last = arr[from];
        int count = 1;
        for (int i = from + 1; i < length; i++) {
            if (arr[i] == last) {
                count++;
            } else {
                buffer.writeInt(last);
                buffer.writeInt(count);
                last = arr[i];
                count = 1;
            }
            if (i == length - 1) {
                buffer.writeInt(last);
                buffer.writeInt(count);
            }
        }
        int[] ret = new int[(int)buffer.size()/4];
        int i = 0;
        while (!buffer.exhausted()) {
            ret[i++] = buffer.readInt();
        }
        return ret;
    }

    public static Buffer encodeRepeatToBuffer(Buffer in) {
        Buffer buffer = new Buffer();
        int length = (int) in.size() / 4;
        if (length <= 0) return buffer;
        buffer.writeInt(length);
        int last = in.readInt();
        int count = 1;
        for (int i = 1, j; i < length; i++) {
            j = in.readInt();
            if (j == last) {
                count++;
            } else {
                buffer.writeInt(last);
                buffer.writeInt(count);
                last = j;
                count = 1;
            }
            if (i == length - 1) {
                buffer.writeInt(last);
                buffer.writeInt(count);
            }
        }
        return buffer;
    }

    public static int[] decodeRepeat(int[] buffer) {
        return decodeRepeat(buffer, 0, buffer.length);
    }

    public static int[] decodeRepeat(int[] arr, int from, int length) {
        if (length <= 0) return arr;
        Preconditions.checkElementIndex(from, length);
        Preconditions.checkArgument(
                length % 2 > 0,
                "decodeRepeat require odd length");
        IntBuffer ret = IntBuffer.allocate(arr[from]);
        for (int i = from + 1; i < length; i+=2) {
            int val = arr[i];
            int count = arr[i+1];
            while (count-- > 0) {
                ret.put(val);
            }
        }
        return ret.array();
    }
    //endregion
    //region Haffman 压缩
    private final static ThreadLocal<ByteBuffer> fourByteBuffer = new ThreadLocal<ByteBuffer>() {
        @Override
        protected ByteBuffer initialValue() {
            return ByteBuffer.allocate(8);
        }
        @Override
        public ByteBuffer get() {
            ByteBuffer b = super.get();
            b.clear();
            return b;
        }
    };

    private final static byte start = (byte)0x80;
    private final static byte mask = (byte)0x7f;
    public static byte[] encodeHaffman(int[] arr) {
        return encodeHaffman(arr, 0, arr.length);
    }
    public static byte[] encodeHaffman(IntBuffer buffer) {
        return encodeHaffman(buffer.array(), buffer.position(), buffer.limit());
    }
    public static byte[] encodeHaffman(int[] arr, int from, int length) {
        Buffer buffer = new Buffer();
        ByteBuffer e = fourByteBuffer.get();
        int i = from;
        while (i < from + length) {
            encodeOneInt(arr[i], e);
            buffer.write(e.array(), 0, e.limit());
            i++;
        }
        return buffer.readByteArray();
    }
    public static int encodeHaffman(Buffer in, Buffer out) {
        int i = 0;
        ByteBuffer e = fourByteBuffer.get();
        while (!in.exhausted()) {
            encodeOneInt(in.readInt(), e);
            out.write(e.array(), 0, e.limit());
            i += e.limit();
        }
        out.flush();
        return i;
    }

    public static void encodeOneInt(int input, ByteBuffer b) {
        if (input < 0) {
            throw new RuntimeException("only nature number is supported, input: " + input);
        }
        b.clear();
        for (int i = 0; i < 8; i++) {
            int r = input & mask;
            int next = input >>> 7;
            if (next > 0) {
                b.put((byte)r);
                input = next;
            } else {
                b.put((byte)(r | start));
                break;
            }
        }
        b.flip();
        reverse(b);
    }

    private static void reverse(ByteBuffer b) {
        int i = b.position();
        int j = b.limit() - 1;
        byte tmp;
        while (j > i) {
            tmp = b.get(j);
            b.put(j, b.get(i));
            b.put(i, tmp);
            j--;
            i++;
        }
    }

    public static int[] decodeHaffman(byte[] arr) {
        return decodeHaffman(arr, 0, arr.length);
    }
    public static int[] decodeHaffman(byte[] arr, int from, int length) {
        int i = from;
        ByteBuffer b = fourByteBuffer.get();
        Buffer buffer = new Buffer();
        while (i < from + length) {
            b.put((byte)(arr[i] & mask));
            if (i == arr.length - 1 ||
                    i < arr.length - 1 && (arr[i+1] & start) == start) {
                b.flip();
                buffer.writeInt(decodeOneInt(b));
                b.clear();
            }
            i++;
        }
        int[] ret = new int[(int)buffer.size()/4];
        i = 0;
        while (!buffer.exhausted()) {
            ret[i++] = buffer.readInt();
        }
        return ret;
    }

    static int decodeOneInt(ByteBuffer b) {
        int l = b.limit();
        int ret = 0;
        for (byte i = 0; i < l; i++) {
            ret = (ret << 7) + b.get(i);
        }
        return ret;
    }
    //endregion
    public static int calculateByteLength(char[] buffer, int start, int charlength) {
        int count = 0;
        charlength += start;
        for (int i = start; i < charlength; i++) {
        	if (buffer.length <= i) {
        		// 下一个字节
        		return count + 1;
        	}
            char ch = buffer[i];
            if (ch <= 0x7F) {
                count++;
            } else if (ch <= 0x7FF) {
                count += 2;
            } else if (Character.isHighSurrogate(ch)) {
                count += 4;
                i++;
            } else {
                count += 3;
            }
        }
        return count;
    }
}
