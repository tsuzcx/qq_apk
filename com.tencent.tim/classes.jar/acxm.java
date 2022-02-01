import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class acxm
  extends acuk
{
  public acxm(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean ace()
  {
    try
    {
      ogj.c(this.context, "from_search_rzh_ws", 2, false);
      return true;
    }
    catch (Exception localException)
    {
      QLog.e("WeishiPublicAccountAction", 1, "doAction error: " + localException.getMessage());
      Ge("WeishiPublicAccountAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acxm
 * JD-Core Version:    0.7.0.1
 */