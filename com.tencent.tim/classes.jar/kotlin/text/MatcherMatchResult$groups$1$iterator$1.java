package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/text/MatchGroup;", "it", "", "invoke"}, k=3, mv={1, 1, 16})
final class MatcherMatchResult$groups$1$iterator$1
  extends Lambda
  implements Function1<Integer, MatchGroup>
{
  MatcherMatchResult$groups$1$iterator$1(MatcherMatchResult.groups.1 param1)
  {
    super(1);
  }
  
  @Nullable
  public final MatchGroup invoke(int paramInt)
  {
    return this.this$0.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.text.MatcherMatchResult.groups.1.iterator.1
 * JD-Core Version:    0.7.0.1
 */