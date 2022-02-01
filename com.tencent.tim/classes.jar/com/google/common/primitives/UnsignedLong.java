package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.math.BigInteger;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
public final class UnsignedLong
  extends Number
  implements Serializable, Comparable<UnsignedLong>
{
  public static final UnsignedLong MAX_VALUE = new UnsignedLong(-1L);
  public static final UnsignedLong ONE;
  private static final long UNSIGNED_MASK = 9223372036854775807L;
  public static final UnsignedLong ZERO = new UnsignedLong(0L);
  private final long value;
  
  static
  {
    ONE = new UnsignedLong(1L);
  }
  
  private UnsignedLong(long paramLong)
  {
    this.value = paramLong;
  }
  
  public static UnsignedLong fromLongBits(long paramLong)
  {
    return new UnsignedLong(paramLong);
  }
  
  @CanIgnoreReturnValue
  public static UnsignedLong valueOf(long paramLong)
  {
    if (paramLong >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "value (%s) is outside the range for an unsigned long value", paramLong);
      return fromLongBits(paramLong);
    }
  }
  
  @CanIgnoreReturnValue
  public static UnsignedLong valueOf(String paramString)
  {
    return valueOf(paramString, 10);
  }
  
  @CanIgnoreReturnValue
  public static UnsignedLong valueOf(String paramString, int paramInt)
  {
    return fromLongBits(UnsignedLongs.parseUnsignedLong(paramString, paramInt));
  }
  
  @CanIgnoreReturnValue
  public static UnsignedLong valueOf(BigInteger paramBigInteger)
  {
    Preconditions.checkNotNull(paramBigInteger);
    if ((paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= 64)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "value (%s) is outside the range for an unsigned long value", paramBigInteger);
      return fromLongBits(paramBigInteger.longValue());
    }
  }
  
  public BigInteger bigIntegerValue()
  {
    BigInteger localBigInteger2 = BigInteger.valueOf(this.value & 0xFFFFFFFF);
    BigInteger localBigInteger1 = localBigInteger2;
    if (this.value < 0L) {
      localBigInteger1 = localBigInteger2.setBit(63);
    }
    return localBigInteger1;
  }
  
  public int compareTo(UnsignedLong paramUnsignedLong)
  {
    Preconditions.checkNotNull(paramUnsignedLong);
    return UnsignedLongs.compare(this.value, paramUnsignedLong.value);
  }
  
  public UnsignedLong dividedBy(UnsignedLong paramUnsignedLong)
  {
    return fromLongBits(UnsignedLongs.divide(this.value, ((UnsignedLong)Preconditions.checkNotNull(paramUnsignedLong)).value));
  }
  
  public double doubleValue()
  {
    double d2 = this.value & 0xFFFFFFFF;
    double d1 = d2;
    if (this.value < 0L) {
      d1 = d2 + 9.223372036854776E+018D;
    }
    return d1;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof UnsignedLong))
    {
      paramObject = (UnsignedLong)paramObject;
      bool1 = bool2;
      if (this.value == paramObject.value) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public float floatValue()
  {
    float f2 = (float)(this.value & 0xFFFFFFFF);
    float f1 = f2;
    if (this.value < 0L) {
      f1 = f2 + 9.223372E+018F;
    }
    return f1;
  }
  
  public int hashCode()
  {
    return Longs.hashCode(this.value);
  }
  
  public int intValue()
  {
    return (int)this.value;
  }
  
  public long longValue()
  {
    return this.value;
  }
  
  public UnsignedLong minus(UnsignedLong paramUnsignedLong)
  {
    return fromLongBits(this.value - ((UnsignedLong)Preconditions.checkNotNull(paramUnsignedLong)).value);
  }
  
  public UnsignedLong mod(UnsignedLong paramUnsignedLong)
  {
    return fromLongBits(UnsignedLongs.remainder(this.value, ((UnsignedLong)Preconditions.checkNotNull(paramUnsignedLong)).value));
  }
  
  public UnsignedLong plus(UnsignedLong paramUnsignedLong)
  {
    long l = this.value;
    return fromLongBits(((UnsignedLong)Preconditions.checkNotNull(paramUnsignedLong)).value + l);
  }
  
  public UnsignedLong times(UnsignedLong paramUnsignedLong)
  {
    long l = this.value;
    return fromLongBits(((UnsignedLong)Preconditions.checkNotNull(paramUnsignedLong)).value * l);
  }
  
  public String toString()
  {
    return UnsignedLongs.toString(this.value);
  }
  
  public String toString(int paramInt)
  {
    return UnsignedLongs.toString(this.value, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.primitives.UnsignedLong
 * JD-Core Version:    0.7.0.1
 */