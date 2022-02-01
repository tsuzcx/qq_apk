import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.friends.intimate.MiniGamePlayTogetherHandler.1.1;
import com.tencent.mobileqq.friends.intimate.MiniGamePlayTogetherHandler.1.2;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public final class ahpw
  implements MiniAppCmdInterface
{
  ahpw(Context paramContext, String paramString) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Activity localActivity = (Activity)this.val$context;
    if (paramJSONObject != null)
    {
      int i = paramJSONObject.optInt("retCode");
      String str = paramJSONObject.optString("errMsg");
      if (i == 0)
      {
        localActivity.startActivity(wja.a(new Intent(localActivity, SplashActivity.class), new int[] { 2 }).putExtra("uin", this.SO).putExtra("uintype", 0));
        return;
      }
      localActivity.runOnUiThread(new MiniGamePlayTogetherHandler.1.1(this, localActivity, str));
      QLog.e("MiniGamePlayTogetherHandler", 1, new Object[] { "createUpdatableMsg fail, retCode=", Integer.valueOf(i), ", errMsg=", str, ",ret=", paramJSONObject.toString() });
      return;
    }
    localActivity.runOnUiThread(new MiniGamePlayTogetherHandler.1.2(this, localActivity));
    QLog.e("MiniGamePlayTogetherHandler", 1, new Object[] { "createUpdatableMsg fail, isSuc=", Boolean.valueOf(paramBoolean), ", ret=", paramJSONObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahpw
 * JD-Core Version:    0.7.0.1
 */