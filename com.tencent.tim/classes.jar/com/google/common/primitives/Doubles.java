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
public final class Doubles
{
  public static final int BYTES = 8;
  @GwtIncompatible
  static final Pattern FLOATING_POINT_PATTERN = ;
  
  public static List<Double> asList(double... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return Collections.emptyList();
    }
    return new DoubleArrayAsList(paramVarArgs);
  }
  
  public static int compare(double paramDouble1, double paramDouble2)
  {
    return Double.compare(paramDouble1, paramDouble2);
  }
  
  public static double[] concat(double[]... paramVarArgs)
  {
    int k = paramVarArgs.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += paramVarArgs[i].length;
      i += 1;
    }
    double[] arrayOfDouble1 = new double[j];
    k = paramVarArgs.length;
    i = 0;
    j = 0;
    while (i < k)
    {
      double[] arrayOfDouble2 = paramVarArgs[i];
      System.arraycopy(arrayOfDouble2, 0, arrayOfDouble1, j, arrayOfDouble2.length);
      j += arrayOfDouble2.length;
      i += 1;
    }
    return arrayOfDouble1;
  }
  
  public static boolean contains(double[] paramArrayOfDouble, double paramDouble)
  {
    boolean bool2 = false;
    int j = paramArrayOfDouble.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfDouble[i] == paramDouble) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static double[] ensureCapacity(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
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
      double[] arrayOfDouble = paramArrayOfDouble;
      if (paramArrayOfDouble.length < paramInt1) {
        arrayOfDouble = Arrays.copyOf(paramArrayOfDouble, paramInt1 + paramInt2);
      }
      return arrayOfDouble;
      bool1 = false;
      break;
    }
  }
  
  @GwtIncompatible
  private static Pattern fpPattern()
  {
    String str1 = "(?:\\d++(?:\\.\\d*+)?|\\.\\d++)" + "(?:[eE][+-]?\\d++)?[fFdD]?";
    String str2 = "0[xX]" + "(?:\\p{XDigit}++(?:\\.\\p{XDigit}*+)?|\\.\\p{XDigit}++)" + "[pP][+-]?\\d++[fFdD]?";
    return Pattern.compile("[+-]?(?:NaN|Infinity|" + str1 + "|" + str2 + ")");
  }
  
  public static int hashCode(double paramDouble)
  {
    return Double.valueOf(paramDouble).hashCode();
  }
  
  public static int indexOf(double[] paramArrayOfDouble, double paramDouble)
  {
    return indexOf(paramArrayOfDouble, paramDouble, 0, paramArrayOfDouble.length);
  }
  
  private static int indexOf(double[] paramArrayOfDouble, double paramDouble, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      if (paramArrayOfDouble[paramInt1] == paramDouble) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return -1;
  }
  
  public static int indexOf(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    Preconditions.checkNotNull(paramArrayOfDouble1, "array");
    Preconditions.checkNotNull(paramArrayOfDouble2, "target");
    if (paramArrayOfDouble2.length == 0) {
      return 0;
    }
    int i = 0;
    if (i < paramArrayOfDouble1.length - paramArrayOfDouble2.length + 1)
    {
      int j = 0;
      for (;;)
      {
        if (j >= paramArrayOfDouble2.length) {
          break label68;
        }
        if (paramArrayOfDouble1[(i + j)] != paramArrayOfDouble2[j])
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
  
  public static boolean isFinite(double paramDouble)
  {
    int j = 1;
    int i;
    if ((-1.0D / 0.0D) < paramDouble)
    {
      i = 1;
      if (paramDouble >= (1.0D / 0.0D)) {
        break label29;
      }
    }
    for (;;)
    {
      return j & i;
      i = 0;
      break;
      label29:
      j = 0;
    }
  }
  
  public static String join(String paramString, double... paramVarArgs)
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
  
  public static int lastIndexOf(double[] paramArrayOfDouble, double paramDouble)
  {
    return lastIndexOf(paramArrayOfDouble, paramDouble, 0, paramArrayOfDouble.length);
  }
  
  private static int lastIndexOf(double[] paramArrayOfDouble, double paramDouble, int paramInt1, int paramInt2)
  {
    paramInt2 -= 1;
    while (paramInt2 >= paramInt1)
    {
      if (paramArrayOfDouble[paramInt2] == paramDouble) {
        return paramInt2;
      }
      paramInt2 -= 1;
    }
    return -1;
  }
  
  public static Comparator<double[]> lexicographicalComparator()
  {
    return LexicographicalComparator.INSTANCE;
  }
  
  public static double max(double... paramVarArgs)
  {
    int i = 1;
    if (paramVarArgs.length > 0) {}
    double d;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      d = paramVarArgs[0];
      while (i < paramVarArgs.length)
      {
        d = Math.max(d, paramVarArgs[i]);
        i += 1;
      }
    }
    return d;
  }
  
  public static double min(double... paramVarArgs)
  {
    int i = 1;
    if (paramVarArgs.length > 0) {}
    double d;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      d = paramVarArgs[0];
      while (i < paramVarArgs.length)
      {
        d = Math.min(d, paramVarArgs[i]);
        i += 1;
      }
    }
    return d;
  }
  
  @Beta
  public static Converter<String, Double> stringConverter()
  {
    return DoubleConverter.INSTANCE;
  }
  
  public static double[] toArray(Collection<? extends Number> paramCollection)
  {
    if ((paramCollection instanceof DoubleArrayAsList)) {
      return ((DoubleArrayAsList)paramCollection).toDoubleArray();
    }
    paramCollection = paramCollection.toArray();
    int j = paramCollection.length;
    double[] arrayOfDouble = new double[j];
    int i = 0;
    while (i < j)
    {
      arrayOfDouble[i] = ((Number)Preconditions.checkNotNull(paramCollection[i])).doubleValue();
      i += 1;
    }
    return arrayOfDouble;
  }
  
  @CheckForNull
  @Nullable
  @Beta
  @GwtIncompatible
  public static Double tryParse(String paramString)
  {
    if (FLOATING_POINT_PATTERN.matcher(paramString).matches()) {
      try
      {
        double d = Double.parseDouble(paramString);
        return Double.valueOf(d);
      }
      catch (NumberFormatException paramString) {}
    }
    return null;
  }
  
  @GwtCompatible
  static class DoubleArrayAsList
    extends AbstractList<Double>
    implements Serializable, RandomAccess
  {
    private static final long serialVersionUID = 0L;
    final double[] array;
    final int end;
    final int start;
    
    DoubleArrayAsList(double[] paramArrayOfDouble)
    {
      this(paramArrayOfDouble, 0, paramArrayOfDouble.length);
    }
    
    DoubleArrayAsList(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
    {
      this.array = paramArrayOfDouble;
      this.start = paramInt1;
      this.end = paramInt2;
    }
    
    public boolean contains(Object paramObject)
    {
      return ((paramObject instanceof Double)) && (Doubles.indexOf(this.array, ((Double)paramObject).doubleValue(), this.start, this.end) != -1);
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if (paramObject == this) {}
      for (;;)
      {
        return true;
        if (!(paramObject instanceof DoubleArrayAsList)) {
          break;
        }
        paramObject = (DoubleArrayAsList)paramObject;
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
    
    public Double get(int paramInt)
    {
      Preconditions.checkElementIndex(paramInt, size());
      return Double.valueOf(this.array[(this.start + paramInt)]);
    }
    
    public int hashCode()
    {
      int j = 1;
      int i = this.start;
      while (i < this.end)
      {
        j = j * 31 + Doubles.hashCode(this.array[i]);
        i += 1;
      }
      return j;
    }
    
    public int indexOf(Object paramObject)
    {
      if ((paramObject instanceof Double))
      {
        int i = Doubles.indexOf(this.array, ((Double)paramObject).doubleValue(), this.start, this.end);
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
      if ((paramObject instanceof Double))
      {
        int i = Doubles.lastIndexOf(this.array, ((Double)paramObject).doubleValue(), this.start, this.end);
        if (i >= 0) {
          return i - this.start;
        }
      }
      return -1;
    }
    
    public Double set(int paramInt, Double paramDouble)
    {
      Preconditions.checkElementIndex(paramInt, size());
      double d = this.array[(this.start + paramInt)];
      this.array[(this.start + paramInt)] = ((Double)Preconditions.checkNotNull(paramDouble)).doubleValue();
      return Double.valueOf(d);
    }
    
    public int size()
    {
      return this.end - this.start;
    }
    
    public List<Double> subList(int paramInt1, int paramInt2)
    {
      Preconditions.checkPositionIndexes(paramInt1, paramInt2, size());
      if (paramInt1 == paramInt2) {
        return Collections.emptyList();
      }
      return new DoubleArrayAsList(this.array, this.start + paramInt1, this.start + paramInt2);
    }
    
    double[] toDoubleArray()
    {
      int i = size();
      double[] arrayOfDouble = new double[i];
      System.arraycopy(this.array, this.start, arrayOfDouble, 0, i);
      return arrayOfDouble;
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
  
  static final class DoubleConverter
    extends Converter<String, Double>
    implements Serializable
  {
    static final DoubleConverter INSTANCE = new DoubleConverter();
    private static final long serialVersionUID = 1L;
    
    private Object readResolve()
    {
      return INSTANCE;
    }
    
    protected String doBackward(Double paramDouble)
    {
      return paramDouble.toString();
    }
    
    protected Double doForward(String paramString)
    {
      return Double.valueOf(paramString);
    }
    
    public String toString()
    {
      return "Doubles.stringConverter()";
    }
  }
  
  static enum LexicographicalComparator
    implements Comparator<double[]>
  {
    INSTANCE;
    
    private LexicographicalComparator() {}
    
    public int compare(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
    {
      int j = Math.min(paramArrayOfDouble1.length, paramArrayOfDouble2.length);
      int i = 0;
      while (i < j)
      {
        int k = Double.compare(paramArrayOfDouble1[i], paramArrayOfDouble2[i]);
        if (k != 0) {
          return k;
        }
        i += 1;
      }
      return paramArrayOfDouble1.length - paramArrayOfDouble2.length;
    }
    
    public String toString()
    {
      return "Doubles.lexicographicalComparator()";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.primitives.Doubles
 * JD-Core Version:    0.7.0.1
 */