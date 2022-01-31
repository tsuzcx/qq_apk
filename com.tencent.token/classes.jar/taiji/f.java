package taiji;

import com.tencent.token.it;
import java.util.List;

public class f
  extends s
{
  public f(List paramList)
  {
    super(paramList);
  }
  
  public Integer a(r paramr, float paramFloat)
  {
    if ((paramr.a == null) || (paramr.b == null)) {
      throw new IllegalStateException("Missing values for keyframe.");
    }
    return Integer.valueOf(it.a(((Integer)paramr.a).intValue(), ((Integer)paramr.b).intValue(), paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.f
 * JD-Core Version:    0.7.0.1
 */