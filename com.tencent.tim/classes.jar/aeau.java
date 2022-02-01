import com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment;
import com.tencent.qphone.base.util.QLog;

public class aeau
  extends acnd
{
  public aeau(MessageNotificationSettingFragment paramMessageNotificationSettingFragment) {}
  
  protected void c(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MessageNotificationSettingFragment", 2, "onOIDB0XA80_0_Ret: invoked.  isSuccess : " + paramBoolean + " op: " + paramInt1 + " type: " + Integer.toHexString(paramInt2));
    }
    if (paramBoolean) {
      MessageNotificationSettingFragment.a(this.a).al(paramString1, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeau
 * JD-Core Version:    0.7.0.1
 */