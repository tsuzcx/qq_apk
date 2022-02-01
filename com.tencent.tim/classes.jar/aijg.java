import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.mobileqq.jsp.IdentificationApiPlugin.1.1;
import com.tencent.mobileqq.jsp.IdentificationApiPlugin.1.2;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aijg
  implements aiak.a
{
  aijg(aijf paramaijf) {}
  
  public void a(FaceDetectForThirdPartyManager.AppConf paramAppConf)
  {
    if (aijf.a(this.a) == null)
    {
      QLog.e("IdentificationApiPlugin", 1, "getConfSuccess, activity is null");
      return;
    }
    ThreadManager.getUIHandler().post(new IdentificationApiPlugin.1.1(this, paramAppConf));
  }
  
  public void cz(int paramInt, String paramString)
  {
    QLog.e("IdentificationApiPlugin", 1, "getAppConf error, code : " + paramInt + " errorMsg : " + paramString);
    if (aijf.a(this.a) == null)
    {
      QLog.e("IdentificationApiPlugin", 1, "getConfFailed, activity is null");
      return;
    }
    ThreadManager.getUIHandler().post(new IdentificationApiPlugin.1.2(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aijg
 * JD-Core Version:    0.7.0.1
 */