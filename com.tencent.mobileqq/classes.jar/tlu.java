import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class tlu
{
  public static final int a = azgq.a(4.0F);
  private static final int b = azgq.e(BaseApplicationImpl.getApplication());
  private static final int c = azgq.c(BaseApplicationImpl.getApplication());
  private static int d;
  private static int e;
  private static int f;
  private static int g;
  private static int h;
  private static int i;
  
  public static int a()
  {
    if (f == 0) {
      f = azgq.a(16.0F);
    }
    return f;
  }
  
  public static int a(Activity paramActivity)
  {
    if (d == 0) {
      d = bngs.b(paramActivity);
    }
    return d;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.compile("^#([0-9a-fA-F]{8}|[0-9a-fA-F]{6})$").matcher(paramString).matches();
  }
  
  public static int b()
  {
    if (g == 0) {
      g = azgq.a(41.0F);
    }
    return g;
  }
  
  public static int b(Activity paramActivity)
  {
    if (e == 0) {
      e = a(paramActivity) + azgq.a(4.5F);
    }
    return e;
  }
  
  public static int c()
  {
    if (h == 0) {
      h = azgq.a(14.0F);
    }
    return h;
  }
  
  public static int d()
  {
    if (i == 0) {
      i = azgq.a(2.0F);
    }
    return i;
  }
  
  public static int e()
  {
    return b;
  }
  
  public static int f()
  {
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tlu
 * JD-Core Version:    0.7.0.1
 */