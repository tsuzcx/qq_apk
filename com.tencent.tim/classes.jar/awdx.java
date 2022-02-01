import android.os.Handler;
import java.util.concurrent.ConcurrentHashMap;

public class awdx
  implements awdw
{
  private static ConcurrentHashMap<String, awdx> ag = new ConcurrentHashMap();
  private static Object lock = new Object();
  private awdw a;
  private int eAq = -1;
  private String mBusinessId;
  
  private awdx(String paramString)
  {
    this.mBusinessId = paramString;
    this.a = aweb.a(this.mBusinessId);
  }
  
  public static awdx a(String paramString)
  {
    Object localObject1 = (awdx)ag.get(paramString);
    if (localObject1 == null) {
      synchronized (lock)
      {
        awdx localawdx = (awdx)ag.get(paramString);
        localObject1 = localawdx;
        if (localawdx == null)
        {
          localObject1 = new awdx(paramString);
          ag.put(paramString, localObject1);
        }
        return localObject1;
      }
    }
    return localObject1;
  }
  
  public void v(Handler paramHandler)
  {
    this.a.v(paramHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awdx
 * JD-Core Version:    0.7.0.1
 */