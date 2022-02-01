import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class acuc
  extends acuk
{
  public acuc(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean ace()
  {
    for (;;)
    {
      try
      {
        if ((this.attrs != null) && (this.attrs.containsKey("mini_appid")) && (!this.attrs.containsKey("fakeUrl")))
        {
          i = 1;
          if (i != 0) {
            return com.tencent.mobileqq.microapp.sdk.MiniAppLauncher.launchMiniAppByScheme(this.context, this.attrs);
          }
          boolean bool = com.tencent.mobileqq.mini.sdk.MiniAppLauncher.launchMiniAppByScheme(this.context, this.attrs, 2016, null, null);
          return bool;
        }
      }
      catch (Exception localException)
      {
        QLog.e("HttpOpenMicroAppAction", 1, "doAction error: " + localException.getMessage());
        Ge("HttpOpenMicroAppAction");
        return false;
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acuc
 * JD-Core Version:    0.7.0.1
 */