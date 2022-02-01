package com.tencent.qqmini.sdk.manager;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class BannerAdViolationManager
{
  private static final String TAG = "BannerAdViolationManage";
  private static Map<Long, Long> exposureTimestampMap = new HashMap();
  
  private static View.OnClickListener getOnClickListenerReflected(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    try
    {
      Field localField = View.class.getDeclaredField("mListenerInfo");
      if (localField == null) {
        break label96;
      }
      localField.setAccessible(true);
      paramView = localField.get(paramView);
      localField = paramView.getClass().getDeclaredField("mOnClickListener");
      if ((localField == null) || (paramView == null)) {
        break label96;
      }
      localField.setAccessible(true);
      paramView = (View.OnClickListener)localField.get(paramView);
    }
    catch (Throwable paramView)
    {
      for (;;)
      {
        QMLog.e("BannerAdViolationManage", "getOnClickListenerReflected", paramView);
        paramView = null;
      }
    }
    QMLog.d("BannerAdViolationManage", "getOnClickListenerReflected: listener = " + paramView);
    return paramView;
  }
  
  private static void handleViolationReport(String paramString, long paramLong1, int paramInt, long paramLong2)
  {
    QMLog.d("BannerAdViolationManage", "handleViolationReport() called with: miniAppId = [" + paramString + "], aid = [" + paramLong1 + "], clickArea = [" + paramInt + "], expoClickInterval = [" + paramLong2 + "]");
    if ((paramInt > 0) && (paramInt < 11) && (paramLong2 > 0L))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString).append('|').append(paramLong1).append('|').append(paramInt).append('|').append(paramLong2).append('|').append(System.currentTimeMillis()).append('|').append("Android").append('|').append("");
      paramString = ((StringBuilder)localObject).toString();
      QMLog.d("BannerAdViolationManage", "handleViolationReport: report one record " + paramString);
      localObject = new Bundle();
      ((Bundle)localObject).putStringArray("data", new String[] { paramString });
      ((Bundle)localObject).putString("log_key", "dc05439");
      AppBrandCmdProxy.g().sendCmd("cmd_dc_report_log_key_data", (Bundle)localObject, null);
      return;
    }
    QMLog.w("BannerAdViolationManage", "invalid report record clickArea = " + paramInt + ", expoClickInterval = " + paramLong2);
  }
  
  public static void scheduleViolationDetectTask(String paramString, long paramLong, View paramView)
  {
    QMLog.d("BannerAdViolationManage", "scheduleViolationDetectTask() called with: miniAppId = [" + paramString + "], aid = [" + paramLong + "], view = [" + paramView + "]");
    if ((TextUtils.isEmpty(paramString)) || (paramView == null)) {
      return;
    }
    exposureTimestampMap.put(Long.valueOf(paramLong), Long.valueOf(System.currentTimeMillis()));
    float[] arrayOfFloat = new float[2];
    paramView.setOnTouchListener(new BannerAdViolationManager.1(arrayOfFloat));
    paramView.setOnClickListener(new BannerAdViolationManager.2(getOnClickListenerReflected(paramView), paramLong, paramView, arrayOfFloat, paramString));
    QMLog.d("BannerAdViolationManage", "scheduleViolationDetectTask: end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.BannerAdViolationManager
 * JD-Core Version:    0.7.0.1
 */