package taiji;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

public class v
  extends s
{
  private final PointF b = new PointF();
  private final float[] c = new float[2];
  private u d;
  private PathMeasure e;
  
  public v(List paramList)
  {
    super(paramList);
  }
  
  public PointF a(r paramr, float paramFloat)
  {
    u localu = (u)paramr;
    Path localPath = localu.d();
    if (localPath == null) {
      return (PointF)paramr.a;
    }
    if (this.d != localu)
    {
      this.e = new PathMeasure(localPath, false);
      this.d = localu;
    }
    this.e.getPosTan(this.e.getLength() * paramFloat, this.c, null);
    this.b.set(this.c[0], this.c[1]);
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.v
 * JD-Core Version:    0.7.0.1
 */