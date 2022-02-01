import org.json.JSONObject;

public class abnp
  implements abob.a
{
  private int cqf;
  
  public abnp()
  {
    int i = abob.cqn;
    abob.cqn = i + 1;
    this.cqf = i;
  }
  
  public JSONObject a(abob paramabob, JSONObject paramJSONObject)
  {
    if ("cs.audio_create.local".equals(paramJSONObject.optString("N_R_CMD")))
    {
      paramJSONObject = new abnc(paramJSONObject.optInt("N_R_OBJ"), paramJSONObject.optInt("id"), paramJSONObject.optString("type"));
      if (paramabob != null) {
        paramabob.a(paramJSONObject);
      }
    }
    return null;
  }
  
  public String rf()
  {
    return null;
  }
  
  public int zJ()
  {
    return this.cqf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abnp
 * JD-Core Version:    0.7.0.1
 */