import android.text.TextUtils;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ReportPolicy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class tml
{
  private static Map<String, Object> a()
  {
    return new pil().a();
  }
  
  private static Map<String, Object> a(String paramString, Map<String, Object> paramMap)
  {
    if (paramMap == null) {
      paramMap = new HashMap();
    }
    for (;;)
    {
      if (paramString == null) {
        return paramMap;
      }
      paramString = paramString.split("[&]");
      int j = paramString.length;
      int i = 0;
      label30:
      String[] arrayOfString;
      if (i < j)
      {
        arrayOfString = paramString[i].split("[=]");
        if (arrayOfString.length <= 1) {
          break label74;
        }
        paramMap.put(arrayOfString[0], arrayOfString[1]);
      }
      for (;;)
      {
        i += 1;
        break label30;
        break;
        label74:
        if (arrayOfString.length == 1) {
          paramMap.put(arrayOfString[0], "");
        }
      }
    }
  }
  
  public static void a(View paramView, Object paramObject)
  {
    int j = 1;
    if ((paramView == null) || (paramObject == null)) {
      return;
    }
    paramObject = b(paramObject.toString(), null);
    if ((paramObject.containsKey("dt_pgid")) && ((paramObject.get("dt_pgid") instanceof String))) {
      VideoReport.setPageId(paramView, (String)paramObject.get("dt_pgid"));
    }
    for (int i = 1;; i = 0)
    {
      if ((paramObject.containsKey("dt_pg_params")) && ((paramObject.get("dt_pg_params") instanceof String)))
      {
        a(paramView, a((String)paramObject.get("dt_pg_params"), a()));
        label108:
        if ((!paramObject.containsKey("dt_eid")) || (!(paramObject.get("dt_eid") instanceof String))) {
          break label243;
        }
        VideoReport.setElementId(paramView, (String)paramObject.get("dt_eid"));
        i = j;
        if (paramObject.containsKey("only_click")) {
          VideoReport.setElementReportPolicy(paramView, ReportPolicy.REPORT_POLICY_NONE);
        }
      }
      label243:
      for (i = j;; i = 0)
      {
        if ((paramObject.containsKey("dt_params")) && ((paramObject.get("dt_params") instanceof String)))
        {
          VideoReport.setElementParams(paramView, a((String)paramObject.get("dt_params"), a()));
          return;
          if (i == 0) {
            break label108;
          }
          a(paramView, a());
          break label108;
        }
        if (i == 0) {
          break;
        }
        VideoReport.setElementParams(paramView, a());
        return;
      }
    }
  }
  
  public static void a(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) || (paramObject2 == null)) {
      return;
    }
    paramObject2 = b(paramObject2.toString(), a());
    if (paramObject2.containsKey("dt_params"))
    {
      paramObject2.putAll(a((String)paramObject2.get("dt_params"), null));
      paramObject2.remove("dt_params");
    }
    a("clck", paramObject2, paramObject1);
  }
  
  private static void a(Object paramObject, Map<String, Object> paramMap)
  {
    if ((paramObject == null) || (paramMap == null) || (paramMap.size() == 0)) {
      return;
    }
    VideoReport.setPageParams(paramObject, new PageParams(paramMap));
  }
  
  public static void a(String paramString, Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return;
    }
    a(paramString, b(paramObject1.toString(), a()), paramObject2);
  }
  
  public static void a(String paramString, Map<String, Object> paramMap, Object paramObject)
  {
    VideoReport.reportEvent(paramString, paramObject, paramMap);
  }
  
  private static Map<String, Object> b(String paramString, Map<String, Object> paramMap)
  {
    localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return localObject;
      try
      {
        paramString = new JSONObject(paramString);
        paramMap = paramString.keys();
        while (paramMap.hasNext())
        {
          String str = (String)paramMap.next();
          ((Map)localObject).put(str, paramString.optString(str));
        }
        return localObject;
      }
      catch (JSONException paramString)
      {
        QLog.e("ViolaDatongReportUtils", 1, "transJsonToStringMap error: " + paramString.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tml
 * JD-Core Version:    0.7.0.1
 */