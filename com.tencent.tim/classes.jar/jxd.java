import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView;
import org.json.JSONException;
import org.json.JSONObject;

public class jxd
{
  public String UB;
  public String UC;
  public int aDT;
  public VideoCoverView b;
  
  public jxd() {}
  
  public jxd(int paramInt, String paramString1, String paramString2)
  {
    this.aDT = paramInt;
    this.UB = paramString1;
    this.UC = paramString2;
  }
  
  public static jxd a(int paramInt, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      jxd localjxd = new jxd();
      localjxd.aDT = paramInt;
      localjxd.UB = paramJSONObject.getString("str_cover");
      localjxd.UC = paramJSONObject.getString("str_src");
      return localjxd;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
  
  public static jxd a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      jxd localjxd = new jxd();
      localjxd.aDT = paramJSONObject.getInt("index");
      localjxd.UB = paramJSONObject.getString("cover");
      localjxd.UC = paramJSONObject.getString("src");
      return localjxd;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
  
  public JSONObject l()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("index", this.aDT);
      localJSONObject.put("cover", this.UB);
      localJSONObject.put("src", this.UC);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public String toString()
  {
    return "mVideoSrc " + this.UC + " mVideoCoverPic " + this.UB + " mVideoIndex " + this.aDT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jxd
 * JD-Core Version:    0.7.0.1
 */