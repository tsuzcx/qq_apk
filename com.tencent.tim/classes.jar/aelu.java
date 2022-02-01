import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aelu
{
  public int aSR = -1;
  
  public static aelu a(aeic[] paramArrayOfaeic)
  {
    aelu localaelu = new aelu();
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
            a(new JSONObject((String)localObject), localaelu);
            if (QLog.isColorLevel()) {
              QLog.i("PhotoListPanelBean", 2, "parse: " + (String)localObject + " bean:" + localaelu);
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
    return localaelu;
  }
  
  private static void a(JSONObject paramJSONObject, aelu paramaelu)
  {
    if (paramJSONObject.has("showMode")) {
      paramaelu.aSR = paramJSONObject.optInt("showMode");
    }
  }
  
  public String toString()
  {
    return "PhotoListPanelBean{showMode=" + this.aSR + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aelu
 * JD-Core Version:    0.7.0.1
 */