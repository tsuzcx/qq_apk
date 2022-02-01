import java.util.HashMap;

public class adfv
{
  public static String bsD;
  public static String bsE;
  public static String bsF;
  public static String bsG;
  private static int cEW;
  private static int cEX;
  public static HashMap<String, adfg> ju = new HashMap();
  
  static
  {
    cEW = 5;
    cEX = 1;
    bsD = "";
    bsE = "";
    bsF = "";
    bsG = "";
    ju.put("recogQ3", new adfg(2147483647));
    ju.put("recogQ4", new adfg(2147483647));
    ju.put("recogQ5", new adfg(2147483647));
    ju.put("trackQ3", new adfg(2147483647));
    ju.put("trackQ4", new adfg(2147483647));
    ju.put("trackQ5", new adfg(2147483647));
    ju.put("renderQ1", new adfg(2147483647));
    ju.put("renderQ0", new adfg(2147483647));
    ju.put("glRenderQ1", new adfg(2147483647));
    ju.put("glRenderQ0", new adfg(2147483647));
    ju.put("camRenderQ0", new adfg(2147483647));
    ju.put("modelRenderQ1", new adfg(2147483647));
    ju.put("modelRenderQ0", new adfg(2147483647));
  }
  
  public static void D(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    bsD = paramString1;
    bsE = paramString2;
    bsF = paramString3;
    bsG = paramString4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adfv
 * JD-Core Version:    0.7.0.1
 */