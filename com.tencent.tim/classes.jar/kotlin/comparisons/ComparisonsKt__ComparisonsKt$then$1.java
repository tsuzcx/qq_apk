package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k=3, mv={1, 1, 16})
final class ComparisonsKt__ComparisonsKt$then$1<T>
  implements Comparator<T>
{
  ComparisonsKt__ComparisonsKt$then$1(Comparator paramComparator1, Comparator paramComparator2) {}
  
  public final int compare(T paramT1, T paramT2)
  {
    int i = this.$this_then.compare(paramT1, paramT2);
    if (i != 0) {
      return i;
    }
    return this.$comparator.compare(paramT1, paramT2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.comparisons.ComparisonsKt__ComparisonsKt.then.1
 * JD-Core Version:    0.7.0.1
 */