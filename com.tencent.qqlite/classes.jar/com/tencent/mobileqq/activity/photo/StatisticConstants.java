package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class StatisticConstants
{
  public static final long a = 604800000L;
  public static final String a = "StatisticConstants";
  public static final String b = "album_statistic";
  public static final String c = "PhotoConst.time_pre_choose";
  public static final String d = "PhotoConst.start_time";
  public static final String e = "PhotoConst.img_count";
  public static final String f = "PhotoConst.phone_type";
  public static final String g = "PhotoConst.system_version";
  public static final String h = "PhotoConst.album_count";
  public static final String i = "PhotoConst.u_album_count";
  public static final String j = "PhotoConst.preview_count";
  public static final String k = "PhotoConst.last_send_album_time";
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StatisticConstants", 4, "sendAlbumAndImagesStatistic(" + paramInt1 + "  " + paramInt2 + ")");
    }
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
      long l1 = localSharedPreferences.getLong("PhotoConst.last_send_album_time", 0L);
      long l2 = System.currentTimeMillis();
      if (l2 - l1 > 604800000L)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("PhotoConst.album_count", paramInt1 + "");
        localHashMap.put("PhotoConst.img_count", paramInt2 + "");
        localHashMap.put("PhotoConst.phone_type", Build.MODEL);
        localHashMap.put("PhotoConst.system_version", Build.VERSION.RELEASE);
        StatisticCollector.a(BaseApplication.getContext()).a(null, "album_statistic", false, 0L, 0L, localHashMap, "", false);
        localSharedPreferences.edit().putLong("PhotoConst.last_send_album_time", l2).commit();
      }
    }
  }
  
  public static void a(Intent paramIntent)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StatisticConstants", 4, "clearStatisticParams");
    }
    paramIntent.removeExtra("PhotoConst.start_time");
    paramIntent.removeExtra("PhotoConst.u_album_count");
    paramIntent.removeExtra("PhotoConst.preview_count");
  }
  
  public static void a(Intent paramIntent, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StatisticConstants", 4, "sendStatisticDataToServer " + paramIntent);
    }
    if (paramIntent == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PhotoConst.preview_count", paramIntent.getIntExtra("PhotoConst.preview_count", 0) + "");
    localHashMap.put("PhotoConst.u_album_count", paramIntent.getIntExtra("PhotoConst.u_album_count", 0) + "");
    int m = (int)(System.currentTimeMillis() - paramIntent.getLongExtra("PhotoConst.start_time", 0L));
    if (paramInt > 0) {}
    for (paramInt = m / paramInt;; paramInt = 0)
    {
      localHashMap.put("PhotoConst.time_pre_choose", paramInt + "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "album_statistic", false, 0L, 0L, localHashMap, "", false);
      a(paramIntent);
      return;
    }
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StatisticConstants", 4, "incrementStatisticParam(" + paramString);
    }
    if (paramIntent != null) {
      paramIntent.putExtra(paramString, paramIntent.getIntExtra(paramString, 0) + 1);
    }
  }
  
  public static void b(Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("PhotoConst.start_time", 0L);
    if (QLog.isDevelopLevel()) {
      QLog.d("StatisticConstants", 4, "initStatistic " + l);
    }
    if (l < 1L) {
      paramIntent.putExtra("PhotoConst.start_time", System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.StatisticConstants
 * JD-Core Version:    0.7.0.1
 */