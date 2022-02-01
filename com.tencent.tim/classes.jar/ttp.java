import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

public class ttp
  extends ttl<PointF>
{
  private ttn a;
  private PathMeasure pathMeasure;
  private final PointF point = new PointF();
  private final float[] pos = new float[2];
  
  public ttp(List<? extends tsl<PointF>> paramList)
  {
    super(paramList);
  }
  
  public PointF a(tsl<PointF> paramtsl, float paramFloat)
  {
    ttn localttn = (ttn)paramtsl;
    Path localPath = localttn.getPath();
    if (localPath == null) {
      return (PointF)paramtsl.startValue;
    }
    if (this.a != localttn)
    {
      this.pathMeasure = new PathMeasure(localPath, false);
      this.a = localttn;
    }
    this.pathMeasure.getPosTan(this.pathMeasure.getLength() * paramFloat, this.pos, null);
    this.point.set(this.pos[0], this.pos[1]);
    return this.point;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ttp
 * JD-Core Version:    0.7.0.1
 */