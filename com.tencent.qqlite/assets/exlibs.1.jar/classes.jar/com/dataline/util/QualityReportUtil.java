package com.dataline.util;

import com.tencent.litetransfersdk.ReportItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class QualityReportUtil
{
  public static final String A = "wifiphoto_qualityReport_pcSessionId";
  public static final String B = "wifiphoto_qualityReport_ErrCode";
  public static final String C = "wifiPhoto_qualityReport_netWorkChange";
  public static final String D = "wifiphoto_qualityReport_IP";
  public static final String E = "wifiphoto_qualityReport_subnetMask";
  public static final String F = "0";
  public static final String G = "1";
  public static final String H = "2";
  public static final String I = "3";
  public static final String J = "4";
  public static int a = 19;
  public static final String a = "dlFileTransfer.Quality";
  public static int b = 1;
  public static final String b = "actFAFileUp";
  private static final int c = 2;
  public static final String c = "actFAFileDown";
  private static final int d = 1;
  public static final String d = "actFAFileConnection";
  public static final String e = "sessionid";
  public static final String f = "mobileterm";
  public static final String g = "otherterm";
  public static final String h = "channeltype";
  public static final String i = "networktype";
  public static final String j = "filesize";
  public static final String k = "fileexist";
  public static final String l = "startpos";
  public static final String m = "duration";
  public static final String n = "suffix";
  public static final String o = "result";
  public static final String p = "failcode";
  public static final String q = "usercode";
  public static final String r = "clientip";
  public static final String s = "serverip";
  public static final String t = "serverport";
  public static final String u = "taskstart";
  public static final String v = "taskend";
  public static final String w = "notifytime";
  public static final String x = "userretry";
  public static final String y = "qqstate";
  public static final String z = "actFAWifiphotoTransQuality";
  
  public static short a()
  {
    if (NetworkUtil.g(BaseApplication.getContext())) {
      return 18;
    }
    if (NetworkUtil.d(BaseApplication.getContext())) {
      return 19;
    }
    if (NetworkUtil.f(BaseApplication.getContext())) {
      return 20;
    }
    return 17;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ReportItem paramReportItem)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    String str;
    boolean bool;
    label62:
    long l2;
    long l3;
    long l4;
    long l1;
    HashMap localHashMap;
    if (paramReportItem.bSend)
    {
      str = "actFAFileUp";
      if ((paramReportItem.emResult != 2) && (paramReportItem.emResult != 26) && (paramReportItem.emResult != 30) && (paramReportItem.emResult != 31) && (paramReportItem.emResult != 34)) {
        break label518;
      }
      bool = true;
      l2 = paramReportItem.uDuration;
      l3 = paramReportItem.uFileSize;
      l4 = paramReportItem.uStartPos;
      l1 = b;
      if (paramQQAppInterface != null) {
        l1 = ((RegisterProxySvcPackHandler)paramQQAppInterface.a(9)).a();
      }
      localHashMap = new HashMap();
      localHashMap.put("sessionid", String.valueOf(paramReportItem.uSessionID));
      localHashMap.put("mobileterm", String.valueOf(a));
      localHashMap.put("otherterm", String.valueOf(l1));
      localHashMap.put("channeltype", String.valueOf(paramReportItem.uChannelType));
      localHashMap.put("networktype", String.valueOf(a()));
      localHashMap.put("filesize", String.valueOf(paramReportItem.uFileSize));
      if (!paramReportItem.bFileExist) {
        break label523;
      }
      i1 = 1;
      label208:
      localHashMap.put("fileexist", String.valueOf(i1));
      localHashMap.put("startpos", String.valueOf(paramReportItem.uStartPos));
      localHashMap.put("duration", String.valueOf(paramReportItem.uDuration));
      localHashMap.put("suffix", paramReportItem.sSuffix);
      localHashMap.put("result", String.valueOf(paramReportItem.emResult));
      localHashMap.put("failcode", String.valueOf(paramReportItem.nFailCode));
      localHashMap.put("usercode", String.valueOf(paramReportItem.nUserCode));
      if (!paramQQAppInterface.e) {
        break label528;
      }
      i1 = 2;
      label316:
      localHashMap.put("qqstate", String.valueOf(i1));
      if (paramReportItem.dwClientIP < 0) {
        break label533;
      }
      l1 = paramReportItem.dwClientIP;
      label342:
      localHashMap.put("clientip", String.valueOf(l1));
      if (paramReportItem.dwServerIP < 0) {
        break label547;
      }
      l1 = paramReportItem.dwServerIP;
      label369:
      localHashMap.put("serverip", String.valueOf(l1));
      if (paramReportItem.wServerPort < 0) {
        break label561;
      }
      i1 = paramReportItem.wServerPort;
      label394:
      localHashMap.put("serverport", String.valueOf(i1));
      localHashMap.put("taskstart", String.valueOf(paramReportItem.uTaskStart / 1000L));
      localHashMap.put("taskend", String.valueOf(paramReportItem.uTaskEnd / 1000L));
      localHashMap.put("notifytime", String.valueOf(paramReportItem.uNotifyTime / 1000L));
      if (!paramReportItem.bUserRetry) {
        break label572;
      }
    }
    label518:
    label523:
    label528:
    label533:
    label547:
    label561:
    label572:
    for (int i1 = 1;; i1 = 0)
    {
      localHashMap.put("userretry", String.valueOf(i1));
      StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.a(), str, bool, l2, l3 - l4, localHashMap, null);
      return;
      str = "actFAFileDown";
      break;
      bool = false;
      break label62;
      i1 = 0;
      break label208;
      i1 = 1;
      break label316;
      l1 = paramReportItem.dwClientIP + 4294967295L;
      break label342;
      l1 = paramReportItem.dwServerIP + 4294967295L;
      break label369;
      i1 = paramReportItem.wServerPort + 65535;
      break label394;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, HashMap paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("sessionid", String.valueOf(paramString));
    localHashMap.put("mobileterm", String.valueOf(a));
    localHashMap.put("wifiphoto_qualityReport_ErrCode", paramHashMap.get("wifiphoto_qualityReport_ErrCode"));
    localHashMap.put("wifiphoto_qualityReport_IP", DBNetworkUtil.b());
    localHashMap.put("wifiphoto_qualityReport_subnetMask", DBNetworkUtil.a());
    StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.a(), "actFAWifiphotoTransQuality", true, 0L, 0L, localHashMap, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    for (;;)
    {
      Object localObject;
      int i1;
      try
      {
        localObject = new String[4];
        i1 = NetworkUtil.a(paramQQAppInterface.getApplication().getApplicationContext());
        if (i1 == 1)
        {
          if (paramBoolean2)
          {
            localObject[0] = "param_WIFIFAFileUploadFlow";
            break label212;
            localObject[3] = "param_Flow";
            paramQQAppInterface.a(paramQQAppInterface.getAccount(), (String[])localObject, paramLong);
            if (!QLog.isColorLevel()) {
              break label229;
            }
            localObject = new StringBuilder().append("addFlowCount ").append(paramLong).append(" for ");
            if (!paramBoolean1) {
              break label257;
            }
            paramQQAppInterface = "nfc";
            localObject = ((StringBuilder)localObject).append(paramQQAppInterface).append(" ");
            if (!paramBoolean2) {
              break label264;
            }
            paramQQAppInterface = "upload";
            localObject = ((StringBuilder)localObject).append(paramQQAppInterface).append(", netType is ");
            if (i1 != 1) {
              break label187;
            }
            paramQQAppInterface = "wifi";
            QLog.d("dlFileTransfer.Quality", 2, paramQQAppInterface);
            return;
          }
          localObject[0] = "param_WIFIFAFileDownloadFlow";
        }
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
      if (paramBoolean2)
      {
        localObject[0] = "param_XGFAFileUploadFlow";
        break label230;
        label187:
        paramQQAppInterface = "nonwifi : " + i1;
        continue;
        label212:
        localObject[1] = "param_WIFIFileFlow";
        localObject[2] = "param_WIFIFlow";
        continue;
        label229:
        return;
      }
      for (;;)
      {
        label230:
        localObject[1] = "param_XGFileFlow";
        localObject[2] = "param_XGFlow";
        break;
        localObject[0] = "param_XGFAFileDownloadFlow";
      }
      label257:
      paramQQAppInterface = "ftn";
      continue;
      label264:
      paramQQAppInterface = "download";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.util.QualityReportUtil
 * JD-Core Version:    0.7.0.1
 */