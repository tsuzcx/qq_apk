import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class opm
{
  private static final Pattern C = Pattern.compile("^#([0-9a-fA-F]{8}|[0-9a-fA-F]{6})$");
  private static final int SCREEN_HEIGHT = ankt.getRealHeight(BaseApplicationImpl.getApplication());
  private static final int SCREEN_WIDTH = ankt.aE(BaseApplicationImpl.getApplication());
  public static final int bfC = ankt.dip2px(4.0F);
  public static final int bfD = ankt.dip2px(16.0F);
  private static int bfE;
  private static int bfF;
  private static int bfG;
  private static int bfH;
  private static int bfI;
  private static int wm;
  
  public static boolean eI(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return C.matcher(paramString).matches();
  }
  
  public static int getScreenHeight()
  {
    return SCREEN_HEIGHT;
  }
  
  public static int getScreenWidth()
  {
    return SCREEN_WIDTH;
  }
  
  public static int o(Activity paramActivity)
  {
    if (wm == 0) {
      wm = ayxa.getNotchInScreenHeight(paramActivity);
    }
    return wm;
  }
  
  public static int p(Activity paramActivity)
  {
    if (bfE == 0) {
      bfE = o(paramActivity) + ankt.dip2px(4.5F);
    }
    return bfE;
  }
  
  public static int rI()
  {
    if (bfF == 0) {
      bfF = ankt.dip2px(16.0F);
    }
    return bfF;
  }
  
  public static int rJ()
  {
    if (bfG == 0) {
      bfG = ankt.dip2px(41.0F);
    }
    return bfG;
  }
  
  public static int rK()
  {
    if (bfH == 0) {
      bfH = ankt.dip2px(14.0F);
    }
    return bfH;
  }
  
  public static int rL()
  {
    if (bfI == 0) {
      bfI = ankt.dip2px(2.0F);
    }
    return bfI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     opm
 * JD-Core Version:    0.7.0.1
 */