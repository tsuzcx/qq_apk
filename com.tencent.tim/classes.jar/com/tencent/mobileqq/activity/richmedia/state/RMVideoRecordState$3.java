package com.tencent.mobileqq.activity.richmedia.state;

import aatb;
import aatf;
import ram;

public class RMVideoRecordState$3
  implements Runnable
{
  public RMVideoRecordState$3(aatb paramaatb) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState.3
 * JD-Core Version:    0.7.0.1
 */