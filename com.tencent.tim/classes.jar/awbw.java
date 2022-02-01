import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.thread.QzoneThreadMonitor;
import cooperation.qzone.thread.QzoneThreadMonitor.a;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.exception.QZoneStartupFailException;
import java.util.concurrent.ConcurrentHashMap;

public class awbw
  extends Handler
{
  public awbw(QzoneThreadMonitor paramQzoneThreadMonitor, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    QzoneThreadMonitor.a locala = (QzoneThreadMonitor.a)paramMessage.obj;
    if (!QzoneThreadMonitor.access$000(this.a).containsKey(locala.id))
    {
      QZLog.w("QzoneThreadMonitor", 1, new Object[] { "massage has been canceled. id=", locala.id });
      return;
    }
    if (paramMessage.arg1 >= 10)
    {
      QZLog.w("QzoneThreadMonitor", 1, new Object[] { "stack check for too many times. id=", locala.id });
      return;
    }
    Object localObject = QzoneThreadMonitor.access$100(QzoneHandlerThreadFactory.getHandlerThreadLooper(locala.threadName).getThread().getStackTrace(), locala.threadName + " id=" + locala.id + ": ");
    QZLog.w("QzoneThreadMonitor", 1, new Object[] { "[stack] ", locala.threadName, " id=", locala.id, " what=", Integer.valueOf(locala.what), " msg.target=", locala.target, " msg.callback=", locala.callback });
    QZLog.w("QzoneThreadMonitor", 1, new Object[] { localObject });
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "report_backgroudmonitor", "0").equals("1")) {
      awcz.h(new QZoneStartupFailException(new Throwable((String)localObject)), ((String)localObject).toString());
    }
    paramMessage = Message.obtain(QzoneThreadMonitor.access$200(this.a), 1, paramMessage.arg1 + 1, 0, locala);
    localObject = QzoneThreadMonitor.access$200(this.a);
    if (locala.type == 1) {}
    for (long l = 500L;; l = 250L)
    {
      ((Handler)localObject).sendMessageDelayed(paramMessage, l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awbw
 * JD-Core Version:    0.7.0.1
 */