package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible
public final class Stats
  implements Serializable
{
  static final int BYTES = 40;
  private static final long serialVersionUID = 0L;
  private final long count;
  private final double max;
  private final double mean;
  private final double min;
  private final double sumOfSquaresOfDeltas;
  
  Stats(long paramLong, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    this.count = paramLong;
    this.mean = paramDouble1;
    this.sumOfSquaresOfDeltas = paramDouble2;
    this.min = paramDouble3;
    this.max = paramDouble4;
  }
  
  public static Stats fromByteArray(byte[] paramArrayOfByte)
  {
    Preconditions.checkNotNull(paramArrayOfByte);
    if (paramArrayOfByte.length == 40) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Expected Stats.BYTES = %s remaining , got %s", 40, paramArrayOfByte.length);
      return readFrom(ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN));
    }
  }
  
  public static double meanOf(Iterable<? extends Number> paramIterable)
  {
    return meanOf(paramIterable.iterator());
  }
  
  public static double meanOf(Iterator<? extends Number> paramIterator)
  {
    Preconditions.checkArgument(paramIterator.hasNext());
    double d1 = ((Number)paramIterator.next()).doubleValue();
    long l = 1L;
    if (paramIterator.hasNext())
    {
      double d2 = ((Number)paramIterator.next()).doubleValue();
      l += 1L;
      if ((Doubles.isFinite(d2)) && (Doubles.isFinite(d1))) {}
      for (d1 = (d2 - d1) / l + d1;; d1 = StatsAccumulator.calculateNewMeanNonFinite(d1, d2)) {
        break;
      }
    }
    return d1;
  }
  
  public static double meanOf(double... paramVarArgs)
  {
    int i = 1;
    boolean bool;
    double d1;
    label20:
    double d2;
    if (paramVarArgs.length > 0)
    {
      bool = true;
      Preconditions.checkArgument(bool);
      d1 = paramVarArgs[0];
      if (i >= paramVarArgs.length) {
        return d1;
      }
      d2 = paramVarArgs[i];
      if ((!Doubles.isFinite(d2)) || (!Doubles.isFinite(d1))) {
        break label73;
      }
    }
    label73:
    for (d1 += (d2 - d1) / (i + 1);; d1 = StatsAccumulator.calculateNewMeanNonFinite(d1, d2))
    {
      i += 1;
      break label20;
      bool = false;
      break;
    }
    return d1;
  }
  
  public static double meanOf(int... paramVarArgs)
  {
    int i = 1;
    boolean bool;
    double d1;
    label21:
    double d2;
    if (paramVarArgs.length > 0)
    {
      bool = true;
      Preconditions.checkArgument(bool);
      d1 = paramVarArgs[0];
      if (i >= paramVarArgs.length) {
        return d1;
      }
      d2 = paramVarArgs[i];
      if ((!Doubles.isFinite(d2)) || (!Doubles.isFinite(d1))) {
        break label75;
      }
    }
    label75:
    for (d1 += (d2 - d1) / (i + 1);; d1 = StatsAccumulator.calculateNewMeanNonFinite(d1, d2))
    {
      i += 1;
      break label21;
      bool = false;
      break;
    }
    return d1;
  }
  
  public static double meanOf(long... paramVarArgs)
  {
    int i = 1;
    boolean bool;
    double d1;
    label21:
    double d2;
    if (paramVarArgs.length > 0)
    {
      bool = true;
      Preconditions.checkArgument(bool);
      d1 = paramVarArgs[0];
      if (i >= paramVarArgs.length) {
        return d1;
      }
      d2 = paramVarArgs[i];
      if ((!Doubles.isFinite(d2)) || (!Doubles.isFinite(d1))) {
        break label75;
      }
    }
    label75:
    for (d1 += (d2 - d1) / (i + 1);; d1 = StatsAccumulator.calculateNewMeanNonFinite(d1, d2))
    {
      i += 1;
      break label21;
      bool = false;
      break;
    }
    return d1;
  }
  
  public static Stats of(Iterable<? extends Number> paramIterable)
  {
    StatsAccumulator localStatsAccumulator = new StatsAccumulator();
    localStatsAccumulator.addAll(paramIterable);
    return localStatsAccumulator.snapshot();
  }
  
  public static Stats of(Iterator<? extends Number> paramIterator)
  {
    StatsAccumulator localStatsAccumulator = new StatsAccumulator();
    localStatsAccumulator.addAll(paramIterator);
    return localStatsAccumulator.snapshot();
  }
  
  public static Stats of(double... paramVarArgs)
  {
    StatsAccumulator localStatsAccumulator = new StatsAccumulator();
    localStatsAccumulator.addAll(paramVarArgs);
    return localStatsAccumulator.snapshot();
  }
  
  public static Stats of(int... paramVarArgs)
  {
    StatsAccumulator localStatsAccumulator = new StatsAccumulator();
    localStatsAccumulator.addAll(paramVarArgs);
    return localStatsAccumulator.snapshot();
  }
  
  public static Stats of(long... paramVarArgs)
  {
    StatsAccumulator localStatsAccumulator = new StatsAccumulator();
    localStatsAccumulator.addAll(paramVarArgs);
    return localStatsAccumulator.snapshot();
  }
  
  static Stats readFrom(ByteBuffer paramByteBuffer)
  {
    Preconditions.checkNotNull(paramByteBuffer);
    if (paramByteBuffer.remaining() >= 40) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Expected at least Stats.BYTES = %s remaining , got %s", 40, paramByteBuffer.remaining());
      return new Stats(paramByteBuffer.getLong(), paramByteBuffer.getDouble(), paramByteBuffer.getDouble(), paramByteBuffer.getDouble(), paramByteBuffer.getDouble());
    }
  }
  
  public long count()
  {
    return this.count;
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
      paramObject = (Stats)paramObject;
    } while ((this.count != paramObject.count) || (Double.doubleToLongBits(this.mean) != Double.doubleToLongBits(paramObject.mean)) || (Double.doubleToLongBits(this.sumOfSquaresOfDeltas) != Double.doubleToLongBits(paramObject.sumOfSquaresOfDeltas)) || (Double.doubleToLongBits(this.min) != Double.doubleToLongBits(paramObject.min)) || (Double.doubleToLongBits(this.max) != Double.doubleToLongBits(paramObject.max)));
    return true;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { Long.valueOf(this.count), Double.valueOf(this.mean), Double.valueOf(this.sumOfSquaresOfDeltas), Double.valueOf(this.min), Double.valueOf(this.max) });
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
  
  public double populationStandardDeviation()
  {
    return Math.sqrt(populationVariance());
  }
  
  public double populationVariance()
  {
    if (this.count > 0L) {}
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
    return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / count();
  }
  
  public double sampleStandardDeviation()
  {
    return Math.sqrt(sampleVariance());
  }
  
  public double sampleVariance()
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
  
  public double sum()
  {
    return this.mean * this.count;
  }
  
  double sumOfSquaresOfDeltas()
  {
    return this.sumOfSquaresOfDeltas;
  }
  
  public byte[] toByteArray()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(40).order(ByteOrder.LITTLE_ENDIAN);
    writeTo(localByteBuffer);
    return localByteBuffer.array();
  }
  
  public String toString()
  {
    if (count() > 0L) {
      return MoreObjects.toStringHelper(this).add("count", this.count).add("mean", this.mean).add("populationStandardDeviation", populationStandardDeviation()).add("min", this.min).add("max", this.max).toString();
    }
    return MoreObjects.toStringHelper(this).add("count", this.count).toString();
  }
  
  void writeTo(ByteBuffer paramByteBuffer)
  {
    Preconditions.checkNotNull(paramByteBuffer);
    if (paramByteBuffer.remaining() >= 40) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Expected at least Stats.BYTES = %s remaining , got %s", 40, paramByteBuffer.remaining());
      paramByteBuffer.putLong(this.count).putDouble(this.mean).putDouble(this.sumOfSquaresOfDeltas).putDouble(this.min).putDouble(this.max);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.math.Stats
 * JD-Core Version:    0.7.0.1
 */