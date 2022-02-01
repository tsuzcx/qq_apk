import android.support.v4.content.FileProvider;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

class uxa
  implements zwi
{
  uxa(uwz paramuwz) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    QLog.d("QCircleConfig", 1, "tryGetSplashVideoAsync onRspCallback " + paramBoolean + ", " + paramString);
    if (paramBoolean)
    {
      paramString = new File(paramString, uwz.a(this.a));
      if ((paramString.exists()) && (paramString.length() > 0L))
      {
        uwz.a(FileProvider.getUriForFile(MobileQQ.getContext(), "com.tencent.mobileqq.fileprovider", paramString));
        QLog.d("QCircleConfig", 1, "tryGetSplashVideoAsync splashVideoPath: " + uwz.b());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uxa
 * JD-Core Version:    0.7.0.1
 */