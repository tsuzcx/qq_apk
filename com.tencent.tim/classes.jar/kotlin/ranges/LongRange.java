package kotlin.ranges;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ranges/LongRange;", "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(JJ)V", "getEndInclusive", "()Ljava/lang/Long;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class LongRange
  extends LongProgression
  implements ClosedRange<Long>
{
  public static final Companion Companion = new Companion(null);
  @NotNull
  private static final LongRange EMPTY = new LongRange(1L, 0L);
  
  public LongRange(long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2, 1L);
  }
  
  public boolean contains(long paramLong)
  {
    return (getFirst() <= paramLong) && (paramLong <= getLast());
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof LongRange)) && (((isEmpty()) && (((LongRange)paramObject).isEmpty())) || ((getFirst() == ((LongRange)paramObject).getFirst()) && (getLast() == ((LongRange)paramObject).getLast())));
  }
  
  @NotNull
  public Long getEndInclusive()
  {
    return Long.valueOf(getLast());
  }
  
  @NotNull
  public Long getStart()
  {
    return Long.valueOf(getFirst());
  }
  
  public int hashCode()
  {
    if (isEmpty()) {
      return -1;
    }
    return (int)(31 * (getFirst() ^ getFirst() >>> 32) + (getLast() ^ getLast() >>> 32));
  }
  
  public boolean isEmpty()
  {
    return getFirst() > getLast();
  }
  
  @NotNull
  public String toString()
  {
    return getFirst() + ".." + getLast();
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ranges/LongRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/LongRange;", "getEMPTY", "()Lkotlin/ranges/LongRange;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    @NotNull
    public final LongRange getEMPTY()
    {
      return LongRange.access$getEMPTY$cp();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.ranges.LongRange
 * JD-Core Version:    0.7.0.1
 */