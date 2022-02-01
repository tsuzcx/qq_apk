import android.os.Bundle;

public abstract class avot
{
  public String apiName;
  public String appId;
  public String appType;
  public int exK;
  public String sdkVersion;
  
  public void fromBundle(Bundle paramBundle)
  {
    this.appId = paramBundle.getString("_mqqpay_baseapi_appid");
    this.appType = paramBundle.getString("_mqqpay_baseapi_apptype");
    this.sdkVersion = paramBundle.getString("_mqqpay_baseapi_sdkversion");
    this.apiName = paramBundle.getString("_mqqpay_baseapi_apiname");
    this.exK = paramBundle.getInt("_mqqpay_baseapi_apimark");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append("ai=" + this.appId);
    localStringBuilder.append("&sv=" + this.sdkVersion);
    localStringBuilder.append("&at=" + this.appType);
    localStringBuilder.append("&an=" + this.apiName);
    localStringBuilder.append("&am=" + this.exK);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avot
 * JD-Core Version:    0.7.0.1
 */