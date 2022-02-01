import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class yhi
  extends yhj
{
  public String aXN;
  public String aXO;
  public String keyword;
  public String user_id;
  
  public JSONObject V()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("user_id", this.user_id);
      localJSONObject2.put("keyword", this.keyword);
      localJSONObject2.put("appid", this.appid);
      localJSONObject2.put("expose_md5s", this.aXP);
      localJSONObject2.put("expose_urls", this.aXQ);
      localJSONObject2.put("click_md5", this.aXR);
      localJSONObject2.put("click_url", this.click_url);
      localJSONObject2.put("aio_type", this.aXN);
      localJSONObject2.put("mobile_type", this.mobile_type);
      localJSONObject2.put("to_user_id", this.aXO);
      localJSONObject2.put("passthough", this.aXS);
      localJSONObject1.put("dcId", this.dcId);
      localJSONObject1.put("data", localJSONObject2);
      return localJSONObject1;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("StickerRecReportData", 2, "convert error:" + localException);
    }
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yhi
 * JD-Core Version:    0.7.0.1
 */