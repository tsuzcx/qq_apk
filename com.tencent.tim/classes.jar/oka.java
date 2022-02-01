import UserGrowth.stSchema;
import com.tencent.common.app.BaseApplicationImpl;

public class oka
  implements ojy
{
  private ojn b(ojp paramojp)
  {
    if (rpw.isWeishiInstalled(BaseApplicationImpl.getContext())) {
      return new ojr(paramojp);
    }
    return new ojt(paramojp);
  }
  
  public ojn a(ojp paramojp)
  {
    switch (paramojp.a().type)
    {
    default: 
      return null;
    case 1: 
      return new oju(paramojp);
    case 2: 
      return b(paramojp);
    }
    return new ojx(paramojp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oka
 * JD-Core Version:    0.7.0.1
 */