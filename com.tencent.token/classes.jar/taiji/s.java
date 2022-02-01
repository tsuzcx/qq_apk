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
    Object localObject = (r)paramo;
    Path localPath = ((r)localObject).d();
    if (localPath == null) {
      return (PointF)paramo.a;
    }
    if (this.d != localObject)
    {
      this.e = new PathMeasure(localPath, false);
      this.d = ((r)localObject);
    }
    paramo = this.e;
    paramo.getPosTan(paramFloat * paramo.getLength(), this.c, null);
    paramo = this.b;
    localObject = this.c;
    paramo.set(localObject[0], localObject[1]);
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.s
 * JD-Core Version:    0.7.0.1
 */