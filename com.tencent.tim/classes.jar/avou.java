import android.os.Bundle;

public abstract class avou
{
  public String apiName;
  public int exK;
  protected final int exL = -9999999;
  protected final int exM = 0;
  public int retCode = -9999999;
  public String retMsg;
  
  public boolean isSuccess()
  {
    return this.retCode == 0;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    paramBundle.putInt("_mqqpay_baseresp_retcode", this.retCode);
    paramBundle.putString("_mqqpay_baseresp_retmsg", this.retMsg);
    paramBundle.putString("_mqqpay_baseapi_apiname", this.apiName);
    paramBundle.putInt("_mqqpay_baseapi_apimark", this.exK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avou
 * JD-Core Version:    0.7.0.1
 */