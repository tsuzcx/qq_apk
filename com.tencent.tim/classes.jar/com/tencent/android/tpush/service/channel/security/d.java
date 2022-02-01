package com.tencent.android.tpush.service.channel.security;

public class d
{
  private int[] b = new int[4];
  
  static
  {
    if (!d.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public d(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new RuntimeException("Invalid key: Key was null");
    }
    if (paramArrayOfByte.length < 16) {
      throw new RuntimeException("Invalid key: Length was less than 16 bytes");
    }
    int j = 0;
    while (i < 4)
    {
      int[] arrayOfInt = this.b;
      int m = j + 1;
      int k = paramArrayOfByte[j];
      j = m + 1;
      m = paramArrayOfByte[m];
      int n = j + 1;
      int i1 = paramArrayOfByte[j];
      j = n + 1;
      arrayOfInt[i] = ((paramArrayOfByte[n] & 0xFF) << 24 | (i1 & 0xFF) << 16 | k & 0xFF | (m & 0xFF) << 8);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.channel.security.d
 * JD-Core Version:    0.7.0.1
 */