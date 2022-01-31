import com.tencent.mobileqq.activity.voip.VoipAddressBookView;
import com.tencent.mobileqq.app.PhoneContactManagerImp;

class etc
  implements Runnable
{
  etc(etb parametb) {}
  
  public void run()
  {
    VoipAddressBookView.f(this.a.a).e();
    this.a.a.a.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     etc
 * JD-Core Version:    0.7.0.1
 */