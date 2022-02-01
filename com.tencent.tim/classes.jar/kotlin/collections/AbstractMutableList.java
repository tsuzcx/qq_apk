package kotlin.collections;

import java.util.AbstractList;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.markers.KMutableList;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/AbstractMutableList;", "E", "", "Ljava/util/AbstractList;", "()V", "add", "", "index", "", "element", "(ILjava/lang/Object;)V", "removeAt", "(I)Ljava/lang/Object;", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.1")
public abstract class AbstractMutableList<E>
  extends AbstractList<E>
  implements List<E>, KMutableList
{
  public abstract void add(int paramInt, E paramE);
  
  public abstract int getSize();
  
  public final E remove(int paramInt)
  {
    return removeAt(paramInt);
  }
  
  public abstract E removeAt(int paramInt);
  
  public abstract E set(int paramInt, E paramE);
  
  public final int size()
  {
    return getSize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.collections.AbstractMutableList
 * JD-Core Version:    0.7.0.1
 */