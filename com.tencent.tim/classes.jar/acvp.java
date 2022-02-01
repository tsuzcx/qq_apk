import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class acvp
  extends acuk
{
  public acvp(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean ace()
  {
    try
    {
      boolean bool = aljn.b(this.context, this.attrs);
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("QbossLoaderAction", 1, "doAction error: " + localException.getMessage());
      Ge("QbossLoaderAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acvp
 * JD-Core Version:    0.7.0.1
 */