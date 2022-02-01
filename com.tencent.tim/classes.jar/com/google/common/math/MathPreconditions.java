package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import javax.annotation.Nullable;

@GwtCompatible
@CanIgnoreReturnValue
final class MathPreconditions
{
  static void checkInRange(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new ArithmeticException("not in range");
    }
  }
  
  static void checkNoOverflow(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new ArithmeticException("overflow");
    }
  }
  
  static double checkNonNegative(@Nullable String paramString, double paramDouble)
  {
    if (paramDouble < 0.0D) {
      throw new IllegalArgumentException(paramString + " (" + paramDouble + ") must be >= 0");
    }
    return paramDouble;
  }
  
  static int checkNonNegative(@Nullable String paramString, int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException(paramString + " (" + paramInt + ") must be >= 0");
    }
    return paramInt;
  }
  
  static long checkNonNegative(@Nullable String paramString, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException(paramString + " (" + paramLong + ") must be >= 0");
    }
    return paramLong;
  }
  
  static BigInteger checkNonNegative(@Nullable String paramString, BigInteger paramBigInteger)
  {
    if (paramBigInteger.signum() < 0) {
      throw new IllegalArgumentException(paramString + " (" + paramBigInteger + ") must be >= 0");
    }
    return paramBigInteger;
  }
  
  static int checkPositive(@Nullable String paramString, int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException(paramString + " (" + paramInt + ") must be > 0");
    }
    return paramInt;
  }
  
  static long checkPositive(@Nullable String paramString, long paramLong)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException(paramString + " (" + paramLong + ") must be > 0");
    }
    return paramLong;
  }
  
  static BigInteger checkPositive(@Nullable String paramString, BigInteger paramBigInteger)
  {
    if (paramBigInteger.signum() <= 0) {
      throw new IllegalArgumentException(paramString + " (" + paramBigInteger + ") must be > 0");
    }
    return paramBigInteger;
  }
  
  static void checkRoundingUnnecessary(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.math.MathPreconditions
 * JD-Core Version:    0.7.0.1
 */