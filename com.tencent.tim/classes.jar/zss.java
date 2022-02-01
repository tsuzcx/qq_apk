import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class zss
  implements tzd
{
  zss(QQAppInterface paramQQAppInterface, String paramString1, Activity paramActivity, String paramString2, String paramString3, String paramString4, Intent paramIntent) {}
  
  public void onComplete()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SdkDynamicAvatarSettingHelper", 2, "check api, onComplete");
    }
  }
  
  public void onFailure(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SdkDynamicAvatarSettingHelper", 2, new Object[] { "check api, onFailure, code=", Integer.valueOf(paramInt), ", msg=", paramString });
    }
  }
  
  public void onPermission(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SdkDynamicAvatarSettingHelper", 2, new Object[] { "check api, onPermission, code=", Integer.valueOf(paramInt) });
    }
    anot.a(this.val$app, "dc00898", "", "", "0X8009DFB", "0X8009DFB", 0, 0, this.baO, "2", "", "");
    zsq.c(this.val$activity, acfp.m(2131714078), this.aZY, this.abn, this.baO);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SdkDynamicAvatarSettingHelper", 2, "check api, onSuccess");
    }
    if (zsq.iq(this.val$videoPath))
    {
      paramJSONObject = this.val$intent.getStringExtra("open_id");
      if ((!TextUtils.isEmpty(this.baO)) && (!TextUtils.isEmpty(paramJSONObject)))
      {
        OpenID localOpenID = this.val$app.a().a(this.baO);
        if (localOpenID == null) {}
        while (paramJSONObject.equals(localOpenID.openID)) {
          try
          {
            long l1 = Long.parseLong(this.val$app.getCurrentAccountUin());
            long l2 = System.currentTimeMillis();
            this.val$app.a().a(l1, paramJSONObject, Long.valueOf(this.baO).longValue(), new zst(this, l2));
            return;
          }
          catch (Exception paramJSONObject)
          {
            QLog.e("SdkDynamicAvatarSettingHelper", 1, "checkOpenidDiff exception=", paramJSONObject);
            return;
          }
        }
        zsq.access$100(this.val$activity);
        return;
      }
      QLog.e("SdkDynamicAvatarSettingHelper", 1, "checkOpenid, openId null");
      return;
    }
    anot.a(this.val$app, "dc00898", "", "", "0X8009DFB", "0X8009DFB", 0, 0, this.baO, "3", "", "");
    zsq.c(this.val$activity, acfp.m(2131714082), this.aZY, this.abn, this.baO);
  }
  
  public void onTrigger(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SdkDynamicAvatarSettingHelper", 2, "check api, onTrigger");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zss
 * JD-Core Version:    0.7.0.1
 */