import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;

public class lgj
{
  private static int aOF;
  private static int aOG;
  private static int aOH;
  private static int aOI;
  private static int aOJ;
  private static long ub;
  
  public static boolean Cc()
  {
    return aOF == 1;
  }
  
  public static boolean Cd()
  {
    return aOG == 1;
  }
  
  public static boolean Ce()
  {
    return aOH == 1;
  }
  
  public static boolean Cf()
  {
    return aOI == 1;
  }
  
  public static boolean Cg()
  {
    return aOJ == 1;
  }
  
  public static long cE()
  {
    if (ub > 0L) {
      return ub;
    }
    return 10000L;
  }
  
  public static void updateConfig()
  {
    aOF = Aladdin.getConfig(293).getIntegerFromString("reportOn", 0);
    aOG = Aladdin.getConfig(293).getIntegerFromString("lifoOn", 0);
    aOH = Aladdin.getConfig(293).getIntegerFromString("renderFirst", 0);
    aOI = Aladdin.getConfig(293).getIntegerFromString("decodeHttpStream", 0);
    aOJ = Aladdin.getConfig(293).getIntegerFromString("bitmapOpt", 0);
    ub = Aladdin.getConfig(293).getIntegerFromString("monitorTime", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lgj
 * JD-Core Version:    0.7.0.1
 */