import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager.d;
import com.tencent.qphone.base.util.QLog;

public class aiwc
  implements URLDrawable.URLDrawableListener
{
  public aiwc(LoginWelcomeManager paramLoginWelcomeManager) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "tryToShowCGLayer drawable onLoadSuccessed");
    }
    if (this.this$0.a != null) {
      this.this$0.a.q(paramURLDrawable);
    }
    this.this$0.duZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiwc
 * JD-Core Version:    0.7.0.1
 */