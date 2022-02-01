import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class acti
  extends acuk
{
  public acti(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean acd()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.context, AssistantSettingActivity.class);
    this.context.startActivity(localIntent);
    return true;
  }
  
  public boolean ace()
  {
    try
    {
      boolean bool = acd();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("AssistantSettingAction", 1, "doAction error: " + localException.getMessage());
      Ge("AssistantSettingAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acti
 * JD-Core Version:    0.7.0.1
 */