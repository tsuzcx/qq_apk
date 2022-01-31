package com.dataline.util;

import com.tencent.litetransfersdk.ReportItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class QualityReportUtil
{
  public static int a = 19;
  public static final String a = "dlFileTransfer.Quality";
  public static int b = 1;
  public static final String b = "sessionid";
  public static final String c = "mobileterm";
  public static final String d = "otherterm";
  public static final String e = "channeltype";
  public static final String f = "networktype";
  public static final String g = "filesize";
  public static final String h = "fileexist";
  public static final String i = "startpos";
  public static final String j = "duration";
  public static final String k = "suffix";
  public static final String l = "result";
  public static final String m = "failcode";
  public static final String n = "usercode";
  public static final String o = "clientip";
  public static final String p = "serverip";
  public static final String q = "serverport";
  public static final String r = "taskstart";
  public static final String s = "taskend";
  public static final String t = "notifytime";
  public static final String u = "userretry";
  
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
    Object localObject;
    boolean bool;
    label65:
    long l1;
    long l2;
    long l3;
    HashMap localHashMap;
    if (paramReportItem.bSend)
    {
      localObject = QualityReportUtil.ReprtType.actFAFileUp;
      localObject = ((QualityReportUtil.ReprtType)localObject).toString();
      if ((paramReportItem.emResult != 2) && (paramReportItem.emResult != 26) && (paramReportItem.emResult != 30) && (paramReportItem.emResult != 31) && (paramReportItem.emResult != 34)) {
        break label445;
      }
      bool = true;
      l1 = paramReportItem.uDuration;
      l2 = paramReportItem.uFileSize;
      l3 = paramReportItem.uStartPos;
      localHashMap = new HashMap();
      localHashMap.put("sessionid", String.valueOf(paramReportItem.uSessionID));
      localHashMap.put("mobileterm", String.valueOf(a));
      localHashMap.put("otherterm", String.valueOf(b));
      localHashMap.put("channeltype", String.valueOf(paramReportItem.uChannelType));
      localHashMap.put("networktype", String.valueOf(a()));
      localHashMap.put("filesize", String.valueOf(paramReportItem.uFileSize));
      if (!paramReportItem.bFileExist) {
        break label450;
      }
      i1 = 1;
      label188:
      localHashMap.put("fileexist", String.valueOf(i1));
      localHashMap.put("startpos", String.valueOf(paramReportItem.uStartPos));
      localHashMap.put("duration", String.valueOf(paramReportItem.uDuration));
      localHashMap.put("suffix", paramReportItem.sSuffix);
      localHashMap.put("result", String.valueOf(paramReportItem.emResult));
      localHashMap.put("failcode", String.valueOf(paramReportItem.nFailCode));
      localHashMap.put("usercode", String.valueOf(paramReportItem.nUserCode));
      localHashMap.put("clientip", String.valueOf(paramReportItem.dwClientIP));
      localHashMap.put("serverip", String.valueOf(paramReportItem.dwServerIP));
      localHashMap.put("serverport", String.valueOf(paramReportItem.wServerPort));
      localHashMap.put("taskstart", String.valueOf(paramReportItem.uTaskStart / 1000L));
      localHashMap.put("taskend", String.valueOf(paramReportItem.uTaskEnd / 1000L));
      localHashMap.put("notifytime", String.valueOf(paramReportItem.uNotifyTime / 1000L));
      if (!paramReportItem.bUserRetry) {
        break label455;
      }
    }
    label445:
    label450:
    label455:
    for (int i1 = 1;; i1 = 0)
    {
      localHashMap.put("userretry", String.valueOf(i1));
      StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.a(), (String)localObject, bool, l1, l2 - l3, localHashMap, null);
      return;
      localObject = QualityReportUtil.ReprtType.actFAFileDown;
      break;
      bool = false;
      break label65;
      i1 = 0;
      break label188;
    }
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
            break label204;
            localObject[3] = "param_Flow";
            paramQQAppInterface.a(paramQQAppInterface.getAccount(), (String[])localObject, paramLong);
            if (!QLog.isColorLevel()) {
              break label221;
            }
            localObject = new StringBuilder().append("addFlowCount ").append(paramLong).append(" for ");
            if (!paramBoolean1) {
              break label249;
            }
            paramQQAppInterface = "nfc";
            localObject = ((StringBuilder)localObject).append(paramQQAppInterface).append(" ");
            if (!paramBoolean2) {
              break label256;
            }
            paramQQAppInterface = "upload";
            localObject = ((StringBuilder)localObject).append(paramQQAppInterface).append(", netType is ");
            if (i1 != 1) {
              break label179;
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
        break label222;
        label179:
        paramQQAppInterface = "nonwifi : " + i1;
        continue;
        label204:
        localObject[1] = "param_WIFIFileFlow";
        localObject[2] = "param_WIFIFlow";
        continue;
        label221:
        return;
      }
      for (;;)
      {
        label222:
        localObject[1] = "param_XGFileFlow";
        localObject[2] = "param_XGFlow";
        break;
        localObject[0] = "param_XGFAFileDownloadFlow";
      }
      label249:
      paramQQAppInterface = "ftn";
      continue;
      label256:
      paramQQAppInterface = "download";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.dataline.util.QualityReportUtil
 * JD-Core Version:    0.7.0.1
 */