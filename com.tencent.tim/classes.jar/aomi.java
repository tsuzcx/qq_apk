import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;

public class aomi
{
  public static aomi a;
  
  public static aomi a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aomi();
      }
      return a;
    }
    finally {}
  }
  
  public String getApnType()
  {
    try
    {
      String str = AppNetConnInfo.getCurrentAPN();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getNetType()
  {
    return aqiw.getSystemNetwork(BaseApplication.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aomi
 * JD-Core Version:    0.7.0.1
 */