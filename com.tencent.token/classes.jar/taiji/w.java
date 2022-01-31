package taiji;

import com.tencent.token.it;
import java.util.List;

public class w
  extends s
{
  public w(List paramList)
  {
    super(paramList);
  }
  
  public bs a(r paramr, float paramFloat)
  {
    if ((paramr.a == null) || (paramr.b == null)) {
      throw new IllegalStateException("Missing values for keyframe.");
    }
    bs localbs = (bs)paramr.a;
    paramr = (bs)paramr.b;
    return new bs(it.a(localbs.a(), paramr.a(), paramFloat), it.a(localbs.b(), paramr.b(), paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.w
 * JD-Core Version:    0.7.0.1
 */