package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;

@GwtCompatible(emulated=true)
public final class IntMath
{
  @VisibleForTesting
  static final int FLOOR_SQRT_MAX_INT = 46340;
  @VisibleForTesting
  static final int MAX_POWER_OF_SQRT2_UNSIGNED = -1257966797;
  @VisibleForTesting
  static final int MAX_SIGNED_POWER_OF_TWO = 1073741824;
  @VisibleForTesting
  static int[] biggestBinomials = { 2147483647, 2147483647, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33 };
  private static final int[] factorials;
  @VisibleForTesting
  static final int[] halfPowersOf10;
  @VisibleForTesting
  static final byte[] maxLog10ForLeadingZeros = { 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0 };
  @VisibleForTesting
  static final int[] powersOf10 = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000 };
  
  static
  {
    halfPowersOf10 = new int[] { 3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 2147483647 };
    factorials = new int[] { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600 };
  }
  
  @GwtIncompatible
  public static int binomial(int paramInt1, int paramInt2)
  {
    int k = 1;
    int j = 0;
    MathPreconditions.checkNonNegative("n", paramInt1);
    MathPreconditions.checkNonNegative("k", paramInt2);
    if (paramInt2 <= paramInt1) {}
    int i;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "k (%s) > n (%s)", paramInt2, paramInt1);
      i = paramInt2;
      if (paramInt2 > paramInt1 >> 1) {
        i = paramInt1 - paramInt2;
      }
      if ((i < biggestBinomials.length) && (paramInt1 <= biggestBinomials[i])) {
        break;
      }
      paramInt2 = 2147483647;
      return paramInt2;
    }
    paramInt2 = k;
    long l;
    switch (i)
    {
    case 0: 
    default: 
      l = 1L;
      paramInt2 = j;
    }
    while (paramInt2 < i)
    {
      l = l * (paramInt1 - paramInt2) / (paramInt2 + 1);
      paramInt2 += 1;
      continue;
      return paramInt1;
    }
    return (int)l;
  }
  
  @Beta
  public static int ceilingPowerOfTwo(int paramInt)
  {
    MathPreconditions.checkPositive("x", paramInt);
    if (paramInt > 1073741824) {
      throw new ArithmeticException("ceilingPowerOfTwo(" + paramInt + ") not representable as an int");
    }
    return 1 << -Integer.numberOfLeadingZeros(paramInt - 1);
  }
  
  public static int checkedAdd(int paramInt1, int paramInt2)
  {
    long l = paramInt1;
    l = paramInt2 + l;
    if (l == (int)l) {}
    for (boolean bool = true;; bool = false)
    {
      MathPreconditions.checkNoOverflow(bool);
      return (int)l;
    }
  }
  
  public static int checkedMultiply(int paramInt1, int paramInt2)
  {
    long l = paramInt1;
    l = paramInt2 * l;
    if (l == (int)l) {}
    for (boolean bool = true;; bool = false)
    {
      MathPreconditions.checkNoOverflow(bool);
      return (int)l;
    }
  }
  
  public static int checkedPow(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    MathPreconditions.checkNonNegative("exponent", paramInt2);
    int j;
    int i;
    switch (paramInt1)
    {
    default: 
      j = 1;
      i = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = j;
      switch (i)
      {
      default: 
        if ((i & 0x1) != 0) {
          paramInt1 = checkedMultiply(paramInt1, paramInt2);
        }
        break;
      }
      break;
    }
    for (;;)
    {
      int k = i >> 1;
      if (k > 0)
      {
        if (-46340 <= paramInt2)
        {
          i = 1;
          label110:
          if (paramInt2 > 46340) {
            break label213;
          }
        }
        label213:
        for (j = 1;; j = 0)
        {
          MathPreconditions.checkNoOverflow(j & i);
          paramInt2 *= paramInt2;
          i = k;
          break;
          if (paramInt2 == 0) {}
          do
          {
            return 1;
            return 0;
          } while ((paramInt2 & 0x1) == 0);
          return -1;
          if (paramInt2 < 31) {
            bool1 = true;
          }
          MathPreconditions.checkNoOverflow(bool1);
          return 1 << paramInt2;
          bool1 = bool2;
          if (paramInt2 < 32) {
            bool1 = true;
          }
          MathPreconditions.checkNoOverflow(bool1);
          if ((paramInt2 & 0x1) == 0) {
            return 1 << paramInt2;
          }
          return -1 << paramInt2;
          return paramInt1;
          return checkedMultiply(paramInt1, paramInt2);
          i = 0;
          break label110;
        }
      }
      i = k;
      break;
    }
  }
  
  public static int checkedSubtract(int paramInt1, int paramInt2)
  {
    long l = paramInt1 - paramInt2;
    if (l == (int)l) {}
    for (boolean bool = true;; bool = false)
    {
      MathPreconditions.checkNoOverflow(bool);
      return (int)l;
    }
  }
  
  public static int divide(int paramInt1, int paramInt2, RoundingMode paramRoundingMode)
  {
    int i = 1;
    boolean bool = true;
    int k = 0;
    Preconditions.checkNotNull(paramRoundingMode);
    if (paramInt2 == 0) {
      throw new ArithmeticException("/ by zero");
    }
    int j = paramInt1 / paramInt2;
    int n = paramInt1 - paramInt2 * j;
    if (n == 0) {
      return j;
    }
    int m = (paramInt1 ^ paramInt2) >> 31 | 0x1;
    paramInt1 = i;
    switch (1.$SwitchMap$java$math$RoundingMode[paramRoundingMode.ordinal()])
    {
    default: 
      throw new AssertionError();
    case 1: 
      if (n == 0) {
        MathPreconditions.checkRoundingUnnecessary(bool);
      }
      break;
    case 2: 
      paramInt1 = 0;
    case 4: 
      label136:
      if (paramInt1 == 0) {}
      break;
    }
    for (paramInt1 = j + m;; paramInt1 = j)
    {
      return paramInt1;
      bool = false;
      break;
      paramInt1 = i;
      if (m > 0) {
        break label136;
      }
      paramInt1 = 0;
      break label136;
      paramInt1 = i;
      if (m < 0) {
        break label136;
      }
      paramInt1 = 0;
      break label136;
      paramInt1 = Math.abs(n);
      paramInt2 = paramInt1 - (Math.abs(paramInt2) - paramInt1);
      if (paramInt2 == 0)
      {
        if (paramRoundingMode != RoundingMode.HALF_UP)
        {
          if (paramRoundingMode != RoundingMode.HALF_EVEN) {
            break label236;
          }
          paramInt2 = 1;
          label213:
          if ((j & 0x1) == 0) {
            break label241;
          }
        }
        label236:
        label241:
        for (i = 1;; i = 0)
        {
          paramInt1 = k;
          if ((i & paramInt2) != 0) {
            paramInt1 = 1;
          }
          break;
          paramInt2 = 0;
          break label213;
        }
      }
      paramInt1 = i;
      if (paramInt2 > 0) {
        break label136;
      }
      paramInt1 = 0;
      break label136;
    }
  }
  
  public static int factorial(int paramInt)
  {
    MathPreconditions.checkNonNegative("n", paramInt);
    if (paramInt < factorials.length) {
      return factorials[paramInt];
    }
    return 2147483647;
  }
  
  @Beta
  public static int floorPowerOfTwo(int paramInt)
  {
    MathPreconditions.checkPositive("x", paramInt);
    return Integer.highestOneBit(paramInt);
  }
  
  public static int gcd(int paramInt1, int paramInt2)
  {
    MathPreconditions.checkNonNegative("a", paramInt1);
    MathPreconditions.checkNonNegative("b", paramInt2);
    if (paramInt1 == 0) {
      return paramInt2;
    }
    if (paramInt2 == 0) {
      return paramInt1;
    }
    int j = Integer.numberOfTrailingZeros(paramInt1);
    paramInt1 >>= j;
    int k = Integer.numberOfTrailingZeros(paramInt2);
    int i = paramInt2 >> k;
    paramInt2 = paramInt1;
    paramInt1 = i;
    while (paramInt2 != paramInt1)
    {
      i = paramInt2 - paramInt1;
      paramInt2 = i >> 31 & i;
      i = i - paramInt2 - paramInt2;
      paramInt1 += paramInt2;
      paramInt2 = i >> Integer.numberOfTrailingZeros(i);
    }
    return paramInt2 << Math.min(j, k);
  }
  
  public static boolean isPowerOfTwo(int paramInt)
  {
    int j = 1;
    int i;
    if (paramInt > 0)
    {
      i = 1;
      if ((paramInt - 1 & paramInt) != 0) {
        break label27;
      }
    }
    label27:
    for (paramInt = j;; paramInt = 0)
    {
      return paramInt & i;
      i = 0;
      break;
    }
  }
  
  @Beta
  @GwtIncompatible
  public static boolean isPrime(int paramInt)
  {
    return LongMath.isPrime(paramInt);
  }
  
  @VisibleForTesting
  static int lessThanBranchFree(int paramInt1, int paramInt2)
  {
    return (paramInt1 - paramInt2 ^ 0xFFFFFFFF ^ 0xFFFFFFFF) >>> 31;
  }
  
  @GwtIncompatible
  public static int log10(int paramInt, RoundingMode paramRoundingMode)
  {
    MathPreconditions.checkPositive("x", paramInt);
    int i = log10Floor(paramInt);
    int j = powersOf10[i];
    switch (1.$SwitchMap$java$math$RoundingMode[paramRoundingMode.ordinal()])
    {
    default: 
      throw new AssertionError();
    case 1: 
      if (paramInt != j) {
        break;
      }
    case 2: 
    case 3: 
      for (boolean bool = true;; bool = false)
      {
        MathPreconditions.checkRoundingUnnecessary(bool);
        return i;
      }
    case 4: 
    case 5: 
      return lessThanBranchFree(j, paramInt) + i;
    }
    return lessThanBranchFree(halfPowersOf10[i], paramInt) + i;
  }
  
  private static int log10Floor(int paramInt)
  {
    int i = maxLog10ForLeadingZeros[Integer.numberOfLeadingZeros(paramInt)];
    return i - lessThanBranchFree(paramInt, powersOf10[i]);
  }
  
  public static int log2(int paramInt, RoundingMode paramRoundingMode)
  {
    MathPreconditions.checkPositive("x", paramInt);
    switch (1.$SwitchMap$java$math$RoundingMode[paramRoundingMode.ordinal()])
    {
    default: 
      throw new AssertionError();
    case 1: 
      MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(paramInt));
    case 2: 
    case 3: 
      return 31 - Integer.numberOfLeadingZeros(paramInt);
    case 4: 
    case 5: 
      return 32 - Integer.numberOfLeadingZeros(paramInt - 1);
    }
    int i = Integer.numberOfLeadingZeros(paramInt);
    return 31 - i + lessThanBranchFree(-1257966797 >>> i, paramInt);
  }
  
  public static int mean(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) + ((paramInt1 ^ paramInt2) >> 1);
  }
  
  public static int mod(int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 0) {
      throw new ArithmeticException("Modulus " + paramInt2 + " must be > 0");
    }
    paramInt1 %= paramInt2;
    if (paramInt1 >= 0) {
      return paramInt1;
    }
    return paramInt1 + paramInt2;
  }
  
  @GwtIncompatible
  public static int pow(int paramInt1, int paramInt2)
  {
    int i = 0;
    MathPreconditions.checkNonNegative("exponent", paramInt2);
    switch (paramInt1)
    {
    default: 
      i = 1;
      switch (paramInt2)
      {
      default: 
        if ((paramInt2 & 0x1) != 0) {}
        break;
      }
      break;
    }
    for (int j = 1;; j = paramInt1)
    {
      i *= j;
      paramInt1 *= paramInt1;
      paramInt2 >>= 1;
      break;
      if (paramInt2 == 0) {}
      do
      {
        return 1;
        return 0;
      } while ((paramInt2 & 0x1) == 0);
      return -1;
      paramInt1 = i;
      if (paramInt2 < 32) {
        paramInt1 = 1 << paramInt2;
      }
      return paramInt1;
      if (paramInt2 < 32)
      {
        if ((paramInt2 & 0x1) == 0) {
          return 1 << paramInt2;
        }
        return -(1 << paramInt2);
      }
      return 0;
      return i;
      return paramInt1 * i;
    }
  }
  
  @Beta
  public static int saturatedAdd(int paramInt1, int paramInt2)
  {
    return Ints.saturatedCast(paramInt1 + paramInt2);
  }
  
  @Beta
  public static int saturatedMultiply(int paramInt1, int paramInt2)
  {
    return Ints.saturatedCast(paramInt1 * paramInt2);
  }
  
  @Beta
  public static int saturatedPow(int paramInt1, int paramInt2)
  {
    int j = 1;
    MathPreconditions.checkNonNegative("exponent", paramInt2);
    int i = j;
    int k;
    int m;
    switch (paramInt1)
    {
    default: 
      i = 1;
      k = paramInt2;
      j = paramInt1;
      m = j;
      switch (k)
      {
      default: 
        if ((k & 0x1) != 0) {
          i = saturatedMultiply(i, m);
        }
        break;
      }
      break;
    }
    for (;;)
    {
      int n = k >> 1;
      if (n > 0)
      {
        if (-46340 > m)
        {
          j = 1;
          if (m <= 46340) {
            break label221;
          }
        }
        label221:
        for (k = 1;; k = 0)
        {
          if ((k | j) == 0) {
            break label227;
          }
          i = 2147483647 + (paramInt1 >>> 31 & paramInt2 & 0x1);
          do
          {
            do
            {
              return i;
              i = j;
            } while (paramInt2 == 0);
            return 0;
            i = j;
          } while ((paramInt2 & 0x1) == 0);
          return -1;
          if (paramInt2 >= 31) {
            return 2147483647;
          }
          return 1 << paramInt2;
          if (paramInt2 >= 32) {
            return (paramInt2 & 0x1) + 2147483647;
          }
          if ((paramInt2 & 0x1) == 0) {
            return 1 << paramInt2;
          }
          return -1 << paramInt2;
          return i;
          return saturatedMultiply(i, m);
          j = 0;
          break;
        }
        label227:
        j = m * m;
        k = n;
        break;
      }
      j = m;
      k = n;
      break;
    }
  }
  
  @Beta
  public static int saturatedSubtract(int paramInt1, int paramInt2)
  {
    return Ints.saturatedCast(paramInt1 - paramInt2);
  }
  
  @GwtIncompatible
  public static int sqrt(int paramInt, RoundingMode paramRoundingMode)
  {
    MathPreconditions.checkNonNegative("x", paramInt);
    int i = sqrtFloor(paramInt);
    switch (1.$SwitchMap$java$math$RoundingMode[paramRoundingMode.ordinal()])
    {
    default: 
      throw new AssertionError();
    case 1: 
      if (i * i != paramInt) {
        break;
      }
    case 2: 
    case 3: 
      for (boolean bool = true;; bool = false)
      {
        MathPreconditions.checkRoundingUnnecessary(bool);
        return i;
      }
    case 4: 
    case 5: 
      return lessThanBranchFree(i * i, paramInt) + i;
    }
    return lessThanBranchFree(i * i + i, paramInt) + i;
  }
  
  private static int sqrtFloor(int paramInt)
  {
    return (int)Math.sqrt(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.math.IntMath
 * JD-Core Version:    0.7.0.1
 */