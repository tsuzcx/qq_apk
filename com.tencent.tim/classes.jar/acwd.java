import android.content.Context;
import com.tencent.mobileqq.activity.activateFriend.ReminderListFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.HashMap;
import org.json.JSONObject;

public class acwd
  extends acuk
{
  public acwd(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean ace()
  {
    try
    {
      boolean bool = this.attrs.containsKey("params");
      if (bool) {}
      try
      {
        JSONObject localJSONObject = new JSONObject(URLDecoder.decode((String)this.attrs.get("params")));
        if (QLog.isColorLevel()) {
          QLog.i("QwalletToNotifyAction", 2, "urlParamObj: " + localJSONObject);
        }
        if (localJSONObject.optInt("view_type", 0) == 0)
        {
          localJSONObject = localJSONObject.optJSONObject("params");
          if (localJSONObject != null) {
            ReminderListFragment.launch(this.context, localJSONObject.optString("notice_time"));
          }
        }
      }
      catch (Exception localException1)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("QwalletToNotifyAction", 2, "JumpAction parse url throw an exception: " + localException1);
        return false;
      }
      return false;
    }
    catch (Exception localException2)
    {
      QLog.e("QwalletToNotifyAction", 1, "doAction error: " + localException2.getMessage());
      Ge("QwalletToNotifyAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acwd
 * JD-Core Version:    0.7.0.1
 */