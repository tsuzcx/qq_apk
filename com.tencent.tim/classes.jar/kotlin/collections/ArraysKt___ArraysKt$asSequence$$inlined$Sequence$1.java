package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class ArraysKt___ArraysKt$asSequence$$inlined$Sequence$1
  implements Sequence<T>
{
  public ArraysKt___ArraysKt$asSequence$$inlined$Sequence$1(Object[] paramArrayOfObject) {}
  
  @NotNull
  public Iterator<T> iterator()
  {
    return ArrayIteratorKt.iterator(this.$this_asSequence$inlined);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.collections.ArraysKt___ArraysKt.asSequence..inlined.Sequence.1
 * JD-Core Version:    0.7.0.1
 */