package com.tencent.mobileqq.activity.richmedia.state;

import aatb;
import acfp;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.qphone.base.util.QLog;

public class RMVideoRecordState$2
  implements Runnable
{
  public RMVideoRecordState$2(aatb paramaatb) {}
  
  public void run()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] EVENT_READ_MIC [error]麦克风读取数据错误...");
    }
    localRMVideoStateMgr.bzc = true;
    localRMVideoStateMgr.byY = false;
    if (localRMVideoStateMgr.a != null)
    {
      if (localRMVideoStateMgr.a.dyv != -1) {
        break label95;
      }
      localRMVideoStateMgr.l(0, acfp.m(2131713956), false);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RMRecordState", 2, "[@] EVENT_READ_MIC [error]麦克风被禁用,音频录制失败 errorcode=" + localRMVideoStateMgr.a.dyv);
      }
      return;
      label95:
      if (localRMVideoStateMgr.a.dyv == -2) {
        localRMVideoStateMgr.l(0, acfp.m(2131713961), false);
      } else if (localRMVideoStateMgr.a.dyv == -3) {
        localRMVideoStateMgr.l(0, acfp.m(2131713963), false);
      } else {
        localRMVideoStateMgr.l(0, acfp.m(2131713959), false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState.2
 * JD-Core Version:    0.7.0.1
 */