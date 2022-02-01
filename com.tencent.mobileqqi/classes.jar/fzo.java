import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.jsp.DataApiPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class fzo
  extends Client.onRemoteRespObserver
{
  public fzo(DataApiPlugin paramDataApiPlugin) {}
  
  public void onBindedToClient() {}
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle paramBundle) {}
  
  public void onResponse(Bundle paramBundle)
  {
    Object localObject;
    String str;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.a.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver.key))
    {
      localObject = paramBundle.getString("cmd");
      str = paramBundle.getString("callbackid");
      paramBundle = paramBundle.getBundle("response");
      if (QLog.isColorLevel()) {
        QLog.i(DataApiPlugin.jdField_a_of_type_JavaLangString, 2, "response:" + (String)localObject);
      }
      if ((localObject == null) || (!"getUserVipType".equals(localObject))) {}
    }
    try
    {
      localObject = new JSONObject();
      int i = paramBundle.getInt("type");
      ((JSONObject)localObject).put("result", 0);
      ((JSONObject)localObject).put("message", "ok");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("uin", paramBundle.getString("uin"));
      localJSONObject.put("type", i);
      ((JSONObject)localObject).put("data", localJSONObject);
      if (!TextUtils.isEmpty(str)) {
        this.a.callJs(str + "(" + ((JSONObject)localObject).toString() + ");");
      }
      return;
    }
    catch (JSONException paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fzo
 * JD-Core Version:    0.7.0.1
 */