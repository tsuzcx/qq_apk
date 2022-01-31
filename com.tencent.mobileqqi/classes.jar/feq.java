import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.qphone.base.util.QLog;

public class feq
  implements Runnable
{
  public feq(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
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
 * Qualified Name:     feq
 * JD-Core Version:    0.7.0.1
 */