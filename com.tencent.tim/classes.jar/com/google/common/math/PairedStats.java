package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible
public final class PairedStats
  implements Serializable
{
  private static final int BYTES = 88;
  private static final long serialVersionUID = 0L;
  private final double sumOfProductsOfDeltas;
  private final Stats xStats;
  private final Stats yStats;
  
  PairedStats(Stats paramStats1, Stats paramStats2, double paramDouble)
  {
    this.xStats = paramStats1;
    this.yStats = paramStats2;
    this.sumOfProductsOfDeltas = paramDouble;
  }
  
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
  
  private static double ensurePositive(double paramDouble)
  {
    if (paramDouble > 0.0D) {
      return paramDouble;
    }
    return 4.9E-324D;
  }
  
  public static PairedStats fromByteArray(byte[] paramArrayOfByte)
  {
    Preconditions.checkNotNull(paramArrayOfByte);
    if (paramArrayOfByte.length == 88) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Expected PairedStats.BYTES = %s, got %s", 88, paramArrayOfByte.length);
      paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN);
      return new PairedStats(Stats.readFrom(paramArrayOfByte), Stats.readFrom(paramArrayOfByte), paramArrayOfByte.getDouble());
    }
  }
  
  public long count()
  {
    return this.xStats.count();
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
      } while (getClass() != paramObject.getClass());
      paramObject = (PairedStats)paramObject;
    } while ((!this.xStats.equals(paramObject.xStats)) || (!this.yStats.equals(paramObject.yStats)) || (Double.doubleToLongBits(this.sumOfProductsOfDeltas) != Double.doubleToLongBits(paramObject.sumOfProductsOfDeltas)));
    return true;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.xStats, this.yStats, Double.valueOf(this.sumOfProductsOfDeltas) });
  }
  
  public LinearTransformation leastSquaresFit()
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
  
  public double pearsonsCorrelationCoefficient()
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
    double d1 = xStats().sumOfSquaresOfDeltas();
    double d2 = yStats().sumOfSquaresOfDeltas();
    if (d1 > 0.0D)
    {
      bool1 = true;
      Preconditions.checkState(bool1);
      if (d2 <= 0.0D) {
        break label111;
      }
    }
    label111:
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
  
  public double sampleCovariance()
  {
    if (count() > 1L) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool);
      return this.sumOfProductsOfDeltas / (count() - 1L);
    }
  }
  
  double sumOfProductsOfDeltas()
  {
    return this.sumOfProductsOfDeltas;
  }
  
  public byte[] toByteArray()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(88).order(ByteOrder.LITTLE_ENDIAN);
    this.xStats.writeTo(localByteBuffer);
    this.yStats.writeTo(localByteBuffer);
    localByteBuffer.putDouble(this.sumOfProductsOfDeltas);
    return localByteBuffer.array();
  }
  
  public String toString()
  {
    if (count() > 0L) {
      return MoreObjects.toStringHelper(this).add("xStats", this.xStats).add("yStats", this.yStats).add("populationCovariance", populationCovariance()).toString();
    }
    return MoreObjects.toStringHelper(this).add("xStats", this.xStats).add("yStats", this.yStats).toString();
  }
  
  public Stats xStats()
  {
    return this.xStats;
  }
  
  public Stats yStats()
  {
    return this.yStats;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.math.PairedStats
 * JD-Core Version:    0.7.0.1
 */