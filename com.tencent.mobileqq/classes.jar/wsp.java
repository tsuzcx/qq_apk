import com.tencent.biz.videostory.capture.AEVideoStoryDashboardPart.6.1;
import com.tencent.mobileqq.app.ThreadManager;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import mqq.os.MqqHandler;

public class wsp
  implements EIPCResultCallback
{
  wsp(wsj paramwsj) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    ThreadManager.getUIHandler().post(new AEVideoStoryDashboardPart.6.1(this, paramEIPCResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wsp
 * JD-Core Version:    0.7.0.1
 */