import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.statistics.ReportController;

public class een
  implements Runnable
{
  public een(NewFriendActivity paramNewFriendActivity) {}
  
  public void run()
  {
    if (NewFriendActivity.a(this.a) != null) {
      NewFriendActivity.a(this.a).k();
    }
    for (;;)
    {
      ReportController.b(this.a.b, "CliOper", "", "", "frd_recommend", "clean_apply", 0, 0, "", "", "", "");
      return;
      SystemMsgListView.a(this.a.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     een
 * JD-Core Version:    0.7.0.1
 */