import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class iox
  extends ill
{
  iox(iow paramiow) {}
  
  void cs(long paramLong)
  {
    Message localMessage = this.b.mHandler.obtainMessage(4);
    localMessage.obj = Long.valueOf(paramLong);
    localMessage.sendToTarget();
  }
  
  protected void d(long paramLong, boolean paramBoolean, int paramInt)
  {
    QLog.w(iow.TAG, 1, "onAfterOpenCamera, success[" + paramBoolean + "], preSessionType[" + paramInt + "], seq[" + paramLong + "]");
    if (paramBoolean) {
      cs(paramLong);
    }
  }
  
  protected void iq(boolean paramBoolean)
  {
    long l = AudioHelper.hG();
    QLog.w(iow.TAG, 1, "onAfterReopenCamera, success[" + paramBoolean + "], seq[" + l + "]");
    if (paramBoolean) {
      cs(l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iox
 * JD-Core Version:    0.7.0.1
 */