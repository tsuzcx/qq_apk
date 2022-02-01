import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;

public class acwg
  extends acuk
{
  public acwg(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean acK()
  {
    if (this.app == null) {
      return false;
    }
    Intent localIntent = new Intent();
    QzonePluginProxyActivity.x(localIntent, "com.qzone.common.activities.QzoneDialogActivity");
    localIntent.addFlags(805306368);
    avpw.a((Activity)this.context, this.app.getCurrentAccountUin(), localIntent, -1);
    return true;
  }
  
  public boolean ace()
  {
    try
    {
      boolean bool = acK();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("QzoneDialogAction", 1, "doAction error: " + localException.getMessage());
      Ge("QzoneDialogAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acwg
 * JD-Core Version:    0.7.0.1
 */