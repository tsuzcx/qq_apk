import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmethodmonitor.monitor.PrivacyInvokeMonitor.1;
import com.tencent.mobileqq.qmethodmonitor.monitor.PrivacyInvokeMonitor.2;
import com.tencent.mobileqq.qmethodmonitor.monitor.PrivacyInvokeMonitor.3;
import com.tencent.mobileqq.qmethodmonitor.monitor.PrivacyInvokeMonitor.4;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import mqq.app.MobileQQ;

public class allb
{
  private static String TAG;
  private static final ConcurrentMap<String, allb.a> b = new ConcurrentHashMap();
  private static final boolean cxy;
  private static boolean cxz;
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
  
  public static void Or(String paramString) {}
  
  private static void a(allb.b paramb)
  {
    ThreadManagerV2.excute(new PrivacyInvokeMonitor.3(paramb), 16, null, false);
  }
  
  private static void a(String paramString1, String paramString2, Activity paramActivity)
  {
    if (paramActivity != null)
    {
      aqha.a(paramActivity, 0, "未接隐私SDK联系maybepeng.method:" + paramString1, paramString2, null, null).show();
      return;
    }
    QQToast.a(MobileQQ.sMobileQQ, 1, "未接隐私SDK联系maybepeng.method: " + paramString1, 1).show();
  }
  
  private static void a(String paramString1, Throwable paramThrowable, String paramString2)
  {
    for (;;)
    {
      synchronized (b)
      {
        allb.a locala = (allb.a)b.get(paramString1);
        if (locala == null)
        {
          locala = new allb.a(paramString1);
          b.put(paramString1, locala);
          Object localObject1 = paramThrowable.getStackTrace();
          Object localObject2 = new StringBuilder();
          int i = 0;
          int j = 0;
          if ((j < localObject1.length) && (i < 8))
          {
            ((StringBuilder)localObject2).append(localObject1[j]);
            j += 1;
            i += 1;
          }
          else
          {
            localObject2 = ((StringBuilder)localObject2).toString();
            localObject1 = Integer.valueOf(((String)localObject2).hashCode());
            allb.b localb = (allb.b)locala.gE.get(localObject1);
            if (localb == null)
            {
              paramString1 = new allb.b(paramString1, paramString2, paramThrowable, (String)localObject2);
              paramString1.mCount += 1;
              locala.gE.put(localObject1, paramString1);
              return;
            }
            localb.mCount += 1;
            return;
          }
        }
      }
    }
  }
  
  private static void b(allb.b paramb)
  {
    ThreadManagerV2.excute(new PrivacyInvokeMonitor.4(paramb), 16, null, false);
  }
  
  public static void dGy()
  {
    for (;;)
    {
      allb.a locala;
      int i;
      Object localObject2;
      Object localObject3;
      synchronized (b)
      {
        Iterator localIterator = b.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        locala = (allb.a)((Map.Entry)localIterator.next()).getValue();
        i = locala.gE.size();
        if (i > 1)
        {
          localObject2 = locala.gE.entrySet().iterator();
          if (!((Iterator)localObject2).hasNext()) {
            continue;
          }
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          allb.b localb = (allb.b)((Map.Entry)localObject3).getValue();
          a(localb);
          b(localb);
          locala.gE.remove(((Map.Entry)localObject3).getKey());
        }
      }
      if (i == 1)
      {
        localObject2 = (Map.Entry)locala.gE.entrySet().iterator().next();
        localObject3 = (allb.b)((Map.Entry)localObject2).getValue();
        if (((allb.b)localObject3).mCount > 1)
        {
          a((allb.b)localObject3);
          b((allb.b)localObject3);
          locala.gE.remove(((Map.Entry)localObject2).getKey());
        }
      }
    }
    sHandler.postDelayed(new PrivacyInvokeMonitor.2(), 300000L);
  }
  
  public static void h(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (!cxy)
    {
      QLog.d(TAG, 1, "report switch has been closed! ");
      return;
    }
    if (!cxz) {
      startMonitor();
    }
    ThreadManagerV2.excute(new PrivacyInvokeMonitor.1(paramString1, paramThrowable, paramString2), 16, null, false);
  }
  
  public static void j(String paramString1, String paramString2, Throwable paramThrowable)
  {
    int i = 0;
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 0;
    while ((j < arrayOfStackTraceElement.length) && (i < 8))
    {
      localStringBuilder.append(arrayOfStackTraceElement[j]);
      j += 1;
      i += 1;
    }
    paramString1 = new allb.b(paramString1, paramString2, paramThrowable, localStringBuilder.toString());
    paramString1.mCount += 1;
    a(paramString1);
    b(paramString1);
  }
  
  public static void startMonitor()
  {
    if (!cxz)
    {
      cxz = true;
      sHandler = new Handler(Looper.getMainLooper());
      dGy();
    }
  }
  
  static class a
  {
    public ConcurrentHashMap<Integer, allb.b> gE = new ConcurrentHashMap();
    public String mTag;
    
    public a(String paramString)
    {
      this.mTag = paramString;
    }
  }
  
  public static class b
  {
    public Throwable b;
    public String bWX;
    public String bXb;
    public String bXc;
    public int mCount;
    
    public b(String paramString1, String paramString2, Throwable paramThrowable, String paramString3)
    {
      this.bXb = paramString1;
      this.b = paramThrowable;
      this.bWX = paramString2;
      this.bXc = paramString3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     allb
 * JD-Core Version:    0.7.0.1
 */