package cooperation.qlink;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import ian;
import java.util.Observable;
import java.util.Observer;

public class QQProxyForQlink$Listener
  implements Observer
{
  private void a(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return;
      paramObject = (Object[])paramObject;
      int i = ((Integer)paramObject[0]).intValue();
      paramObject = (Object[])paramObject[1];
      switch (i)
      {
      default: 
        QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ QQProxyForQlink listener upate err event:" + i);
        return;
      }
    } while (paramObject == null);
    a((String)paramObject[0]);
  }
  
  public void a(String paramString) {}
  
  public final void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      new Handler(paramObservable).post(new ian(this, paramObject));
      return;
    }
    a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qlink.QQProxyForQlink.Listener
 * JD-Core Version:    0.7.0.1
 */