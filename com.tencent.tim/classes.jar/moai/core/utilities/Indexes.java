package moai.core.utilities;

import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import okio.Buffer;

public class Indexes
{
  private static final ThreadLocal<ByteBuffer> fourByteBuffer = new Indexes.1();
  private static final byte mask = 127;
  private static final byte start = -128;
  
  public static int calculateByteLength(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int j = 0;
    int k = paramInt1;
    if (k < paramInt2 + paramInt1)
    {
      if (paramArrayOfChar.length <= k) {
        return j + 1;
      }
      int i = paramArrayOfChar[k];
      if (i <= 127) {
        j += 1;
      }
      for (;;)
      {
        k += 1;
        break;
        if (i <= 2047)
        {
          j += 2;
        }
        else if (Character.isHighSurrogate(i))
        {
          j += 4;
          k += 1;
        }
        else
        {
          j += 3;
        }
      }
    }
    return j;
  }
  
  static void checkArray(int[] paramArrayOfInt)
  {
    int i = 0;
    if (paramArrayOfInt == null) {
      throw new NullPointerException("index array should not be null");
    }
    if (paramArrayOfInt.length == 0) {
      throw new InvalidArrayException();
    }
    int m = paramArrayOfInt.length;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = paramArrayOfInt[i];
      if (j > k) {
        throw new InvalidArrayException(j, k);
      }
      i += 1;
    }
  }
  
  public static void checkOffsetAndCount(int paramInt1, int paramInt2, int paramInt3)
  {
    if (((paramInt2 | paramInt3) < 0) || (paramInt2 > paramInt1) || (paramInt1 - paramInt2 < paramInt3)) {
      throw new ArrayIndexOutOfBoundsException("length=" + paramInt1 + "; regionStart=" + paramInt2 + "; regionLength=" + paramInt3);
    }
  }
  
  public static int[] decodeDelta(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length == 0) {}
    for (;;)
    {
      return paramArrayOfInt;
      int i = 1;
      while (i < paramArrayOfInt.length)
      {
        paramArrayOfInt[i] += paramArrayOfInt[(i - 1)];
        i += 1;
      }
    }
  }
  
  public static int[] decodeHaffman(byte[] paramArrayOfByte)
  {
    return decodeHaffman(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static int[] decodeHaffman(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    ByteBuffer localByteBuffer = (ByteBuffer)fourByteBuffer.get();
    Buffer localBuffer = new Buffer();
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      localByteBuffer.put((byte)(paramArrayOfByte[i] & 0x7F));
      if ((i == paramArrayOfByte.length - 1) || ((i < paramArrayOfByte.length - 1) && ((paramArrayOfByte[(i + 1)] & 0xFFFFFF80) == -128)))
      {
        localByteBuffer.flip();
        localBuffer.writeInt(decodeOneInt(localByteBuffer));
        localByteBuffer.clear();
      }
      i += 1;
    }
    paramArrayOfByte = new int[(int)localBuffer.size() / 4];
    paramInt1 = 0;
    while (!localBuffer.exhausted())
    {
      paramArrayOfByte[paramInt1] = localBuffer.readInt();
      paramInt1 += 1;
    }
    return paramArrayOfByte;
  }
  
  public static int[] decodeIndex(byte[] paramArrayOfByte)
  {
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
    paramArrayOfByte = new int[paramArrayOfByte.length / 4];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      paramArrayOfByte[i] = localByteBuffer.getInt();
      i += 1;
    }
    return paramArrayOfByte;
  }
  
  static int decodeOneInt(ByteBuffer paramByteBuffer)
  {
    int i = 0;
    int k = paramByteBuffer.limit();
    int j = 0;
    while (i < k)
    {
      j = (j << 7) + paramByteBuffer.get(i);
      i = (byte)(i + 1);
    }
    return j;
  }
  
  public static int[] decodeRepeat(int[] paramArrayOfInt)
  {
    return decodeRepeat(paramArrayOfInt, 0, paramArrayOfInt.length);
  }
  
  public static int[] decodeRepeat(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 0) {
      return paramArrayOfInt;
    }
    Preconditions.checkElementIndex(paramInt1, paramInt2);
    boolean bool;
    IntBuffer localIntBuffer;
    if (paramInt2 % 2 > 0)
    {
      bool = true;
      Preconditions.checkArgument(bool, "decodeRepeat require odd length");
      localIntBuffer = IntBuffer.allocate(paramArrayOfInt[paramInt1]);
      paramInt1 += 1;
    }
    for (;;)
    {
      if (paramInt1 >= paramInt2) {
        break label88;
      }
      int j = paramArrayOfInt[paramInt1];
      int i = paramArrayOfInt[(paramInt1 + 1)];
      for (;;)
      {
        if (i > 0)
        {
          localIntBuffer.put(j);
          i -= 1;
          continue;
          bool = false;
          break;
        }
      }
      paramInt1 += 2;
    }
    label88:
    return localIntBuffer.array();
  }
  
  public static int[] encodeDelta(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length == 0) {}
    for (;;)
    {
      return paramArrayOfInt;
      int i = paramArrayOfInt.length - 1;
      while (i > 0)
      {
        paramArrayOfInt[i] -= paramArrayOfInt[(i - 1)];
        i -= 1;
      }
    }
  }
  
  public static int encodeHaffman(Buffer paramBuffer1, Buffer paramBuffer2)
  {
    ByteBuffer localByteBuffer = (ByteBuffer)fourByteBuffer.get();
    int i = 0;
    while (!paramBuffer1.exhausted())
    {
      encodeOneInt(paramBuffer1.readInt(), localByteBuffer);
      paramBuffer2.write(localByteBuffer.array(), 0, localByteBuffer.limit());
      i += localByteBuffer.limit();
    }
    paramBuffer2.flush();
    return i;
  }
  
  public static byte[] encodeHaffman(IntBuffer paramIntBuffer)
  {
    return encodeHaffman(paramIntBuffer.array(), paramIntBuffer.position(), paramIntBuffer.limit());
  }
  
  public static byte[] encodeHaffman(int[] paramArrayOfInt)
  {
    return encodeHaffman(paramArrayOfInt, 0, paramArrayOfInt.length);
  }
  
  public static byte[] encodeHaffman(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    Buffer localBuffer = new Buffer();
    ByteBuffer localByteBuffer = (ByteBuffer)fourByteBuffer.get();
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      encodeOneInt(paramArrayOfInt[i], localByteBuffer);
      localBuffer.write(localByteBuffer.array(), 0, localByteBuffer.limit());
      i += 1;
    }
    return localBuffer.readByteArray();
  }
  
  public static byte[] encodeIndex(int[] paramArrayOfInt)
  {
    checkArray(paramArrayOfInt);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramArrayOfInt.length * 4);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localByteBuffer.putInt(paramArrayOfInt[i]);
      i += 1;
    }
    return localByteBuffer.array();
  }
  
  public static void encodeOneInt(int paramInt, ByteBuffer paramByteBuffer)
  {
    if (paramInt < 0) {
      throw new RuntimeException("only nature number is supported, input: " + paramInt);
    }
    paramByteBuffer.clear();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < 8)
    {
      j = i & 0x7F;
      i >>>= 7;
      if (i > 0)
      {
        paramByteBuffer.put((byte)j);
        paramInt += 1;
      }
      else
      {
        paramByteBuffer.put((byte)(j | 0xFFFFFF80));
      }
    }
    paramByteBuffer.flip();
    reverse(paramByteBuffer);
  }
  
  public static int[] encodeRepeat(IntBuffer paramIntBuffer)
  {
    return encodeRepeat(paramIntBuffer.array(), paramIntBuffer.position(), paramIntBuffer.limit());
  }
  
  public static int[] encodeRepeat(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 0) {
      return paramArrayOfInt;
    }
    Buffer localBuffer = new Buffer();
    localBuffer.writeInt(paramInt2);
    int j = paramArrayOfInt[paramInt1];
    int i = paramInt1 + 1;
    int k = 1;
    paramInt1 = j;
    if (i < paramInt2)
    {
      if (paramArrayOfInt[i] == paramInt1)
      {
        k += 1;
        j = paramInt1;
      }
      for (paramInt1 = k;; paramInt1 = 1)
      {
        if (i == paramInt2 - 1)
        {
          localBuffer.writeInt(j);
          localBuffer.writeInt(paramInt1);
        }
        i += 1;
        k = paramInt1;
        paramInt1 = j;
        break;
        localBuffer.writeInt(paramInt1);
        localBuffer.writeInt(k);
        j = paramArrayOfInt[i];
      }
    }
    int[] arrayOfInt = new int[(int)localBuffer.size() / 4];
    paramInt1 = 0;
    for (;;)
    {
      paramArrayOfInt = arrayOfInt;
      if (localBuffer.exhausted()) {
        break;
      }
      arrayOfInt[paramInt1] = localBuffer.readInt();
      paramInt1 += 1;
    }
  }
  
  public static Buffer encodeRepeatToBuffer(Buffer paramBuffer)
  {
    Buffer localBuffer = new Buffer();
    int n = (int)paramBuffer.size() / 4;
    if (n <= 0) {
      return localBuffer;
    }
    localBuffer.writeInt(n);
    int i = paramBuffer.readInt();
    int j = 1;
    int k = 1;
    label43:
    int m;
    if (j < n)
    {
      m = paramBuffer.readInt();
      if (m != i) {
        break label108;
      }
      m = k + 1;
      k = i;
    }
    for (i = m;; i = 1)
    {
      if (j == n - 1)
      {
        localBuffer.writeInt(k);
        localBuffer.writeInt(i);
      }
      j += 1;
      m = i;
      i = k;
      k = m;
      break label43;
      break;
      label108:
      localBuffer.writeInt(i);
      localBuffer.writeInt(k);
      k = m;
    }
  }
  
  private static void reverse(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.position();
    int j = paramByteBuffer.limit() - 1;
    while (j > i)
    {
      byte b = paramByteBuffer.get(j);
      paramByteBuffer.put(j, paramByteBuffer.get(i));
      paramByteBuffer.put(i, b);
      j -= 1;
      i += 1;
    }
  }
  
  public static class InvalidArrayException
    extends RuntimeException
  {
    InvalidArrayException()
    {
      super();
    }
    
    InvalidArrayException(int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.core.utilities.Indexes
 * JD-Core Version:    0.7.0.1
 */