import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcenter.QZoneAppWebViewActivity;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.appcommon.Common;
import com.tencent.open.base.FileUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.MyAppApi;
import java.io.File;
import java.util.HashMap;

public final class hkc
  implements Runnable
{
  public hkc(Bundle paramBundle1, Bundle paramBundle2, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    boolean bool;
    String str1;
    Object localObject;
    Intent localIntent;
    Bundle localBundle;
    if (Common.a(this.jdField_a_of_type_AndroidOsBundle.getString("schemaUrl")).get("auto_download") != null)
    {
      bool = true;
      if (!MyAppApi.a().a(CommonDataAdapter.a().a(), this.jdField_b_of_type_AndroidOsBundle, bool, false))
      {
        str1 = Common.e() + File.separator + "qapp_center_detail.htm";
        localObject = new File(str1);
        if (!((File)localObject).exists())
        {
          LogUtility.d(AppClient.jdField_a_of_type_JavaLangString, "file" + str1 + " not exist copyassets.");
          FileUtils.a("Page/system", Common.f());
        }
        localIntent = new Intent();
        localBundle = new Bundle();
        if (!((File)localObject).exists()) {
          break label380;
        }
        localObject = "file:///" + str1;
        label170:
        str1 = "&from=-10&id=" + this.jdField_a_of_type_JavaLangString + "&channelId=" + this.jdField_b_of_type_JavaLangString;
        if (!bool) {
          break label442;
        }
        str1 = str1 + "&auto_download=1";
      }
    }
    label411:
    label442:
    for (;;)
    {
      String str2 = str1;
      if (!TextUtils.isEmpty(this.c)) {
        if (!this.c.equals(this.jdField_a_of_type_JavaLangString)) {
          break label411;
        }
      }
      for (str2 = str1;; str2 = str1 + "&" + this.c)
      {
        localIntent.setClass(CommonDataAdapter.a().a(), QZoneAppWebViewActivity.class);
        localBundle.putString("APP_URL", (String)localObject);
        localBundle.putBoolean("FROM_FEED", true);
        localBundle.putString("APP_PARAMS", str2);
        LogUtility.b("Jie", "APP_URL:" + (String)localObject + " |  PARAMS >>> " + localBundle.getString("APP_PARAMS"));
        localIntent.putExtras(localBundle);
        localIntent.putExtra("adapter_action", "action_app_detail");
        localIntent.addFlags(872415232);
        CommonDataAdapter.a().a().startActivity(localIntent);
        return;
        bool = false;
        break;
        label380:
        localObject = Common.l() + File.separator + "qapp_center_detail.htm";
        break label170;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hkc
 * JD-Core Version:    0.7.0.1
 */