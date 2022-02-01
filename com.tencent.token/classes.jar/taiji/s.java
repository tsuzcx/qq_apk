package taiji;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

public class s
  extends p<PointF>
{
  private final PointF b = new PointF();
  private final float[] c = new float[2];
  private r d;
  private PathMeasure e;
  
  public s(List<? extends o<PointF>> paramList)
  {
    super(paramList);
  }
  
  public PointF a(o<PointF> paramo, float paramFloat)
  {
    r localr = (r)paramo;
    Path localPath = localr.d();
    if (localPath == null) {
      return (PointF)paramo.a;
    }
    if (this.d != localr)
    {
      this.e = new PathMeasure(localPath, false);
      this.d = localr;
    }
    this.e.getPosTan(this.e.getLength() * paramFloat, this.c, null);
    this.b.set(this.c[0], this.c[1]);
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.s
 * JD-Core Version:    0.7.0.1
 */