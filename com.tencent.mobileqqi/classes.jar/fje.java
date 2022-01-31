import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.qphone.base.util.QLog;

public class fje
  implements Runnable
{
  public fje(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "syncBindState mCurrentBindState = " + this.a.a);
    }
    if (this.a.a >= 6) {
      return;
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fje
 * JD-Core Version:    0.7.0.1
 */