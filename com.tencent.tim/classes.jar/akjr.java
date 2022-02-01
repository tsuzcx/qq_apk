import java.util.List;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.NearbyPeople;

public class akjr
{
  public static List<oidb_0x8dd.NearbyPeople> DW;
  public static String bTA = "0";
  
  public static void O(String paramString, List<oidb_0x8dd.NearbyPeople> paramList)
  {
    DW = paramList;
    bTA = paramString;
  }
  
  public static List<oidb_0x8dd.NearbyPeople> fL()
  {
    return DW;
  }
  
  public static String xE()
  {
    return bTA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akjr
 * JD-Core Version:    0.7.0.1
 */