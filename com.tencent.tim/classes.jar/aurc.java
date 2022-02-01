import android.os.Debug;
import java.io.IOException;

public class aurc
{
  private static String[] bh = { "35872667", "354653668", "270749863", "279242625", "1849510872" };
  private static boolean djH;
  
  public static void Zx(String paramString)
  {
    if (djH) {}
    for (;;)
    {
      return;
      Object localObject = bh;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        if (localObject[i].equals(paramString))
        {
          localObject = acbn.oM + "dump_";
          try
          {
            Debug.dumpHprofData((String)localObject + paramString + System.currentTimeMillis());
            djH = true;
            return;
          }
          catch (IOException paramString)
          {
            return;
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aurc
 * JD-Core Version:    0.7.0.1
 */