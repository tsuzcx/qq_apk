package taiji;

import com.tencent.token.gm;
import java.util.List;

public class t
  extends p<az>
{
  public t(List<o<az>> paramList)
  {
    super(paramList);
  }
  
  public az a(o<az> paramo, float paramFloat)
  {
    if ((paramo.a != null) && (paramo.b != null))
    {
      az localaz = (az)paramo.a;
      paramo = (az)paramo.b;
      return new az(gm.a(localaz.a(), paramo.a(), paramFloat), gm.a(localaz.b(), paramo.b(), paramFloat));
    }
    throw new IllegalStateException("Missing values for keyframe.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.t
 * JD-Core Version:    0.7.0.1
 */