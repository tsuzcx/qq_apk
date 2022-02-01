package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.math.BigInteger;

@GwtIncompatible
final class DoubleUtils
{
  static final int EXPONENT_BIAS = 1023;
  static final long EXPONENT_MASK = 9218868437227405312L;
  static final long IMPLICIT_BIT = 4503599627370496L;
  private static final long ONE_BITS = Double.doubleToRawLongBits(1.0D);
  static final int SIGNIFICAND_BITS = 52;
  static final long SIGNIFICAND_MASK = 4503599627370495L;
  static final long SIGN_MASK = -9223372036854775808L;
  
  static double bigToDouble(BigInteger paramBigInteger)
  {
    int j = 1;
    BigInteger localBigInteger = paramBigInteger.abs();
    int k = localBigInteger.bitLength() - 1;
    if (k < 63) {
      return paramBigInteger.longValue();
    }
    if (k > 1023) {
      return paramBigInteger.signum() * (1.0D / 0.0D);
    }
    int m = k - 52 - 1;
    long l1 = localBigInteger.shiftRight(m).longValue();
    long l2 = l1 >> 1 & 0xFFFFFFFF;
    if ((l1 & 1L) != 0L)
    {
      i = j;
      if ((l2 & 1L) == 0L) {
        if (localBigInteger.getLowestSetBit() >= m) {
          break label147;
        }
      }
    }
    label147:
    for (int i = j;; i = 0)
    {
      l1 = l2;
      if (i != 0) {
        l1 = l2 + 1L;
      }
      return Double.longBitsToDouble(l1 + (k + 1023 << 52) | paramBigInteger.signum() & 0x0);
    }
  }
  
  static double ensureNonNegative(double paramDouble)
  {
    if (!Double.isNaN(paramDouble)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      if (paramDouble <= 0.0D) {
        break;
      }
      return paramDouble;
    }
    return 0.0D;
  }
  
  static long getSignificand(double paramDouble)
  {
    Preconditions.checkArgument(isFinite(paramDouble), "not a normal value");
    int i = Math.getExponent(paramDouble);
    long l = Double.doubleToRawLongBits(paramDouble) & 0xFFFFFFFF;
    if (i == -1023) {
      return l << 1;
    }
    return 0x0 | l;
  }
  
  static boolean isFinite(double paramDouble)
  {
    return Math.getExponent(paramDouble) <= 1023;
  }
  
  static boolean isNormal(double paramDouble)
  {
    return Math.getExponent(paramDouble) >= -1022;
  }
  
  static double nextDown(double paramDouble)
  {
    return -Math.nextUp(-paramDouble);
  }
  
  static double scaleNormalize(double paramDouble)
  {
    return Double.longBitsToDouble(Double.doubleToRawLongBits(paramDouble) & 0xFFFFFFFF | ONE_BITS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.math.DoubleUtils
 * JD-Core Version:    0.7.0.1
 */