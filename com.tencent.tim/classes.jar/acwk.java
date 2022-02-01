import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class acwk
  extends acuk
{
  public acwk(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean acM()
  {
    String str = (String)this.attrs.get("uin");
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(str))
        {
          str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          avpw.a((Activity)this.context, avpw.d.a(), str, 0, 0, 0);
          return true;
        }
      }
      catch (Exception localException)
      {
        QLog.e("QzoneOpenHomePageAction", 1, localException, new Object[0]);
        return true;
      }
    }
  }
  
  public boolean ace()
  {
    try
    {
      boolean bool = acM();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("QzoneOpenHomePageAction", 1, "doAction error: " + localException.getMessage());
      Ge("QzoneOpenHomePageAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acwk
 * JD-Core Version:    0.7.0.1
 */