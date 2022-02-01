import com.tencent.common.app.BaseApplicationImpl;

public class iok
{
  private static iok a;
  
  public static iok a()
  {
    if (a != null) {
      return a;
    }
    try
    {
      a = new iok();
      iok localiok = a;
      return localiok;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public float R()
  {
    try
    {
      float f1 = Float.parseFloat(ijc.a(BaseApplicationImpl.getContext()).getStringValue("sharp/lowlight_denoise/videodenoiseratio", "15.0"));
      float f2;
      if (f1 <= 0.0D) {
        f2 = 0.0F;
      }
      do
      {
        return f2;
        f2 = f1;
      } while (f1 < 30.0D);
      return 30.0F;
    }
    catch (Exception localException) {}
    return 15.0F;
  }
  
  public boolean uJ()
  {
    return ijc.a(BaseApplicationImpl.getContext()).getIntValue("sharp/lowlight_denoise/lowlightflag", 0) == 1;
  }
  
  public boolean uK()
  {
    boolean bool = false;
    if (ijc.a(BaseApplicationImpl.getContext()).getIntValue("sharp/lowlight_denoise/lowlightflag", 0) == -1) {
      bool = true;
    }
    return bool;
  }
  
  public boolean uL()
  {
    return ijc.a(BaseApplicationImpl.getContext()).getIntValue("sharp/lowlight_denoise/videodenoiseflag", 0) == 1;
  }
  
  public boolean uM()
  {
    boolean bool = false;
    if (ijc.a(BaseApplicationImpl.getContext()).getIntValue("sharp/lowlight_denoise/videodenoiseflag", 0) == -1) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iok
 * JD-Core Version:    0.7.0.1
 */