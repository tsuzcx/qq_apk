package com.tencent.mobileqq.activity.richmedia.state;

import aatb;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;

public class RMVideoRecordState$1
  implements Runnable
{
  public RMVideoRecordState$1(aatb paramaatb, RMVideoStateMgr paramRMVideoStateMgr) {}
  
  public void run()
  {
    if (this.b.a != null) {
      this.b.a.unlockFrameSync();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState.1
 * JD-Core Version:    0.7.0.1
 */