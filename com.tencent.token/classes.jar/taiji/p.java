package taiji;

import com.tencent.token.ir;
import java.util.List;

public class p
  extends s
{
  public p(List paramList)
  {
    super(paramList);
  }
  
  public Integer a(r paramr, float paramFloat)
  {
    if ((paramr.a == null) || (paramr.b == null)) {
      throw new IllegalStateException("Missing values for keyframe.");
    }
    return Integer.valueOf(ir.a(paramFloat, ((Integer)paramr.a).intValue(), ((Integer)paramr.b).intValue()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.p
 * JD-Core Version:    0.7.0.1
 */