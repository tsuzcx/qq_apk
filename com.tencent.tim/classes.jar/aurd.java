import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.qphone.base.util.QLog;

public class aurd
{
  public static void aO(View paramView)
  {
    ((InputMethodManager)paramView.getContext().getSystemService("input_method")).showSoftInput(paramView, 0);
  }
  
  public static void cE(Activity paramActivity)
  {
    try
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
      if (localInputMethodManager.isActive()) {
        localInputMethodManager.hideSoftInputFromWindow(paramActivity.getWindow().getDecorView().getWindowToken(), 0);
      }
      return;
    }
    catch (Exception paramActivity)
    {
      while (!QLog.isDevelopLevel()) {}
      paramActivity.printStackTrace();
    }
  }
  
  public static boolean cE(Context paramContext)
  {
    boolean bool2 = false;
    try
    {
      paramContext = alla.getString(paramContext.getContentResolver(), "default_input_method");
      bool1 = bool2;
      if (paramContext != null) {
        if ((!paramContext.contains("com.sohu.inputmethod.sogou")) && (!paramContext.contains("com.tencent.qqpinyin")))
        {
          bool1 = bool2;
          if (!paramContext.contains("com.sogou.zhuyininput")) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    catch (NullPointerException paramContext)
    {
      do
      {
        boolean bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("InputMethodUtil", 2, "checkSogouInputDefault(), e = " + paramContext.getStackTrace());
    }
    return bool1;
    return false;
  }
  
  public static void hide(View paramView)
  {
    ((InputMethodManager)paramView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aurd
 * JD-Core Version:    0.7.0.1
 */