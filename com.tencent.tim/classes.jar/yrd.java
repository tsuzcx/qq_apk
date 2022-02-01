import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.activity.contact.addfriendverifi.NewFriendVerifyBlockedListFragment;

public class yrd
  extends ClickableSpan
{
  public yrd(NewFriendVerifyBlockedListFragment paramNewFriendVerifyBlockedListFragment) {}
  
  public void onClick(View paramView)
  {
    PermisionPrivacyActivity.df(NewFriendVerifyBlockedListFragment.a(this.a));
    anot.a(null, "dc00898", "", "", "0X800A3AA", "0X800A3AA", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yrd
 * JD-Core Version:    0.7.0.1
 */