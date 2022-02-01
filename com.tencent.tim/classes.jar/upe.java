import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class upe
  implements BusinessObserver
{
  public upe(ChatSettingActivity paramChatSettingActivity, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          Object localObject = new WebSsoBody.WebSsoResponseBody();
          ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
          paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
          localObject = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get());
          if (paramInt != 0)
          {
            paramBundle = ((JSONObject)localObject).optString("msg");
            if ((!TextUtils.isEmpty(paramBundle)) && (QLog.isColorLevel()))
            {
              QLog.d(ChatSettingActivity.a(this.this$0) + "Q.nearby.follow", 2, "sendOperateFollowUser,targetUin:" + ChatSettingActivity.b(this.this$0) + ", op:" + this.aMh + ", errMsg:" + paramBundle);
              QQToast.a(this.this$0, 1, paramBundle, 0).show(this.this$0.getTitleBarHeight());
            }
          }
          else
          {
            paramBundle = ((JSONObject)localObject).getJSONObject("result");
            if (((JSONObject)localObject).optInt("retcode") == 0)
            {
              localObject = this.this$0;
              if (this.this$0.mIsFollowed) {
                break label648;
              }
              paramBoolean = true;
              ((ChatSettingActivity)localObject).mIsFollowed = paramBoolean;
              ChatSettingActivity.a(this.this$0);
              if (this.this$0.mIsFollowed)
              {
                ChatSettingActivity.a(this.this$0, false);
                ((aizg)this.this$0.app.getManager(16)).H(0, 1, ChatSettingActivity.b(this.this$0));
                ChatSettingActivity.a(this.this$0).setOnCheckedChangeListener(null);
                if (QLog.isColorLevel()) {
                  QLog.d(this.this$0.aLY, 2, "sendOperateFollowUser, mIsShield=" + ChatSettingActivity.a(this.this$0) + ", mIsFollowed=" + this.this$0.mIsFollowed);
                }
                ChatSettingActivity.b(this.this$0);
                ChatSettingActivity.a(this.this$0).setOnCheckedChangeListener(this.this$0);
              }
              localObject = this.this$0;
              ChatSettingActivity localChatSettingActivity = this.this$0;
              if (!this.aMh.equals("1")) {
                break label653;
              }
              paramInt = 2131696197;
              label390:
              QQToast.a((Context)localObject, 2, localChatSettingActivity.getString(paramInt), 0).show(this.this$0.getTitleBarHeight());
              if (!QLog.isColorLevel()) {
                return;
              }
              QLog.d(ChatSettingActivity.a(this.this$0) + "Q.nearby.follow", 2, "sendOperateFollowUser,targetUin:" + ChatSettingActivity.b(this.this$0) + ", op:" + this.aMh + ", result:" + paramBundle.toString());
              return;
            }
          }
        }
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.d(ChatSettingActivity.a(this.this$0), 2, "sendOperateFollowUser, Exception");
        }
      }
    }
    else
    {
      paramBundle = this.this$0;
      if (!this.aMh.equals("1")) {
        break label659;
      }
    }
    label648:
    label653:
    label659:
    for (paramInt = 2131696196;; paramInt = 2131696209)
    {
      paramBundle = paramBundle.getString(paramInt);
      QQToast.a(this.this$0, 1, paramBundle, 0).show(this.this$0.getTitleBarHeight());
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.d(ChatSettingActivity.a(this.this$0) + "Q.nearby.follow", 2, "sendOperateFollowUser,targetUin:" + ChatSettingActivity.b(this.this$0) + ", op:" + this.aMh + ", re:" + paramBundle);
      return;
      paramBoolean = false;
      break;
      paramInt = 2131696210;
      break label390;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     upe
 * JD-Core Version:    0.7.0.1
 */