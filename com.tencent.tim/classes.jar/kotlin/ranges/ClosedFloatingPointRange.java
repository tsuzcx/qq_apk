package kotlin.ranges;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ranges/ClosedFloatingPointRange;", "T", "", "Lkotlin/ranges/ClosedRange;", "contains", "", "value", "(Ljava/lang/Comparable;)Z", "isEmpty", "lessThanOrEquals", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Z", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.1")
public abstract interface ClosedFloatingPointRange<T extends Comparable<? super T>>
  extends ClosedRange<T>
{
  public abstract boolean contains(@NotNull T paramT);
  
  public abstract boolean isEmpty();
  
  public abstract boolean lessThanOrEquals(@NotNull T paramT1, @NotNull T paramT2);
  
  @Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
  public static final class DefaultImpls
  {
    public static <T extends Comparable<? super T>> boolean contains(ClosedFloatingPointRange<T> paramClosedFloatingPointRange, @NotNull T paramT)
    {
      Intrinsics.checkParameterIsNotNull(paramT, "value");
      return (paramClosedFloatingPointRange.lessThanOrEquals(paramClosedFloatingPointRange.getStart(), paramT)) && (paramClosedFloatingPointRange.lessThanOrEquals(paramT, paramClosedFloatingPointRange.getEndInclusive()));
    }
    
    public static <T extends Comparable<? super T>> boolean isEmpty(ClosedFloatingPointRange<T> paramClosedFloatingPointRange)
    {
      return !paramClosedFloatingPointRange.lessThanOrEquals(paramClosedFloatingPointRange.getStart(), paramClosedFloatingPointRange.getEndInclusive());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.ranges.ClosedFloatingPointRange
 * JD-Core Version:    0.7.0.1
 */