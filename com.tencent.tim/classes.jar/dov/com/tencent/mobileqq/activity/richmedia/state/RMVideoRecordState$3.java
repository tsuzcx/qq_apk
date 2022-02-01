package dov.com.tencent.mobileqq.activity.richmedia.state;

import ayvh;
import ayvl;
import ram;

public class RMVideoRecordState$3
  implements Runnable
{
  public RMVideoRecordState$3(ayvh paramayvh) {}
  
  public void run()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (!localRMVideoStateMgr.Xc())
    {
      ram.i("RMRecordState", "run record finish, but state is not right");
      return;
    }
    this.this$0.cxZ();
    localRMVideoStateMgr.a.cwI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState.3
 * JD-Core Version:    0.7.0.1
 */