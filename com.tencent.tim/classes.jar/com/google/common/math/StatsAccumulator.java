package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import java.util.Iterator;

@Beta
@GwtIncompatible
public final class StatsAccumulator
{
  private long count = 0L;
  private double max = (0.0D / 0.0D);
  private double mean = 0.0D;
  private double min = (0.0D / 0.0D);
  private double sumOfSquaresOfDeltas = 0.0D;
  
  static double calculateNewMeanNonFinite(double paramDouble1, double paramDouble2)
  {
    if (Doubles.isFinite(paramDouble1)) {
      return paramDouble2;
    }
    if ((Doubles.isFinite(paramDouble2)) || (paramDouble1 == paramDouble2)) {
      return paramDouble1;
    }
    return (0.0D / 0.0D);
  }
  
  public void add(double paramDouble)
  {
    if (this.count == 0L)
    {
      this.count = 1L;
      this.mean = paramDouble;
      this.min = paramDouble;
      this.max = paramDouble;
      if (!Doubles.isFinite(paramDouble)) {
        this.sumOfSquaresOfDeltas = (0.0D / 0.0D);
      }
      return;
    }
    this.count += 1L;
    double d1;
    double d2;
    if ((Doubles.isFinite(paramDouble)) && (Doubles.isFinite(this.mean)))
    {
      d1 = paramDouble - this.mean;
      this.mean += d1 / this.count;
      d2 = this.sumOfSquaresOfDeltas;
    }
    for (this.sumOfSquaresOfDeltas = (d1 * (paramDouble - this.mean) + d2);; this.sumOfSquaresOfDeltas = (0.0D / 0.0D))
    {
      this.min = Math.min(this.min, paramDouble);
      this.max = Math.max(this.max, paramDouble);
      return;
      this.mean = calculateNewMeanNonFinite(this.mean, paramDouble);
    }
  }
  
  public void addAll(Stats paramStats)
  {
    if (paramStats.count() == 0L) {
      return;
    }
    if (this.count == 0L)
    {
      this.count = paramStats.count();
      this.mean = paramStats.mean();
      this.sumOfSquaresOfDeltas = paramStats.sumOfSquaresOfDeltas();
      this.min = paramStats.min();
      this.max = paramStats.max();
      return;
    }
    this.count += paramStats.count();
    double d1;
    double d2;
    double d3;
    if ((Doubles.isFinite(this.mean)) && (Doubles.isFinite(paramStats.mean())))
    {
      d1 = paramStats.mean() - this.mean;
      this.mean += paramStats.count() * d1 / this.count;
      d2 = this.sumOfSquaresOfDeltas;
      d3 = paramStats.sumOfSquaresOfDeltas();
    }
    for (this.sumOfSquaresOfDeltas = (d1 * (paramStats.mean() - this.mean) * paramStats.count() + d3 + d2);; this.sumOfSquaresOfDeltas = (0.0D / 0.0D))
    {
      this.min = Math.min(this.min, paramStats.min());
      this.max = Math.max(this.max, paramStats.max());
      return;
      this.mean = calculateNewMeanNonFinite(this.mean, paramStats.mean());
    }
  }
  
  public void addAll(Iterable<? extends Number> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      add(((Number)paramIterable.next()).doubleValue());
    }
  }
  
  public void addAll(Iterator<? extends Number> paramIterator)
  {
    while (paramIterator.hasNext()) {
      add(((Number)paramIterator.next()).doubleValue());
    }
  }
  
  public void addAll(double... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      add(paramVarArgs[i]);
      i += 1;
    }
  }
  
  public void addAll(int... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      add(paramVarArgs[i]);
      i += 1;
    }
  }
  
  public void addAll(long... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      add(paramVarArgs[i]);
      i += 1;
    }
  }
  
  public long count()
  {
    return this.count;
  }
  
  public double max()
  {
    if (this.count != 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool);
      return this.max;
    }
  }
  
  public double mean()
  {
    if (this.count != 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool);
      return this.mean;
    }
  }
  
  public double min()
  {
    if (this.count != 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool);
      return this.min;
    }
  }
  
  public final double populationStandardDeviation()
  {
    return Math.sqrt(populationVariance());
  }
  
  public final double populationVariance()
  {
    if (this.count != 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool);
      if (!Double.isNaN(this.sumOfSquaresOfDeltas)) {
        break;
      }
      return (0.0D / 0.0D);
    }
    if (this.count == 1L) {
      return 0.0D;
    }
    return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / this.count;
  }
  
  public final double sampleStandardDeviation()
  {
    return Math.sqrt(sampleVariance());
  }
  
  public final double sampleVariance()
  {
    if (this.count > 1L) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool);
      if (!Double.isNaN(this.sumOfSquaresOfDeltas)) {
        break;
      }
      return (0.0D / 0.0D);
    }
    return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / (this.count - 1L);
  }
  
  public Stats snapshot()
  {
    return new Stats(this.count, this.mean, this.sumOfSquaresOfDeltas, this.min, this.max);
  }
  
  public final double sum()
  {
    return this.mean * this.count;
  }
  
  double sumOfSquaresOfDeltas()
  {
    return this.sumOfSquaresOfDeltas;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.math.StatsAccumulator
 * JD-Core Version:    0.7.0.1
 */