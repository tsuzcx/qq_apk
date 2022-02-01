import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class utp
  implements aaea
{
  utp(uta paramuta, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void callback(Bundle paramBundle)
  {
    String str2;
    JSONObject localJSONObject;
    if (paramBundle != null)
    {
      if (this.jdField_a_of_type_Uta.a != null) {
        this.jdField_a_of_type_Uta.l();
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
        if (!this.jdField_a_of_type_Boolean) {
          continue;
        }
        bdla.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D28", "0X8005D28", 0, -1, "1", "", "", "");
        paramBundle = str2;
        localJSONObject.put("localId", paramBundle);
      }
      catch (JSONException paramBundle)
      {
        String str1;
        paramBundle.printStackTrace();
        continue;
      }
      this.jdField_a_of_type_Uta.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Uta.c(this.b);
      }
      return;
      bdla.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D31", "0X8005D31", 0, -1, "1", "", "", "");
      paramBundle = str2;
      continue;
      str1 = str2;
      if (this.jdField_a_of_type_Boolean) {
        str1 = "mqqpa://resourceid/" + str2;
      }
      paramBundle = paramBundle.getString("pic_local_path");
      uta.b.put(str1, paramBundle);
      localJSONObject.put("retCode", 0);
      localJSONObject.put("msg", anvx.a(2131708227) + str1);
      if (QLog.isColorLevel()) {
        QLog.i("PublicAccountH5AbilityPlugin", 2, "下载成功，localld为  " + str1);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        bdla.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D28", "0X8005D28", 0, 0, "1", "", "", "");
        paramBundle = str1;
      }
      else
      {
        bdla.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D31", "0X8005D31", 0, 0, "1", "", "", "");
        paramBundle = str1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     utp
 * JD-Core Version:    0.7.0.1
 */