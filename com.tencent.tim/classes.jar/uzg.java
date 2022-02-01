import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uzg
  implements View.OnClickListener
{
  public uzg(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.bOT();
    this.this$0.finish();
    if ((this.this$0.a.e != null) && (this.this$0.a.e.aZe) && (this.this$0.app != null) && (!"0".equals(this.this$0.app.getCurrentAccountUin()))) {
      this.this$0.app.dQ(this.this$0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uzg
 * JD-Core Version:    0.7.0.1
 */