import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class tuf
{
  private final char character;
  private final String fontFamily;
  private final List<tvz> shapes;
  private final int size;
  private final String style;
  private final double width;
  
  tuf(List<tvz> paramList, char paramChar, int paramInt, double paramDouble, String paramString1, String paramString2)
  {
    this.shapes = paramList;
    this.character = paramChar;
    this.size = paramInt;
    this.width = paramDouble;
    this.style = paramString1;
    this.fontFamily = paramString2;
  }
  
  public static int hashFor(char paramChar, String paramString1, String paramString2)
  {
    return ((paramChar + '\000') * 31 + paramString1.hashCode()) * 31 + paramString2.hashCode();
  }
  
  public List<tvz> getShapes()
  {
    return this.shapes;
  }
  
  public double getWidth()
  {
    return this.width;
  }
  
  public int hashCode()
  {
    return hashFor(this.character, this.fontFamily, this.style);
  }
  
  public static class a
  {
    public static tuf a(JSONObject paramJSONObject, trx paramtrx)
    {
      char c = paramJSONObject.optString("ch").charAt(0);
      int j = paramJSONObject.optInt("size");
      double d = paramJSONObject.optDouble("w");
      String str1 = paramJSONObject.optString("style");
      String str2 = paramJSONObject.optString("fFamily");
      Object localObject = paramJSONObject.optJSONObject("data");
      List localList = Collections.emptyList();
      paramJSONObject = localList;
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optJSONArray("shapes");
        paramJSONObject = localList;
        if (localObject != null)
        {
          paramJSONObject = new ArrayList(((JSONArray)localObject).length());
          int i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            paramJSONObject.add((tvz)tvz.a(((JSONArray)localObject).optJSONObject(i), paramtrx));
            i += 1;
          }
        }
      }
      return new tuf(paramJSONObject, c, j, d, str1, str2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tuf
 * JD-Core Version:    0.7.0.1
 */