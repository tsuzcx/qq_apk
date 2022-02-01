package moai.concurrent;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

final class Threads$3
  implements Runnable
{
  Threads$3(Runnable paramRunnable) {}
  
  public void run()
  {
    List localList = (List)Threads.access$600().get(this.val$r);
    if ((localList != null) && (localList.size() > 0)) {}
    try
    {
      localList.remove(this);
      if ((localList == null) || (localList.size() == 0)) {
        Threads.access$600().remove(this.val$r);
      }
      Threads.access$300().execute(this.val$r);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.concurrent.Threads.3
 * JD-Core Version:    0.7.0.1
 */