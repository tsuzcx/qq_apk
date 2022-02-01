import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.contentbox.QZoneMsgActivity;

public class acwn
  extends acuk
{
  public acwn(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean acN()
  {
    if (this.context == null) {
      return false;
    }
    long l = avcb.iK();
    if (l != 0L) {
      QZoneMsgActivity.h(l, this.context);
    }
    for (;;)
    {
      return true;
      Intent localIntent = new Intent(this.context, QZoneMsgActivity.class);
      localIntent.addFlags(67108864);
      this.context.startActivity(localIntent);
    }
  }
  
  public boolean ace()
  {
    try
    {
      boolean bool = acN();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("QzonePublicAccountAction", 1, "doAction error: " + localException.getMessage());
      Ge("QzonePublicAccountAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acwn
 * JD-Core Version:    0.7.0.1
 */