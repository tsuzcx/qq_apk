import android.os.Message;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.QLog;

public class uyn
  extends VasQuickUpdateManager.CallBacker
{
  public uyn(FriendProfileCardActivity paramFriendProfileCardActivity, alcs paramalcs, Card paramCard) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((paramLong == 15L) && ("cardWZ.zip".equals(paramString1)))
    {
      if (this.this$0.b != null)
      {
        if (this.a.c(this.this$0.app, this.c.backgroundColor, this.c.lCurrentStyleId)) {
          this.this$0.a.b = this.a;
        }
        this.this$0.b.obtainMessage(5, 0, 18, this.c).sendToTarget();
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "send msg of UI_MSG_UPDATE_CARD");
        }
      }
      paramVasQuickUpdateManager.removeCallBacker(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uyn
 * JD-Core Version:    0.7.0.1
 */