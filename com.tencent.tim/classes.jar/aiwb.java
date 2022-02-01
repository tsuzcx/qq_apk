import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager.c;
import com.tencent.qphone.base.util.QLog;

public class aiwb
  implements URLDrawable.URLDrawableListener
{
  public aiwb(LoginWelcomeManager paramLoginWelcomeManager, LoginWelcomeManager.c paramc, RecentUser paramRecentUser) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "tryShowCGRU drawable onLoadSuccessed");
    }
    this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$c.cmi = true;
    this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$c.E = paramURLDrawable;
    this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$c.E.setURLDrawableListener(null);
    LoginWelcomeManager.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiwb
 * JD-Core Version:    0.7.0.1
 */