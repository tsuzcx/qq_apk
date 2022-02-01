package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Iterator;

@GwtCompatible(emulated=true)
public final class DoubleMath
{
  private static final double LN_2 = Math.log(2.0D);
  @VisibleForTesting
  static final int MAX_FACTORIAL = 170;
  private static final double MAX_INT_AS_DOUBLE = 2147483647.0D;
  private static final double MAX_LONG_AS_DOUBLE_PLUS_ONE = 9.223372036854776E+018D;
  private static final double MIN_INT_AS_DOUBLE = -2147483648.0D;
  private static final double MIN_LONG_AS_DOUBLE = -9.223372036854776E+018D;
  @VisibleForTesting
  static final double[] everySixteenthFactorial = { 1.0D, 20922789888000.0D, 2.631308369336935E+035D, 1.241391559253607E+061D, 1.268869321858842E+089D, 7.156945704626381E+118D, 9.916779348709497E+149D, 1.974506857221074E+182D, 3.856204823625804E+215D, 5.550293832739304E+249D, 4.714723635992062E+284D };
  
  @GwtIncompatible
  @CanIgnoreReturnValue
  private static double checkFinite(double paramDouble)
  {
    Preconditions.checkArgument(DoubleUtils.isFinite(paramDouble));
    return paramDouble;
  }
  
  public static double factorial(int paramInt)
  {
    MathPreconditions.checkNonNegative("n", paramInt);
    if (paramInt > 170) {
      return (1.0D / 0.0D);
    }
    double d = 1.0D;
    int i = (paramInt & 0xFFFFFFF0) + 1;
    while (i <= paramInt)
    {
      d *= i;
      i += 1;
    }
    return everySixteenthFactorial[(paramInt >> 4)] * d;
  }
  
  public static int fuzzyCompare(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (fuzzyEquals(paramDouble1, paramDouble2, paramDouble3)) {
      return 0;
    }
    if (paramDouble1 < paramDouble2) {
      return -1;
    }
    if (paramDouble1 > paramDouble2) {
      return 1;
    }
    return Booleans.compare(Double.isNaN(paramDouble1), Double.isNaN(paramDouble2));
  }
  
  public static boolean fuzzyEquals(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    MathPreconditions.checkNonNegative("tolerance", paramDouble3);
    return (Math.copySign(paramDouble1 - paramDouble2, 1.0D) <= paramDouble3) || (paramDouble1 == paramDouble2) || ((Double.isNaN(paramDouble1)) && (Double.isNaN(paramDouble2)));
  }
  
  @GwtIncompatible
  public static boolean isMathematicalInteger(double paramDouble)
  {
    return (DoubleUtils.isFinite(paramDouble)) && ((paramDouble == 0.0D) || (52 - Long.numberOfTrailingZeros(DoubleUtils.getSignificand(paramDouble)) <= Math.getExponent(paramDouble)));
  }
  
  @GwtIncompatible
  public static boolean isPowerOfTwo(double paramDouble)
  {
    return (paramDouble > 0.0D) && (DoubleUtils.isFinite(paramDouble)) && (LongMath.isPowerOfTwo(DoubleUtils.getSignificand(paramDouble)));
  }
  
  public static double log2(double paramDouble)
  {
    return Math.log(paramDouble) / LN_2;
  }
  
  @GwtIncompatible
  public static int log2(double paramDouble, RoundingMode paramRoundingMode)
  {
    int j = 1;
    int k = 1;
    int i = 1;
    if ((paramDouble > 0.0D) && (DoubleUtils.isFinite(paramDouble))) {}
    int m;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "x must be positive and finite");
      m = Math.getExponent(paramDouble);
      if (DoubleUtils.isNormal(paramDouble)) {
        break;
      }
      return log2(4503599627370496.0D * paramDouble, paramRoundingMode) - 52;
    }
    switch (1.$SwitchMap$java$math$RoundingMode[paramRoundingMode.ordinal()])
    {
    default: 
      throw new AssertionError();
    case 1: 
      MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(paramDouble));
    case 2: 
      i = 0;
    }
    while (i != 0)
    {
      return m + 1;
      if (isPowerOfTwo(paramDouble))
      {
        i = 0;
        continue;
        if (m < 0)
        {
          i = 1;
          label161:
          if (isPowerOfTwo(paramDouble)) {
            break label181;
          }
        }
        for (;;)
        {
          i = j & i;
          break;
          i = 0;
          break label161;
          label181:
          j = 0;
        }
        if (m >= 0)
        {
          i = 1;
          label194:
          if (isPowerOfTwo(paramDouble)) {
            break label218;
          }
        }
        label218:
        for (j = k;; j = 0)
        {
          i = j & i;
          break;
          i = 0;
          break label194;
        }
        paramDouble = DoubleUtils.scaleNormalize(paramDouble);
        if (paramDouble * paramDouble <= 2.0D) {
          i = 0;
        }
      }
    }
    return m;
  }
  
  @Deprecated
  @GwtIncompatible
  public static double mean(Iterable<? extends Number> paramIterable)
  {
    return mean(paramIterable.iterator());
  }
  
  @Deprecated
  @GwtIncompatible
  public static double mean(Iterator<? extends Number> paramIterator)
  {
    Preconditions.checkArgument(paramIterator.hasNext(), "Cannot take mean of 0 values");
    double d1 = checkFinite(((Number)paramIterator.next()).doubleValue());
    long l = 1L;
    while (paramIterator.hasNext())
    {
      double d2 = checkFinite(((Number)paramIterator.next()).doubleValue());
      l += 1L;
      d1 = (d2 - d1) / l + d1;
    }
    return d1;
  }
  
  @Deprecated
  @GwtIncompatible
  public static double mean(double... paramVarArgs)
  {
    int i = 1;
    if (paramVarArgs.length > 0) {}
    double d;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Cannot take mean of 0 values");
      d = checkFinite(paramVarArgs[0]);
      long l = 1L;
      while (i < paramVarArgs.length)
      {
        checkFinite(paramVarArgs[i]);
        l += 1L;
        d += (paramVarArgs[i] - d) / l;
        i += 1;
      }
    }
    return d;
  }
  
  @Deprecated
  public static double mean(int... paramVarArgs)
  {
    int i = 0;
    if (paramVarArgs.length > 0) {}
    long l;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Cannot take mean of 0 values");
      l = 0L;
      while (i < paramVarArgs.length)
      {
        l += paramVarArgs[i];
        i += 1;
      }
    }
    return l / paramVarArgs.length;
  }
  
  @Deprecated
  public static double mean(long... paramVarArgs)
  {
    int i = 1;
    if (paramVarArgs.length > 0) {}
    double d;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Cannot take mean of 0 values");
      d = paramVarArgs[0];
      long l = 1L;
      while (i < paramVarArgs.length)
      {
        l += 1L;
        d += (paramVarArgs[i] - d) / l;
        i += 1;
      }
    }
    return d;
  }
  
  @GwtIncompatible
  static double roundIntermediate(double paramDouble, RoundingMode paramRoundingMode)
  {
    if (!DoubleUtils.isFinite(paramDouble)) {
      throw new ArithmeticException("input is infinite or NaN");
    }
    switch (1.$SwitchMap$java$math$RoundingMode[paramRoundingMode.ordinal()])
    {
    default: 
      throw new AssertionError();
    case 1: 
      MathPreconditions.checkRoundingUnnecessary(isMathematicalInteger(paramDouble));
    }
    double d;
    do
    {
      do
      {
        do
        {
          do
          {
            return paramDouble;
          } while ((paramDouble >= 0.0D) || (isMathematicalInteger(paramDouble)));
          return paramDouble - 1L;
        } while ((paramDouble <= 0.0D) || (isMathematicalInteger(paramDouble)));
        return paramDouble + 1L;
      } while (isMathematicalInteger(paramDouble));
      long l = paramDouble;
      if (paramDouble > 0.0D) {}
      for (int i = 1;; i = -1) {
        return i + l;
      }
      return Math.rint(paramDouble);
      d = Math.rint(paramDouble);
      if (Math.abs(paramDouble - d) == 0.5D) {
        return paramDouble + Math.copySign(0.5D, paramDouble);
      }
      return d;
      d = Math.rint(paramDouble);
    } while (Math.abs(paramDouble - d) == 0.5D);
    return d;
  }
  
  @GwtIncompatible
  public static BigInteger roundToBigInteger(double paramDouble, RoundingMode paramRoundingMode)
  {
    int j = 1;
    paramDouble = roundIntermediate(paramDouble, paramRoundingMode);
    int i;
    if (-9.223372036854776E+018D - paramDouble < 1.0D)
    {
      i = 1;
      if (paramDouble >= 9.223372036854776E+018D) {
        break label49;
      }
      label29:
      if ((j & i) == 0) {
        break label55;
      }
      paramRoundingMode = BigInteger.valueOf(paramDouble);
    }
    label49:
    label55:
    BigInteger localBigInteger;
    do
    {
      return paramRoundingMode;
      i = 0;
      break;
      j = 0;
      break label29;
      i = Math.getExponent(paramDouble);
      localBigInteger = BigInteger.valueOf(DoubleUtils.getSignificand(paramDouble)).shiftLeft(i - 52);
      paramRoundingMode = localBigInteger;
    } while (paramDouble >= 0.0D);
    return localBigInteger.negate();
  }
  
  @GwtIncompatible
  public static int roundToInt(double paramDouble, RoundingMode paramRoundingMode)
  {
    int j = 1;
    paramDouble = roundIntermediate(paramDouble, paramRoundingMode);
    int i;
    if (paramDouble > -2147483649.0D)
    {
      i = 1;
      if (paramDouble >= 2147483648.0D) {
        break label42;
      }
    }
    for (;;)
    {
      MathPreconditions.checkInRange(j & i);
      return (int)paramDouble;
      i = 0;
      break;
      label42:
      j = 0;
    }
  }
  
  @GwtIncompatible
  public static long roundToLong(double paramDouble, RoundingMode paramRoundingMode)
  {
    int j = 1;
    paramDouble = roundIntermediate(paramDouble, paramRoundingMode);
    int i;
    if (-9.223372036854776E+018D - paramDouble < 1.0D)
    {
      i = 1;
      if (paramDouble >= 9.223372036854776E+018D) {
        break label44;
      }
    }
    for (;;)
    {
      MathPreconditions.checkInRange(j & i);
      return paramDouble;
      i = 0;
      break;
      label44:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.math.DoubleMath
 * JD-Core Version:    0.7.0.1
 */