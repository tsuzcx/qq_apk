import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.lebasearch.Utils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import org.json.JSONException;
import org.json.JSONObject;

public class jrz
  extends WebViewPlugin
{
  public acci b = new jsa(this);
  String mCallBack = null;
  skj mClient = null;
  aqju mDialog = null;
  aqju p;
  
  public jrz()
  {
    this.mPluginNameSpace = "lebaPlugin";
  }
  
  private void c(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    if ((this.mRuntime.getActivity() == null) || (this.mRuntime.getActivity().isFinishing())) {}
    do
    {
      return;
      if (this.p == null) {
        this.p = Utils.createPluginSetDialogForWeb(this.mRuntime.getActivity(), this.mClient, this.b, paramInt, paramLong, paramString1, paramString2);
      }
    } while (this.p.isShowing());
    this.p.show();
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    paramJsBridgeListener = paramVarArgs[0];
    if (paramString3 == null) {
      return false;
    }
    if (paramString3.equals("showOpenDialog")) {}
    for (;;)
    {
      long l;
      try
      {
        paramString1 = new JSONObject(paramJsBridgeListener);
        l = paramString1.optLong("id", -1L);
        paramJsBridgeListener = paramString1.optString("msg");
        paramString1 = paramString1.optString("callback");
        if (l != -1L)
        {
          paramString2 = new Bundle();
          paramString2.putInt("reqCode", 10000);
          paramString2.putLong("uiResId", l);
          paramString2.putString("msg", paramJsBridgeListener);
          paramString2.putString("callback", paramString1);
          paramString2.putInt("dialogType", 1);
          this.mClient.a(18, paramString2, this.b);
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        continue;
      }
      return true;
      if (paramString3.equals("getPluginStatus")) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramJsBridgeListener);
          l = paramJsBridgeListener.optLong("id", -1L);
          paramJsBridgeListener = paramJsBridgeListener.optString("callback");
          if (l == -1L) {
            continue;
          }
          paramString1 = new Bundle();
          paramString1.putInt("reqCode", 10002);
          paramString1.putLong("uiResId", l);
          paramString1.putString("callback", paramJsBridgeListener);
          this.mClient.a(18, paramString1, this.b);
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
      } else if (paramString3.equals("search")) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramJsBridgeListener).optString("keyWord");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            if (this.mRuntime.getActivity() != null) {}
            amxk.b("hot_list", "clk_hot_list", new String[] { paramJsBridgeListener });
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mClient = skj.a();
    this.mClient.bzj();
  }
  
  public void onDestroy()
  {
    if (this.mClient != null) {
      this.mClient.bzk();
    }
    if ((this.p != null) && (this.p.isShowing())) {
      this.p.dismiss();
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jrz
 * JD-Core Version:    0.7.0.1
 */