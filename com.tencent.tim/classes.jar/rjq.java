import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

class rjq
  extends pue
{
  rjq(rjp paramrjp, pmy parampmy, long paramLong)
  {
    super(parampmy);
  }
  
  protected void a(pue.b paramb)
  {
    if (paramb.errorCode == 0)
    {
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.val$startTime;
      if (QLog.isColorLevel()) {
        QLog.d("FileDownloadTask", 2, "startDownloadVCImage success, cost:" + (l1 - l2));
      }
      rjp.access$000().sendMessage(Message.obtain(rjp.access$000(), 1, null));
    }
    for (;;)
    {
      rjp.a(this.a);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FileDownloadTask", 2, "startDownloadVCImage error:" + paramb.errorCode + ", errMsg:" + paramb.errorMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rjq
 * JD-Core Version:    0.7.0.1
 */