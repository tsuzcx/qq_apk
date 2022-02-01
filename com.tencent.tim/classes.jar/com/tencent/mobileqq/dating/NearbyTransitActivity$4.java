package com.tencent.mobileqq.dating;

import ajrk;
import anpc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class NearbyTransitActivity$4
  implements Runnable
{
  NearbyTransitActivity$4(int paramInt, String paramString, boolean paramBoolean, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(this.val$reason));
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance(this.val$uin, "actEnterHotChatAIO", this.bgh, this.val$cost, this.val$reason, localHashMap, "");
    if (QLog.isDevelopLevel()) {
      ajrk.f("NearbyTransitActivity", "reportResult", new Object[] { "end of report" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.NearbyTransitActivity.4
 * JD-Core Version:    0.7.0.1
 */