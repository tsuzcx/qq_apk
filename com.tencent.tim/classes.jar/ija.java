import android.content.Context;
import android.media.AudioManager;
import java.lang.reflect.Method;

public class ija
{
  static int anF = 0;
  static int anG = 0;
  
  public static boolean Y(Context paramContext)
  {
    try
    {
      paramContext = (AudioManager)paramContext.getSystemService("audio");
      boolean bool = Boolean.parseBoolean(paramContext.getClass().getMethod("isWiredHeadsetOn", new Class[0]).invoke(paramContext, (Object[])null).toString());
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ija
 * JD-Core Version:    0.7.0.1
 */