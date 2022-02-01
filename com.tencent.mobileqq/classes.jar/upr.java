import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class upr
{
  public static final int a;
  private static final Pattern a;
  public static final int b = bclx.a(16.0F);
  public static final int c = bclx.a(60.0F);
  public static final int d = bclx.a(80.0F);
  private static final int e;
  private static final int f;
  private static int g;
  private static int h;
  private static int i;
  private static int j;
  
  static
  {
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("^#([0-9a-fA-F]{8}|[0-9a-fA-F]{6})$");
    e = bclx.e(BaseApplicationImpl.getApplication());
    f = bclx.c(BaseApplicationImpl.getApplication());
    jdField_a_of_type_Int = bclx.a(4.0F);
  }
  
  public static int a()
  {
    if (i == 0) {
      i = bclx.a(16.0F);
    }
    return i;
  }
  
  public static int a(Activity paramActivity)
  {
    if (g == 0) {
      g = bqcd.b(paramActivity);
    }
    return g;
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
    if (j == 0) {
      j = bclx.a(41.0F);
    }
    return j;
  }
  
  public static int b(Activity paramActivity)
  {
    if (h == 0) {
      h = a(paramActivity) + bclx.a(4.5F);
    }
    return h;
  }
  
  public static int c()
  {
    return e;
  }
  
  public static int d()
  {
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     upr
 * JD-Core Version:    0.7.0.1
 */