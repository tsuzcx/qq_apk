import java.util.List;
import org.json.JSONObject;

public class tva
  extends tvg<tuc, tuc>
{
  tva(List<tsl<tuc>> paramList, tuc paramtuc)
  {
    super(paramList, paramtuc);
  }
  
  public ttv a()
  {
    return new ttv(this.keyframes);
  }
  
  public static final class a
  {
    public static tva a(JSONObject paramJSONObject, trx paramtrx)
    {
      if ((paramJSONObject != null) && (paramJSONObject.has("x"))) {
        paramtrx.addWarning("Lottie doesn't support expressions.");
      }
      paramJSONObject = tvf.a(paramJSONObject, 1.0F, paramtrx, tva.b.a()).a();
      return new tva(paramJSONObject.keyframes, (tuc)paramJSONObject.bH);
    }
  }
  
  static class b
    implements tve.a<tuc>
  {
    private static final b a = new b();
    
    public tuc a(Object paramObject, float paramFloat)
    {
      return tuc.a.a((JSONObject)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tva
 * JD-Core Version:    0.7.0.1
 */