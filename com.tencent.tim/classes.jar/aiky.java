import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class aiky
  implements auuw.b
{
  public aiky(UiApiPlugin paramUiApiPlugin, JSONObject paramJSONObject, Activity paramActivity) {}
  
  public void a(auuw.a parama)
  {
    int i = parama.id - 1;
    Object localObject1 = null;
    parama = null;
    for (;;)
    {
      JSONArray localJSONArray;
      int j;
      try
      {
        String str = this.val$params.optString("callback");
        localJSONArray = this.val$params.optJSONArray("list");
        if (localJSONArray == null) {
          break;
        }
        if (i >= localJSONArray.length()) {
          return;
        }
        if (TextUtils.isEmpty(str)) {
          break label169;
        }
        this.this$0.callJs(str, new String[] { String.valueOf(i + 1) });
        return;
      }
      catch (Exception localException1)
      {
        i = 0;
        localObject1 = parama;
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.e("UiApiPlugin", 2, "showPopupMenu Exception: " + localException1.getMessage());
          j = i;
          localObject1 = parama;
        }
        switch (j)
        {
        default: 
          return;
        }
      }
      this.this$0.mRuntime.getWebView().loadUrl((String)localObject1);
      return;
      label169:
      Object localObject2 = localJSONArray.optJSONObject(i);
      i = ((JSONObject)localObject2).optInt("target");
      parama = (auuw.a)localObject1;
      try
      {
        localObject1 = ((JSONObject)localObject2).optString("jumpUrl");
        parama = (auuw.a)localObject1;
        boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
        j = i;
        if (!bool) {
          continue;
        }
        return;
      }
      catch (Exception localException2) {}
      parama = new Bundle();
      if ((this.val$activity instanceof BasePluginActivity))
      {
        localObject2 = new Intent(((BasePluginActivity)this.val$activity).getOutActivity(), QQBrowserActivity.class);
        ((Intent)localObject2).putExtras(parama);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
        ((Intent)localObject2).setFlags(0);
        this.val$activity.startActivity((Intent)localObject2);
        return;
      }
      localObject2 = new Intent(this.val$activity, this.val$activity.getClass());
      ((Intent)localObject2).putExtras(parama);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
      ((Intent)localObject2).setFlags(0);
      this.val$activity.startActivity((Intent)localObject2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiky
 * JD-Core Version:    0.7.0.1
 */