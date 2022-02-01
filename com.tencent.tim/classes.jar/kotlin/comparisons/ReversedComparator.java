package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/comparisons/ReversedComparator;", "T", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "(Ljava/util/Comparator;)V", "getComparator", "()Ljava/util/Comparator;", "compare", "", "a", "b", "(Ljava/lang/Object;Ljava/lang/Object;)I", "reversed", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class ReversedComparator<T>
  implements Comparator<T>
{
  @NotNull
  private final Comparator<T> comparator;
  
  public ReversedComparator(@NotNull Comparator<T> paramComparator)
  {
    this.comparator = paramComparator;
  }
  
  public int compare(T paramT1, T paramT2)
  {
    return this.comparator.compare(paramT2, paramT1);
  }
  
  @NotNull
  public final Comparator<T> getComparator()
  {
    return this.comparator;
  }
  
  @NotNull
  public final Comparator<T> reversed()
  {
    return this.comparator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.comparisons.ReversedComparator
 * JD-Core Version:    0.7.0.1
 */