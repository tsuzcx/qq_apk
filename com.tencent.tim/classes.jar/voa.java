import android.os.Bundle;
import com.tencent.mobileqq.activity.QQIdentiferLegacy;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.concurrent.atomic.AtomicBoolean;

public class voa
  implements EIPCResultCallback
{
  public voa(QQIdentiferLegacy paramQQIdentiferLegacy, boolean paramBoolean) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    QLog.d("QQIdentiferLegacy", 1, "callServer ACTION_APP_CONF error_code:" + paramEIPCResult.code);
    switch (paramEIPCResult.code)
    {
    default: 
      QQIdentiferLegacy.a(this.this$0).set(false);
    }
    for (;;)
    {
      if (this.aZt) {
        QQIdentiferLegacy.b(this.this$0);
      }
      return;
      QQIdentiferLegacy.a(this.this$0).set(false);
      continue;
      QQIdentiferLegacy.a(this.this$0).set(false);
      if (paramEIPCResult.data != null) {
        QQIdentiferLegacy.a(this.this$0, (FaceDetectForThirdPartyManager.AppConf)paramEIPCResult.data.getSerializable("FaceRecognition.AppConf"));
      }
      QLog.d("QQIdentiferLegacy", 1, "callServer ACTION_APP_CONF success conf :" + QQIdentiferLegacy.a(this.this$0));
      continue;
      QQIdentiferLegacy.a(this.this$0).set(false);
      QQIdentiferLegacy.a(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     voa
 * JD-Core Version:    0.7.0.1
 */