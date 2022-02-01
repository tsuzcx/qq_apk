import java.util.List;
import org.json.JSONObject;

public class tum
  extends tvg<Float, Float>
{
  private tum()
  {
    super(Float.valueOf(0.0F));
  }
  
  private tum(List<tsl<Float>> paramList, Float paramFloat)
  {
    super(paramList, paramFloat);
  }
  
  public Float a()
  {
    return (Float)this.bH;
  }
  
  public ttg<Float, Float> g()
  {
    if (!Os()) {
      return new ttu(this.bH);
    }
    return new tti(this.keyframes);
  }
  
  public static final class a
  {
    static tum a()
    {
      return new tum(null);
    }
    
    public static tum a(JSONObject paramJSONObject, trx paramtrx)
    {
      return a(paramJSONObject, paramtrx, true);
    }
    
    public static tum a(JSONObject paramJSONObject, trx paramtrx, boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (float f = paramtrx.aE();; f = 1.0F)
      {
        if ((paramJSONObject != null) && (paramJSONObject.has("x"))) {
          paramtrx.addWarning("Lottie doesn't support expressions.");
        }
        paramJSONObject = tvf.a(paramJSONObject, f, paramtrx, tum.b.a).a();
        return new tum(paramJSONObject.keyframes, (Float)paramJSONObject.bH, null);
      }
    }
  }
  
  static class b
    implements tve.a<Float>
  {
    static final b a = new b();
    
    public Float a(Object paramObject, float paramFloat)
    {
      return Float.valueOf(tws.a(paramObject) * paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tum
 * JD-Core Version:    0.7.0.1
 */