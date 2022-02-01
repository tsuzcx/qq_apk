import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class abbg
{
  public List<abbg.a> vK = new ArrayList();
  
  public static abbg a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = new abbg();
    }
    for (;;)
    {
      return paramJSONObject;
      localabbg = new abbg();
      try
      {
        JSONArray localJSONArray = new JSONArray(paramJSONObject.getString("items"));
        paramJSONObject = localabbg;
        if (localJSONArray == null) {
          continue;
        }
        paramJSONObject = localabbg;
        if (localJSONArray.length() < 0) {
          continue;
        }
        int j = localJSONArray.length();
        int i = 0;
        for (;;)
        {
          paramJSONObject = localabbg;
          if (i >= j) {
            break;
          }
          paramJSONObject = abbg.a.a(localJSONArray.getJSONObject(i));
          localabbg.vK.add(paramJSONObject);
          i += 1;
        }
        return localabbg;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return localabbg;
      }
      catch (OutOfMemoryError paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return localabbg;
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  public static class a
  {
    public String aZu;
    public String ace;
    public String backgroundUrl;
    public String bfb;
    public String bfc;
    public String bfd;
    public String bfe;
    public String bff;
    public String bfg;
    public int classify;
    public int cnA;
    public int id;
    public int isShow;
    public int type;
    
    static a a(JSONObject paramJSONObject)
    {
      if (paramJSONObject == null) {
        return new a();
      }
      a locala = new a();
      try
      {
        locala.id = paramJSONObject.getInt("id");
        locala.bfb = paramJSONObject.getString("name");
        locala.type = paramJSONObject.getInt("type");
        locala.bfc = paramJSONObject.optString("soundVersion", "0");
        locala.ace = paramJSONObject.getString("soundUrl");
        locala.bfd = paramJSONObject.getString("whiteList");
        locala.isShow = paramJSONObject.getInt("isShow");
        locala.classify = paramJSONObject.getInt("classify");
        locala.aZu = paramJSONObject.getString("classifyName");
        locala.backgroundUrl = paramJSONObject.getString("backgroundUrl");
        locala.bfe = String.valueOf(paramJSONObject.getInt("vip_type"));
        locala.cnA = paramJSONObject.getInt("useNum");
        locala.bff = paramJSONObject.getString("trialstartday");
        locala.bfg = paramJSONObject.getString("trialendday");
        return locala;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abbg
 * JD-Core Version:    0.7.0.1
 */