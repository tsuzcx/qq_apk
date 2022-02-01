package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/collections/ArraysKt___ArraysJvmKt$asList$6", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", "get", "index", "(I)Ljava/lang/Double;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class ArraysKt___ArraysJvmKt$asList$6
  extends AbstractList<Double>
  implements RandomAccess
{
  ArraysKt___ArraysJvmKt$asList$6(double[] paramArrayOfDouble) {}
  
  public boolean contains(double paramDouble)
  {
    return ArraysKt.contains(this.$this_asList, paramDouble);
  }
  
  public final boolean contains(Object paramObject)
  {
    if ((paramObject instanceof Double)) {
      return contains(((Number)paramObject).doubleValue());
    }
    return false;
  }
  
  @NotNull
  public Double get(int paramInt)
  {
    return Double.valueOf(this.$this_asList[paramInt]);
  }
  
  public int getSize()
  {
    return this.$this_asList.length;
  }
  
  public int indexOf(double paramDouble)
  {
    return ArraysKt.indexOf(this.$this_asList, paramDouble);
  }
  
  public final int indexOf(Object paramObject)
  {
    if ((paramObject instanceof Double)) {
      return indexOf(((Number)paramObject).doubleValue());
    }
    return -1;
  }
  
  public boolean isEmpty()
  {
    return this.$this_asList.length == 0;
  }
  
  public int lastIndexOf(double paramDouble)
  {
    return ArraysKt.lastIndexOf(this.$this_asList, paramDouble);
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    if ((paramObject instanceof Double)) {
      return lastIndexOf(((Number)paramObject).doubleValue());
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.collections.ArraysKt___ArraysJvmKt.asList.6
 * JD-Core Version:    0.7.0.1
 */