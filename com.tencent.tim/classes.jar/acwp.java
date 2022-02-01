import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class acwp
  extends acuk
{
  public acwp(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean acO()
  {
    if ((this.context instanceof Activity))
    {
      avpw.d locald = avpw.d.a();
      locald.cMP = this.app.getCurrentAccountUin();
      locald.nickname = this.app.getCurrentNickname();
      avpw.a((Activity)this.context, locald, -1);
      return true;
    }
    return false;
  }
  
  public boolean ace()
  {
    try
    {
      boolean bool = acO();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("QzonePublishQueueAction", 1, "doAction error: " + localException.getMessage());
      Ge("QzonePublishQueueAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acwp
 * JD-Core Version:    0.7.0.1
 */