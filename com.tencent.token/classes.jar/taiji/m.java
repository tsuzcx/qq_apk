package taiji;

import com.tencent.token.gl;
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
    if ((paramo.a == null) || (paramo.b == null)) {
      throw new IllegalStateException("Missing values for keyframe.");
    }
    return Integer.valueOf(gl.a(paramFloat, ((Integer)paramo.a).intValue(), ((Integer)paramo.b).intValue()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.m
 * JD-Core Version:    0.7.0.1
 */