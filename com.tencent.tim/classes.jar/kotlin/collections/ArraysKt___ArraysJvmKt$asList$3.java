package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/collections/ArraysKt___ArraysJvmKt$asList$3", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "getSize", "()I", "contains", "", "element", "get", "index", "(I)Ljava/lang/Integer;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class ArraysKt___ArraysJvmKt$asList$3
  extends AbstractList<Integer>
  implements RandomAccess
{
  ArraysKt___ArraysJvmKt$asList$3(int[] paramArrayOfInt) {}
  
  public boolean contains(int paramInt)
  {
    return ArraysKt.contains(this.$this_asList, paramInt);
  }
  
  public final boolean contains(Object paramObject)
  {
    if ((paramObject instanceof Integer)) {
      return contains(((Number)paramObject).intValue());
    }
    return false;
  }
  
  @NotNull
  public Integer get(int paramInt)
  {
    return Integer.valueOf(this.$this_asList[paramInt]);
  }
  
  public int getSize()
  {
    return this.$this_asList.length;
  }
  
  public int indexOf(int paramInt)
  {
    return ArraysKt.indexOf(this.$this_asList, paramInt);
  }
  
  public final int indexOf(Object paramObject)
  {
    if ((paramObject instanceof Integer)) {
      return indexOf(((Number)paramObject).intValue());
    }
    return -1;
  }
  
  public boolean isEmpty()
  {
    return this.$this_asList.length == 0;
  }
  
  public int lastIndexOf(int paramInt)
  {
    return ArraysKt.lastIndexOf(this.$this_asList, paramInt);
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    if ((paramObject instanceof Integer)) {
      return lastIndexOf(((Number)paramObject).intValue());
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.collections.ArraysKt___ArraysJvmKt.asList.3
 * JD-Core Version:    0.7.0.1
 */