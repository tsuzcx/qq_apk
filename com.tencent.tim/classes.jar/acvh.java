import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import com.tencent.mobileqq.activity.RegisterChooseLoginActivity;
import com.tencent.mobileqq.activity.RegisterPersonalInfoActivity;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.activity.RegisterSendUpSms;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppActivity;
import mqq.util.WeakReference;

public class acvh
  extends acuk
{
  public acvh(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean act()
  {
    Object localObject = (String)this.attrs.get("appid");
    anot.a(this.app, "CliOper", "", "", "0X80077DE", "0X80077DE", 0, 0, (String)localObject, "", "", "");
    localObject = f();
    Intent localIntent = new Intent(this.context, (Class)localObject);
    if (RegisterPhoneNumActivity.class == localObject) {
      localIntent.putExtra("key_report_extra_from", 5);
    }
    this.context.startActivity(localIntent);
    return true;
  }
  
  private Class f()
  {
    int i = BaseApplicationImpl.getApplication().appActivities.size() - 1;
    while (i >= 0)
    {
      Object localObject = (WeakReference)BaseApplicationImpl.getApplication().appActivities.get(i);
      if (localObject != null) {
        localObject = (AppActivity)((WeakReference)localObject).get();
      }
      while (localObject != null)
      {
        localObject = ((Activity)localObject).getLocalClassName();
        if ("activity.RegisterPersonalInfoActivity".equals(localObject))
        {
          return RegisterPersonalInfoActivity.class;
          localObject = null;
        }
        else
        {
          if ("activity.RegisterChooseLoginActivity".equals(localObject)) {
            return RegisterChooseLoginActivity.class;
          }
          if ("activity.RegisterVerifyCodeActivity".equals(localObject)) {
            return RegisterVerifyCodeActivity.class;
          }
          if ("activity.RegisterByNicknameAndPwdActivity".equals(localObject)) {
            return RegisterByNicknameAndPwdActivity.class;
          }
          if ("activity.RegisterSendUpSms".equals(localObject)) {
            return RegisterSendUpSms.class;
          }
          if ("activity.RegisterPhoneNumActivity".equals(localObject)) {
            return RegisterPhoneNumActivity.class;
          }
        }
      }
      i -= 1;
    }
    return RegisterPhoneNumActivity.class;
  }
  
  public boolean ace()
  {
    try
    {
      boolean bool = act();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("QQRegisterAction", 1, "doAction error: " + localException.getMessage());
      Ge("QQRegisterAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acvh
 * JD-Core Version:    0.7.0.1
 */