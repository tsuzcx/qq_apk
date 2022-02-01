import android.graphics.PointF;
import java.util.Collections;
import java.util.List;

public class ttt
  extends ttg<PointF, PointF>
{
  private final PointF point = new PointF();
  private final ttg<Float, Float> v;
  private final ttg<Float, Float> w;
  
  public ttt(ttg<Float, Float> paramttg1, ttg<Float, Float> paramttg2)
  {
    super(Collections.emptyList());
    this.v = paramttg1;
    this.w = paramttg2;
  }
  
  PointF a(tsl<PointF> paramtsl, float paramFloat)
  {
    return this.point;
  }
  
  public PointF getValue()
  {
    return a(null, 0.0F);
  }
  
  public void setProgress(float paramFloat)
  {
    this.v.setProgress(paramFloat);
    this.w.setProgress(paramFloat);
    this.point.set(((Float)this.v.getValue()).floatValue(), ((Float)this.w.getValue()).floatValue());
    int i = 0;
    while (i < this.listeners.size())
    {
      ((ttg.a)this.listeners.get(i)).onValueChanged();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ttt
 * JD-Core Version:    0.7.0.1
 */