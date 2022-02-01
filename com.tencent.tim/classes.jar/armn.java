import MWIFI.SCGet3rdCloudCheck;
import android.content.Context;
import android.os.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

final class armn
  extends armm.b
{
  armn(Context paramContext, String paramString, QQAppInterface paramQQAppInterface, acod paramacod) {}
  
  public void Kd(int paramInt)
  {
    if ((1 == paramInt) && (this.val$app != null)) {
      this.val$app.removeObserver(this.a);
    }
  }
  
  public void a(SCGet3rdCloudCheck paramSCGet3rdCloudCheck)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WifiSdk", 2, "startCheck onGetWifiSecurityCheckInfo, result: " + paramSCGet3rdCloudCheck);
    }
    if (paramSCGet3rdCloudCheck != null)
    {
      if (paramSCGet3rdCloudCheck.delayHour > 24) {
        arna.aQ(this.val$context, this.val$uin, paramSCGet3rdCloudCheck.delayHour);
      }
      if (QLog.isColorLevel()) {
        QLog.i("WifiSdk", 2, "startCheck onGetWifiSecurityCheckInfo, tips: " + paramSCGet3rdCloudCheck.tips + " tipsType: " + paramSCGet3rdCloudCheck.tipsType + " delayHour: " + paramSCGet3rdCloudCheck.delayHour + " URL: " + paramSCGet3rdCloudCheck.h5);
      }
      if (this.val$app != null)
      {
        MqqHandler localMqqHandler = this.val$app.getHandler(Conversation.class);
        Message localMessage = localMqqHandler.obtainMessage(1134063);
        localMessage.obj = paramSCGet3rdCloudCheck;
        localMqqHandler.sendMessage(localMessage);
        armm.aU(this.val$context, 398677);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     armn
 * JD-Core Version:    0.7.0.1
 */