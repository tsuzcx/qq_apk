import android.graphics.PointF;
import java.util.List;
import org.json.JSONObject;

public class tut
  extends tvg<PointF, PointF>
{
  private tut(List<tsl<PointF>> paramList, PointF paramPointF)
  {
    super(paramList, paramPointF);
  }
  
  public ttg<PointF, PointF> g()
  {
    if (!Os()) {
      return new ttu(this.bH);
    }
    return new ttq(this.keyframes);
  }
  
  public static final class a
  {
    public static tut a(JSONObject paramJSONObject, trx paramtrx)
    {
      paramJSONObject = tvf.a(paramJSONObject, paramtrx.aE(), paramtrx, tui.a).a();
      return new tut(paramJSONObject.keyframes, (PointF)paramJSONObject.bH, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tut
 * JD-Core Version:    0.7.0.1
 */