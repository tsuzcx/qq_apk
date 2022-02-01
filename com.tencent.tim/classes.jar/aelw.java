import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aelw
{
  public long Wk = 16777216L;
  public long Wl = 16777216L;
  public int bvF = 7;
  public int cNJ = -1;
  public boolean needRegionDecode = true;
  public long pxThreshold = 100000000L;
  public int ramThreshold = 8;
  
  public static aelw a(aeic[] paramArrayOfaeic)
  {
    aelw localaelw = new aelw();
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      int j = paramArrayOfaeic.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramArrayOfaeic[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((aeic)localObject).content;
          try
          {
            JSONObject localJSONObject = new JSONObject((String)localObject);
            a(localJSONObject, localaelw);
            b(localJSONObject, localaelw);
            c(localJSONObject, localaelw);
            if (QLog.isColorLevel()) {
              QLog.i("PicCommonBean", 2, "parse: " + (String)localObject + " bean:" + localaelw);
            }
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
    }
    if (localaelw.ramThreshold < 0) {
      localaelw.ramThreshold = 8;
    }
    if (localaelw.pxThreshold < 0L) {
      localaelw.pxThreshold = 100000000L;
    }
    if (localaelw.bvF < 1) {
      localaelw.pxThreshold = 7L;
    }
    return localaelw;
  }
  
  private static void a(JSONObject paramJSONObject, aelw paramaelw)
    throws JSONException
  {
    paramJSONObject = paramJSONObject.getJSONObject("regionDecode");
    if (paramJSONObject.has("ramThreshold")) {
      paramaelw.ramThreshold = paramJSONObject.optInt("ramThreshold");
    }
    if (paramJSONObject.has("pxThreshold")) {
      paramaelw.pxThreshold = paramJSONObject.optLong("pxThreshold");
    }
    if (paramJSONObject.has("threadCount")) {
      paramaelw.bvF = paramJSONObject.optInt("threadCount");
    }
    if (paramJSONObject.has("needRegionDecode")) {
      paramaelw.needRegionDecode = paramJSONObject.optBoolean("needRegionDecode");
    }
  }
  
  private static void b(JSONObject paramJSONObject, aelw paramaelw)
    throws JSONException
  {
    paramJSONObject = paramJSONObject.getJSONObject("uploadLimit");
    if (paramJSONObject.has("c2c")) {
      paramaelw.Wk = paramJSONObject.optInt("c2c");
    }
    if (paramJSONObject.has("group")) {
      paramaelw.Wl = paramJSONObject.optInt("group");
    }
  }
  
  private static void c(JSONObject paramJSONObject, aelw paramaelw)
    throws JSONException
  {
    paramJSONObject = paramJSONObject.getJSONObject("switchEXIF");
    if (paramJSONObject.has("switch")) {
      paramaelw.cNJ = paramJSONObject.optInt("switch");
    }
  }
  
  public String toString()
  {
    return "PicCommonBean{needRegionDecode=" + this.needRegionDecode + ", ramThreshold=" + this.ramThreshold + ", pxThreshold=" + this.pxThreshold + ", threadCount=" + this.bvF + ", C2C_FileSize_Limit=" + this.Wk + ", GROUP_FileSize_Limit=" + this.Wl + ", EXIF_SWITCH=" + this.cNJ + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aelw
 * JD-Core Version:    0.7.0.1
 */