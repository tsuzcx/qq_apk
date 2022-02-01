import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ysm
  implements View.OnClickListener
{
  public ysm(NewFriendMoreSysMsgActivity paramNewFriendMoreSysMsgActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ysm
 * JD-Core Version:    0.7.0.1
 */