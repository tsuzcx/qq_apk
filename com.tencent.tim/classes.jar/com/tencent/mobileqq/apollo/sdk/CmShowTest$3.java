package com.tencent.mobileqq.apollo.sdk;

import com.tencent.qphone.base.util.QLog;

public final class CmShowTest$3
  implements Runnable
{
  public void run()
  {
    QLog.i("CmShowTest", 1, "testPreAction");
    CmShowRenderView.PlayActionConfig localPlayActionConfig = new CmShowRenderView.PlayActionConfig();
    localPlayActionConfig.mActionId = 3000272;
    localPlayActionConfig.crn = 100;
    localPlayActionConfig.bFa = false;
    localPlayActionConfig.cri = 1;
    this.c.a(localPlayActionConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowTest.3
 * JD-Core Version:    0.7.0.1
 */