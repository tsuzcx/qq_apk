import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Process;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.commonsdk.pool.RecyclablePool.Recyclable;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.MemoryManager.a;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Set;
import mqq.app.Foreground;
import mqq.app.Foreground.AppLifeCycleCallback;

public class anoz
  implements Handler.Callback, Foreground.AppLifeCycleCallback
{
  private static anoz jdField_a_of_type_Anoz;
  private LinkedList<anoz.a> Y = new LinkedList();
  private MemoryManager.a jdField_a_of_type_ComTencentMobileqqAppMemoryManager$a = new MemoryManager.a();
  private LinkedHashMap<String, anoz.a> af = new LinkedHashMap(4);
  private boolean cIX;
  private int cIb = 0;
  private int dKQ;
  private int dKR;
  private Set<String> db = new HashSet(10);
  public Handler dr;
  private SharedPreferences mPref = BaseApplicationImpl.getApplication().getSharedPreferences("scene_tracker" + BaseApplicationImpl.sProcessId, 0);
  private RecyclablePool sPool = new RecyclablePool(anoz.a.class, 5);
  
  private anoz()
  {
    long l = this.mPref.getLong("last_rand_time", 0L);
    if (Math.abs(System.currentTimeMillis() - l) < 86400000L) {
      if (this.mPref.getBoolean("rand_rs", false))
      {
        this.cIb = i;
        this.dKQ = this.mPref.getInt("rpt_nest_count", 0);
        this.dKR = this.mPref.getInt("rpt_nnest_count", 0);
        this.dr = new Handler(ThreadManager.getFileThreadLooper(), this);
        Foreground.registerLifeCycleCallback(this);
        if (Foreground.sCountResume <= 0) {
          break label308;
        }
      }
    }
    label303:
    label308:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.cIX = bool1;
      return;
      i = 1;
      break;
      if (Math.random() < 0.0005000000237487257D)
      {
        bool1 = true;
        label238:
        if (!bool1) {
          break label303;
        }
      }
      for (;;)
      {
        this.cIb = i;
        this.mPref.edit().putLong("last_rand_time", System.currentTimeMillis()).putBoolean("rand_rs", bool1).putInt("rpt_nest_count", 0).putInt("rpt_nnest_count", 0).apply();
        break;
        bool1 = false;
        break label238;
        i = 1;
      }
    }
  }
  
  public static anoz a()
  {
    if (jdField_a_of_type_Anoz == null) {}
    try
    {
      if (jdField_a_of_type_Anoz == null) {
        jdField_a_of_type_Anoz = new anoz();
      }
      return jdField_a_of_type_Anoz;
    }
    finally {}
  }
  
  private void a(anoz.a parama)
  {
    if ((parama.loopCount > 0) && (Math.random() < 0.1500000059604645D)) {
      if (parama.cfH == null)
      {
        if (this.dKR >= 20) {
          break label705;
        }
        this.dKR += 1;
        this.mPref.edit().putInt("rpt_nnest_count", this.dKR);
      }
    }
    label705:
    for (int i = 1;; i = 0) {
      for (;;)
      {
        if (i != 0)
        {
          HashMap localHashMap = new HashMap(30);
          localHashMap.put("stage", parama.stage);
          localHashMap.put("nestStage", parama.cfH);
          localHashMap.put("fromStage", parama.cfG);
          localHashMap.put("model", Build.MODEL);
          localHashMap.put("sdk_int", String.valueOf(Build.VERSION.SDK_INT));
          localHashMap.put("HeapMax", String.valueOf(Runtime.getRuntime().maxMemory() / 1024L));
          localHashMap.put("startPss", String.valueOf(parama.amR / 1024L));
          localHashMap.put("startHeap", String.valueOf(parama.amL / 1024L));
          localHashMap.put("startCache", String.valueOf(parama.amN / 1024L));
          localHashMap.put("startNativePss", String.valueOf(parama.amS / 1024L));
          if (parama.loopCount > 0)
          {
            localHashMap.put("avgPss", String.valueOf(parama.amV / parama.loopCount / 1024L));
            localHashMap.put("avgHeap", String.valueOf(parama.amX / parama.loopCount / 1024L));
            localHashMap.put("avgNativePss", String.valueOf(parama.amW / parama.loopCount / 1024L));
          }
          localHashMap.put("maxPss", String.valueOf(parama.amY / 1024L));
          localHashMap.put("maxNativePss", String.valueOf(parama.amZ / 1024L));
          localHashMap.put("maxHeap", String.valueOf(parama.ana / 1024L));
          localHashMap.put("endPss", String.valueOf(parama.amT / 1024L));
          localHashMap.put("endNativePss", String.valueOf(parama.amU / 1024L));
          localHashMap.put("endHeap", String.valueOf(parama.amO / 1024L));
          localHashMap.put("endCache", String.valueOf(parama.amQ / 1024L));
          if (parama.cIY)
          {
            ??? = "0";
            localHashMap.put("firstTrack", ???);
            localHashMap.put("processId", String.valueOf(BaseApplicationImpl.sProcessId));
            anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "actSceneMem", true, 0L, 0L, localHashMap, "");
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("SceneTracker", 2, new Object[] { parama.stage, "alloc:", Long.valueOf(parama.amL), "->", Long.valueOf(parama.amO), "; free:", Long.valueOf(parama.amM), "->", Long.valueOf(parama.amP) });
        }
        synchronized (this.af)
        {
          if (!this.Y.contains(parama)) {
            this.sPool.recycle(parama);
          }
          return;
          if (this.dKQ < 20)
          {
            this.dKQ += 1;
            this.mPref.edit().putInt("rpt_nest_count", this.dKQ);
            i = 1;
            continue;
            ??? = "1";
          }
        }
      }
    }
  }
  
  private boolean a(MemoryManager.a parama, long paramLong1, long paramLong2, anoz.a parama1)
  {
    synchronized (this.af)
    {
      Iterator localIterator = this.af.values().iterator();
      while (localIterator.hasNext())
      {
        anoz.a locala = (anoz.a)localIterator.next();
        if (locala != parama1)
        {
          locala.amX += paramLong1;
          locala.amW = parama.PW;
          locala.amV += parama.pss;
          locala.amY = Math.max(parama.pss, locala.amY);
          locala.loopCount += 1;
          locala.amZ = Math.max(parama.PW, locala.amZ);
          locala.ana = Math.max(paramLong1, locala.ana);
        }
      }
    }
    if ((this.af.size() > 0) && (this.cIX)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public String Ak()
  {
    ??? = null;
    try
    {
      localStringBuilder = new StringBuilder();
      try
      {
        for (;;)
        {
          synchronized (this.af)
          {
            int i = this.Y.size() - 1;
            if (i >= 0)
            {
              anoz.a locala = (anoz.a)this.Y.get(i);
              long l1;
              if (locala.amO == 0L)
              {
                l1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                if (locala.amP == 0L)
                {
                  l2 = Runtime.getRuntime().freeMemory();
                  localStringBuilder.append(locala.stage).append("(From ").append(locala.cfG).append(")").append(":Alloc ").append(locala.amL).append("->").append(l1).append(";Free ").append(locala.amM).append("->").append(l2).append("|");
                  i -= 1;
                }
              }
              else
              {
                l1 = locala.amO;
                continue;
              }
              long l2 = locala.amP;
            }
            else
            {
              if (localStringBuilder != null) {
                break;
              }
              return "Exception";
            }
          }
        }
      }
      catch (Exception localException3) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        Exception localException2 = localException3;
      }
    }
    return localStringBuilder.toString();
  }
  
  public void B(String paramString, boolean paramBoolean)
  {
    if (this.cIb == 0) {
      return;
    }
    anoz.a locala2 = (anoz.a)this.sPool.obtain(anoz.a.class);
    locala2.stage = paramString;
    if (!this.db.contains(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      locala2.cIY = bool;
      if (locala2.cIY) {
        this.db.add(paramString);
      }
      synchronized (this.af)
      {
        if (this.af.size() > 0)
        {
          anoz.a locala1 = null;
          Iterator localIterator = this.af.values().iterator();
          while (localIterator.hasNext()) {
            locala1 = (anoz.a)localIterator.next();
          }
          locala2.cfG = locala1.stage;
          if (locala1.cfH == null) {
            locala1.cfH = locala2.stage;
          }
        }
        this.af.put(paramString, locala2);
        if (this.Y.size() > 8)
        {
          paramString = (anoz.a)this.Y.remove(0);
          if ((!this.af.containsValue(paramString)) && (!paramString.cIZ)) {
            this.sPool.recycle(paramString);
          }
        }
        this.Y.add(locala2);
        this.dr.removeMessages(2);
        if (this.cIb == 1)
        {
          locala2.amL = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
          locala2.amM = Runtime.getRuntime().freeMemory();
          return;
        }
      }
      if (this.cIb != 2) {
        break;
      }
      paramString = this.dr.obtainMessage(0);
      paramString.obj = locala2;
      if (paramBoolean)
      {
        this.dr.sendMessageDelayed(paramString, 1000L);
        return;
      }
      this.dr.sendMessageAtFrontOfQueue(paramString);
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    long l1 = 0L;
    long l2 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long l3 = Runtime.getRuntime().freeMemory();
    MemoryManager.a(Process.myPid(), this.jdField_a_of_type_ComTencentMobileqqAppMemoryManager$a);
    if (paramMessage.what == 0)
    {
      this.dr.removeMessages(2);
      paramMessage = (anoz.a)paramMessage.obj;
      paramMessage.amL = l2;
      paramMessage.amM = l3;
      paramMessage.amS = this.jdField_a_of_type_ComTencentMobileqqAppMemoryManager$a.PW;
      if (BaseApplicationImpl.sImageCache != null)
      {
        l1 = BaseApplicationImpl.sImageCache.size();
        paramMessage.amN = l1;
        paramMessage.amR = this.jdField_a_of_type_ComTencentMobileqqAppMemoryManager$a.pss;
        if (a(this.jdField_a_of_type_ComTencentMobileqqAppMemoryManager$a, l2, l3, paramMessage)) {
          this.dr.sendEmptyMessageDelayed(2, 2000L);
        }
      }
    }
    for (;;)
    {
      return false;
      l1 = 0L;
      break;
      if (paramMessage.what == 1)
      {
        this.dr.removeMessages(2);
        paramMessage = (anoz.a)paramMessage.obj;
        paramMessage.amO = l2;
        paramMessage.amP = l3;
        paramMessage.amU = this.jdField_a_of_type_ComTencentMobileqqAppMemoryManager$a.PW;
        if (BaseApplicationImpl.sImageCache != null) {
          l1 = BaseApplicationImpl.sImageCache.size();
        }
        paramMessage.amQ = l1;
        paramMessage.amT = this.jdField_a_of_type_ComTencentMobileqqAppMemoryManager$a.pss;
        if (a(this.jdField_a_of_type_ComTencentMobileqqAppMemoryManager$a, l2, l3, null)) {
          this.dr.sendEmptyMessageDelayed(2, 2000L);
        }
        a(paramMessage);
      }
      else if (a(this.jdField_a_of_type_ComTencentMobileqqAppMemoryManager$a, l2, l3, null))
      {
        this.dr.sendEmptyMessageDelayed(2, 2000L);
      }
    }
  }
  
  public void onActivityCreated(Activity paramActivity)
  {
    traceStart(paramActivity.getClass().getSimpleName());
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    traceEnd(paramActivity.getClass().getSimpleName());
  }
  
  public void onRunningBackground()
  {
    this.cIX = false;
  }
  
  public void onRunningForeground()
  {
    this.cIX = true;
  }
  
  public void traceEnd(String paramString)
  {
    if (this.cIb == 0) {}
    do
    {
      return;
      synchronized (this.af)
      {
        paramString = (anoz.a)this.af.remove(paramString);
        if (paramString == null) {
          return;
        }
      }
      paramString.cIZ = true;
      if (this.cIb == 1)
      {
        paramString.amO = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        paramString.amP = Runtime.getRuntime().freeMemory();
        if (QLog.isColorLevel()) {
          QLog.d("SceneTracker", 2, new Object[] { paramString.stage, "alloc:", Long.valueOf(paramString.amL), "->", Long.valueOf(paramString.amO), "; free:", Long.valueOf(paramString.amM), "->", Long.valueOf(paramString.amP) });
        }
        for (;;)
        {
          synchronized (this.af)
          {
            if (!this.Y.contains(paramString))
            {
              this.sPool.recycle(paramString);
              return;
            }
          }
          paramString.cIZ = false;
        }
      }
    } while (this.cIb != 2);
    ??? = this.dr.obtainMessage(1);
    ((Message)???).obj = paramString;
    this.dr.sendMessageDelayed((Message)???, 2000L);
  }
  
  public void traceStart(String paramString)
  {
    B(paramString, false);
  }
  
  public static class a
    extends RecyclablePool.Recyclable
  {
    public long amL;
    public long amM;
    public long amN;
    public long amO;
    public long amP;
    public long amQ;
    public long amR;
    public long amS;
    public long amT;
    public long amU;
    public long amV;
    public long amW;
    public long amX;
    public long amY;
    public long amZ;
    public long ana;
    public boolean cIY = true;
    public boolean cIZ;
    public String cfG;
    public String cfH;
    public int loopCount;
    public String stage;
    
    public void recycle()
    {
      super.recycle();
      this.stage = null;
      this.amP = 0L;
      this.amO = 0L;
      this.amM = 0L;
      this.amL = 0L;
      this.amQ = 0L;
      this.amN = 0L;
      this.amU = 0L;
      this.amT = 0L;
      this.amS = 0L;
      this.amR = 0L;
      this.amX = 0L;
      this.amW = 0L;
      this.amV = 0L;
      this.loopCount = 0;
      this.ana = 0L;
      this.amZ = 0L;
      this.amY = 0L;
      this.cfH = null;
      this.cfG = null;
      this.cIZ = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     anoz
 * JD-Core Version:    0.7.0.1
 */