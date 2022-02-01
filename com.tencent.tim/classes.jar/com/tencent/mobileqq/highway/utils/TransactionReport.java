package com.tencent.mobileqq.highway.utils;

import android.os.SystemClock;
import android.text.format.Time;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.segment.RequestFinishQuery;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class TransactionReport
{
  public static final String KEY_TIME = "key_time";
  public static final String KEY_UIN = "key_uin";
  public static final String REPORT_QUERY_FINISH_COUNT = "param_query_finish_flag";
  public static final String REPORT_QUERY_FINISH_PROBLEM = "report_query_finish_beyond";
  public static final String REPORT_TAG_ACTBDHCHANNEL = "actBDHTask";
  public static final String REPORT_TAG_SUCC = "param_succ_flag";
  
  public static void reportFunction(String paramString, Transaction paramTransaction, HashMap<String, String> paramHashMap)
  {
    int j = 1;
    Object localObject = paramHashMap;
    if (paramHashMap == null) {
      localObject = new HashMap();
    }
    boolean bool = paramTransaction.isSuccess.get();
    if (!bool) {
      ((HashMap)localObject).put("param_FailCode", String.valueOf(paramTransaction.mErrorCode));
    }
    ((HashMap)localObject).put("param_buz_id", String.valueOf(paramTransaction.mBuzCmdId));
    if (bool)
    {
      paramHashMap = "1";
      ((HashMap)localObject).put("param_succ_flag", paramHashMap);
      if (!paramTransaction.mTransReport.isIpv6) {
        break label239;
      }
      i = 1;
      label92:
      ((HashMap)localObject).put("param_is_ipv6", String.valueOf(i));
      if (!paramTransaction.mTransReport.mIPv6Fast) {
        break label244;
      }
      i = 1;
      label116:
      ((HashMap)localObject).put("param_hasV6List", String.valueOf(i));
      if (!paramTransaction.mTransReport.mHasIpv6List) {
        break label249;
      }
    }
    label239:
    label244:
    label249:
    for (int i = j;; i = 0)
    {
      ((HashMap)localObject).put("param_ipv6First", String.valueOf(i));
      paramHashMap = new RdmReq();
      paramHashMap.eventName = paramString;
      paramHashMap.elapse = (SystemClock.uptimeMillis() - paramTransaction.startTime);
      paramHashMap.size = paramTransaction.totalLength;
      paramHashMap.isSucceed = bool;
      paramHashMap.params = ((Map)localObject);
      try
      {
        paramString = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), paramHashMap);
        paramString.setAppId(HwEngine.appId);
        paramString.setTimeout(30000L);
        MsfServiceSdk.get().sendMsg(paramString);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      paramHashMap = "0";
      break;
      i = 0;
      break label92;
      i = 0;
      break label116;
    }
  }
  
  public static void reportQueryFinishQuality(Transaction paramTransaction, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_query_finish_flag", String.valueOf(paramInt));
    reportFunction("param_query_finish_flag", paramTransaction, localHashMap);
    if ((QLog.isColorLevel()) && (paramInt > RequestFinishQuery.QUERY_HOLE_MAX_COUNT))
    {
      localHashMap.put("key_uin", paramTransaction.peerUin);
      localHashMap.put("param_query_finish_flag", String.valueOf(paramInt));
      Time localTime = new Time();
      localTime.setToNow();
      paramInt = localTime.hour;
      int i = localTime.minute;
      localHashMap.put("key_time", paramInt + "_" + i);
      reportFunction("report_query_finish_beyond", paramTransaction, localHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.utils.TransactionReport
 * JD-Core Version:    0.7.0.1
 */