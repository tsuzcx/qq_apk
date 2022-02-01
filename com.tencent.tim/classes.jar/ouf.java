import android.support.v4.content.FileProvider;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

class ouf
  implements ozq.a
{
  ouf(oue paramoue) {}
  
  public void C(boolean paramBoolean, String paramString)
  {
    QLog.d("QCircleConfig", 1, "tryGetSplashVideoAsync onRspCallback " + paramBoolean + ", " + paramString);
    if (paramBoolean)
    {
      paramString = new File(paramString, oue.a(this.b));
      if ((paramString.exists()) && (paramString.length() > 0L))
      {
        oue.a(FileProvider.getUriForFile(MobileQQ.getContext(), "com.tencent.tim.fileprovider", paramString));
        QLog.d("QCircleConfig", 1, "tryGetSplashVideoAsync splashVideoPath: " + oue.c());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ouf
 * JD-Core Version:    0.7.0.1
 */