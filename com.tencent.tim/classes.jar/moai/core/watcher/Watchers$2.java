package moai.core.watcher;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.functions.Action1;

class Watchers$2
  implements Action1<Watchers.Context>
{
  Watchers$2(Watchers paramWatchers, Watchers.Config paramConfig, Watchers.Watcher paramWatcher) {}
  
  public void call(Watchers.Context paramContext)
  {
    if ((this.val$config.once()) && (Watchers.Context.access$200(paramContext).getAndSet(true))) {
      return;
    }
    try
    {
      this.val$watcher.getClass().getMethod(Watchers.Context.access$300(paramContext).getName(), Watchers.Context.access$300(paramContext).getParameterTypes()).invoke(this.val$watcher, Watchers.Context.access$400(paramContext));
      return;
    }
    catch (Exception paramContext)
    {
      if ((paramContext instanceof InvocationTargetException)) {
        throw new RuntimeException(((InvocationTargetException)paramContext).getTargetException());
      }
      throw new RuntimeException(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.core.watcher.Watchers.2
 * JD-Core Version:    0.7.0.1
 */