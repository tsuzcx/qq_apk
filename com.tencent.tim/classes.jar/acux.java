import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.InterestSwitchEditActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class acux
  extends acuk
{
  public acux(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean ace()
  {
    try
    {
      boolean bool = acq();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("OpenOnProfileSettingAction", 1, "doAction error: " + localException.getMessage());
      Ge("OpenOnProfileSettingAction");
    }
    return false;
  }
  
  public boolean acq()
  {
    Intent localIntent = new Intent(this.context, InterestSwitchEditActivity.class);
    localIntent.setFlags(67108864);
    this.context.startActivity(localIntent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acux
 * JD-Core Version:    0.7.0.1
 */