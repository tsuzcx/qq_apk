import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public class een
  implements Runnable
{
  public een(NewFriendActivity paramNewFriendActivity) {}
  
  public void run()
  {
    ((PhoneContactManagerImp)this.a.b.getManager(10)).f();
    ReportController.b(this.a.b, "CliOper", "", "", "frd_recommend", "clean_offer", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     een
 * JD-Core Version:    0.7.0.1
 */