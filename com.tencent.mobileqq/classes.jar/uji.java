import UserGrowth.stSchema;
import com.tencent.common.app.BaseApplicationImpl;

public class uji
  implements ujg
{
  private uiv b(uix paramuix)
  {
    if (zqd.a(BaseApplicationImpl.getContext())) {
      return new uiz(paramuix);
    }
    return new ujb(paramuix);
  }
  
  public uiv a(uix paramuix)
  {
    switch (paramuix.a().type)
    {
    default: 
      return null;
    case 1: 
      return new ujc(paramuix);
    case 2: 
      return b(paramuix);
    }
    return new ujf(paramuix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uji
 * JD-Core Version:    0.7.0.1
 */