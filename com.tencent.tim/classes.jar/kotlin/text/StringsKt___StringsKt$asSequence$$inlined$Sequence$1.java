package kotlin.text;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class StringsKt___StringsKt$asSequence$$inlined$Sequence$1
  implements Sequence<Character>
{
  public StringsKt___StringsKt$asSequence$$inlined$Sequence$1(CharSequence paramCharSequence) {}
  
  @NotNull
  public Iterator<Character> iterator()
  {
    return (Iterator)StringsKt.iterator(this.$this_asSequence$inlined);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.text.StringsKt___StringsKt.asSequence..inlined.Sequence.1
 * JD-Core Version:    0.7.0.1
 */