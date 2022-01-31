import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class zgb
  extends ContentObserver
{
  WeakReference a;
  
  public zgb(Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void a(PhoneContactManagerImp paramPhoneContactManagerImp)
  {
    if (this.a != null) {
      this.a.clear();
    }
    if (paramPhoneContactManagerImp != null) {
      this.a = new WeakReference(paramPhoneContactManagerImp);
    }
  }
  
  public void onChange(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "Contact changed.");
    }
    if (this.a == null) {}
    for (PhoneContactManagerImp localPhoneContactManagerImp = null;; localPhoneContactManagerImp = (PhoneContactManagerImp)this.a.get())
    {
      if (localPhoneContactManagerImp != null) {
        localPhoneContactManagerImp.h = true;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zgb
 * JD-Core Version:    0.7.0.1
 */