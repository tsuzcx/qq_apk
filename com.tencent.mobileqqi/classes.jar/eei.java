import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.statistics.ReportController;

class eei
  implements Runnable
{
  eei(eeg parameeg) {}
  
  public void run()
  {
    if (NewFriendActivity.a(this.a.a) != null) {
      NewFriendActivity.a(this.a.a).k();
    }
    for (;;)
    {
      ReportController.b(this.a.a.b, "CliOper", "", "", "frd_recommend", "clean_apply", 0, 0, "", "", "", "");
      return;
      SystemMsgListView.a(this.a.a.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eei
 * JD-Core Version:    0.7.0.1
 */