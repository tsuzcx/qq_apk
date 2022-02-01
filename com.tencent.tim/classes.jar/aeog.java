import android.graphics.Color;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;

public class aeog
{
  public boolean bVm;
  public int cOf = 10;
  public ArrayList<aoie> vL = new ArrayList(4);
  
  public static aeog a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      aeog localaeog = new aeog();
      paramString = new JSONObject(paramString);
      localaeog.bVm = paramString.optBoolean("showEntrance", false);
      localaeog.cOf = paramString.optInt("bannerInterval", 10);
      paramString = paramString.optJSONArray("array");
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length())
        {
          JSONObject localJSONObject = (JSONObject)paramString.get(i);
          aoie localaoie = new aoie();
          localaoie.id = localJSONObject.optInt("id");
          localaoie.order = localJSONObject.optInt("order");
          localaoie.title = localJSONObject.optString("title");
          localaoie.subTitle = localJSONObject.optString("subTitle");
          localaoie.bgColor = Color.parseColor(localJSONObject.optString("bgColor"));
          localaoie.imgUrl = localJSONObject.optString("imageUrl");
          localaeog.vL.add(localaoie);
          i += 1;
        }
      }
      Collections.sort(localaeog.vL, new aeoh());
      QLog.d("TogetherEntryConfProcessor", 2, "confBean = " + localaeog.toString());
      return localaeog;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TogetherEntryConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
      }
    }
    return null;
  }
  
  public String toString()
  {
    return 50;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeog
 * JD-Core Version:    0.7.0.1
 */