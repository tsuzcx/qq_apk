package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "", "a", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k=3, mv={1, 1, 16})
final class ComparisonsKt__ComparisonsKt$nullsFirst$1<T>
  implements Comparator<T>
{
  ComparisonsKt__ComparisonsKt$nullsFirst$1(Comparator paramComparator) {}
  
  public final int compare(@Nullable T paramT1, @Nullable T paramT2)
  {
    if (paramT1 == paramT2) {
      return 0;
    }
    if (paramT1 == null) {
      return -1;
    }
    if (paramT2 == null) {
      return 1;
    }
    return this.$comparator.compare(paramT1, paramT2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.comparisons.ComparisonsKt__ComparisonsKt.nullsFirst.1
 * JD-Core Version:    0.7.0.1
 */