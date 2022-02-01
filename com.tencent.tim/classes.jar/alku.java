import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmethodmonitor.PrivacyInvokeMonitor.2;
import com.tencent.mobileqq.qmethodmonitor.PrivacyInvokeMonitor.3;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import mqq.app.MobileQQ;

public class alku
{
  private static String TAG;
  private static final ConcurrentMap<String, alku.a> b = new ConcurrentHashMap();
  private static final boolean cxy;
  private static final String sCurrentProcessName;
  private static Handler sHandler;
  
  static
  {
    boolean bool = false;
    TAG = "PrivacyInvokeMonitor";
    if (aqlu.nextInt(0, 100) < 10) {
      bool = true;
    }
    cxy = bool;
    sCurrentProcessName = MobileQQ.processName;
  }
  
  private static void a(alku.b paramb)
  {
    ThreadManagerV2.excute(new PrivacyInvokeMonitor.3(paramb), 16, null, false);
  }
  
  private static void a(String paramString1, Throwable paramThrowable, String paramString2)
  {
    for (;;)
    {
      Object localObject;
      synchronized (b)
      {
        localObject = (alku.a)b.get(paramString1);
        if (localObject == null)
        {
          localObject = new alku.a(paramString1);
          b.put(paramString1, localObject);
          paramString1 = (String)localObject;
          paramThrowable = paramThrowable.getStackTrace();
          localObject = new StringBuilder();
          int i = 0;
          int j = 0;
          if ((j < paramThrowable.length) && (i < 6))
          {
            ((StringBuilder)localObject).append(paramThrowable[j]);
            j += 1;
            i += 1;
            continue;
          }
          localObject = ((StringBuilder)localObject).toString();
          paramThrowable = Integer.valueOf(((String)localObject).hashCode());
          alku.b localb = (alku.b)paramString1.gE.get(paramThrowable);
          if (localb == null)
          {
            paramString2 = new alku.b(paramString2, (String)localObject);
            paramString2.mCount += 1;
            paramString1.gE.put(paramThrowable, paramString2);
            return;
          }
          localb.mCount += 1;
          return;
        }
      }
      paramString1 = (String)localObject;
    }
  }
  
  public static void dGy()
  {
    synchronized (b)
    {
      alku.a locala;
      Map.Entry localEntry;
      alku.b localb;
      do
      {
        Iterator localIterator1 = b.values().iterator();
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          locala = (alku.a)localIterator1.next();
          localIterator2 = locala.gE.entrySet().iterator();
        }
        localEntry = (Map.Entry)localIterator2.next();
        localb = (alku.b)localEntry.getValue();
      } while (localb.mCount <= 1);
      a(localb);
      locala.gE.remove(localEntry.getKey());
    }
    sHandler.postDelayed(new PrivacyInvokeMonitor.2(), 300000L);
  }
  
  static class a
  {
    public ConcurrentHashMap<Integer, alku.b> gE = new ConcurrentHashMap();
    public String mTag;
    
    public a(String paramString)
    {
      this.mTag = paramString;
    }
  }
  
  public static class b
  {
    public String bWX;
    public String bWY;
    public int mCount;
    
    public b(String paramString1, String paramString2)
    {
      this.bWX = paramString1;
      this.bWY = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alku
 * JD-Core Version:    0.7.0.1
 */