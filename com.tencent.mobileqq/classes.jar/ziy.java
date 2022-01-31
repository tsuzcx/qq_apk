import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.qphone.base.util.QLog;

public class ziy
  extends Handler
{
  public ziy(RegisterProxySvcPackHandler paramRegisterProxySvcPackHandler, Looper paramLooper)
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
      this.a.c();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RegisterProxySvcPack", 2, "real notify|iState:" + RegisterProxySvcPackHandler.a(this.a) + ", clientType:" + RegisterProxySvcPackHandler.a(this.a) + ", appId:" + RegisterProxySvcPackHandler.b(this.a));
      }
      this.a.a(2, true, new Object[] { Integer.valueOf(RegisterProxySvcPackHandler.a(this.a)), Long.valueOf(RegisterProxySvcPackHandler.a(this.a)), Long.valueOf(RegisterProxySvcPackHandler.b(this.a)) });
    } while ((RegisterProxySvcPackHandler.a(this.a) != 0) || (this.a.a.hasMessages(101)));
    this.a.a.sendEmptyMessageDelayed(101, 3000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ziy
 * JD-Core Version:    0.7.0.1
 */