import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;

public class abla
  extends abkx
{
  public abla(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.priority = 0;
  }
  
  public void b(abrs paramabrs, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if ((this.bDy) || (!this.bDA)) {}
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      this.bDz = true;
      localSharedPreferences = paramContext.getSharedPreferences("apollo_sp", 0);
    } while (!localSharedPreferences.getBoolean(paramQQAppInterface.getAccount() + "apollo_settingme_first_enter", true));
    abrj.a(paramabrs, acfp.m(2131706326), 7, 0);
    localSharedPreferences.edit().putBoolean(paramQQAppInterface.getAccount() + "apollo_settingme_first_enter", false).commit();
    c(paramContext, paramQQAppInterface);
  }
  
  public void c(abrs paramabrs, Context paramContext, QQAppInterface paramQQAppInterface) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abla
 * JD-Core Version:    0.7.0.1
 */