package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "invoke"}, k=3, mv={1, 1, 16})
final class ArraysKt___ArraysKt$withIndex$1
  extends Lambda
  implements Function0<Iterator<? extends T>>
{
  ArraysKt___ArraysKt$withIndex$1(Object[] paramArrayOfObject)
  {
    super(0);
  }
  
  @NotNull
  public final Iterator<T> invoke()
  {
    return ArrayIteratorKt.iterator(this.$this_withIndex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.collections.ArraysKt___ArraysKt.withIndex.1
 * JD-Core Version:    0.7.0.1
 */