import UserGrowth.stSchema;
import com.tencent.common.app.BaseApplicationImpl;

public class uit
  implements uir
{
  private uig b(uii paramuii)
  {
    if (zmi.a(BaseApplicationImpl.getContext())) {
      return new uik(paramuii);
    }
    return new uim(paramuii);
  }
  
  public uig a(uii paramuii)
  {
    switch (paramuii.a().type)
    {
    default: 
      return null;
    case 1: 
      return new uin(paramuii);
    case 2: 
      return b(paramuii);
    }
    return new uiq(paramuii);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uit
 * JD-Core Version:    0.7.0.1
 */