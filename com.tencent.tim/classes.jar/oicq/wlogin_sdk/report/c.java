package oicq.wlogin_sdk.report;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import oicq.wlogin_sdk.listener.ReportListener;
import oicq.wlogin_sdk.report.event.EventSaver;
import oicq.wlogin_sdk.report.event.b;
import oicq.wlogin_sdk.request.u;
import oicq.wlogin_sdk.tools.util;

public class c
  implements Handler.Callback
{
  public ReportListener a = null;
  public final EventSaver b = new EventSaver();
  private HandlerThread c = new HandlerThread("CostTracer");
  private Handler d;
  
  private c()
  {
    try
    {
      this.c.start();
      if (this.c.isAlive()) {
        this.d = new Handler(this.c.getLooper(), this);
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void a()
  {
    if (a.a.d != null) {
      a.a.d.sendEmptyMessage(2);
    }
  }
  
  public static void a(Thread paramThread)
  {
    if (a.a.d != null)
    {
      Message localMessage = a.a.d.obtainMessage();
      localMessage.what = 1;
      localMessage.obj = paramThread;
      a.a.d.sendMessageDelayed(localMessage, 1000L);
    }
  }
  
  public static void a(ReportListener paramReportListener)
  {
    a.a.a = paramReportListener;
  }
  
  public static void a(b paramb)
  {
    if (a.a.d != null)
    {
      Message localMessage = a.a.d.obtainMessage();
      localMessage.what = 3;
      localMessage.obj = paramb;
      a.a.d.sendMessage(localMessage);
    }
  }
  
  public static void b(Thread paramThread)
  {
    if (a.a.d != null) {
      a.a.d.removeMessages(1, paramThread);
    }
  }
  
  public static void b(b paramb)
  {
    if (a.a.d != null)
    {
      Message localMessage = a.a.d.obtainMessage();
      localMessage.what = 4;
      localMessage.obj = paramb;
      a.a.d.sendMessage(localMessage);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      paramMessage = (Thread)paramMessage.obj;
      Iterator localIterator = Thread.getAllStackTraces().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        Object localObject1 = (Thread)((Map.Entry)localObject2).getKey();
        localObject2 = (StackTraceElement[])((Map.Entry)localObject2).getValue();
        if (localObject1 == paramMessage)
        {
          localObject1 = new StringBuilder("    ");
          int i = 0;
          while (i < localObject2.length)
          {
            ((StringBuilder)localObject1).append(localObject2[i].getClassName() + ".").append(localObject2[i].getMethodName() + "(").append(localObject2[i].getFileName() + ":").append(localObject2[i].getLineNumber() + ")").append("\n");
            i += 1;
          }
          a.a().a(((StringBuilder)localObject1).toString());
        }
      }
      if (u.u != null)
      {
        a.a().a(u.u);
        continue;
        paramMessage = (b)paramMessage.obj;
        if (paramMessage != null)
        {
          if (this.a != null) {
            this.a.onReport(paramMessage.a(), paramMessage.c(), paramMessage.e(), paramMessage.f());
          }
          if (paramMessage.h())
          {
            oicq.wlogin_sdk.report.event.a.a(paramMessage);
            continue;
            paramMessage = (b)paramMessage.obj;
            if (paramMessage != null) {
              try
              {
                this.b.realSaveItem(u.u, paramMessage.a(), paramMessage.d());
              }
              catch (Exception paramMessage)
              {
                util.LOGI(util.LOG_TAG_EVENT_REPORT + Log.getStackTraceString(paramMessage), "");
              }
            } else {
              util.LOGI(util.LOG_TAG_EVENT_REPORT + "saveEvent error ,saveEvent = null", "");
            }
          }
        }
      }
    }
  }
  
  static final class a
  {
    public static final c a = new c(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.report.c
 * JD-Core Version:    0.7.0.1
 */