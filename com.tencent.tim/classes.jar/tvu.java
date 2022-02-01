import android.support.annotation.Nullable;
import org.json.JSONObject;

public class tvu
  implements tvj
{
  private final tvc a;
  private final String name;
  private final tum r;
  private final tum s;
  
  tvu(String paramString, tum paramtum1, tum paramtum2, tvc paramtvc)
  {
    this.name = paramString;
    this.r = paramtum1;
    this.s = paramtum2;
    this.a = paramtvc;
  }
  
  @Nullable
  public tso a(trz paramtrz, twe paramtwe)
  {
    return new ttc(paramtrz, paramtwe, this);
  }
  
  public tvc b()
  {
    return this.a;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public tum m()
  {
    return this.r;
  }
  
  public tum n()
  {
    return this.s;
  }
  
  static final class a
  {
    static tvu a(JSONObject paramJSONObject, trx paramtrx)
    {
      return new tvu(paramJSONObject.optString("nm"), tum.a.a(paramJSONObject.optJSONObject("c"), paramtrx, false), tum.a.a(paramJSONObject.optJSONObject("o"), paramtrx, false), tvc.a.a(paramJSONObject.optJSONObject("tr"), paramtrx));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tvu
 * JD-Core Version:    0.7.0.1
 */