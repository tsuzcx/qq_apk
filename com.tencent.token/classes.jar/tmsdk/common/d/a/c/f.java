package tmsdk.common.d.a.c;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class f
  extends Handler
{
  private WeakReference a = null;
  
  public f(b paramb)
  {
    super(paramb.a().getMainLooper());
    this.a = new WeakReference(paramb);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    paramMessage = (b)this.a.get();
    if (paramMessage == null) {
      return;
    }
    paramMessage.e();
    a.a(paramMessage.a(), "com.tencent.tmsdk.HeartBeatPlot.ACTION_HEARTBEAT_PLOT_ALARM_CYCLE", paramMessage.f());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.c.f
 * JD-Core Version:    0.7.0.1
 */