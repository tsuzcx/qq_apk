import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import org.json.JSONException;
import org.json.JSONObject;

public class awhm
{
  public static void C(WebViewPlugin.a parama, String... paramVarArgs)
  {
    int i = 0;
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      return;
    }
    try
    {
      paramVarArgs = new JSONObject(paramVarArgs[0]);
      int k = paramVarArgs.optInt("facade", -1);
      int m = paramVarArgs.optInt("feedskin", -1);
      int n = paramVarArgs.optInt("avatar", -1);
      int i1 = paramVarArgs.optInt("float", -1);
      int i2 = paramVarArgs.optInt("customvip", -1);
      int i3 = paramVarArgs.optInt("praise", -1);
      int i4 = paramVarArgs.optInt("player", -1);
      boolean bool = paramVarArgs.optBoolean("isAfter785", false);
      int j = paramVarArgs.optInt("diyHome", -1);
      paramVarArgs = new Intent("action_personalize_js2qzone");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "SetPersonalizeFinished");
      localBundle.putInt("facade", k);
      localBundle.putInt("feedskin", m);
      localBundle.putInt("avatar", n);
      localBundle.putInt("floatObject", i1);
      localBundle.putInt("customvip", i2);
      localBundle.putInt("praise", i3);
      localBundle.putInt("player", i4);
      if (bool) {
        i = 1;
      }
      localBundle.putInt("isAfter785", i);
      localBundle.putInt("diyHome", j);
      paramVarArgs.putExtras(localBundle);
      avpw.a(parama.getActivity(), avpw.d.a(), paramVarArgs);
      return;
    }
    catch (JSONException parama) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awhm
 * JD-Core Version:    0.7.0.1
 */