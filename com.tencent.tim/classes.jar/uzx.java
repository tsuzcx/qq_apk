import android.os.Handler;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

public class uzx
  extends afsr
{
  public uzx(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  protected void a(boolean paramBoolean, Card paramCard)
  {
    super.a(paramBoolean, paramCard);
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "checkUpdateExtendInfo, got extend info");
    }
    if (FriendProfileCardActivity.a(this.this$0) != null) {
      FriendProfileCardActivity.a(this.this$0).dismiss();
    }
    if (FriendProfileCardActivity.a(this.this$0) != null)
    {
      FriendProfileCardActivity.a(this.this$0).removeCallbacksAndMessages(null);
      FriendProfileCardActivity.a(this.this$0, null);
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, "checkUpdateExtendInfo, start add friend :" + FriendProfileCardActivity.d(this.this$0));
      }
      if (!FriendProfileCardActivity.d(this.this$0))
      {
        FriendProfileCardActivity.a(this.this$0, true);
        FriendProfileCardActivity.b(this.this$0);
      }
    }
  }
  
  protected void xq(boolean paramBoolean)
  {
    super.xq(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uzx
 * JD-Core Version:    0.7.0.1
 */