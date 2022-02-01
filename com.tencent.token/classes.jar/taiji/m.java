package taiji;

import com.tencent.token.gk;
import java.util.List;

public class m
  extends p<Integer>
{
  public m(List<o<Integer>> paramList)
  {
    super(paramList);
  }
  
  public Integer a(o<Integer> paramo, float paramFloat)
  {
    if ((paramo.a != null) && (paramo.b != null)) {
      return Integer.valueOf(gk.a(paramFloat, ((Integer)paramo.a).intValue(), ((Integer)paramo.b).intValue()));
    }
    throw new IllegalStateException("Missing values for keyframe.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.m
 * JD-Core Version:    0.7.0.1
 */