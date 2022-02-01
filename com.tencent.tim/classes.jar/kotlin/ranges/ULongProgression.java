package kotlin.ranges;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.collections.ULongIterator;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ranges/ULongProgression;", "", "Lkotlin/ULong;", "start", "endInclusive", "step", "", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "first", "getFirst", "()J", "J", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "", "isEmpty", "iterator", "Lkotlin/collections/ULongIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@ExperimentalUnsignedTypes
@SinceKotlin(version="1.3")
public class ULongProgression
  implements Iterable<ULong>, KMappedMarker
{
  public static final Companion Companion = new Companion(null);
  private final long first;
  private final long last;
  private final long step;
  
  private ULongProgression(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong3 == 0L) {
      throw ((Throwable)new IllegalArgumentException("Step must be non-zero."));
    }
    if (paramLong3 == -9223372036854775808L) {
      throw ((Throwable)new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation."));
    }
    this.first = paramLong1;
    this.last = UProgressionUtilKt.getProgressionLastElement-7ftBX0g(paramLong1, paramLong2, paramLong3);
    this.step = paramLong3;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof ULongProgression)) && (((isEmpty()) && (((ULongProgression)paramObject).isEmpty())) || ((this.first == ((ULongProgression)paramObject).first) && (this.last == ((ULongProgression)paramObject).last) && (this.step == ((ULongProgression)paramObject).step)));
  }
  
  public final long getFirst()
  {
    return this.first;
  }
  
  public final long getLast()
  {
    return this.last;
  }
  
  public final long getStep()
  {
    return this.step;
  }
  
  public int hashCode()
  {
    if (isEmpty()) {
      return -1;
    }
    return ((int)ULong.constructor-impl(this.first ^ ULong.constructor-impl(this.first >>> 32)) * 31 + (int)ULong.constructor-impl(this.last ^ ULong.constructor-impl(this.last >>> 32))) * 31 + (int)(this.step ^ this.step >>> 32);
  }
  
  public boolean isEmpty()
  {
    if (this.step > 0L) {
      if (UnsignedKt.ulongCompare(this.first, this.last) <= 0) {}
    }
    while (UnsignedKt.ulongCompare(this.first, this.last) < 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  @NotNull
  public ULongIterator iterator()
  {
    return (ULongIterator)new ULongProgressionIterator(this.first, this.last, this.step, null);
  }
  
  @NotNull
  public String toString()
  {
    if (this.step > 0L) {
      return ULong.toString-impl(this.first) + ".." + ULong.toString-impl(this.last) + " step " + this.step;
    }
    return ULong.toString-impl(this.first) + " downTo " + ULong.toString-impl(this.last) + " step " + -this.step;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ranges/ULongProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/ULongProgression;", "rangeStart", "Lkotlin/ULong;", "rangeEnd", "step", "", "fromClosedRange-7ftBX0g", "(JJJ)Lkotlin/ranges/ULongProgression;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    @NotNull
    public final ULongProgression fromClosedRange-7ftBX0g(long paramLong1, long paramLong2, long paramLong3)
    {
      return new ULongProgression(paramLong1, paramLong2, paramLong3, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.ranges.ULongProgression
 * JD-Core Version:    0.7.0.1
 */