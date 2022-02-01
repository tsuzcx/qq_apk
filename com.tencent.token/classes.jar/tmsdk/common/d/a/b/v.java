package tmsdk.common.d.a.b;

import a.e.f;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class v
  extends Handler
{
  v(u paramu, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    f localf = new f();
    localf.d = -50004;
    localf.c = paramMessage.what;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seq : ");
    localStringBuilder.append(paramMessage.what);
    localStringBuilder.append("超时");
    localStringBuilder.toString();
    u.a(this.a, localf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.b.v
 * JD-Core Version:    0.7.0.1
 */