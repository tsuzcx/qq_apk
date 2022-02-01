import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class aqhy
  extends jnm.d
{
  aqhy(aqhv paramaqhv, String paramString1, String paramString2, String paramString3) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ahlw.x("KEY_STAGE_2_GO_TO_CHAT_D55", bool1);
      this.this$0.hideProgressDialog();
      if (!this.this$0.cUg) {
        break;
      }
      anot.a(this.this$0.app, "dc01160", "", "", "0X800A40E", "0X800A40E", 0, 0, "", "", this.this$0.context.getString(2131701796), "");
      QQToast.a(this.this$0.context, 1, 2131701796, 1).show();
      paramArrayOfByte = new Intent(this.this$0.context, SplashActivity.class);
      paramArrayOfByte.addFlags(67108864);
      paramArrayOfByte.addFlags(268435456);
      this.this$0.context.startActivity(paramArrayOfByte);
      aqhv.d(this.this$0);
      return;
    }
    if (this.this$0.dJ != null) {
      this.this$0.dJ.removeCallbacksAndMessages(null);
    }
    if (paramInt == 0) {
      paramInt = 0;
    }
    boolean bool2;
    Object localObject;
    for (;;)
    {
      if (paramInt <= 1)
      {
        paramBundle = (String)this.this$0.attrs.get("uin");
        if ((paramBundle == null) || (paramBundle.length() < 5) || (SearchBaseActivity.R.matcher(paramBundle).matches()))
        {
          QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131701794, 1).show();
          anot.a(this.this$0.app, "dc01160", "", "", "0X800A40E", "0X800A40E", 0, 0, "", "", this.this$0.context.getString(2131701797), "");
          aqhv.d(this.this$0);
          return;
          if (paramInt == 25501) {
            paramInt = 1;
          } else {
            paramInt = 2;
          }
        }
        else
        {
          bool2 = ((acff)this.this$0.app.getManager(51)).isFriend(paramBundle);
          paramArrayOfByte = aqgv.s(this.this$0.app, paramBundle);
          if ((bool2) && (paramInt == 0))
          {
            localObject = new Intent(this.this$0.context, SplashActivity.class);
            ((Intent)localObject).putExtra("uin", paramBundle);
            ((Intent)localObject).putExtra("uintype", 0);
            ((Intent)localObject).putExtra("openid", this.ctt);
            ((Intent)localObject).putExtra("appid", this.ctp);
            ((Intent)localObject).putExtra("thridparty_pull_aio", true);
            paramBundle = wja.a((Intent)localObject, new int[] { 2 });
            paramBundle.putExtra("pull_aio_audio", this.ctv.equals("audio_chat"));
            paramBundle.putExtra("pull_aio_video", this.ctv.equals("video_chat"));
            if (paramArrayOfByte != null) {
              paramBundle.putExtra("uinname", paramArrayOfByte);
            }
            this.this$0.context.startActivity(paramBundle);
          }
        }
      }
    }
    for (;;)
    {
      aqhv.d(this.this$0);
      return;
      if (paramInt == 1)
      {
        bool1 = true;
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("pull_show_open_id_diff_main", bool1);
        ((Bundle)localObject).putString("uin", paramBundle);
        ((Bundle)localObject).putInt("uintype", 0);
        if (paramArrayOfByte != null) {
          ((Bundle)localObject).putString("uinname", paramArrayOfByte);
        }
        ((Bundle)localObject).putString("openid", this.ctt);
        ((Bundle)localObject).putString("appid", this.ctp);
        anot.a(this.this$0.app, "dc01160", "", "", "0X800A40F", "0X800A40F", 0, 0, "", "", "", "");
        if (!bool2) {
          break label658;
        }
        ((Bundle)localObject).putBoolean("thridparty_pull_aio", true);
        ((Bundle)localObject).putBoolean("pull_aio_audio", this.ctv.equals("audio_chat"));
        ((Bundle)localObject).putBoolean("pull_aio_video", this.ctv.equals("video_chat"));
      }
      for (;;)
      {
        aqhv.a(this.this$0, (Bundle)localObject);
        aqhv.d(this.this$0);
        return;
        bool1 = false;
        break;
        label658:
        ((Bundle)localObject).putInt("fragment_id", 1);
        ((Bundle)localObject).putBoolean("pull_add_friend_tip", true);
      }
      paramArrayOfByte = aceo.p(paramArrayOfByte);
      anot.a(this.this$0.app, "inter", "skip", "inter_fail", "", 1, "", paramArrayOfByte, "", "", "", "", "", "", "");
      paramBundle = new Bundle();
      paramBundle.putBoolean("pull_app_not_privilege", true);
      paramBundle.putString("pull_app_not_privilege_string", paramArrayOfByte);
      aqhv.a(this.this$0, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqhy
 * JD-Core Version:    0.7.0.1
 */