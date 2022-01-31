import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.statistics.ReportController;

class ccj
  implements Runnable
{
  ccj(cci paramcci) {}
  
  public void run()
  {
    if (NewFriendActivity.a(this.a.a) != null) {
      NewFriendActivity.a(this.a.a).k();
    }
    for (;;)
    {
      ReportController.b(this.a.a.app, "CliOper", "", "", "frd_recommend", "clean_apply", 0, 0, "", "", "", "");
      return;
      SystemMsgListView.a(this.a.a.app);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ccj
 * JD-Core Version:    0.7.0.1
 */