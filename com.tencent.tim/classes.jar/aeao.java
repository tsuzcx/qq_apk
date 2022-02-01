import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager.2.1;
import com.tencent.qphone.base.util.QLog;

public class aeao
  implements aqqq
{
  aeao(aean paramaean, int paramInt) {}
  
  public void onCompleted(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "onCompleted: invoked. ", " bid: ", Long.valueOf(paramLong), " ringId: ", Integer.valueOf(this.cLS) });
    }
    paramQQAppInterface = new MessageNotificationSettingManager.2.1(this);
    ThreadManagerV2.getUIHandlerV2().post(paramQQAppInterface);
  }
  
  public void onProgress(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeao
 * JD-Core Version:    0.7.0.1
 */