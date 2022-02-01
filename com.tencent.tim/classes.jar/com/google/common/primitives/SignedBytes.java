package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Comparator;

@GwtCompatible
public final class SignedBytes
{
  public static final byte MAX_POWER_OF_TWO = 64;
  
  public static byte checkedCast(long paramLong)
  {
    byte b = (byte)(int)paramLong;
    if (b != paramLong) {
      throw new IllegalArgumentException("Out of range: " + paramLong);
    }
    return b;
  }
  
  public static int compare(byte paramByte1, byte paramByte2)
  {
    return paramByte1 - paramByte2;
  }
  
  public static String join(String paramString, byte... paramVarArgs)
  {
    Preconditions.checkNotNull(paramString);
    if (paramVarArgs.length == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 5);
    localStringBuilder.append(paramVarArgs[0]);
    int i = 1;
    while (i < paramVarArgs.length)
    {
      localStringBuilder.append(paramString).append(paramVarArgs[i]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static Comparator<byte[]> lexicographicalComparator()
  {
    return LexicographicalComparator.INSTANCE;
  }
  
  public static byte max(byte... paramVarArgs)
  {
    int i = 1;
    if (paramVarArgs.length > 0) {}
    byte b1;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      byte b2;
      for (b1 = paramVarArgs[0]; i < paramVarArgs.length; b1 = b2)
      {
        b2 = b1;
        if (paramVarArgs[i] > b1) {
          b2 = paramVarArgs[i];
        }
        i += 1;
      }
    }
    return b1;
  }
  
  public static byte min(byte... paramVarArgs)
  {
    int i = 1;
    if (paramVarArgs.length > 0) {}
    byte b1;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      byte b2;
      for (b1 = paramVarArgs[0]; i < paramVarArgs.length; b1 = b2)
      {
        b2 = b1;
        if (paramVarArgs[i] < b1) {
          b2 = paramVarArgs[i];
        }
        i += 1;
      }
    }
    return b1;
  }
  
  public static byte saturatedCast(long paramLong)
  {
    if (paramLong > 127L) {
      return 127;
    }
    if (paramLong < -128L) {
      return -128;
    }
    return (byte)(int)paramLong;
  }
  
  static enum LexicographicalComparator
    implements Comparator<byte[]>
  {
    INSTANCE;
    
    private LexicographicalComparator() {}
    
    public int compare(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    {
      int j = Math.min(paramArrayOfByte1.length, paramArrayOfByte2.length);
      int i = 0;
      while (i < j)
      {
        int k = SignedBytes.compare(paramArrayOfByte1[i], paramArrayOfByte2[i]);
        if (k != 0) {
          return k;
        }
        i += 1;
      }
      return paramArrayOfByte1.length - paramArrayOfByte2.length;
    }
    
    public String toString()
    {
      return "SignedBytes.lexicographicalComparator()";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.primitives.SignedBytes
 * JD-Core Version:    0.7.0.1
 */