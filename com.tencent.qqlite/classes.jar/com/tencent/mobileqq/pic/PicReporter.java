package com.tencent.mobileqq.pic;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class PicReporter
{
  private static final Object jdField_a_of_type_JavaLangObject;
  private static final String jdField_a_of_type_JavaLangString = "Pic.Preview.Preload";
  private static final String b = "Pic.AioPreview.Preload";
  private static final String c = "Pic.AlbumList.Cost";
  private static final String d = "Pic.Mkdir.DeviceBusy";
  private static final String e = "Pic.AioPreview.Empty";
  private static final String f = "preload_status";
  private static final String g = "preload_fail_filetype";
  private static final String h = "first_load";
  
  static
  {
    a = "PicReporter";
  }
  
  public static void a()
  {
    boolean bool = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131363062), "qqsetting_auto_receive_pic_key", true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_state", String.valueOf(bool));
    Logger.a(a, "report2G3G4GSwitchState", "param_state:" + bool);
    StatisticCollector.a(BaseApplication.getContext()).a(null, "act2G3G4GSwitch", false, 0L, 0L, localHashMap, "");
  }
  
  public static void a(int paramInt, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_network", String.valueOf(paramInt));
    localHashMap.put("param_limit", String.valueOf(paramLong));
    Logger.a(a, "reportOverFlow", "param_network:" + paramInt + ",param_limit:" + paramLong);
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actPicPreDownOverFlow", false, 0L, 0L, localHashMap, "");
  }
  
  public static void a(PicDownloadInfo paramPicDownloadInfo, QQAppInterface paramQQAppInterface)
  {
    int j = 1;
    int i = 1;
    if (paramQQAppInterface == null) {
      Logger.b(a, "reportDownloadInfo", "app == null");
    }
    ReportInfo localReportInfo;
    label415:
    do
    {
      return;
      if (paramPicDownloadInfo == null)
      {
        Logger.b(a, "reportDownloadInfo", "downInfo == null");
        return;
      }
      if (paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo == null)
      {
        Logger.b(a, "reportDownloadInfo", "id:" + paramPicDownloadInfo.jdField_a_of_type_JavaLangString + " downInfo.reportInfo == null");
        return;
      }
      localReportInfo = paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo;
      if ((localReportInfo.e == -1) || (localReportInfo.e == 0))
      {
        Logger.b(a, "reportDownloadInfo", "id:" + paramPicDownloadInfo.jdField_a_of_type_JavaLangString + " ri.rpStep:" + localReportInfo.e);
        return;
      }
      if (localReportInfo.e == 1)
      {
        if (localReportInfo.a == -1L)
        {
          Logger.b(a, "reportDownloadInfo", "id:" + paramPicDownloadInfo.jdField_a_of_type_JavaLangString + " ReportInfo.STEP_RECV_THUMB ri.rpMsgRecvTime == -1:");
          return;
        }
        localHashMap = new HashMap();
        if ((paramPicDownloadInfo.b == 1) && (TroopAssistantManager.a().a(paramQQAppInterface, paramPicDownloadInfo.c)))
        {
          if (i == 0) {
            break label415;
          }
          localHashMap.put("param_sessionType", String.valueOf(paramPicDownloadInfo.b) + "_digital");
        }
        for (;;)
        {
          localHashMap.put("param_msg_recvNetwork", String.valueOf(localReportInfo.f));
          localHashMap.put("param_thumb_downMode", String.valueOf(localReportInfo.h));
          localHashMap.put("param_thumb_timeDiff", String.valueOf((int)(localReportInfo.b / 1000L)));
          localHashMap.put("param_thumb_recvNetwork", String.valueOf(localReportInfo.g));
          StatisticCollector.a(BaseApplication.getContext()).a(null, "actPicThumbDownload", false, 0L, 0L, localHashMap, "");
          Logger.a(a, "reportDownloadInfo", "id:" + paramPicDownloadInfo.jdField_a_of_type_JavaLangString + " ReportInfo.STEP_RECV_THUMB,sessionType:" + paramPicDownloadInfo.b + ",ReportInfo:" + localReportInfo);
          return;
          i = 0;
          break;
          localHashMap.put("param_sessionType", String.valueOf(paramPicDownloadInfo.b));
        }
      }
    } while (localReportInfo.e != 2);
    if ((localReportInfo.a == -1L) || (localReportInfo.b == -1L))
    {
      Logger.b(a, "reportDownloadInfo", "id:" + paramPicDownloadInfo.jdField_a_of_type_JavaLangString + " ReportInfo.STEP_RECV_BIG ri.rpMsgRecvTime:" + localReportInfo.a + ",ri.rpThumbTimeDiff:" + localReportInfo.b);
      return;
    }
    HashMap localHashMap = new HashMap();
    if ((paramPicDownloadInfo.b == 1) && (TroopAssistantManager.a().a(paramQQAppInterface, paramPicDownloadInfo.c)))
    {
      i = j;
      if (i == 0) {
        break label792;
      }
      localHashMap.put("param_sessionType", String.valueOf(paramPicDownloadInfo.b) + "_digital");
    }
    for (;;)
    {
      localHashMap.put("param_msg_recvNetwork", String.valueOf(localReportInfo.f));
      localHashMap.put("param_thumb_downMode", String.valueOf(localReportInfo.h));
      localHashMap.put("param_thumb_timeDiff", String.valueOf((int)(localReportInfo.b / 1000L)));
      localHashMap.put("param_thumb_recvNetwork", String.valueOf(localReportInfo.g));
      localHashMap.put("param_big_downMode", String.valueOf(localReportInfo.i));
      localHashMap.put("param_big_timeDiff", String.valueOf((int)(localReportInfo.c / 1000L)));
      localHashMap.put("param_big_recvNetwork", String.valueOf(localReportInfo.j));
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPicBigDownload", false, 0L, 0L, localHashMap, "");
      Logger.a(a, "reportDownloadInfo", "id:" + paramPicDownloadInfo.jdField_a_of_type_JavaLangString + " ReportInfo.STEP_RECV_BIG,sessionType:" + paramPicDownloadInfo.b + ",ReportInfo:" + localReportInfo);
      return;
      i = 0;
      break;
      label792:
      localHashMap.put("param_sessionType", String.valueOf(paramPicDownloadInfo.b));
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    Logger.a(a, "reportBigPicDownCost", "uintype:" + paramInt1 + ",networktype:" + paramInt2 + ",timeCost:" + paramLong);
    if ((paramInt1 == -1) || (paramInt2 == -1) || (paramLong < 0L)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_uintype", String.valueOf(paramInt1));
    localHashMap.put("param_networktype", String.valueOf(paramInt2));
    localHashMap.put("param_timecost", String.valueOf(paramLong));
    StatisticCollector.a(BaseApplication.getContext()).a(paramString, "actBigPicDownCost", false, 0L, 0L, localHashMap, "");
  }
  
  public static void a(String paramString, HashMap paramHashMap)
  {
    if (paramHashMap == null)
    {
      Logger.a(a, "reportPicDownAutoLearn", "reportInfo == null");
      return;
    }
    if ((String)paramHashMap.get("xgPreDownCount") == null)
    {
      Logger.a(a, "reportPicDownAutoLearn", "no xg report data");
      return;
    }
    StatisticCollector.a(BaseApplication.getContext()).a(paramString, "actPicDownAutoLearn", false, 0L, 0L, paramHashMap, "");
    Logger.a(a, "reportPicDownAutoLearn", "");
  }
  
  public static void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PicReporter", 2, "device busy " + paramBoolean);
    }
    StatisticCollector.a(BaseApplication.getContext()).a(null, "Pic.Mkdir.DeviceBusy", paramBoolean, 0L, 0L, null, "");
  }
  
  public static void a(boolean paramBoolean, String paramString)
  {
    Logger.a(a, "reportAioPreviewPreloadStatus", "preloaded:" + paramBoolean);
    HashMap localHashMap = new HashMap();
    localHashMap.put("preload_status", String.valueOf(paramBoolean));
    localHashMap.put("preload_fail_filetype", paramString);
    StatisticCollector.a(BaseApplication.getContext()).a(null, "Pic.AioPreview.Preload", false, 0L, 0L, localHashMap, "");
  }
  
  public static void b(String paramString, HashMap paramHashMap)
  {
    if (paramHashMap == null)
    {
      Logger.a(a, "reportPicDownAutoLearnAcc", "reportInfo == null");
      return;
    }
    StatisticCollector.a(BaseApplication.getContext()).a(paramString, "actPicDownAutoLearnAcc", false, 0L, 0L, paramHashMap, "");
    Logger.a(a, "reportPicDownAutoLearnAcc", "");
  }
  
  public static void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PicReporter", 2, "Aio preview " + paramBoolean);
    }
    StatisticCollector.a(BaseApplication.getContext()).a(null, "Pic.AioPreview.Empty", paramBoolean, 0L, 0L, null, "");
  }
  
  public static void c(String paramString, HashMap paramHashMap)
  {
    if (paramHashMap == null)
    {
      Logger.a(a, "XgMissReasonForFLowOver", "reportInfo == null");
      return;
    }
    StatisticCollector.a(BaseApplication.getContext()).a(paramString, "XgMissReasonForFLowOver", false, 0L, 0L, paramHashMap, "");
    Logger.a(a, "XgMissReasonForFLowOver", "");
  }
  
  public static void c(boolean paramBoolean)
  {
    Logger.a(a, "reportPreviewPreloadStatus", "preloaded:" + paramBoolean);
    HashMap localHashMap = new HashMap();
    localHashMap.put("preload_status", String.valueOf(paramBoolean));
    StatisticCollector.a(BaseApplication.getContext()).a(null, "Pic.Preview.Preload", false, 0L, 0L, localHashMap, "");
  }
  
  public static void d(String paramString, HashMap paramHashMap)
  {
    if (paramHashMap == null)
    {
      Logger.a(a, "XgMissReasonForPriority", "reportInfo == null");
      return;
    }
    StatisticCollector.a(BaseApplication.getContext()).a(paramString, "XgMissReasonForPriority", false, 0L, 0L, paramHashMap, "");
    Logger.a(a, "XgMissReasonForPriority", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicReporter
 * JD-Core Version:    0.7.0.1
 */