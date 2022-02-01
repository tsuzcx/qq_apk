import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ShowReactiveActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import org.json.JSONObject;

public class aiid
  extends WebViewPlugin
{
  public aiid()
  {
    this.mPluginNameSpace = "emojiEggSetting";
  }
  
  private void g(int paramInt, String... paramVarArgs)
  {
    try
    {
      Activity localActivity = this.mRuntime.getActivity();
      paramVarArgs = new JSONObject(paramVarArgs[0]).optString("frd_uin");
      if (!TextUtils.isEmpty(paramVarArgs))
      {
        Intent localIntent = wja.a(new Intent(localActivity, SplashActivity.class), new int[] { 2 });
        localIntent.putExtra("uin", paramVarArgs);
        if (paramInt == 1) {
          localIntent.putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
        }
        for (;;)
        {
          localIntent.putExtra("uintype", 0);
          localActivity.startActivity(localIntent);
          return;
          if (paramInt == 2) {
            localIntent.putExtra("KEY_SHOULD_SHOW_PLUS_PANEL", true);
          }
        }
      }
      return;
    }
    catch (Exception paramVarArgs)
    {
      QLog.e("IntimatePlugin", 1, "gotoC2C exception e = ", paramVarArgs);
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimatePlugin", 2, String.format(Locale.getDefault(), "handleJsRequest url: %s pkgName; %s method: %s, args: %s", new Object[] { paramString1, paramString2, paramString3, paramVarArgs }));
    }
    if ("emojiEggSetting".equals(paramString2))
    {
      if (!"showVC".equals(paramString3)) {}
    }
    else
    {
      do
      {
        try
        {
          paramJsBridgeListener = this.mRuntime.getActivity();
          int i = new JSONObject(paramVarArgs[0]).optInt("entry");
          paramString1 = new Intent(paramJsBridgeListener, ShowReactiveActivity.class);
          paramString1.putExtra("entry", i);
          paramJsBridgeListener.startActivity(paramString1);
          return true;
        }
        catch (Exception paramJsBridgeListener)
        {
          QLog.e("IntimatePlugin", 1, "openConfessAIO exception e = ", paramJsBridgeListener);
          return false;
        }
        if (!"interactionScore".equals(paramString2)) {
          break;
        }
        if ("gotoChat".equals(paramString3))
        {
          g(1, paramVarArgs);
          return true;
        }
      } while (!"gotoCall".equals(paramString3));
      g(2, paramVarArgs);
      return true;
      return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
    }
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiid
 * JD-Core Version:    0.7.0.1
 */