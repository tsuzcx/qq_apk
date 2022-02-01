package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.Nullable;

@GwtCompatible
public final class Booleans
{
  public static List<Boolean> asList(boolean... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return Collections.emptyList();
    }
    return new BooleanArrayAsList(paramVarArgs);
  }
  
  public static int compare(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1 == paramBoolean2) {
      return 0;
    }
    if (paramBoolean1) {
      return 1;
    }
    return -1;
  }
  
  public static boolean[] concat(boolean[]... paramVarArgs)
  {
    int k = paramVarArgs.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += paramVarArgs[i].length;
      i += 1;
    }
    boolean[] arrayOfBoolean1 = new boolean[j];
    k = paramVarArgs.length;
    i = 0;
    j = 0;
    while (i < k)
    {
      boolean[] arrayOfBoolean2 = paramVarArgs[i];
      System.arraycopy(arrayOfBoolean2, 0, arrayOfBoolean1, j, arrayOfBoolean2.length);
      j += arrayOfBoolean2.length;
      i += 1;
    }
    return arrayOfBoolean1;
  }
  
  public static boolean contains(boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    boolean bool2 = false;
    int j = paramArrayOfBoolean.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfBoolean[i] == paramBoolean) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  @Beta
  public static int countTrue(boolean... paramVarArgs)
  {
    int j = 0;
    int m = paramVarArgs.length;
    int i = 0;
    while (i < m)
    {
      int k = j;
      if (paramVarArgs[i] != 0) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  public static boolean[] ensureCapacity(boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2)
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
      boolean[] arrayOfBoolean = paramArrayOfBoolean;
      if (paramArrayOfBoolean.length < paramInt1) {
        arrayOfBoolean = Arrays.copyOf(paramArrayOfBoolean, paramInt1 + paramInt2);
      }
      return arrayOfBoolean;
      bool1 = false;
      break;
    }
  }
  
  public static int hashCode(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1231;
    }
    return 1237;
  }
  
  public static int indexOf(boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    return indexOf(paramArrayOfBoolean, paramBoolean, 0, paramArrayOfBoolean.length);
  }
  
  private static int indexOf(boolean[] paramArrayOfBoolean, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      if (paramArrayOfBoolean[paramInt1] == paramBoolean) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return -1;
  }
  
  public static int indexOf(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    Preconditions.checkNotNull(paramArrayOfBoolean1, "array");
    Preconditions.checkNotNull(paramArrayOfBoolean2, "target");
    if (paramArrayOfBoolean2.length == 0) {
      return 0;
    }
    int i = 0;
    if (i < paramArrayOfBoolean1.length - paramArrayOfBoolean2.length + 1)
    {
      int j = 0;
      for (;;)
      {
        if (j >= paramArrayOfBoolean2.length) {
          break label67;
        }
        if (paramArrayOfBoolean1[(i + j)] != paramArrayOfBoolean2[j])
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
  
  public static String join(String paramString, boolean... paramVarArgs)
  {
    Preconditions.checkNotNull(paramString);
    if (paramVarArgs.length == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 7);
    localStringBuilder.append(paramVarArgs[0]);
    int i = 1;
    while (i < paramVarArgs.length)
    {
      localStringBuilder.append(paramString).append(paramVarArgs[i]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static int lastIndexOf(boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    return lastIndexOf(paramArrayOfBoolean, paramBoolean, 0, paramArrayOfBoolean.length);
  }
  
  private static int lastIndexOf(boolean[] paramArrayOfBoolean, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    paramInt2 -= 1;
    while (paramInt2 >= paramInt1)
    {
      if (paramArrayOfBoolean[paramInt2] == paramBoolean) {
        return paramInt2;
      }
      paramInt2 -= 1;
    }
    return -1;
  }
  
  public static Comparator<boolean[]> lexicographicalComparator()
  {
    return LexicographicalComparator.INSTANCE;
  }
  
  public static boolean[] toArray(Collection<Boolean> paramCollection)
  {
    if ((paramCollection instanceof BooleanArrayAsList)) {
      return ((BooleanArrayAsList)paramCollection).toBooleanArray();
    }
    paramCollection = paramCollection.toArray();
    int j = paramCollection.length;
    boolean[] arrayOfBoolean = new boolean[j];
    int i = 0;
    while (i < j)
    {
      arrayOfBoolean[i] = ((Boolean)Preconditions.checkNotNull(paramCollection[i])).booleanValue();
      i += 1;
    }
    return arrayOfBoolean;
  }
  
  @GwtCompatible
  static class BooleanArrayAsList
    extends AbstractList<Boolean>
    implements Serializable, RandomAccess
  {
    private static final long serialVersionUID = 0L;
    final boolean[] array;
    final int end;
    final int start;
    
    BooleanArrayAsList(boolean[] paramArrayOfBoolean)
    {
      this(paramArrayOfBoolean, 0, paramArrayOfBoolean.length);
    }
    
    BooleanArrayAsList(boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2)
    {
      this.array = paramArrayOfBoolean;
      this.start = paramInt1;
      this.end = paramInt2;
    }
    
    public boolean contains(Object paramObject)
    {
      return ((paramObject instanceof Boolean)) && (Booleans.indexOf(this.array, ((Boolean)paramObject).booleanValue(), this.start, this.end) != -1);
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if (paramObject == this) {}
      for (;;)
      {
        return true;
        if (!(paramObject instanceof BooleanArrayAsList)) {
          break;
        }
        paramObject = (BooleanArrayAsList)paramObject;
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
    
    public Boolean get(int paramInt)
    {
      Preconditions.checkElementIndex(paramInt, size());
      return Boolean.valueOf(this.array[(this.start + paramInt)]);
    }
    
    public int hashCode()
    {
      int j = 1;
      int i = this.start;
      while (i < this.end)
      {
        j = j * 31 + Booleans.hashCode(this.array[i]);
        i += 1;
      }
      return j;
    }
    
    public int indexOf(Object paramObject)
    {
      if ((paramObject instanceof Boolean))
      {
        int i = Booleans.indexOf(this.array, ((Boolean)paramObject).booleanValue(), this.start, this.end);
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
      if ((paramObject instanceof Boolean))
      {
        int i = Booleans.lastIndexOf(this.array, ((Boolean)paramObject).booleanValue(), this.start, this.end);
        if (i >= 0) {
          return i - this.start;
        }
      }
      return -1;
    }
    
    public Boolean set(int paramInt, Boolean paramBoolean)
    {
      Preconditions.checkElementIndex(paramInt, size());
      int i = this.array[(this.start + paramInt)];
      this.array[(this.start + paramInt)] = ((Boolean)Preconditions.checkNotNull(paramBoolean)).booleanValue();
      return Boolean.valueOf(i);
    }
    
    public int size()
    {
      return this.end - this.start;
    }
    
    public List<Boolean> subList(int paramInt1, int paramInt2)
    {
      Preconditions.checkPositionIndexes(paramInt1, paramInt2, size());
      if (paramInt1 == paramInt2) {
        return Collections.emptyList();
      }
      return new BooleanArrayAsList(this.array, this.start + paramInt1, this.start + paramInt2);
    }
    
    boolean[] toBooleanArray()
    {
      int i = size();
      boolean[] arrayOfBoolean = new boolean[i];
      System.arraycopy(this.array, this.start, arrayOfBoolean, 0, i);
      return arrayOfBoolean;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(size() * 7);
      int i;
      if (this.array[this.start] != 0)
      {
        str = "[true";
        localStringBuilder.append(str);
        i = this.start + 1;
        label43:
        if (i >= this.end) {
          break label88;
        }
        if (this.array[i] == 0) {
          break label82;
        }
      }
      label82:
      for (String str = ", true";; str = ", false")
      {
        localStringBuilder.append(str);
        i += 1;
        break label43;
        str = "[false";
        break;
      }
      label88:
      return ']';
    }
  }
  
  static enum LexicographicalComparator
    implements Comparator<boolean[]>
  {
    INSTANCE;
    
    private LexicographicalComparator() {}
    
    public int compare(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
    {
      int j = Math.min(paramArrayOfBoolean1.length, paramArrayOfBoolean2.length);
      int i = 0;
      while (i < j)
      {
        int k = Booleans.compare(paramArrayOfBoolean1[i], paramArrayOfBoolean2[i]);
        if (k != 0) {
          return k;
        }
        i += 1;
      }
      return paramArrayOfBoolean1.length - paramArrayOfBoolean2.length;
    }
    
    public String toString()
    {
      return "Booleans.lexicographicalComparator()";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.primitives.Booleans
 * JD-Core Version:    0.7.0.1
 */