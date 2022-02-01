import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class yff
  extends BroadcastReceiver
{
  public yff(TroopChatPie paramTroopChatPie) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction())) && ("onHomeworkTroopIdentityChanged".equals(paramIntent.getStringExtra("event"))))
    {
      paramContext = paramIntent.getStringExtra("data");
      if (!TextUtils.isEmpty(paramContext)) {
        break label41;
      }
    }
    for (;;)
    {
      return;
      try
      {
        label41:
        Object localObject = new JSONObject(paramContext);
        paramContext = ((JSONObject)localObject).optString("groupCode");
        if (TextUtils.equals(paramContext, this.this$0.sessionInfo.aTl))
        {
          paramIntent = ((JSONObject)localObject).optString("content");
          String str1 = ((JSONObject)localObject).optString("source");
          int i = ((JSONObject)localObject).optInt("rankId", 333);
          String str2 = ((JSONObject)localObject).optString("nickName");
          String str3 = ((JSONObject)localObject).optString("uin");
          String str4 = ((JSONObject)localObject).optString("course");
          localObject = ((JSONObject)localObject).optString("name");
          if ((!"join".equals(str1)) && (TextUtils.equals(str3, this.this$0.app.getCurrentAccountUin())))
          {
            ((TroopManager)this.this$0.app.getManager(52)).c(this.this$0.sessionInfo.aTl, str3, str2, i, str4, (String)localObject);
            if (this.this$0.a != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d(this.this$0.TAG, 2, "mHomeworkTroopIdentityChangedReceiver dismissTipsBar.");
              }
              this.this$0.a.a(TroopChatPie.a(this.this$0), false);
            }
            if (TroopChatPie.a(this.this$0) != null) {
              TroopChatPie.a(this.this$0).WH(i);
            }
          }
          if (QLog.isColorLevel())
          {
            QLog.d("zivonchen", 2, new Object[] { "mHomeworkTroopIdentityChangedReceiver troopUin = ", paramContext, ", content = ", paramIntent, ", source = ", str1, ", rankId = ", Integer.valueOf(i), ", nickName = ", str2, "uin = ", str3 });
            return;
          }
        }
      }
      catch (JSONException paramContext) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yff
 * JD-Core Version:    0.7.0.1
 */