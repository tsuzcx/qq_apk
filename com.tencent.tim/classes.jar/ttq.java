import android.graphics.PointF;
import java.util.List;

public class ttq
  extends ttl<PointF>
{
  private final PointF point = new PointF();
  
  public ttq(List<tsl<PointF>> paramList)
  {
    super(paramList);
  }
  
  public PointF a(tsl<PointF> paramtsl, float paramFloat)
  {
    if ((paramtsl.startValue == null) || (paramtsl.endValue == null)) {
      throw new IllegalStateException("Missing values for keyframe.");
    }
    PointF localPointF1 = (PointF)paramtsl.startValue;
    paramtsl = (PointF)paramtsl.endValue;
    PointF localPointF2 = this.point;
    float f1 = localPointF1.x;
    float f2 = paramtsl.x;
    float f3 = localPointF1.x;
    float f4 = localPointF1.y;
    localPointF2.set(f1 + (f2 - f3) * paramFloat, (paramtsl.y - localPointF1.y) * paramFloat + f4);
    return this.point;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ttq
 * JD-Core Version:    0.7.0.1
 */