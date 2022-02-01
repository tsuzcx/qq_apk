import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class acxa
  extends acuk
{
  public acxa(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean ace()
  {
    try
    {
      rzd.b((Activity)this.context, this.ctj, this.attrs);
      return true;
    }
    catch (Exception localException)
    {
      QLog.e("SubScribeAction", 1, "doAction error: " + localException.getMessage());
      Ge("SubScribeAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acxa
 * JD-Core Version:    0.7.0.1
 */