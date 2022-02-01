import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class tus
  implements tve<PointF, PointF>
{
  private PointF initialPoint;
  private final List<ttn> keyframes = new ArrayList();
  
  tus()
  {
    this.initialPoint = new PointF(0.0F, 0.0F);
  }
  
  tus(Object paramObject, trx paramtrx)
  {
    if (t(paramObject))
    {
      paramObject = (JSONArray)paramObject;
      int j = paramObject.length();
      int i = 0;
      while (i < j)
      {
        ttn localttn = ttn.a.a(paramObject.optJSONObject(i), paramtrx, tus.a.a());
        this.keyframes.add(localttn);
        i += 1;
      }
      tsl.setEndFrames(this.keyframes);
      return;
    }
    this.initialPoint = tws.a((JSONArray)paramObject, paramtrx.aE());
  }
  
  public static tve<PointF, PointF> a(JSONObject paramJSONObject, trx paramtrx)
  {
    if (paramJSONObject.has("k")) {
      return new tus(paramJSONObject.opt("k"), paramtrx);
    }
    return new tuz(tum.a.a(paramJSONObject.optJSONObject("x"), paramtrx), tum.a.a(paramJSONObject.optJSONObject("y"), paramtrx));
  }
  
  private boolean t(Object paramObject)
  {
    if (!(paramObject instanceof JSONArray)) {
      return false;
    }
    paramObject = ((JSONArray)paramObject).opt(0);
    if (((paramObject instanceof JSONObject)) && (((JSONObject)paramObject).has("t"))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean Os()
  {
    return !this.keyframes.isEmpty();
  }
  
  public ttg<PointF, PointF> g()
  {
    if (!Os()) {
      return new ttu(this.initialPoint);
    }
    return new ttp(this.keyframes);
  }
  
  public String toString()
  {
    return "initialPoint=" + this.initialPoint;
  }
  
  static class a
    implements tve.a<PointF>
  {
    private static final tve.a<PointF> a = new a();
    
    public PointF a(Object paramObject, float paramFloat)
    {
      return tws.a((JSONArray)paramObject, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tus
 * JD-Core Version:    0.7.0.1
 */