import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.MultiVideoCtrlLayerUI;
import com.tencent.qphone.base.util.QLog;

class bjo
  implements Runnable
{
  bjo(bjn parambjn) {}
  
  public void run()
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "AutoCheckVideoRunnable");
    }
    SessionInfo localSessionInfo;
    if (this.a.a.a != null)
    {
      this.a.a.a.a().p = true;
      this.a.a.a.a().q = true;
      this.a.a.a.a().r = true;
      if (this.a.a.a.a().p)
      {
        localSessionInfo = this.a.a.a.a();
        if (this.a.a.a(true, true, true, true)) {
          break label136;
        }
      }
    }
    for (;;)
    {
      localSessionInfo.p = bool;
      return;
      label136:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bjo
 * JD-Core Version:    0.7.0.1
 */