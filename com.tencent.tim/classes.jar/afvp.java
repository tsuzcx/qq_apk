import android.os.Bundle;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchFragment.2.1;
import com.tencent.qphone.base.util.QLog;

public class afvp
  extends acfd
{
  public afvp(ExtendFriendSearchFragment paramExtendFriendSearchFragment) {}
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSearchFragment", 2, String.format("onUpdateAddFriend isSuccess=%s addSuccess=%s reqestUin=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString }));
    }
    paramString = this.this$0.a.a(this.this$0.cUx);
    if ((paramString != null) && (!paramString.mAddFriendVerified))
    {
      paramString.mAddFriendVerified = true;
      ExtendFriendSearchFragment.a(this.this$0).post(new ExtendFriendSearchFragment.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afvp
 * JD-Core Version:    0.7.0.1
 */