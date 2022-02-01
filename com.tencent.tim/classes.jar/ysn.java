import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ysn
  implements View.OnClickListener
{
  public ysn(NewFriendMoreSysMsgSuspiciousFragment paramNewFriendMoreSysMsgSuspiciousFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.getActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ysn
 * JD-Core Version:    0.7.0.1
 */