package kotlin.text;

import kotlin.Metadata;
import kotlin.collections.CharIterator;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/text/StringsKt__StringsKt$iterator$1", "Lkotlin/collections/CharIterator;", "index", "", "hasNext", "", "nextChar", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class StringsKt__StringsKt$iterator$1
  extends CharIterator
{
  private int index;
  
  StringsKt__StringsKt$iterator$1(CharSequence paramCharSequence) {}
  
  public boolean hasNext()
  {
    return this.index < this.$this_iterator.length();
  }
  
  public char nextChar()
  {
    CharSequence localCharSequence = this.$this_iterator;
    int i = this.index;
    this.index = (i + 1);
    return localCharSequence.charAt(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.text.StringsKt__StringsKt.iterator.1
 * JD-Core Version:    0.7.0.1
 */