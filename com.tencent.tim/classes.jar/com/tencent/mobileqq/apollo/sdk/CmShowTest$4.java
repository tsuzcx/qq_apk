package com.tencent.mobileqq.apollo.sdk;

import absr;

public final class CmShowTest$4
  implements Runnable
{
  public CmShowTest$4(CmShowRenderView paramCmShowRenderView) {}
  
  public void run()
  {
    CmShowRenderView.PlayActionConfig localPlayActionConfig = new CmShowRenderView.PlayActionConfig();
    localPlayActionConfig.mActionId = 300272;
    int i = absr.crr + 1;
    absr.crr = i;
    localPlayActionConfig.crn = i;
    localPlayActionConfig.bFa = true;
    localPlayActionConfig.cri = 2;
    localPlayActionConfig.mLoop = true;
    localPlayActionConfig.mUin = "1174992642";
    this.b.a(localPlayActionConfig);
    this.b.postDelayed(new CmShowTest.4.1(this), 4000L);
    this.b.k("1669140032", "测试空间气泡", 1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowTest.4
 * JD-Core Version:    0.7.0.1
 */