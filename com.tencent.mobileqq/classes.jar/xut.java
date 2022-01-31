import android.os.FileObserver;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.qphone.base.util.QLog;

public class xut
  extends FileObserver
{
  private boolean a;
  
  private void a()
  {
    if (!this.a)
    {
      this.a = true;
      RMVideoStateMgr.a().a(new xuu(this));
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
        a();
        return;
      }
      if ((paramInt & 0x200) == 512)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RMFileEventNotify", 2, "RMFileEventNotify[onEvent][DELETE]  path=" + paramString);
        }
        a();
        return;
      }
    } while ((paramInt & 0x8) != 8);
    if (QLog.isColorLevel()) {
      QLog.d("RMFileEventNotify", 2, "RMFileEventNotify[onEvent][CLOSE_WRITE]  path=" + paramString);
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xut
 * JD-Core Version:    0.7.0.1
 */