import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPicAdapter;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPicData;
import com.tencent.qphone.base.util.QLog;

public class wdz
  extends Handler
{
  public wdz(ZhituManager paramZhituManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int i;
    do
    {
      do
      {
        return;
        paramMessage = (ZhituPicData)paramMessage.obj;
        if (QLog.isColorLevel()) {
          QLog.d("ZhituManager", 2, ZhituManager.a(paramMessage.d, "main handler", paramMessage.a, "all img process is finished, now is in main thread"));
        }
        this.a.d(paramMessage);
        return;
        i = paramMessage.arg1;
        paramMessage = (String)paramMessage.obj;
        if (paramMessage.equals(this.a.a())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ZhituManager", 2, ZhituManager.a(paramMessage, "main handler", "reqKey is outdated, skip"));
      return;
    } while (this.a.a == null);
    this.a.a.a(i, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wdz
 * JD-Core Version:    0.7.0.1
 */