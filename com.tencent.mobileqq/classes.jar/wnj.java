import com.tencent.mobileqq.activity.contacts.fragment.FriendFragment;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.qphone.base.util.QLog;

public class wnj
  extends CardObserver
{
  private wnj(FriendFragment paramFriendFragment) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("interactive", 2, " contacts onGetCalReactiveDays isAllow= " + paramBoolean2);
      }
      FriendFragment.a(this.a, 1400L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wnj
 * JD-Core Version:    0.7.0.1
 */