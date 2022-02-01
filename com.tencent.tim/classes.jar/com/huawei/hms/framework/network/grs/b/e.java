package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;

public class e
{
  public static void a(ArrayList<d> paramArrayList, long paramLong, JSONArray paramJSONArray, Context paramContext)
  {
    if ((paramContext != null) && (paramArrayList != null) && (paramArrayList.size() > 0) && (HianalyticsHelper.getInstance().isEnableReportNoSeed(paramContext))) {
      HianalyticsHelper.getInstance().getReportExecutor().submit(new e.1(paramLong, paramContext, paramArrayList, paramJSONArray));
    }
  }
  
  private static LinkedHashMap<String, String> b(d paramd)
  {
    LinkedHashMapPack localLinkedHashMapPack = new LinkedHashMapPack();
    Exception localException = paramd.j();
    if (localException != null)
    {
      localLinkedHashMapPack.put("error_code", ExceptionCode.getErrorCodeFromException(localException));
      localLinkedHashMapPack.put("exception_name", localException.getClass().getSimpleName());
      localLinkedHashMapPack.put("message", StringUtils.anonymizeMessage(localException.getMessage()));
    }
    try
    {
      for (;;)
      {
        localLinkedHashMapPack.put("domain", new URL(paramd.k()).getHost());
        localLinkedHashMapPack.put("req_start_time", paramd.a());
        localLinkedHashMapPack.put("req_end_time", paramd.b());
        localLinkedHashMapPack.put("req_total_time", paramd.m());
        return localLinkedHashMapPack.getAll();
        localLinkedHashMapPack.put("error_code", paramd.l());
        localLinkedHashMapPack.put("exception_name", paramd.g());
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        Logger.w("HaReportHelper", "report host MalformedURLException", localMalformedURLException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.b.e
 * JD-Core Version:    0.7.0.1
 */