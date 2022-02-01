import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

public class aauq
{
  public static Context F = ;
  public static String JD;
  public static long kd = -1L;
  
  public static void ahH()
  {
    try
    {
      ((AudioManager)MobileQQ.getContext().getSystemService("audio")).requestAudioFocus(null, 3, 1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void ahI()
  {
    try
    {
      ((AudioManager)MobileQQ.getContext().getSystemService("audio")).abandonAudioFocus(null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static boolean ai(long paramLong)
  {
    if ((kd > 0L) && (kd == paramLong)) {}
    Object localObject;
    do
    {
      return true;
      localObject = aaur.a().fW();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return false;
      }
      JD = (String)localObject + File.separator + "cover" + File.separator + paramLong;
      localObject = new File(JD);
    } while ((((File)localObject).mkdirs()) || (((File)localObject).isDirectory()));
    QLog.e("GloableValue", 2, "make cover dir: " + JD + " failed.");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aauq
 * JD-Core Version:    0.7.0.1
 */