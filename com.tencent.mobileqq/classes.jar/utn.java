import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

class utn
  implements aaea
{
  utn(uta paramuta, String paramString, boolean paramBoolean) {}
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (this.jdField_a_of_type_Uta.a != null) {
        this.jdField_a_of_type_Uta.l();
      }
      String str = paramBundle.getString("pic_server_id");
      this.jdField_a_of_type_Uta.a(paramBundle);
      if ("-1".equals(str)) {
        paramBundle = new JSONObject();
      }
    }
    else
    {
      try
      {
        paramBundle.put("retCode", -1);
        paramBundle.put("msg", "fail");
        this.jdField_a_of_type_Uta.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle.toString() });
        if (this.jdField_a_of_type_Boolean)
        {
          olh.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D27", "0X8005D27", 0, -1, "1", "", "", "", false);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
        bdla.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D30", "0X8005D30", 0, -1, "1", "", "", "");
        return;
      }
    }
    this.jdField_a_of_type_Uta.a(localJSONException, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     utn
 * JD-Core Version:    0.7.0.1
 */