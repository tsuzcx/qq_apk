import org.json.JSONObject;

public class twa
  implements tvj
{
  private final tux b;
  private final int index;
  private final String name;
  
  private twa(String paramString, int paramInt, tux paramtux)
  {
    this.name = paramString;
    this.index = paramInt;
    this.b = paramtux;
  }
  
  public tso a(trz paramtrz, twe paramtwe)
  {
    return new ttd(paramtrz, paramtwe, this);
  }
  
  public tux b()
  {
    return this.b;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String toString()
  {
    return "ShapePath{name=" + this.name + ", index=" + this.index + ", hasAnimation=" + this.b.Os() + '}';
  }
  
  static class a
  {
    static twa a(JSONObject paramJSONObject, trx paramtrx)
    {
      paramtrx = tux.a.a(paramJSONObject.optJSONObject("ks"), paramtrx);
      return new twa(paramJSONObject.optString("nm"), paramJSONObject.optInt("ind"), paramtrx, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     twa
 * JD-Core Version:    0.7.0.1
 */