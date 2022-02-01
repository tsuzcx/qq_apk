package com.tencent.qqmail.utilities.report;

import android.text.TextUtils;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.service.PushMsgType;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushService.PushConnectReason;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushService.PushStartUpReason;
import moai.oss.KvHelper;
import moai.oss.OssHelper;

public final class QMPushReportManager
{
  private static final String PUSH_TAG = "QMPushService";
  
  public static void autoSync(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      KvHelper.autoSyncOn(new double[0]);
      return;
    }
    KvHelper.autoSyncOff(new double[0]);
  }
  
  public static void connect(QMPushService.PushConnectReason paramPushConnectReason, String paramString, long paramLong1, long paramLong2, boolean paramBoolean, Throwable paramThrowable)
  {
    if (QMReportManager.ReportType.PUSH_OSS_WATCH.enable())
    {
      if (paramBoolean) {
        KvHelper.pushConnectSuccess(new double[0]);
      }
    }
    else {
      if (!paramBoolean) {
        break label102;
      }
    }
    label102:
    for (int i = 4;; i = 5)
    {
      logPush(i, "Connect, success: " + paramBoolean + ", elapse: " + paramLong2 + "ms, reason: " + paramPushConnectReason + ", interval: " + paramLong1 + "ms, ip: " + paramString, paramThrowable);
      return;
      KvHelper.pushConnectFail(new double[0]);
      break;
    }
  }
  
  public static void existing(long paramLong)
  {
    KvHelper.pushExistTime(new double[] { Math.round(paramLong / 60.0D / 60.0D / 1000.0D * 100.0D) / 100.0D });
    logPush(2, "push exist diff: " + paramLong + "ms");
  }
  
  public static void heartbeat(String paramString1, long paramLong1, long paramLong2, boolean paramBoolean, String paramString2, Throwable paramThrowable)
  {
    int i;
    label28:
    StringBuilder localStringBuilder;
    if (QMReportManager.ReportType.PUSH_OSS_WATCH.enable())
    {
      if (paramBoolean) {
        KvHelper.pushHeartbeatSuccess(new double[0]);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label125;
      }
      i = 4;
      localStringBuilder = new StringBuilder().append("Heartbeat, success: ").append(paramBoolean).append(", elapse: ").append(paramLong2).append("ms, interval: ").append(paramLong1).append("ms");
      if (TextUtils.isEmpty(paramString2)) {
        break label131;
      }
    }
    label131:
    for (paramString1 = ", failReason: " + paramString2;; paramString1 = "")
    {
      logPush(i, paramString1, paramThrowable);
      return;
      KvHelper.pushHeartbeatFail(new double[0]);
      break;
      label125:
      i = 5;
      break label28;
    }
  }
  
  public static void heartbeatDetect(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString)
  {
    if (QMReportManager.ReportType.PUSH_OSS_WATCH.enable()) {
      OssHelper.heartbeatDetect(new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    }
  }
  
  private static void logPush(int paramInt, String paramString)
  {
    logPush(paramInt, paramString, null);
  }
  
  private static void logPush(int paramInt, String paramString, Throwable paramThrowable)
  {
    QMLog.log(paramInt, "QMPushService", paramString + ", network: " + QMReportManager.getNetwork() + ", operator: " + QMReportManager.getOperator(), paramThrowable);
  }
  
  public static void login(String paramString1, long paramLong, boolean paramBoolean, String paramString2, String paramString3, Throwable paramThrowable)
  {
    int i;
    if (QMReportManager.ReportType.PUSH_OSS_WATCH.enable())
    {
      if (paramBoolean) {
        KvHelper.pushLoginSuccess(new double[0]);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label150;
      }
      i = 4;
      label26:
      StringBuilder localStringBuilder = new StringBuilder().append("Login, success: ").append(paramBoolean).append(", elapse: ").append(paramLong).append("ms");
      if (TextUtils.isEmpty(paramString2)) {
        break label156;
      }
      paramString1 = ", failReason: " + paramString2;
      label87:
      paramString2 = localStringBuilder.append(paramString1);
      if (TextUtils.isEmpty(paramString3)) {
        break label162;
      }
    }
    label150:
    label156:
    label162:
    for (paramString1 = ", " + paramString3;; paramString1 = "")
    {
      logPush(i, paramString1, paramThrowable);
      return;
      KvHelper.pushLoginFail(new double[0]);
      break;
      i = 5;
      break label26;
      paramString1 = "";
      break label87;
    }
  }
  
  public static void masterSync(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      KvHelper.masterSyncOn(new double[0]);
      return;
    }
    KvHelper.masterSyncOff(new double[0]);
  }
  
  public static void memory(int paramInt1, int paramInt2)
  {
    if (QMReportManager.ReportType.PUSH_OSS_WATCH.enable())
    {
      double d1 = Math.round(paramInt1 / 1024.0D * 100.0D) / 100.0D;
      double d2 = Math.round(paramInt2 / 1024.0D * 100.0D) / 100.0D;
      KvHelper.pushPd(new double[] { d1 });
      KvHelper.pushPss(new double[] { d2 });
      KvHelper.pushMemTimes(new double[0]);
    }
    logPush(2, "push memory, pd: " + paramInt1 + "kb, pss: " + paramInt2 + "kb");
  }
  
  public static void reachTest(String paramString1, String paramString2, boolean paramBoolean)
  {
    OssHelper.reachTestPush(new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
  }
  
  public static void receiveMail(long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    OssHelper.receiveMail(new Object[] { Long.valueOf(paramLong1), paramString1, paramString2, Long.valueOf(paramLong2) });
  }
  
  public static void removeSyncAccount()
  {
    KvHelper.removeSyncAccount(new double[0]);
  }
  
  public static void replyServerDetect(String paramString, boolean paramBoolean, Throwable paramThrowable)
  {
    if (paramBoolean) {}
    for (int i = 4;; i = 5)
    {
      logPush(i, "Detect reply, success: " + paramBoolean + ", ip: " + paramString, paramThrowable);
      return;
    }
  }
  
  public static void reportPushType(int paramInt)
  {
    String str = PushMsgType.getNameByType(paramInt);
    logPush(4, "recv push, type: " + str);
  }
  
  public static void serverDetect(long paramLong)
  {
    logPush(4, "Detect recv, interval: " + paramLong + "ms");
  }
  
  public static void sessionKey(long paramLong1, long paramLong2, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {}
    for (int i = 4;; i = 5)
    {
      logPush(i, "request session key, success: " + paramBoolean + ", elapse: " + paramLong2 + "ms, interval: " + paramLong1 + "ms, ret: " + paramInt);
      return;
    }
  }
  
  public static void startUp(QMPushService.PushStartUpReason paramPushStartUpReason, long paramLong1, long paramLong2)
  {
    KvHelper.pushStartUp(new double[0]);
    KvHelper.pushStartUpReason(paramPushStartUpReason.name().toLowerCase(), new double[0]);
    logPush(4, "Push Start Up, startEvent: " + paramPushStartUpReason + ", interval: " + paramLong1 + "ms, lastLifeTime: " + paramLong2 + "ms");
  }
  
  public static void syncAdaptper(String paramString, int paramInt)
  {
    OssHelper.syncAdapter(new Object[] { paramString, Integer.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.report.QMPushReportManager
 * JD-Core Version:    0.7.0.1
 */