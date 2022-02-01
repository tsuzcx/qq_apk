import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.AppRuntime;

class aogu
  extends Handler
{
  aogu(aogs paramaogs, Looper paramLooper)
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
      do
      {
        return;
      } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof Bundle)));
      this.b.M(paramMessage.arg1, (Bundle)paramMessage.obj);
      return;
    } while (this.b.mRuntime == null);
    QQToast.a(this.b.mRuntime.getApplication(), acfp.m(2131709139), 4000).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aogu
 * JD-Core Version:    0.7.0.1
 */