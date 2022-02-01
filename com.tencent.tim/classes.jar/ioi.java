import com.tencent.common.app.BaseApplicationImpl;

public class ioi
{
  private static ioi a;
  
  public static ioi a()
  {
    if (a != null) {
      return a;
    }
    try
    {
      a = new ioi();
      ioi localioi = a;
      return localioi;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public float Q()
  {
    float f;
    try
    {
      f = Float.parseFloat(ijc.a(BaseApplicationImpl.getContext()).getStringValue("sharp/beauty_3/ratio", "1.0"));
      if (f <= 0.0F) {
        return 1.0F;
      }
    }
    catch (Exception localException)
    {
      return 1.0F;
    }
    return f;
  }
  
  public boolean uB()
  {
    return ijc.a(BaseApplicationImpl.getContext()).getIntValue("sharp/beauty_3/flag", 0) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ioi
 * JD-Core Version:    0.7.0.1
 */