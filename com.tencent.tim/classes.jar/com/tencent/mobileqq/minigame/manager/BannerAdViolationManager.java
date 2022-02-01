package com.tencent.mobileqq.minigame.manager;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

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
        break label100;
      }
      localField.setAccessible(true);
      paramView = localField.get(paramView);
      localField = paramView.getClass().getDeclaredField("mOnClickListener");
      if ((localField == null) || (paramView == null)) {
        break label100;
      }
      localField.setAccessible(true);
      paramView = (View.OnClickListener)localField.get(paramView);
    }
    catch (Throwable paramView)
    {
      for (;;)
      {
        QLog.e("BannerAdViolationManage", 1, paramView, new Object[0]);
        paramView = null;
      }
    }
    QLog.d("BannerAdViolationManage", 1, "getOnClickListenerReflected: listener = " + paramView);
    return paramView;
  }
  
  private static void handleViolationReport(String paramString, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, int paramInt, long paramLong)
  {
    QLog.d("BannerAdViolationManage", 1, "handleViolationReport() called with: miniAppId = [" + paramString + "], adInfo = [" + paramAdInfo + "], clickArea = [" + paramInt + "], expoClickInterval = [" + paramLong + "]");
    if ((paramInt > 0) && (paramInt < 11) && (paramLong > 0L))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString).append('|').append(paramAdInfo.report_info.trace_info.aid.get()).append('|').append(paramInt).append('|').append(paramLong).append('|').append(System.currentTimeMillis()).append('|').append("Android").append('|').append("");
      paramString = localStringBuilder.toString();
      QLog.d("BannerAdViolationManage", 1, "handleViolationReport: report one record " + paramString);
      paramAdInfo = new Bundle();
      paramAdInfo.putStringArray("data", new String[] { paramString });
      paramAdInfo.putString("log_key", "dc05439");
      AppBrandProxy.g().sendCmd("cmd_dc_report_log_key_data", paramAdInfo, null);
      return;
    }
    QLog.w("BannerAdViolationManage", 1, "invalid report record clickArea = " + paramInt + ", expoClickInterval = " + paramLong);
  }
  
  public static void scheduleViolationDetectTask(String paramString, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, View paramView)
  {
    QLog.d("BannerAdViolationManage", 1, "scheduleViolationDetectTask() called with: miniAppId = [" + paramString + "], adInfo = [" + paramAdInfo + "], view = [" + paramView + "]");
    if ((TextUtils.isEmpty(paramString)) || (paramAdInfo == null) || (paramAdInfo.report_info == null) || (paramAdInfo.report_info.trace_info == null) || (paramView == null)) {
      return;
    }
    long l = paramAdInfo.report_info.trace_info.aid.get();
    exposureTimestampMap.put(Long.valueOf(l), Long.valueOf(System.currentTimeMillis()));
    float[] arrayOfFloat = new float[2];
    paramView.setOnTouchListener(new BannerAdViolationManager.1(arrayOfFloat));
    paramView.setOnClickListener(new BannerAdViolationManager.2(getOnClickListenerReflected(paramView), l, paramView, arrayOfFloat, paramString, paramAdInfo));
    QLog.d("BannerAdViolationManage", 1, "scheduleViolationDetectTask: end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.BannerAdViolationManager
 * JD-Core Version:    0.7.0.1
 */