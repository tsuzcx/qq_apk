package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible(emulated=true)
public final class Shorts
{
  public static final int BYTES = 2;
  public static final short MAX_POWER_OF_TWO = 16384;
  
  public static List<Short> asList(short... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return Collections.emptyList();
    }
    return new ShortArrayAsList(paramVarArgs);
  }
  
  public static short checkedCast(long paramLong)
  {
    short s = (short)(int)paramLong;
    if (s != paramLong) {
      throw new IllegalArgumentException("Out of range: " + paramLong);
    }
    return s;
  }
  
  public static int compare(short paramShort1, short paramShort2)
  {
    return paramShort1 - paramShort2;
  }
  
  public static short[] concat(short[]... paramVarArgs)
  {
    int k = paramVarArgs.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += paramVarArgs[i].length;
      i += 1;
    }
    short[] arrayOfShort1 = new short[j];
    k = paramVarArgs.length;
    i = 0;
    j = 0;
    while (i < k)
    {
      short[] arrayOfShort2 = paramVarArgs[i];
      System.arraycopy(arrayOfShort2, 0, arrayOfShort1, j, arrayOfShort2.length);
      j += arrayOfShort2.length;
      i += 1;
    }
    return arrayOfShort1;
  }
  
  public static boolean contains(short[] paramArrayOfShort, short paramShort)
  {
    boolean bool2 = false;
    int j = paramArrayOfShort.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfShort[i] == paramShort) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static short[] ensureCapacity(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    if (paramInt1 >= 0)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1, "Invalid minLength: %s", paramInt1);
      if (paramInt2 < 0) {
        break label56;
      }
    }
    label56:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1, "Invalid padding: %s", paramInt2);
      short[] arrayOfShort = paramArrayOfShort;
      if (paramArrayOfShort.length < paramInt1) {
        arrayOfShort = Arrays.copyOf(paramArrayOfShort, paramInt1 + paramInt2);
      }
      return arrayOfShort;
      bool1 = false;
      break;
    }
  }
  
  @GwtIncompatible
  public static short fromByteArray(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length >= 2) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "array too small: %s < %s", paramArrayOfByte.length, 2);
      return fromBytes(paramArrayOfByte[0], paramArrayOfByte[1]);
    }
  }
  
  @GwtIncompatible
  public static short fromBytes(byte paramByte1, byte paramByte2)
  {
    return (short)(paramByte1 << 8 | paramByte2 & 0xFF);
  }
  
  public static int hashCode(short paramShort)
  {
    return paramShort;
  }
  
  public static int indexOf(short[] paramArrayOfShort, short paramShort)
  {
    return indexOf(paramArrayOfShort, paramShort, 0, paramArrayOfShort.length);
  }
  
  private static int indexOf(short[] paramArrayOfShort, short paramShort, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      if (paramArrayOfShort[paramInt1] == paramShort) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return -1;
  }
  
  public static int indexOf(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    Preconditions.checkNotNull(paramArrayOfShort1, "array");
    Preconditions.checkNotNull(paramArrayOfShort2, "target");
    if (paramArrayOfShort2.length == 0) {
      return 0;
    }
    int i = 0;
    if (i < paramArrayOfShort1.length - paramArrayOfShort2.length + 1)
    {
      int j = 0;
      for (;;)
      {
        if (j >= paramArrayOfShort2.length) {
          break label67;
        }
        if (paramArrayOfShort1[(i + j)] != paramArrayOfShort2[j])
        {
          i += 1;
          break;
        }
        j += 1;
      }
      label67:
      return i;
    }
    return -1;
  }
  
  public static String join(String paramString, short... paramVarArgs)
  {
    Preconditions.checkNotNull(paramString);
    if (paramVarArgs.length == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 6);
    localStringBuilder.append(paramVarArgs[0]);
    int i = 1;
    while (i < paramVarArgs.length)
    {
      localStringBuilder.append(paramString).append(paramVarArgs[i]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static int lastIndexOf(short[] paramArrayOfShort, short paramShort)
  {
    return lastIndexOf(paramArrayOfShort, paramShort, 0, paramArrayOfShort.length);
  }
  
  private static int lastIndexOf(short[] paramArrayOfShort, short paramShort, int paramInt1, int paramInt2)
  {
    paramInt2 -= 1;
    while (paramInt2 >= paramInt1)
    {
      if (paramArrayOfShort[paramInt2] == paramShort) {
        return paramInt2;
      }
      paramInt2 -= 1;
    }
    return -1;
  }
  
  public static Comparator<short[]> lexicographicalComparator()
  {
    return LexicographicalComparator.INSTANCE;
  }
  
  public static short max(short... paramVarArgs)
  {
    int i = 1;
    if (paramVarArgs.length > 0) {}
    short s1;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      short s2;
      for (s1 = paramVarArgs[0]; i < paramVarArgs.length; s1 = s2)
      {
        s2 = s1;
        if (paramVarArgs[i] > s1) {
          s2 = paramVarArgs[i];
        }
        i += 1;
      }
    }
    return s1;
  }
  
  public static short min(short... paramVarArgs)
  {
    int i = 1;
    if (paramVarArgs.length > 0) {}
    short s1;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      short s2;
      for (s1 = paramVarArgs[0]; i < paramVarArgs.length; s1 = s2)
      {
        s2 = s1;
        if (paramVarArgs[i] < s1) {
          s2 = paramVarArgs[i];
        }
        i += 1;
      }
    }
    return s1;
  }
  
  public static short saturatedCast(long paramLong)
  {
    if (paramLong > 32767L) {
      return 32767;
    }
    if (paramLong < -32768L) {
      return -32768;
    }
    return (short)(int)paramLong;
  }
  
  @Beta
  public static Converter<String, Short> stringConverter()
  {
    return ShortConverter.INSTANCE;
  }
  
  public static short[] toArray(Collection<? extends Number> paramCollection)
  {
    if ((paramCollection instanceof ShortArrayAsList)) {
      return ((ShortArrayAsList)paramCollection).toShortArray();
    }
    paramCollection = paramCollection.toArray();
    int j = paramCollection.length;
    short[] arrayOfShort = new short[j];
    int i = 0;
    while (i < j)
    {
      arrayOfShort[i] = ((Number)Preconditions.checkNotNull(paramCollection[i])).shortValue();
      i += 1;
    }
    return arrayOfShort;
  }
  
  @GwtIncompatible
  public static byte[] toByteArray(short paramShort)
  {
    return new byte[] { (byte)(paramShort >> 8), (byte)paramShort };
  }
  
  static enum LexicographicalComparator
    implements Comparator<short[]>
  {
    INSTANCE;
    
    private LexicographicalComparator() {}
    
    public int compare(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
    {
      int j = Math.min(paramArrayOfShort1.length, paramArrayOfShort2.length);
      int i = 0;
      while (i < j)
      {
        int k = Shorts.compare(paramArrayOfShort1[i], paramArrayOfShort2[i]);
        if (k != 0) {
          return k;
        }
        i += 1;
      }
      return paramArrayOfShort1.length - paramArrayOfShort2.length;
    }
    
    public String toString()
    {
      return "Shorts.lexicographicalComparator()";
    }
  }
  
  @GwtCompatible
  static class ShortArrayAsList
    extends AbstractList<Short>
    implements Serializable, RandomAccess
  {
    private static final long serialVersionUID = 0L;
    final short[] array;
    final int end;
    final int start;
    
    ShortArrayAsList(short[] paramArrayOfShort)
    {
      this(paramArrayOfShort, 0, paramArrayOfShort.length);
    }
    
    ShortArrayAsList(short[] paramArrayOfShort, int paramInt1, int paramInt2)
    {
      this.array = paramArrayOfShort;
      this.start = paramInt1;
      this.end = paramInt2;
    }
    
    public boolean contains(Object paramObject)
    {
      return ((paramObject instanceof Short)) && (Shorts.indexOf(this.array, ((Short)paramObject).shortValue(), this.start, this.end) != -1);
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      for (;;)
      {
        return true;
        if (!(paramObject instanceof ShortArrayAsList)) {
          break;
        }
        paramObject = (ShortArrayAsList)paramObject;
        int j = size();
        if (paramObject.size() != j) {
          return false;
        }
        int i = 0;
        while (i < j)
        {
          if (this.array[(this.start + i)] != paramObject.array[(paramObject.start + i)]) {
            return false;
          }
          i += 1;
        }
      }
      return super.equals(paramObject);
    }
    
    public Short get(int paramInt)
    {
      Preconditions.checkElementIndex(paramInt, size());
      return Short.valueOf(this.array[(this.start + paramInt)]);
    }
    
    public int hashCode()
    {
      int j = 1;
      int i = this.start;
      while (i < this.end)
      {
        j = j * 31 + Shorts.hashCode(this.array[i]);
        i += 1;
      }
      return j;
    }
    
    public int indexOf(Object paramObject)
    {
      if ((paramObject instanceof Short))
      {
        int i = Shorts.indexOf(this.array, ((Short)paramObject).shortValue(), this.start, this.end);
        if (i >= 0) {
          return i - this.start;
        }
      }
      return -1;
    }
    
    public boolean isEmpty()
    {
      return false;
    }
    
    public int lastIndexOf(Object paramObject)
    {
      if ((paramObject instanceof Short))
      {
        int i = Shorts.lastIndexOf(this.array, ((Short)paramObject).shortValue(), this.start, this.end);
        if (i >= 0) {
          return i - this.start;
        }
      }
      return -1;
    }
    
    public Short set(int paramInt, Short paramShort)
    {
      Preconditions.checkElementIndex(paramInt, size());
      short s = this.array[(this.start + paramInt)];
      this.array[(this.start + paramInt)] = ((Short)Preconditions.checkNotNull(paramShort)).shortValue();
      return Short.valueOf(s);
    }
    
    public int size()
    {
      return this.end - this.start;
    }
    
    public List<Short> subList(int paramInt1, int paramInt2)
    {
      Preconditions.checkPositionIndexes(paramInt1, paramInt2, size());
      if (paramInt1 == paramInt2) {
        return Collections.emptyList();
      }
      return new ShortArrayAsList(this.array, this.start + paramInt1, this.start + paramInt2);
    }
    
    short[] toShortArray()
    {
      int i = size();
      short[] arrayOfShort = new short[i];
      System.arraycopy(this.array, this.start, arrayOfShort, 0, i);
      return arrayOfShort;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(size() * 6);
      localStringBuilder.append('[').append(this.array[this.start]);
      int i = this.start + 1;
      while (i < this.end)
      {
        localStringBuilder.append(", ").append(this.array[i]);
        i += 1;
      }
      return ']';
    }
  }
  
  static final class ShortConverter
    extends Converter<String, Short>
    implements Serializable
  {
    static final ShortConverter INSTANCE = new ShortConverter();
    private static final long serialVersionUID = 1L;
    
    private Object readResolve()
    {
      return INSTANCE;
    }
    
    protected String doBackward(Short paramShort)
    {
      return paramShort.toString();
    }
    
    protected Short doForward(String paramString)
    {
      return Short.decode(paramString);
    }
    
    public String toString()
    {
      return "Shorts.stringConverter()";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.primitives.Shorts
 * JD-Core Version:    0.7.0.1
 */