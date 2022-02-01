package com.tencent.mobileqq.data;

import afag;
import afah;
import android.content.Context;
import android.text.TextUtils;
import avpq;
import avpr;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.statistic.StatisticCollector;
import cooperation.qzone.statistic.access.WnsKeys;
import cooperation.qzone.statistic.access.concept.Statistic;
import cooperation.qzone.util.NetworkState;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.app.Servlet;

public class QzoneCommonIntent
  extends NewIntent
{
  static afah defaultProcessor = new afag();
  private afah processor;
  private avpr request;
  
  public QzoneCommonIntent(Context paramContext, Class<? extends Servlet> paramClass)
  {
    super(paramContext, paramClass);
  }
  
  private static void prepareReport(avpr paramavpr, int paramInt, String paramString)
  {
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance();
    Statistic localStatistic = localStatisticCollector.getStatistic();
    localStatistic.setValue(WnsKeys.AppId, Integer.valueOf(localStatisticCollector.getAppid()));
    localStatistic.setValue(WnsKeys.ReleaseVersion, localStatisticCollector.getReleaseVersion());
    localStatistic.setValue(WnsKeys.CommandId, paramavpr.getCmdString());
    localStatistic.setValue(WnsKeys.APN, NetworkState.getAPN());
    localStatistic.setValue(WnsKeys.ResultCode_i, Integer.valueOf(paramInt));
    localStatistic.setValue(WnsKeys.ToUIN, Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()));
    localStatistic.setValue(WnsKeys.Qua, avpq.getQUA3());
    localStatistic.setValue(WnsKeys.Build, "3058");
    if ((paramInt != 0) && (!TextUtils.isEmpty(paramString)))
    {
      localStatistic.setValue(WnsKeys.Detail, paramString);
      localStatistic.setValue(WnsKeys.Frequency, Integer.valueOf(1));
    }
    localStatisticCollector.put(localStatistic);
    if (paramInt != 0) {
      localStatisticCollector.forceReport();
    }
  }
  
  public static boolean succeeded(int paramInt)
  {
    return (paramInt == 0) || ((Math.abs(paramInt) <= 19999) && (Math.abs(paramInt) >= 19000));
  }
  
  public afah getProcessor()
  {
    if (this.processor == null) {
      return defaultProcessor;
    }
    return this.processor;
  }
  
  public avpr getRequest()
  {
    return this.request;
  }
  
  public void setRequest(avpr paramavpr)
  {
    this.request = paramavpr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.QzoneCommonIntent
 * JD-Core Version:    0.7.0.1
 */