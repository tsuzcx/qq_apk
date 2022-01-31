import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;

public class xxe
{
  public static final String a;
  public static final HashMap<String, String> a;
  public static final String[] a;
  public static final String b;
  public static final HashMap<String, String> b;
  public static final String c;
  public static final HashMap<String, String> c;
  public static final String d;
  private static final String e = bduw.a("cache/");
  private static final String f = bduw.a("qsubscribe/");
  
  static
  {
    jdField_a_of_type_JavaLangString = f + "file/";
    jdField_b_of_type_JavaLangString = f + "cache/";
    jdField_c_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "animation/";
    d = e + "tencent_sdk_download/";
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_c_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("follow_guide_pics", "https://down.qq.com/video_story/certified_account/animation_pics/follow_guide_pics.zip");
    jdField_a_of_type_JavaUtilHashMap.put("praise_guide_pics", "https://down.qq.com/video_story/certified_account/animation_pics/praise_guide_pics.zip");
    jdField_b_of_type_JavaUtilHashMap.put("follow_guide_pics", jdField_c_of_type_JavaLangString + "follow_guide_pics" + File.separator);
    jdField_b_of_type_JavaUtilHashMap.put("praise_guide_pics", jdField_c_of_type_JavaLangString + "praise_guide_pics" + File.separator);
    jdField_c_of_type_JavaUtilHashMap.put("follow_guide_pics", "KEY_SUBSCRIBE_FOLLOW_GUIDE_DOWNLOAD_URL");
    jdField_c_of_type_JavaUtilHashMap.put("praise_guide_pics", "KEY_SUBSCRIBE_FOLLOW_PRAISE_DOWNLOAD_URL");
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "follow_guide_pics", "praise_guide_pics" };
  }
  
  public static String a(String paramString)
  {
    return String.format("https://h5.qzone.qq.com/subscription/openshop/%s?_proxy=1&_wv=3", new Object[] { paramString });
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str = String.format("https://h5.qzone.qq.com/subscription/addgoods/%s?_proxy=1&_wv=3", new Object[] { paramString1 });
    paramString1 = str;
    if (paramString2 != null)
    {
      paramString1 = str;
      if (!bdje.a(paramString2)) {
        paramString1 = str + "&id=" + URLEncoder.encode(paramString2);
      }
    }
    return paramString1;
  }
  
  public static String b(String paramString)
  {
    return "https://h5.qzone.qq.com/subscription/morerecommend/{uin}?_proxy=1&_wv=3&_p=".replace("{uin}", paramString);
  }
  
  public static String c(String paramString)
  {
    paramString = jdField_a_of_type_JavaLangString + paramString;
    if (QLog.isColorLevel()) {
      QLog.d("SubscribeConstants", 4, "QSUSCRIBE_DOWNLOAD_ROOT_PATH" + jdField_a_of_type_JavaLangString + "   getSDKPrivatePath realPath=" + paramString);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xxe
 * JD-Core Version:    0.7.0.1
 */