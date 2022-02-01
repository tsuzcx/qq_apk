package com.google.common.hash;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

final class FarmHashFingerprint64
  extends AbstractNonStreamingHashFunction
{
  private static final long K0 = -4348849565147123417L;
  private static final long K1 = -5435081209227447693L;
  private static final long K2 = -7286425919675154353L;
  
  @VisibleForTesting
  static long fingerprint(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 32)
    {
      if (paramInt2 <= 16) {
        return hashLength0to16(paramArrayOfByte, paramInt1, paramInt2);
      }
      return hashLength17to32(paramArrayOfByte, paramInt1, paramInt2);
    }
    if (paramInt2 <= 64) {
      return hashLength33To64(paramArrayOfByte, paramInt1, paramInt2);
    }
    return hashLength65Plus(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private static long hashLength0to16(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l1 = -7286425919675154353L;
    if (paramInt2 >= 8)
    {
      l1 = -7286425919675154353L + paramInt2 * 2;
      long l2 = LittleEndianByteArray.load64(paramArrayOfByte, paramInt1) - 7286425919675154353L;
      long l3 = LittleEndianByteArray.load64(paramArrayOfByte, paramInt1 + paramInt2 - 8);
      l1 = hashLength16(Long.rotateRight(l3, 37) * l1 + l2, (Long.rotateRight(l2, 25) + l3) * l1, l1);
    }
    do
    {
      return l1;
      if (paramInt2 >= 4)
      {
        l1 = paramInt2 * 2;
        return hashLength16(((LittleEndianByteArray.load32(paramArrayOfByte, paramInt1) & 0xFFFFFFFF) << 3) + paramInt2, LittleEndianByteArray.load32(paramArrayOfByte, paramInt1 + paramInt2 - 4) & 0xFFFFFFFF, -7286425919675154353L + l1);
      }
    } while (paramInt2 <= 0);
    int i = paramArrayOfByte[paramInt1];
    int j = paramArrayOfByte[((paramInt2 >> 1) + paramInt1)];
    paramInt1 = paramArrayOfByte[(paramInt2 - 1 + paramInt1)];
    l1 = (i & 0xFF) + ((j & 0xFF) << 8);
    return -7286425919675154353L * shiftMix((((paramInt1 & 0xFF) << 2) + paramInt2) * -4348849565147123417L ^ l1 * -7286425919675154353L);
  }
  
  private static long hashLength16(long paramLong1, long paramLong2, long paramLong3)
  {
    paramLong1 = (paramLong1 ^ paramLong2) * paramLong3;
    paramLong1 = (paramLong1 ^ paramLong1 >>> 47 ^ paramLong2) * paramLong3;
    return (paramLong1 ^ paramLong1 >>> 47) * paramLong3;
  }
  
  private static long hashLength17to32(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l1 = -7286425919675154353L + paramInt2 * 2;
    long l2 = -5435081209227447693L * LittleEndianByteArray.load64(paramArrayOfByte, paramInt1);
    long l3 = LittleEndianByteArray.load64(paramArrayOfByte, paramInt1 + 8);
    long l4 = LittleEndianByteArray.load64(paramArrayOfByte, paramInt1 + paramInt2 - 8) * l1;
    return hashLength16(LittleEndianByteArray.load64(paramArrayOfByte, paramInt1 + paramInt2 - 16) * -7286425919675154353L + (Long.rotateRight(l2 + l3, 43) + Long.rotateRight(l4, 30)), l2 + Long.rotateRight(l3 - 7286425919675154353L, 18) + l4, l1);
  }
  
  private static long hashLength33To64(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l1 = -7286425919675154353L + paramInt2 * 2;
    long l2 = LittleEndianByteArray.load64(paramArrayOfByte, paramInt1) * -7286425919675154353L;
    long l4 = LittleEndianByteArray.load64(paramArrayOfByte, paramInt1 + 8);
    long l5 = LittleEndianByteArray.load64(paramArrayOfByte, paramInt1 + paramInt2 - 8) * l1;
    long l3 = LittleEndianByteArray.load64(paramArrayOfByte, paramInt1 + paramInt2 - 16) * -7286425919675154353L + (Long.rotateRight(l2 + l4, 43) + Long.rotateRight(l5, 30));
    l4 = hashLength16(l3, Long.rotateRight(l4 - 7286425919675154353L, 18) + l2 + l5, l1);
    l5 = LittleEndianByteArray.load64(paramArrayOfByte, paramInt1 + 16) * l1;
    long l6 = LittleEndianByteArray.load64(paramArrayOfByte, paramInt1 + 24);
    l3 = (l3 + LittleEndianByteArray.load64(paramArrayOfByte, paramInt1 + paramInt2 - 32)) * l1;
    return hashLength16((LittleEndianByteArray.load64(paramArrayOfByte, paramInt1 + paramInt2 - 24) + l4) * l1 + (Long.rotateRight(l5 + l6, 43) + Long.rotateRight(l3, 30)), Long.rotateRight(l6 + l2, 18) + l5 + l3, l1);
  }
  
  private static long hashLength65Plus(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l1 = shiftMix(-7286425919675154353L * 2480279821605975764L + 113L);
    long[] arrayOfLong1 = new long[2];
    long[] arrayOfLong2 = new long[2];
    long l2 = LittleEndianByteArray.load64(paramArrayOfByte, paramInt1);
    int i = (paramInt2 - 1) / 64 * 64 + paramInt1;
    int j = (paramInt2 - 1 & 0x3F) + i - 63;
    long l3 = 81L * -7286425919675154353L + l2;
    l2 = 2480279821605975764L;
    l1 *= -7286425919675154353L;
    for (;;)
    {
      l3 = Long.rotateRight(l3 + l2 + arrayOfLong1[0] + LittleEndianByteArray.load64(paramArrayOfByte, paramInt1 + 8), 37);
      long l4 = Long.rotateRight(l2 + arrayOfLong1[1] + LittleEndianByteArray.load64(paramArrayOfByte, paramInt1 + 48), 42);
      l2 = l3 * -5435081209227447693L ^ arrayOfLong2[1];
      l3 = l4 * -5435081209227447693L + (arrayOfLong1[0] + LittleEndianByteArray.load64(paramArrayOfByte, paramInt1 + 40));
      l4 = Long.rotateRight(l1 + arrayOfLong2[0], 33) * -5435081209227447693L;
      weakHashLength32WithSeeds(paramArrayOfByte, paramInt1, arrayOfLong1[1] * -5435081209227447693L, arrayOfLong2[0] + l2, arrayOfLong1);
      weakHashLength32WithSeeds(paramArrayOfByte, paramInt1 + 32, l4 + arrayOfLong2[1], l3 + LittleEndianByteArray.load64(paramArrayOfByte, paramInt1 + 16), arrayOfLong2);
      paramInt1 += 64;
      if (paramInt1 == i)
      {
        l1 = -5435081209227447693L + ((0xFF & l2) << 1);
        arrayOfLong2[0] += (paramInt2 - 1 & 0x3F);
        arrayOfLong1[0] += arrayOfLong2[0];
        arrayOfLong2[0] += arrayOfLong1[0];
        l4 = Long.rotateRight(l4 + l3 + arrayOfLong1[0] + LittleEndianByteArray.load64(paramArrayOfByte, j + 8), 37);
        long l5 = Long.rotateRight(arrayOfLong1[1] + l3 + LittleEndianByteArray.load64(paramArrayOfByte, j + 48), 42);
        l3 = l4 * l1 ^ arrayOfLong2[1] * 9L;
        l4 = l5 * l1 + (arrayOfLong1[0] * 9L + LittleEndianByteArray.load64(paramArrayOfByte, j + 40));
        l2 = Long.rotateRight(arrayOfLong2[0] + l2, 33) * l1;
        weakHashLength32WithSeeds(paramArrayOfByte, j, arrayOfLong1[1] * l1, l3 + arrayOfLong2[0], arrayOfLong1);
        weakHashLength32WithSeeds(paramArrayOfByte, j + 32, l2 + arrayOfLong2[1], l4 + LittleEndianByteArray.load64(paramArrayOfByte, j + 16), arrayOfLong2);
        return hashLength16(hashLength16(arrayOfLong1[0], arrayOfLong2[0], l1) + shiftMix(l4) * -4348849565147123417L + l3, hashLength16(arrayOfLong1[1], arrayOfLong2[1], l1) + l2, l1);
      }
      l1 = l2;
      l2 = l3;
      l3 = l4;
    }
  }
  
  private static long shiftMix(long paramLong)
  {
    return paramLong >>> 47 ^ paramLong;
  }
  
  private static void weakHashLength32WithSeeds(byte[] paramArrayOfByte, int paramInt, long paramLong1, long paramLong2, long[] paramArrayOfLong)
  {
    long l4 = LittleEndianByteArray.load64(paramArrayOfByte, paramInt);
    long l2 = LittleEndianByteArray.load64(paramArrayOfByte, paramInt + 8);
    long l3 = LittleEndianByteArray.load64(paramArrayOfByte, paramInt + 16);
    long l1 = LittleEndianByteArray.load64(paramArrayOfByte, paramInt + 24);
    paramLong1 = l4 + paramLong1;
    paramLong2 = Long.rotateRight(paramLong2 + paramLong1 + l1, 21);
    l2 = l2 + paramLong1 + l3;
    l3 = Long.rotateRight(l2, 44);
    paramArrayOfLong[0] = (l2 + l1);
    paramArrayOfLong[1] = (paramLong1 + (l3 + paramLong2));
  }
  
  public int bits()
  {
    return 64;
  }
  
  public HashCode hashBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Preconditions.checkPositionIndexes(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
    return HashCode.fromLong(fingerprint(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public String toString()
  {
    return "Hashing.farmHashFingerprint64()";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.hash.FarmHashFingerprint64
 * JD-Core Version:    0.7.0.1
 */