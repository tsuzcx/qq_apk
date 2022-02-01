package com.tencent.moai.mailsdk.protocol.auth;

public final class MD4
{
  private static final int S11 = 3;
  private static final int S12 = 7;
  private static final int S13 = 11;
  private static final int S14 = 19;
  private static final int S21 = 3;
  private static final int S22 = 5;
  private static final int S23 = 9;
  private static final int S24 = 13;
  private static final int S31 = 3;
  private static final int S32 = 9;
  private static final int S33 = 11;
  private static final int S34 = 15;
  private static final int blockSize = 64;
  private static final byte[] padding = new byte[''];
  private int bufOfs;
  private final byte[] buffer = new byte[64];
  private long bytesProcessed;
  private final int[] state = new int[4];
  private final int[] x = new int[16];
  
  static
  {
    padding[0] = -128;
  }
  
  public MD4()
  {
    implReset();
  }
  
  private static int FF(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    paramInt1 = (paramInt2 & paramInt3 | (paramInt2 ^ 0xFFFFFFFF) & paramInt4) + paramInt5 + paramInt1;
    return paramInt1 >>> 32 - paramInt6 | paramInt1 << paramInt6;
  }
  
  private static int GG(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    paramInt1 = (paramInt2 & paramInt3 | paramInt2 & paramInt4 | paramInt3 & paramInt4) + paramInt5 + 1518500249 + paramInt1;
    return paramInt1 >>> 32 - paramInt6 | paramInt1 << paramInt6;
  }
  
  private static int HH(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    paramInt1 = (paramInt2 ^ paramInt3 ^ paramInt4) + paramInt5 + 1859775393 + paramInt1;
    return paramInt1 >>> 32 - paramInt6 | paramInt1 << paramInt6;
  }
  
  private void engineUpdate(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {}
    int i;
    int j;
    do
    {
      return;
      if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 > paramArrayOfByte.length - paramInt2)) {
        throw new ArrayIndexOutOfBoundsException();
      }
      if (this.bytesProcessed < 0L) {
        implReset();
      }
      this.bytesProcessed += paramInt2;
      i = paramInt1;
      j = paramInt2;
      if (this.bufOfs != 0)
      {
        i = Math.min(paramInt2, 64 - this.bufOfs);
        System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.bufOfs, i);
        this.bufOfs += i;
        paramInt1 += i;
        paramInt2 -= i;
        i = paramInt1;
        j = paramInt2;
        if (this.bufOfs >= 64)
        {
          implCompress(this.buffer, 0);
          this.bufOfs = 0;
          j = paramInt2;
          i = paramInt1;
        }
      }
      while (j >= 64)
      {
        implCompress(paramArrayOfByte, i);
        j -= 64;
        i += 64;
      }
    } while (j <= 0);
    System.arraycopy(paramArrayOfByte, i, this.buffer, 0, j);
    this.bufOfs = j;
  }
  
  private void implCompress(byte[] paramArrayOfByte, int paramInt)
  {
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < this.x.length)
    {
      this.x[paramInt] = (paramArrayOfByte[i] & 0xFF | (paramArrayOfByte[(i + 1)] & 0xFF) << 8 | (paramArrayOfByte[(i + 2)] & 0xFF) << 16 | (paramArrayOfByte[(i + 3)] & 0xFF) << 24);
      i += 4;
      paramInt += 1;
    }
    i = this.state[0];
    paramInt = this.state[1];
    int k = this.state[2];
    j = this.state[3];
    i = FF(i, paramInt, k, j, this.x[0], 3);
    j = FF(j, i, paramInt, k, this.x[1], 7);
    k = FF(k, j, i, paramInt, this.x[2], 11);
    paramInt = FF(paramInt, k, j, i, this.x[3], 19);
    i = FF(i, paramInt, k, j, this.x[4], 3);
    j = FF(j, i, paramInt, k, this.x[5], 7);
    k = FF(k, j, i, paramInt, this.x[6], 11);
    paramInt = FF(paramInt, k, j, i, this.x[7], 19);
    i = FF(i, paramInt, k, j, this.x[8], 3);
    j = FF(j, i, paramInt, k, this.x[9], 7);
    k = FF(k, j, i, paramInt, this.x[10], 11);
    paramInt = FF(paramInt, k, j, i, this.x[11], 19);
    i = FF(i, paramInt, k, j, this.x[12], 3);
    j = FF(j, i, paramInt, k, this.x[13], 7);
    k = FF(k, j, i, paramInt, this.x[14], 11);
    paramInt = FF(paramInt, k, j, i, this.x[15], 19);
    i = GG(i, paramInt, k, j, this.x[0], 3);
    j = GG(j, i, paramInt, k, this.x[4], 5);
    k = GG(k, j, i, paramInt, this.x[8], 9);
    paramInt = GG(paramInt, k, j, i, this.x[12], 13);
    i = GG(i, paramInt, k, j, this.x[1], 3);
    j = GG(j, i, paramInt, k, this.x[5], 5);
    k = GG(k, j, i, paramInt, this.x[9], 9);
    paramInt = GG(paramInt, k, j, i, this.x[13], 13);
    i = GG(i, paramInt, k, j, this.x[2], 3);
    j = GG(j, i, paramInt, k, this.x[6], 5);
    k = GG(k, j, i, paramInt, this.x[10], 9);
    paramInt = GG(paramInt, k, j, i, this.x[14], 13);
    i = GG(i, paramInt, k, j, this.x[3], 3);
    j = GG(j, i, paramInt, k, this.x[7], 5);
    k = GG(k, j, i, paramInt, this.x[11], 9);
    paramInt = GG(paramInt, k, j, i, this.x[15], 13);
    i = HH(i, paramInt, k, j, this.x[0], 3);
    j = HH(j, i, paramInt, k, this.x[8], 9);
    k = HH(k, j, i, paramInt, this.x[4], 11);
    paramInt = HH(paramInt, k, j, i, this.x[12], 15);
    i = HH(i, paramInt, k, j, this.x[2], 3);
    j = HH(j, i, paramInt, k, this.x[10], 9);
    k = HH(k, j, i, paramInt, this.x[6], 11);
    paramInt = HH(paramInt, k, j, i, this.x[14], 15);
    i = HH(i, paramInt, k, j, this.x[1], 3);
    j = HH(j, i, paramInt, k, this.x[9], 9);
    k = HH(k, j, i, paramInt, this.x[5], 11);
    paramInt = HH(paramInt, k, j, i, this.x[13], 15);
    i = HH(i, paramInt, k, j, this.x[3], 3);
    j = HH(j, i, paramInt, k, this.x[11], 9);
    k = HH(k, j, i, paramInt, this.x[7], 11);
    paramInt = HH(paramInt, k, j, i, this.x[15], 15);
    paramArrayOfByte = this.state;
    paramArrayOfByte[0] += i;
    paramArrayOfByte = this.state;
    paramArrayOfByte[1] = (paramInt + paramArrayOfByte[1]);
    paramArrayOfByte = this.state;
    paramArrayOfByte[2] += k;
    paramArrayOfByte = this.state;
    paramArrayOfByte[3] += j;
  }
  
  private void implDigest(byte[] paramArrayOfByte, int paramInt)
  {
    long l = this.bytesProcessed << 3;
    int i = (int)this.bytesProcessed & 0x3F;
    if (i < 56) {}
    for (i = 56 - i;; i = 120 - i)
    {
      engineUpdate(padding, 0, i);
      this.buffer[56] = ((byte)(int)l);
      this.buffer[57] = ((byte)(int)(l >> 8));
      this.buffer[58] = ((byte)(int)(l >> 16));
      this.buffer[59] = ((byte)(int)(l >> 24));
      this.buffer[60] = ((byte)(int)(l >> 32));
      this.buffer[61] = ((byte)(int)(l >> 40));
      this.buffer[62] = ((byte)(int)(l >> 48));
      this.buffer[63] = ((byte)(int)(l >> 56));
      implCompress(this.buffer, 0);
      int j = 0;
      i = paramInt;
      paramInt = j;
      while (paramInt < this.state.length)
      {
        j = this.state[paramInt];
        int k = i + 1;
        paramArrayOfByte[i] = ((byte)j);
        i = k + 1;
        paramArrayOfByte[k] = ((byte)(j >> 8));
        k = i + 1;
        paramArrayOfByte[i] = ((byte)(j >> 16));
        i = k + 1;
        paramArrayOfByte[k] = ((byte)(j >> 24));
        paramInt += 1;
      }
    }
  }
  
  private void implReset()
  {
    this.state[0] = 1732584193;
    this.state[1] = -271733879;
    this.state[2] = -1732584194;
    this.state[3] = 271733878;
    this.bufOfs = 0;
    this.bytesProcessed = 0L;
  }
  
  public byte[] digest(byte[] paramArrayOfByte)
  {
    implReset();
    engineUpdate(paramArrayOfByte, 0, paramArrayOfByte.length);
    paramArrayOfByte = new byte[16];
    implDigest(paramArrayOfByte, 0);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.auth.MD4
 * JD-Core Version:    0.7.0.1
 */