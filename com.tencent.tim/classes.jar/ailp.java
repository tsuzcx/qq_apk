import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.qphone.base.util.QLog;

class ailp
  implements skj.a
{
  ailp(ailo paramailo, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle.getBoolean("isSuccess", false))
    {
      int i = paramBundle.getInt("appid");
      Object localObject = paramBundle.getString("openId");
      if ((i != this.a.af.intValue()) || (!((String)localObject).equals(this.a.bOT))) {
        break label120;
      }
      paramBundle = paramBundle.getString("uin");
      if (!TextUtils.isEmpty(paramBundle))
      {
        localObject = new Intent(this.a.this$0.getCurrentContext(), FriendProfileCardActivity.class);
        ((Intent)localObject).putExtra("troopUin", this.Uf);
        ((Intent)localObject).putExtra("memberUin", paramBundle);
        this.a.this$0.getCurrentContext().startActivity((Intent)localObject);
      }
    }
    label120:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("UiApiPlugin", 2, "appId != appID || !openId.equals(openID)");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ailp
 * JD-Core Version:    0.7.0.1
 */