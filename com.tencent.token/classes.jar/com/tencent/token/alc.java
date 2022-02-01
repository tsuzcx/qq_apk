package com.tencent.token;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class alc
  implements Serializable, Comparable<alc>
{
  static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  public static final alc b = a(new byte[0]);
  final byte[] c;
  transient int d;
  transient String e;
  
  alc(byte[] paramArrayOfByte)
  {
    this.c = paramArrayOfByte;
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
    throw new IllegalArgumentException("Unexpected hex digit: ".concat(String.valueOf(paramChar)));
  }
  
  public static alc a(String paramString)
  {
    if (paramString != null)
    {
      alc localalc = new alc(paramString.getBytes(alr.a));
      localalc.e = paramString;
      return localalc;
    }
    throw new IllegalArgumentException("s == null");
  }
  
  public static alc a(byte... paramVarArgs)
  {
    if (paramVarArgs != null) {
      return new alc((byte[])paramVarArgs.clone());
    }
    throw new IllegalArgumentException("data == null");
  }
  
  public static alc b(String paramString)
  {
    if (paramString.length() % 2 == 0)
    {
      byte[] arrayOfByte = new byte[paramString.length() / 2];
      int i = 0;
      while (i < arrayOfByte.length)
      {
        int j = i * 2;
        arrayOfByte[i] = ((byte)((a(paramString.charAt(j)) << 4) + a(paramString.charAt(j + 1))));
        i += 1;
      }
      return a(arrayOfByte);
    }
    throw new IllegalArgumentException("Unexpected hex string: ".concat(String.valueOf(paramString)));
  }
  
  private alc c(String paramString)
  {
    try
    {
      paramString = a(MessageDigest.getInstance(paramString).digest(this.c));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new AssertionError(paramString);
    }
  }
  
  public byte a(int paramInt)
  {
    return this.c[paramInt];
  }
  
  public alc a(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      Object localObject = this.c;
      if (paramInt2 <= localObject.length)
      {
        int i = paramInt2 - paramInt1;
        if (i >= 0)
        {
          if ((paramInt1 == 0) && (paramInt2 == localObject.length)) {
            return this;
          }
          localObject = new byte[i];
          System.arraycopy(this.c, paramInt1, localObject, 0, i);
          return new alc((byte[])localObject);
        }
        throw new IllegalArgumentException("endIndex < beginIndex");
      }
      localObject = new StringBuilder("endIndex > length(");
      ((StringBuilder)localObject).append(this.c.length);
      ((StringBuilder)localObject).append(")");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    throw new IllegalArgumentException("beginIndex < 0");
  }
  
  public String a()
  {
    String str = this.e;
    if (str != null) {
      return str;
    }
    str = new String(this.c, alr.a);
    this.e = str;
    return str;
  }
  
  void a(akz paramakz)
  {
    byte[] arrayOfByte = this.c;
    paramakz.b(arrayOfByte, 0, arrayOfByte.length);
  }
  
  public boolean a(int paramInt1, alc paramalc, int paramInt2, int paramInt3)
  {
    return paramalc.a(0, this.c, 0, paramInt3);
  }
  
  public boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    if (paramInt1 >= 0)
    {
      byte[] arrayOfByte = this.c;
      if ((paramInt1 <= arrayOfByte.length - paramInt3) && (paramInt2 >= 0) && (paramInt2 <= paramArrayOfByte.length - paramInt3) && (alr.a(arrayOfByte, paramInt1, paramArrayOfByte, paramInt2, paramInt3))) {
        return true;
      }
    }
    return false;
  }
  
  public String b()
  {
    return aky.a(this.c);
  }
  
  public alc c()
  {
    return c("SHA-1");
  }
  
  public alc d()
  {
    return c("SHA-256");
  }
  
  public String e()
  {
    byte[] arrayOfByte = this.c;
    char[] arrayOfChar1 = new char[arrayOfByte.length * 2];
    int k = arrayOfByte.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = arrayOfByte[i];
      int n = j + 1;
      char[] arrayOfChar2 = a;
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
    if ((paramObject instanceof alc))
    {
      paramObject = (alc)paramObject;
      int i = paramObject.g();
      byte[] arrayOfByte = this.c;
      if ((i == arrayOfByte.length) && (paramObject.a(0, arrayOfByte, 0, arrayOfByte.length))) {
        return true;
      }
    }
    return false;
  }
  
  public alc f()
  {
    int i = 0;
    for (;;)
    {
      byte[] arrayOfByte = this.c;
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
        return new alc(arrayOfByte);
      }
      i += 1;
    }
    return this;
  }
  
  public int g()
  {
    return this.c.length;
  }
  
  public byte[] h()
  {
    return (byte[])this.c.clone();
  }
  
  public int hashCode()
  {
    int i = this.d;
    if (i != 0) {
      return i;
    }
    i = Arrays.hashCode(this.c);
    this.d = i;
    return i;
  }
  
  public String toString()
  {
    if (this.c.length == 0) {
      return "[size=0]";
    }
    Object localObject2 = a();
    int k = ((String)localObject2).length();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      if (j == 64) {
        break label104;
      }
      int m = ((String)localObject2).codePointAt(i);
      if (((Character.isISOControl(m)) && (m != 10) && (m != 13)) || (m == 65533))
      {
        i = -1;
        break label104;
      }
      j += 1;
      i += Character.charCount(m);
    }
    i = ((String)localObject2).length();
    label104:
    if (i == -1)
    {
      if (this.c.length <= 64)
      {
        localObject1 = new StringBuilder("[hex=");
        ((StringBuilder)localObject1).append(e());
        ((StringBuilder)localObject1).append("]");
        return ((StringBuilder)localObject1).toString();
      }
      localObject1 = new StringBuilder("[size=");
      ((StringBuilder)localObject1).append(this.c.length);
      ((StringBuilder)localObject1).append(" hex=");
      ((StringBuilder)localObject1).append(a(0, 64).e());
      ((StringBuilder)localObject1).append("…]");
      return ((StringBuilder)localObject1).toString();
    }
    Object localObject1 = ((String)localObject2).substring(0, i).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
    if (i < ((String)localObject2).length())
    {
      localObject2 = new StringBuilder("[size=");
      ((StringBuilder)localObject2).append(this.c.length);
      ((StringBuilder)localObject2).append(" text=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("…]");
      return ((StringBuilder)localObject2).toString();
    }
    localObject2 = new StringBuilder("[text=");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("]");
    return ((StringBuilder)localObject2).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.alc
 * JD-Core Version:    0.7.0.1
 */