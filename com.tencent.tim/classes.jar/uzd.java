import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uzd
  implements View.OnClickListener
{
  public uzd(FriendProfileCardActivity paramFriendProfileCardActivity, ausj paramausj) {}
  
  public void onClick(View paramView)
  {
    if (FriendProfileCardActivity.a(this.this$0) == 98) {
      anot.a(this.this$0.app, "dc00898", "", "", "0X800A97D", "0X800A97D", 3, 0, "0", "0", "", "");
    }
    this.val$sheet.mDefaultDismissListener.onClick(null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uzd
 * JD-Core Version:    0.7.0.1
 */