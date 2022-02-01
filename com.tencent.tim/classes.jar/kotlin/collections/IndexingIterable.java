package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/IndexingIterable;", "T", "", "Lkotlin/collections/IndexedValue;", "iteratorFactory", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "iterator", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class IndexingIterable<T>
  implements Iterable<IndexedValue<? extends T>>, KMappedMarker
{
  private final Function0<Iterator<T>> iteratorFactory;
  
  public IndexingIterable(@NotNull Function0<? extends Iterator<? extends T>> paramFunction0)
  {
    this.iteratorFactory = paramFunction0;
  }
  
  @NotNull
  public Iterator<IndexedValue<T>> iterator()
  {
    return (Iterator)new IndexingIterator((Iterator)this.iteratorFactory.invoke());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.collections.IndexingIterable
 * JD-Core Version:    0.7.0.1
 */