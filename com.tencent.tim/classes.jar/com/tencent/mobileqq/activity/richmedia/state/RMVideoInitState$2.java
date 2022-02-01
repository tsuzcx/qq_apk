package com.tencent.mobileqq.activity.richmedia.state;

import aasz;
import acfp;
import anii;
import com.tencent.qphone.base.util.QLog;

public class RMVideoInitState$2
  implements Runnable
{
  public RMVideoInitState$2(aasz paramaasz) {}
  
  public void run()
  {
    boolean bool = anii.isFoundProductFeature(anii.KEY_CAMERA_OPEN_BLOCK_CHOOSE_PERMITTED_MODEL);
    if (bool)
    {
      RMVideoStateMgr.a().j(1102, acfp.m(2131713940), true);
      return;
    }
    try
    {
      if ((!this.this$0.byQ) && (this.this$0.byS)) {
        RMVideoStateMgr.a().j(1102, acfp.m(2131713946) + 1102, true);
      }
      RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
      if (QLog.isColorLevel()) {
        QLog.e("RMVideoInitState", 2, "[ERR_CODE_INIT_TIMEOUT]初始化失败,code=1102 mIsReadAVCodec=" + this.this$0.byO + " mIsReadCamera=" + this.this$0.byP + " black=" + bool + " rmStateMgr.mIsAudioReady=" + localRMVideoStateMgr.byX + " rmStateMgr.mVideoFileDir=" + localRMVideoStateMgr.bdG);
      }
      RMVideoStateMgr.AR(null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.2
 * JD-Core Version:    0.7.0.1
 */