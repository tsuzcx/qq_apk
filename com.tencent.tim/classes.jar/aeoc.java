import org.json.JSONException;
import org.json.JSONObject;

public class aeoc
{
  private boolean bVk;
  private String mAppid = "1108338344";
  private String mPath = "pages/list/list";
  private String mVersion = "";
  
  public static aeoc a(JSONObject paramJSONObject)
    throws JSONException
  {
    boolean bool = true;
    aeoc localaeoc = new aeoc();
    if (paramJSONObject.has("enableOpenMiniCode")) {
      if (paramJSONObject.getInt("enableOpenMiniCode") != 1) {
        break label93;
      }
    }
    for (;;)
    {
      localaeoc.bVk = bool;
      if (paramJSONObject.has("miniCodeAppid")) {
        localaeoc.mAppid = paramJSONObject.getString("miniCodeAppid");
      }
      if (paramJSONObject.has("miniCodePage")) {
        localaeoc.mPath = paramJSONObject.getString("miniCodePage");
      }
      if (paramJSONObject.has("miniCodeEnvVersion")) {
        localaeoc.mVersion = paramJSONObject.getString("miniCodeEnvVersion");
      }
      return localaeoc;
      label93:
      bool = false;
    }
  }
  
  public void Ht(boolean paramBoolean)
  {
    this.bVk = paramBoolean;
  }
  
  public boolean ahr()
  {
    return this.bVk;
  }
  
  public String getAppid()
  {
    return this.mAppid;
  }
  
  public String getPath()
  {
    return this.mPath;
  }
  
  public void setPath(String paramString)
  {
    this.mPath = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeoc
 * JD-Core Version:    0.7.0.1
 */