package com.tencent.token.utils.encrypt.random;

import com.tencent.token.abv;
import com.tencent.token.aby;
import com.tencent.token.abz;
import java.util.Random;

public class SecureRandom
  extends Random
{
  private static SecureRandom rand = new SecureRandom(new abv(new abz()));
  protected aby generator;
  
  public SecureRandom()
  {
    super(0L);
    this.generator = new abv(new abz());
    setSeed(System.currentTimeMillis());
  }
  
  private SecureRandom(aby paramaby)
  {
    super(0L);
    this.generator = paramaby;
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    this.generator.a(paramArrayOfByte);
  }
  
  protected final int next(int paramInt)
  {
    int k = (paramInt + 7) / 8;
    byte[] arrayOfByte = new byte[k];
    nextBytes(arrayOfByte);
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j = (j << 8) + (arrayOfByte[i] & 0xFF);
      i += 1;
    }
    return (1 << paramInt) - 1 & j;
  }
  
  public void nextBytes(byte[] paramArrayOfByte)
  {
    this.generator.b(paramArrayOfByte);
  }
  
  public int nextInt()
  {
    byte[] arrayOfByte = new byte[4];
    nextBytes(arrayOfByte);
    int i = 0;
    int j = 0;
    while (i < 4)
    {
      j = (j << 8) + (arrayOfByte[i] & 0xFF);
      i += 1;
    }
    return j;
  }
  
  public void setSeed(long paramLong)
  {
    if (paramLong != 0L) {
      this.generator.a(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.encrypt.random.SecureRandom
 * JD-Core Version:    0.7.0.1
 */