import android.content.Context;
import android.graphics.Rect;
import com.tencent.common.app.BaseApplicationImpl;
import org.json.JSONArray;
import org.json.JSONObject;

public class adyc
{
  public int alpha;
  public Rect bP;
  public boolean bRL;
  public Rect bl;
  public int bubbleId;
  public String bvU = "";
  public String bwg = "";
  public int cLb;
  public long duration;
  public String key = "";
  public int repeatCount = 1;
  public String zipName;
  
  public void b(int paramInt, String paramString, JSONObject paramJSONObject)
    throws Exception
  {
    if (paramJSONObject == null) {}
    do
    {
      return;
      this.key = paramString;
      this.bubbleId = paramInt;
      paramString = BaseApplicationImpl.getContext();
      if (paramJSONObject.has("rect"))
      {
        JSONArray localJSONArray = paramJSONObject.getJSONArray("rect");
        this.bl = new Rect();
        this.bl.left = wja.dp2px(localJSONArray.getInt(0) / 2, paramString.getResources());
        this.bl.top = wja.dp2px(localJSONArray.getInt(1) / 2, paramString.getResources());
        this.bl.right = wja.dp2px(localJSONArray.getInt(2) / 2, paramString.getResources());
        this.bl.bottom = wja.dp2px(localJSONArray.getInt(3) / 2, paramString.getResources());
      }
      this.duration = paramJSONObject.optInt("time", 0);
      this.repeatCount = paramJSONObject.optInt("cycle_count", 1);
      this.cLb = paramJSONObject.optInt("count", 0);
      this.bwg = paramJSONObject.optString("img_prefix", "");
      this.alpha = paramJSONObject.optInt("alpha", 0);
      this.bvU = paramJSONObject.optString("align", "");
      this.zipName = paramJSONObject.optString("zip_name", "");
      this.bRL = paramJSONObject.optBoolean("img_reverse", true);
      paramJSONObject = paramJSONObject.optJSONArray("padding");
    } while ((paramJSONObject == null) || (paramJSONObject.length() <= 0));
    this.bP = new Rect();
    this.bP.left = wja.dp2px(paramJSONObject.getInt(0) / 2, paramString.getResources());
    this.bP.top = wja.dp2px(paramJSONObject.getInt(1) / 2, paramString.getResources());
    this.bP.right = wja.dp2px(paramJSONObject.getInt(2) / 2, paramString.getResources());
    this.bP.bottom = wja.dp2px(paramJSONObject.getInt(3) / 2, paramString.getResources());
  }
  
  public static class a
    extends adyc
  {
    public Rect bQ;
    public Rect bR;
    public boolean bRM;
    public String bwh = "";
    public String bwi = "";
    public int cLc = -1;
    
    public void b(int paramInt, String paramString, JSONObject paramJSONObject)
      throws Exception
    {
      if (paramJSONObject != null)
      {
        super.b(paramInt, paramString, paramJSONObject);
        paramString = BaseApplicationImpl.getContext();
        this.cLc = paramJSONObject.optInt("passive_type", -1);
        this.bRM = paramJSONObject.optBoolean("passive_rotate", false);
        this.bwh = paramJSONObject.optString("start_align", this.bvU);
        this.bvU = this.bwh;
        this.bwi = paramJSONObject.optString("end_align", "");
        if (paramJSONObject.has("start_rect"))
        {
          JSONArray localJSONArray = paramJSONObject.getJSONArray("start_rect");
          this.bQ = new Rect();
          this.bQ.left = wja.dp2px(localJSONArray.getInt(0) / 2, paramString.getResources());
          this.bQ.top = wja.dp2px(localJSONArray.getInt(1) / 2, paramString.getResources());
          this.bQ.right = wja.dp2px(localJSONArray.getInt(2) / 2, paramString.getResources());
          this.bQ.bottom = wja.dp2px(localJSONArray.getInt(3) / 2, paramString.getResources());
          this.bl = this.bQ;
        }
        if (paramJSONObject.has("end_rect"))
        {
          paramJSONObject = paramJSONObject.getJSONArray("end_rect");
          this.bR = new Rect();
          this.bR.left = wja.dp2px(paramJSONObject.getInt(0) / 2, paramString.getResources());
          this.bR.top = wja.dp2px(paramJSONObject.getInt(1) / 2, paramString.getResources());
          this.bR.right = wja.dp2px(paramJSONObject.getInt(2) / 2, paramString.getResources());
          this.bR.bottom = wja.dp2px(paramJSONObject.getInt(3) / 2, paramString.getResources());
        }
      }
    }
  }
  
  public static class b
    extends adyc
  {
    public float aH;
    public float aI;
    public boolean bRL;
    public boolean bRN;
    public int cLd = 0;
    public int cLe = 100;
    public int cLf = 100;
    public int cLg;
    public int cLh;
    public int cLi = 1;
    public float startX;
    public float startY;
    public float vv;
    public float vw;
    public float vx;
    public float vy;
    
    public b a()
    {
      b localb = new b();
      localb.startX = this.aH;
      localb.startY = this.aI;
      localb.aH = this.startX;
      localb.aI = this.startY;
      this.key += "reverse";
      boolean bool;
      if (!this.bRL)
      {
        bool = true;
        localb.bRL = bool;
        localb.cLb = this.cLb;
        localb.bwg = this.bwg;
        localb.cLe = this.cLf;
        localb.cLf = this.cLe;
        localb.cLg = this.cLh;
        localb.cLh = this.cLg;
        if (!this.bRN) {
          break label214;
        }
        localb.vv = this.vv;
        localb.vx = this.vx;
        localb.vw = this.vw;
      }
      for (localb.vy = this.vy;; localb.vy = this.vw)
      {
        localb.cLd = this.cLd;
        localb.bRN = this.bRN;
        localb.cLi = this.cLi;
        localb.duration = this.duration;
        localb.repeatCount = this.repeatCount;
        return localb;
        bool = false;
        break;
        label214:
        localb.vv = this.vx;
        localb.vx = this.vv;
        localb.vw = this.vy;
      }
    }
  }
  
  public static class c
    extends adyc
  {
    public String bwj = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adyc
 * JD-Core Version:    0.7.0.1
 */