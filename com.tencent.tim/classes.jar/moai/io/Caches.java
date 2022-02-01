package moai.io;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Pair;
import android.util.SparseIntArray;
import com.google.common.cache.CacheBuilder;
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

public class Caches
{
  private static final char[] CJK_Symbols_and_Punctuation;
  private static final char[] CJK_Unified_Ideographs;
  private static final int DEFAULT_SIZE = 20480;
  private static final ThreadBuffer<byte[]> DYNAMIC_BYTE_ARRAY = ThreadBuffer.bytes(20480);
  private static final ThreadBuffer<char[]> DYNAMIC_CHAR_ARRAY = ThreadBuffer.chars(20480);
  private static final ThreadBuffer<int[]> DYNAMIC_INT_ARRAY = ThreadBuffer.ints(1048576);
  private static final ThreadBuffer<byte[]> EMPTY_BYTE_ARRAY;
  private static final ThreadBuffer<char[]> EMPTY_CHAR_ARRAY;
  private static final ThreadBuffer<int[]> EMPTY_INT_ARRAY;
  private static final char[][] IGNORE_CHARS;
  private static final char[][] IGNORE_CHARS_INCLUDE_SPECIAL;
  public static final ThreadBuffer<char[]> SINGLE_CHAR = ThreadBuffer.chars(1);
  private static final ThreadBuffer<byte[]> STATIC_BYTE_ARRAY;
  private static final ThreadBuffer<char[]> STATIC_CHAR_ARRAY;
  private static final int STATIC_SIZE = 8192;
  private static volatile ThreadLocal<Values> cachedTypeface;
  private static final Pair<SparseIntArray, SparseIntArray> defaultPair;
  private static final LoadingCache<Typeface, Pair<SparseIntArray, SparseIntArray>> typefaceCache = CacheBuilder.newBuilder().weakKeys().build(new Caches.1());
  
  static
  {
    defaultPair = Pair.create(new SparseIntArray(), new SparseIntArray());
    cachedTypeface = new Caches.2();
    char[] arrayOfChar = { -3824, -1793 };
    IGNORE_CHARS = new char[][] { { -8192, -3841 }, arrayOfChar };
    IGNORE_CHARS_INCLUDE_SPECIAL = new char[][] { { -8192, -1793 } };
    CJK_Symbols_and_Punctuation = new char[] { 12288, 12351 };
    CJK_Unified_Ideographs = new char[] { 19968, -24577 };
    EMPTY_BYTE_ARRAY = ThreadBuffer.bytes(0);
    STATIC_BYTE_ARRAY = ThreadBuffer.bytes(8192);
    EMPTY_CHAR_ARRAY = ThreadBuffer.chars(0);
    STATIC_CHAR_ARRAY = ThreadBuffer.chars(8192);
    EMPTY_INT_ARRAY = ThreadBuffer.ints(0);
  }
  
  public static char[] buffer(char paramChar)
  {
    char[] arrayOfChar = (char[])SINGLE_CHAR.array();
    arrayOfChar[0] = paramChar;
    return arrayOfChar;
  }
  
  public static byte[] bytes()
  {
    return (byte[])STATIC_BYTE_ARRAY.array();
  }
  
  public static byte[] bytes(int paramInt)
  {
    return (byte[])DYNAMIC_BYTE_ARRAY.array(paramInt);
  }
  
  public static char[] chars()
  {
    return (char[])STATIC_CHAR_ARRAY.array();
  }
  
  public static char[] chars(int paramInt)
  {
    return (char[])DYNAMIC_CHAR_ARRAY.array(paramInt);
  }
  
  public static void copy(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    ByteStreams.copy(paramInputStream, paramOutputStream);
  }
  
  public static void copy(InputStream paramInputStream, Writer paramWriter)
    throws IOException
  {
    CharStreams.copy(new InputStreamReader(paramInputStream, Charset.defaultCharset()), paramWriter);
  }
  
  public static byte[] emptyBytes()
  {
    return (byte[])EMPTY_BYTE_ARRAY.array();
  }
  
  public static char[] emptyChars()
  {
    return (char[])EMPTY_CHAR_ARRAY.array();
  }
  
  public static int[] emptyInts()
  {
    return (int[])EMPTY_INT_ARRAY.array();
  }
  
  public static boolean ignore(char paramChar)
  {
    char[][] arrayOfChar = IGNORE_CHARS;
    int j = arrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      char[] arrayOfChar1 = arrayOfChar[i];
      if ((paramChar >= arrayOfChar1[0]) && (paramChar <= arrayOfChar1[1])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean ignoreIncludeSpecial(char paramChar)
  {
    char[][] arrayOfChar = IGNORE_CHARS_INCLUDE_SPECIAL;
    int j = arrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      char[] arrayOfChar1 = arrayOfChar[i];
      if ((paramChar >= arrayOfChar1[0]) && (paramChar <= arrayOfChar1[1])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static boolean inRange(char[] paramArrayOfChar, char paramChar)
  {
    return (paramChar >= paramArrayOfChar[0]) && (paramChar <= paramArrayOfChar[1]);
  }
  
  public static int[] ints(int paramInt)
  {
    return (int[])DYNAMIC_INT_ARRAY.array(paramInt);
  }
  
  public static boolean isCJK(char paramChar)
  {
    return (isCJKPunctuation(paramChar)) || (isCJKUnified(paramChar));
  }
  
  public static boolean isCJKPunctuation(char paramChar)
  {
    return inRange(CJK_Symbols_and_Punctuation, paramChar);
  }
  
  public static boolean isCJKUnified(char paramChar)
  {
    return inRange(CJK_Unified_Ideographs, paramChar);
  }
  
  public static int measureText(Paint paramPaint, char paramChar)
  {
    Object localObject = (Values)cachedTypeface.get();
    if (paramPaint.getTypeface() != ((Values)localObject).typeface) {
      ((Values)localObject).setTypeface(paramPaint.getTypeface());
    }
    float f = paramPaint.getTextSize();
    boolean bool = isCJK(paramChar);
    int i;
    if (bool)
    {
      i = (int)f;
      if (!bool) {
        break label120;
      }
    }
    label120:
    for (localObject = ((Values)localObject).CJKFontWidth;; localObject = ((Values)localObject).nonCJKFontWidth)
    {
      int k = ((SparseIntArray)localObject).get(i, -1);
      int j = k;
      if (k == -1)
      {
        j = (int)paramPaint.measureText(buffer(paramChar), 0, 1);
        ((SparseIntArray)localObject).put(i, j);
      }
      return Math.max(0, j);
      i = Maths.cantor(f, paramChar);
      break;
    }
  }
  
  public static int read(Reader paramReader, char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 < 0) {
      throw new IllegalArgumentException("Length must not be negative: " + paramInt2);
    }
    int i = paramInt2;
    for (;;)
    {
      int j;
      if (i > 0)
      {
        j = paramReader.read(paramArrayOfChar, paramInt2 - i + paramInt1, i);
        if (-1 != j) {}
      }
      else
      {
        return paramInt2 - i;
      }
      i -= j;
    }
  }
  
  public static int[] toArray(Buffer paramBuffer)
  {
    int[] arrayOfInt = new int[(int)paramBuffer.size() / 4];
    int i = 0;
    while (!paramBuffer.exhausted())
    {
      arrayOfInt[i] = paramBuffer.readInt();
      i += 1;
    }
    return arrayOfInt;
  }
  
  public static byte[] toByteArray(InputStream paramInputStream)
    throws IOException
  {
    return ByteStreams.toByteArray(paramInputStream);
  }
  
  public static char[] toSharedCharArray(InputStream paramInputStream)
    throws IOException
  {
    SharedCharArrayWriter localSharedCharArrayWriter = new SharedCharArrayWriter();
    CharStreams.copy(new InputStreamReader(paramInputStream, Charset.defaultCharset()), localSharedCharArrayWriter);
    return localSharedCharArrayWriter.toCharArray();
  }
  
  public static String toString(InputStream paramInputStream)
    throws IOException
  {
    return CharStreams.toString(new InputStreamReader(paramInputStream, Charset.defaultCharset()));
  }
  
  public static String wrapIgnoreChar(String paramString)
  {
    int j = 0;
    int i = 0;
    if (i < paramString.length()) {
      if (!ignoreIncludeSpecial(paramString.charAt(i))) {}
    }
    for (i = 0;; i = 1)
    {
      if (i != 0)
      {
        return paramString;
        i += 1;
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      i = j;
      if (i < paramString.length())
      {
        if (!ignoreIncludeSpecial(paramString.charAt(i)))
        {
          localStringBuilder.append(paramString.charAt(i));
          j = i;
        }
        for (;;)
        {
          i = j + 1;
          break;
          j = i;
          if (i < paramString.length() - 1)
          {
            j = i;
            if (paramString.charAt(i) == '\n') {
              j = i + 1;
            }
          }
        }
      }
      return localStringBuilder.toString();
    }
  }
  
  static class Values
  {
    SparseIntArray CJKFontWidth = new SparseIntArray();
    SparseIntArray nonCJKFontWidth = new SparseIntArray();
    Typeface typeface = null;
    
    void setTypeface(Typeface paramTypeface)
    {
      if (paramTypeface == null) {}
      for (Pair localPair = Caches.defaultPair;; localPair = (Pair)Caches.typefaceCache.getUnchecked(paramTypeface))
      {
        this.nonCJKFontWidth = ((SparseIntArray)localPair.first);
        this.CJKFontWidth = ((SparseIntArray)localPair.second);
        this.typeface = paramTypeface;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.io.Caches
 * JD-Core Version:    0.7.0.1
 */