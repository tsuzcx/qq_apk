import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class ocg
  implements skj.a
{
  ocg(obw paramobw, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void callback(Bundle paramBundle)
  {
    String str2;
    JSONObject localJSONObject;
    if (paramBundle != null)
    {
      if (this.this$0.activity != null) {
        this.this$0.cancleProgressDailog();
      }
      str2 = paramBundle.getString("pic_local_id");
      localJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        if (!"-1".equals(str2)) {
          continue;
        }
        localJSONObject.put("retCode", -1);
        localJSONObject.put("msg", "fail");
        if (!this.awl) {
          continue;
        }
        anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D28", "0X8005D28", 0, -1, "1", "", "", "");
        paramBundle = str2;
        localJSONObject.put("localId", paramBundle);
      }
      catch (JSONException paramBundle)
      {
        String str1;
        paramBundle.printStackTrace();
        continue;
      }
      this.this$0.callJs(this.val$callback, new String[] { localJSONObject.toString() });
      if (this.awl) {
        this.this$0.pi(this.apE);
      }
      return;
      anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D31", "0X8005D31", 0, -1, "1", "", "", "");
      paramBundle = str2;
      continue;
      str1 = str2;
      if (this.awl) {
        str1 = "mqqpa://resourceid/" + str2;
      }
      paramBundle = paramBundle.getString("pic_local_path");
      obw.eH.put(str1, paramBundle);
      localJSONObject.put("retCode", 0);
      if (QLog.isColorLevel()) {
        QLog.i("PublicAccountH5AbilityPlugin", 2, "下载成功，localld为  " + str1);
      }
      if (this.awl)
      {
        anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D28", "0X8005D28", 0, 0, "1", "", "", "");
        paramBundle = str1;
      }
      else
      {
        anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D31", "0X8005D31", 0, 0, "1", "", "", "");
        paramBundle = str1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ocg
 * JD-Core Version:    0.7.0.1
 */