package taiji;

import android.graphics.Path;
import com.tencent.token.gm;
import java.util.List;

public class u
  extends l<ao, Path>
{
  private final ao b = new ao();
  private final Path c = new Path();
  
  public u(List<o<ao>> paramList)
  {
    super(paramList);
  }
  
  public Path a(o<ao> paramo, float paramFloat)
  {
    ao localao = (ao)paramo.a;
    paramo = (ao)paramo.b;
    this.b.a(localao, paramo, paramFloat);
    gm.a(this.b, this.c);
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.u
 * JD-Core Version:    0.7.0.1
 */