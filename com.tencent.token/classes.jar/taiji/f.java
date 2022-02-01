package taiji;

import com.tencent.token.gn;
import java.util.List;

public class f
  extends p<Integer>
{
  public f(List<o<Integer>> paramList)
  {
    super(paramList);
  }
  
  public Integer a(o<Integer> paramo, float paramFloat)
  {
    if ((paramo.a == null) || (paramo.b == null)) {
      throw new IllegalStateException("Missing values for keyframe.");
    }
    return Integer.valueOf(gn.a(((Integer)paramo.a).intValue(), ((Integer)paramo.b).intValue(), paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.f
 * JD-Core Version:    0.7.0.1
 */