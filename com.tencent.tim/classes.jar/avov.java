import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class avov
  extends avot
{
  public String bargainorId;
  public String cMq;
  public String cMr;
  public String cMs;
  public String cMt;
  public String cMu;
  public String cvX;
  public String nonce;
  public String packageName;
  public String sig;
  public long timeStamp;
  
  public boolean checkParams()
  {
    if (TextUtils.isEmpty(this.appId)) {}
    while ((TextUtils.isEmpty(this.appType)) || ((!this.appType.equals("native")) && (!this.appType.equals("browser"))) || (TextUtils.isEmpty(this.packageName)) || ((!this.appType.equals("browser")) && (TextUtils.isEmpty(this.cMr))) || (TextUtils.isEmpty(this.cMu)) || (TextUtils.isEmpty(this.bargainorId)) || (TextUtils.isEmpty(this.nonce)) || (TextUtils.isEmpty(this.sig)) || (TextUtils.isEmpty(this.cvX)) || (this.timeStamp <= 0L) || (TextUtils.isEmpty(this.cMq))) {
      return false;
    }
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.cMq = paramBundle.getString("_mqqpay_payapi_serialnumber");
    this.cMr = paramBundle.getString("_mqqpay_payapi_callbackscheme");
    this.cMs = paramBundle.getString("_mqqpay_payapi_pubacc");
    this.cMt = paramBundle.getString("_mqqpay_payapi_pubacchint");
    this.cMu = paramBundle.getString("_mqqpay_payapi_tokenid");
    this.nonce = paramBundle.getString("_mqqpay_payapi_nonce");
    this.timeStamp = paramBundle.getLong("_mqqpay_payapi_timeStamp");
    this.bargainorId = paramBundle.getString("_mqqpay_payapi_bargainorId");
    this.cvX = paramBundle.getString("_mqqpay_payapi_sigType");
    this.sig = paramBundle.getString("_mqqpay_payapi_sig");
    this.packageName = paramBundle.getString("_mqqpay_payapi_packageName");
  }
  
  public void fromJson(String paramString)
  {
    this.appType = "browser";
    this.apiName = "pay";
    this.exK = 1;
    try
    {
      paramString = new JSONObject(paramString);
      JSONObject localJSONObject = paramString.optJSONObject("action");
      if (localJSONObject != null)
      {
        String str = localJSONObject.optString("name");
        if (str != null)
        {
          if (!str.equals("pay")) {
            return;
          }
          this.cMq = localJSONObject.optString("identifier");
          localJSONObject = paramString.optJSONObject("application");
          if (localJSONObject != null)
          {
            this.appId = localJSONObject.optString("appId");
            this.sdkVersion = localJSONObject.optString("sdkVersion");
            this.packageName = localJSONObject.optString("pkgName");
            this.cMr = localJSONObject.optString("urlScheme");
          }
          paramString = paramString.optJSONObject("params");
          if (paramString != null)
          {
            this.cMu = paramString.optString("tokenId");
            this.timeStamp = paramString.optLong("timeStamp");
            this.nonce = paramString.optString("nonce");
            this.bargainorId = paramString.optString("bargainorId");
            this.cvX = "HMAC-SHA1";
            this.sig = paramString.optString("sig");
            return;
          }
        }
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(super.toString());
    localStringBuilder.append("&sn=" + this.cMq);
    localStringBuilder.append("&cs=" + this.cMr);
    localStringBuilder.append("&pa=" + this.cMs);
    localStringBuilder.append("&pah=" + this.cMt);
    localStringBuilder.append("&ti=" + this.cMu);
    localStringBuilder.append("&ne=" + this.nonce);
    localStringBuilder.append("&ts=" + this.timeStamp);
    localStringBuilder.append("&bi=" + this.bargainorId);
    localStringBuilder.append("&st=" + this.cvX);
    localStringBuilder.append("&sg=" + this.sig);
    localStringBuilder.append("&pn=" + this.packageName);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avov
 * JD-Core Version:    0.7.0.1
 */