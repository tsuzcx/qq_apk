package cooperation.qzone.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Printer;
import awbw;
import awbx;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;

public class QzoneThreadMonitor
{
  private static final int MAX_CHECK_THREAD_TIME = 10;
  private static final int MSG_CHECK_THREAD = 1;
  private static final String TAG = "QzoneThreadMonitor";
  private static final long THREAD_CHECK_INTERVAL_NORMAL = 500L;
  private static final long THREAD_CHECK_INTERVAL_REAL_TIME = 250L;
  private static final long THREAD_CHECK_THRESHOLD_NORMAL = 2000L;
  private static final long THREAD_CHECK_THRESHOLD_REAL_TIME = 500L;
  private static final long THREAD_DELAY_WARN_THRESHOLD = 2000L;
  private static final long THREAD_DELAY_WARN_THRESHOLD_REAL_TIME = 500L;
  public static boolean enableMonitor;
  private static QzoneThreadMonitor instance;
  private Printer handlerDumpPrinter = new awbx(this);
  private ConcurrentHashMap<String, a> id2Msg = new ConcurrentHashMap(8, 0.75F, 2);
  private Handler monitorHandler;
  private List<String> realTimeThreadNames = Arrays.asList(new String[] { "RealTime_HandlerThread" });
  private List<String> slowThreadNames = Arrays.asList(new String[] { "Report_HandlerThread" });
  private HashMap<String, PriorityBlockingQueue<a>> thread2Msg = new HashMap();
  
  private QzoneThreadMonitor()
  {
    HandlerThread localHandlerThread = new HandlerThread("qzone_thread_monitor_debug");
    localHandlerThread.start();
    this.monitorHandler = new awbw(this, localHandlerThread.getLooper());
  }
  
  private static String buildStackTraceString(StackTraceElement[] paramArrayOfStackTraceElement, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayOfStackTraceElement != null) && (paramArrayOfStackTraceElement.length > 0))
    {
      int j = paramArrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        StackTraceElement localStackTraceElement = paramArrayOfStackTraceElement[i];
        localStringBuilder.append(paramString).append(localStackTraceElement.toString()).append('\n');
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static QzoneThreadMonitor getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new QzoneThreadMonitor();
      }
      return instance;
    }
    finally {}
  }
  
  void beginHandle(BaseHandler paramBaseHandler, Message paramMessage, long paramLong)
  {
    if (!enableMonitor) {
      break label6;
    }
    label6:
    String str;
    a locala;
    for (;;)
    {
      return;
      if ((paramBaseHandler != null) && (paramMessage != null)) {
        try
        {
          paramBaseHandler = paramBaseHandler.getLooper().getThread().getName();
          if (QzoneHandlerThreadFactory.mHandlerThreadMap.containsKey(paramBaseHandler))
          {
            str = String.valueOf(paramMessage.hashCode()) + paramMessage.getWhen();
            locala = (a)this.id2Msg.get(str);
            if (locala == null)
            {
              QZLog.w("QzoneThreadMonitor", 1, new Object[] { "massage info missing. id=", str });
              return;
            }
          }
        }
        catch (Exception paramBaseHandler)
        {
          QLog.w("QzoneThreadMonitor", 1, "beginHandle exception:", paramBaseHandler);
          return;
        }
      }
    }
    locala.aAK = paramLong;
    long l = paramLong - locala.aAJ;
    if (locala.type != 3) {
      if (locala.type != 1) {
        break label385;
      }
    }
    label385:
    for (paramLong = 2000L;; paramLong = 500L)
    {
      if (l > paramLong) {
        QZLog.w("QzoneThreadMonitor", 1, new Object[] { "[begin handle] ", paramBaseHandler, " id=", str + " delay=", Long.valueOf(l), " what=", paramMessage.what + " msg.target=", locala.target, " msg.callback=", locala.callback });
      }
      paramMessage = (PriorityBlockingQueue)this.thread2Msg.get(paramBaseHandler);
      if (paramMessage == null) {
        break;
      }
      for (paramBaseHandler = (a)paramMessage.peek(); (paramBaseHandler != null) && (paramBaseHandler.aAJ < locala.aAJ); paramBaseHandler = (a)paramMessage.peek()) {
        paramMessage.poll();
      }
      if (locala.type == 3) {
        break;
      }
      paramBaseHandler = Message.obtain(this.monitorHandler, 1, 0, 0, locala);
      paramMessage = this.monitorHandler;
      if (locala.type == 1) {}
      for (paramLong = 2000L;; paramLong = 500L)
      {
        paramMessage.sendMessageDelayed(paramBaseHandler, paramLong);
        return;
      }
    }
  }
  
  public void dump(BaseHandler paramBaseHandler)
  {
    if (!enableMonitor) {}
    while ((paramBaseHandler == null) || (!QLog.isDevelopLevel())) {
      return;
    }
    QLog.d("QzoneThreadMonitor", 4, "======================================================================================");
    paramBaseHandler.dump(this.handlerDumpPrinter, "|| ");
    QLog.d("QzoneThreadMonitor", 4, "======================================================================================");
  }
  
  void enqueue(BaseHandler paramBaseHandler, Message paramMessage, long paramLong)
  {
    if (!enableMonitor) {}
    while ((paramBaseHandler == null) || (paramMessage == null)) {
      return;
    }
    for (;;)
    {
      String str1;
      int i;
      try
      {
        str1 = paramBaseHandler.getLooper().getThread().getName();
        if (!QzoneHandlerThreadFactory.mHandlerThreadMap.containsKey(str1)) {
          break;
        }
        String str2 = String.valueOf(paramMessage.hashCode()) + paramLong;
        if (paramMessage.getTarget() == null)
        {
          paramBaseHandler = "null";
          if (paramMessage.getCallback() != null) {
            break label213;
          }
          localObject = "null";
          i = 1;
          if (!this.realTimeThreadNames.contains(str1)) {
            break label225;
          }
          i = 2;
          localObject = new a(str2, str1, paramMessage.what, paramBaseHandler, (String)localObject, paramLong, i);
          this.id2Msg.put(str2, localObject);
          paramMessage = (PriorityBlockingQueue)this.thread2Msg.get(str1);
          paramBaseHandler = paramMessage;
          if (paramMessage == null)
          {
            paramBaseHandler = new PriorityBlockingQueue();
            this.thread2Msg.put(str1, paramBaseHandler);
          }
          paramBaseHandler.put(localObject);
          return;
        }
      }
      catch (Exception paramBaseHandler)
      {
        QLog.w("QzoneThreadMonitor", 1, "enqueue exception:", paramBaseHandler);
        return;
      }
      paramBaseHandler = paramMessage.getTarget().toString();
      continue;
      label213:
      Object localObject = paramMessage.getCallback().toString();
      continue;
      label225:
      boolean bool = this.slowThreadNames.contains(str1);
      if (bool) {
        i = 3;
      }
    }
  }
  
  void finishHandle(BaseHandler paramBaseHandler, Message paramMessage, long paramLong)
  {
    if (!enableMonitor) {
      break label6;
    }
    label6:
    String str1;
    String str2;
    for (;;)
    {
      return;
      if ((paramBaseHandler != null) && (paramMessage != null)) {
        try
        {
          str1 = paramBaseHandler.getLooper().getThread().getName();
          if (QzoneHandlerThreadFactory.mHandlerThreadMap.containsKey(str1))
          {
            str2 = String.valueOf(paramMessage.hashCode()) + paramMessage.getWhen();
            paramBaseHandler = (a)this.id2Msg.remove(str2);
            if (paramBaseHandler == null)
            {
              QZLog.w("QzoneThreadMonitor", 1, new Object[] { "massage info missing. id=", str2 });
              return;
            }
          }
        }
        catch (Exception paramBaseHandler)
        {
          QLog.w("QzoneThreadMonitor", 1, "finishHandle exception:", paramBaseHandler);
          return;
        }
      }
    }
    this.monitorHandler.removeMessages(1, paramBaseHandler);
    paramBaseHandler.finishTime = paramLong;
    long l = paramLong - paramBaseHandler.aAK;
    if (paramBaseHandler.type != 3) {
      if (paramBaseHandler.type != 1) {
        break label304;
      }
    }
    label304:
    for (paramLong = 2000L;; paramLong = 500L)
    {
      if (l > paramLong) {
        QZLog.w("QzoneThreadMonitor", 1, new Object[] { "[finish handle] ", str1, " id=", str2 + " cost=", Long.valueOf(l), " what=", paramMessage.what + " msg.target=", paramBaseHandler.target, " msg.callback=", paramBaseHandler.callback });
      }
      paramMessage = (PriorityBlockingQueue)this.thread2Msg.get(str1);
      if (paramMessage == null) {
        break;
      }
      paramMessage.remove(paramBaseHandler);
      return;
    }
  }
  
  public class a
    implements Comparable<a>
  {
    public long aAJ;
    public long aAK = -1L;
    public String callback;
    public long finishTime = -1L;
    public String id;
    public String target;
    public String threadName;
    public int type;
    public int what;
    
    public a(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, long paramLong, int paramInt2)
    {
      this.id = paramString1;
      this.threadName = paramString2;
      this.what = paramInt1;
      this.target = paramString3;
      this.callback = paramString4;
      this.aAJ = paramLong;
      this.type = paramInt2;
    }
    
    public int a(@NonNull a parama)
    {
      return (int)(this.aAJ - parama.aAJ);
    }
    
    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof a)) && (this.id.equals(((a)paramObject).id));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.thread.QzoneThreadMonitor
 * JD-Core Version:    0.7.0.1
 */