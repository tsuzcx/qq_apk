import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.QLog;

public class acue
  extends acuk
{
  public acue(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean ace()
  {
    try
    {
      boolean bool = MiniAppLauncher.startMiniApp(this.context, this.source, 2016, null);
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("HttpOpenMiniAppAndAdAction", 1, "doAction error: " + localException.getMessage());
      Ge("HttpOpenMiniAppAndAdAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acue
 * JD-Core Version:    0.7.0.1
 */