import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeSwitcher.a;
import com.tencent.mobileqq.theme.ThemeUtil.2.1;
import mqq.os.MqqHandler;

public final class aohe
  extends ThemeSwitcher.a
{
  public aohe(QQAppInterface paramQQAppInterface) {}
  
  public boolean bu(int paramInt)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new ThemeUtil.2.1(this), 1000L);
    return super.bu(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aohe
 * JD-Core Version:    0.7.0.1
 */