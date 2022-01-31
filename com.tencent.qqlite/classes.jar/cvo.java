import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.qphone.base.util.QLog;

public class cvo
  implements Runnable
{
  public cvo(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "syncBindState mCurrentBindState = " + this.a.a);
    }
    if (this.a.a >= 6) {
      return;
    }
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cvo
 * JD-Core Version:    0.7.0.1
 */