package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class IndividuationPlugin
  extends VasWebviewJsPlugin
{
  public static final String BusinessName = "individuation";
  public static final String Business_Activity = "0";
  public static final String Business_Bubble = "200";
  public static final String Business_ChagBg = "500";
  public static final String Business_Emoji = "100";
  public static final String Business_Emoji_Detail = "101";
  public static final String Business_Font = "300";
  public static final String Business_Theme = "600";
  public static final String Method_GetFontType = "getFontType";
  public static final String Method_OpenPage = "openPage";
  public static final int RequestCode_ThemeMall = 0;
  public static final byte Start_Activity_Request_Code_ChatBg = 1;
  public static final String Tag = "IndividuationPlugin";
  protected Activity mActivity;
  private BrowserAppInterface mBrowserApp;
  
  protected void getFontType(JSONObject paramJSONObject, String paramString) {}
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IndividuationPlugin", 2, "handleJsRequest, url=" + paramString1 + ",pkgName=" + paramString2 + ",method=" + paramString3);
    }
    if ((paramString1 == null) || (!"individuation".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    int i;
    try
    {
      i = paramString1.indexOf("=");
      if ((i == -1) || (i + 1 > paramString1.length() - 1)) {
        throw new Exception("Invalid Url Parameters");
      }
    }
    catch (Exception paramJsBridgeListener)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IndividuationPlugin", 2, paramJsBridgeListener.getMessage());
      }
    }
    for (;;)
    {
      return true;
      paramJsBridgeListener = new JSONObject(URLDecoder.decode(paramString1.substring(i + 1), "UTF-8"));
      paramString2 = paramJsBridgeListener.getString("callback");
      if (paramString2 == null) {
        throw new Exception("Need callbackId");
      }
      if ("openPage".equals(paramString3)) {
        openPage(paramJsBridgeListener, paramString2);
      } else if ("getFontType".equals(paramString3)) {
        getFontType(paramJsBridgeListener, paramString2);
      } else if (QLog.isColorLevel()) {
        QLog.d("IndividuationPlugin", 2, "No such method: " + paramString3 + ", url=" + paramString1);
      }
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.mActivity = this.mRuntime.a();
    this.mBrowserApp = ((BrowserAppInterface)this.mRuntime.a());
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    int i;
    String str;
    Bundle localBundle;
    Object localObject;
    do
    {
      return;
      i = paramBundle.getInt("respkey", 0);
      str = paramBundle.getString("cmd");
      localBundle = paramBundle.getBundle("request");
      localObject = paramBundle.getBundle("response");
    } while ((localObject == null) || (i != this.mOnRemoteResp.key) || (str == null));
    if ("openEmojiMall".equals(str))
    {
      paramBundle = ((Bundle)localObject).getString("curChatUin");
      i = ((Bundle)localObject).getInt("curChatType", 0);
      EmojiHomeUiPlugin.openEmojiHomePage2(this.mActivity, this.mBrowserApp.a(), 3, this.mBrowserApp.getSid(), paramBundle, i);
      return;
    }
    if ("openEmojiDetail".equals(str))
    {
      paramBundle = ((Bundle)localObject).getString("curChatUin");
      i = ((Bundle)localObject).getInt("curChatType", 0);
      localObject = localBundle.getString("pkgId");
      boolean bool = localBundle.getBoolean("isQFace");
      EmojiHomeUiPlugin.openEmojiDetailPage2(this.mActivity, this.mBrowserApp.a(), 4, (String)localObject, this.mBrowserApp.getSid(), Boolean.valueOf(bool).booleanValue(), i, paramBundle);
      return;
    }
    if ("openFontSetting".equals(str))
    {
      if (((Bundle)localObject).getBoolean("feature"))
      {
        paramBundle = new Intent(this.mActivity, QQBrowserActivity.class);
        paramBundle.putExtra("hide_left_button", false);
        paramBundle.putExtra("show_right_close_button", false);
        paramBundle.putExtra("startOpenPageTime", System.currentTimeMillis());
        VasWebviewUtil.a(this.mActivity, VasWebviewConstants.CHAT_FONT_MARKET_HOME_URL, 4096L, paramBundle, false, -1);
        return;
      }
      paramBundle = new Intent(this.mActivity, ChatTextSizeSettingActivity.class);
      this.mActivity.startActivity(paramBundle);
      return;
    }
    super.onResponse(paramBundle);
  }
  
  protected void openPage(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      localObject = paramJSONObject.getString("business");
      if (QLog.isColorLevel()) {
        QLog.i("IndividuationPlugin", 2, "openPage, business=" + (String)localObject);
      }
      if ("600".equals(localObject))
      {
        if (!BaseApplicationImpl.a)
        {
          Toast.makeText(this.mActivity, this.mActivity.getString(2131363274), 0).show();
          return;
        }
        if (!Utils.e())
        {
          Toast.makeText(this.mActivity, this.mActivity.getString(2131363522), 0).show();
          return;
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        QLog.d("IndividuationPlugin", 2, paramJSONObject.getMessage());
        return;
        paramJSONObject = new Intent(this.mActivity, QQBrowserActivity.class);
        paramJSONObject.putExtra("updateFlag", false);
        VasWebviewUtil.a(this.mActivity, "http://imgcache.qq.com/club/themes/mobile/theme/html/index.html?uin=[uin]&client=[client]&version=[version]&sid=[sid]&platformId=[platformId]&device=[device]&system=[system]&density=[density]&updateId=[updateId]&adTag=mvip.gongneng.android.theme.index_dynamic_tab&updateFlag=[updateFlag]&_bid=123&_wv=1027", 32L, paramJSONObject, true, 0);
        return;
        if ("500".equals(localObject))
        {
          paramJSONObject = new Intent(this.mActivity, ChatBackgroundSettingActivity.class);
          paramJSONObject.putExtra("bg_replace_entrance", 8);
          paramJSONObject.putExtra("selfSet_leftViewText", this.mActivity.getString(2131363123));
          super.startActivityForResult(paramJSONObject, (byte)1);
          return;
        }
        if ("200".equals(localObject))
        {
          paramJSONObject = new Intent(this.mActivity, QQBrowserActivity.class);
          paramJSONObject.putExtra("updateFlag", false);
          VasWebviewUtil.a(this.mActivity, "http://imgcache.qq.com/club/themes/mobile/bubble/html/index.html?uin=[uin]&client=[client]&version=[version]&sid=[sid]&platformId=[platformId]&device=[device]&system=[system]&updateTime=[updateTime]&updateFlag=[updateFlag]&updateId=[updateId]&adTag=mvip.gongneng.android.bubble.index_dynamic_tab&_bid=122&_wv=1027", 64L, paramJSONObject, false, -1);
          return;
        }
        if ("100".equals(localObject))
        {
          paramJSONObject = new Bundle();
          super.sendRemoteReq(DataFactory.makeIPCRequestPacket("openEmojiMall", paramString, this.mOnRemoteResp.key, paramJSONObject), true, true);
          return;
        }
        if ("101".equals(localObject))
        {
          paramJSONObject = paramJSONObject.getString("detailId");
          localObject = new Bundle();
          ((Bundle)localObject).putString("pkgId", paramJSONObject);
          ((Bundle)localObject).putBoolean("isQFace", Boolean.valueOf(false).booleanValue());
          super.sendRemoteReq(DataFactory.makeIPCRequestPacket("openEmojiDetail", paramString, this.mOnRemoteResp.key, (Bundle)localObject), true, true);
          return;
        }
        if ("300".equals(localObject))
        {
          paramJSONObject = new Bundle();
          sendRemoteReq(DataFactory.makeIPCRequestPacket("openFontSetting", paramString, this.mOnRemoteResp.key, paramJSONObject), true, true);
          return;
        }
        if ("0".equals(localObject))
        {
          paramString = new Intent(this.mActivity, QQBrowserActivity.class);
          paramString.putExtra("url", URLDecoder.decode(paramJSONObject.getString("detailId"), "UTF-8").replace("{uin}", this.mBrowserApp.a()).replace("{client}", "androidQQ").replace("{version}", "3.5.0.660").replace("{platformId}", "2").replace("{device}", Build.DEVICE).replace("{system}", Build.VERSION.RELEASE).replace("{systemInt}", Integer.toString(Build.VERSION.SDK_INT)).replace("{adtag}", "mvip.gongneng.anroid.individuation.web").replace("{updateFlag}", "false").replace("{density}", ThemeUtil.getThemeDensity(this.mBrowserApp.getApplication().getApplicationContext())));
          this.mActivity.startActivity(paramString);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("IndividuationPlugin", 2, "Unknown business: " + (String)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin
 * JD-Core Version:    0.7.0.1
 */