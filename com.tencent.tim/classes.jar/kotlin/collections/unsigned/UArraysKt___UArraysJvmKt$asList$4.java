package kotlin.collections.unsigned;

import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$4", "Lkotlin/collections/AbstractList;", "Lkotlin/UShort;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", "contains-xj2QHRw", "(S)Z", "get", "index", "indexOf", "indexOf-xj2QHRw", "(S)I", "isEmpty", "lastIndexOf", "lastIndexOf-xj2QHRw", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class UArraysKt___UArraysJvmKt$asList$4
  extends AbstractList<UShort>
  implements RandomAccess
{
  UArraysKt___UArraysJvmKt$asList$4(short[] paramArrayOfShort) {}
  
  public final boolean contains(Object paramObject)
  {
    if ((paramObject instanceof UShort)) {
      return contains-xj2QHRw(((UShort)paramObject).unbox-impl());
    }
    return false;
  }
  
  public boolean contains-xj2QHRw(short paramShort)
  {
    return UShortArray.contains-xj2QHRw(this.$this_asList, paramShort);
  }
  
  @NotNull
  public UShort get(int paramInt)
  {
    return UShort.box-impl(UShortArray.get-impl(this.$this_asList, paramInt));
  }
  
  public int getSize()
  {
    return UShortArray.getSize-impl(this.$this_asList);
  }
  
  public final int indexOf(Object paramObject)
  {
    if ((paramObject instanceof UShort)) {
      return indexOf-xj2QHRw(((UShort)paramObject).unbox-impl());
    }
    return -1;
  }
  
  public int indexOf-xj2QHRw(short paramShort)
  {
    return ArraysKt.indexOf(this.$this_asList, paramShort);
  }
  
  public boolean isEmpty()
  {
    return UShortArray.isEmpty-impl(this.$this_asList);
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    if ((paramObject instanceof UShort)) {
      return lastIndexOf-xj2QHRw(((UShort)paramObject).unbox-impl());
    }
    return -1;
  }
  
  public int lastIndexOf-xj2QHRw(short paramShort)
  {
    return ArraysKt.lastIndexOf(this.$this_asList, paramShort);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.collections.unsigned.UArraysKt___UArraysJvmKt.asList.4
 * JD-Core Version:    0.7.0.1
 */