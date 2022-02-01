import org.json.JSONException;
import org.json.JSONObject;

public class nwq
{
  public int busiType;
  public String coverUrl;
  public int duration;
  public int height;
  public long ry;
  public String title;
  public String vid;
  public String videoUrl;
  public int width;
  
  public nwq() {}
  
  public nwq(JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject == null) {}
    do
    {
      return;
      if (paramJSONObject.has("busiType")) {
        this.busiType = paramJSONObject.getInt("busiType");
      }
      if (paramJSONObject.has("vid")) {
        this.vid = paramJSONObject.getString("vid");
      }
      if (paramJSONObject.has("width")) {
        this.width = paramJSONObject.getInt("width");
      }
      if (paramJSONObject.has("height")) {
        this.height = paramJSONObject.getInt("height");
      }
      if (paramJSONObject.has("duration")) {
        this.duration = paramJSONObject.getInt("duration");
      }
      if (paramJSONObject.has("poster")) {
        this.coverUrl = paramJSONObject.getString("poster");
      }
      if (paramJSONObject.has("title")) {
        this.title = paramJSONObject.getString("title");
      }
      if (paramJSONObject.has("xgFileSize")) {
        this.ry = paramJSONObject.getLong("xgFileSize");
      }
    } while (!paramJSONObject.has("videoUrl"));
    this.videoUrl = paramJSONObject.getString("videoUrl");
  }
  
  public String toString()
  {
    return "VideoInfo{busiType=" + this.busiType + ", vid='" + this.vid + '\'' + ", width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", coverUrl='" + this.coverUrl + '\'' + ", title='" + this.title + '\'' + ", XGFileSize=" + this.ry + ", videoUrl='" + this.videoUrl + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nwq
 * JD-Core Version:    0.7.0.1
 */