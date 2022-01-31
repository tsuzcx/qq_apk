import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMViewSTInterface;

public class xrz
  implements Runnable
{
  public xrz(RMVideoRecordState paramRMVideoRecordState) {}
  
  public void run()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (!localRMVideoStateMgr.b())
    {
      SLog.c("RMRecordState", "run record finish, but state is not right");
      return;
    }
    this.a.b();
    localRMVideoStateMgr.a.z();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xrz
 * JD-Core Version:    0.7.0.1
 */