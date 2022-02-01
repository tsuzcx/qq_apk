import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

class eeg
  implements Runnable
{
  eeg(eef parameef) {}
  
  public void run()
  {
    ((PhoneContactManagerImp)this.a.a.b.getManager(10)).f();
    ReportController.b(this.a.a.b, "CliOper", "", "", "frd_recommend", "clean_offer", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eeg
 * JD-Core Version:    0.7.0.1
 */