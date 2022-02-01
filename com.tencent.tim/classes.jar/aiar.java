import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.observer.BusinessObserver;

class aiar
  implements BusinessObserver
{
  aiar(aiaq paramaiaq, FaceDetectForThirdPartyManager paramFaceDetectForThirdPartyManager, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt == 17) && (paramBoolean) && (paramBundle != null))
    {
      paramInt = paramBundle.getInt("app_id", 0);
      QLog.d("qqidentification_server", 1, "onReceive appid = " + paramInt);
      if (paramInt == 0) {
        return;
      }
      FaceDetectForThirdPartyManager.AppConf localAppConf = (FaceDetectForThirdPartyManager.AppConf)paramBundle.getSerializable("FaceRecognition.AppConf");
      if (this.a != null) {
        this.a.a(paramInt, localAppConf);
      }
      this.this$0.callbackResult(this.val$callbackId, EIPCResult.createResult(0, paramBundle));
      return;
    }
    if (paramInt != 15)
    {
      this.this$0.callbackResult(this.val$callbackId, EIPCResult.createResult(-102, null));
      if (paramInt != 17) {
        break label186;
      }
      if (paramBundle != null) {
        break label180;
      }
    }
    label180:
    for (paramBundle = "1";; paramBundle = "2")
    {
      anot.a(this.val$app, "dc00898", "", "", "0X8009D63", "0X8009D63", 0, 0, paramBundle, "", "", "");
      return;
      this.this$0.callbackResult(this.val$callbackId, EIPCResult.createResult(15, null));
      break;
    }
    label186:
    QLog.e("qqidentification_server", 1, "requestThirdPartyInfo unexpected error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiar
 * JD-Core Version:    0.7.0.1
 */