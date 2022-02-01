package com.tencent.mobileqq.highway.utils;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import java.util.List;

public class HwStatisticMgr
{
  public static final String KEY_CONNCNT = "ConnCnt";
  public static final String KEY_CONNFAILCNT = "ConnFailCnt";
  public static final String KEY_CONNSUCCCNT = "ConnSuccCnt";
  public static final String KEY_CTIMECOST = "param_cost";
  public static final String KEY_IPINFO = "connDetail";
  public static final String REPORT_TAG_ACTBDHCHANNEL = "actBDHChannel";
  public static long sLastReportTime = -1L;
  
  public static void doReportConnection(int paramInt1, String paramString, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, List<EndPoint> paramList, long paramLong)
  {
    HashMap localHashMap;
    StringBuilder localStringBuilder;
    if (sLastReportTime == -1L)
    {
      sLastReportTime = SystemClock.uptimeMillis();
      sLastReportTime = SystemClock.uptimeMillis();
      localHashMap = new HashMap();
      localHashMap.put("ConnCnt", String.valueOf(paramInt2));
      localHashMap.put("ConnSuccCnt", String.valueOf(paramInt3));
      localHashMap.put("ConnFailCnt", String.valueOf(paramInt4));
      localHashMap.put("param_cost", String.valueOf(paramLong));
      if (paramList.size() <= 0) {
        break label274;
      }
      localStringBuilder = new StringBuilder();
      paramInt2 = 0;
      label103:
      if (paramInt2 >= paramList.size()) {
        break label261;
      }
      if (paramInt2 <= 0) {
        break label255;
      }
      localStringBuilder.append(";");
    }
    label255:
    while (paramInt2 <= 20)
    {
      EndPoint localEndPoint = (EndPoint)paramList.get(paramInt2);
      if (localEndPoint != null) {
        localStringBuilder.append(localEndPoint.connIndex + "_" + localEndPoint.ipIndex + "_" + localEndPoint.host + "_" + localEndPoint.port + "_" + localEndPoint.connResult + "_" + localEndPoint.cost);
      }
      paramInt2 += 1;
      break label103;
      if (SystemClock.uptimeMillis() - sLastReportTime >= 480000L) {
        break;
      }
      return;
    }
    label261:
    localHashMap.put("connDetail", localStringBuilder.toString());
    label274:
    report(paramInt1, paramString, "actBDHChannel", paramBoolean, paramLong, 0L, localHashMap);
    BdhLogUtil.LogEvent("HwStatisticMgr", "REPORT event= actBDHChannel value= " + localHashMap.toString());
  }
  
  public static void report(int paramInt, String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap)
  {
    paramString1 = new RdmReq();
    paramString1.eventName = paramString2;
    paramString1.elapse = paramLong1;
    paramString1.size = paramLong2;
    paramString1.isSucceed = paramBoolean;
    paramString1.isRealTime = true;
    paramString1.isMerge = false;
    paramString1.params = paramHashMap;
    try
    {
      paramString1 = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), paramString1);
      paramString1.setAppId(paramInt);
      paramString1.setTimeout(30000L);
      MsfServiceSdk.get().sendMsg(paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.utils.HwStatisticMgr
 * JD-Core Version:    0.7.0.1
 */