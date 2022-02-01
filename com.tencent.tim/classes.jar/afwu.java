import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment;
import mqq.app.QQPermissionCallback;

public class afwu
  implements QQPermissionCallback
{
  public afwu(ExtendFriendLimitChatMatchFragment paramExtendFriendLimitChatMatchFragment) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((ExtendFriendLimitChatMatchFragment.a(this.this$0) != null) && (!ExtendFriendLimitChatMatchFragment.a(this.this$0).isFinishing())) {
      aqha.a(ExtendFriendLimitChatMatchFragment.a(this.this$0), paramArrayOfString, paramArrayOfInt);
    }
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    ExtendFriendLimitChatMatchFragment.f(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afwu
 * JD-Core Version:    0.7.0.1
 */