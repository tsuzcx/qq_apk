package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Comparator;

@Beta
@GwtCompatible
public final class UnsignedInts
{
  static final long INT_MASK = 4294967295L;
  
  public static int compare(int paramInt1, int paramInt2)
  {
    return Ints.compare(flip(paramInt1), flip(paramInt2));
  }
  
  @CanIgnoreReturnValue
  public static int decode(String paramString)
  {
    ParseRequest localParseRequest = ParseRequest.fromString(paramString);
    try
    {
      int i = parseUnsignedInt(localParseRequest.rawValue, localParseRequest.radix);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      paramString = new NumberFormatException("Error parsing value: " + paramString);
      paramString.initCause(localNumberFormatException);
      throw paramString;
    }
  }
  
  public static int divide(int paramInt1, int paramInt2)
  {
    return (int)(toLong(paramInt1) / toLong(paramInt2));
  }
  
  static int flip(int paramInt)
  {
    return 0x80000000 ^ paramInt;
  }
  
  public static String join(String paramString, int... paramVarArgs)
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
  
  public static Comparator<int[]> lexicographicalComparator()
  {
    return LexicographicalComparator.INSTANCE;
  }
  
  public static int max(int... paramVarArgs)
  {
    int i = 1;
    if (paramVarArgs.length > 0) {}
    int j;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      int k;
      for (j = flip(paramVarArgs[0]); i < paramVarArgs.length; j = k)
      {
        int m = flip(paramVarArgs[i]);
        k = j;
        if (m > j) {
          k = m;
        }
        i += 1;
      }
    }
    return flip(j);
  }
  
  public static int min(int... paramVarArgs)
  {
    int i = 1;
    if (paramVarArgs.length > 0) {}
    int j;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      int k;
      for (j = flip(paramVarArgs[0]); i < paramVarArgs.length; j = k)
      {
        int m = flip(paramVarArgs[i]);
        k = j;
        if (m < j) {
          k = m;
        }
        i += 1;
      }
    }
    return flip(j);
  }
  
  @CanIgnoreReturnValue
  public static int parseUnsignedInt(String paramString)
  {
    return parseUnsignedInt(paramString, 10);
  }
  
  @CanIgnoreReturnValue
  public static int parseUnsignedInt(String paramString, int paramInt)
  {
    Preconditions.checkNotNull(paramString);
    long l = Long.parseLong(paramString, paramInt);
    if ((0xFFFFFFFF & l) != l) {
      throw new NumberFormatException("Input " + paramString + " in base " + paramInt + " is not in the range of an unsigned integer");
    }
    return (int)l;
  }
  
  public static int remainder(int paramInt1, int paramInt2)
  {
    return (int)(toLong(paramInt1) % toLong(paramInt2));
  }
  
  public static long toLong(int paramInt)
  {
    return paramInt & 0xFFFFFFFF;
  }
  
  public static String toString(int paramInt)
  {
    return toString(paramInt, 10);
  }
  
  public static String toString(int paramInt1, int paramInt2)
  {
    return Long.toString(paramInt1 & 0xFFFFFFFF, paramInt2);
  }
  
  static enum LexicographicalComparator
    implements Comparator<int[]>
  {
    INSTANCE;
    
    private LexicographicalComparator() {}
    
    public int compare(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    {
      int j = Math.min(paramArrayOfInt1.length, paramArrayOfInt2.length);
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfInt1[i] != paramArrayOfInt2[i]) {
          return UnsignedInts.compare(paramArrayOfInt1[i], paramArrayOfInt2[i]);
        }
        i += 1;
      }
      return paramArrayOfInt1.length - paramArrayOfInt2.length;
    }
    
    public String toString()
    {
      return "UnsignedInts.lexicographicalComparator()";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.primitives.UnsignedInts
 * JD-Core Version:    0.7.0.1
 */