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

public class tqr
{
  public static final String a;
  public static final HashSet<String> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = QzoneConfig.getQQCircleSearchPageUrl();
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
    jdField_a_of_type_JavaUtilHashSet.add("_wwv");
    jdField_a_of_type_JavaUtilHashSet.add("_proxy");
    jdField_a_of_type_JavaUtilHashSet.add("_wv");
  }
  
  public static String a(List<FeedCloudCommon.Entry> paramList, String paramString)
  {
    return tra.a(paramList, paramString, "");
  }
  
  public static HashMap<String, String> a(String paramString)
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
  
  public static boolean a(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tqr
 * JD-Core Version:    0.7.0.1
 */