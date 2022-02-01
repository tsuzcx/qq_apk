package kotlin.sequences;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/Pair;", "T", "R", "t1", "t2", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;"}, k=3, mv={1, 1, 16})
final class SequencesKt___SequencesKt$zip$1
  extends Lambda
  implements Function2<T, R, Pair<? extends T, ? extends R>>
{
  public static final 1 INSTANCE = new 1();
  
  SequencesKt___SequencesKt$zip$1()
  {
    super(2);
  }
  
  @NotNull
  public final Pair<T, R> invoke(T paramT, R paramR)
  {
    return TuplesKt.to(paramT, paramR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.sequences.SequencesKt___SequencesKt.zip.1
 * JD-Core Version:    0.7.0.1
 */