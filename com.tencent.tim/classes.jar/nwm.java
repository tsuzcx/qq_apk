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

public class nwm
{
  public static void a(String paramString, Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return;
    }
    a(paramString, k(paramObject1.toString()), paramObject2);
  }
  
  public static void a(String paramString, Map<String, String> paramMap, Object paramObject)
  {
    VideoReport.reportEvent(paramString, paramObject, paramMap);
  }
  
  public static void d(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) || (paramObject2 == null)) {
      return;
    }
    a("clck", k(paramObject2.toString()), paramObject1);
  }
  
  private static Map<String, Object> j(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (paramString == null) {
      return localHashMap;
    }
    paramString = paramString.split("[&]");
    int j = paramString.length;
    int i = 0;
    label26:
    String[] arrayOfString;
    if (i < j)
    {
      arrayOfString = paramString[i].split("[=]");
      if (arrayOfString.length <= 1) {
        break label70;
      }
      localHashMap.put(arrayOfString[0], arrayOfString[1]);
    }
    for (;;)
    {
      i += 1;
      break label26;
      break;
      label70:
      if (arrayOfString.length == 1) {
        localHashMap.put(arrayOfString[0], "");
      }
    }
  }
  
  private static Map<String, String> k(String paramString)
  {
    localHashMap = new HashMap();
    if (TextUtils.isEmpty(paramString)) {
      return localHashMap;
    }
    try
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, paramString.optString(str));
      }
      return localHashMap;
    }
    catch (JSONException paramString)
    {
      QLog.e("ViolaDatongReportUtils", 1, "transJsonToStringMap error: " + paramString.getMessage());
    }
  }
  
  public static void onVRParamsChange(View paramView, Object paramObject)
  {
    if ((paramView == null) || (paramObject == null)) {}
    do
    {
      return;
      paramObject = k(paramObject.toString());
      if (paramObject.containsKey("dt_pgid")) {
        VideoReport.setPageId(paramView, (String)paramObject.get("dt_pgid"));
      }
      if (paramObject.containsKey("dt_pg_params")) {
        setPageParams(paramView, j((String)paramObject.get("dt_pg_params")));
      }
      if (paramObject.containsKey("dt_eid")) {
        VideoReport.setElementId(paramView, (String)paramObject.get("dt_eid"));
      }
    } while (!paramObject.containsKey("dt_params"));
    VideoReport.setElementParams(paramView, j((String)paramObject.get("dt_params")));
  }
  
  private static void setPageParams(Object paramObject, Map<String, Object> paramMap)
  {
    if ((paramObject == null) || (paramMap == null) || (paramMap.size() == 0)) {
      return;
    }
    VideoReport.setPageParams(paramObject, new PageParams(paramMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nwm
 * JD-Core Version:    0.7.0.1
 */