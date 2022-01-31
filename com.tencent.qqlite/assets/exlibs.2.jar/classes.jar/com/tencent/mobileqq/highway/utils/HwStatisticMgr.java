package com.tencent.mobileqq.highway.utils;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.HashMap;

public class HwStatisticMgr
{
  public static final String KEY_CONNCNT = "ConnCnt";
  public static final String KEY_CONNFAILCNT = "ConnFailCnt";
  public static final String KEY_CONNSUCCCNT = "ConnSuccCnt";
  public static final String KEY_CTIMECOST = "param_conncnt";
  public static final String KEY_IPINFO = "param_ipinfo";
  public static int MAX_REPORT_NUM_PER_PERIOD = 1;
  public static final long PERIOD_DUATION = 60000L;
  public static final String REPORT_TAG_ACTBDHCHANNEL = "actBDHChannel";
  public static boolean hasStartReport = false;
  public static long lastStartTime;
  public static int reportNumSinceLastTime;
  
  public static void doReportConnection(int paramInt1, String paramString, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, ArrayList<EndPoint> paramArrayList, ArrayList<Integer> paramArrayList1, ArrayList<Long> paramArrayList2, long paramLong)
  {
    long l = SystemClock.uptimeMillis();
    if (!hasStartReport)
    {
      hasStartReport = true;
      lastStartTime = l;
    }
    for (reportNumSinceLastTime = 0; lastStartTime + 60000L < l; reportNumSinceLastTime = 0) {
      lastStartTime += 60000L;
    }
    reportNumSinceLastTime += 1;
    if (reportNumSinceLastTime > MAX_REPORT_NUM_PER_PERIOD) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("ConnCnt", String.valueOf(paramInt2));
    localHashMap.put("ConnSuccCnt", String.valueOf(paramInt3));
    localHashMap.put("ConnFailCnt", String.valueOf(paramInt4));
    localHashMap.put("param_conncnt", String.valueOf(paramLong));
    StringBuilder localStringBuilder;
    if (paramArrayList.size() > 0)
    {
      localStringBuilder = new StringBuilder();
      paramInt2 = 0;
    }
    for (;;)
    {
      if ((paramInt2 >= paramArrayList.size()) || (paramInt2 > 3))
      {
        localHashMap.put("param_ipinfo", localStringBuilder.toString());
        report(paramInt1, paramString, "actBDHChannel", paramBoolean, 0L, 0L, localHashMap);
        BdhLogUtil.LogEvent("HwStatisticMgr", "REPORT event= actBDHChannel value= " + localHashMap.toString());
        return;
      }
      if (paramInt2 != 0) {
        localStringBuilder.append(";");
      }
      if ((paramInt2 < paramArrayList.size()) && (paramInt2 < paramArrayList1.size()) && (paramInt2 < paramArrayList2.size())) {
        localStringBuilder.append("ip" + (paramInt2 + 1) + "_" + ((EndPoint)paramArrayList.get(paramInt2)).host + "_" + ((EndPoint)paramArrayList.get(paramInt2)).port + "_" + paramArrayList1.get(paramInt2) + "_" + paramArrayList2.get(paramInt2));
      }
      paramInt2 += 1;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.utils.HwStatisticMgr
 * JD-Core Version:    0.7.0.1
 */