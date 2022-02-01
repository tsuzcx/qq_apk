package kotlin.collections;

import java.util.Iterator;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/collections/AbstractMap$values$1$iterator$1", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class AbstractMap$values$1$iterator$1
  implements Iterator<V>, KMappedMarker
{
  AbstractMap$values$1$iterator$1(Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    return this.$entryIterator.hasNext();
  }
  
  public V next()
  {
    return ((Map.Entry)this.$entryIterator.next()).getValue();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.collections.AbstractMap.values.1.iterator.1
 * JD-Core Version:    0.7.0.1
 */