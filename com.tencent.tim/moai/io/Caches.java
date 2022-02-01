package moai.io;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Pair;
import android.util.SparseIntArray;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.io.ByteStreams;
import com.google.common.io.CharStreams;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

import moai.core.utilities.Maths;
import okio.Buffer;

/**
 * Created by ayangxu.
 */
public class Caches {
    public static final ThreadBuffer<char[]> SINGLE_CHAR = ThreadBuffer.chars(1);
    private static final LoadingCache<Typeface, Pair<SparseIntArray, SparseIntArray>> typefaceCache
            = CacheBuilder.newBuilder().weakKeys().build(
                new CacheLoader<Typeface, Pair<SparseIntArray, SparseIntArray>>() {
                    @Override
                    public Pair<SparseIntArray, SparseIntArray> load(Typeface typeface)
                            throws Exception {
                        return Pair.create(new SparseIntArray(), new SparseIntArray());
                    }
                });
    private static final Pair<SparseIntArray, SparseIntArray> defaultPair = Pair.create(
            new SparseIntArray(), new SparseIntArray()
    );

    private static class Values {
        Typeface typeface = null;
        SparseIntArray nonCJKFontWidth = new SparseIntArray();
        SparseIntArray CJKFontWidth = new SparseIntArray();
        void setTypeface(Typeface tf) {
            Pair<SparseIntArray, SparseIntArray> pair;
            pair = tf == null ? defaultPair : typefaceCache.getUnchecked(tf);
            nonCJKFontWidth = pair.first;
            CJKFontWidth = pair.second;
            typeface = tf;
        }
    }
    private static volatile ThreadLocal<Values> cachedTypeface = new ThreadLocal<Values>() {
        @Override
        protected Values initialValue() {
            return new Values();
        }
    };
    private static final char[][] IGNORE_CHARS = {
            {'\uE000', '\uF0FF'},
            {'\uF110', '\uF8FF'}
    };
    private static final char[][] IGNORE_CHARS_INCLUDE_SPECIAL = {
            {'\uE000', '\uF8FF'}
    };

    /**
     * 忽略某些区间的字符集
     */
    public static boolean ignore(char c) {
        for (char[] chars : IGNORE_CHARS) {
            if (c >= chars[0] && c <= chars[1]) return true;
        }
        return false;
    }

    public static boolean ignoreIncludeSpecial(char c) {
        for (char[] chars : IGNORE_CHARS_INCLUDE_SPECIAL) {
            if (c >= chars[0] && c <= chars[1]) return true;
        }
        return false;
    }

    /**
     * 高效地计算一个字符的宽度，线程安全。
     *
     * <ul>
     * <li>英文的字宽不一致，通过 Pairing Function 对字符集和大小做 hash，放入稀疏数组。</li>
     * <li>中文的字宽都是一样的，直接以字体大小做 key 放入稀疏数组。</li>
     * </ul>
     */
    public static int measureText(Paint tp, char c) {
        Values v = cachedTypeface.get();
        if (tp.getTypeface() != v.typeface) {
            v.setTypeface(tp.getTypeface());
        }
        int width;
        float fontSize = tp.getTextSize();
        boolean isCJK = isCJK(c);
        int k = isCJK ? (int)fontSize : Maths.cantor(fontSize, c);
        SparseIntArray cache = isCJK ? v.CJKFontWidth : v.nonCJKFontWidth;
        if ((width = cache.get(k, -1)) == -1) {
            width = (int) tp.measureText(buffer(c), 0, 1);
            cache.put(k, width);
        }
        return Math.max(0, width);
    }

    public static String wrapIgnoreChar(String s) {
        // 由于大多数情况，都没有忽略的字符，所以采用策略，检查，有问题再生成新字符串
        boolean ok = true;
        for (int i = 0; i < s.length(); i++) {
            if (Caches.ignoreIncludeSpecial(s.charAt(i))) {
                ok = false;
                break;
            }
        }
        if (ok) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!Caches.ignoreIncludeSpecial(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else if (i < s.length() - 1 && s.charAt(i) == '\n') {
                i++;
            }
        }
        return sb.toString();
    }

    /** 单字符缓冲 */
    public static char[] buffer(char c) {
        char[] ch = SINGLE_CHAR.array();
        ch[0] = c;
        return ch;
    }

    private final static char[] CJK_Symbols_and_Punctuation = {'\u3000', '\u303F'};
    private final static char[] CJK_Unified_Ideographs = {'\u4E00', '\u9FFF'};
    public static boolean isCJK(char c) {
        return isCJKPunctuation(c) || isCJKUnified(c);
    }
    public static boolean isCJKUnified(char c) {
        return inRange(CJK_Unified_Ideographs, c);
    }
    public static boolean isCJKPunctuation(char c) {
        return inRange(CJK_Symbols_and_Punctuation, c);
    }
    private static boolean inRange(char[] range, char c) {
        return c >= range[0] && c <= range[1];
    }

    private static final ThreadBuffer<byte[]> EMPTY_BYTE_ARRAY = ThreadBuffer.bytes(0);
    public static byte[] emptyBytes() {
        return EMPTY_BYTE_ARRAY.array();
    }

    private final static int STATIC_SIZE = 8192;
    private static final ThreadBuffer<byte[]> STATIC_BYTE_ARRAY = ThreadBuffer.bytes(STATIC_SIZE);
    public static byte[] bytes() {
        return STATIC_BYTE_ARRAY.array();
    }

    private static final ThreadBuffer<char[]> EMPTY_CHAR_ARRAY = ThreadBuffer.chars(0);
    public static char[] emptyChars() {
        return EMPTY_CHAR_ARRAY.array();
    }

    private static final ThreadBuffer<char[]> STATIC_CHAR_ARRAY = ThreadBuffer.chars(STATIC_SIZE);
    public static char[] chars() {
        return STATIC_CHAR_ARRAY.array();
    }

    private static final ThreadBuffer<int[]> EMPTY_INT_ARRAY = ThreadBuffer.ints(0);
    public static int[] emptyInts() {
        return EMPTY_INT_ARRAY.array();
    }

    private final static int DEFAULT_SIZE = 1024 * 20;
    private final static ThreadBuffer<byte[]> DYNAMIC_BYTE_ARRAY = ThreadBuffer.bytes(DEFAULT_SIZE);
    public static byte[] bytes(int len) {
        return DYNAMIC_BYTE_ARRAY.array(len);
    }
    private final static ThreadBuffer<char[]> DYNAMIC_CHAR_ARRAY = ThreadBuffer.chars(DEFAULT_SIZE);
    public static char[] chars(int len) {
        return DYNAMIC_CHAR_ARRAY.array(len);
    }
    private final static ThreadBuffer<int[]> DYNAMIC_INT_ARRAY = ThreadBuffer.ints(1024*1024);
    public static int[] ints(int len) {
        return DYNAMIC_INT_ARRAY.array(len);
    }

    public static byte[] toByteArray(InputStream input) throws IOException {
        return ByteStreams.toByteArray(input);
    }

    public static char[] toSharedCharArray(InputStream input) throws IOException {
        SharedCharArrayWriter output = new SharedCharArrayWriter();
        CharStreams.copy(new InputStreamReader(input, Charset.defaultCharset()), output);
        return output.toCharArray();
    }

    public static String toString(InputStream input) throws IOException {
        return CharStreams.toString(new InputStreamReader(input, Charset.defaultCharset()));
    }

    public static void copy(InputStream input, Writer output) throws IOException {
        CharStreams.copy(new InputStreamReader(input, Charset.defaultCharset()), output);
    }

    public static void copy(InputStream input, OutputStream output) throws IOException {
        ByteStreams.copy(input, output);
    }

    public static int[] toArray(Buffer buffer) {
        int[] ret = new int[(int)buffer.size()/4];
        int i = 0;
        while (!buffer.exhausted()) {
            ret[i++] = buffer.readInt();
        }
        return ret;
    }
    /**
     * Read characters from an input character stream.
     * This implementation guarantees that it will read as many characters
     * as possible before giving up; this may not always be the case for
     * subclasses of {@link Reader}.
     *
     * @param input where to read input from
     * @param buffer destination
     * @param offset inital offset into buffer
     * @param length length to read, must be >= 0
     * @return actual length read; may be less than requested if EOF was reached
     * @throws IOException if a read error occurs
     * @since 2.2
     */
    public static int read(Reader input, char[] buffer, int offset, int length) throws IOException {
        if (length < 0) {
            throw new IllegalArgumentException("Length must not be negative: " + length);
        }
        int remaining = length;
        while (remaining > 0) {
            int location = length - remaining;
            int count = input.read(buffer, offset + location, remaining);
            if (-1 == count) { // EOF
                break;
            }
            remaining -= count;
        }
        return length - remaining;
    }
}
