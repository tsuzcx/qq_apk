package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;

@Beta
@GwtIncompatible
public final class PairedStatsAccumulator
{
  private double sumOfProductsOfDeltas = 0.0D;
  private final StatsAccumulator xStats = new StatsAccumulator();
  private final StatsAccumulator yStats = new StatsAccumulator();
  
  private static double ensureInUnitRange(double paramDouble)
  {
    double d;
    if (paramDouble >= 1.0D) {
      d = 1.0D;
    }
    do
    {
      return d;
      d = paramDouble;
    } while (paramDouble > -1.0D);
    return -1.0D;
  }
  
  private double ensurePositive(double paramDouble)
  {
    if (paramDouble > 0.0D) {
      return paramDouble;
    }
    return 4.9E-324D;
  }
  
  public void add(double paramDouble1, double paramDouble2)
  {
    this.xStats.add(paramDouble1);
    if ((Doubles.isFinite(paramDouble1)) && (Doubles.isFinite(paramDouble2))) {
      if (this.xStats.count() <= 1L) {}
    }
    for (this.sumOfProductsOfDeltas += (paramDouble1 - this.xStats.mean()) * (paramDouble2 - this.yStats.mean());; this.sumOfProductsOfDeltas = (0.0D / 0.0D))
    {
      this.yStats.add(paramDouble2);
      return;
    }
  }
  
  public void addAll(PairedStats paramPairedStats)
  {
    if (paramPairedStats.count() == 0L) {
      return;
    }
    this.xStats.addAll(paramPairedStats.xStats());
    if (this.yStats.count() == 0L) {}
    for (this.sumOfProductsOfDeltas = paramPairedStats.sumOfProductsOfDeltas();; this.sumOfProductsOfDeltas += paramPairedStats.sumOfProductsOfDeltas() + (paramPairedStats.xStats().mean() - this.xStats.mean()) * (paramPairedStats.yStats().mean() - this.yStats.mean()) * paramPairedStats.count())
    {
      this.yStats.addAll(paramPairedStats.yStats());
      return;
    }
  }
  
  public long count()
  {
    return this.xStats.count();
  }
  
  public final LinearTransformation leastSquaresFit()
  {
    boolean bool2 = true;
    if (count() > 1L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Preconditions.checkState(bool1);
      if (!Double.isNaN(this.sumOfProductsOfDeltas)) {
        break;
      }
      return LinearTransformation.forNaN();
    }
    double d = this.xStats.sumOfSquaresOfDeltas();
    if (d > 0.0D)
    {
      if (this.yStats.sumOfSquaresOfDeltas() > 0.0D) {
        return LinearTransformation.mapping(this.xStats.mean(), this.yStats.mean()).withSlope(this.sumOfProductsOfDeltas / d);
      }
      return LinearTransformation.horizontal(this.yStats.mean());
    }
    if (this.yStats.sumOfSquaresOfDeltas() > 0.0D) {}
    for (bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkState(bool1);
      return LinearTransformation.vertical(this.xStats.mean());
    }
  }
  
  public final double pearsonsCorrelationCoefficient()
  {
    boolean bool2 = true;
    if (count() > 1L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Preconditions.checkState(bool1);
      if (!Double.isNaN(this.sumOfProductsOfDeltas)) {
        break;
      }
      return (0.0D / 0.0D);
    }
    double d1 = this.xStats.sumOfSquaresOfDeltas();
    double d2 = this.yStats.sumOfSquaresOfDeltas();
    if (d1 > 0.0D)
    {
      bool1 = true;
      Preconditions.checkState(bool1);
      if (d2 <= 0.0D) {
        break label112;
      }
    }
    label112:
    for (bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkState(bool1);
      d1 = ensurePositive(d1 * d2);
      return ensureInUnitRange(this.sumOfProductsOfDeltas / Math.sqrt(d1));
      bool1 = false;
      break;
    }
  }
  
  public double populationCovariance()
  {
    if (count() != 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool);
      return this.sumOfProductsOfDeltas / count();
    }
  }
  
  public final double sampleCovariance()
  {
    if (count() > 1L) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool);
      return this.sumOfProductsOfDeltas / (count() - 1L);
    }
  }
  
  public PairedStats snapshot()
  {
    return new PairedStats(this.xStats.snapshot(), this.yStats.snapshot(), this.sumOfProductsOfDeltas);
  }
  
  public Stats xStats()
  {
    return this.xStats.snapshot();
  }
  
  public Stats yStats()
  {
    return this.yStats.snapshot();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.math.PairedStatsAccumulator
 * JD-Core Version:    0.7.0.1
 */