import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.widget.BounceScrollView.OnScrollChangedListener;
import com.tencent.qphone.base.util.QLog;

public class aox
  implements BounceScrollView.OnScrollChangedListener
{
  public aox(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("PROFILE_TEST", 4, "onScrollChanged, [" + paramInt1 + "," + paramInt2 + "],[" + paramInt3 + "," + paramInt4 + "]");
    }
    if ((this.a.a.a.a != 33) && (FriendProfileCardActivity.a(this.a) == null)) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aox
 * JD-Core Version:    0.7.0.1
 */