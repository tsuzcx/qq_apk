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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.CheckForNull;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class Floats
{
  public static final int BYTES = 4;
  
  public static List<Float> asList(float... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return Collections.emptyList();
    }
    return new FloatArrayAsList(paramVarArgs);
  }
  
  public static int compare(float paramFloat1, float paramFloat2)
  {
    return Float.compare(paramFloat1, paramFloat2);
  }
  
  public static float[] concat(float[]... paramVarArgs)
  {
    int k = paramVarArgs.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += paramVarArgs[i].length;
      i += 1;
    }
    float[] arrayOfFloat1 = new float[j];
    k = paramVarArgs.length;
    i = 0;
    j = 0;
    while (i < k)
    {
      float[] arrayOfFloat2 = paramVarArgs[i];
      System.arraycopy(arrayOfFloat2, 0, arrayOfFloat1, j, arrayOfFloat2.length);
      j += arrayOfFloat2.length;
      i += 1;
    }
    return arrayOfFloat1;
  }
  
  public static boolean contains(float[] paramArrayOfFloat, float paramFloat)
  {
    boolean bool2 = false;
    int j = paramArrayOfFloat.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfFloat[i] == paramFloat) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static float[] ensureCapacity(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
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
      float[] arrayOfFloat = paramArrayOfFloat;
      if (paramArrayOfFloat.length < paramInt1) {
        arrayOfFloat = Arrays.copyOf(paramArrayOfFloat, paramInt1 + paramInt2);
      }
      return arrayOfFloat;
      bool1 = false;
      break;
    }
  }
  
  public static int hashCode(float paramFloat)
  {
    return Float.valueOf(paramFloat).hashCode();
  }
  
  public static int indexOf(float[] paramArrayOfFloat, float paramFloat)
  {
    return indexOf(paramArrayOfFloat, paramFloat, 0, paramArrayOfFloat.length);
  }
  
  private static int indexOf(float[] paramArrayOfFloat, float paramFloat, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      if (paramArrayOfFloat[paramInt1] == paramFloat) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return -1;
  }
  
  public static int indexOf(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    Preconditions.checkNotNull(paramArrayOfFloat1, "array");
    Preconditions.checkNotNull(paramArrayOfFloat2, "target");
    if (paramArrayOfFloat2.length == 0) {
      return 0;
    }
    int i = 0;
    if (i < paramArrayOfFloat1.length - paramArrayOfFloat2.length + 1)
    {
      int j = 0;
      for (;;)
      {
        if (j >= paramArrayOfFloat2.length) {
          break label68;
        }
        if (paramArrayOfFloat1[(i + j)] != paramArrayOfFloat2[j])
        {
          i += 1;
          break;
        }
        j += 1;
      }
      label68:
      return i;
    }
    return -1;
  }
  
  public static boolean isFinite(float paramFloat)
  {
    int j = 1;
    int i;
    if ((1.0F / -1.0F) < paramFloat)
    {
      i = 1;
      if (paramFloat >= (1.0F / 1.0F)) {
        break label27;
      }
    }
    for (;;)
    {
      return j & i;
      i = 0;
      break;
      label27:
      j = 0;
    }
  }
  
  public static String join(String paramString, float... paramVarArgs)
  {
    Preconditions.checkNotNull(paramString);
    if (paramVarArgs.length == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 12);
    localStringBuilder.append(paramVarArgs[0]);
    int i = 1;
    while (i < paramVarArgs.length)
    {
      localStringBuilder.append(paramString).append(paramVarArgs[i]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static int lastIndexOf(float[] paramArrayOfFloat, float paramFloat)
  {
    return lastIndexOf(paramArrayOfFloat, paramFloat, 0, paramArrayOfFloat.length);
  }
  
  private static int lastIndexOf(float[] paramArrayOfFloat, float paramFloat, int paramInt1, int paramInt2)
  {
    paramInt2 -= 1;
    while (paramInt2 >= paramInt1)
    {
      if (paramArrayOfFloat[paramInt2] == paramFloat) {
        return paramInt2;
      }
      paramInt2 -= 1;
    }
    return -1;
  }
  
  public static Comparator<float[]> lexicographicalComparator()
  {
    return LexicographicalComparator.INSTANCE;
  }
  
  public static float max(float... paramVarArgs)
  {
    int i = 1;
    if (paramVarArgs.length > 0) {}
    float f;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      f = paramVarArgs[0];
      while (i < paramVarArgs.length)
      {
        f = Math.max(f, paramVarArgs[i]);
        i += 1;
      }
    }
    return f;
  }
  
  public static float min(float... paramVarArgs)
  {
    int i = 1;
    if (paramVarArgs.length > 0) {}
    float f;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      f = paramVarArgs[0];
      while (i < paramVarArgs.length)
      {
        f = Math.min(f, paramVarArgs[i]);
        i += 1;
      }
    }
    return f;
  }
  
  @Beta
  public static Converter<String, Float> stringConverter()
  {
    return FloatConverter.INSTANCE;
  }
  
  public static float[] toArray(Collection<? extends Number> paramCollection)
  {
    if ((paramCollection instanceof FloatArrayAsList)) {
      return ((FloatArrayAsList)paramCollection).toFloatArray();
    }
    paramCollection = paramCollection.toArray();
    int j = paramCollection.length;
    float[] arrayOfFloat = new float[j];
    int i = 0;
    while (i < j)
    {
      arrayOfFloat[i] = ((Number)Preconditions.checkNotNull(paramCollection[i])).floatValue();
      i += 1;
    }
    return arrayOfFloat;
  }
  
  @CheckForNull
  @Nullable
  @Beta
  @GwtIncompatible
  public static Float tryParse(String paramString)
  {
    if (Doubles.FLOATING_POINT_PATTERN.matcher(paramString).matches()) {
      try
      {
        float f = Float.parseFloat(paramString);
        return Float.valueOf(f);
      }
      catch (NumberFormatException paramString) {}
    }
    return null;
  }
  
  @GwtCompatible
  static class FloatArrayAsList
    extends AbstractList<Float>
    implements Serializable, RandomAccess
  {
    private static final long serialVersionUID = 0L;
    final float[] array;
    final int end;
    final int start;
    
    FloatArrayAsList(float[] paramArrayOfFloat)
    {
      this(paramArrayOfFloat, 0, paramArrayOfFloat.length);
    }
    
    FloatArrayAsList(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
    {
      this.array = paramArrayOfFloat;
      this.start = paramInt1;
      this.end = paramInt2;
    }
    
    public boolean contains(Object paramObject)
    {
      return ((paramObject instanceof Float)) && (Floats.indexOf(this.array, ((Float)paramObject).floatValue(), this.start, this.end) != -1);
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if (paramObject == this) {}
      for (;;)
      {
        return true;
        if (!(paramObject instanceof FloatArrayAsList)) {
          break;
        }
        paramObject = (FloatArrayAsList)paramObject;
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
    
    public Float get(int paramInt)
    {
      Preconditions.checkElementIndex(paramInt, size());
      return Float.valueOf(this.array[(this.start + paramInt)]);
    }
    
    public int hashCode()
    {
      int j = 1;
      int i = this.start;
      while (i < this.end)
      {
        j = j * 31 + Floats.hashCode(this.array[i]);
        i += 1;
      }
      return j;
    }
    
    public int indexOf(Object paramObject)
    {
      if ((paramObject instanceof Float))
      {
        int i = Floats.indexOf(this.array, ((Float)paramObject).floatValue(), this.start, this.end);
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
      if ((paramObject instanceof Float))
      {
        int i = Floats.lastIndexOf(this.array, ((Float)paramObject).floatValue(), this.start, this.end);
        if (i >= 0) {
          return i - this.start;
        }
      }
      return -1;
    }
    
    public Float set(int paramInt, Float paramFloat)
    {
      Preconditions.checkElementIndex(paramInt, size());
      float f = this.array[(this.start + paramInt)];
      this.array[(this.start + paramInt)] = ((Float)Preconditions.checkNotNull(paramFloat)).floatValue();
      return Float.valueOf(f);
    }
    
    public int size()
    {
      return this.end - this.start;
    }
    
    public List<Float> subList(int paramInt1, int paramInt2)
    {
      Preconditions.checkPositionIndexes(paramInt1, paramInt2, size());
      if (paramInt1 == paramInt2) {
        return Collections.emptyList();
      }
      return new FloatArrayAsList(this.array, this.start + paramInt1, this.start + paramInt2);
    }
    
    float[] toFloatArray()
    {
      int i = size();
      float[] arrayOfFloat = new float[i];
      System.arraycopy(this.array, this.start, arrayOfFloat, 0, i);
      return arrayOfFloat;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(size() * 12);
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
  
  static final class FloatConverter
    extends Converter<String, Float>
    implements Serializable
  {
    static final FloatConverter INSTANCE = new FloatConverter();
    private static final long serialVersionUID = 1L;
    
    private Object readResolve()
    {
      return INSTANCE;
    }
    
    protected String doBackward(Float paramFloat)
    {
      return paramFloat.toString();
    }
    
    protected Float doForward(String paramString)
    {
      return Float.valueOf(paramString);
    }
    
    public String toString()
    {
      return "Floats.stringConverter()";
    }
  }
  
  static enum LexicographicalComparator
    implements Comparator<float[]>
  {
    INSTANCE;
    
    private LexicographicalComparator() {}
    
    public int compare(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
    {
      int j = Math.min(paramArrayOfFloat1.length, paramArrayOfFloat2.length);
      int i = 0;
      while (i < j)
      {
        int k = Float.compare(paramArrayOfFloat1[i], paramArrayOfFloat2[i]);
        if (k != 0) {
          return k;
        }
        i += 1;
      }
      return paramArrayOfFloat1.length - paramArrayOfFloat2.length;
    }
    
    public String toString()
    {
      return "Floats.lexicographicalComparator()";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.primitives.Floats
 * JD-Core Version:    0.7.0.1
 */