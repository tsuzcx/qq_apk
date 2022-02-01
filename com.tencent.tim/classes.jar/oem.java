import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import cooperation.qzone.util.NetworkState;
import org.json.JSONException;
import org.json.JSONObject;

public class oem
{
  private static DownloadInfo c;
  
  public static DownloadInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    DownloadInfo localDownloadInfo = new DownloadInfo();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localDownloadInfo.appId = localJSONObject.getString("appid");
      localDownloadInfo.urlStr = localJSONObject.getString("url");
      localDownloadInfo.packageName = localJSONObject.getString("packageName");
      localDownloadInfo.via = localJSONObject.getString("via");
      localDownloadInfo.isAutoInstall = true;
      localDownloadInfo.isAutoInstallBySDK = true;
      localDownloadInfo.ell = TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE;
      String str = localJSONObject.getString("isAutoInstall");
      if (str != null) {
        localDownloadInfo.isAutoInstall = str.equals("1");
      }
      str = localJSONObject.getString("isAutoInstallBySDK");
      if (str != null) {
        localDownloadInfo.isAutoInstallBySDK = str.equals("1");
      }
      str = localJSONObject.getString("isShowNotification");
      if (str != null) {
        if (!str.equals("1")) {
          break label189;
        }
      }
      label189:
      for (int i = TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE;; i = TMAssistantDownloadConst.SHOW_NOTIFICATION_FALSE)
      {
        localDownloadInfo.ell = i;
        localDownloadInfo.ddw = true;
        localDownloadInfo.source = kxm.bg(40677);
        localDownloadInfo.pushTitle = localJSONObject.getString("appName");
        return localDownloadInfo;
      }
      return null;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("VideoFeedsWeiShiUtils", 4, "json err:" + paramString);
    }
  }
  
  public static void aT(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    Intent localIntent;
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(paramString));
      localIntent = new Intent();
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.putExtra("big_brother_source_key", kxm.bg(40677));
      localIntent.putExtra("big_brother_ref_source_key", kxm.bg(0));
      localIntent.setData(Uri.parse(fu(paramString)));
    } while (!muj.isIntentAvailable(paramContext, localIntent));
    paramContext.startActivity(localIntent);
  }
  
  public static void aU(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!TextUtils.isEmpty(ft(paramString))) {
      c = a(ft(paramString));
    }
    if (c != null)
    {
      if (NetworkState.getNetworkType() == 1)
      {
        aryy.a().b(c);
        return;
      }
      paramContext = aqha.a(paramContext, 230);
      paramContext.setTitle(null);
      paramContext.setNegativeButton("", new oeo()).setPositiveButton("", new oen());
      paramContext.show();
      return;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", fs(paramString));
    localIntent.putExtra("big_brother_source_key", kxm.bg(40677));
    paramContext.startActivity(localIntent);
  }
  
  public static DownloadInfo b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      DownloadInfo localDownloadInfo = new DownloadInfo();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (!localJSONObject.optBoolean("isWeb", false))
        {
          localDownloadInfo.urlStr = localJSONObject.optString("url");
          localDownloadInfo.packageName = localJSONObject.optString("packageName", null);
          localDownloadInfo.source = kxm.bg(0);
          return localDownloadInfo;
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("VideoFeedsWeiShiUtils", 4, "json err:" + paramString);
      }
    }
    return null;
  }
  
  private static String fs(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (paramString.equals("video_type_videocard")) {
        return "https://act.qzone.qq.com/vip/meteor/m/p/3f04eaa353710dd5c996e09588244bf93066";
      }
      if (paramString.equals("video_type_videoguid")) {
        return "https://act.qzone.qq.com/vip/meteor/m/p/01e512f4384e934f8b42e30f9e16f1283064";
      }
    } while (!paramString.equals("video_type_videopublic"));
    return "https://act.qzone.qq.com/vip/meteor/m/p/f644be070eeed9bcba017b43a8c7980a3065";
  }
  
  private static String ft(String paramString)
  {
    return null;
  }
  
  private static String fu(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (paramString.equals("video_type_videocard")) {
        return "weishi://main?goto=recommend&logsour=5001";
      }
      if (paramString.equals("video_type_videoguid")) {
        return "weishi://main?goto=recommend&logsour=5002";
      }
    } while (!paramString.equals("video_type_videopublic"));
    return "weishi://main?goto=recommend&logsour=5003";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oem
 * JD-Core Version:    0.7.0.1
 */