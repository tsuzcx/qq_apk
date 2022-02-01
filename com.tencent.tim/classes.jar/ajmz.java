import android.text.TextUtils;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.qphone.base.util.QLog;

public class ajmz
{
  public static String TOKEN = "";
  
  public static String getToken()
  {
    if (TextUtils.isEmpty(TOKEN)) {}
    try
    {
      TOKEN = QQPlayerService.I(6, "MusicPendantUtil");
      return TOKEN;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MusicPendantUtil", 1, "MusicPendantManager() exception", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajmz
 * JD-Core Version:    0.7.0.1
 */