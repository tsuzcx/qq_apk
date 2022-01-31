import android.app.Activity;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.LoadedCallBack;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class bup
  implements LoadedCallBack
{
  public bup(OfflinePlugin paramOfflinePlugin, String paramString, long paramLong) {}
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    int i;
    Object localObject;
    try
    {
      paramString = new JSONObject(paramString);
    }
    catch (JSONException paramString)
    {
      int j;
      label67:
      paramString.printStackTrace();
      return;
    }
    try
    {
      i = paramString.getInt("r");
      if (i != 0) {}
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    try
    {
      if (paramString.getInt("type") > 0)
      {
        localObject = paramString.getString("url");
        boolean bool = TextUtils.isEmpty((CharSequence)localObject);
        if (!bool) {
          i = 0;
        }
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    try
    {
      j = paramString.getInt("filesize");
      i = j;
    }
    catch (JSONException localJSONException)
    {
      break label67;
    }
    String str = Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("_bid");
    if ((paramString.optInt("updateNotification") == 1) && (this.jdField_a_of_type_Long != 0L))
    {
      localObject = this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.a.obtainMessage();
      ((Message)localObject).arg1 = 3;
      ((Message)localObject).obj = paramString;
      this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.a.sendMessage((Message)localObject);
    }
    do
    {
      return;
      paramString = this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.mRuntime.a();
    } while (paramString == null);
    HtmlOffline.a(paramString.getApplicationContext(), str, (String)localObject, i, new buq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bup
 * JD-Core Version:    0.7.0.1
 */