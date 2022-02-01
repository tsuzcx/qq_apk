import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import org.json.JSONException;
import org.json.JSONObject;

class aidj
  extends BroadcastReceiver
{
  aidj(aidi paramaidi) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int i;
    JSONObject localJSONObject;
    if ((paramContext.equals(aidi.lu(this.a.pluginPackageName))) || (paramContext.equals(aidi.lx(this.a.pluginPackageName))))
    {
      i = paramIntent.getIntExtra("key_state", -1);
      aidi.a(this.a, i);
      localJSONObject = aidi.a(this.a, i);
      switch (i)
      {
      default: 
        this.a.callJs(this.a.bNb, new String[] { localJSONObject.toString() });
      }
    }
    do
    {
      for (;;)
      {
        return;
        l = paramIntent.getLongExtra("key_totalSize", 0L);
        aidi.a(this.a, "size:" + l);
        try
        {
          localJSONObject.putOpt("totalSize", Long.valueOf(l));
          localJSONObject.remove("state");
        }
        catch (JSONException paramContext)
        {
          for (;;)
          {
            paramContext.printStackTrace();
          }
        }
      }
      int j = paramIntent.getIntExtra("key_progress", 0);
      long l = paramIntent.getLongExtra("key_totalSize", 0L);
      paramIntent = this.a;
      if (i == 1) {}
      for (paramContext = "progress:STATE_DOWANLOADING:" + j;; paramContext = "progress:STATE_LOADING:" + j)
      {
        for (;;)
        {
          aidi.a(paramIntent, paramContext);
          if (i == 4)
          {
            if (j <= 90) {
              break;
            }
            aidi.a(this.a).removeCallbacksAndMessages(null);
          }
          try
          {
            localJSONObject.putOpt("totalSize", Long.valueOf(l));
            localJSONObject.putOpt("pro", Integer.valueOf(j));
          }
          catch (JSONException paramContext)
          {
            paramContext.printStackTrace();
          }
        }
        break;
      }
      aidi.a(this.a, "STATE_DOWANLODAD_COMPLETE");
      paramContext = Message.obtain();
      if (aidi.a(this.a) == 1) {}
      for (paramContext.arg1 = 40; !TextUtils.equals(aidi.a(this.a), "checkVersion"); paramContext.arg1 = 0)
      {
        aidi.b(this.a, 0);
        aidi.a(this.a).sendMessage(paramContext);
        break;
      }
      aidi.a(this.a, "STATE_DOWANLODAD_FAILED");
      break;
      aidi.a(this.a, "STATE_PRELOAD_FALIED");
      break;
      aidi.a(this.a, "STATE_LOAD_COMPLETE");
      break;
      aidi.a(this.a, "STATE_LOAD_FALIED");
      break;
      aidi.a(this.a, "STATE_LAUNCHERING");
      break;
      aidi.a(this.a, "STATE_LAUNCHER_SUCC");
      break;
      aidi.a(this.a, "STATE_LAUNCHER_FAILED");
      break;
      if (aidi.lv(this.a.pluginPackageName).equals(paramContext))
      {
        paramContext = this.a.mRuntime.getActivity();
        if ((paramContext instanceof BaseActivity))
        {
          ((BaseActivity)paramContext).doOnBackPressed();
          return;
        }
        paramContext.onBackPressed();
        return;
      }
    } while (!aidi.lw(this.a.pluginPackageName).equals(paramContext));
    aidi.c(this.a, paramIntent.getIntExtra("key_isCache", -1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aidj
 * JD-Core Version:    0.7.0.1
 */