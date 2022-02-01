import android.os.Handler;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.qphone.base.util.QLog;

public class uqq
  extends jqk
{
  public uqq(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void a(boolean paramBoolean, OpenID paramOpenID)
  {
    if ((this.this$0.isFinishing()) || (this.this$0.aRg)) {}
    do
    {
      do
      {
        return;
        this.this$0.ath();
        if (this.this$0.bJ != null) {
          this.this$0.bJ.removeCallbacksAndMessages(null);
        }
        if ((!paramBoolean) || (paramOpenID == null) || (paramOpenID.openID == null)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, "openIdObserver success");
        }
      } while (paramOpenID.openID.equals(this.this$0.aMl));
      if (QLog.isColorLevel()) {
        QLog.w("Q.chatopttroop", 2, "-->onGetOpenId--openid doesn't equal current openid");
      }
      this.this$0.bFG();
      return;
    } while (!QLog.isColorLevel());
    QLog.d("Q.chatopttroop", 2, "openIdObserver fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uqq
 * JD-Core Version:    0.7.0.1
 */