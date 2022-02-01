package kotlin.ranges;

import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ranges/IntProgression;", "", "", "start", "endInclusive", "step", "(III)V", "first", "getFirst", "()I", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/IntIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public class IntProgression
  implements Iterable<Integer>, KMappedMarker
{
  public static final Companion Companion = new Companion(null);
  private final int first;
  private final int last;
  private final int step;
  
  public IntProgression(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0) {
      throw ((Throwable)new IllegalArgumentException("Step must be non-zero."));
    }
    if (paramInt3 == -2147483648) {
      throw ((Throwable)new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation."));
    }
    this.first = paramInt1;
    this.last = ProgressionUtilKt.getProgressionLastElement(paramInt1, paramInt2, paramInt3);
    this.step = paramInt3;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof IntProgression)) && (((isEmpty()) && (((IntProgression)paramObject).isEmpty())) || ((this.first == ((IntProgression)paramObject).first) && (this.last == ((IntProgression)paramObject).last) && (this.step == ((IntProgression)paramObject).step)));
  }
  
  public final int getFirst()
  {
    return this.first;
  }
  
  public final int getLast()
  {
    return this.last;
  }
  
  public final int getStep()
  {
    return this.step;
  }
  
  public int hashCode()
  {
    if (isEmpty()) {
      return -1;
    }
    return (this.first * 31 + this.last) * 31 + this.step;
  }
  
  public boolean isEmpty()
  {
    if (this.step > 0) {
      if (this.first <= this.last) {}
    }
    while (this.first < this.last)
    {
      return true;
      return false;
    }
    return false;
  }
  
  @NotNull
  public IntIterator iterator()
  {
    return (IntIterator)new IntProgressionIterator(this.first, this.last, this.step);
  }
  
  @NotNull
  public String toString()
  {
    if (this.step > 0) {
      return this.first + ".." + this.last + " step " + this.step;
    }
    return this.first + " downTo " + this.last + " step " + -this.step;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ranges/IntProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/IntProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    @NotNull
    public final IntProgression fromClosedRange(int paramInt1, int paramInt2, int paramInt3)
    {
      return new IntProgression(paramInt1, paramInt2, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.ranges.IntProgression
 * JD-Core Version:    0.7.0.1
 */