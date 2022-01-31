import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.qphone.base.util.QLog;

public class cuk
  extends ContentObserver
{
  public cuk(PhoneContactManagerImp paramPhoneContactManagerImp, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactManager", 2, "Contact changed.");
    }
    this.a.d = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cuk
 * JD-Core Version:    0.7.0.1
 */