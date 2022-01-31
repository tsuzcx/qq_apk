import android.support.v4.content.FileProvider;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

class tqa
  implements tvv
{
  tqa(tpz paramtpz) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    QLog.d("QCircleConfig", 1, "tryGetSplashVideoAsync onRspCallback " + paramBoolean + ", " + paramString);
    if (paramBoolean)
    {
      paramString = new File(paramString, tpz.a(this.a));
      if ((paramString.exists()) && (paramString.length() > 0L))
      {
        tpz.a(FileProvider.getUriForFile(MobileQQ.getContext(), "com.tencent.mobileqq.fileprovider", paramString));
        QLog.d("QCircleConfig", 1, "tryGetSplashVideoAsync splashVideoPath: " + tpz.b());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tqa
 * JD-Core Version:    0.7.0.1
 */