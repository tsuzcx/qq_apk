import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aetd
{
  private String mDesc = "";
  private String mTitle = acfp.m(2131715232);
  private List<String> yZ = new ArrayList();
  
  public static aetd a(aeic[] paramArrayOfaeic)
  {
    int i = 0;
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0)) {
      return null;
    }
    aetd localaetd = new aetd();
    try
    {
      paramArrayOfaeic = new JSONObject(paramArrayOfaeic[0].content);
      JSONArray localJSONArray = paramArrayOfaeic.getJSONArray("suffix");
      while (i < localJSONArray.length())
      {
        localaetd.yZ.add(localJSONArray.getString(i));
        i += 1;
      }
      localaetd.mTitle = paramArrayOfaeic.getString("title");
      localaetd.mDesc = paramArrayOfaeic.getString("desc");
      return localaetd;
    }
    catch (JSONException paramArrayOfaeic)
    {
      paramArrayOfaeic.printStackTrace();
    }
    return localaetd;
  }
  
  public List<String> es()
  {
    return this.yZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aetd
 * JD-Core Version:    0.7.0.1
 */