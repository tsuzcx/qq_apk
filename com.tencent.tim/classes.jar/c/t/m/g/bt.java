package c.t.m.g;

import org.json.JSONObject;

final class bt
{
  public String a;
  public String b;
  public int c;
  
  bt() {}
  
  public bt(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("bid", null);
    this.b = paramJSONObject.optString("floor", "1000");
    this.c = paramJSONObject.optInt("type", -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.bt
 * JD-Core Version:    0.7.0.1
 */