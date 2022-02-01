import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.qphone.base.util.QLog;

public class uqu
  extends aqrd
{
  public uqu(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void onGetMyTroopEffect(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "onGetMyTroopEffect  result = " + paramBoolean);
    }
    if (paramBoolean) {
      this.this$0.wv(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uqu
 * JD-Core Version:    0.7.0.1
 */