import android.content.Context;
import com.tencent.mobileqq.activity.qwallet.WXMiniProgramHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class acwb
  extends acuk
{
  public acwb(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean acI()
  {
    WXMiniProgramHelper.a().X(this.attrs);
    return true;
  }
  
  public boolean ace()
  {
    try
    {
      if ((this.attrs.containsKey("user_name")) && (!aqmr.isEmpty((String)this.attrs.get("user_name"))))
      {
        boolean bool = acI();
        return bool;
      }
      return false;
    }
    catch (Exception localException)
    {
      QLog.e("QwalletToLaunchWXMiniAppAction", 1, "doAction error: " + localException.getMessage());
      Ge("QwalletToLaunchWXMiniAppAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acwb
 * JD-Core Version:    0.7.0.1
 */