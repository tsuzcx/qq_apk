package org.apache.commons.lang3;

import java.util.Random;

public class RandomUtils
{
  private static final Random RANDOM = new Random();
  
  public static byte[] nextBytes(int paramInt)
  {
    if (paramInt >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Validate.isTrue(bool, "Count cannot be negative.", new Object[0]);
      byte[] arrayOfByte = new byte[paramInt];
      RANDOM.nextBytes(arrayOfByte);
      return arrayOfByte;
    }
  }
  
  public static double nextDouble(double paramDouble1, double paramDouble2)
  {
    boolean bool2 = true;
    if (paramDouble2 >= paramDouble1)
    {
      bool1 = true;
      Validate.isTrue(bool1, "Start value must be smaller or equal to end value.", new Object[0]);
      if (paramDouble1 < 0.0D) {
        break label58;
      }
    }
    label58:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Validate.isTrue(bool1, "Both range values must be non-negative.", new Object[0]);
      if (paramDouble1 != paramDouble2) {
        break label64;
      }
      return paramDouble1;
      bool1 = false;
      break;
    }
    label64:
    return paramDouble1 + (paramDouble2 - paramDouble1) * RANDOM.nextDouble();
  }
  
  public static float nextFloat(float paramFloat1, float paramFloat2)
  {
    boolean bool2 = true;
    if (paramFloat2 >= paramFloat1)
    {
      bool1 = true;
      Validate.isTrue(bool1, "Start value must be smaller or equal to end value.", new Object[0]);
      if (paramFloat1 < 0.0F) {
        break label51;
      }
    }
    label51:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Validate.isTrue(bool1, "Both range values must be non-negative.", new Object[0]);
      if (paramFloat1 != paramFloat2) {
        break label56;
      }
      return paramFloat1;
      bool1 = false;
      break;
    }
    label56:
    return paramFloat1 + (paramFloat2 - paramFloat1) * RANDOM.nextFloat();
  }
  
  public static int nextInt(int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    if (paramInt2 >= paramInt1)
    {
      bool1 = true;
      Validate.isTrue(bool1, "Start value must be smaller or equal to end value.", new Object[0]);
      if (paramInt1 < 0) {
        break label47;
      }
    }
    label47:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Validate.isTrue(bool1, "Both range values must be non-negative.", new Object[0]);
      if (paramInt1 != paramInt2) {
        break label52;
      }
      return paramInt1;
      bool1 = false;
      break;
    }
    label52:
    return paramInt1 + RANDOM.nextInt(paramInt2 - paramInt1);
  }
  
  public static long nextLong(long paramLong1, long paramLong2)
  {
    boolean bool2 = true;
    if (paramLong2 >= paramLong1)
    {
      bool1 = true;
      Validate.isTrue(bool1, "Start value must be smaller or equal to end value.", new Object[0]);
      if (paramLong1 < 0L) {
        break label58;
      }
    }
    label58:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Validate.isTrue(bool1, "Both range values must be non-negative.", new Object[0]);
      if (paramLong1 != paramLong2) {
        break label64;
      }
      return paramLong1;
      bool1 = false;
      break;
    }
    label64:
    return nextDouble(paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.RandomUtils
 * JD-Core Version:    0.7.0.1
 */