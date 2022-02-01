import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.qphone.base.util.QLog;

public class ailn
  implements skj.a
{
  public ailn(UiApiPlugin paramUiApiPlugin, Integer paramInteger, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle.getBoolean("isSuccess", false))
    {
      int i = paramBundle.getInt("appid");
      Object localObject = paramBundle.getString("openId");
      if ((i != this.af.intValue()) || (!((String)localObject).equals(this.bOT))) {
        break label178;
      }
      str1 = paramBundle.getString("uin");
      bool = paramBundle.getBoolean("isFriend", false);
      localObject = paramBundle.getString("nickName");
      str2 = paramBundle.getString("remark");
      if (!TextUtils.isEmpty(str1))
      {
        if (!bool) {
          break label163;
        }
        paramBundle = new ProfileActivity.AllInOne(str1, 1);
        paramBundle.nickname = ((String)localObject);
        paramBundle.remark = str2;
        localObject = new Intent(this.this$0.getCurrentContext(), FriendProfileCardActivity.class);
        ((Intent)localObject).putExtra("AllInOne", paramBundle);
        ((Intent)localObject).addFlags(536870912);
        this.this$0.getCurrentContext().startActivity((Intent)localObject);
      }
    }
    label163:
    label178:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        String str1;
        boolean bool;
        String str2;
        return;
        paramBundle = new ProfileActivity.AllInOne(str1, 105);
      }
    }
    QLog.d("UiApiPlugin", 2, "appId != appID || !openId.equals(openID)");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ailn
 * JD-Core Version:    0.7.0.1
 */