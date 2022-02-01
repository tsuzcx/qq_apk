import android.view.ViewGroup;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager.a;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager.d;
import com.tencent.mobileqq.loginwelcome.LoginwelcomeHelper.1.1;
import com.tencent.qphone.base.util.QLog;

public class aiwe
  implements LoginWelcomeManager.d
{
  aiwe(aiwd paramaiwd) {}
  
  public void a(LoginWelcomeManager.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "onShowCommonGuideWeb");
    }
    aiwd.a(this.this$0, parama);
  }
  
  public void q(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "onShowContactsGuideLayer");
    }
    if (aiwd.a(this.this$0) != null) {
      aiwd.a(this.this$0).post(new LoginwelcomeHelper.1.1(this, paramURLDrawable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiwe
 * JD-Core Version:    0.7.0.1
 */