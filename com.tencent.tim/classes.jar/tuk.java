import java.util.List;
import org.json.JSONObject;

public class tuk
  extends tvg<Integer, Integer>
{
  private tuk(List<tsl<Integer>> paramList, Integer paramInteger)
  {
    super(paramList, paramInteger);
  }
  
  public ttg<Integer, Integer> g()
  {
    if (!Os()) {
      return new ttu(this.bH);
    }
    return new tth(this.keyframes);
  }
  
  public String toString()
  {
    return "AnimatableColorValue{initialValue=" + this.bH + '}';
  }
  
  public static final class a
  {
    public static tuk a(JSONObject paramJSONObject, trx paramtrx)
    {
      paramJSONObject = tvf.a(paramJSONObject, 1.0F, paramtrx, ttz.a).a();
      return new tuk(paramJSONObject.keyframes, (Integer)paramJSONObject.bH, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tuk
 * JD-Core Version:    0.7.0.1
 */