import android.graphics.Path;
import java.util.List;
import org.json.JSONObject;

public class tux
  extends tvg<tvv, Path>
{
  private final Path x = new Path();
  
  private tux(List<tsl<tvv>> paramList, tvv paramtvv)
  {
    super(paramList, paramtvv);
  }
  
  Path a(tvv paramtvv)
  {
    this.x.reset();
    twx.a(paramtvv, this.x);
    return this.x;
  }
  
  public ttg<tvv, Path> g()
  {
    if (!Os()) {
      return new ttu(a((tvv)this.bH));
    }
    return new tts(this.keyframes);
  }
  
  public static final class a
  {
    public static tux a(JSONObject paramJSONObject, trx paramtrx)
    {
      paramJSONObject = tvf.a(paramJSONObject, paramtrx.aE(), paramtrx, tvv.a.a).a();
      return new tux(paramJSONObject.keyframes, (tvv)paramJSONObject.bH, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tux
 * JD-Core Version:    0.7.0.1
 */