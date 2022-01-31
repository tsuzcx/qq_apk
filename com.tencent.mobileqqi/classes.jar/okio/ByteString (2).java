package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ByteString
  implements Serializable, Comparable<ByteString>
{
  public static final ByteString EMPTY = of(new byte[0]);
  static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final long serialVersionUID = 1L;
  final byte[] data;
  transient int hashCode;
  transient String utf8;
  
  ByteString(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
  }
  
  public static ByteString decodeBase64(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("base64 == null");
    }
    paramString = Base64.decode(paramString);
    if (paramString != null) {
      return new ByteString(paramString);
    }
    return null;
  }
  
  public static ByteString decodeHex(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("hex == null");
    }
    if (paramString.length() % 2 != 0) {
      throw new IllegalArgumentException("Unexpected hex string: " + paramString);
    }
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    for (;;)
    {
      if (i >= arrayOfByte.length) {
        return of(arrayOfByte);
      }
      arrayOfByte[i] = ((byte)((decodeHexDigit(paramString.charAt(i * 2)) << 4) + decodeHexDigit(paramString.charAt(i * 2 + 1))));
      i += 1;
    }
  }
  
  private static int decodeHexDigit(char paramChar)
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
  
  private ByteString digest(String paramString)
  {
    try
    {
      paramString = of(MessageDigest.getInstance(paramString).digest(this.data));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new AssertionError(paramString);
    }
  }
  
  public static ByteString encodeUtf8(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("s == null");
    }
    ByteString localByteString = new ByteString(paramString.getBytes(Util.UTF_8));
    localByteString.utf8 = paramString;
    return localByteString;
  }
  
  public static ByteString of(byte... paramVarArgs)
  {
    if (paramVarArgs == null) {
      throw new IllegalArgumentException("data == null");
    }
    return new ByteString((byte[])paramVarArgs.clone());
  }
  
  public static ByteString of(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("data == null");
    }
    Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return new ByteString(arrayOfByte);
  }
  
  public static ByteString read(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    if (paramInputStream == null) {
      throw new IllegalArgumentException("in == null");
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("byteCount < 0: " + paramInt);
    }
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    for (;;)
    {
      if (i >= paramInt) {
        return new ByteString(arrayOfByte);
      }
      int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
      if (j == -1) {
        throw new EOFException();
      }
      i += j;
    }
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException
  {
    paramObjectInputStream = read(paramObjectInputStream, paramObjectInputStream.readInt());
    try
    {
      Field localField = ByteString.class.getDeclaredField("data");
      localField.setAccessible(true);
      localField.set(this, paramObjectInputStream.data);
      return;
    }
    catch (NoSuchFieldException paramObjectInputStream)
    {
      throw new AssertionError();
    }
    catch (IllegalAccessException paramObjectInputStream)
    {
      throw new AssertionError();
    }
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeInt(this.data.length);
    paramObjectOutputStream.write(this.data);
  }
  
  public String base64()
  {
    return Base64.encode(this.data);
  }
  
  public String base64Url()
  {
    return Base64.encodeUrl(this.data);
  }
  
  public int compareTo(ByteString paramByteString)
  {
    int j = -1;
    int k = size();
    int m = paramByteString.size();
    int i = 0;
    int n = Math.min(k, m);
    if (i >= n)
    {
      if (k != m) {
        break label89;
      }
      i = 0;
    }
    label89:
    do
    {
      int i1;
      int i2;
      do
      {
        return i;
        i1 = getByte(i) & 0xFF;
        i2 = paramByteString.getByte(i) & 0xFF;
        if (i1 == i2)
        {
          i += 1;
          break;
        }
        i = j;
      } while (i1 < i2);
      return 1;
      i = j;
    } while (k < m);
    return 1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    return ((paramObject instanceof ByteString)) && (((ByteString)paramObject).size() == this.data.length) && (((ByteString)paramObject).rangeEquals(0, this.data, 0, this.data.length));
  }
  
  public byte getByte(int paramInt)
  {
    return this.data[paramInt];
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
  
  public String hex()
  {
    char[] arrayOfChar = new char[this.data.length * 2];
    byte[] arrayOfByte = this.data;
    int k = arrayOfByte.length;
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (i >= k) {
        return new String(arrayOfChar);
      }
      int m = arrayOfByte[i];
      int n = j + 1;
      arrayOfChar[j] = HEX_DIGITS[(m >> 4 & 0xF)];
      j = n + 1;
      arrayOfChar[n] = HEX_DIGITS[(m & 0xF)];
      i += 1;
    }
  }
  
  public ByteString md5()
  {
    return digest("MD5");
  }
  
  public boolean rangeEquals(int paramInt1, ByteString paramByteString, int paramInt2, int paramInt3)
  {
    return paramByteString.rangeEquals(paramInt2, this.data, paramInt1, paramInt3);
  }
  
  public boolean rangeEquals(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    return (paramInt1 <= this.data.length - paramInt3) && (paramInt2 <= paramArrayOfByte.length - paramInt3) && (Util.arrayRangeEquals(this.data, paramInt1, paramArrayOfByte, paramInt2, paramInt3));
  }
  
  public ByteString sha256()
  {
    return digest("SHA-256");
  }
  
  public int size()
  {
    return this.data.length;
  }
  
  public ByteString substring(int paramInt)
  {
    return substring(paramInt, this.data.length);
  }
  
  public ByteString substring(int paramInt1, int paramInt2)
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
  
  public ByteString toAsciiLowercase()
  {
    int i = 0;
    for (;;)
    {
      if (i >= this.data.length) {
        return this;
      }
      j = this.data[i];
      if ((j >= 65) && (j <= 90)) {
        break;
      }
      i += 1;
    }
    byte[] arrayOfByte = (byte[])this.data.clone();
    arrayOfByte[i] = ((byte)(j + 32));
    i += 1;
    if (i >= arrayOfByte.length) {
      return new ByteString(arrayOfByte);
    }
    int j = arrayOfByte[i];
    if ((j < 65) || (j > 90)) {}
    for (;;)
    {
      i += 1;
      break;
      arrayOfByte[i] = ((byte)(j + 32));
    }
  }
  
  public ByteString toAsciiUppercase()
  {
    int i = 0;
    for (;;)
    {
      if (i >= this.data.length) {
        return this;
      }
      j = this.data[i];
      if ((j >= 97) && (j <= 122)) {
        break;
      }
      i += 1;
    }
    byte[] arrayOfByte = (byte[])this.data.clone();
    arrayOfByte[i] = ((byte)(j - 32));
    i += 1;
    if (i >= arrayOfByte.length) {
      return new ByteString(arrayOfByte);
    }
    int j = arrayOfByte[i];
    if ((j < 97) || (j > 122)) {}
    for (;;)
    {
      i += 1;
      break;
      arrayOfByte[i] = ((byte)(j - 32));
    }
  }
  
  public byte[] toByteArray()
  {
    return (byte[])this.data.clone();
  }
  
  public String toString()
  {
    if (this.data.length == 0) {
      return "ByteString[size=0]";
    }
    if (this.data.length <= 16) {
      return String.format("ByteString[size=%s data=%s]", new Object[] { Integer.valueOf(this.data.length), hex() });
    }
    return String.format("ByteString[size=%s md5=%s]", new Object[] { Integer.valueOf(this.data.length), md5().hex() });
  }
  
  public String utf8()
  {
    String str = this.utf8;
    if (str != null) {
      return str;
    }
    str = new String(this.data, Util.UTF_8);
    this.utf8 = str;
    return str;
  }
  
  public void write(OutputStream paramOutputStream)
    throws IOException
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("out == null");
    }
    paramOutputStream.write(this.data);
  }
  
  void write(Buffer paramBuffer)
  {
    paramBuffer.write(this.data, 0, this.data.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     okio.ByteString
 * JD-Core Version:    0.7.0.1
 */