import android.app.Activity;
import android.text.TextUtils;
import android.widget.RelativeLayout;

public class oql
{
  public static void a(Activity paramActivity, RelativeLayout paramRelativeLayout)
  {
    if ((paramActivity != null) && (paramRelativeLayout != null))
    {
      int i = opm.o(paramActivity);
      paramRelativeLayout.setPadding(paramRelativeLayout.getPaddingLeft(), i + paramRelativeLayout.getPaddingTop(), paramRelativeLayout.getPaddingRight(), paramRelativeLayout.getPaddingBottom());
    }
  }
  
  public static int aX(String paramString)
  {
    int i = 2;
    if (TextUtils.equals(paramString, "trends")) {
      i = 6;
    }
    return i;
  }
  
  public static String fC(String paramString)
  {
    String str = "";
    if (TextUtils.equals("recommend_tab", paramString)) {
      str = "feeds";
    }
    do
    {
      return str;
      if (TextUtils.equals("mini_app_personal_main", paramString)) {
        return "homepage_main";
      }
      if (TextUtils.equals("mini_app_personal_guest", paramString)) {
        return "homepage_guest";
      }
      if (TextUtils.equals("follow_tab", paramString)) {
        return "focus";
      }
    } while (!TextUtils.equals("aio_new_msg", paramString));
    return "direct";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oql
 * JD-Core Version:    0.7.0.1
 */