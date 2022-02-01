package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "R", "it", "", "invoke"}, k=3, mv={1, 1, 16})
public final class SequencesKt___SequencesKt$filterIsInstance$1
  extends Lambda
  implements Function1<Object, Boolean>
{
  public static final 1 INSTANCE = new 1();
  
  public SequencesKt___SequencesKt$filterIsInstance$1()
  {
    super(1);
  }
  
  public final boolean invoke(@Nullable Object paramObject)
  {
    Intrinsics.reifiedOperationMarker(3, "R");
    return paramObject instanceof Object;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance.1
 * JD-Core Version:    0.7.0.1
 */