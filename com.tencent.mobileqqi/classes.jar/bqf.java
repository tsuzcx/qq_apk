import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import org.json.JSONException;
import org.json.JSONObject;

public class bqf
  extends Thread
{
  public bqf(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, String paramString1, JSONObject paramJSONObject, String paramString2) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.jdField_a_of_type_JavaLangString);
      String str2 = localJSONObject.optString("callid");
      String str1 = str2;
      if (!TextUtils.isEmpty(str2)) {
        str1 = str2.replace("\\", "\\\\").replace("'", "\\'");
      }
      this.jdField_a_of_type_OrgJsonJSONObject.put("callid", str1);
      str1 = localJSONObject.optString("url");
      if (!TextUtils.isEmpty(str1))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.b, new String[] { "{ret:1, response:" + this.jdField_a_of_type_OrgJsonJSONObject.toString() + "}" });
        str1 = PublicAccountJavascriptInterface.a(str1);
        if (str1 != null)
        {
          str1 = str1.replace("\\", "\\\\").replace("'", "\\'");
          this.jdField_a_of_type_OrgJsonJSONObject.put("data", str1);
          this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.b, new String[] { "{ret:0, response:" + this.jdField_a_of_type_OrgJsonJSONObject.toString() + "}" });
          return;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.b, new String[] { "{ret:-10, response:" + this.jdField_a_of_type_OrgJsonJSONObject.toString() + "}" });
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.b, new String[] { "{ret:-2, response:" + this.jdField_a_of_type_OrgJsonJSONObject.toString() + "}" });
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.b, new String[] { "{ret:-4, response:" + this.jdField_a_of_type_OrgJsonJSONObject.toString() + "}" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bqf
 * JD-Core Version:    0.7.0.1
 */