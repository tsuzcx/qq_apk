import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class tyo
  implements Handler.Callback
{
  tyo(tym paramtym) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      if (System.currentTimeMillis() - tym.a(this.a) > 1500L)
      {
        tym.a(this.a, false);
        QLog.d("ReadInJoySuperMaskAd", 2, "time up do not update volume");
      }
      if (tym.b(this.a))
      {
        tym.a(this.a).sendEmptyMessageDelayed(1, 300L);
        this.a.d();
        return false;
      }
      tym.a(this.a).removeMessages(1);
      return false;
    }
    tym.a(this.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tyo
 * JD-Core Version:    0.7.0.1
 */