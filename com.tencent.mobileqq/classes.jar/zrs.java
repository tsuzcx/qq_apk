import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class zrs
  implements Runnable
{
  public zrs(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.a.getApp()).edit();
    localEditor.putString("LastScreenShotUri", "");
    localEditor.commit();
    this.a.o();
    try
    {
      QQAppInterface.i(this.a).unregisterReceiver(QQAppInterface.b(this.a));
      try
      {
        label58:
        QQAppInterface.j(this.a).unregisterReceiver(QQAppInterface.c(this.a));
        return;
      }
      catch (Exception localException1) {}
    }
    catch (Exception localException2)
    {
      break label58;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zrs
 * JD-Core Version:    0.7.0.1
 */