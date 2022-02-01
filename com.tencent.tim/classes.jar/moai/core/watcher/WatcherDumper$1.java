package moai.core.watcher;

import com.google.common.cache.Cache;
import java.util.Comparator;
import java.util.Map.Entry;
import rx.Subscription;

class WatcherDumper$1
  implements Comparator<Map.Entry<Class<? extends Watchers.Watcher>, Cache<Watchers.Watcher, Subscription>>>
{
  WatcherDumper$1(WatcherDumper paramWatcherDumper) {}
  
  public int compare(Map.Entry<Class<? extends Watchers.Watcher>, Cache<Watchers.Watcher, Subscription>> paramEntry1, Map.Entry<Class<? extends Watchers.Watcher>, Cache<Watchers.Watcher, Subscription>> paramEntry2)
  {
    return ((Class)paramEntry1.getKey()).getSimpleName().compareTo(((Class)paramEntry2.getKey()).getSimpleName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.core.watcher.WatcherDumper.1
 * JD-Core Version:    0.7.0.1
 */