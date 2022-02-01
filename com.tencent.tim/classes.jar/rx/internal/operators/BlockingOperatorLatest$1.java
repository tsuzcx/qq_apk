package rx.internal.operators;

import java.util.Iterator;
import rx.Observable;

final class BlockingOperatorLatest$1
  implements Iterable<T>
{
  BlockingOperatorLatest$1(Observable paramObservable) {}
  
  public Iterator<T> iterator()
  {
    BlockingOperatorLatest.LatestObserverIterator localLatestObserverIterator = new BlockingOperatorLatest.LatestObserverIterator();
    this.val$source.materialize().subscribe(localLatestObserverIterator);
    return localLatestObserverIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.BlockingOperatorLatest.1
 * JD-Core Version:    0.7.0.1
 */