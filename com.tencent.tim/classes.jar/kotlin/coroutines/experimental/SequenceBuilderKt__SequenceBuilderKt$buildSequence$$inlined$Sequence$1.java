package kotlin.coroutines.experimental;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class SequenceBuilderKt__SequenceBuilderKt$buildSequence$$inlined$Sequence$1
  implements Sequence<T>
{
  public SequenceBuilderKt__SequenceBuilderKt$buildSequence$$inlined$Sequence$1(Function2 paramFunction2) {}
  
  @NotNull
  public Iterator<T> iterator()
  {
    return SequenceBuilderKt.buildIterator(this.$builderAction$inlined);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.coroutines.experimental.SequenceBuilderKt__SequenceBuilderKt.buildSequence..inlined.Sequence.1
 * JD-Core Version:    0.7.0.1
 */