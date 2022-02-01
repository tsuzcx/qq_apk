import com.tencent.common.app.BaseApplicationImpl;

public class ioj
{
  private static ioj a;
  int aqR = 0;
  
  public static ioj a()
  {
    try
    {
      ioj localioj;
      if (a != null)
      {
        localioj = a;
        return localioj;
      }
      return null;
    }
    finally
    {
      try
      {
        a = new ioj();
        localioj = a;
        return localioj;
      }
      catch (Exception localException) {}
      localObject = finally;
    }
  }
  
  public boolean tw()
  {
    boolean bool = false;
    if (ijc.a(BaseApplicationImpl.getContext()).getIntValue("sharp/qavGestureConfig/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean uC()
  {
    boolean bool = false;
    if (ijc.a(BaseApplicationImpl.getContext()).getIntValue("sharp/EffectFilterDeviceConfig/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean uD()
  {
    boolean bool = false;
    if (ijc.a(BaseApplicationImpl.getContext()).getIntValue("sharp/qavRedbagConfig/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean uE()
  {
    boolean bool = false;
    if (ijc.a(BaseApplicationImpl.getContext()).getIntValue("sharp/qavScreenRecoder/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean uF()
  {
    boolean bool = false;
    if (ijc.a(BaseApplicationImpl.getContext()).getIntValue("sharp/EffectFaceDeviceConfig/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean uG()
  {
    return ijc.a(BaseApplicationImpl.getContext()).getIntValue("sharp/EffectFaceDeviceConfig/enable", 0) == 1;
  }
  
  public boolean uH()
  {
    return ijc.a(BaseApplicationImpl.getContext()).getIntValue("sharp/CameraFocusMethod/isUseSelfDev", 0) == 1;
  }
  
  public boolean uI()
  {
    return 1 == ijc.a(BaseApplicationImpl.getContext()).getIntValue("sharp/EffectFaceDetectInversion/Inversion", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ioj
 * JD-Core Version:    0.7.0.1
 */