import com.tencent.mobileqq.activity.voip.VoipAddressBookView;
import com.tencent.mobileqq.app.PhoneContactManagerImp;

class exq
  implements Runnable
{
  exq(exp paramexp) {}
  
  public void run()
  {
    VoipAddressBookView.f(this.a.a).e();
    this.a.a.a.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     exq
 * JD-Core Version:    0.7.0.1
 */