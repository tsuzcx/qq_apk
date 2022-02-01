package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class SlidingWindowKt$windowedSequence$$inlined$Sequence$1
  implements Sequence<List<? extends T>>
{
  public SlidingWindowKt$windowedSequence$$inlined$Sequence$1(Sequence paramSequence, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {}
  
  @NotNull
  public Iterator<List<? extends T>> iterator()
  {
    return SlidingWindowKt.windowedIterator(this.$this_windowedSequence$inlined.iterator(), this.$size$inlined, this.$step$inlined, this.$partialWindows$inlined, this.$reuseBuffer$inlined);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.collections.SlidingWindowKt.windowedSequence..inlined.Sequence.1
 * JD-Core Version:    0.7.0.1
 */