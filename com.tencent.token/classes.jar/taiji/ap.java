package taiji;

import android.graphics.Path;
import com.tencent.token.it;

public class ap
  extends aw
{
  private final Path c;
  
  Path a(az paramaz)
  {
    this.c.reset();
    it.a(paramaz, this.c);
    return this.c;
  }
  
  public n c()
  {
    if (!b()) {
      return new y(a((az)this.b));
    }
    return new x(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.ap
 * JD-Core Version:    0.7.0.1
 */