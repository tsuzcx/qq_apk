import java.util.List;
import org.json.JSONObject;

public class tuq
  extends tvg<Integer, Integer>
{
  private tuq()
  {
    super(Integer.valueOf(100));
  }
  
  tuq(List<tsl<Integer>> paramList, Integer paramInteger)
  {
    super(paramList, paramInteger);
  }
  
  public Integer e()
  {
    return (Integer)this.bH;
  }
  
  public ttg<Integer, Integer> g()
  {
    if (!Os()) {
      return new ttu(this.bH);
    }
    return new ttk(this.keyframes);
  }
  
  public static final class a
  {
    static tuq a()
    {
      return new tuq(null);
    }
    
    public static tuq a(JSONObject paramJSONObject, trx paramtrx)
    {
      if ((paramJSONObject != null) && (paramJSONObject.has("x"))) {
        paramtrx.addWarning("Lottie doesn't support expressions.");
      }
      paramJSONObject = tvf.a(paramJSONObject, 1.0F, paramtrx, tuq.b.a()).a();
      paramtrx = (Integer)paramJSONObject.bH;
      return new tuq(paramJSONObject.keyframes, paramtrx);
    }
  }
  
  static class b
    implements tve.a<Integer>
  {
    private static final b a = new b();
    
    public Integer a(Object paramObject, float paramFloat)
    {
      return Integer.valueOf(Math.round(tws.a(paramObject) * paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tuq
 * JD-Core Version:    0.7.0.1
 */