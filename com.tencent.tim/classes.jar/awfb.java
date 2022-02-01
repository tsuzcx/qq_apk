import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QZoneWebViewJsHandleLogic.2;
import cooperation.qzone.webviewplugin.QZoneWebViewJsHandleLogic.3;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class awfb
{
  public static awal.a a;
  static CustomWebView a;
  static String bxh;
  
  static
  {
    jdField_a_of_type_Awal$a = new awfc();
  }
  
  private static int a(Context paramContext, String paramString, int paramInt, WebViewPlugin.a parama)
  {
    int i = 2;
    if (paramContext == null) {
      return 5;
    }
    if (checkScheme(paramString)) {
      if (d(paramContext, paramInt))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QZoneWebViewPlugin", 2, "simpleSchemeJump");
        }
        a(paramContext, Uri.parse(paramString));
        paramInt = 1;
      }
    }
    for (;;)
    {
      return paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("QZoneWebViewPlugin", 2, "showQzoneAppDownloadDialog");
      }
      a(paramContext, parama);
      paramInt = i;
      continue;
      if (URLUtil.isNetworkUrl(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QZoneWebViewPlugin", 2, "isNetworkUrl do nothing");
        }
        paramInt = 5;
      }
      else
      {
        paramInt = 5;
      }
    }
  }
  
  static void a(Context paramContext, Uri paramUri)
  {
    Intent localIntent = new Intent();
    localIntent.setData(paramUri);
    localIntent.setPackage("com.qzone");
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, WebViewPlugin.a parama)
  {
    parama = aqha.a(paramContext, 0);
    parama.setMessage(paramContext.getString(2131721123));
    parama.setPositiveButton(paramContext.getString(2131692928), new awfd(paramContext));
    parama.setNegativeButton(paramContext.getString(2131694745), new awfe(parama));
    try
    {
      if (!parama.isShowing()) {
        parama.show();
      }
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("showQzoneAppDownloadDialog", 2, "mDialog.show() exception", paramContext);
    }
  }
  
  /* Error */
  private static void a(WebViewPlugin.a parama, String paramString)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_3
    //   2: aload_0
    //   3: ifnonnull +4 -> 7
    //   6: return
    //   7: new 135	org/json/JSONObject
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 138	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15: astore 5
    //   17: aload 5
    //   19: ldc 140
    //   21: invokevirtual 144	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   24: istore_2
    //   25: aload 5
    //   27: ldc 146
    //   29: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore_1
    //   33: aload 5
    //   35: ldc 152
    //   37: invokevirtual 144	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   40: istore 4
    //   42: iload 4
    //   44: istore_3
    //   45: new 64	android/content/Intent
    //   48: dup
    //   49: invokespecial 65	android/content/Intent:<init>	()V
    //   52: astore 5
    //   54: aload 5
    //   56: ldc 154
    //   58: invokevirtual 157	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   61: pop
    //   62: aload 5
    //   64: ldc 140
    //   66: iload_2
    //   67: invokevirtual 161	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   70: pop
    //   71: aload 5
    //   73: ldc 146
    //   75: aload_1
    //   76: invokestatic 167	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   79: invokevirtual 170	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   82: pop
    //   83: aload 5
    //   85: ldc 172
    //   87: ldc 174
    //   89: invokevirtual 177	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   92: pop
    //   93: aload 5
    //   95: ldc 152
    //   97: iload_3
    //   98: invokevirtual 161	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   101: pop
    //   102: aload_0
    //   103: invokevirtual 183	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   106: astore_0
    //   107: aload_0
    //   108: ifnull -102 -> 6
    //   111: aload_0
    //   112: aload 5
    //   114: invokevirtual 188	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   117: return
    //   118: astore 5
    //   120: ldc 190
    //   122: astore_1
    //   123: iconst_m1
    //   124: istore_2
    //   125: aload 5
    //   127: invokevirtual 193	org/json/JSONException:printStackTrace	()V
    //   130: goto -85 -> 45
    //   133: astore 5
    //   135: ldc 190
    //   137: astore_1
    //   138: goto -13 -> 125
    //   141: astore 5
    //   143: goto -18 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	parama	WebViewPlugin.a
    //   0	146	1	paramString	String
    //   24	101	2	i	int
    //   1	97	3	j	int
    //   40	3	4	k	int
    //   15	98	5	localObject	Object
    //   118	8	5	localJSONException1	JSONException
    //   133	1	5	localJSONException2	JSONException
    //   141	1	5	localJSONException3	JSONException
    // Exception table:
    //   from	to	target	type
    //   7	25	118	org/json/JSONException
    //   25	33	133	org/json/JSONException
    //   33	42	141	org/json/JSONException
  }
  
  public static boolean a(WebViewPlugin paramWebViewPlugin, WebViewPlugin.a parama, String paramString, String... paramVarArgs)
  {
    if ("updateFeedContainer".equalsIgnoreCase(paramString)) {
      h(parama, paramVarArgs);
    }
    do
    {
      return true;
      if ("SendGiftFinished".equalsIgnoreCase(paramString))
      {
        i(parama, paramVarArgs);
        return true;
      }
      if ("sendGiftSuccess".equalsIgnoreCase(paramString))
      {
        j(parama, paramVarArgs);
        return true;
      }
      if ("openAppDetail".equalsIgnoreCase(paramString))
      {
        k(parama, paramVarArgs);
        return true;
      }
      if ("Schema".equalsIgnoreCase(paramString))
      {
        j(paramWebViewPlugin, parama, paramVarArgs);
        return true;
      }
      if (!"refreshFeeds".equals(paramString)) {
        break;
      }
    } while (parama.getActivity() == null);
    cK(parama.getActivity());
    return true;
    if ("UpdateFamousSpaceVpageOptions".equalsIgnoreCase(paramString))
    {
      a(parama, paramVarArgs[0]);
      return true;
    }
    if ("clickWeiShiWidget".equalsIgnoreCase(paramString))
    {
      g(parama, paramVarArgs);
      return true;
    }
    if ("showFamousSpaceVpageOptions".equalsIgnoreCase(paramString))
    {
      f(parama, paramVarArgs);
      return true;
    }
    if ("updateNativeIsSpecialFollow".equalsIgnoreCase(paramString))
    {
      e(parama, paramVarArgs);
      return true;
    }
    if ("ShareToWXMiniProgram".equals(paramString))
    {
      d(parama, paramVarArgs);
      return true;
    }
    if ("pickGameMates".equals(paramString))
    {
      c(parama, paramVarArgs);
      return true;
    }
    return false;
  }
  
  private static void c(WebViewPlugin.a parama, String... paramVarArgs)
  {
    if ((parama != null) && (parama.getActivity() != null) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      parama = new Intent("qzone.pickgamemates");
      parama.putExtra("gamemates", paramVarArgs[0]);
      BaseApplicationImpl.getApplication().sendBroadcast(parama);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneWebViewJsHandleLogic", 1, "handleGameMates = " + paramVarArgs[0]);
      }
    }
  }
  
  public static void cK(Activity paramActivity)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("SignInSbumited");
    if (paramActivity != null) {
      paramActivity.sendBroadcast(localIntent);
    }
  }
  
  private static boolean checkScheme(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString).getScheme();
      if (("mqzone".equals(paramString)) || ("mqzonev2".equals(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  static void d(WebViewPlugin.a parama, String... paramVarArgs)
  {
    if ((parama != null) && (parama.getActivity() != null) && (paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        Object localObject1 = parama.a(parama.getActivity());
        if ((localObject1 != null) && ((localObject1 instanceof ardm.k)))
        {
          localObject1 = ((ardm.k)localObject1).b().b();
          if ((localObject1 != null) && (((arhz)localObject1).isShowing())) {
            ((arhz)localObject1).dismiss();
          }
        }
        jdField_a_of_type_ComTencentBizPubaccountCustomWebView = parama.getWebView();
        Object localObject2 = new JSONObject(paramVarArgs[0]);
        bxh = ((JSONObject)localObject2).optString("callback");
        paramVarArgs = ((JSONObject)localObject2).optString("webpageUrl");
        ((JSONObject)localObject2).optInt("miniprogramType");
        localObject1 = ((JSONObject)localObject2).optString("userName");
        String str1 = ((JSONObject)localObject2).optString("path");
        String str2 = ((JSONObject)localObject2).optString("title");
        String str3 = ((JSONObject)localObject2).optString("description");
        localObject2 = ((JSONObject)localObject2).optString("picUrl");
        HashMap localHashMap = new HashMap(1);
        paramVarArgs = new QZoneWebViewJsHandleLogic.2(parama, localHashMap, str2, str3, paramVarArgs, str1, (String)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          paramVarArgs.run();
          return;
        }
        ThreadManager.post(new QZoneWebViewJsHandleLogic.3((String)localObject2, localHashMap, parama, paramVarArgs), 8, null, false);
        return;
      }
      catch (Exception parama)
      {
        QZLog.e("QZoneWebViewJsHandleLogic", "shareMiniProgramFromQzone error", parama);
      }
    }
  }
  
  public static boolean d(Context paramContext, int paramInt)
  {
    boolean bool2 = false;
    Object localObject = null;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.qzone", 0);
      boolean bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.versionCode >= paramInt) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = localObject;
      }
    }
  }
  
  private static void e(WebViewPlugin.a parama, String... paramVarArgs)
  {
    if ((parama != null) && (parama.getActivity() != null) && (paramVarArgs != null) && (paramVarArgs.length > 0)) {}
    try
    {
      int i = new JSONObject(paramVarArgs[0]).optInt("isSpecialFollow", -1);
      parama = new Intent("updateIsSpecialFollow");
      parama.putExtra("isSpecialFollow", i);
      BaseApplicationImpl.getApplication().sendBroadcast(parama);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneWebViewJsHandleLogic", 1, "followStatus = " + i);
      }
      return;
    }
    catch (Exception parama)
    {
      QLog.e("QZoneWebViewJsHandleLogic", 1, "handleUpdateIsSpecialFollow catch an exception. ", parama);
    }
  }
  
  private static void f(WebViewPlugin.a parama, String... paramVarArgs)
  {
    if ((parama != null) && (parama.getActivity() != null) && (paramVarArgs != null) && (paramVarArgs.length > 0)) {}
    try
    {
      int i = new JSONObject(paramVarArgs[0]).optInt("followStatus");
      parama = new Intent("showFollowActionSheet");
      parama.putExtra("followStatus", i);
      BaseApplicationImpl.getApplication().sendBroadcast(parama);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneWebViewJsHandleLogic", 1, "followStatus = " + i);
      }
      return;
    }
    catch (Exception parama)
    {
      QLog.e("QZoneWebViewJsHandleLogic", 1, "handleShowFollowActionSheet catch an exception. ", parama);
    }
  }
  
  private static void g(WebViewPlugin.a parama, String... paramVarArgs)
  {
    Activity localActivity;
    if ((parama != null) && (parama.getActivity() != null) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      localActivity = parama.getActivity();
      if (aqiz.isAppInstalled(localActivity, "com.tencent.weishi"))
      {
        parama = "";
        try
        {
          paramVarArgs = new JSONObject(paramVarArgs[0]).optString("schema");
          parama = paramVarArgs;
          if (!TextUtils.isEmpty(paramVarArgs))
          {
            parama = paramVarArgs;
            Intent localIntent = new Intent();
            parama = paramVarArgs;
            localIntent.setAction("android.intent.action.VIEW");
            parama = paramVarArgs;
            localIntent.setData(Uri.parse(paramVarArgs));
            parama = paramVarArgs;
            avpw.ay(localIntent);
            parama = paramVarArgs;
            List localList = localActivity.getPackageManager().queryIntentActivities(localIntent, 65536);
            if (localList == null) {
              break label179;
            }
            parama = paramVarArgs;
            if (localList.size() <= 0) {
              break label179;
            }
            parama = paramVarArgs;
            localActivity.startActivity(localIntent);
          }
          for (;;)
          {
            parama = paramVarArgs;
            if (!QLog.isColorLevel()) {
              break;
            }
            parama = paramVarArgs;
            QLog.d("QZoneWebViewJsHandleLogic", 1, "weishi schema is " + paramVarArgs);
            return;
            label179:
            parama = paramVarArgs;
            gy(localActivity);
          }
          gy(localActivity);
        }
        catch (Exception paramVarArgs)
        {
          QLog.e("QZoneWebViewJsHandleLogic", 1, "handleClickWeiShiWidget catch an exception. weishi schema is " + parama, paramVarArgs);
          return;
        }
      }
    }
  }
  
  private static void gy(Context paramContext)
  {
    Intent localIntent;
    if (paramContext != null)
    {
      String str1 = QzoneConfig.getInstance().getConfig("MiniVideo", "DownloadWeishiFromMarket", "market://details?id=com.tencent.weishi");
      if (!TextUtils.isEmpty(str1))
      {
        localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setData(Uri.parse(str1));
        avpw.ay(localIntent);
      }
    }
    try
    {
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      String str2;
      do
      {
        str2 = QzoneConfig.getInstance().getConfig("MiniVideo", "DownloadWeishiFromURL", "https://android.myapp.com/myapp/detail.htm?apkName=com.tencent.weishi");
      } while (TextUtils.isEmpty(str2));
      localIntent.setData(Uri.parse(str2));
      try
      {
        paramContext.startActivity(localIntent);
        return;
      }
      catch (Exception paramContext)
      {
        QLog.e("QZoneWebViewJsHandleLogic", 1, "goToDownloadWeishi catch an exception.", paramContext);
      }
    }
  }
  
  private static void h(WebViewPlugin.a parama, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          if (new JSONObject(paramVarArgs[0]).getInt("height") <= 0)
          {
            if (!(parama.getWebView().getParent() instanceof RelativeLayout)) {
              continue;
            }
            ((RelativeLayout)parama.getWebView().getParent()).setVisibility(8);
          }
        }
        catch (JSONException parama)
        {
          QLog.e("QZoneWebViewJsHandleLogic", 1, parama, new Object[0]);
          return;
        }
      }
    } while (!(parama.getWebView().getParent() instanceof RelativeLayout));
    ((RelativeLayout)parama.getWebView().getParent()).setVisibility(0);
  }
  
  private static void i(WebViewPlugin.a parama, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = new JSONObject(paramVarArgs[0]);
        if (((JSONObject)localObject).getInt("success") == 1)
        {
          paramVarArgs = ((JSONObject)localObject).getJSONArray("uins");
          JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("birthdays");
          String str = ((JSONObject)localObject).getString("giftmessage");
          int j = ((JSONObject)localObject).optInt("giftid");
          if ((paramVarArgs != null) && (paramVarArgs.length() > 0) && (localJSONArray != null) && (localJSONArray.length() == paramVarArgs.length()))
          {
            if ((((JSONObject)localObject).has("toast")) && (((JSONObject)localObject).getBoolean("toast"))) {
              QQToast.a(parama.getActivity(), 2, 2131689674, 0).show();
            }
            localObject = new long[paramVarArgs.length()];
            long[] arrayOfLong = new long[localJSONArray.length()];
            int i = 0;
            while (i < paramVarArgs.length())
            {
              localObject[i] = paramVarArgs.getLong(i);
              arrayOfLong[i] = localJSONArray.getLong(i);
              i += 1;
            }
            Intent localIntent = new Intent();
            localIntent.putExtra("key_msg_type", 2);
            localIntent.putExtra("key_friend_list", (long[])localObject);
            localIntent.putExtra("key_time_list", arrayOfLong);
            localIntent.putExtra("key_msg_content", str);
            localIntent.putExtra("key_gift_id", j);
            parama.getActivity().setResult(-1, localIntent);
            parama.getActivity().finish();
            if (QLog.isColorLevel())
            {
              QLog.d("QZoneWebViewJsHandleLogic", 2, "the giftid is " + j + "\n the giftmessage is" + str + "\n the uins are: " + paramVarArgs.toString() + "\n the birthdays are: " + localJSONArray.toString());
              return;
            }
          }
        }
      }
      catch (JSONException parama)
      {
        QLog.e("QZoneWebViewJsHandleLogic", 1, parama, new Object[0]);
      }
    }
  }
  
  public static String j(String paramString, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return paramString;
      try
      {
        String str = Uri.parse(paramString).getQueryParameter("_wv");
        if (str == null) {
          return j(paramString, "_wv", String.valueOf(paramInt));
        }
        if (paramBoolean)
        {
          str = j(paramString, "_wv", String.valueOf(Integer.valueOf(str).intValue() | paramInt));
          return str;
        }
      }
      catch (Exception localException) {}
    }
    return paramString;
  }
  
  public static String j(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    String str = paramString2 + '=';
    int i = paramString1.indexOf(str);
    int j;
    if (i != -1)
    {
      if (i == 0) {}
      do
      {
        i = paramString1.indexOf(str, str.length() + i);
        break;
        j = paramString1.charAt(i - 1);
      } while ((j != 63) && (j != 35) && (j != 38));
    }
    int k;
    if (i > -1)
    {
      k = i + str.length();
      j = k;
      if (j < paramString1.length())
      {
        int m = paramString1.charAt(j);
        if ((m != 38) && (m != 35)) {}
      }
      else
      {
        if ((!paramString2.equals("_wv")) || (i <= paramString1.indexOf('#'))) {
          break label189;
        }
        paramString1 = Uri.parse(paramString1).buildUpon().appendQueryParameter(paramString2, paramString3).toString();
      }
    }
    for (;;)
    {
      return paramString1;
      j += 1;
      break;
      label189:
      paramString1 = paramString1.substring(0, k) + paramString3 + paramString1.substring(j);
      continue;
      paramString1 = Uri.parse(paramString1).buildUpon().appendQueryParameter(paramString2, paramString3).toString();
    }
  }
  
  private static void j(WebViewPlugin.a parama, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      return;
    }
    try
    {
      LocalMultiProcConfig.putString("BirthdayGiftSendSuccessList", new JSONObject(paramVarArgs[0]).optString("uins"));
      return;
    }
    catch (JSONException parama)
    {
      QLog.e("QZoneWebViewJsHandleLogic", 1, parama, new Object[0]);
    }
  }
  
  private static void j(WebViewPlugin paramWebViewPlugin, WebViewPlugin.a parama, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (parama == null) || (paramVarArgs.length <= 0)) {}
    Object localObject5;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    int i;
    label399:
    label718:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            try
            {
              localObject5 = new JSONObject(paramVarArgs[0]);
              localObject1 = ((JSONObject)localObject5).optString("schema");
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                continue;
              }
              paramVarArgs = parama.getWebView().getUrl();
              if (!awdd.a().ct(paramVarArgs, (String)localObject1))
              {
                QLog.e("QZoneWebViewJsHandleLogic", 1, "has no right handle this jsapi");
                return;
              }
            }
            catch (JSONException paramWebViewPlugin)
            {
              paramWebViewPlugin.printStackTrace();
              QLog.e("QZoneWebViewJsHandleLogic", 1, "handleSchema", paramWebViewPlugin);
              return;
            }
            paramVarArgs = ((JSONObject)localObject5).optJSONObject("dealparam");
            if (paramVarArgs == null) {
              break label1099;
            }
            localObject2 = paramVarArgs.optString("url");
            paramVarArgs = paramVarArgs.optString("blogurl", "");
            if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
              break label1084;
            }
            localObject3 = (String)localObject1 + "&url=" + (String)localObject2;
            localObject1 = localObject2;
            localObject2 = localObject3;
            if (QLog.isColorLevel()) {
              QLog.d("QZoneWebViewPlugin", 2, " handleSchema scheme:" + (String)localObject2);
            }
            localObject4 = null;
            if (parama != null) {
              localObject4 = parama.getActivity();
            }
            localObject3 = localObject4;
            if (localObject4 != null)
            {
              localObject3 = localObject4;
              if ((localObject4 instanceof BasePluginActivity)) {
                localObject3 = ((BasePluginActivity)localObject4).getOutActivity();
              }
            }
            localObject4 = localObject3;
            if (localObject3 != null)
            {
              localObject4 = localObject3;
              if ((localObject3 instanceof BasePluginActivity)) {
                localObject4 = ((BasePluginActivity)localObject3).getOutActivity();
              }
            }
            bool = ((String)localObject2).startsWith("mqzone://arouse/userhome");
            if (bool)
            {
              if (localObject4 == null) {
                continue;
              }
              try
              {
                if (((String)localObject2).indexOf("uin=") != -1)
                {
                  paramWebViewPlugin = ((String)localObject2).substring(((String)localObject2).indexOf("uin=") + 4, ((String)localObject2).length());
                  avpw.a((Context)localObject4, avpw.d.a(), paramWebViewPlugin, 0, 0, 0);
                  return;
                }
              }
              catch (Exception paramWebViewPlugin)
              {
                paramWebViewPlugin.printStackTrace();
                return;
              }
            }
          }
          if (!((String)localObject2).startsWith("mqzone://arouse/webtofeeddetail")) {
            break;
          }
        } while (localObject4 == null);
        parama = parama.a((Activity)localObject4);
        if (!(parama instanceof aran)) {
          break label1115;
        }
        i = ((aran)parama).switchRequestCode(paramWebViewPlugin, (byte)3);
        if (TextUtils.isEmpty(paramVarArgs))
        {
          avpw.a((Activity)localObject4, avpw.d.a(), (String)localObject1, i);
          return;
        }
        avpw.a((Activity)localObject4, avpw.d.a(), (String)localObject1, i, paramVarArgs);
        return;
        if (!((String)localObject2).startsWith("mqzone://arouse/detail")) {
          break;
        }
      } while (localObject4 == null);
      paramVarArgs = Uri.parse((String)localObject2);
      localObject1 = paramVarArgs.getQueryParameter("uin");
      localObject2 = paramVarArgs.getQueryParameter("appid");
      localObject3 = paramVarArgs.getQueryParameter("cellid");
      localObject5 = paramVarArgs.getQueryParameter("subid");
      Object localObject6 = paramVarArgs.getQueryParameter("source");
      String str1 = paramVarArgs.getQueryParameter("cookie");
      String str2 = paramVarArgs.getQueryParameter("local_city_feedindex");
      String str3 = paramVarArgs.getQueryParameter("ugckey");
      String str4 = paramVarArgs.getQueryParameter("feedData");
      String str5 = paramVarArgs.getQueryParameter("needShowBottom");
      String str6 = paramVarArgs.getQueryParameter("urlForTodayInHistory");
      String str7 = paramVarArgs.getQueryParameter("buttonText");
      Bundle localBundle = new Bundle();
      if (localObject6 != null) {
        localBundle.putString("source", (String)localObject6);
      }
      if (str1 != null) {
        localBundle.putString("cookie", str1);
      }
      if (str2 != null) {
        localBundle.putString("local_city_feedindex", str2);
      }
      if (str3 != null) {
        localBundle.putString("ugckey", str3);
      }
      if (str4 != null) {
        localBundle.putString("local_city_feedData", str4);
      }
      if (str5 != null) {
        localBundle.putString("show_share_btn", str5);
      }
      if (str6 != null) {
        localBundle.putString("share_url", str6);
      }
      if (str7 != null) {
        localBundle.putString("share_btn_text", str7);
      }
      localObject6 = parama.a((Activity)localObject4);
      if (!(localObject6 instanceof aran)) {
        break label1120;
      }
      i = ((aran)localObject6).switchRequestCode(paramWebViewPlugin, (byte)3);
      paramWebViewPlugin = avpw.d.a();
      paramWebViewPlugin.cMP = parama.a().getAccount();
      parama = new Bundle();
      parama.putString("source", paramVarArgs.getQueryParameter("source"));
      parama.putString("bypassparam", paramVarArgs.getQueryParameter("bypassparam"));
      parama.putAll(localBundle);
      avpw.a((Activity)localObject4, paramWebViewPlugin, (String)localObject1, (String)localObject2, (String)localObject3, (String)localObject5, i, parama);
      return;
      if (!"mqzone://arouse/dynamicnickname".equalsIgnoreCase((String)localObject2)) {
        break;
      }
    } while ((parama == null) || (parama.getActivity() == null) || (parama.a() == null));
    avpw.X(parama.getActivity(), parama.a().getAccount());
    return;
    if (((String)localObject2).startsWith("mqzone://arouse/uploadphoto"))
    {
      avpw.a(paramWebViewPlugin, parama, parama.getActivity(), parama.a().getAccount(), (String)localObject2);
      return;
    }
    if ((((String)localObject2).startsWith("mqzone://arouse/facade")) || (((String)localObject2).startsWith("mqzonev2://arouse/facade")))
    {
      a(parama.getActivity(), (String)localObject2, 81, parama);
      return;
    }
    if (((String)localObject2).startsWith("mqzone://arouse/moodVoiceRecord"))
    {
      avpw.b(paramWebViewPlugin, parama, parama.getActivity(), parama.a().getAccount(), (String)localObject2);
      return;
    }
    paramVarArgs = new Intent("action_js2qzone");
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putString("cmd", "Schema");
    ((Bundle)localObject1).putString("schema", (String)localObject2);
    if (((JSONObject)localObject5).optInt("showQzoneProgressDialog", 1) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramVarArgs.putExtras((Bundle)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneWebViewPlugin", 2, "handleSchema actionString: " + paramVarArgs.getAction() + "scheme:" + (String)localObject2);
      }
      if (((String)localObject2).startsWith("mqzone://arouse/openvideolayer"))
      {
        i = awff.a(paramWebViewPlugin, parama, 4);
        avpw.a((Activity)localObject4, avpw.d.a(), paramVarArgs, i, bool);
        return;
      }
      avpw.a((Activity)localObject4, avpw.d.a(), paramVarArgs, -1, bool);
      return;
      label1084:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      break;
      label1099:
      localObject3 = null;
      localObject2 = localObject1;
      paramVarArgs = null;
      localObject1 = localObject3;
      break;
      label1115:
      i = 3;
      break label399;
      label1120:
      i = 3;
      break label718;
    }
  }
  
  private static void k(WebViewPlugin.a parama, String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        Object localObject2 = new JSONObject(paramVarArgs[0]);
        paramVarArgs = ((JSONObject)localObject2).getString("packName");
        Object localObject1 = ((JSONObject)localObject2).getString("taskAppId");
        String str1 = ((JSONObject)localObject2).getString("appId");
        String str2 = ((JSONObject)localObject2).getString("taskApkId");
        String str3 = ((JSONObject)localObject2).getString("via");
        String str4 = ((JSONObject)localObject2).getString("versionCode");
        String str5 = ((JSONObject)localObject2).getString("channel");
        localObject2 = ((JSONObject)localObject2).getString("from");
        int j = 3;
        int i = j;
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            i = Integer.parseInt((String)localObject2);
          }
          localObject2 = new StringBuilder();
          if (!TextUtils.isEmpty(str1)) {
            ((StringBuilder)localObject2).append(aryv.PARAM_SNG_APPID).append("=").append(str1);
          }
          if (!TextUtils.isEmpty(paramVarArgs)) {
            ((StringBuilder)localObject2).append("&").append(aryv.PARAM_TASK_PACKNAME).append("=").append(paramVarArgs);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            ((StringBuilder)localObject2).append("&").append(aryv.PARAM_TASK_APPID).append("=").append((String)localObject1);
          }
          if (!TextUtils.isEmpty(str2)) {
            ((StringBuilder)localObject2).append("&").append(aryv.PARAM_TASK_APK_ID).append("=").append(str2);
          }
          if (!TextUtils.isEmpty(str3)) {
            ((StringBuilder)localObject2).append("&").append(aryv.PARAM_VIA).append("=").append(str3);
          }
          if (!TextUtils.isEmpty(str4)) {
            ((StringBuilder)localObject2).append("&").append(aryv.PARAM_TASK_VERSION).append("=").append(str4);
          }
          if (!TextUtils.isEmpty(str5)) {
            ((StringBuilder)localObject2).append("&").append(aryv.cDC).append("=").append(str5);
          }
          paramVarArgs = ((StringBuilder)localObject2).toString();
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("from", i);
          ((Bundle)localObject1).putString("schemaUrl", paramVarArgs);
          avpw.ac((Bundle)localObject1);
          arue.openAppDetail(parama.getActivity(), (Bundle)localObject1);
          return;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.e("QZoneWebViewJsHandleLogic", 2, "from 错误", localNumberFormatException);
              i = j;
            }
          }
        }
        return;
      }
      catch (JSONException parama)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QZoneWebViewJsHandleLogic", 2, "json 解析异常", parama);
        }
      }
    }
  }
  
  static void q(String paramString, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("handleUrl", 2, "browse url fail:" + paramString);
      }
    }
    do
    {
      return;
      paramString = j(paramString, 7, false);
      Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserDelegationActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("fromQZone", true);
      localIntent.putExtra("injectrecommend", true);
      localIntent.setData(Uri.parse(paramString));
      localIntent.addFlags(268435456);
      localIntent.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131717944));
      paramContext.startActivity(localIntent);
    } while (!QLog.isColorLevel());
    QLog.d("handleurl", 2, "jump to browser: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awfb
 * JD-Core Version:    0.7.0.1
 */