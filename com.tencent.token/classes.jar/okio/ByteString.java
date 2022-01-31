package okio;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ByteString
  implements Serializable, Comparable
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
    throw new IllegalArgumentException("Unexpected hex digit: " + paramChar);
  }
  
  static int a(String paramString, int paramInt)
  {
    int i = 0;
    int k = paramString.length();
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
    if (paramString == null) {
      throw new IllegalArgumentException("s == null");
    }
    ByteString localByteString = new ByteString(paramString.getBytes(ab.a));
    localByteString.utf8 = paramString;
    return localByteString;
  }
  
  public static ByteString a(byte... paramVarArgs)
  {
    if (paramVarArgs == null) {
      throw new IllegalArgumentException("data == null");
    }
    return new ByteString((byte[])paramVarArgs.clone());
  }
  
  public static ByteString b(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("hex == null");
    }
    if (paramString.length() % 2 != 0) {
      throw new IllegalArgumentException("Unexpected hex string: " + paramString);
    }
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)((a(paramString.charAt(i * 2)) << 4) + a(paramString.charAt(i * 2 + 1))));
      i += 1;
    }
    return a(arrayOfByte);
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
    str = new String(this.data, ab.a);
    this.utf8 = str;
    return str;
  }
  
  public ByteString a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("beginIndex < 0");
    }
    if (paramInt2 > this.data.length) {
      throw new IllegalArgumentException("endIndex > length(" + this.data.length + ")");
    }
    int i = paramInt2 - paramInt1;
    if (i < 0) {
      throw new IllegalArgumentException("endIndex < beginIndex");
    }
    if ((paramInt1 == 0) && (paramInt2 == this.data.length)) {
      return this;
    }
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.data, paramInt1, arrayOfByte, 0, i);
    return new ByteString(arrayOfByte);
  }
  
  void a(f paramf)
  {
    paramf.b(this.data, 0, this.data.length);
  }
  
  public boolean a(int paramInt1, ByteString paramByteString, int paramInt2, int paramInt3)
  {
    return paramByteString.a(paramInt2, this.data, paramInt1, paramInt3);
  }
  
  public boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    return (paramInt1 >= 0) && (paramInt1 <= this.data.length - paramInt3) && (paramInt2 >= 0) && (paramInt2 <= paramArrayOfByte.length - paramInt3) && (ab.a(this.data, paramInt1, paramArrayOfByte, paramInt2, paramInt3));
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
    for (;;)
    {
      if (i < m)
      {
        int n = a(i) & 0xFF;
        int i1 = paramByteString.a(i) & 0xFF;
        if (n == i1) {
          i += 1;
        } else {
          if (n >= i1) {
            break;
          }
        }
      }
    }
    do
    {
      return -1;
      return 1;
      if (j == k) {
        return 0;
      }
    } while (j < k);
    return 1;
  }
  
  public String b()
  {
    return e.a(this.data);
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
    int i = 0;
    char[] arrayOfChar = new char[this.data.length * 2];
    byte[] arrayOfByte = this.data;
    int k = arrayOfByte.length;
    int j = 0;
    while (i < k)
    {
      int m = arrayOfByte[i];
      int n = j + 1;
      arrayOfChar[j] = HEX_DIGITS[(m >> 4 & 0xF)];
      j = n + 1;
      arrayOfChar[n] = HEX_DIGITS[(m & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (((paramObject instanceof ByteString)) && (((ByteString)paramObject).g() == this.data.length) && (((ByteString)paramObject).a(0, this.data, 0, this.data.length))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public ByteString f()
  {
    int i = 0;
    int j;
    for (;;)
    {
      localObject = this;
      if (i >= this.data.length) {
        return localObject;
      }
      j = this.data[i];
      if ((j >= 65) && (j <= 90)) {
        break;
      }
      i += 1;
    }
    Object localObject = (byte[])this.data.clone();
    localObject[i] = ((byte)(j + 32));
    i += 1;
    if (i < localObject.length)
    {
      j = localObject[i];
      if ((j < 65) || (j > 90)) {}
      for (;;)
      {
        i += 1;
        break;
        localObject[i] = ((byte)(j + 32));
      }
    }
    localObject = new ByteString((byte[])localObject);
    return localObject;
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
    String str1 = a();
    int i = a(str1, 64);
    if (i == -1)
    {
      if (this.data.length <= 64) {
        return "[hex=" + e() + "]";
      }
      return "[size=" + this.data.length + " hex=" + a(0, 64).e() + "…]";
    }
    String str2 = str1.substring(0, i).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
    if (i < str1.length()) {
      return "[size=" + this.data.length + " text=" + str2 + "…]";
    }
    return "[text=" + str2 + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.ByteString
 * JD-Core Version:    0.7.0.1
 */