package com.tencent.mobileqq.highway;

import com.tencent.mobileqq.highway.netprobe.WeakNetCallback;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;

class HwEngine$1
  implements WeakNetCallback
{
  HwEngine$1(HwEngine paramHwEngine) {}
  
  public void onResultOverflow(HashMap<String, String> paramHashMap)
  {
    if ((paramHashMap == null) || (paramHashMap.isEmpty())) {
      return;
    }
    BdhLogUtil.LogEvent("P", "probe result upload to dengta, count " + paramHashMap.size());
    RdmReq localRdmReq = new RdmReq();
    localRdmReq.isMerge = false;
    localRdmReq.isRealTime = true;
    localRdmReq.isSucceed = true;
    localRdmReq.eventName = "actWeaknetProbe";
    localRdmReq.elapse = 0L;
    localRdmReq.size = 0L;
    localRdmReq.params = paramHashMap;
    try
    {
      paramHashMap = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), localRdmReq);
      paramHashMap.setAppId(HwEngine.appId);
      paramHashMap.setTimeout(30000L);
      MsfServiceSdk.get().sendMsg(paramHashMap);
      return;
    }
    catch (Exception paramHashMap)
    {
      paramHashMap.printStackTrace();
      BdhLogUtil.LogException("P", "upload report has exception ", paramHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.HwEngine.1
 * JD-Core Version:    0.7.0.1
 */