import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class acvb
  extends acuk
{
  public acvb(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean ace()
  {
    try
    {
      oux.a((Activity)this.context, this.ctj, this.attrs);
      return true;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleAction", 1, "doAction error: " + localException.getMessage());
      Ge("QCircleAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acvb
 * JD-Core Version:    0.7.0.1
 */