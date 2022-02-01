package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/sequences/TakeSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "left", "", "getLeft", "()I", "setLeft", "(I)V", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class TakeSequence$iterator$1
  implements Iterator<T>, KMappedMarker
{
  @NotNull
  private final Iterator<T> iterator;
  private int left;
  
  TakeSequence$iterator$1()
  {
    this.left = TakeSequence.access$getCount$p(localTakeSequence);
    this.iterator = TakeSequence.access$getSequence$p(localTakeSequence).iterator();
  }
  
  @NotNull
  public final Iterator<T> getIterator()
  {
    return this.iterator;
  }
  
  public final int getLeft()
  {
    return this.left;
  }
  
  public boolean hasNext()
  {
    return (this.left > 0) && (this.iterator.hasNext());
  }
  
  public T next()
  {
    if (this.left == 0) {
      throw ((Throwable)new NoSuchElementException());
    }
    this.left -= 1;
    return this.iterator.next();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final void setLeft(int paramInt)
  {
    this.left = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.sequences.TakeSequence.iterator.1
 * JD-Core Version:    0.7.0.1
 */