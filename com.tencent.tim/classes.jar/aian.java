import android.os.Bundle;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class aian
  implements EIPCResultCallback
{
  aian(aiak.a parama) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    String str = null;
    QLog.d("FaceLoginHelper", 1, "callServer error_code:" + paramEIPCResult.code);
    FaceDetectForThirdPartyManager.AppConf localAppConf;
    switch (paramEIPCResult.code)
    {
    default: 
      str = acfp.m(2131714935);
      localAppConf = null;
    }
    while ((paramEIPCResult.code != 0) || (paramEIPCResult.data == null))
    {
      this.a.cz(paramEIPCResult.code, str);
      return;
      if (paramEIPCResult.data != null)
      {
        localAppConf = (FaceDetectForThirdPartyManager.AppConf)paramEIPCResult.data.getSerializable("FaceRecognition.AppConf");
        QLog.d("FaceLoginHelper", 1, "callServer error_code:" + localAppConf);
      }
      else
      {
        str = acfp.m(2131714935);
        localAppConf = null;
        continue;
        str = acfp.m(2131693361);
        localAppConf = null;
      }
    }
    this.a.a(localAppConf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aian
 * JD-Core Version:    0.7.0.1
 */