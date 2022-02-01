import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.webprocess.PreloadService.PreloadImpl.1;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class aqyc
{
  public static WebViewPluginEngine c;
  public static volatile boolean cWT;
  public static volatile boolean cWU;
  public static volatile boolean cWV;
  public static volatile boolean cWW;
  public static WebViewPluginEngine d;
  public static final Object fB = new Object();
  public static HashMap<Integer, aqyc.b> pu = new HashMap();
  public static HashMap<Integer, aqyc.b> pv = new HashMap();
  public static long sLastReportTime;
  
  public static void Yb(int paramInt)
  {
    int j = 0;
    Object localObject = (aeou)aeif.a().o(158);
    if ((localObject != null) && (((aeou)localObject).cOm == 1)) {
      return;
    }
    boolean bool = QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool");
    if (!bool)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("from", 305);
      ((Intent)localObject).setAction("com.tencent.mobileqq.webprocess.preload_web_process");
      ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
      ((Intent)localObject).putExtra("com.tencent.mobileqq.webprocess.start_time", System.currentTimeMillis());
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject, "com.tencent.tim.msg.permission.pushnotify");
      if (QLog.isColorLevel()) {
        QLog.d("PreloadService", 2, "preloadWebview...");
      }
    }
    localObject = new aqyc.b(paramInt);
    if (pu.containsKey(Integer.valueOf(paramInt))) {
      localObject = (aqyc.b)pu.get(Integer.valueOf(paramInt));
    }
    ((aqyc.b)localObject).total += 1;
    int k = ((aqyc.b)localObject).edE;
    if (bool)
    {
      i = 1;
      label184:
      ((aqyc.b)localObject).edE = (i + k);
      k = ((aqyc.b)localObject).edF;
      if (!bool) {
        break label244;
      }
    }
    label244:
    for (int i = j;; i = 1)
    {
      ((aqyc.b)localObject).edF = (k + i);
      pu.put(Integer.valueOf(paramInt), localObject);
      if (((aqyc.b)localObject).total <= 3) {
        break;
      }
      ego();
      return;
      i = 0;
      break label184;
    }
  }
  
  public static void ego()
  {
    if (System.currentTimeMillis() - sLastReportTime > 3600000L)
    {
      Iterator localIterator = pu.values().iterator();
      aqyc.b localb;
      HashMap localHashMap;
      while (localIterator.hasNext())
      {
        localb = (aqyc.b)localIterator.next();
        localHashMap = new HashMap(4);
        localHashMap.put("type", String.valueOf(localb.type));
        localHashMap.put("totalNum", String.valueOf(localb.total));
        localHashMap.put("hasProc", String.valueOf(localb.edE));
        localHashMap.put("noProc", String.valueOf(localb.edF));
        anpc.a(BaseApplicationImpl.getApplication().getApplicationContext()).collectPerformance(null, "actPreloadWebview", true, 0L, 0L, localHashMap, null);
      }
      localIterator = pv.values().iterator();
      while (localIterator.hasNext())
      {
        localb = (aqyc.b)localIterator.next();
        localHashMap = new HashMap(4);
        localHashMap.put("type", String.valueOf(localb.type));
        localHashMap.put("totalNum", String.valueOf(localb.total));
        localHashMap.put("hasProc", String.valueOf(localb.edE));
        localHashMap.put("noProc", String.valueOf(localb.edF));
        anpc.a(BaseApplicationImpl.getApplication().getApplicationContext()).collectPerformance(null, "actJumpWebview", true, 0L, 0L, localHashMap, null);
      }
      pu.clear();
      pv.clear();
      sLastReportTime = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("PreloadService", 2, "reportInterval...");
      }
    }
  }
  
  public static boolean k(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getClass().getSimpleName().equals("ReaderRuntime");
  }
  
  public static boolean l(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getClass().getSimpleName().equals("VipComicPluginRuntime");
  }
  
  public static void sI(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("_accelerator_mode_", 3);
    localBundle.putInt("from", paramInt);
    arcn.a().dD(localBundle);
  }
  
  public static class a
  {
    private void egp()
    {
      int i = arcn.a().MA();
      if ((i & 0x2) == 0)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("_accelerator_mode_", i | 0x2);
        arcn.a().dD(localBundle);
      }
    }
    
    public void I(AppInterface arg1)
    {
      if (((!aqyc.cWT) && (aqyc.k(???))) || ((!aqyc.cWU) && (aqyc.l(???)))) {}
      label182:
      while (!QLog.isColorLevel()) {
        for (;;)
        {
          try
          {
            if (QLog.isColorLevel()) {
              QLog.d("PreloadService", 2, "preload webview engine");
            }
            l1 = System.currentTimeMillis();
            if (!aqyc.k(???)) {
              break label182;
            }
            aqyc.c = WebAccelerateHelper.getInstance().createWebViewPluginEngine(???, null, null, gL());
          }
          catch (Exception ???)
          {
            long l1;
            long l2;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("PreloadService", 2, "preload error:" + ???.toString());
            return;
          }
          synchronized (aqyc.fB)
          {
            aqyc.fB.notifyAll();
            aqyc.cWT = true;
            l2 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
              QLog.i("QQBrowser", 2, "Pre_Load_async_create_webview_engine, cost=" + (l2 - l1));
            }
            if (QLog.isColorLevel()) {
              QLog.d("PreloadService", 2, "asyncPreload end");
            }
            return;
          }
          if (aqyc.l(???))
          {
            aqyc.d = WebAccelerateHelper.getInstance().createWebViewPluginEngine(???, null, null, gL());
            aqyc.cWU = true;
          }
        }
      }
      QLog.d("PreloadService", 2, "async preload:already inited.");
    }
    
    public void a(AppInterface paramAppInterface, Context paramContext, long paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadService", 2, "asyncPreload app = " + paramAppInterface);
      }
      if (paramAppInterface == null) {
        return;
      }
      egp();
      ThreadManager.postImmediately(new PreloadService.PreloadImpl.1(this, paramAppInterface), null, true);
    }
    
    protected List<WebViewPlugin> gL()
    {
      return null;
    }
  }
  
  public static class b
  {
    public int edE;
    public int edF;
    public int total;
    public int type;
    
    b(int paramInt)
    {
      this.type = paramInt;
      this.total = 0;
      this.edE = 0;
      this.edF = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqyc
 * JD-Core Version:    0.7.0.1
 */