import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class uqs
{
  public static final int a;
  private static final Pattern a;
  public static final int b = bdep.a(2.0F);
  public static final int c = bdep.a(4.0F);
  public static final int d = bdep.a(16.0F);
  public static final int e = bdep.a(28.0F);
  public static final int f = bdep.a(80.0F);
  private static final int g;
  private static final int h;
  private static int i;
  private static int j;
  private static int k;
  private static int l;
  
  static
  {
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("^#([0-9a-fA-F]{8}|[0-9a-fA-F]{6})$");
    g = bdep.e(BaseApplicationImpl.getApplication());
    h = bdep.c(BaseApplicationImpl.getApplication());
    jdField_a_of_type_Int = bdep.a(0.5F);
  }
  
  public static int a()
  {
    if (k == 0) {
      k = bdep.a(16.0F);
    }
    return k;
  }
  
  public static int a(Activity paramActivity)
  {
    if (i == 0) {
      i = LiuHaiUtils.b(paramActivity);
    }
    return i;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString).matches();
  }
  
  public static int b()
  {
    if (l == 0) {
      l = bdep.a(41.0F);
    }
    return l;
  }
  
  public static int b(Activity paramActivity)
  {
    if (j == 0) {
      j = a(paramActivity) + bdep.a(4.5F);
    }
    return j;
  }
  
  public static int c()
  {
    return g;
  }
  
  public static int d()
  {
    return h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uqs
 * JD-Core Version:    0.7.0.1
 */