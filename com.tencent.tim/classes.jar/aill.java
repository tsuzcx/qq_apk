import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import cooperation.plugin.PluginInfo;
import cooperation.troop.TroopManageProxyActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class aill
  implements skj.a
{
  public aill(UiApiPlugin paramUiApiPlugin, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    int i = 12;
    if (paramBundle != null)
    {
      if (paramBundle.getBoolean("isSuccess"))
      {
        paramBundle = new Intent();
        paramBundle.putExtra("troop_uin", this.Uf);
        if (this.this$0.mRuntime.b() != null) {
          i = this.this$0.mRuntime.b().switchRequestCode(this.this$0, (byte)12);
        }
        TroopManageProxyActivity.a("troop_manage_plugin.apk", PluginInfo.cKH, TroopManageProxyActivity.class, this.this$0.mRuntime.getActivity(), paramBundle, TroopManageProxyActivity.a(this.this$0.mRuntime.getActivity()), "com.tencent.mobileqq.activity.TroopSetJoinTypeActivity", this.this$0.mRuntime.a().getAccount(), i);
      }
    }
    else {
      return;
    }
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("gc", this.Uf);
      paramBundle.put("ret", 1);
      this.this$0.callJs(this.this$0.bOK, new String[] { paramBundle.toString() });
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aill
 * JD-Core Version:    0.7.0.1
 */