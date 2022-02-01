package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lkotlin/ranges/IntRange;", "invoke"}, k=3, mv={1, 1, 16})
final class StringsKt__StringsKt$splitToSequence$2
  extends Lambda
  implements Function1<IntRange, String>
{
  StringsKt__StringsKt$splitToSequence$2(CharSequence paramCharSequence)
  {
    super(1);
  }
  
  @NotNull
  public final String invoke(@NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramIntRange, "it");
    return StringsKt.substring(this.$this_splitToSequence, paramIntRange);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.text.StringsKt__StringsKt.splitToSequence.2
 * JD-Core Version:    0.7.0.1
 */