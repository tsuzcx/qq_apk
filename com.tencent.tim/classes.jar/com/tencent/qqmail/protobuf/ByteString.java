package com.tencent.qqmail.protobuf;

import com.tencent.qqmail.utilities.log.QMLog;
import java.io.UnsupportedEncodingException;

public final class ByteString
{
  private byte[] bytes;
  
  private ByteString() {}
  
  public ByteString(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public ByteString(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.bytes = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, this.bytes, 0, paramInt2);
  }
  
  public static ByteString copyFrom(String paramString1, String paramString2)
    throws UnsupportedEncodingException
  {
    ByteString localByteString = new ByteString();
    localByteString.bytes = paramString1.getBytes(paramString2);
    return localByteString;
  }
  
  public static ByteString copyFrom(byte[] paramArrayOfByte)
  {
    return new ByteString(paramArrayOfByte);
  }
  
  public static ByteString copyFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new ByteString(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static ByteString copyFromUtf8(String paramString)
  {
    try
    {
      paramString = copyFrom(paramString, "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported?", paramString);
    }
  }
  
  public void copyTo(byte[] paramArrayOfByte, int paramInt)
  {
    System.arraycopy(this.bytes, 0, paramArrayOfByte, paramInt, this.bytes.length);
  }
  
  public void copyTo(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    System.arraycopy(this.bytes, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }
  
  public byte[] getBytes()
  {
    return this.bytes;
  }
  
  public ByteString setCLength(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    if (this.bytes.length >= paramInt)
    {
      System.arraycopy(this.bytes, 0, arrayOfByte, 0, paramInt - 1);
      this.bytes = arrayOfByte;
      return this;
    }
    System.arraycopy(this.bytes, 0, arrayOfByte, 0, this.bytes.length);
    this.bytes = arrayOfByte;
    return this;
  }
  
  public int size()
  {
    return this.bytes.length;
  }
  
  public byte[] toByteArray()
  {
    int i = this.bytes.length;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.bytes, 0, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  public String toString()
  {
    try
    {
      String str = toString("UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      QMLog.log(5, getClass().getSimpleName(), "UTF-8 not supported?");
    }
    return super.toString();
  }
  
  public String toString(String paramString)
    throws UnsupportedEncodingException
  {
    return new String(this.bytes, paramString);
  }
  
  /* Error */
  public String toStringUtf8()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iload_1
    //   3: aload_0
    //   4: getfield 17	com/tencent/qqmail/protobuf/ByteString:bytes	[B
    //   7: arraylength
    //   8: if_icmpge +12 -> 20
    //   11: aload_0
    //   12: getfield 17	com/tencent/qqmail/protobuf/ByteString:bytes	[B
    //   15: iload_1
    //   16: baload
    //   17: ifne +21 -> 38
    //   20: new 30	java/lang/String
    //   23: dup
    //   24: aload_0
    //   25: getfield 17	com/tencent/qqmail/protobuf/ByteString:bytes	[B
    //   28: iconst_0
    //   29: iload_1
    //   30: ldc 43
    //   32: invokespecial 90	java/lang/String:<init>	([BIILjava/lang/String;)V
    //   35: astore_2
    //   36: aload_2
    //   37: areturn
    //   38: iload_1
    //   39: iconst_1
    //   40: iadd
    //   41: istore_1
    //   42: goto -40 -> 2
    //   45: astore_2
    //   46: new 47	java/lang/RuntimeException
    //   49: dup
    //   50: ldc 49
    //   52: invokespecial 93	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	ByteString
    //   1	41	1	i	int
    //   35	2	2	str	String
    //   45	1	2	localUnsupportedEncodingException	UnsupportedEncodingException
    // Exception table:
    //   from	to	target	type
    //   2	20	45	java/io/UnsupportedEncodingException
    //   20	36	45	java/io/UnsupportedEncodingException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protobuf.ByteString
 * JD-Core Version:    0.7.0.1
 */