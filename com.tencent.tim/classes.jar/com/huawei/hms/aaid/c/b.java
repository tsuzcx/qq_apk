package com.huawei.hms.aaid.c;

import android.content.Context;
import com.huawei.hms.aaid.constant.a;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;

public final class b
{
  public static String a(Context paramContext, String paramString)
  {
    return HiAnalyticsClient.reportEntry(paramContext, paramString, 40001301);
  }
  
  public static void a(Context paramContext, String paramString, ResponseErrorCode paramResponseErrorCode)
  {
    HiAnalyticsClient.reportExit(paramContext, paramString, paramResponseErrorCode.getTransactionId(), paramResponseErrorCode.getStatusCode(), paramResponseErrorCode.getErrorCode(), 40001301);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    HiAnalyticsClient.reportExit(paramContext, paramString1, paramString2, Status.SUCCESS.getStatusCode(), paramInt, 40001301);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, a parama)
  {
    HiAnalyticsClient.reportExit(paramContext, paramString1, paramString2, Status.SUCCESS.getStatusCode(), parama.a(), 40001301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.aaid.c.b
 * JD-Core Version:    0.7.0.1
 */