import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeSwitcher.a;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;

class acmj
  extends ThemeSwitcher.a
{
  acmj(acmi paramacmi) {}
  
  public boolean a(aogy paramaogy)
  {
    String str = ThemeUtil.getCurrentThemeId();
    if (!paramaogy.getThemeId().equals(str)) {
      QQToast.a(this.this$0.app.getApplication(), acfp.m(2131715307), 4000).show();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acmj
 * JD-Core Version:    0.7.0.1
 */