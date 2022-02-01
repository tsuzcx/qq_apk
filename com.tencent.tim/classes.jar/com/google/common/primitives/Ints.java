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
import javax.annotation.CheckForNull;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class Ints
{
  public static final int BYTES = 4;
  public static final int MAX_POWER_OF_TWO = 1073741824;
  
  public static List<Integer> asList(int... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return Collections.emptyList();
    }
    return new IntArrayAsList(paramVarArgs);
  }
  
  public static int checkedCast(long paramLong)
  {
    int i = (int)paramLong;
    if (i != paramLong) {
      throw new IllegalArgumentException("Out of range: " + paramLong);
    }
    return i;
  }
  
  public static int compare(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return -1;
    }
    if (paramInt1 > paramInt2) {
      return 1;
    }
    return 0;
  }
  
  public static int[] concat(int[]... paramVarArgs)
  {
    int k = paramVarArgs.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += paramVarArgs[i].length;
      i += 1;
    }
    int[] arrayOfInt1 = new int[j];
    k = paramVarArgs.length;
    i = 0;
    j = 0;
    while (i < k)
    {
      int[] arrayOfInt2 = paramVarArgs[i];
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, j, arrayOfInt2.length);
      j += arrayOfInt2.length;
      i += 1;
    }
    return arrayOfInt1;
  }
  
  public static boolean contains(int[] paramArrayOfInt, int paramInt)
  {
    boolean bool2 = false;
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static int[] ensureCapacity(int[] paramArrayOfInt, int paramInt1, int paramInt2)
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
      int[] arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt.length < paramInt1) {
        arrayOfInt = Arrays.copyOf(paramArrayOfInt, paramInt1 + paramInt2);
      }
      return arrayOfInt;
      bool1 = false;
      break;
    }
  }
  
  @GwtIncompatible
  public static int fromByteArray(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length >= 4) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "array too small: %s < %s", paramArrayOfByte.length, 4);
      return fromBytes(paramArrayOfByte[0], paramArrayOfByte[1], paramArrayOfByte[2], paramArrayOfByte[3]);
    }
  }
  
  @GwtIncompatible
  public static int fromBytes(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4)
  {
    return paramByte1 << 24 | (paramByte2 & 0xFF) << 16 | (paramByte3 & 0xFF) << 8 | paramByte4 & 0xFF;
  }
  
  public static int hashCode(int paramInt)
  {
    return paramInt;
  }
  
  public static int indexOf(int[] paramArrayOfInt, int paramInt)
  {
    return indexOf(paramArrayOfInt, paramInt, 0, paramArrayOfInt.length);
  }
  
  private static int indexOf(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    while (paramInt2 < paramInt3)
    {
      if (paramArrayOfInt[paramInt2] == paramInt1) {
        return paramInt2;
      }
      paramInt2 += 1;
    }
    return -1;
  }
  
  public static int indexOf(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    Preconditions.checkNotNull(paramArrayOfInt1, "array");
    Preconditions.checkNotNull(paramArrayOfInt2, "target");
    if (paramArrayOfInt2.length == 0) {
      return 0;
    }
    int i = 0;
    if (i < paramArrayOfInt1.length - paramArrayOfInt2.length + 1)
    {
      int j = 0;
      for (;;)
      {
        if (j >= paramArrayOfInt2.length) {
          break label67;
        }
        if (paramArrayOfInt1[(i + j)] != paramArrayOfInt2[j])
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
  
  public static String join(String paramString, int... paramVarArgs)
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
  
  public static int lastIndexOf(int[] paramArrayOfInt, int paramInt)
  {
    return lastIndexOf(paramArrayOfInt, paramInt, 0, paramArrayOfInt.length);
  }
  
  private static int lastIndexOf(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt3 -= 1;
    while (paramInt3 >= paramInt2)
    {
      if (paramArrayOfInt[paramInt3] == paramInt1) {
        return paramInt3;
      }
      paramInt3 -= 1;
    }
    return -1;
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
      for (j = paramVarArgs[0]; i < paramVarArgs.length; j = k)
      {
        k = j;
        if (paramVarArgs[i] > j) {
          k = paramVarArgs[i];
        }
        i += 1;
      }
    }
    return j;
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
      for (j = paramVarArgs[0]; i < paramVarArgs.length; j = k)
      {
        k = j;
        if (paramVarArgs[i] < j) {
          k = paramVarArgs[i];
        }
        i += 1;
      }
    }
    return j;
  }
  
  public static int saturatedCast(long paramLong)
  {
    if (paramLong > 2147483647L) {
      return 2147483647;
    }
    if (paramLong < -2147483648L) {
      return -2147483648;
    }
    return (int)paramLong;
  }
  
  @Beta
  public static Converter<String, Integer> stringConverter()
  {
    return IntConverter.INSTANCE;
  }
  
  public static int[] toArray(Collection<? extends Number> paramCollection)
  {
    if ((paramCollection instanceof IntArrayAsList)) {
      return ((IntArrayAsList)paramCollection).toIntArray();
    }
    paramCollection = paramCollection.toArray();
    int j = paramCollection.length;
    int[] arrayOfInt = new int[j];
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = ((Number)Preconditions.checkNotNull(paramCollection[i])).intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  @GwtIncompatible
  public static byte[] toByteArray(int paramInt)
  {
    return new byte[] { (byte)(paramInt >> 24), (byte)(paramInt >> 16), (byte)(paramInt >> 8), (byte)paramInt };
  }
  
  @CheckForNull
  @Nullable
  @Beta
  public static Integer tryParse(String paramString)
  {
    return tryParse(paramString, 10);
  }
  
  @CheckForNull
  @Nullable
  @Beta
  public static Integer tryParse(String paramString, int paramInt)
  {
    paramString = Longs.tryParse(paramString, paramInt);
    if ((paramString == null) || (paramString.longValue() != paramString.intValue())) {
      return null;
    }
    return Integer.valueOf(paramString.intValue());
  }
  
  @GwtCompatible
  static class IntArrayAsList
    extends AbstractList<Integer>
    implements Serializable, RandomAccess
  {
    private static final long serialVersionUID = 0L;
    final int[] array;
    final int end;
    final int start;
    
    IntArrayAsList(int[] paramArrayOfInt)
    {
      this(paramArrayOfInt, 0, paramArrayOfInt.length);
    }
    
    IntArrayAsList(int[] paramArrayOfInt, int paramInt1, int paramInt2)
    {
      this.array = paramArrayOfInt;
      this.start = paramInt1;
      this.end = paramInt2;
    }
    
    public boolean contains(Object paramObject)
    {
      return ((paramObject instanceof Integer)) && (Ints.indexOf(this.array, ((Integer)paramObject).intValue(), this.start, this.end) != -1);
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if (paramObject == this) {}
      for (;;)
      {
        return true;
        if (!(paramObject instanceof IntArrayAsList)) {
          break;
        }
        paramObject = (IntArrayAsList)paramObject;
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
    
    public Integer get(int paramInt)
    {
      Preconditions.checkElementIndex(paramInt, size());
      return Integer.valueOf(this.array[(this.start + paramInt)]);
    }
    
    public int hashCode()
    {
      int j = 1;
      int i = this.start;
      while (i < this.end)
      {
        j = j * 31 + Ints.hashCode(this.array[i]);
        i += 1;
      }
      return j;
    }
    
    public int indexOf(Object paramObject)
    {
      if ((paramObject instanceof Integer))
      {
        int i = Ints.indexOf(this.array, ((Integer)paramObject).intValue(), this.start, this.end);
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
      if ((paramObject instanceof Integer))
      {
        int i = Ints.lastIndexOf(this.array, ((Integer)paramObject).intValue(), this.start, this.end);
        if (i >= 0) {
          return i - this.start;
        }
      }
      return -1;
    }
    
    public Integer set(int paramInt, Integer paramInteger)
    {
      Preconditions.checkElementIndex(paramInt, size());
      int i = this.array[(this.start + paramInt)];
      this.array[(this.start + paramInt)] = ((Integer)Preconditions.checkNotNull(paramInteger)).intValue();
      return Integer.valueOf(i);
    }
    
    public int size()
    {
      return this.end - this.start;
    }
    
    public List<Integer> subList(int paramInt1, int paramInt2)
    {
      Preconditions.checkPositionIndexes(paramInt1, paramInt2, size());
      if (paramInt1 == paramInt2) {
        return Collections.emptyList();
      }
      return new IntArrayAsList(this.array, this.start + paramInt1, this.start + paramInt2);
    }
    
    int[] toIntArray()
    {
      int i = size();
      int[] arrayOfInt = new int[i];
      System.arraycopy(this.array, this.start, arrayOfInt, 0, i);
      return arrayOfInt;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(size() * 5);
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
  
  static final class IntConverter
    extends Converter<String, Integer>
    implements Serializable
  {
    static final IntConverter INSTANCE = new IntConverter();
    private static final long serialVersionUID = 1L;
    
    private Object readResolve()
    {
      return INSTANCE;
    }
    
    protected String doBackward(Integer paramInteger)
    {
      return paramInteger.toString();
    }
    
    protected Integer doForward(String paramString)
    {
      return Integer.decode(paramString);
    }
    
    public String toString()
    {
      return "Ints.stringConverter()";
    }
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
        int k = Ints.compare(paramArrayOfInt1[i], paramArrayOfInt2[i]);
        if (k != 0) {
          return k;
        }
        i += 1;
      }
      return paramArrayOfInt1.length - paramArrayOfInt2.length;
    }
    
    public String toString()
    {
      return "Ints.lexicographicalComparator()";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.primitives.Ints
 * JD-Core Version:    0.7.0.1
 */