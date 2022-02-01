import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

public class avow
  extends avou
{
  public String cMA;
  public String cMq;
  public String cMv;
  public String cMw;
  public String cMx;
  public String cMy;
  public String cMz;
  public String openId;
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_mqqpay_payresp_paychanneltype", this.cMv);
    paramBundle.putString("_mqqpay_payresp_transactionid", this.cMw);
    paramBundle.putString("_mqqpay_payresp_paytime", this.cMx);
    paramBundle.putString("_mqqpay_payresp_totalfee", this.cMy);
    paramBundle.putString("_mqqpay_payresp_callbackurl", this.cMz);
    paramBundle.putString("_mqqpay_payresp_spdata", this.cMA);
    paramBundle.putString("_mqqpay_payapi_serialnumber", this.cMq);
    paramBundle.putString("_mqqpay_payapi_openid", this.openId);
  }
  
  public String toJson()
  {
    try
    {
      Object localObject = new JSONObject();
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("name", "pay");
      localJSONObject1.put("identifier", this.cMq);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("code", this.retCode);
      localJSONObject2.put("message", this.retMsg);
      ((JSONObject)localObject).put("action", localJSONObject1);
      ((JSONObject)localObject).put("params", localJSONObject2);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avow
 * JD-Core Version:    0.7.0.1
 */