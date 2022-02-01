import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class aoun
  extends AsyncTask<Void, Void, Bundle>
{
  public aoun(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, URLDrawable paramURLDrawable, String paramString) {}
  
  protected Bundle a(Void... paramVarArgs)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    paramVarArgs = new File(acbn.bmS);
    if (!paramVarArgs.exists()) {
      paramVarArgs.mkdirs();
    }
    String str = acbn.bmS + this.this$0.mTroopUin + Utils.Crc64String(this.x.getURL().toString());
    paramVarArgs = str;
    if (!new File(str).exists()) {}
    try
    {
      paramVarArgs = this.x.saveTo(str);
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", this.val$thumbUrl);
      localBundle.putString("forward_filepath", paramVarArgs);
      localBundle.putString("forward_urldrawable_big_url", this.x.getURL().toString());
      localBundle.putString("forward_extra", paramVarArgs);
      if (this.this$0.cOO)
      {
        localBundle.putString("forward_thumb", paramVarArgs);
        localBundle.putBoolean("key_flag_from_plugin", true);
      }
      return localBundle;
    }
    catch (IOException paramVarArgs)
    {
      QLog.e("foward", 2, "IOException", paramVarArgs);
    }
    return null;
  }
  
  protected void dg(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QQToast.a(this.this$0, acfp.m(2131715569), 0).show(this.this$0.getTitleBarHeight());
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    ahgq.f(this.this$0, localIntent, 21);
    TroopAvatarWallPreviewActivity.a(this.this$0, "0X8006A81", "0X8006A95");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoun
 * JD-Core Version:    0.7.0.1
 */