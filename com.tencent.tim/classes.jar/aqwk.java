import org.json.JSONException;
import org.json.JSONObject;

public class aqwk
{
  public boolean flag;
  public int ret = -30009;
  
  public aqwk() {}
  
  public aqwk(JSONObject paramJSONObject)
    throws JSONException
  {
    this.ret = paramJSONObject.optInt("ret", -30009);
    if ((this.ret == 0) && (paramJSONObject.optInt("flag", 0) == 1)) {}
    for (;;)
    {
      this.flag = bool;
      return;
      bool = false;
    }
  }
  
  public String toString()
  {
    return "LiangHaoStatusRsp{ret=" + this.ret + ", flag=" + this.flag + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqwk
 * JD-Core Version:    0.7.0.1
 */