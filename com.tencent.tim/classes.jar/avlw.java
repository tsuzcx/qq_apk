import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qqreader.QRPluginProxyActivity;
import cooperation.qqreader.ui.ReaderContentPageActivity;
import cooperation.qqreader.ui.ReaderHomePageActivity;
import mqq.app.AppRuntime;

public final class avlw
{
  private static Intent a(Activity paramActivity, Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("readtype");
    int i;
    if (paramIntent.hasExtra("key_params_qq")) {
      i = 502;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramActivity = new Intent(paramActivity, ReaderHomePageActivity.class);
        paramActivity.putExtras(a(paramIntent, 1));
        paramActivity.putExtras(paramIntent);
        return paramActivity;
        if (paramIntent.getBooleanExtra("is_from_qreader_shortcut", false)) {
          i = 501;
        } else if (!TextUtils.isEmpty(str1)) {
          try
          {
            i = Integer.valueOf(str1).intValue();
          }
          catch (NumberFormatException localNumberFormatException)
          {
            avoc.d("QRJumpAction", localNumberFormatException.toString());
          }
        } else {
          i = -1;
        }
        break;
      }
    }
    paramIntent.putExtra("openBookDetailByBid", paramIntent.getStringExtra("id"));
    paramIntent.putExtra("openBookDetailByNBid", paramIntent.getStringExtra("nbid"));
    paramIntent.putExtra("item_type", 2);
    paramActivity = new Intent(paramActivity, ReaderContentPageActivity.class);
    paramActivity.putExtras(paramIntent);
    return paramActivity;
    paramIntent.putExtra("tab_index", Integer.valueOf(paramIntent.getStringExtra("column")).intValue());
    paramActivity = new Intent(paramActivity, ReaderHomePageActivity.class);
    paramActivity.putExtras(a(paramIntent, 1));
    paramActivity.putExtras(paramIntent);
    return paramActivity;
    paramIntent.putExtra("url", avoe.rI(rG(paramIntent.getStringExtra("url"))));
    paramIntent.putExtra("item_type", 2);
    paramActivity = new Intent(paramActivity, ReaderContentPageActivity.class);
    paramActivity.putExtras(a(paramIntent, 2));
    paramActivity.putExtras(paramIntent);
    return paramActivity;
    paramIntent.putExtra("item_type", 3);
    paramIntent.putExtra("webview_hide_progress", true);
    paramActivity = new Intent(paramActivity, ReaderContentPageActivity.class);
    paramActivity.putExtras(paramIntent);
    return paramActivity;
    paramIntent.putExtra("openMoreState", true);
    paramIntent.putExtra("item_type", 2);
    paramIntent.putExtra("com.qq.reader.WebContent.bookshelf", 100001);
    paramActivity = new Intent(paramActivity, ReaderContentPageActivity.class);
    paramActivity.putExtras(paramIntent);
    return paramActivity;
    String str2 = "100314";
    if (paramIntent.getBooleanExtra("recent_note", false)) {
      str2 = "100336";
    }
    if (paramIntent.getBooleanExtra("history_note", false)) {
      str2 = "100435";
    }
    paramIntent.putExtra("ChannelID", str2);
    paramActivity = new Intent(paramActivity, ReaderContentPageActivity.class);
    paramActivity.putExtra("is_to_splash_activity", true);
    paramActivity.putExtras(paramIntent);
    return paramActivity;
    paramActivity = new Intent(paramActivity, ReaderContentPageActivity.class);
    paramActivity.putExtra("is_to_splash_activity", true);
    paramActivity.putExtras(paramIntent);
    return paramActivity;
  }
  
  @NonNull
  public static Intent a(Activity paramActivity, Intent paramIntent, String paramString)
  {
    if ((paramActivity == null) || (paramIntent == null) || (TextUtils.isEmpty(paramString)))
    {
      avoc.d("QRJumpAction", "jumpAction args error");
      return new Intent();
    }
    return a(paramActivity, c(paramIntent, paramString));
  }
  
  public static Intent a(@NonNull Intent paramIntent, int paramInt)
  {
    paramIntent.putExtra("item_type", paramInt);
    paramIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    return paramIntent;
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString, avfw.a parama)
  {
    if ((paramContext == null) || (paramIntent == null) || (TextUtils.isEmpty(paramString)))
    {
      avoc.e("QRJumpAction", "jumpToPlugin args error");
      return;
    }
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    avfw.d locald = new avfw.d(1);
    locald.mPluginID = "qqreaderplugin.apk";
    locald.mPluginName = acfp.m(2131712600);
    locald.mUin = str;
    locald.cKu = paramString;
    locald.K = QRPluginProxyActivity.e(paramString);
    paramIntent.putExtra("userQqResources", 2);
    locald.mIntent = paramIntent;
    paramIntent = avcm.a(1);
    if (paramIntent != null)
    {
      paramIntent.dqV();
      locald.a = paramIntent.a;
    }
    try
    {
      avfw.a(paramContext, locald, parama);
      return;
    }
    catch (Exception paramContext)
    {
      avoc.e("QRJumpAction", "[jumpToPlugin] error!", paramContext);
    }
  }
  
  private static Intent c(Intent paramIntent, String paramString)
  {
    int i = 0;
    if ((paramIntent == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    paramIntent.putExtra("launch_by_splash", true);
    paramIntent.putExtra("isFromSplashActivityToCloseQRbridge", true);
    if ((paramIntent.hasExtra("is_from_leba")) && (paramIntent.getBooleanExtra("is_from_leba", false))) {}
    for (;;)
    {
      paramIntent.putExtra("from_where", i);
      paramIntent.putExtra("params_remote_connect_at_launch", true);
      return paramIntent;
      if ((paramIntent.hasExtra("is_from_webview")) && (paramIntent.getBooleanExtra("is_from_webview", false))) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
  
  public static void jumpToPlugin(Context paramContext, Intent paramIntent, String paramString)
  {
    a(paramContext, paramIntent, paramString, null);
  }
  
  public static Intent l(Intent paramIntent)
  {
    return a(paramIntent, 4);
  }
  
  private static String rG(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.contains("/46")) {
        str = paramString.replaceAll("/46", "&");
      }
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avlw
 * JD-Core Version:    0.7.0.1
 */