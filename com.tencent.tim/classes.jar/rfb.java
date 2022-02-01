import com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterManager;
import java.io.File;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class rfb
{
  public String azY;
  public String id;
  public String md5;
  public String name;
  public int priority;
  public String url;
  public int version;
  
  public rfb(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.id = paramString1;
    this.version = paramInt1;
    this.priority = paramInt2;
    this.url = paramString2;
    this.name = paramString3;
    this.md5 = paramString4;
    this.azY = paramString5;
  }
  
  public String getThumbImageFileName()
  {
    return this.name + "_thumb" + ".png";
  }
  
  public String getUnzippedDir()
  {
    return this.name + File.separator + this.version + File.separator;
  }
  
  public String getZipFilePath()
  {
    return this.name + File.separator + this.version + ".zip";
  }
  
  public JSONObject toJsonObject()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", this.id);
      localJSONObject.put("thumbPath", ArtFilterManager.aAb + getUnzippedDir() + getThumbImageFileName());
      localJSONObject.put("priority", this.priority);
      localJSONObject.put("name", this.name);
      localJSONObject.put("pron", this.azY);
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
    return String.format(Locale.CHINA, "ArtFilter: id=%s, version=%d, priority=%d, url=%s, name=%s, md5=%s, pron=%s", new Object[] { this.id, Integer.valueOf(this.version), Integer.valueOf(this.priority), this.url, this.name, this.md5, this.azY });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rfb
 * JD-Core Version:    0.7.0.1
 */