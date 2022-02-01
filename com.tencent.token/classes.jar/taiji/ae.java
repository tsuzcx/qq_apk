package taiji;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

public class ae
  implements ak<PointF>
{
  private final List<r> a = new ArrayList();
  private PointF b = new PointF(0.0F, 0.0F);
  
  public p<PointF> a()
  {
    if (!b()) {
      return new v(this.b);
    }
    return new s(this.a);
  }
  
  public boolean b()
  {
    return this.a.isEmpty() ^ true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initialPoint=");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.ae
 * JD-Core Version:    0.7.0.1
 */