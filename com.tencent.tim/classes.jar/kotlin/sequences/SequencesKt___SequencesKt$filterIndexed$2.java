package kotlin.sequences;

import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "T", "it", "Lkotlin/collections/IndexedValue;", "invoke", "(Lkotlin/collections/IndexedValue;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
final class SequencesKt___SequencesKt$filterIndexed$2
  extends Lambda
  implements Function1<IndexedValue<? extends T>, T>
{
  public static final 2 INSTANCE = new 2();
  
  SequencesKt___SequencesKt$filterIndexed$2()
  {
    super(1);
  }
  
  public final T invoke(@NotNull IndexedValue<? extends T> paramIndexedValue)
  {
    Intrinsics.checkParameterIsNotNull(paramIndexedValue, "it");
    return paramIndexedValue.getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.sequences.SequencesKt___SequencesKt.filterIndexed.2
 * JD-Core Version:    0.7.0.1
 */