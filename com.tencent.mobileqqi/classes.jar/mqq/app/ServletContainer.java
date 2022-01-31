package mqq.app;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServletContainer
{
  private static final long SCAN_INTERVAL = 60000L;
  private final Map<String, Set<String>> actionMap = new HashMap();
  private AppRuntime app;
  private Handler mHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      long l = SystemClock.uptimeMillis();
      if (!ServletContainer.this.managedServlet.isEmpty())
      {
        paramAnonymousMessage = ServletContainer.this.managedServlet.entrySet().iterator();
        while (paramAnonymousMessage.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramAnonymousMessage.next();
          String str = (String)localEntry.getKey();
          if (l > ((Servlet)localEntry.getValue()).getLastAccessTime())
          {
            ServletContainer.this.needDestory.push(str);
            QLog.d("ServletContainer", 2, "ServletContainer time > value.getLastAccessTime() and push key");
          }
        }
        while (!ServletContainer.this.needDestory.isEmpty())
        {
          paramAnonymousMessage = (String)ServletContainer.this.needDestory.pop();
          ((Servlet)ServletContainer.this.managedServlet.remove(paramAnonymousMessage)).onDestroy();
        }
      }
      if ((ServletContainer.this.app != null) && (ServletContainer.this.app.isRunning())) {
        sendEmptyMessageAtTime(0, SystemClock.uptimeMillis() + 60000L);
      }
    }
  };
  private ExecutorService mService = Executors.newSingleThreadExecutor();
  final ConcurrentHashMap<String, Servlet> managedServlet = new ConcurrentHashMap();
  final Stack<String> needDestory = new Stack();
  
  public ServletContainer(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
    this.mHandler.sendEmptyMessageAtTime(0, SystemClock.uptimeMillis() + 60000L);
  }
  
  private Servlet getServlet(String paramString)
  {
    Servlet localServlet = (Servlet)this.managedServlet.get(paramString);
    Object localObject = localServlet;
    if (localServlet == null) {
      try
      {
        localObject = Class.forName(paramString);
      }
      catch (Exception localException)
      {
        try
        {
          Class localClass;
          for (;;)
          {
            localServlet = (Servlet)((Class)localObject).newInstance();
            localServlet.init(this.app, this);
            localServlet.onCreate();
            this.managedServlet.put(paramString, localServlet);
            localObject = localServlet;
            if (!(localServlet instanceof MSFServlet)) {
              break;
            }
            String[] arrayOfString = ((MSFServlet)localServlet).getPreferSSOCommands();
            localObject = localServlet;
            if (arrayOfString == null) {
              break;
            }
            int j = arrayOfString.length;
            int i = 0;
            for (;;)
            {
              localObject = localServlet;
              if (i >= j) {
                break;
              }
              String str = arrayOfString[i];
              Set localSet = (Set)this.actionMap.get(str);
              localObject = localSet;
              if (localSet == null)
              {
                localObject = new HashSet();
                this.actionMap.put(str, localObject);
              }
              ((Set)localObject).add(paramString);
              i += 1;
            }
            localException = localException;
            localClass = this.app.getClass().getClassLoader().loadClass(paramString);
          }
          return localClass;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          return null;
        }
      }
    }
  }
  
  public void destroy()
  {
    this.mService.shutdown();
    this.mHandler.removeMessages(0);
    this.mHandler.removeCallbacksAndMessages(null);
    Iterator localIterator = this.managedServlet.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((Servlet)((Map.Entry)localIterator.next()).getValue()).onDestroy();
    }
    this.managedServlet.clear();
  }
  
  public void forward(AppRuntime paramAppRuntime, final Intent paramIntent)
  {
    paramAppRuntime = new Runnable()
    {
      public void run()
      {
        try
        {
          Servlet localServlet = ServletContainer.this.getServlet(this.val$className);
          if (localServlet != null)
          {
            localServlet.service(paramIntent);
            localServlet.updateAccessTime();
          }
          return;
        }
        catch (Exception localException)
        {
          QLog.e("mqq", 2, "[Servlet service]" + localException.toString());
          localException.printStackTrace();
        }
      }
    };
    boolean bool = false;
    if ((paramIntent instanceof NewIntent)) {
      bool = ((NewIntent)paramIntent).runNow;
    }
    if ((bool) || (Thread.currentThread() != Looper.getMainLooper().getThread()))
    {
      paramAppRuntime.run();
      return;
    }
    if (!this.mService.isShutdown())
    {
      this.mService.execute(paramAppRuntime);
      return;
    }
    QLog.e("mqq", 2, "ServletContainer has destoryed," + paramIntent.getComponent().getClassName() + " can not be started.");
  }
  
  public void notifyMSFServlet(Class<? extends MSFServlet> paramClass, FromServiceMsg paramFromServiceMsg)
  {
    Class<? extends MSFServlet> localClass = null;
    if (paramClass != null)
    {
      paramClass = (MSFServlet)getServlet(paramClass.getName());
      localClass = paramClass;
      if (paramClass != null)
      {
        paramClass.onReceive(paramFromServiceMsg);
        localClass = paramClass;
      }
    }
    paramClass = (Set)this.actionMap.get(paramFromServiceMsg.getServiceCmd());
    if (paramClass != null)
    {
      paramClass = paramClass.iterator();
      while (paramClass.hasNext())
      {
        MSFServlet localMSFServlet = (MSFServlet)getServlet((String)paramClass.next());
        if ((localMSFServlet != null) && (localMSFServlet != localClass)) {
          localMSFServlet.onReceive(paramFromServiceMsg);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     mqq.app.ServletContainer
 * JD-Core Version:    0.7.0.1
 */