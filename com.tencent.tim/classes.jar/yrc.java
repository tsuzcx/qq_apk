import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.addfriendverifi.NewFriendVerifyBlockedListFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class yrc
  implements View.OnClickListener
{
  public yrc(NewFriendVerifyBlockedListFragment paramNewFriendVerifyBlockedListFragment) {}
  
  public void onClick(View paramView)
  {
    yqv.a(NewFriendVerifyBlockedListFragment.a(this.a).app).zd(NewFriendVerifyBlockedListFragment.a(this.a).app.getCurrentAccountUin());
    anot.a(null, "dc00898", "", "", "0X800A3A9", "0X800A3A9", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yrc
 * JD-Core Version:    0.7.0.1
 */