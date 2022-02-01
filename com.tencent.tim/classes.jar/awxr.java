import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.1.1;
import mqq.os.MqqHandler;

public class awxr
  implements INetEventHandler
{
  awxr(awxq paramawxq) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new AEBottomListAdapter.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awxr
 * JD-Core Version:    0.7.0.1
 */