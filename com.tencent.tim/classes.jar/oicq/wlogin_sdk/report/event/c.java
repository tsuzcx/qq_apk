package oicq.wlogin_sdk.report.event;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import oicq.wlogin_sdk.request.u;
import oicq.wlogin_sdk.tools.util;

public class c
{
  private static String a;
  private static SimpleDateFormat b = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
  
  public static void a(b paramb)
  {
    String str1 = b.format(new Date());
    String str2 = String.valueOf(2484L);
    if (a == null) {
      a = u.m();
    }
    StringBuilder localStringBuilder = new StringBuilder(util.LOG_TAG_EVENT_REPORT);
    localStringBuilder.append(",type=").append(paramb.a());
    localStringBuilder.append(",subType=").append(paramb.b());
    localStringBuilder.append(",detail=").append(paramb.d());
    localStringBuilder.append(",isRealTime=").append(paramb.e());
    localStringBuilder.append(",isImmediatelyUpload=").append(paramb.f());
    localStringBuilder.append(",uin=").append(paramb.g());
    localStringBuilder.append(",time=").append(str1);
    localStringBuilder.append(",version=").append(str2);
    localStringBuilder.append(",process=").append(a);
    localStringBuilder.append(",isReportAtta=").append(paramb.h());
    HashMap localHashMap = paramb.c();
    if (!localHashMap.isEmpty())
    {
      Iterator localIterator = localHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localStringBuilder.append(",").append((String)localEntry.getKey()).append("=").append((String)localEntry.getValue());
      }
    }
    localHashMap.put("user_id", paramb.g());
    localHashMap.put("sub_type", paramb.b());
    localHashMap.put("detail", paramb.d());
    localHashMap.put("wt_version", str2);
    localHashMap.put("happen_time", str1);
    localHashMap.put("process", a);
    oicq.wlogin_sdk.report.c.a(paramb);
    util.LOGI(localStringBuilder.toString(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.report.event.c
 * JD-Core Version:    0.7.0.1
 */