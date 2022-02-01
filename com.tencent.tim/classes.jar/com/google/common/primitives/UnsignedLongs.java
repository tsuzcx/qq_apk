package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.util.Comparator;

@Beta
@GwtCompatible
public final class UnsignedLongs
{
  public static final long MAX_VALUE = -1L;
  private static final int[] maxSafeDigits;
  private static final long[] maxValueDivs = new long[37];
  private static final int[] maxValueMods = new int[37];
  
  static
  {
    maxSafeDigits = new int[37];
    BigInteger localBigInteger = new BigInteger("10000000000000000", 16);
    int i = 2;
    while (i <= 36)
    {
      maxValueDivs[i] = divide(-1L, i);
      maxValueMods[i] = ((int)remainder(-1L, i));
      maxSafeDigits[i] = (localBigInteger.toString(i).length() - 1);
      i += 1;
    }
  }
  
  public static int compare(long paramLong1, long paramLong2)
  {
    return Longs.compare(flip(paramLong1), flip(paramLong2));
  }
  
  @CanIgnoreReturnValue
  public static long decode(String paramString)
  {
    ParseRequest localParseRequest = ParseRequest.fromString(paramString);
    try
    {
      long l = parseUnsignedLong(localParseRequest.rawValue, localParseRequest.radix);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      paramString = new NumberFormatException("Error parsing value: " + paramString);
      paramString.initCause(localNumberFormatException);
      throw paramString;
    }
  }
  
  public static long divide(long paramLong1, long paramLong2)
  {
    int i = 1;
    if (paramLong2 < 0L)
    {
      if (compare(paramLong1, paramLong2) < 0) {
        return 0L;
      }
      return 1L;
    }
    if (paramLong1 >= 0L) {
      return paramLong1 / paramLong2;
    }
    long l = (paramLong1 >>> 1) / paramLong2 << 1;
    if (compare(paramLong1 - l * paramLong2, paramLong2) >= 0) {}
    for (;;)
    {
      return i + l;
      i = 0;
    }
  }
  
  private static long flip(long paramLong)
  {
    return 0x0 ^ paramLong;
  }
  
  public static String join(String paramString, long... paramVarArgs)
  {
    Preconditions.checkNotNull(paramString);
    if (paramVarArgs.length == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 5);
    localStringBuilder.append(toString(paramVarArgs[0]));
    int i = 1;
    while (i < paramVarArgs.length)
    {
      localStringBuilder.append(paramString).append(toString(paramVarArgs[i]));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static Comparator<long[]> lexicographicalComparator()
  {
    return LexicographicalComparator.INSTANCE;
  }
  
  public static long max(long... paramVarArgs)
  {
    int i = 1;
    if (paramVarArgs.length > 0) {}
    long l1;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      long l2;
      for (l1 = flip(paramVarArgs[0]); i < paramVarArgs.length; l1 = l2)
      {
        long l3 = flip(paramVarArgs[i]);
        l2 = l1;
        if (l3 > l1) {
          l2 = l3;
        }
        i += 1;
      }
    }
    return flip(l1);
  }
  
  public static long min(long... paramVarArgs)
  {
    int i = 1;
    if (paramVarArgs.length > 0) {}
    long l1;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      long l2;
      for (l1 = flip(paramVarArgs[0]); i < paramVarArgs.length; l1 = l2)
      {
        long l3 = flip(paramVarArgs[i]);
        l2 = l1;
        if (l3 < l1) {
          l2 = l3;
        }
        i += 1;
      }
    }
    return flip(l1);
  }
  
  private static boolean overflowInParse(long paramLong, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramLong >= 0L)
    {
      if (paramLong >= maxValueDivs[paramInt2]) {
        break label29;
      }
      bool1 = false;
    }
    label29:
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramLong > maxValueDivs[paramInt2]);
      bool1 = bool2;
    } while (paramInt1 > maxValueMods[paramInt2]);
    return false;
  }
  
  @CanIgnoreReturnValue
  public static long parseUnsignedLong(String paramString)
  {
    return parseUnsignedLong(paramString, 10);
  }
  
  @CanIgnoreReturnValue
  public static long parseUnsignedLong(String paramString, int paramInt)
  {
    Preconditions.checkNotNull(paramString);
    if (paramString.length() == 0) {
      throw new NumberFormatException("empty string");
    }
    if ((paramInt < 2) || (paramInt > 36)) {
      throw new NumberFormatException("illegal radix: " + paramInt);
    }
    int j = maxSafeDigits[paramInt];
    long l = 0L;
    int i = 0;
    while (i < paramString.length())
    {
      int k = Character.digit(paramString.charAt(i), paramInt);
      if (k == -1) {
        throw new NumberFormatException(paramString);
      }
      if ((i > j - 1) && (overflowInParse(l, k, paramInt))) {
        throw new NumberFormatException("Too large for unsigned long: " + paramString);
      }
      l = l * paramInt + k;
      i += 1;
    }
    return l;
  }
  
  public static long remainder(long paramLong1, long paramLong2)
  {
    if (paramLong2 < 0L)
    {
      if (compare(paramLong1, paramLong2) < 0) {
        return paramLong1;
      }
      return paramLong1 - paramLong2;
    }
    if (paramLong1 >= 0L) {
      return paramLong1 % paramLong2;
    }
    paramLong1 -= ((paramLong1 >>> 1) / paramLong2 << 1) * paramLong2;
    if (compare(paramLong1, paramLong2) >= 0) {}
    for (;;)
    {
      return paramLong1 - paramLong2;
      paramLong2 = 0L;
    }
  }
  
  public static String toString(long paramLong)
  {
    return toString(paramLong, 10);
  }
  
  public static String toString(long paramLong, int paramInt)
  {
    if ((paramInt >= 2) && (paramInt <= 36)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", paramInt);
      if (paramLong != 0L) {
        break;
      }
      return "0";
    }
    if (paramLong > 0L) {
      return Long.toString(paramLong, paramInt);
    }
    char[] arrayOfChar = new char[64];
    int i = arrayOfChar.length;
    int j;
    if ((paramInt - 1 & paramInt) == 0)
    {
      int k = Integer.numberOfTrailingZeros(paramInt);
      do
      {
        j = i - 1;
        arrayOfChar[j] = Character.forDigit((int)paramLong & paramInt - 1, paramInt);
        l1 = paramLong >>> k;
        i = j;
        paramLong = l1;
      } while (l1 != 0L);
      return new String(arrayOfChar, j, arrayOfChar.length - j);
    }
    if ((paramInt & 0x1) == 0) {}
    for (long l1 = (paramLong >>> 1) / (paramInt >>> 1);; l1 = divide(paramLong, paramInt))
    {
      long l2 = paramInt;
      i -= 1;
      arrayOfChar[i] = Character.forDigit((int)(paramLong - l2 * l1), paramInt);
      for (;;)
      {
        j = i;
        if (l1 <= 0L) {
          break;
        }
        i -= 1;
        arrayOfChar[i] = Character.forDigit((int)(l1 % paramInt), paramInt);
        l1 /= paramInt;
      }
    }
  }
  
  static enum LexicographicalComparator
    implements Comparator<long[]>
  {
    INSTANCE;
    
    private LexicographicalComparator() {}
    
    public int compare(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
    {
      int j = Math.min(paramArrayOfLong1.length, paramArrayOfLong2.length);
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfLong1[i] != paramArrayOfLong2[i]) {
          return UnsignedLongs.compare(paramArrayOfLong1[i], paramArrayOfLong2[i]);
        }
        i += 1;
      }
      return paramArrayOfLong1.length - paramArrayOfLong2.length;
    }
    
    public String toString()
    {
      return "UnsignedLongs.lexicographicalComparator()";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.primitives.UnsignedLongs
 * JD-Core Version:    0.7.0.1
 */