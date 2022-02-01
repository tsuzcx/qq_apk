import android.os.Bundle;
import com.tencent.biz.webviewplugin.NewerGuidePlugin.RecommendedListResp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.qphone.base.util.QLog;

public class aiwa
  extends akwm
{
  public aiwa(LoginWelcomeManager paramLoginWelcomeManager) {}
  
  protected void LB(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("ShowCommonGuideWebResult result=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
  }
  
  protected void a(NewerGuidePlugin.RecommendedListResp paramRecommendedListResp)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, String.format("onGetRecommendedList resp=%s", new Object[] { paramRecommendedListResp }));
      }
      if (LoginWelcomeManager.a(this.this$0) != null)
      {
        Bundle localBundle = LoginWelcomeManager.a(this.this$0).getBundle("request");
        if (localBundle != null) {
          localBundle.putParcelable("result", paramRecommendedListResp);
        }
        this.this$0.duU();
      }
      LoginWelcomeManager.a(this.this$0).removeObserver(LoginWelcomeManager.a(this.this$0));
      return;
    }
    catch (Throwable paramRecommendedListResp)
    {
      QLog.e("LoginWelcomeManager", 1, "onGetRecommendedList fail.", paramRecommendedListResp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiwa
 * JD-Core Version:    0.7.0.1
 */