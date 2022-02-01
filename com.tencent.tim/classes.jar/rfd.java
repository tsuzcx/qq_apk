import com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterManager;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class rfd
  implements Cloneable
{
  public static final String azZ = ArtFilterManager.aAb + "loading" + File.separator;
  public int frameCount;
  public String md5;
  public String url;
  public int version;
  
  public static rfd a(JSONObject paramJSONObject)
    throws JSONException
  {
    rfd localrfd = new rfd();
    localrfd.version = paramJSONObject.getInt("version");
    localrfd.frameCount = paramJSONObject.getInt("picNum");
    localrfd.url = paramJSONObject.getString("url");
    localrfd.md5 = paramJSONObject.getString("md5");
    return localrfd;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
  
  public String getZipPath()
  {
    return azZ + this.version + ".zip";
  }
  
  public String mU()
  {
    Object localObject = new File(mV());
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).listFiles();
      if ((localObject != null) && (localObject.length == this.frameCount)) {
        return mV();
      }
    }
    return null;
  }
  
  public String mV()
  {
    return azZ + this.version + File.separator;
  }
  
  public String mW()
  {
    return "loading" + File.separator + this.version + ".zip";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rfd
 * JD-Core Version:    0.7.0.1
 */