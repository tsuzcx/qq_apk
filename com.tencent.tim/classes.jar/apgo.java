import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class apgo
{
  private JSONArray R;
  private JSONObject bT;
  public boolean cQp;
  private String coO;
  public int dUe;
  private int errorCode;
  private String errorMsg;
  private List<apgo.a> items = new ArrayList();
  
  public static apgo a(String paramString)
    throws JSONException
  {
    apgo localapgo = new apgo();
    localapgo.parse(paramString);
    return localapgo;
  }
  
  private void parse(String paramString)
    throws JSONException
  {
    long l = System.currentTimeMillis();
    this.coO = paramString;
    new ArrayList();
    JSONObject localJSONObject1 = new JSONObject(paramString);
    this.errorCode = localJSONObject1.optInt("errorcode");
    this.errorMsg = localJSONObject1.optString("errormsg");
    JSONArray localJSONArray = localJSONObject1.optJSONArray("items");
    int i = 0;
    while (i < localJSONArray.length())
    {
      JSONObject localJSONObject2 = localJSONArray.getJSONObject(i);
      apgo.a locala = new apgo.a();
      locala.subject = localJSONObject2.optString("itemstring");
      locala.cQq = "YES".equalsIgnoreCase(localJSONObject2.optString("item"));
      locala.confidence = localJSONObject2.optInt("itemconf");
      JSONObject localJSONObject3 = localJSONObject2.optJSONObject("itemcoord");
      locala.x = localJSONObject3.optInt("x");
      locala.y = localJSONObject3.optInt("y");
      locala.width = localJSONObject3.optInt("width");
      locala.height = localJSONObject3.optInt("height");
      if (!locala.aAZ())
      {
        ram.e("QQ.Troop.homework.ArithResult", "arith homework json error!! all json=" + paramString);
        rom.fail("arith homework json error!! json=" + localJSONObject2, new Object[0]);
      }
      if (!locala.cQq) {
        this.dUe += 1;
      }
      this.items.add(locala);
      i += 1;
    }
    this.R = localJSONArray;
    this.bT = localJSONObject1;
    ram.w("QQ.Troop.homework.ArithResult", "parse json cost=" + (System.currentTimeMillis() - l));
  }
  
  public int Lq()
  {
    return this.items.size();
  }
  
  public apgo.a a(int paramInt)
  {
    return (apgo.a)this.items.get(paramInt);
  }
  
  public String toJSON()
    throws JSONException
  {
    ram.w("QQ.Troop.homework.ArithResult", "toJson:" + this.cQp);
    long l = System.currentTimeMillis();
    if (this.cQp)
    {
      int i = 0;
      if (i < this.items.size())
      {
        localObject = (apgo.a)this.items.get(i);
        JSONObject localJSONObject = this.R.getJSONObject(i);
        if (((apgo.a)localObject).cQq) {}
        for (localObject = "YES";; localObject = "NO")
        {
          localJSONObject.put("item", localObject);
          i += 1;
          break;
        }
      }
      this.bT.put("items", this.R);
    }
    for (Object localObject = this.bT.toString();; localObject = this.coO)
    {
      ram.w("QQ.Troop.homework.ArithResult", "toJSON cost=" + (System.currentTimeMillis() - l));
      return localObject;
    }
  }
  
  public static class a
  {
    public boolean cQq;
    public int confidence;
    public int height;
    public String subject = "default";
    public int width;
    public int x;
    public int y;
    
    public boolean aAZ()
    {
      if ((TextUtils.isEmpty(this.subject)) || ("default".equals(this.subject))) {}
      while ((this.x < 0) || (this.y < 0) || (this.width <= 0) || (this.height <= 0)) {
        return false;
      }
      return true;
    }
    
    public String toString()
    {
      return "Item{subject='" + this.subject + '\'' + ", correct=" + this.cQq + ", confidence=" + this.confidence + ", x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apgo
 * JD-Core Version:    0.7.0.1
 */