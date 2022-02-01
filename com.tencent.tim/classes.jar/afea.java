import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class afea
{
  public afea.a a;
  public String dcId;
  
  public JSONObject V()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("user_id", this.a.user_id);
      localJSONObject2.put("source_md5", this.a.bDg);
      localJSONObject2.put("source_url", this.a.bDh);
      localJSONArray = new JSONArray();
      localIterator = this.a.vY.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put((String)localIterator.next());
      }
      localException.put("expose_md5s", localJSONArray);
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DoutuReportData", 2, "convert error:" + localException);
      }
      return localJSONObject1;
    }
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.a.vZ.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put((String)localIterator.next());
    }
    localException.put("expose_urls", localJSONArray);
    localException.put("click_md5", this.a.aXR);
    localException.put("click_url", this.a.click_url);
    localException.put("aio_type", this.a.aXN);
    localException.put("mobile_type", this.a.mobile_type);
    localException.put("to_user_id", this.a.aXO);
    localJSONObject1.put("dcId", this.dcId);
    localJSONObject1.put("data", localException);
    return localJSONObject1;
  }
  
  public class a
  {
    public String aXN;
    public String aXO;
    public String aXR;
    public String bDg;
    public String bDh;
    public String click_url;
    public String mobile_type;
    public String user_id;
    public ArrayList<String> vY;
    public ArrayList<String> vZ;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afea
 * JD-Core Version:    0.7.0.1
 */