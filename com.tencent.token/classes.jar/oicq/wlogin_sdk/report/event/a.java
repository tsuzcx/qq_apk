package oicq.wlogin_sdk.report.event;

import android.text.TextUtils;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import oicq.wlogin_sdk.tools.c;

public class a
{
  public static String a(String paramString, Map<String, String> paramMap)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramMap != null))
    {
      StringBuilder localStringBuilder = new StringBuilder("attaid=0c200055384&token=5658354256&report_type=wtlogin_android_atta&event_type=");
      localStringBuilder.append(paramString);
      paramString = paramMap.entrySet().iterator();
      while (paramString.hasNext())
      {
        Object localObject = (Map.Entry)paramString.next();
        paramMap = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        if ((!TextUtils.isEmpty(paramMap)) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          localStringBuilder.append("&");
          localStringBuilder.append(URLEncoder.encode(paramMap));
          localStringBuilder.append("=");
          localStringBuilder.append(URLEncoder.encode((String)localObject));
        }
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static void a(b paramb)
  {
    if (paramb == null) {
      return;
    }
    c.a("https://h.trace.qq.com/kv", a(paramb.a(), paramb.c()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.report.event.a
 * JD-Core Version:    0.7.0.1
 */