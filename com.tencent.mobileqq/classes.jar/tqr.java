import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudCommon.Entry;
import java.net.URL;
import java.util.HashSet;
import java.util.List;

public class tqr
{
  public static final String a;
  public static final HashSet<String> a;
  public static final String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = tqr.class.getSimpleName();
    b = QzoneConfig.getQQCircleSearchPageUrl();
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
    jdField_a_of_type_JavaUtilHashSet.add("_wwv");
    jdField_a_of_type_JavaUtilHashSet.add("_proxy");
    jdField_a_of_type_JavaUtilHashSet.add("_wv");
  }
  
  public static String a(List<FeedCloudCommon.Entry> paramList, String paramString)
  {
    return tra.a(paramList, paramString, "");
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      String str = new URL(paramString).getHost();
      QLog.d(jdField_a_of_type_JavaLangString, 1, "url:" + paramString + " domain:" + str);
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