import com.tencent.biz.videostory.capture.AEBottomListAdapter.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import mqq.os.MqqHandler;

public class wqm
  implements INetEventHandler
{
  wqm(wql paramwql) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new AEBottomListAdapter.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wqm
 * JD-Core Version:    0.7.0.1
 */