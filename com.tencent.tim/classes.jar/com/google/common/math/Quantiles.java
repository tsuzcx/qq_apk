package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Beta
@GwtIncompatible
public final class Quantiles
{
  private static void checkIndex(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > paramInt2)) {
      throw new IllegalArgumentException("Quantile indexes must be between 0 and the scale, which is " + paramInt2);
    }
  }
  
  private static int chooseNextSelection(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 == paramInt2) {
      return paramInt1;
    }
    int j = paramInt3 + paramInt4 >>> 1;
    int i = paramInt2;
    paramInt2 = paramInt1;
    paramInt1 = i;
    if (paramInt1 > paramInt2 + 1)
    {
      i = paramInt2 + paramInt1 >>> 1;
      if (paramArrayOfInt[i] > j) {
        paramInt1 = i;
      }
      for (;;)
      {
        break;
        if (paramArrayOfInt[i] >= j) {
          break label67;
        }
        paramInt2 = i;
      }
      label67:
      return i;
    }
    if (paramInt3 + paramInt4 - paramArrayOfInt[paramInt2] - paramArrayOfInt[paramInt1] > 0) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  private static boolean containsNaN(double... paramVarArgs)
  {
    boolean bool2 = false;
    int j = paramVarArgs.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (Double.isNaN(paramVarArgs[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private static double interpolate(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    double d = (-1.0D / 0.0D);
    if (paramDouble1 == (-1.0D / 0.0D))
    {
      paramDouble1 = d;
      if (paramDouble2 == (1.0D / 0.0D)) {
        paramDouble1 = (0.0D / 0.0D);
      }
      return paramDouble1;
    }
    if (paramDouble2 == (1.0D / 0.0D)) {
      return (1.0D / 0.0D);
    }
    return (paramDouble2 - paramDouble1) * paramDouble3 / paramDouble4 + paramDouble1;
  }
  
  private static double[] intsToDoubles(int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    double[] arrayOfDouble = new double[j];
    int i = 0;
    while (i < j)
    {
      arrayOfDouble[i] = paramArrayOfInt[i];
      i += 1;
    }
    return arrayOfDouble;
  }
  
  private static double[] longsToDoubles(long[] paramArrayOfLong)
  {
    int j = paramArrayOfLong.length;
    double[] arrayOfDouble = new double[j];
    int i = 0;
    while (i < j)
    {
      arrayOfDouble[i] = paramArrayOfLong[i];
      i += 1;
    }
    return arrayOfDouble;
  }
  
  public static ScaleAndIndex median()
  {
    return scale(2).index(1);
  }
  
  private static void movePivotToStartOfSlice(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
  {
    int k = 1;
    int m = paramInt1 + paramInt2 >>> 1;
    int i;
    int j;
    if (paramArrayOfDouble[paramInt2] < paramArrayOfDouble[m])
    {
      i = 1;
      if (paramArrayOfDouble[m] >= paramArrayOfDouble[paramInt1]) {
        break label66;
      }
      j = 1;
      label37:
      if (paramArrayOfDouble[paramInt2] >= paramArrayOfDouble[paramInt1]) {
        break label72;
      }
      label47:
      if (i != j) {
        break label78;
      }
      swap(paramArrayOfDouble, m, paramInt1);
    }
    label66:
    label72:
    label78:
    while (i == k)
    {
      return;
      i = 0;
      break;
      j = 0;
      break label37;
      k = 0;
      break label47;
    }
    swap(paramArrayOfDouble, paramInt1, paramInt2);
  }
  
  private static int partition(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
  {
    movePivotToStartOfSlice(paramArrayOfDouble, paramInt1, paramInt2);
    double d = paramArrayOfDouble[paramInt1];
    int j;
    for (int i = paramInt2; paramInt2 > paramInt1; i = j)
    {
      j = i;
      if (paramArrayOfDouble[paramInt2] > d)
      {
        swap(paramArrayOfDouble, i, paramInt2);
        j = i - 1;
      }
      paramInt2 -= 1;
    }
    swap(paramArrayOfDouble, paramInt1, i);
    return i;
  }
  
  public static Scale percentiles()
  {
    return scale(100);
  }
  
  public static Scale quartiles()
  {
    return scale(4);
  }
  
  public static Scale scale(int paramInt)
  {
    return new Scale(paramInt, null);
  }
  
  private static void selectAllInPlace(int[] paramArrayOfInt, int paramInt1, int paramInt2, double[] paramArrayOfDouble, int paramInt3, int paramInt4)
  {
    int k = chooseNextSelection(paramArrayOfInt, paramInt1, paramInt2, paramInt3, paramInt4);
    int j = paramArrayOfInt[k];
    selectInPlace(j, paramArrayOfDouble, paramInt3, paramInt4);
    int i = k - 1;
    while ((i >= paramInt1) && (paramArrayOfInt[i] == j)) {
      i -= 1;
    }
    if (i >= paramInt1) {
      selectAllInPlace(paramArrayOfInt, paramInt1, i, paramArrayOfDouble, paramInt3, j - 1);
    }
    paramInt1 = k + 1;
    while ((paramInt1 <= paramInt2) && (paramArrayOfInt[paramInt1] == j)) {
      paramInt1 += 1;
    }
    if (paramInt1 <= paramInt2) {
      selectAllInPlace(paramArrayOfInt, paramInt1, paramInt2, paramArrayOfDouble, j + 1, paramInt4);
    }
  }
  
  private static void selectInPlace(int paramInt1, double[] paramArrayOfDouble, int paramInt2, int paramInt3)
  {
    int i;
    int j;
    if (paramInt1 == paramInt2)
    {
      paramInt1 = paramInt2 + 1;
      for (i = paramInt2; paramInt1 <= paramInt3; i = j)
      {
        j = i;
        if (paramArrayOfDouble[i] > paramArrayOfDouble[paramInt1]) {
          j = paramInt1;
        }
        paramInt1 += 1;
      }
      if (i != paramInt2) {
        swap(paramArrayOfDouble, i, paramInt2);
      }
    }
    for (;;)
    {
      return;
      while (i > paramInt2)
      {
        j = partition(paramArrayOfDouble, paramInt2, i);
        paramInt3 = i;
        if (j >= paramInt1) {
          paramInt3 = j - 1;
        }
        i = paramInt3;
        if (j <= paramInt1)
        {
          paramInt2 = j + 1;
          i = paramInt3;
          continue;
          i = paramInt3;
        }
      }
    }
  }
  
  private static void swap(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
  {
    double d = paramArrayOfDouble[paramInt1];
    paramArrayOfDouble[paramInt1] = paramArrayOfDouble[paramInt2];
    paramArrayOfDouble[paramInt2] = d;
  }
  
  public static final class Scale
  {
    private final int scale;
    
    private Scale(int paramInt)
    {
      if (paramInt > 0) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "Quantile scale must be positive");
        this.scale = paramInt;
        return;
      }
    }
    
    public Quantiles.ScaleAndIndex index(int paramInt)
    {
      return new Quantiles.ScaleAndIndex(this.scale, paramInt, null);
    }
    
    public Quantiles.ScaleAndIndexes indexes(Collection<Integer> paramCollection)
    {
      return new Quantiles.ScaleAndIndexes(this.scale, Ints.toArray(paramCollection), null);
    }
    
    public Quantiles.ScaleAndIndexes indexes(int... paramVarArgs)
    {
      return new Quantiles.ScaleAndIndexes(this.scale, (int[])paramVarArgs.clone(), null);
    }
  }
  
  public static final class ScaleAndIndex
  {
    private final int index;
    private final int scale;
    
    private ScaleAndIndex(int paramInt1, int paramInt2)
    {
      Quantiles.checkIndex(paramInt2, paramInt1);
      this.scale = paramInt1;
      this.index = paramInt2;
    }
    
    public double compute(Collection<? extends Number> paramCollection)
    {
      return computeInPlace(Doubles.toArray(paramCollection));
    }
    
    public double compute(double... paramVarArgs)
    {
      return computeInPlace((double[])paramVarArgs.clone());
    }
    
    public double compute(int... paramVarArgs)
    {
      return computeInPlace(Quantiles.intsToDoubles(paramVarArgs));
    }
    
    public double compute(long... paramVarArgs)
    {
      return computeInPlace(Quantiles.longsToDoubles(paramVarArgs));
    }
    
    public double computeInPlace(double... paramVarArgs)
    {
      if (paramVarArgs.length > 0) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "Cannot calculate quantiles of an empty dataset");
        if (!Quantiles.containsNaN(paramVarArgs)) {
          break;
        }
        return (0.0D / 0.0D);
      }
      long l = this.index * (paramVarArgs.length - 1);
      int i = (int)LongMath.divide(l, this.scale, RoundingMode.DOWN);
      int j = (int)(l - i * this.scale);
      Quantiles.selectInPlace(i, paramVarArgs, 0, paramVarArgs.length - 1);
      if (j == 0) {
        return paramVarArgs[i];
      }
      Quantiles.selectInPlace(i + 1, paramVarArgs, i + 1, paramVarArgs.length - 1);
      return Quantiles.interpolate(paramVarArgs[i], paramVarArgs[(i + 1)], j, this.scale);
    }
  }
  
  public static final class ScaleAndIndexes
  {
    private final int[] indexes;
    private final int scale;
    
    private ScaleAndIndexes(int paramInt, int[] paramArrayOfInt)
    {
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        Quantiles.checkIndex(paramArrayOfInt[i], paramInt);
        i += 1;
      }
      this.scale = paramInt;
      this.indexes = paramArrayOfInt;
    }
    
    public Map<Integer, Double> compute(Collection<? extends Number> paramCollection)
    {
      return computeInPlace(Doubles.toArray(paramCollection));
    }
    
    public Map<Integer, Double> compute(double... paramVarArgs)
    {
      return computeInPlace((double[])paramVarArgs.clone());
    }
    
    public Map<Integer, Double> compute(int... paramVarArgs)
    {
      return computeInPlace(Quantiles.intsToDoubles(paramVarArgs));
    }
    
    public Map<Integer, Double> compute(long... paramVarArgs)
    {
      return computeInPlace(Quantiles.longsToDoubles(paramVarArgs));
    }
    
    public Map<Integer, Double> computeInPlace(double... paramVarArgs)
    {
      if (paramVarArgs.length > 0) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "Cannot calculate quantiles of an empty dataset");
        if (!Quantiles.containsNaN(paramVarArgs)) {
          break label85;
        }
        paramVarArgs = new HashMap();
        arrayOfInt1 = this.indexes;
        j = arrayOfInt1.length;
        i = 0;
        while (i < j)
        {
          paramVarArgs.put(Integer.valueOf(arrayOfInt1[i]), Double.valueOf((0.0D / 0.0D)));
          i += 1;
        }
      }
      return Collections.unmodifiableMap(paramVarArgs);
      label85:
      int[] arrayOfInt1 = new int[this.indexes.length];
      int[] arrayOfInt2 = new int[this.indexes.length];
      Object localObject = new int[this.indexes.length * 2];
      int i = 0;
      int j = 0;
      int k;
      while (j < this.indexes.length)
      {
        long l = this.indexes[j] * (paramVarArgs.length - 1);
        int m = (int)LongMath.divide(l, this.scale, RoundingMode.DOWN);
        int n = (int)(l - m * this.scale);
        arrayOfInt1[j] = m;
        arrayOfInt2[j] = n;
        localObject[i] = m;
        k = i + 1;
        i = k;
        if (n != 0)
        {
          localObject[k] = (m + 1);
          i = k + 1;
        }
        j += 1;
      }
      Arrays.sort((int[])localObject, 0, i);
      Quantiles.selectAllInPlace((int[])localObject, 0, i - 1, paramVarArgs, 0, paramVarArgs.length - 1);
      localObject = new HashMap();
      i = 0;
      if (i < this.indexes.length)
      {
        j = arrayOfInt1[i];
        k = arrayOfInt2[i];
        if (k == 0) {
          ((Map)localObject).put(Integer.valueOf(this.indexes[i]), Double.valueOf(paramVarArgs[j]));
        }
        for (;;)
        {
          i += 1;
          break;
          ((Map)localObject).put(Integer.valueOf(this.indexes[i]), Double.valueOf(Quantiles.interpolate(paramVarArgs[j], paramVarArgs[(j + 1)], k, this.scale)));
        }
      }
      return Collections.unmodifiableMap((Map)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.math.Quantiles
 * JD-Core Version:    0.7.0.1
 */