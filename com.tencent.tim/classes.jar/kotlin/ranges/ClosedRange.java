package kotlin.ranges;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ranges/ClosedRange;", "T", "", "", "endInclusive", "getEndInclusive", "()Ljava/lang/Comparable;", "start", "getStart", "contains", "", "value", "(Ljava/lang/Comparable;)Z", "isEmpty", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract interface ClosedRange<T extends Comparable<? super T>>
{
  public abstract boolean contains(@NotNull T paramT);
  
  @NotNull
  public abstract T getEndInclusive();
  
  @NotNull
  public abstract T getStart();
  
  public abstract boolean isEmpty();
  
  @Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
  public static final class DefaultImpls
  {
    public static <T extends Comparable<? super T>> boolean contains(ClosedRange<T> paramClosedRange, @NotNull T paramT)
    {
      Intrinsics.checkParameterIsNotNull(paramT, "value");
      return (paramT.compareTo(paramClosedRange.getStart()) >= 0) && (paramT.compareTo(paramClosedRange.getEndInclusive()) <= 0);
    }
    
    public static <T extends Comparable<? super T>> boolean isEmpty(ClosedRange<T> paramClosedRange)
    {
      return paramClosedRange.getStart().compareTo(paramClosedRange.getEndInclusive()) > 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.ranges.ClosedRange
 * JD-Core Version:    0.7.0.1
 */