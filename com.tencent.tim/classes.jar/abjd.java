import com.tencent.mobileqq.apollo.activity.HotChatCenterFragment;
import com.tencent.mobileqq.apollo.activity.HotChatCenterFragment.1.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class abjd
  extends acfd
{
  public abjd(HotChatCenterFragment paramHotChatCenterFragment) {}
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    while ((HotChatCenterFragment.a(this.this$0).getCurrentAccountUin() == null) || (!HotChatCenterFragment.a(this.this$0).getCurrentAccountUin().equals(paramString))) {
      return;
    }
    ThreadManager.post(new HotChatCenterFragment.1.1(this, paramString), 8, null, true);
  }
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString) {}
  
  protected void onUpdateRecentList()
  {
    this.this$0.update();
  }
  
  public void wJ(String paramString)
  {
    if (!paramString.equals(HotChatCenterFragment.a(this.this$0).getAccount())) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abjd
 * JD-Core Version:    0.7.0.1
 */