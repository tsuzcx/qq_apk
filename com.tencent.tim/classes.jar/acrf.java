import android.annotation.SuppressLint;
import android.util.Pair;
import java.util.HashMap;
import java.util.Map;

public class acrf
{
  private static Object cJ = new Object();
  private static Map<Integer, Pair<String, Integer>> jw;
  
  public static Map<Integer, Pair<String, Integer>> af()
  {
    if (jw == null) {}
    synchronized (cJ)
    {
      if (jw == null) {
        cNZ();
      }
      return jw;
    }
  }
  
  @SuppressLint({"UseSparseArrays"})
  private static void cNZ()
  {
    jw = new HashMap();
    jw.put(Integer.valueOf(193), Pair.create("video_processor", Integer.valueOf(9002)));
    jw.put(Integer.valueOf(734), Pair.create("video_processor", Integer.valueOf(9003)));
    jw.put(Integer.valueOf(524), Pair.create("discuss_update_processor", Integer.valueOf(9010)));
    jw.put(Integer.valueOf(736), Pair.create("info_update_processor", Integer.valueOf(9011)));
    jw.put(Integer.valueOf(526), Pair.create("slave_master_processor", Integer.valueOf(9012)));
  }
  
  public static String dC(int paramInt)
  {
    return (String)((Pair)jw.get(Integer.valueOf(paramInt))).first;
  }
  
  public static int gH(int paramInt)
  {
    return ((Integer)((Pair)jw.get(Integer.valueOf(paramInt))).second).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acrf
 * JD-Core Version:    0.7.0.1
 */