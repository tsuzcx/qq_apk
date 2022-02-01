import android.content.Context;
import com.tencent.mobileqq.activity.activateFriend.QQNotifySettingFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class acvf
  extends acuk
{
  public acvf(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean ace()
  {
    try
    {
      if ((this.attrs.containsKey("scheme")) && (this.attrs.containsKey("msgid")) && (this.attrs.containsKey("busiid")))
      {
        String str2 = (String)this.attrs.get("msgid");
        String str3 = (String)this.attrs.get("busiid");
        String str4 = (String)this.attrs.get("scheme");
        String str1 = "";
        if (this.attrs.containsKey("domain")) {
          str1 = (String)this.attrs.get("domain");
        }
        QQNotifySettingFragment.b(this.context, str2, str3, str4, str1);
      }
      return false;
    }
    catch (Exception localException)
    {
      QLog.e("QQNotifySettingAction", 1, "doAction error: " + localException.getMessage());
      Ge("QQNotifySettingAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acvf
 * JD-Core Version:    0.7.0.1
 */