import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aora
{
  public boolean cOh;
  private int dRu = 1;
  public int duration;
  public int height;
  public String md5;
  public long size;
  public String text;
  public String thumbUrl;
  public String url;
  public String vid;
  public int width;
  
  public void Wb(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.dRu = -1;
      return;
    case 1: 
      this.dRu = 2;
      return;
    case 0: 
      this.dRu = 1;
      return;
    }
    this.dRu = 3;
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("vid", this.vid);
      localJSONObject.put("url", this.url);
      localJSONObject.put("video_md5", this.md5);
      localJSONObject.put("video_thumbe_url", this.thumbUrl);
      localJSONObject.put("text", this.text);
      localJSONObject.put("duration", this.duration);
      localJSONObject.put("size", this.size);
      localJSONObject.put("width", this.width);
      localJSONObject.put("height", this.height);
      localJSONObject.put("isLocalVideo", this.cOh);
      localJSONObject.put("takeVideoMode", this.dRu);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("VideoInfo", 2, "VideoInfo: " + QLog.getStackTraceString(localJSONException));
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aora
 * JD-Core Version:    0.7.0.1
 */