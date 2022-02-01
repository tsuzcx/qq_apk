package taiji;

import com.tencent.token.gp;
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
    if ((paramo.a != null) && (paramo.b != null)) {
      return Integer.valueOf(gp.a(((Integer)paramo.a).intValue(), ((Integer)paramo.b).intValue(), paramFloat));
    }
    throw new IllegalStateException("Missing values for keyframe.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.f
 * JD-Core Version:    0.7.0.1
 */