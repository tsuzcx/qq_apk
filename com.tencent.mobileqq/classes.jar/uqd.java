import UserGrowth.stSchema;
import com.tencent.common.app.BaseApplicationImpl;

public class uqd
  implements uqb
{
  private upq b(ups paramups)
  {
    if (yqu.a(BaseApplicationImpl.getContext())) {
      return new upu(paramups);
    }
    return new upw(paramups);
  }
  
  public upq a(ups paramups)
  {
    switch (paramups.a().type)
    {
    default: 
      return null;
    case 1: 
      return new upx(paramups);
    case 2: 
      return b(paramups);
    }
    return new uqa(paramups);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uqd
 * JD-Core Version:    0.7.0.1
 */