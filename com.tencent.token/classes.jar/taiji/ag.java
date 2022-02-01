package taiji;

import android.graphics.Path;
import com.tencent.token.gp;

public class ag
  extends al<ao, Path>
{
  private final Path c;
  
  Path a(ao paramao)
  {
    this.c.reset();
    gp.a(paramao, this.c);
    return this.c;
  }
  
  public l<?, Path> c()
  {
    if (!b()) {
      return new v(a((ao)this.b));
    }
    return new u(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.ag
 * JD-Core Version:    0.7.0.1
 */