import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.view.animation.Interpolator;
import org.json.JSONArray;
import org.json.JSONObject;

public class ttn
  extends tsl<PointF>
{
  @Nullable
  private Path path;
  
  private ttn(trx paramtrx, @Nullable PointF paramPointF1, @Nullable PointF paramPointF2, @Nullable Interpolator paramInterpolator, float paramFloat, @Nullable Float paramFloat1)
  {
    super(paramtrx, paramPointF1, paramPointF2, paramInterpolator, paramFloat, paramFloat1);
  }
  
  @Nullable
  Path getPath()
  {
    return this.path;
  }
  
  public static class a
  {
    public static ttn a(JSONObject paramJSONObject, trx paramtrx, tve.a<PointF> parama)
    {
      tsl localtsl = tsl.a.a(paramJSONObject, paramtrx, paramtrx.aE(), parama);
      JSONArray localJSONArray = paramJSONObject.optJSONArray("ti");
      paramJSONObject = paramJSONObject.optJSONArray("to");
      if ((localJSONArray != null) && (paramJSONObject != null))
      {
        parama = tws.a(paramJSONObject, paramtrx.aE());
        paramJSONObject = tws.a(localJSONArray, paramtrx.aE());
      }
      for (;;)
      {
        paramtrx = new ttn(paramtrx, (PointF)localtsl.startValue, (PointF)localtsl.endValue, localtsl.interpolator, localtsl.startFrame, localtsl.endFrame, null);
        if ((localtsl.endValue != null) && (localtsl.startValue != null) && (((PointF)localtsl.startValue).equals(((PointF)localtsl.endValue).x, ((PointF)localtsl.endValue).y))) {}
        for (int i = 1;; i = 0)
        {
          if ((paramtrx.endValue != null) && (i == 0)) {
            ttn.a(paramtrx, twy.createPath((PointF)localtsl.startValue, (PointF)localtsl.endValue, parama, paramJSONObject));
          }
          return paramtrx;
        }
        paramJSONObject = null;
        parama = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ttn
 * JD-Core Version:    0.7.0.1
 */