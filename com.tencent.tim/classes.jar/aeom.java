import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aeom
{
  public int cOh;
  public int cOi;
  public int cOj;
  public List<Long> yY = new ArrayList();
  
  public static aeom a(aeic[] paramArrayOfaeic)
  {
    aeom localaeom = new aeom();
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
            localObject = new JSONObject((String)localObject);
            if (((JSONObject)localObject).has("gtcSwitch")) {
              localaeom.cOh = ((JSONObject)localObject).optInt("gtcSwitch");
            }
            if (((JSONObject)localObject).has("groupMemberCount")) {
              localaeom.cOi = ((JSONObject)localObject).optInt("groupMemberCount");
            }
            if (((JSONObject)localObject).has("allGroupTypesEnable")) {
              localaeom.cOj = ((JSONObject)localObject).optInt("allGroupTypesEnable");
            }
            if (((JSONObject)localObject).has("enabledGroupTypes"))
            {
              localObject = ((JSONObject)localObject).optJSONArray("enabledGroupTypes");
              localaeom.yY.addAll(g((JSONArray)localObject));
            }
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberRecommend.ConfBean", 2, "parse: " + localaeom.toString());
          }
        }
      }
    }
    return localaeom;
  }
  
  private static List<Long> g(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray != null)
    {
      int j = paramJSONArray.length();
      int i = 0;
      for (;;)
      {
        if (i < j) {
          try
          {
            localArrayList.add(Long.valueOf(paramJSONArray.getLong(i)));
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.e("TroopMemberRecommend.ConfBean", 2, "TroopMemRecommendConfBean processJsonArray error", localException);
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("TroopMemRecommendConfBean [gtcSwitch: ").append(this.cOh).append(", groupMemberCount: ").append(this.cOi).append(", allGroupTypesEnable: ").append(this.cOj).append(", enabledGroupTypes: ").append(this.yY.toString()).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeom
 * JD-Core Version:    0.7.0.1
 */