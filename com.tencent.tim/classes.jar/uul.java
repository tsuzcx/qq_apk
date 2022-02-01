import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;

public class uul
  extends acfd
{
  public uul(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean)
    {
      this.this$0.bNd();
      DiscussionInfoCardActivity.a(this.this$0, DiscussionInfoCardActivity.b(this.this$0));
      DiscussionInfoCardActivity.a(this.this$0).notifyDataSetChanged();
    }
    while ((this.this$0.A == null) || (!this.this$0.A.isShowing()) || (this.this$0.isFinishing())) {
      return;
    }
    this.this$0.A.dismiss();
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((this.this$0.a != null) && (this.this$0.a.ownerUin != null))
      {
        paramString = ((acff)this.this$0.app.getManager(51)).e(this.this$0.a.ownerUin + "");
        if (paramString != null) {
          this.this$0.mOwnerName = paramString.name;
        }
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("DiscussionInfoCardActivity", 2, "onUpdateFriendInfo get owner name failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uul
 * JD-Core Version:    0.7.0.1
 */