package taiji;

import com.tencent.token.it;
import java.util.List;

public class q
  extends s
{
  public q(List paramList)
  {
    super(paramList);
  }
  
  public Float a(r paramr, float paramFloat)
  {
    if ((paramr.a == null) || (paramr.b == null)) {
      throw new IllegalStateException("Missing values for keyframe.");
    }
    return Float.valueOf(it.a(((Float)paramr.a).floatValue(), ((Float)paramr.b).floatValue(), paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.q
 * JD-Core Version:    0.7.0.1
 */