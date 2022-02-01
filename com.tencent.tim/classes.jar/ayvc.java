import android.os.FileObserver;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMFileEventNotify.1;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;

public class ayvc
  extends FileObserver
{
  private boolean isStopped;
  
  private void cxY()
  {
    if (!this.isStopped)
    {
      this.isStopped = true;
      RMVideoStateMgr.a().runOnUiThread(new RMFileEventNotify.1(this));
    }
  }
  
  public void onEvent(int paramInt, String paramString)
  {
    if ((paramInt & 0x20) == 32) {
      if (QLog.isColorLevel()) {
        QLog.d("RMFileEventNotify", 2, "RMFileEventNotify[onEvent][OPEN]  path=" + paramString);
      }
    }
    do
    {
      return;
      if ((paramInt & 0x400) == 1024)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RMFileEventNotify", 2, "RMFileEventNotify[onEvent][DELETE_SELF]  path=" + paramString);
        }
        cxY();
        return;
      }
      if ((paramInt & 0x200) == 512)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RMFileEventNotify", 2, "RMFileEventNotify[onEvent][DELETE]  path=" + paramString);
        }
        cxY();
        return;
      }
    } while ((paramInt & 0x8) != 8);
    if (QLog.isColorLevel()) {
      QLog.d("RMFileEventNotify", 2, "RMFileEventNotify[onEvent][CLOSE_WRITE]  path=" + paramString);
    }
    cxY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayvc
 * JD-Core Version:    0.7.0.1
 */