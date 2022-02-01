import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeURLImageView;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class amip
{
  private static String cag = "";
  private static WeakReference<Drawable> hL;
  
  private static Drawable a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (hL != null)
    {
      Drawable localDrawable = (Drawable)hL.get();
      if (localDrawable != null) {
        if (!TextUtils.isEmpty(cag))
        {
          paramQQAppInterface = localDrawable;
          if (cag.equals(ThemeUtil.curThemeId)) {}
        }
        else
        {
          ThemeUtil.setThemeFilter(localDrawable, ThemeUtil.curThemeId);
          cag = ThemeUtil.curThemeId;
          paramQQAppInterface = localDrawable;
        }
      }
    }
    do
    {
      return paramQQAppInterface;
      paramContext = f(paramContext);
      paramQQAppInterface = paramContext;
    } while (paramContext == null);
    paramQQAppInterface = paramContext.getConstantState().newDrawable().mutate();
    ThemeUtil.setThemeFilter(paramQQAppInterface, ThemeUtil.curThemeId);
    cag = ThemeUtil.curThemeId;
    hL = new WeakReference(paramQQAppInterface);
    return paramQQAppInterface;
  }
  
  public static ThemeURLImageView a(Context paramContext)
  {
    if (paramContext == null) {}
    Drawable localDrawable;
    do
    {
      return null;
      localDrawable = f(paramContext);
    } while (localDrawable == null);
    paramContext = new ThemeURLImageView(paramContext);
    paramContext.setContentDescription("BOT");
    paramContext.setImageDrawable(localDrawable);
    return paramContext;
  }
  
  public static void a(Context paramContext, SingleLineTextView paramSingleLineTextView, String paramString)
  {
    if ((paramSingleLineTextView == null) || (TextUtils.isEmpty(paramString)) || (paramContext == null)) {}
    do
    {
      return;
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((!(localAppRuntime instanceof QQAppInterface)) || (!aprg.V((QQAppInterface)localAppRuntime, paramString))) {
        break;
      }
      paramString = a((QQAppInterface)localAppRuntime, paramContext);
    } while (paramString == null);
    paramSingleLineTextView.setCompoundDrawablePadding((int)aqho.convertDpToPixel(paramContext, 5.0F));
    paramSingleLineTextView.setDrawableRight2WithIntrinsicBounds(paramString);
    return;
    paramSingleLineTextView.setDrawableRight2WithIntrinsicBounds(null);
  }
  
  public static Drawable f(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    return paramContext.getResources().getDrawable(2130847068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amip
 * JD-Core Version:    0.7.0.1
 */