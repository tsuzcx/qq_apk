package okio;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ByteString
  implements Serializable, Comparable<ByteString>
{
  public static final ByteString EMPTY = a(new byte[0]);
  static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final long serialVersionUID = 1L;
  final byte[] data;
  transient int hashCode;
  transient String utf8;
  
  ByteString(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
  }
  
  private static int a(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return paramChar - '0';
    }
    if ((paramChar >= 'a') && (paramChar <= 'f')) {
      return paramChar - 'a' + 10;
    }
    if ((paramChar >= 'A') && (paramChar <= 'F')) {
      return paramChar - 'A' + 10;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unexpected hex digit: ");
    localStringBuilder.append(paramChar);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  static int a(String paramString, int paramInt)
  {
    int k = paramString.length();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      if (j == paramInt) {
        return i;
      }
      int m = paramString.codePointAt(i);
      if (((Character.isISOControl(m)) && (m != 10) && (m != 13)) || (m == 65533)) {
        return -1;
      }
      j += 1;
      i += Character.charCount(m);
    }
    return paramString.length();
  }
  
  public static ByteString a(String paramString)
  {
    if (paramString != null)
    {
      ByteString localByteString = new ByteString(paramString.getBytes(s.a));
      localByteString.utf8 = paramString;
      return localByteString;
    }
    throw new IllegalArgumentException("s == null");
  }
  
  public static ByteString a(byte... paramVarArgs)
  {
    if (paramVarArgs != null) {
      return new ByteString((byte[])paramVarArgs.clone());
    }
    throw new IllegalArgumentException("data == null");
  }
  
  public static ByteString b(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() % 2 == 0)
      {
        localObject = new byte[paramString.length() / 2];
        int i = 0;
        while (i < localObject.length)
        {
          int j = i * 2;
          localObject[i] = ((byte)((a(paramString.charAt(j)) << 4) + a(paramString.charAt(j + 1))));
          i += 1;
        }
        return a((byte[])localObject);
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unexpected hex string: ");
      ((StringBuilder)localObject).append(paramString);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    throw new IllegalArgumentException("hex == null");
  }
  
  private ByteString c(String paramString)
  {
    try
    {
      paramString = a(MessageDigest.getInstance(paramString).digest(this.data));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new AssertionError(paramString);
    }
  }
  
  public byte a(int paramInt)
  {
    return this.data[paramInt];
  }
  
  public String a()
  {
    String str = this.utf8;
    if (str != null) {
      return str;
    }
    str = new String(this.data, s.a);
    this.utf8 = str;
    return str;
  }
  
  public ByteString a(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      Object localObject = this.data;
      if (paramInt2 <= localObject.length)
      {
        int i = paramInt2 - paramInt1;
        if (i >= 0)
        {
          if ((paramInt1 == 0) && (paramInt2 == localObject.length)) {
            return this;
          }
          localObject = new byte[i];
          System.arraycopy(this.data, paramInt1, localObject, 0, i);
          return new ByteString((byte[])localObject);
        }
        throw new IllegalArgumentException("endIndex < beginIndex");
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("endIndex > length(");
      ((StringBuilder)localObject).append(this.data.length);
      ((StringBuilder)localObject).append(")");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    throw new IllegalArgumentException("beginIndex < 0");
  }
  
  void a(c paramc)
  {
    byte[] arrayOfByte = this.data;
    paramc.b(arrayOfByte, 0, arrayOfByte.length);
  }
  
  public boolean a(int paramInt1, ByteString paramByteString, int paramInt2, int paramInt3)
  {
    return paramByteString.a(paramInt2, this.data, paramInt1, paramInt3);
  }
  
  public boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    if (paramInt1 >= 0)
    {
      byte[] arrayOfByte = this.data;
      if ((paramInt1 <= arrayOfByte.length - paramInt3) && (paramInt2 >= 0) && (paramInt2 <= paramArrayOfByte.length - paramInt3) && (s.a(arrayOfByte, paramInt1, paramArrayOfByte, paramInt2, paramInt3))) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean a(ByteString paramByteString)
  {
    return a(0, paramByteString, 0, paramByteString.g());
  }
  
  public int b(ByteString paramByteString)
  {
    int j = g();
    int k = paramByteString.g();
    int m = Math.min(j, k);
    int i = 0;
    while (i < m)
    {
      int n = a(i) & 0xFF;
      int i1 = paramByteString.a(i) & 0xFF;
      if (n == i1)
      {
        i += 1;
      }
      else
      {
        if (n < i1) {
          return -1;
        }
        return 1;
      }
    }
    if (j == k) {
      return 0;
    }
    if (j < k) {
      return -1;
    }
    return 1;
  }
  
  public String b()
  {
    return b.a(this.data);
  }
  
  public ByteString c()
  {
    return c("SHA-1");
  }
  
  public ByteString d()
  {
    return c("SHA-256");
  }
  
  public String e()
  {
    byte[] arrayOfByte = this.data;
    char[] arrayOfChar1 = new char[arrayOfByte.length * 2];
    int k = arrayOfByte.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = arrayOfByte[i];
      int n = j + 1;
      char[] arrayOfChar2 = HEX_DIGITS;
      arrayOfChar1[j] = arrayOfChar2[(m >> 4 & 0xF)];
      j = n + 1;
      arrayOfChar1[n] = arrayOfChar2[(m & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar1);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof ByteString))
    {
      paramObject = (ByteString)paramObject;
      int i = paramObject.g();
      byte[] arrayOfByte = this.data;
      if ((i == arrayOfByte.length) && (paramObject.a(0, arrayOfByte, 0, arrayOfByte.length))) {
        return true;
      }
    }
    return false;
  }
  
  public ByteString f()
  {
    int i = 0;
    for (;;)
    {
      byte[] arrayOfByte = this.data;
      if (i >= arrayOfByte.length) {
        break;
      }
      int k = arrayOfByte[i];
      if ((k >= 65) && (k <= 90))
      {
        arrayOfByte = (byte[])arrayOfByte.clone();
        int j = i + 1;
        arrayOfByte[i] = ((byte)(k + 32));
        i = j;
        while (i < arrayOfByte.length)
        {
          j = arrayOfByte[i];
          if ((j >= 65) && (j <= 90)) {
            arrayOfByte[i] = ((byte)(j + 32));
          }
          i += 1;
        }
        return new ByteString(arrayOfByte);
      }
      i += 1;
    }
    return this;
  }
  
  public int g()
  {
    return this.data.length;
  }
  
  public byte[] h()
  {
    return (byte[])this.data.clone();
  }
  
  public int hashCode()
  {
    int i = this.hashCode;
    if (i != 0) {
      return i;
    }
    i = Arrays.hashCode(this.data);
    this.hashCode = i;
    return i;
  }
  
  public String toString()
  {
    if (this.data.length == 0) {
      return "[size=0]";
    }
    Object localObject2 = a();
    int i = a((String)localObject2, 64);
    if (i == -1)
    {
      if (this.data.length <= 64)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[hex=");
        ((StringBuilder)localObject1).append(e());
        ((StringBuilder)localObject1).append("]");
        return ((StringBuilder)localObject1).toString();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[size=");
      ((StringBuilder)localObject1).append(this.data.length);
      ((StringBuilder)localObject1).append(" hex=");
      ((StringBuilder)localObject1).append(a(0, 64).e());
      ((StringBuilder)localObject1).append("…]");
      return ((StringBuilder)localObject1).toString();
    }
    Object localObject1 = ((String)localObject2).substring(0, i).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
    if (i < ((String)localObject2).length())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[size=");
      ((StringBuilder)localObject2).append(this.data.length);
      ((StringBuilder)localObject2).append(" text=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("…]");
      return ((StringBuilder)localObject2).toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[text=");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("]");
    return ((StringBuilder)localObject2).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.ByteString
 * JD-Core Version:    0.7.0.1
 */