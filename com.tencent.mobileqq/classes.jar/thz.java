import android.text.TextUtils;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class thz
{
  private static Map<String, Object> a()
  {
    return new pda().a();
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
    if ((paramView == null) || (paramObject == null)) {}
    do
    {
      return;
      paramObject = b(paramObject.toString(), null);
      if ((paramObject.containsKey("dt_pgid")) && ((paramObject.get("dt_pgid") instanceof String))) {
        VideoReport.setPageId(paramView, (String)paramObject.get("dt_pgid"));
      }
      if ((paramObject.containsKey("dt_pg_params")) && ((paramObject.get("dt_pg_params") instanceof String))) {
        a(paramView, a((String)paramObject.get("dt_pg_params"), a()));
      }
      if ((paramObject.containsKey("dt_eid")) && ((paramObject.get("dt_eid") instanceof String))) {
        VideoReport.setElementId(paramView, (String)paramObject.get("dt_eid"));
      }
    } while ((!paramObject.containsKey("dt_params")) || (!(paramObject.get("dt_params") instanceof String)));
    VideoReport.setElementParams(paramView, a((String)paramObject.get("dt_params"), a()));
  }
  
  public static void a(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) || (paramObject2 == null)) {
      return;
    }
    a("clck", b(paramObject2.toString(), a()), paramObject1);
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
 * Qualified Name:     thz
 * JD-Core Version:    0.7.0.1
 */