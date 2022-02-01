import android.os.Build.VERSION;
import android.os.Process;

public class anmb
{
  private static Boolean aD;
  
  public static boolean is64Bit()
  {
    if (aD == null)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        break label28;
      }
      aD = Boolean.valueOf(false);
    }
    for (;;)
    {
      return aD.booleanValue();
      label28:
      if (Build.VERSION.SDK_INT >= 23) {
        aD = Boolean.valueOf(Process.is64Bit());
      } else {
        aD = Boolean.valueOf(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anmb
 * JD-Core Version:    0.7.0.1
 */