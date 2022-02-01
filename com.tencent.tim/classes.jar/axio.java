import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class axio
{
  public static String HO()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(localDate);
  }
  
  public static HashMap<String, String> a(HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2)
  {
    paramHashMap1 = new HashMap(paramHashMap1);
    Iterator localIterator = paramHashMap2.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramHashMap1.put(str, paramHashMap2.get(str));
    }
    return paramHashMap1;
  }
  
  public static boolean aOG()
  {
    if (axis.a().ay("sp_key_ae_camera_launch_mark", 0)) {
      return false;
    }
    axis.a().n("sp_key_ae_camera_launch_mark", true, 0);
    return true;
  }
  
  public static void aoV()
  {
    axis.a().aY("AEKIT_CAMERA_FIRST_LAUNCH", 1, 0);
  }
  
  public static String d(Long paramLong)
  {
    float f = (float)paramLong.longValue() / 1000.0F;
    return new DecimalFormat("0.00").format(f);
  }
  
  public static String fi(int paramInt)
  {
    if (paramInt == 1) {
      return "1";
    }
    return "2";
  }
  
  public static boolean uU()
  {
    boolean bool = false;
    if (axis.a().l("AEKIT_CAMERA_FIRST_LAUNCH", 0, 0) == 0) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axio
 * JD-Core Version:    0.7.0.1
 */