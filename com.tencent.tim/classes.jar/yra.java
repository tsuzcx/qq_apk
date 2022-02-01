import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.contact.addfriendverifi.AddFriendBlockedInfo;
import com.tencent.mobileqq.activity.contact.addfriendverifi.NewFriendVerifyBlockedListFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class yra
  extends yqy
{
  public yra(NewFriendVerifyBlockedListFragment paramNewFriendVerifyBlockedListFragment) {}
  
  protected void Q(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      this.a.q.removeMessages(1);
      this.a.q.sendEmptyMessage(1);
    }
  }
  
  public void a(boolean paramBoolean, List<AddFriendBlockedInfo> paramList, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BlockedListFragment", 2, "onGetAddFriendBlockedList, success=" + paramBoolean);
    }
    if ((!paramBoolean) || (NewFriendVerifyBlockedListFragment.a(this.a) == null) || (NewFriendVerifyBlockedListFragment.a(this.a).isFinishing()) || (NewFriendVerifyBlockedListFragment.a(this.a) == null) || (NewFriendVerifyBlockedListFragment.a(this.a) == null)) {
      return;
    }
    this.a.q.removeMessages(1);
    this.a.q.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yra
 * JD-Core Version:    0.7.0.1
 */