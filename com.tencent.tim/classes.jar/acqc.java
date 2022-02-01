import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment;
import com.tencent.qphone.base.util.QLog;

public class acqc
  extends acnd
{
  public acqc(HiddenChatFragment paramHiddenChatFragment) {}
  
  protected void c(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 512) && (paramBoolean))
    {
      paramString2 = ((TroopManager)HiddenChatFragment.a(this.this$0).getManager(52)).b(paramString1);
      acqi.a(HiddenChatFragment.a(this.this$0), paramString2);
      this.this$0.bOm();
      if (QLog.isColorLevel()) {
        QLog.d("tag_hidden_chat", 2, "onSetHiddenChatSwitch troopUin=" + paramString1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acqc
 * JD-Core Version:    0.7.0.1
 */