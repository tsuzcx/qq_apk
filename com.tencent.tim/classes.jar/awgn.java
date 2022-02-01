import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QzoneHardwareRestriction;
import org.json.JSONException;
import org.json.JSONObject;

public class awgn
  extends awfr
{
  private static boolean NQ;
  private static boolean NR;
  private SharedPreferences sp = BaseApplicationImpl.sApplication.getSharedPreferences("qzone_detail_sp", 4);
  
  private boolean a(JsBridgeListener paramJsBridgeListener, WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramJsBridgeListener = paramWebViewPlugin.mRuntime.getActivity();
    } while ((paramJsBridgeListener == null) || (paramJsBridgeListener.isFinishing()));
    try
    {
      JSONObject localJSONObject = new JSONObject(paramArrayOfString[0]);
      int i = localJSONObject.optInt("iconID");
      paramJsBridgeListener = localJSONObject.optString("title");
      paramArrayOfString = localJSONObject.optString("callback");
      boolean bool = localJSONObject.optBoolean("hidden");
      localJSONObject.optBoolean("disable");
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a(paramWebViewPlugin.mRuntime.getActivity());
      if ((paramWebViewPlugin != null) && ((paramWebViewPlugin instanceof ardm.n))) {
        ((ardm.n)paramWebViewPlugin).a(paramArrayOfString, paramJsBridgeListener, null, bool, i + 1000, 0, null, null);
      }
    }
    catch (JSONException paramJsBridgeListener)
    {
      label133:
      break label133;
    }
    return true;
  }
  
  private boolean a(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      localObject = paramWebViewPlugin.mRuntime.getActivity();
    } while ((localObject == null) || (((Activity)localObject).isFinishing()));
    Object localObject = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      boolean bool = LocalMultiProcConfig.getBool("qzone_feed_custom_browser_deco_switch", true);
      if (bool) {
        i = 1;
      }
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({enable:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "---customBrowserInfoSwitch-:" + bool);
      return true;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = (String[])localObject;
      }
    }
  }
  
  private void acp(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramInt = -1;
    }
    for (;;)
    {
      if (paramInt != -1) {
        LpReportInfo_pf00064.allReport(593, 2, paramInt);
      }
      return;
      paramInt = 8;
      continue;
      paramInt = 7;
      continue;
      paramInt = 9;
    }
  }
  
  private void b(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    boolean bool = true;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.getActivity();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramArrayOfString[0]).getInt("new_value");
        if (i == 0) {
          continue;
        }
      }
      catch (JSONException paramWebViewPlugin)
      {
        QZLog.w("QzoneSettingJsPlugin", 4, new Object[] { "handleSetInteractSoundMode: json error " + paramArrayOfString[0], paramWebViewPlugin });
        continue;
      }
      QLog.i("QzoneSettingJsPlugin", 4, "handleSetInteractSoundMode: " + bool);
      this.sp.edit().putBoolean("qzone_sound_effect_enabled", bool).apply();
      return;
      bool = false;
    }
  }
  
  private boolean b(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.getActivity();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramArrayOfString[0]).getInt("enable");
        if (i != 0) {
          continue;
        }
      }
      catch (JSONException paramWebViewPlugin)
      {
        paramWebViewPlugin.printStackTrace();
        bool = true;
        continue;
      }
      avzf.a().a().O(bool);
      QLog.i("QzoneSettingJsPlugin", 4, "---notifyCustomBrowserChanged-:" + bool);
      return true;
      bool = true;
    }
  }
  
  private void c(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    i = 1;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      Object localObject;
      do
      {
        return;
        localObject = paramWebViewPlugin.mRuntime.getActivity();
      } while ((localObject == null) || (((Activity)localObject).isFinishing()));
      try
      {
        localObject = new JSONObject(paramArrayOfString[0]).getString("callback");
        paramArrayOfString = (String[])localObject;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          boolean bool;
          QZLog.w("QzoneSettingJsPlugin", 4, new Object[] { "handleGetInteractSoundMode: json error " + paramArrayOfString[0], localJSONException });
          paramArrayOfString = null;
          continue;
          i = 0;
        }
      }
    } while (paramArrayOfString == null);
    bool = this.sp.getBoolean("qzone_sound_effect_enabled", false);
    if (bool)
    {
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({new_value:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "handleGetInteractSoundMode: " + bool);
      return;
    }
  }
  
  private boolean c(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      localObject = paramWebViewPlugin.mRuntime.getActivity();
    } while ((localObject == null) || (((Activity)localObject).isFinishing()));
    Object localObject = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      boolean bool = LocalMultiProcConfig.getBool("qzone_barrage_effect_enabled", true);
      if (bool) {
        i = 1;
      }
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({new_value:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "---handleShowCommentBubbleGet-:" + bool);
      return true;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = (String[])localObject;
      }
    }
  }
  
  private void d(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = paramWebViewPlugin.mRuntime.getActivity();
    } while ((localActivity == null) || (localActivity.isFinishing()));
    try
    {
      int i = new JSONObject(paramArrayOfString[0]).getInt("value");
      if (i != 0) {
        bool = true;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        long l;
        QZLog.w("QzoneSettingJsPlugin", 4, new Object[] { "handleSetWaterMark: json error " + paramArrayOfString[0], localJSONException });
        bool = true;
      }
    }
    l = paramWebViewPlugin.mRuntime.a().getLongAccountUin();
    QLog.i("QzoneSettingJsPlugin", 1, "handleSetWaterMark: " + bool + " uin:" + l);
    LocalMultiProcConfig.putBool("Qzone_multi_setting", "WaterMark_" + l, bool);
    LocalMultiProcConfig.putBool("QZ_setting", "WaterMark_" + l, bool);
  }
  
  private boolean d(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.getActivity();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramArrayOfString[0]).getInt("new_value");
        if (i != 0) {
          continue;
        }
      }
      catch (JSONException paramWebViewPlugin)
      {
        paramWebViewPlugin.printStackTrace();
        bool = true;
        continue;
      }
      avzf.a().a().N(bool);
      QLog.i("QzoneSettingJsPlugin", 4, "---handleShowCommentBubbleSetting-:" + bool);
      return true;
      bool = true;
    }
  }
  
  private void e(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      do
      {
        return;
        localActivity = paramWebViewPlugin.mRuntime.getActivity();
      } while ((localActivity == null) || (localActivity.isFinishing()));
      Activity localActivity = null;
      try
      {
        String str = new JSONObject(paramArrayOfString[0]).getString("callback");
        paramArrayOfString = str;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          long l;
          QZLog.w("QzoneSettingJsPlugin", 4, new Object[] { "handleGetWaterMark: json error " + paramArrayOfString[0], localJSONException });
          paramArrayOfString = localActivity;
          continue;
          boolean bool = LocalMultiProcConfig.getBool("QZ_setting", "WaterMark_" + l, false);
        }
      }
    } while (paramArrayOfString == null);
    l = paramWebViewPlugin.mRuntime.a().getLongAccountUin();
    if (LocalMultiProcConfig.containKey("Qzone_multi_setting", "WaterMark_" + l))
    {
      bool = LocalMultiProcConfig.getBool("Qzone_multi_setting", "WaterMark_" + l, false);
      QLog.i("QzoneSettingJsPlugin", 1, "use new key");
      if (bool) {
        i = 1;
      }
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({value:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 1, "handleGetWaterMark: " + bool + " uin:" + l);
      return;
    }
  }
  
  private boolean e(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    boolean bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    Activity localActivity;
    do
    {
      return false;
      localActivity = paramWebViewPlugin.mRuntime.getActivity();
    } while ((localActivity == null) || (localActivity.isFinishing()));
    long l = paramWebViewPlugin.mRuntime.a().getLongAccountUin();
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramArrayOfString[0]).getInt("new_value");
        if (i != 0) {
          continue;
        }
      }
      catch (JSONException paramWebViewPlugin)
      {
        paramWebViewPlugin.printStackTrace();
        continue;
      }
      QLog.i("QzoneSettingJsPlugin", 4, "---handleShowQzoneRemindfeedSetting-:" + bool);
      LocalMultiProcConfig.putBooleanAsync(localActivity.getString(2131718976) + l, bool);
      return true;
      bool = true;
    }
  }
  
  private boolean f(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    Activity localActivity;
    do
    {
      return false;
      localActivity = paramWebViewPlugin.mRuntime.getActivity();
    } while ((localActivity == null) || (localActivity.isFinishing()));
    long l = paramWebViewPlugin.mRuntime.a().getLongAccountUin();
    paramWebViewPlugin = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      paramWebViewPlugin = paramArrayOfString;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        boolean bool;
        paramArrayOfString.printStackTrace();
      }
    }
    bool = LocalMultiProcConfig.getBool(localActivity.getString(2131718976) + l, true);
    if (bool) {
      i = 1;
    }
    paramWebViewPlugin = "window." + paramWebViewPlugin + "({new_value:" + i + "})";
    this.f.callJs(paramWebViewPlugin);
    QLog.i("QzoneSettingJsPlugin", 4, "---handleShowQzoneRemindfeedGet-:" + bool);
    return true;
  }
  
  private boolean g(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.getActivity();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    try
    {
      int j = new JSONObject(paramArrayOfString[0]).getInt("new_value");
      i = j;
      acp(j);
      i = j;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
      }
    }
    QLog.i("QzoneSettingJsPlugin", 4, "---handleVideoPlayModeSetting-:" + i);
    LocalMultiProcConfig.putInt("QZ_setting", "Qzone_playMode", i);
    paramWebViewPlugin.sendBroadcast(new Intent("com.tencent.qq.VideoPlaySetting"));
    return true;
  }
  
  private boolean h(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return false;
    }
    Object localObject = paramWebViewPlugin.mRuntime.getActivity();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {
      return false;
    }
    localObject = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      if (!LocalMultiProcConfig.getBool("QZ_setting", "Qzone_setVideoplay", true))
      {
        i = 2;
        LocalMultiProcConfig.putBool("QZ_setting", "Qzone_setVideoplay", true);
        paramWebViewPlugin.callJs("window." + paramArrayOfString + "({new_value:" + i + "})");
        QLog.i("QzoneSettingJsPlugin", 4, "---handleVideoPlayModeGet-:" + i);
        return true;
      }
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = (String[])localObject;
        continue;
        int i = LocalMultiProcConfig.getInt("QZ_setting", "Qzone_playMode", 0);
      }
    }
  }
  
  @Deprecated
  private boolean i(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.getActivity();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramArrayOfString[0]).getInt("new_value");
        if (i != 0) {
          continue;
        }
      }
      catch (JSONException paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
        bool = true;
        continue;
      }
      QLog.i("QzoneSettingJsPlugin", 4, "---handleGifPlayModeSetting-:" + bool);
      LocalMultiProcConfig.putBool("QZ_setting", "Qzone_playMode", bool);
      paramWebViewPlugin.sendBroadcast(new Intent("com.tencent.qq.GifPlaySetting"));
      return true;
      bool = true;
    }
  }
  
  private boolean j(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      localObject = paramWebViewPlugin.mRuntime.getActivity();
    } while ((localObject == null) || (((Activity)localObject).isFinishing()));
    Object localObject = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      boolean bool = LocalMultiProcConfig.getBool("QZ_setting", "Qzone_playMode", true);
      if (bool) {
        i = 1;
      }
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({new_value:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "---handleGifPlayModeGet-:" + bool);
      return true;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = (String[])localObject;
      }
    }
  }
  
  private boolean k(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.getActivity();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    try
    {
      int j = new JSONObject(paramArrayOfString[0]).getInt("new_value");
      i = j;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
      }
    }
    paramWebViewPlugin.sendBroadcast(new Intent("com.tencent.qq.syncNoPhotoSetting"));
    QLog.i("QzoneSettingJsPlugin", 4, "---handlePictureModeSetting-:" + i);
    LocalMultiProcConfig.putInt(paramWebViewPlugin.getResources().getString(2131718989), i);
    return true;
  }
  
  private boolean l(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return false;
    }
    Activity localActivity = paramWebViewPlugin.mRuntime.getActivity();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return false;
    }
    String str = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      int i = LocalMultiProcConfig.getInt(localActivity.getResources().getString(2131718989), 0);
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({new_value:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "---handlePictureModeGet-:" + i);
      return true;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = str;
      }
    }
  }
  
  private boolean m(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.getActivity();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramArrayOfString[0]).getInt("new_value");
        if (i != 0) {
          continue;
        }
      }
      catch (JSONException paramWebViewPlugin)
      {
        paramWebViewPlugin.printStackTrace();
        bool = true;
        continue;
      }
      avzf.a().a().M(bool);
      QLog.i("QzoneSettingJsPlugin", 4, "---handleShowFontSetting-:" + bool);
      return true;
      bool = true;
    }
  }
  
  private boolean n(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      localObject = paramWebViewPlugin.mRuntime.getActivity();
    } while ((localObject == null) || (((Activity)localObject).isFinishing()));
    Object localObject = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      boolean bool = LocalMultiProcConfig.getBool("qzone_font_enabled", true);
      if (bool) {
        i = 1;
      }
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({new_value:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "---handleShowFontGet-:" + bool);
      return true;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = (String[])localObject;
      }
    }
  }
  
  private boolean o(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.getActivity();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramArrayOfString[0]).getInt("new_value");
        if (i != 0) {
          continue;
        }
      }
      catch (JSONException paramWebViewPlugin)
      {
        paramWebViewPlugin.printStackTrace();
        bool = true;
        continue;
      }
      avzf.a().a().P(bool);
      QLog.i("QzoneSettingJsPlugin", 4, "---handleShowSparkleFontSetting-:" + bool);
      return true;
      bool = true;
    }
  }
  
  private boolean p(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      localObject = paramWebViewPlugin.mRuntime.getActivity();
    } while ((localObject == null) || (((Activity)localObject).isFinishing()));
    Object localObject = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      boolean bool = LocalMultiProcConfig.getBool("qzone_super_font_enabled", true);
      if (bool) {
        i = 1;
      }
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({new_value:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "---handleShowSparkleFontGet-:" + bool);
      return true;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = (String[])localObject;
      }
    }
  }
  
  private boolean q(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      localObject = paramWebViewPlugin.mRuntime.getActivity();
    } while ((localObject == null) || (((Activity)localObject).isFinishing()));
    Object localObject = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      if (rW()) {
        i = 1;
      }
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({enable:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "---handleIsSupportParticleEffect-:" + i);
      return true;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = (String[])localObject;
      }
    }
  }
  
  private boolean r(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      localObject = paramWebViewPlugin.mRuntime.getActivity();
    } while ((localObject == null) || (((Activity)localObject).isFinishing()));
    Object localObject = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      boolean bool = LocalMultiProcConfig.getBool("qzone_passive_praise_enabled", true);
      if (bool) {
        i = 1;
      }
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({isOpen:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "---handlePassivePraiseGet-:" + bool);
      return true;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = (String[])localObject;
      }
    }
  }
  
  public static boolean rW()
  {
    if (!NQ)
    {
      NR = QzoneHardwareRestriction.meetHardwareRestriction(1, 1);
      NQ = true;
    }
    return NR;
  }
  
  private boolean s(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.getActivity();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramArrayOfString[0]).getInt("value");
        if (i != 0) {
          continue;
        }
      }
      catch (JSONException paramWebViewPlugin)
      {
        paramWebViewPlugin.printStackTrace();
        bool = true;
        continue;
      }
      LocalMultiProcConfig.putBool("qzone_passive_praise_enabled", bool);
      QLog.i("QzoneSettingJsPlugin", 4, "---handleShowSparkleFontSetting-:" + bool);
      return true;
      bool = true;
    }
  }
  
  private boolean t(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.getActivity();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramArrayOfString[0]).getInt("value");
        if (i != 0) {
          continue;
        }
      }
      catch (JSONException paramWebViewPlugin)
      {
        paramWebViewPlugin.printStackTrace();
        bool = true;
        continue;
      }
      LocalMultiProcConfig.putBool("qzone_feed_skin_enable", bool);
      avzf.a().a().PV();
      QLog.i("QzoneSettingJsPlugin", 4, "---handlefeedSkinEnable-:" + bool);
      return true;
      bool = true;
    }
  }
  
  private boolean u(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      localObject = paramWebViewPlugin.mRuntime.getActivity();
    } while ((localObject == null) || (((Activity)localObject).isFinishing()));
    Object localObject = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      boolean bool = LocalMultiProcConfig.getBool("qzone_feed_skin_enable", true);
      if (bool) {
        i = 1;
      }
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({isOpen:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "---handleFeedSkinGet-:" + bool);
      return true;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = (String[])localObject;
      }
    }
  }
  
  private boolean v(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.getActivity();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    avzf.a().a().gb(paramArrayOfString[0]);
    QLog.i("QzoneSettingJsPlugin", 4, "---handleUpdateCustomPraise-:" + paramArrayOfString[0]);
    return true;
  }
  
  private boolean w(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.getActivity();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    avzf.a().a().gc(paramArrayOfString[0]);
    QLog.i("QzoneSettingJsPlugin", 4, "---handleUpdatePloymorphicPraise-:" + paramArrayOfString[0]);
    return true;
  }
  
  private boolean x(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    paramWebViewPlugin = paramWebViewPlugin.mRuntime.getActivity();
    if ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing())) {
      return false;
    }
    avzf.a().a().PW();
    QLog.i("QzoneSettingJsPlugin", 4, "---handleUpdateFontList-:");
    return true;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.f == null) || (this.f.mRuntime == null)) {
      return false;
    }
    if (paramString3.equalsIgnoreCase("setShowRemindfeed"))
    {
      e(this.f, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setVideoPlayMode"))
    {
      g(this.f, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setGifPlayMode"))
    {
      i(this.f, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setPictureMode"))
    {
      k(this.f, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setShowFont"))
    {
      m(this.f, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getPictureMode"))
    {
      l(this.f, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getShowRemindfeed"))
    {
      f(this.f, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getVideoPlayMode"))
    {
      h(this.f, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getGifPlayMode"))
    {
      j(this.f, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getShowFont"))
    {
      n(this.f, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setShowSparkleFont"))
    {
      o(this.f, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getShowSparkleFont"))
    {
      p(this.f, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setShowCommentBubble"))
    {
      d(this.f, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getShowCommentBubble"))
    {
      c(this.f, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setPassivePraiseSwitch"))
    {
      s(this.f, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getPassivePraiseSwitch"))
    {
      r(this.f, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("isSupportParticleEffect"))
    {
      q(this.f, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("updateCustomPraise"))
    {
      v(this.f, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setRightButton"))
    {
      a(paramJsBridgeListener, this.f, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setFeedSkinSwitch"))
    {
      t(this.f, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getFeedSkinSwitch"))
    {
      u(this.f, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("updatePloymorphicPraise"))
    {
      w(this.f, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("updateFontList"))
    {
      x(this.f, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getCustomBrowseInfoSwitch"))
    {
      a(this.f, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("enableCustomBrowseInfo"))
    {
      b(this.f, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setInteractSoundMode"))
    {
      b(this.f, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getInteractSoundMode"))
    {
      c(this.f, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getWaterMark"))
    {
      e(this.f, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setWaterMark"))
    {
      d(this.f, paramVarArgs);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awgn
 * JD-Core Version:    0.7.0.1
 */