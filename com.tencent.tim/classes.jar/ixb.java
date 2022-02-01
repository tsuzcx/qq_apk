import android.os.MessageQueue.IdleHandler;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.AVActivity.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ixb
  implements MessageQueue.IdleHandler
{
  public ixb(AVActivity paramAVActivity) {}
  
  public boolean queueIdle()
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.this$0.TAG, 1, "call IdleHandler mPeerUin:=" + this.this$0.mPeerUin);
    }
    ThreadManager.getSubThreadHandler().postDelayed(new AVActivity.1.1(this), 2000L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ixb
 * JD-Core Version:    0.7.0.1
 */