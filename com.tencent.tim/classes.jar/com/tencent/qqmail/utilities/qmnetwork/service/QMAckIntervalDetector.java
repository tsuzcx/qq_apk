package com.tencent.qqmail.utilities.qmnetwork.service;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils.NetworkType;
import com.tencent.qqmail.utilities.report.QMPushReportManager;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import moai.oss.OssHelper;

public class QMAckIntervalDetector
{
  private static final int ACK_FAIL_TIMES_LIMIT = 5;
  private static final int ACK_INTERVAL_STEP_1 = 60000;
  private static final int ACK_INTERVAL_STEP_2 = 10000;
  private static final long ACK_RESULT_VALID_LIMIT = 604800000L;
  private static final int ACK_STABLE_TIMES_LIMIT = 3;
  private static final int ACK_STATUS_AGGRESSIVE_DETECT = 0;
  private static final int ACK_STATUS_CONSERVATIVE_DETECT = 1;
  private static final int ACK_STATUS_STABLE = 2;
  private static final String KEY_ACK_DETECT_START_TIME_PREFIX = "ack_detect_start_time_";
  private static final String KEY_ACK_DETECT_TIMES_PREFIX = "ack_detect_times_";
  private static final String KEY_ACK_RESULT_PREFIX = "ack_result_";
  private static final String KEY_ACK_RESULT_TIME_PREFIX = "ack_result_time_";
  private static final String KEY_ACK_STATUS_PREFIX = "ack_status_";
  private static final String KEY_FAIL_ACK_TIMES_PREFIX = "fail_ack_times_";
  private static final String KEY_SUCCESS_ACK_INTERVAL_PREFIX = "success_ack_interval_";
  private static final int MIN_ACK_INTERVAL = 240000;
  public static final String SHARED_IDLE_PREF_FILENAME = "idle_ack_info";
  private static final String TAG = "QMAckIntervalDetector";
  private long mAckInterval = 240000L;
  private long mAckSuccessTimes;
  private boolean mFirstTimeEnterDetect;
  private int maxInterval = 2147483647;
  private int minInterval;
  private String sharePrefFileName;
  
  public QMAckIntervalDetector(String paramString)
  {
    this.sharePrefFileName = paramString;
    this.minInterval = 240000;
  }
  
  public QMAckIntervalDetector(String paramString, int paramInt1, int paramInt2)
  {
    this.sharePrefFileName = paramString;
    this.minInterval = paramInt1;
    this.maxInterval = paramInt2;
    this.mAckInterval = paramInt1;
  }
  
  private void detectAckInterval(boolean paramBoolean, long paramLong, int paramInt)
  {
    String str2 = QMNetworkUtils.getActiveNetworkName();
    String str3 = "ack_result_" + str2;
    String str4 = "ack_result_time_" + str2;
    String str5 = "fail_ack_times_" + str2;
    String str6 = "success_ack_interval_" + str2;
    String str7 = "ack_status_" + str2;
    String str1 = "ack_detect_times_" + str2;
    SharedPreferences.Editor localEditor = getEditor();
    boolean bool = this.mFirstTimeEnterDetect;
    this.mFirstTimeEnterDetect = false;
    if (bool)
    {
      this.mAckInterval = getSP().getLong(str6, this.minInterval);
      if (this.mAckInterval >= 1800000L)
      {
        QMLog.log(5, "QMAckIntervalDetector", "Inappropriate ack interval: " + this.mAckInterval + "ms, try to restore");
        this.mAckInterval = this.minInterval;
        localEditor.putLong(str6, this.mAckInterval).putInt(str7, 0).remove(str1);
      }
      QMLog.log(4, "QMAckIntervalDetector", "updateAckInterval " + this.sharePrefFileName + ", last success ack interval: " + this.mAckInterval + "ms");
    }
    int i;
    if (paramBoolean)
    {
      if (!bool) {
        localEditor.remove(str5);
      }
      localEditor.putLong(str6, this.mAckInterval);
      if (this.mAckInterval + paramLong >= this.maxInterval)
      {
        localEditor.putInt(str7, 2).putLong(str3, this.mAckInterval).putLong(str4, System.currentTimeMillis()).remove(str5);
        str2 = "ack_detect_start_time_" + str2;
        paramLong = System.currentTimeMillis() - getSP().getLong(str2, System.currentTimeMillis());
        i = getSP().getInt(str1, 0);
        if ("webpush_push_info".equals(this.sharePrefFileName)) {
          QMPushReportManager.heartbeatDetect(this.mAckInterval, paramLong, i, paramInt, QMNetworkUtils.getActiveNetworkType().getTypeName());
        }
      }
    }
    for (;;)
    {
      localEditor.apply();
      return;
      OssHelper.heartbeatDetect(new Object[] { Long.valueOf(this.mAckInterval), Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(paramInt), QMNetworkUtils.getActiveNetworkType().getTypeName(), this.sharePrefFileName });
      continue;
      this.mAckInterval += paramLong;
      QMLog.log(4, "QMAckIntervalDetector", "updateAckInterval " + this.sharePrefFileName + ", new ack interval: " + this.mAckInterval + "ms");
      continue;
      i = getSP().getInt(str5, 0) + 1;
      localEditor.putInt(str5, i);
      QMLog.log(5, "QMAckIntervalDetector", "updateAckInterval " + this.sharePrefFileName + ", ack failed with new interval, times: " + i + ", interval: " + this.mAckInterval + "ms");
      if (i >= 5)
      {
        paramLong = getSP().getLong(str6, this.minInterval);
        localEditor.putInt(str7, paramInt).putLong(str3, paramLong).putLong(str4, System.currentTimeMillis()).remove(str5);
        QMLog.log(4, "QMAckIntervalDetector", "updateAckInterval " + this.sharePrefFileName + ", detect finish, result interval: " + paramLong + "ms, nextStatus: " + paramInt);
        if (paramInt == 2)
        {
          str2 = "ack_detect_start_time_" + str2;
          long l = System.currentTimeMillis() - getSP().getLong(str2, System.currentTimeMillis());
          i = getSP().getInt(str1, 0);
          if ("webpush_push_info".equals(this.sharePrefFileName)) {
            QMPushReportManager.heartbeatDetect(paramLong, l, i, paramInt, QMNetworkUtils.getActiveNetworkType().getTypeName());
          } else {
            OssHelper.idleHeartbeatDetect(new Object[] { Long.valueOf(paramLong), Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(paramInt), QMNetworkUtils.getActiveNetworkType().getTypeName(), this.sharePrefFileName });
          }
        }
      }
    }
  }
  
  private void stableAckInterval(boolean paramBoolean)
  {
    String str7 = QMNetworkUtils.getActiveNetworkName();
    String str1 = "ack_result_" + str7;
    String str2 = "ack_result_time_" + str7;
    String str3 = "fail_ack_times_" + str7;
    String str4 = "success_ack_interval_" + str7;
    String str5 = "ack_status_" + str7;
    SharedPreferences.Editor localEditor = getEditor();
    long l = getSP().getLong(str2, 0L);
    l = System.currentTimeMillis() - l;
    if (l > 604800000L)
    {
      QMLog.log(5, "QMAckIntervalDetector", "updateAckInterval, try continue detect, ri: " + l + "ms");
      localEditor.putInt(str5, 1);
    }
    for (;;)
    {
      localEditor.apply();
      return;
      if (paramBoolean)
      {
        paramBoolean = this.mFirstTimeEnterDetect;
        this.mFirstTimeEnterDetect = false;
        if ((!paramBoolean) && (getSP().contains(str3))) {
          localEditor.remove(str3);
        }
        this.mAckInterval = getSP().getLong(str1, this.minInterval);
        this.mAckInterval -= 10000L;
        QMLog.log(4, "QMAckIntervalDetector", "updateAckInterval " + this.sharePrefFileName + ", remain result interval: " + this.mAckInterval + "ms");
      }
      else
      {
        int i = getSP().getInt(str3, 0) + 1;
        localEditor.putInt(str3, i);
        QMLog.log(5, "QMAckIntervalDetector", "updateAckInterval " + this.sharePrefFileName + ", ack failed with result interval, times: " + i + ", interval: " + this.mAckInterval + "ms");
        if (i >= 5)
        {
          String str6 = "ack_detect_start_time_" + str7;
          str7 = "ack_detect_times_" + str7;
          localEditor.putInt(str5, 0).putLong(str6, System.currentTimeMillis()).remove(str7).remove(str3).remove(str1).remove(str2).remove(str4);
        }
      }
    }
  }
  
  public long getAckInterval()
  {
    return this.mAckInterval;
  }
  
  public SharedPreferences.Editor getEditor()
  {
    return SPManager.getEditor(this.sharePrefFileName);
  }
  
  public SharedPreferences getSP()
  {
    return SPManager.getSp(this.sharePrefFileName);
  }
  
  public void resetAckIntervalStatus()
  {
    this.mAckSuccessTimes = 0L;
    this.mAckInterval = this.minInterval;
    this.mFirstTimeEnterDetect = true;
  }
  
  public void updateAckInterval(boolean paramBoolean)
  {
    int i = 4;
    String str1 = QMNetworkUtils.getActiveNetworkName();
    String str2 = "ack_status_" + str1;
    String str3 = "ack_detect_times_" + str1;
    SharedPreferences.Editor localEditor = getEditor();
    localEditor.putInt(str3, getSP().getInt(str3, 0) + 1);
    if (paramBoolean) {
      this.mAckSuccessTimes += 1L;
    }
    if (this.mAckSuccessTimes < 3L)
    {
      this.mAckInterval = this.minInterval;
      if (paramBoolean) {
        QMLog.log(i, "QMAckIntervalDetector", "updateAckInterval " + this.sharePrefFileName + ", ensure network stable, success: " + paramBoolean + ", times: " + this.mAckSuccessTimes);
      }
    }
    for (;;)
    {
      localEditor.apply();
      return;
      i = 5;
      break;
      int j = getSP().getInt(str2, 0);
      if (paramBoolean) {}
      for (;;)
      {
        QMLog.log(i, "QMAckIntervalDetector", "updateAckInterval " + this.sharePrefFileName + ", success: " + paramBoolean + ", status: " + j + ", times: " + this.mAckSuccessTimes);
        if (j != 1) {
          break label278;
        }
        detectAckInterval(paramBoolean, 10000L, 2);
        break;
        i = 5;
      }
      label278:
      if (j == 2)
      {
        stableAckInterval(paramBoolean);
      }
      else
      {
        str1 = "ack_detect_start_time_" + str1;
        if (!getSP().contains(str1)) {
          localEditor.putLong(str1, System.currentTimeMillis());
        }
        detectAckInterval(paramBoolean, 60000L, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMAckIntervalDetector
 * JD-Core Version:    0.7.0.1
 */