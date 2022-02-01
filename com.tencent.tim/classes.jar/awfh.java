import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class awfh
  extends awfr
{
  private static final String TAG = awfk.class.getSimpleName();
  private static String cPN = "";
  
  private void q(WebViewPlugin.a parama, String[] paramArrayOfString)
  {
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]);
      cPN = paramArrayOfString.getString("callback");
      parama = new Bundle();
      parama.putInt("key_personal_album_enter_model", 0);
      parama.putBoolean("key_pass_result_by_bundle", true);
      parama.putString("key_accept_album_anonymity", paramArrayOfString.optString("acceptType"));
      parama.putString("key_deny_delect_tips", paramArrayOfString.optString("denyTips"));
      parama.putBoolean("key_can_new_album", false);
      parama.putString("key_from_type", paramArrayOfString.optString("fromType"));
      paramArrayOfString = avpw.d.a();
      paramArrayOfString.cMP = this.f.mRuntime.a().getCurrentAccountUin();
      parama.putBoolean("key_need_change_to_jpg", false);
      avpw.a(this.f.mRuntime.getActivity(), paramArrayOfString, parama, avpw.a(this.f, this.f.mRuntime, 7));
      return;
    }
    catch (Exception parama)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w(TAG, 2, "handlePickQzoneAlbum,decode param error");
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.f == null) || (this.f.mRuntime == null)) {}
    while (!paramString3.equalsIgnoreCase("PickQzoneAlbum")) {
      return false;
    }
    q(this.f.mRuntime, paramVarArgs);
    return true;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    switch (paramByte)
    {
    }
    do
    {
      return;
    } while ((TextUtils.isEmpty(cPN)) || (paramIntent == null));
    String str1 = paramIntent.getStringExtra("key_selected_albuminfo.id");
    String str2 = paramIntent.getStringExtra("key_selected_albuminfo.name");
    paramIntent.getStringExtra("key_selected_albuminfo.cover");
    paramIntent.getIntExtra("key_selected_albuminfo.permission", 0);
    paramByte = paramIntent.getIntExtra("key_selected_albuminfo.type", 0);
    paramInt = paramIntent.getIntExtra("key_selected_albuminfo.anonymity", 0);
    paramIntent = new JSONObject();
    try
    {
      paramIntent.put("albumid", str1);
      paramIntent.put("albumtype", paramByte);
      paramIntent.put("albumname", str2);
      paramIntent.put("albumanonymity", paramInt);
      if (QLog.isDevelopLevel()) {
        QLog.d(TAG, 4, paramIntent.toString());
      }
      this.f.callJs(cPN, new String[] { paramIntent.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awfh
 * JD-Core Version:    0.7.0.1
 */