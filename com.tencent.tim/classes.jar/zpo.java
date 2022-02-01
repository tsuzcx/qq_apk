import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class zpo
{
  public static List<zpo.a> uG;
  
  public static void parseConfig(JSONObject paramJSONObject)
  {
    int i = 2;
    if ((paramJSONObject != null) && (paramJSONObject.has("entryList")))
    {
      paramJSONObject = paramJSONObject.optJSONArray("entryList");
      ArrayList localArrayList = new ArrayList();
      if (paramJSONObject.length() > 2) {}
      for (;;)
      {
        int j = 0;
        while (j < i)
        {
          JSONObject localJSONObject = paramJSONObject.optJSONObject(j);
          zpo.a locala = new zpo.a();
          locala.id = localJSONObject.optInt("id");
          Object localObject = localJSONObject.optJSONObject("image");
          if (localObject != null)
          {
            localObject = ((JSONObject)localObject).optString("src");
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              locala.imageUrl = ("https://gxh.vip.qq.com/xydata" + (String)localObject);
            }
          }
          locala.title = localJSONObject.optString("name");
          locala.desc = localJSONObject.optString("desc");
          locala.jumpUrl = localJSONObject.optString("url");
          locala.isShow = localJSONObject.optBoolean("isShow", true);
          locala.tag = localJSONObject.optInt("tag", 0);
          localArrayList.add(locala);
          j += 1;
        }
        i = paramJSONObject.length();
      }
      uG = localArrayList;
    }
  }
  
  public static class a
  {
    public String desc;
    public int id;
    public String imageUrl;
    public boolean isShow = true;
    public String jumpUrl;
    public int tag;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zpo
 * JD-Core Version:    0.7.0.1
 */