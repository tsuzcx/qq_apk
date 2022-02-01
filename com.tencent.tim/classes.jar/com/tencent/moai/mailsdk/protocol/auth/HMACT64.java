package com.tencent.moai.mailsdk.protocol.auth;

import java.security.MessageDigest;

public class HMACT64
  extends MessageDigest
  implements Cloneable
{
  private static final int BLOCK_LENGTH = 64;
  private static final byte IPAD = 54;
  private static final byte OPAD = 92;
  private byte[] ipad = new byte[64];
  private MessageDigest md5;
  private byte[] opad = new byte[64];
  
  private HMACT64(HMACT64 paramHMACT64)
    throws CloneNotSupportedException
  {
    super("HMACT64");
    this.ipad = paramHMACT64.ipad;
    this.opad = paramHMACT64.opad;
    this.md5 = ((MessageDigest)paramHMACT64.md5.clone());
  }
  
  public HMACT64(byte[] paramArrayOfByte)
  {
    super("HMACT64");
    int k = Math.min(paramArrayOfByte.length, 64);
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= k) {
        break;
      }
      this.ipad[i] = ((byte)(paramArrayOfByte[i] ^ 0x36));
      this.opad[i] = ((byte)(paramArrayOfByte[i] ^ 0x5C));
      i += 1;
    }
    while (j < 64)
    {
      this.ipad[j] = 54;
      this.opad[j] = 92;
      j += 1;
    }
    try
    {
      this.md5 = MessageDigest.getInstance("MD5");
      engineReset();
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new IllegalStateException(paramArrayOfByte.getMessage());
    }
  }
  
  public Object clone()
  {
    try
    {
      HMACT64 localHMACT64 = new HMACT64(this);
      return localHMACT64;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new IllegalStateException(localCloneNotSupportedException.getMessage());
    }
  }
  
  protected int engineDigest(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = this.md5.digest();
    this.md5.update(this.opad);
    this.md5.update(arrayOfByte);
    try
    {
      paramInt1 = this.md5.digest(paramArrayOfByte, paramInt1, paramInt2);
      return paramInt1;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new IllegalStateException();
    }
  }
  
  protected byte[] engineDigest()
  {
    byte[] arrayOfByte = this.md5.digest();
    this.md5.update(this.opad);
    return this.md5.digest(arrayOfByte);
  }
  
  protected int engineGetDigestLength()
  {
    return this.md5.getDigestLength();
  }
  
  protected void engineReset()
  {
    this.md5.reset();
    this.md5.update(this.ipad);
  }
  
  protected void engineUpdate(byte paramByte)
  {
    this.md5.update(paramByte);
  }
  
  protected void engineUpdate(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.md5.update(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.auth.HMACT64
 * JD-Core Version:    0.7.0.1
 */