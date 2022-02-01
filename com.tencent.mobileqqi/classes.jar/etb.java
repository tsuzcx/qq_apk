import com.tencent.mobileqq.activity.voip.VoipAddressBookView;
import com.tencent.mobileqq.app.PhoneContactManagerImp;

class etb
  implements Runnable
{
  etb(eta parameta) {}
  
  public void run()
  {
    VoipAddressBookView.f(this.a.a).e();
    this.a.a.a.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     etb
 * JD-Core Version:    0.7.0.1
 */