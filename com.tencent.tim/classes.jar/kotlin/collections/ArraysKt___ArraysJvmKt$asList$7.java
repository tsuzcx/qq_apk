package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/collections/ArraysKt___ArraysJvmKt$asList$7", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "element", "get", "index", "(I)Ljava/lang/Boolean;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class ArraysKt___ArraysJvmKt$asList$7
  extends AbstractList<Boolean>
  implements RandomAccess
{
  ArraysKt___ArraysJvmKt$asList$7(boolean[] paramArrayOfBoolean) {}
  
  public final boolean contains(Object paramObject)
  {
    if ((paramObject instanceof Boolean)) {
      return contains(((Boolean)paramObject).booleanValue());
    }
    return false;
  }
  
  public boolean contains(boolean paramBoolean)
  {
    return ArraysKt.contains(this.$this_asList, paramBoolean);
  }
  
  @NotNull
  public Boolean get(int paramInt)
  {
    return Boolean.valueOf(this.$this_asList[paramInt]);
  }
  
  public int getSize()
  {
    return this.$this_asList.length;
  }
  
  public final int indexOf(Object paramObject)
  {
    if ((paramObject instanceof Boolean)) {
      return indexOf(((Boolean)paramObject).booleanValue());
    }
    return -1;
  }
  
  public int indexOf(boolean paramBoolean)
  {
    return ArraysKt.indexOf(this.$this_asList, paramBoolean);
  }
  
  public boolean isEmpty()
  {
    return this.$this_asList.length == 0;
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    if ((paramObject instanceof Boolean)) {
      return lastIndexOf(((Boolean)paramObject).booleanValue());
    }
    return -1;
  }
  
  public int lastIndexOf(boolean paramBoolean)
  {
    return ArraysKt.lastIndexOf(this.$this_asList, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.collections.ArraysKt___ArraysJvmKt.asList.7
 * JD-Core Version:    0.7.0.1
 */