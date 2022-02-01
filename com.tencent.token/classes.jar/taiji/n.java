package taiji;

import com.tencent.token.gm;
import java.util.List;

public class n
  extends p<Float>
{
  public n(List<o<Float>> paramList)
  {
    super(paramList);
  }
  
  public Float a(o<Float> paramo, float paramFloat)
  {
    if ((paramo.a == null) || (paramo.b == null)) {
      throw new IllegalStateException("Missing values for keyframe.");
    }
    return Float.valueOf(gm.a(((Float)paramo.a).floatValue(), ((Float)paramo.b).floatValue(), paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.n
 * JD-Core Version:    0.7.0.1
 */