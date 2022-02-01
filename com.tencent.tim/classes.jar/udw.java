import android.os.Handler;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.qphone.base.util.QLog;

public class udw
  extends jqk
{
  public udw(AddFriendLogicActivity paramAddFriendLogicActivity) {}
  
  protected void a(boolean paramBoolean, OpenID paramOpenID)
  {
    if ((this.this$0.isFinishing()) || (this.this$0.aRg)) {}
    do
    {
      return;
      if (this.this$0.bJ != null) {
        this.this$0.bJ.removeCallbacksAndMessages(null);
      }
      if ((paramBoolean) && (paramOpenID != null) && (paramOpenID.openID != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("qqBaseActivity", 2, "openIdObserver success");
        }
        if (!paramOpenID.openID.equals(AddFriendLogicActivity.aKF))
        {
          AddFriendLogicActivity.a(this.this$0, true);
          this.this$0.bFG();
          return;
        }
        AddFriendLogicActivity.a(this.this$0);
        return;
      }
      AddFriendLogicActivity.a(this.this$0);
    } while (!QLog.isColorLevel());
    QLog.d("qqBaseActivity", 2, "openIdObserver fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     udw
 * JD-Core Version:    0.7.0.1
 */