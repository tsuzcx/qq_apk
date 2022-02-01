import android.view.ViewConfiguration;
import com.tencent.biz.qqcircle.fragments.main.QCircleFolderFollowTabFragment;
import com.tencent.biz.qqcircle.fragments.main.QCircleFolderRcmdTabFragment;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.HashMap;

public class uym
{
  public static int a;
  public static final String a;
  public static final HashMap<String, String> a;
  public static boolean a;
  public static final String[] a;
  public static int b;
  public static final String b;
  public static final HashMap<String, String> b;
  public static final int c;
  public static final String c;
  public static final HashMap<String, String> c;
  public static final String d;
  public static final String e;
  public static final String f;
  public static final String g;
  public static final String h;
  public static final String i;
  private static final String j;
  private static final String k;
  private static final String l;
  
  static
  {
    jdField_a_of_type_JavaLangString = QCircleFolderFollowTabFragment.e;
    jdField_b_of_type_JavaLangString = QCircleFolderRcmdTabFragment.e;
    jdField_a_of_type_Int = 300;
    jdField_b_of_type_Int = ViewConfiguration.getLongPressTimeout();
    j = bigv.a("cache/");
    k = bigv.a("file/");
    l = bigv.a("qcircle/");
    jdField_c_of_type_JavaLangString = l + "file/";
    d = l + "cache/";
    e = jdField_c_of_type_JavaLangString + "download/";
    f = e + "base/";
    g = j + "qqcircle_video/";
    h = jdField_c_of_type_JavaLangString + "animation/";
    i = f + "qcircle_download_pics/";
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_c_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("rockey1", "https://downv6.qq.com/video_story/qcircle/animation/rocket1.zip");
    jdField_a_of_type_JavaUtilHashMap.put("rockey2", "https://downv6.qq.com/video_story/qcircle/animation/rocket2.zip");
    jdField_a_of_type_JavaUtilHashMap.put("rockey3", "https://downv6.qq.com/video_story/qcircle/animation/rocket3.zip");
    jdField_b_of_type_JavaUtilHashMap.put("rockey1", h + "rockey1" + File.separator);
    jdField_b_of_type_JavaUtilHashMap.put("rockey2", h + "rockey2" + File.separator);
    jdField_b_of_type_JavaUtilHashMap.put("rockey3", h + "rockey3" + File.separator);
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "rockey1", "rockey2", "rockey3" };
    jdField_c_of_type_Int = ImmersiveUtils.a(80.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uym
 * JD-Core Version:    0.7.0.1
 */