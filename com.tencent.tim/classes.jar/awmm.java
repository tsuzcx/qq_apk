import BOSSStrategyCenter.tAdvDesc;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class awmm
  extends aajc
{
  public String auH;
  public String cRv;
  public String cRw;
  public String cRx;
  public String cRy;
  public String cRz;
  public int eBS;
  public int eBT;
  public int eBU;
  
  public awmm(tAdvDesc paramtAdvDesc)
  {
    super(paramtAdvDesc);
  }
  
  protected void cuD()
  {
    super.cuD();
    if ((this.b == null) || (TextUtils.isEmpty(this.b.res_data)))
    {
      QLog.e("QbossADBannerConfigInfo", 1, "parseJsonFromAdvDesc error with data = null");
      return;
    }
    String str = this.b.res_data;
    try
    {
      JSONObject localJSONObject = new JSONObject(str);
      this.eBS = localJSONObject.optInt("enableCountdown");
      this.eBT = localJSONObject.optInt("countdownMinute");
      this.eBU = localJSONObject.optInt("countdownSecond");
      this.cRv = localJSONObject.optString("topText");
      this.cRw = localJSONObject.optString("bottomText");
      this.auH = localJSONObject.optString("textColor");
      this.cRx = localJSONObject.optString("coutdownBgColor");
      this.cRy = localJSONObject.optString("coutdownTextColor");
      this.cRz = localJSONObject.optString("buttonTitle");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("QbossADBannerConfigInfo", 1, "qboss banner parseJson error msg = " + localException.getMessage());
      avyz.a().s(2741, this.b.task_id, 102, "CountDownBanner json parseError exception = " + localException.getMessage() + " json string = " + str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awmm
 * JD-Core Version:    0.7.0.1
 */