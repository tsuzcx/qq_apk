import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class trv
  implements Handler.Callback
{
  trv(trt paramtrt) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      if (System.currentTimeMillis() - trt.a(this.a) > 1500L)
      {
        trt.a(this.a, false);
        QLog.d("KandianAdPandent", 2, "time up do not update volume");
      }
      if (trt.b(this.a))
      {
        trt.a(this.a).sendEmptyMessageDelayed(1, 300L);
        this.a.d();
        return false;
      }
      trt.a(this.a).removeMessages(1);
      return false;
    }
    trt.a(this.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trv
 * JD-Core Version:    0.7.0.1
 */