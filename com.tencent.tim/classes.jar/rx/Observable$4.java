package rx;

import java.util.List;
import rx.functions.Func1;

final class Observable$4
  implements Func1<List<? extends Observable<?>>, Observable<?>[]>
{
  public Observable<?>[] call(List<? extends Observable<?>> paramList)
  {
    return (Observable[])paramList.toArray(new Observable[paramList.size()]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.Observable.4
 * JD-Core Version:    0.7.0.1
 */