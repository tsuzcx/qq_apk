import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QzoneTiantaiTranslucentBrowserActivity;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class awfv
  extends awfr
{
  private avtz.c c = new awfw(this);
  
  private void ae(String... paramVarArgs)
  {
    String str1;
    int i;
    int j;
    String str2;
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        str1 = paramVarArgs.optString("url");
        i = paramVarArgs.optInt("id", -1);
        j = paramVarArgs.optInt("download");
        str2 = paramVarArgs.optString("callback");
        if ((j != 0) && (TextUtils.isEmpty(str1)))
        {
          QLog.e("QzonePersonalizeJsPlugin", 1, "url is empty.");
          return;
        }
        if (TextUtils.isEmpty(str2))
        {
          QLog.e("QzonePersonalizeJsPlugin", 1, "callback is empty.");
          return;
        }
      }
      catch (Exception paramVarArgs)
      {
        QLog.e("QzonePersonalizeJsPlugin", 1, paramVarArgs.getMessage());
        return;
      }
      if (Build.VERSION.SDK_INT >= 11) {
        break label193;
      }
      QLog.e("QzonePersonalizeJsPlugin", 1, "low android version system, so not to download font. sdk = " + Build.VERSION.SDK_INT);
      am(str2, -1, "font has not been cached.");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(avtz.a(i, str1, str2, paramVarArgs)))
      {
        am(str2, 0, "success");
        return;
      }
      label193:
      do
      {
        paramVarArgs = this.c;
        break;
        if (paramVarArgs == null) {
          am(str2, -1, "font has not been cached.");
        }
        return;
      } while (j != 0);
      paramVarArgs = null;
    }
  }
  
  private void af(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      long l;
      String str;
      int i;
      int j;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramVarArgs[0]);
        l = localJSONObject.optLong("uin");
        str = localJSONObject.optString("url");
        i = localJSONObject.optInt("id", -1);
        j = localJSONObject.optInt("formatType");
        if (localJSONObject.optInt("sparkle_id", -1) != -1) {
          ah(paramVarArgs);
        }
        if (localJSONObject.optInt("bubble_iItemId", -2147483648) != -2147483648) {
          ag(paramVarArgs);
        }
        if (i < 0)
        {
          QLog.e("QzonePersonalizeJsPlugin", 1, "font id error , id = " + i);
          return;
        }
        if ((i > 0) && (TextUtils.isEmpty(str)))
        {
          QLog.e("QzonePersonalizeJsPlugin", 1, "url is empty.");
          return;
        }
      }
      catch (Exception paramVarArgs)
      {
        QLog.e("QzonePersonalizeJsPlugin", 1, paramVarArgs.getMessage());
        return;
      }
      paramVarArgs = new avua.b();
      paramVarArgs.fontId = i;
      paramVarArgs.eyB = j;
      paramVarArgs.fontUrl = str;
      avtz.a(l, paramVarArgs);
      if (i > 0) {
        avtz.a(l, null);
      }
    }
  }
  
  private void ag(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        Object localObject2 = new JSONObject(paramVarArgs[0]);
        long l = ((JSONObject)localObject2).optLong("uin");
        int i = ((JSONObject)localObject2).optInt("bubble_iItemId", -2147483648);
        paramVarArgs = ((JSONObject)localObject2).optString("bubble_strTextColor");
        Object localObject1 = ((JSONObject)localObject2).optString("bubble_strAndBgUrl");
        String str1 = ((JSONObject)localObject2).optString("bubble_strIosBgUrl");
        String str2 = ((JSONObject)localObject2).optString("bubble_strFrameZip");
        int j = ((JSONObject)localObject2).optInt("bubble_iFrameRate");
        if (i == -2147483648)
        {
          QLog.e("QzonePersonalizeJsPlugin", 1, "CommentBubble id error , id = " + i);
          return;
        }
        localObject2 = new avua.a();
        ((avua.a)localObject2).itemId = i;
        ((avua.a)localObject2).jsonStr = avua.a.a(i, paramVarArgs, (String)localObject1, str1, str2, j);
        avtz.a(l, (avua.a)localObject2);
        paramVarArgs = new Intent("action_personalize_js2qzone");
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("cmd", "refreshCommonList");
        paramVarArgs.putExtras((Bundle)localObject1);
        avpw.a(this.f.mRuntime.getActivity(), avpw.d.a(), paramVarArgs);
        if (i > 0)
        {
          avtz.a(l, null);
          avtz.a(l, null);
          return;
        }
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
    }
  }
  
  private void ah(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        long l = paramVarArgs.optLong("uin");
        int i = paramVarArgs.optInt("sparkle_id");
        paramVarArgs = paramVarArgs.optString("sparkle_json");
        if (i < 0)
        {
          QLog.e("QzonePersonalizeJsPlugin", 1, "font id error , id = " + i);
          return;
        }
        avua.c localc = new avua.c();
        localc.fontId = i;
        localc.jsonStr = paramVarArgs;
        avtz.a(l, localc);
        if (i > 0)
        {
          avtz.a(l, null);
          return;
        }
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
    }
  }
  
  private void ai(String[] paramArrayOfString)
  {
    int j = -1;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      for (;;)
      {
        avua.c localc;
        avua.a locala;
        try
        {
          paramArrayOfString = new JSONObject(paramArrayOfString[0]);
          long l = paramArrayOfString.optLong("uin");
          paramArrayOfString = paramArrayOfString.optString("callback");
          if (TextUtils.isEmpty(paramArrayOfString))
          {
            QLog.e("QzonePersonalizeJsPlugin", 1, "callback is empty.");
            return;
          }
          avua.b localb = avtz.a(l);
          localc = avtz.a(l);
          locala = avtz.a(l);
          try
          {
            JSONObject localJSONObject = new JSONObject();
            if (localb == null)
            {
              i = -1;
              localJSONObject.put("id", i);
              if (localc != null) {
                break label191;
              }
              i = -1;
              localJSONObject.put("sparkle_id", i);
              if (locala != null) {
                break label200;
              }
              i = j;
              localJSONObject.put("bubble_iItemId", i);
              this.f.mRuntime.getWebView().callJs(paramArrayOfString, new String[] { localJSONObject.toString() });
              return;
            }
          }
          catch (JSONException paramArrayOfString)
          {
            QLog.e("QzonePersonalizeJsPlugin", 1, paramArrayOfString.getMessage());
            return;
          }
          i = localb.fontId;
        }
        catch (Exception paramArrayOfString)
        {
          QLog.e("QzonePersonalizeJsPlugin", 1, paramArrayOfString.getMessage());
          return;
        }
        continue;
        label191:
        int i = localc.fontId;
        continue;
        label200:
        i = locala.itemId;
      }
    }
  }
  
  private void aj(String... paramVarArgs)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramVarArgs[0]);
      Intent localIntent = new Intent("action_personalize_js2qzone");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "Custom_Player_Setting");
      localBundle.putInt("itemId", localJSONObject.getInt("itemId"));
      localBundle.putString("playerDecoUrl", localJSONObject.optString("playerDecoUrl"));
      localBundle.putLong("textColor", localJSONObject.optLong("textColor"));
      localIntent.putExtras(localBundle);
      avpw.a(this.f.mRuntime.getActivity(), avpw.d.a(), localIntent);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QzonePersonalizeJsPlugin", 1, "parse json error " + paramVarArgs[0]);
    }
  }
  
  private void ak(String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {}
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]);
      if (paramArrayOfString.optInt("transparent") == 1) {
        i = 1;
      }
      paramArrayOfString = paramArrayOfString.optString("url");
      Activity localActivity = this.f.mRuntime.getActivity();
      if (i != 0)
      {
        if ((localActivity instanceof BasePluginActivity))
        {
          avpw.a(((BasePluginActivity)localActivity).getOutActivity(), paramArrayOfString, -1, null, null);
          return;
        }
        avpw.a(localActivity, paramArrayOfString, -1, null, null);
        return;
      }
      if ((localActivity instanceof BasePluginActivity))
      {
        avpw.forwardToBrowser(((BasePluginActivity)localActivity).getOutActivity(), paramArrayOfString, -1, null, null);
        return;
      }
      avpw.forwardToBrowser(localActivity, paramArrayOfString, -1, null, null);
      return;
    }
    catch (Exception paramArrayOfString) {}
  }
  
  private void al(String[] paramArrayOfString)
  {
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]);
      boolean bool = paramArrayOfString.getBoolean("isGet");
      paramArrayOfString = paramArrayOfString.getString("ugckey");
      if (bool)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("param.yellowdiamondRedpocketUgckey", paramArrayOfString);
        avzf.a().a("cmd.getYellowDiamondRedPocket", localBundle, false);
      }
      return;
    }
    catch (Exception paramArrayOfString)
    {
      QLog.w("QzonePersonalizeJsPlugin", 1, "handleYellowDiamondRedpocket  ", paramArrayOfString);
    }
  }
  
  private void am(String paramString1, int paramInt, String paramString2)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("QzonePersonalizeJsPlugin", 1, "callback is null");
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    if (Build.VERSION.SDK_INT < 11) {}
    for (int i = 1;; i = 0)
    {
      if (Build.VERSION.SDK_INT > 20) {
        j = 1;
      }
      try
      {
        localJSONObject.put("ret", paramInt);
        localJSONObject.put("msg", paramString2);
        localJSONObject.put("noZip", i);
        localJSONObject.put("noCrossDomain", j);
        paramString2 = localJSONObject.toString();
        this.f.mRuntime.getWebView().callJs(paramString1, new String[] { paramString2 });
        return;
      }
      catch (JSONException paramString1)
      {
        QLog.e("QzonePersonalizeJsPlugin", 1, paramString1.getMessage());
        return;
      }
    }
  }
  
  private void am(String[] paramArrayOfString)
  {
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]);
      Intent localIntent = new Intent("action_personalize_js2qzone");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "setFriendNaviDeco");
      localBundle.putInt("itemId", paramArrayOfString.getInt("itemid"));
      localBundle.putString("friendNaviDecoUrl", paramArrayOfString.optString("friendnavidecoresurl", ""));
      localBundle.putString("textColor", paramArrayOfString.optString("fontcolor", ""));
      localIntent.putExtras(localBundle);
      avpw.a(this.f.mRuntime.getActivity(), avpw.d.a(), localIntent);
      return;
    }
    catch (Exception paramArrayOfString)
    {
      QLog.w("QzonePersonalizeJsPlugin", 1, "handleFriendNaviDeco  ", paramArrayOfString);
    }
  }
  
  private void an(String[] paramArrayOfString)
  {
    try
    {
      Object localObject = new JSONObject(paramArrayOfString[0]);
      int i = ((JSONObject)localObject).getInt("itemId");
      paramArrayOfString = ((JSONObject)localObject).getString("itemUrl");
      localObject = ((JSONObject)localObject).getString("itemText");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "setResponsiveLike");
      localBundle.putInt("itemId", i);
      localBundle.putString("itemUrl", paramArrayOfString);
      localBundle.putString("itemText", (String)localObject);
      avzf.a().a("cmd.setResponsiveLike", localBundle, false);
      return;
    }
    catch (Exception paramArrayOfString)
    {
      QLog.w("QzonePersonalizeJsPlugin", 1, "handleHighFive  ", paramArrayOfString);
    }
  }
  
  private void ao(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length == 1)) {}
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).optString("data");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "setDiyHomePage");
      localBundle.putString("layoutJson", paramArrayOfString);
      avzf.a().a("cmd.setDIYData", localBundle, false);
      return;
    }
    catch (Exception paramArrayOfString)
    {
      QLog.w("QzonePersonalizeJsPlugin", 1, "handleDIYData  ", paramArrayOfString);
    }
  }
  
  private void ap(String[] paramArrayOfString)
  {
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]);
      Bundle localBundle = new Bundle();
      localBundle.putInt("itemId", paramArrayOfString.getInt("itemid"));
      QLog.i("QzonePersonalizeJsPlugin", 1, "handleCustomTrack  h5set ");
      avzf.a().a("cmd.setCustomTrack", localBundle, false);
      return;
    }
    catch (Exception paramArrayOfString)
    {
      QLog.e("QzonePersonalizeJsPlugin", 1, "handleCustomTrack  ", paramArrayOfString);
    }
  }
  
  private void aq(String[] paramArrayOfString)
  {
    try
    {
      Object localObject = new JSONObject(paramArrayOfString[0]);
      paramArrayOfString = new Bundle();
      localObject = ((JSONObject)localObject).getJSONObject("param");
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).getString("orderid");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramArrayOfString.putString("orderid", (String)localObject);
          if (QLog.isColorLevel()) {
            QLog.i("QzonePersonalizeJsPlugin", 1, "handleReserveAdvertise  h5set +" + (String)localObject);
          }
          avzf.a().a("cmd.reserveAdvertise", paramArrayOfString, false);
          return;
        }
        QLog.e("QzonePersonalizeJsPlugin", 1, "@orderAdv orderid  is null  ");
        return;
      }
    }
    catch (Exception paramArrayOfString)
    {
      QLog.e("QzonePersonalizeJsPlugin", 1, new Object[] { "@orderAdv handleReserveAdvertise  ", paramArrayOfString.toString() });
      return;
    }
    QLog.e("QzonePersonalizeJsPlugin", 1, "@orderAdv orderid  is null  ");
  }
  
  private void eDx()
  {
    QLog.i("QzonePersonalizeJsPlugin", 1, "tiantai handleNotifyWebviewJsReady");
    try
    {
      if ((this.f == null) || (this.f.mRuntime == null)) {
        break label184;
      }
      CustomWebView localCustomWebView = this.f.mRuntime.getWebView();
      if (localCustomWebView == null)
      {
        QZLog.w("QzonePersonalizeJsPlugin", "tiantai webView == null");
        return;
      }
      localCustomWebView.setTag(2131376500, Boolean.TRUE);
      QLog.i("QzonePersonalizeJsPlugin", 1, "tiantai webview activity name: " + this.f.mRuntime.getActivity().getClass().getSimpleName());
      if (!(this.f.mRuntime.getActivity() instanceof QzoneTiantaiTranslucentBrowserActivity))
      {
        QZLog.i("QzonePersonalizeJsPlugin", "tiantai 非定制webview直接返回");
        g(localCustomWebView);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.w("QzonePersonalizeJsPlugin", 1, "tiantai handleNotifyWebviewJsReady: ", localException);
      return;
    }
    Object localObject2 = localException.getTag(2131376497);
    if ((localObject2 != null) && (((Boolean)localObject2).booleanValue())) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        QZLog.i("QzonePersonalizeJsPlugin", "tiantai video not finish");
        return;
      }
      g(localException);
      return;
      label184:
      Object localObject1 = null;
      break;
    }
  }
  
  public static void g(CustomWebView paramCustomWebView)
  {
    try
    {
      QZLog.i("QzonePersonalizeJsPlugin", "tiantai notifyWebviewStartAnimation");
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("action", "startAnimation");
      JSONObject localJSONObject2 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put("*.qzone.qq.com");
      localJSONObject2.put("echo", true);
      localJSONObject2.put("broadcast", true);
      localJSONObject2.put("domains", localJSONArray);
      a(paramCustomWebView, "qzRooftop", localJSONObject1, localJSONObject2);
      paramCustomWebView.setTag(2131376497, Boolean.FALSE);
      paramCustomWebView.setTag(2131376500, Boolean.FALSE);
      return;
    }
    catch (Exception paramCustomWebView)
    {
      QLog.w("QzonePersonalizeJsPlugin", 1, "tiantai notifyWebviewStartAnimation: ", paramCustomWebView);
    }
  }
  
  private static void r(WebViewPlugin.a parama, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      return;
    }
    try
    {
      int i = new JSONObject(paramVarArgs[0]).getInt("timestamp");
      if (QLog.isColorLevel()) {
        QLog.d("QZoneWebViewPlugin", 2, "handleUpdateMallClicktime: " + i);
      }
      awhl.a(Integer.valueOf(i), Long.valueOf(parama.a().getLongAccountUin()));
      return;
    }
    catch (JSONException parama)
    {
      parama.printStackTrace();
    }
  }
  
  private static void s(WebViewPlugin.a parama, String... paramVarArgs)
  {
    int j = 0;
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      return;
    }
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("QZoneWebViewPlugin", 2, "handleUpdateMallID");
        }
        localObject = new JSONObject(paramVarArgs[0]).getJSONArray("id");
        if ((localObject == null) || (((JSONArray)localObject).length() <= 0)) {
          break;
        }
        paramVarArgs = new int[((JSONArray)localObject).length()];
        i = 0;
        if (i < ((JSONArray)localObject).length())
        {
          paramVarArgs[i] = ((JSONArray)localObject).getInt(i);
          i += 1;
          continue;
        }
        if (paramVarArgs.length <= 0) {
          break;
        }
        new HashMap();
        localObject = awhl.b(Long.valueOf(parama.a().getLongAccountUin()));
        i = j;
        if (i < paramVarArgs.length)
        {
          if (((Map)localObject).containsKey(Integer.valueOf(paramVarArgs[i]))) {
            break label191;
          }
          ((Map)localObject).put(Integer.valueOf(paramVarArgs[i]), Long.valueOf(0L));
        }
      }
      catch (JSONException parama)
      {
        parama.printStackTrace();
        return;
      }
      awhl.b((Map)localObject, Long.valueOf(parama.a().getLongAccountUin()));
      return;
      label191:
      i += 1;
    }
  }
  
  private static void t(WebViewPlugin.a parama, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      return;
    }
    try
    {
      paramVarArgs = new JSONObject(paramVarArgs[0]);
      int i = paramVarArgs.getInt("CustomVipId");
      paramVarArgs = paramVarArgs.getString("zipUrl");
      Intent localIntent = new Intent("action_personalize_js2qzone");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "Custom_Vip_Setting");
      localBundle.putInt("CustomVipId", i);
      localBundle.putString("zipUrl", paramVarArgs);
      localIntent.putExtras(localBundle);
      avpw.a(parama.getActivity(), avpw.d.a(), localIntent);
      return;
    }
    catch (JSONException parama)
    {
      parama.printStackTrace();
    }
  }
  
  private static void u(WebViewPlugin.a parama, String... paramVarArgs)
  {
    int i = 0;
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
          if ((paramVarArgs != null) && (paramVarArgs.length() > 0))
          {
            if ((((JSONObject)localObject).has("toast")) && (((JSONObject)localObject).getBoolean("toast"))) {
              QQToast.a(parama.getActivity(), 2, 2131689674, 0).show();
            }
            localObject = new long[paramVarArgs.length()];
            while (i < paramVarArgs.length())
            {
              localObject[i] = paramVarArgs.getLong(i);
              i += 1;
            }
            paramVarArgs = new Intent();
            paramVarArgs.putExtra("key_msg_type", 2);
            paramVarArgs.putExtra("key_friend_list", (long[])localObject);
            parama.getActivity().setResult(-1, paramVarArgs);
            parama.getActivity().finish();
            return;
          }
        }
      }
      catch (JSONException parama)
      {
        parama.printStackTrace();
      }
    }
  }
  
  private void v(WebViewPlugin.a parama, String... paramVarArgs)
  {
    Intent localIntent = new Intent("action_personalize_js2qzone");
    Bundle localBundle = new Bundle();
    localBundle.putString("cmd", "SetFacade");
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
    try
    {
      localBundle.putInt("showonfridyn", new JSONObject(paramVarArgs[0]).getInt("showonfridyn"));
      localIntent.putExtras(localBundle);
      avpw.a(parama.getActivity(), avpw.d.a(), localIntent);
      return;
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        paramVarArgs.printStackTrace();
      }
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((!paramString2.equals("Qzone")) || (this.f == null) || (this.f.mRuntime == null)) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          if (awen.tQ(paramString3))
          {
            LocalMultiProcConfig.putBool("qzone_force_refresh", true);
            LocalMultiProcConfig.putBool("qzone_force_refresh_passive", true);
          }
          if ("UpdateMallTimestamp".equalsIgnoreCase(paramString3))
          {
            r(this.f.mRuntime, paramVarArgs);
            return true;
          }
          if ("UpdateMallid".equalsIgnoreCase(paramString3))
          {
            s(this.f.mRuntime, paramVarArgs);
            return true;
          }
          if ("Personalize".equalsIgnoreCase(paramString3))
          {
            u(this.f.mRuntime, paramVarArgs);
            return true;
          }
          if ("SetFacade".equalsIgnoreCase(paramString3))
          {
            v(this.f.mRuntime, paramVarArgs);
            return true;
          }
          if (paramString3.equals("CleanZebraNum"))
          {
            awhp.D(this.f.mRuntime, paramVarArgs);
            return true;
          }
          if (paramString3.equals("SetPersonalizeFinished"))
          {
            awhm.C(this.f.mRuntime, paramVarArgs);
            return true;
          }
          if (paramString3.equals("openNameplateSucc"))
          {
            awhj.x(this.f.mRuntime, paramVarArgs);
            return true;
          }
          if ("downLoadFont".equalsIgnoreCase(paramString3))
          {
            ae(paramVarArgs);
            return true;
          }
          if ("OpenCustomVipSucc".equals(paramString3))
          {
            t(this.f.mRuntime, paramVarArgs);
            return true;
          }
          if ("setDefaultFont".equals(paramString3))
          {
            af(paramVarArgs);
            return true;
          }
          if ("getDefaultFont".equals(paramString3))
          {
            ai(paramVarArgs);
            return true;
          }
          if ("SetPlayerDeco".equals(paramString3))
          {
            aj(paramVarArgs);
            return true;
          }
          if ("qzRooftopPageReady".equals(paramString3))
          {
            eDx();
            return true;
          }
          if ("OpenUrl".equals(paramString3))
          {
            ak(paramVarArgs);
            return true;
          }
          if ("RefreshDeco".equals(paramString3))
          {
            avzf.a().a("cmd.refeshDecoCustom", null, false);
            return true;
          }
          if (!"GiftPlayAnimation".equals(paramString3)) {
            break;
          }
          bool1 = bool2;
        } while (paramVarArgs == null);
        bool1 = bool2;
      } while (paramVarArgs.length != 1);
      bool1 = bool2;
    } while (TextUtils.isEmpty(paramVarArgs[0]));
    alsg.a().fJ(paramVarArgs[0]);
    return true;
    if ("GetRedpocket".equals(paramString3))
    {
      al(paramVarArgs);
      return true;
    }
    if ("setFriendNaviDeco".equals(paramString3))
    {
      am(paramVarArgs);
      return true;
    }
    if ("setResponsiveLike".equals(paramString3))
    {
      an(paramVarArgs);
      return true;
    }
    if ("setDiyHomePage".equals(paramString3))
    {
      ao(paramVarArgs);
      return true;
    }
    if ("setCustomTrack".equals(paramString3))
    {
      ap(paramVarArgs);
      return true;
    }
    if ("reserveAdvertise".equals(paramString3))
    {
      aq(paramVarArgs);
      return true;
    }
    return false;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    alsg.a().onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awfv
 * JD-Core Version:    0.7.0.1
 */