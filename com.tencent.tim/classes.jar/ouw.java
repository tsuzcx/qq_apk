import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudCommon.Entry;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ouw
{
  public static final HashSet<String> ae;
  public static final String arD = ;
  
  static
  {
    ae = new HashSet();
    ae.add("_wwv");
    ae.add("_proxy");
    ae.add("_wv");
  }
  
  public static String c(List<FeedCloudCommon.Entry> paramList, String paramString)
  {
    return ovd.b(paramList, paramString, "");
  }
  
  public static boolean eK(String paramString)
  {
    try
    {
      String str = new URL(paramString).getHost();
      QLog.d("QCircleJsUrlConfig", 1, "url:" + paramString + " domain:" + str);
      if (!TextUtils.isEmpty(str))
      {
        boolean bool = str.endsWith(".qq.com");
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public static HashMap<String, String> j(String paramString)
  {
    HashMap localHashMap;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = Uri.parse(paramString);
        if (paramString != null)
        {
          localHashMap = new HashMap();
          Iterator localIterator = paramString.getQueryParameterNames().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            localHashMap.put(str, paramString.getQueryParameter(str));
          }
        }
      }
      return new HashMap();
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ouw
 * JD-Core Version:    0.7.0.1
 */