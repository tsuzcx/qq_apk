import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class yhn
  extends yhj
{
  public String aXN;
  public String aXT;
  public String scene;
  public String uin;
  
  public JSONObject V()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("uin", this.uin);
      localJSONObject2.put("touin", this.aXT);
      localJSONObject2.put("appid", this.appid);
      localJSONObject2.put("scene", this.scene);
      localJSONObject2.put("expose_md5s", this.aXP);
      localJSONObject2.put("expose_urls", this.aXQ);
      localJSONObject2.put("click_md5", this.aXR);
      localJSONObject2.put("click_url", this.click_url);
      localJSONObject2.put("aio_type", this.aXN);
      localJSONObject2.put("mobile_type", this.mobile_type);
      localJSONObject2.put("passthough", this.aXS);
      localJSONObject1.put("dcId", this.dcId);
      localJSONObject1.put("data", localJSONObject2);
      return localJSONObject1;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ScenesRecReportData", 2, "convert error:" + localException);
    }
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yhn
 * JD-Core Version:    0.7.0.1
 */