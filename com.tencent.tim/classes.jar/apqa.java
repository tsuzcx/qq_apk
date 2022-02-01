import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.ArrayList;

class apqa
  implements ztd.b
{
  apqa(appx paramappx) {}
  
  public void bw(Bundle paramBundle)
  {
    if ((appx.a(this.this$0) == null) || (appx.a(this.this$0) == null) || (appx.a(this.this$0) == null)) {
      return;
    }
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    Intent localIntent = new Intent();
    localIntent.setClass(appx.a(this.this$0), TroopAvatarWallEditActivity.class);
    localBundle.putInt("index", 0);
    localBundle.putString("troop_uin", appx.a(this.this$0).troopUin);
    localBundle.putLong("troop_flag_ext", appx.a(this.this$0).dwGroupFlagExt);
    localBundle.putBoolean("isUseClassAvatar", appx.a(this.this$0).isUseClassAvatar);
    boolean bool = localBundle.getBoolean("IS_EDIT");
    int i;
    if (!localBundle.getBoolean("IS_COVER"))
    {
      i = 1;
      if (i == 0) {
        break label232;
      }
      paramBundle = (ArrayList)appx.a(this.this$0);
      label165:
      if (!bool) {
        break label246;
      }
      localBundle.putInt("vistor_type", 1);
      label177:
      localBundle.putParcelableArrayList("PHOTO_LIST", paramBundle);
      if (i == 0) {
        break label264;
      }
      if (!bool) {
        break label257;
      }
      i = 260;
    }
    for (;;)
    {
      localIntent.putExtras(localBundle);
      localIntent.addFlags(603979776);
      appx.a(this.this$0).startActivityForResult(localIntent, i);
      return;
      i = 0;
      break;
      label232:
      paramBundle = (ArrayList)appx.b(this.this$0);
      break label165;
      label246:
      localBundle.putInt("vistor_type", 2);
      break label177;
      label257:
      i = 261;
      continue;
      label264:
      if (bool) {
        i = 258;
      } else {
        i = 259;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apqa
 * JD-Core Version:    0.7.0.1
 */