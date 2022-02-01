import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aqwj
{
  public boolean cWI;
  public String content;
  public List<aqwl> iD;
  public String moreUrl;
  public String msg;
  public int ret = -30009;
  
  public aqwj() {}
  
  public aqwj(JSONObject paramJSONObject)
    throws JSONException
  {
    this.msg = paramJSONObject.optString("msg");
    if (paramJSONObject.optInt("openflag") == 1)
    {
      this.cWI = bool;
      this.ret = paramJSONObject.optInt("ret", -30009);
      this.content = paramJSONObject.optString("content");
      this.moreUrl = paramJSONObject.optString("url");
      paramJSONObject = paramJSONObject.optString("list");
      if (!TextUtils.isEmpty(paramJSONObject)) {
        break label96;
      }
    }
    for (;;)
    {
      return;
      bool = false;
      break;
      label96:
      paramJSONObject = new JSONArray(paramJSONObject);
      int j = paramJSONObject.length();
      this.iD = new ArrayList();
      while (i < j)
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
        if (localJSONObject != null) {
          this.iD.add(new aqwl(localJSONObject.optString("num"), localJSONObject.optString("light")));
        }
        i += 1;
      }
    }
  }
  
  public String toString()
  {
    return "LiangHaoRsp{openFlag=" + this.cWI + ", ret=" + this.ret + ", msg='" + this.msg + '\'' + ", moreUrl='" + this.moreUrl + '\'' + ", content='" + this.content + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqwj
 * JD-Core Version:    0.7.0.1
 */