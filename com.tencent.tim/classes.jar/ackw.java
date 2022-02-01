import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class ackw
  extends Handler
{
  ackw(ackv paramackv, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      this.a.cMf();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RegisterProxySvcPack", 2, new Object[] { "real notify pcStatus:", Integer.valueOf(ackv.a(this.a)), " ,devStatus:", Integer.valueOf(ackv.b(this.a)), " ,clientType:", Long.valueOf(ackv.a(this.a)), " ,appid:", Long.valueOf(ackv.b(this.a)) });
      }
      this.a.notifyUI(2, true, new Object[] { Integer.valueOf(ackv.b(this.a)) });
    } while (ackv.b(this.a) != 0);
    if (!this.a.mHandler.hasMessages(101)) {
      this.a.mHandler.sendEmptyMessageDelayed(101, 3000L);
    }
    aqel.setMute(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ackw
 * JD-Core Version:    0.7.0.1
 */