import android.os.MessageQueue.IdleHandler;
import com.tencent.qphone.base.util.QLog;

class wss
  implements MessageQueue.IdleHandler
{
  wss(wsr paramwsr) {}
  
  public boolean queueIdle()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatDrawer", 2, "queueIdle");
    }
    if (wsp.RN()) {
      this.b.cbw();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wss
 * JD-Core Version:    0.7.0.1
 */