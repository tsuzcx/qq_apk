package kotlin.text;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.Grouping;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/text/StringsKt___StringsKt$groupingBy$1", "Lkotlin/collections/Grouping;", "", "keyOf", "element", "(C)Ljava/lang/Object;", "sourceIterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class StringsKt___StringsKt$groupingBy$1
  implements Grouping<Character, K>
{
  public StringsKt___StringsKt$groupingBy$1(CharSequence paramCharSequence, Function1 paramFunction1) {}
  
  public K keyOf(char paramChar)
  {
    return this.$keySelector.invoke(Character.valueOf(paramChar));
  }
  
  @NotNull
  public Iterator<Character> sourceIterator()
  {
    return (Iterator)StringsKt.iterator(this.$this_groupingBy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.text.StringsKt___StringsKt.groupingBy.1
 * JD-Core Version:    0.7.0.1
 */