package kotlin.ranges;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ranges/IntRange;", "Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(II)V", "getEndInclusive", "()Ljava/lang/Integer;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class IntRange
  extends IntProgression
  implements ClosedRange<Integer>
{
  public static final Companion Companion = new Companion(null);
  @NotNull
  private static final IntRange EMPTY = new IntRange(1, 0);
  
  public IntRange(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2, 1);
  }
  
  public boolean contains(int paramInt)
  {
    return (getFirst() <= paramInt) && (paramInt <= getLast());
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof IntRange)) && (((isEmpty()) && (((IntRange)paramObject).isEmpty())) || ((getFirst() == ((IntRange)paramObject).getFirst()) && (getLast() == ((IntRange)paramObject).getLast())));
  }
  
  @NotNull
  public Integer getEndInclusive()
  {
    return Integer.valueOf(getLast());
  }
  
  @NotNull
  public Integer getStart()
  {
    return Integer.valueOf(getFirst());
  }
  
  public int hashCode()
  {
    if (isEmpty()) {
      return -1;
    }
    return getFirst() * 31 + getLast();
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
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ranges/IntRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/IntRange;", "getEMPTY", "()Lkotlin/ranges/IntRange;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    @NotNull
    public final IntRange getEMPTY()
    {
      return IntRange.access$getEMPTY$cp();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.ranges.IntRange
 * JD-Core Version:    0.7.0.1
 */