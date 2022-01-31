import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;

public class eji
  implements TabBarView.OnTabChangeListener
{
  public eji(NewFriendActivity paramNewFriendActivity) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      return;
    case 1: 
      NewFriendActivity.a(this.a, false);
      this.a.e();
      NewFriendActivity.a(this.a, 2);
      ReportController.b(this.a.b, "CliOper", "", "", "frd_recommend", "frd_rclist_exp", 0, 0, "0", "", "", "");
      return;
    }
    NewFriendActivity.a(this.a, false);
    this.a.f();
    NewFriendActivity.a(this.a, 3);
    ReportController.b(this.a.b, "CliOper", "", "", "frd_recommend", "frd_rclist_exp", 0, 0, "1", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eji
 * JD-Core Version:    0.7.0.1
 */