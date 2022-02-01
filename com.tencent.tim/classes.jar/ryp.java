import com.tencent.biz.richframework.preload.Worker;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ryp
{
  private static ryp a;
  private final AtomicInteger ak = new AtomicInteger(100);
  private final ConcurrentHashMap<String, rys> cu = new ConcurrentHashMap();
  
  private <T> String a(String paramString, Worker<T> paramWorker)
  {
    if (exists(paramString))
    {
      ryo.log("preLoader ID is used, please note that remove!");
      remove(paramString);
    }
    this.cu.put(paramString, paramWorker);
    paramWorker.bxr();
    return paramString;
  }
  
  public static ryp a()
  {
    if (a == null) {
      a = new ryp();
    }
    return a;
  }
  
  public <T> String a(String paramString, ryn<T> paramryn)
  {
    int i = this.ak.getAndIncrement();
    return a(paramString, new Worker(paramString, paramryn, (ryu)null, i));
  }
  
  public <T> void b(String paramString, ryu<T> paramryu)
  {
    try
    {
      paramString = (rys)this.cu.get(paramString);
      if (paramString != null) {
        paramString.a(paramryu);
      }
      return;
    }
    catch (Exception paramString)
    {
      ryo.log(paramString);
    }
  }
  
  public boolean exists(String paramString)
  {
    return this.cu.containsKey(paramString);
  }
  
  public void remove(String paramString)
  {
    if ((this.cu != null) && (this.cu.containsKey(paramString))) {}
    try
    {
      rys localrys = (rys)this.cu.get(paramString);
      if (localrys != null) {
        localrys.onRemove();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ryo.log(localException);
      }
    }
    this.cu.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ryp
 * JD-Core Version:    0.7.0.1
 */