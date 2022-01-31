package btmsdkobf;

import android.os.HandlerThread;
import java.util.HashMap;

public class ep
{
  private static HashMap oO = new HashMap();
  private static es.a oP;
  private static eq.a oQ = new ix();
  
  public static HandlerThread a(String paramString, int paramInt, long paramLong)
  {
    return new eo(paramString, paramInt, paramLong);
  }
  
  public static int activeCount()
  {
    return oO.size();
  }
  
  private static void dg()
  {
    if (oP == null) {
      oP = en.da();
    }
  }
  
  public static eq.a dh()
  {
    return oQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ep
 * JD-Core Version:    0.7.0.1
 */