import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.HashMap;

public class anfv
{
  public static void UL(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("MANUFACTURER", Build.MANUFACTURER);
    localHashMap.put("MODEL", Build.MODEL);
    localHashMap.put("SDK_INT", "" + Build.VERSION.SDK_INT);
    localHashMap.put("waite", "" + paramInt);
    anpc.a(VideoEnvironment.getContext()).collectPerformance(null, "sv_waite_record_count", true, 0L, 0L, localHashMap, "");
  }
  
  private static void aE(String paramString, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("MANUFACTURER", Build.MANUFACTURER);
    localHashMap.put("MODEL", Build.MODEL);
    localHashMap.put("SDK_INT", "" + Build.VERSION.SDK_INT);
    localHashMap.put("type", "" + paramInt1);
    localHashMap.put("error", "" + paramInt2);
    anpc.a(VideoEnvironment.getContext()).collectPerformance(null, paramString, true, 0L, 0L, localHashMap, "");
  }
  
  public static void aS(String paramString, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("MANUFACTURER", Build.MANUFACTURER);
    localHashMap.put("MODEL", Build.MODEL);
    localHashMap.put("SDK_INT", "" + Build.VERSION.SDK_INT);
    localHashMap.put("cost", "" + paramLong);
    anpc.a(VideoEnvironment.getContext()).collectPerformance(null, paramString, true, 0L, 0L, localHashMap, "");
  }
  
  public static void jw(int paramInt1, int paramInt2)
  {
    aE("sv_resource_download_base", paramInt1, paramInt2);
  }
  
  public static void jx(int paramInt1, int paramInt2)
  {
    aE("sv_resource_download_qzone", paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anfv
 * JD-Core Version:    0.7.0.1
 */