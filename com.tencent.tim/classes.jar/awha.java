import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import java.io.PrintStream;
import org.json.JSONException;
import org.json.JSONObject;

public class awha
  extends awfr
{
  public static String PKG_NAME = "Qzone";
  public static String cQi = "famous_uin";
  public static String cQj = "title";
  public static String cQk = "summary";
  public static String cQl = "thumb_photo_url";
  public static String cQm = "detail_url";
  public static String cQn = "h5_detail_url";
  public static String cQo = "schema_detail_url";
  public static String cQp = "is_followed";
  public static String cQq = "show_report";
  public static String cQr = "nick_name";
  public static String cQs = "descption";
  public static String cQt = "fans_count";
  public static String cQu = "visitor_count";
  public static String cQv = "background_url";
  public static String cQw = "qrcode_url";
  
  private void a(Activity paramActivity, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return;
    }
    try
    {
      Object localObject = new JSONObject(paramArrayOfString[0]);
      String str4 = ((JSONObject)localObject).getString("famous_uin");
      String str5 = ((JSONObject)localObject).getString("title");
      String str6 = ((JSONObject)localObject).getString("summary");
      String str7 = ((JSONObject)localObject).getString("thumb_photo_url");
      String str8 = ((JSONObject)localObject).getString("detail_url");
      paramArrayOfString = null;
      String str1 = null;
      String str2 = null;
      String str3 = null;
      long l = 0L;
      int i = 0;
      if (((JSONObject)localObject).has("nick_name")) {
        paramArrayOfString = ((JSONObject)localObject).getString("nick_name");
      }
      if (((JSONObject)localObject).has("descption")) {
        str1 = ((JSONObject)localObject).getString("descption");
      }
      if (((JSONObject)localObject).has("fans_count")) {
        l = ((JSONObject)localObject).getLong("fans_count");
      }
      if (((JSONObject)localObject).has("visitor_count")) {
        i = ((JSONObject)localObject).getInt("visitor_count");
      }
      if (((JSONObject)localObject).has("background_url")) {
        str2 = ((JSONObject)localObject).getString("background_url");
      }
      if (((JSONObject)localObject).has("qrcode_url")) {
        str3 = ((JSONObject)localObject).getString("qrcode_url");
      }
      System.out.println("---------title:" + str5 + ",summary:" + str6 + ",thumb_photo_url" + str7 + ",detail_url:" + str8);
      localObject = new Intent();
      ((Intent)localObject).putExtra(cQi, str4);
      ((Intent)localObject).putExtra(cQj, str5);
      ((Intent)localObject).putExtra(cQk, str6);
      ((Intent)localObject).putExtra(cQl, str7);
      ((Intent)localObject).putExtra(cQr, paramArrayOfString);
      ((Intent)localObject).putExtra(cQs, str1);
      ((Intent)localObject).putExtra(cQt, l);
      ((Intent)localObject).putExtra(cQu, i);
      ((Intent)localObject).putExtra(cQv, str2);
      ((Intent)localObject).putExtra(cQw, str3);
      ((Intent)localObject).putExtra(cQm, str8);
      ((Intent)localObject).setClassName(paramActivity, "com.qzone.misc.web.QZoneTranslucentActivity");
      ((Intent)localObject).putExtra("cmd", awen.cPz);
      paramActivity.startActivity((Intent)localObject);
      return;
    }
    catch (JSONException paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals(PKG_NAME)) || (this.f == null) || (this.f.mRuntime == null)) {}
    while (!paramString3.equalsIgnoreCase("showShareMenu")) {
      return false;
    }
    a(this.f.mRuntime.getActivity(), paramVarArgs);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awha
 * JD-Core Version:    0.7.0.1
 */