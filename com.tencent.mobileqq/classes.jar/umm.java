import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class umm
  implements Handler.Callback
{
  umm(umk paramumk) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      if (System.currentTimeMillis() - umk.a(this.a) > 1500L)
      {
        umk.a(this.a, false);
        QLog.d("ReadInJoySuperMaskAd", 2, "time up do not update volume");
      }
      if (umk.b(this.a))
      {
        umk.a(this.a).sendEmptyMessageDelayed(1, 300L);
        this.a.d();
        return false;
      }
      umk.a(this.a).removeMessages(1);
      return false;
    }
    umk.a(this.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     umm
 * JD-Core Version:    0.7.0.1
 */