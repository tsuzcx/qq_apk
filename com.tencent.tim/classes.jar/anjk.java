import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class anjk
{
  public static void UZ(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("MANUFACTURER", Build.MANUFACTURER);
    localHashMap.put("MODEL", Build.MODEL);
    localHashMap.put("SDK_INT", "" + Build.VERSION.SDK_INT);
    localHashMap.put("crashKind", "" + paramInt);
    anpc.a(VideoEnvironment.getContext()).collectPerformance(null, "sv_filter_egl_crash_exp", true, 0L, 0L, localHashMap, "");
  }
  
  public static void aT(String paramString, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("MANUFACTURER", Build.MANUFACTURER);
    localHashMap.put("MODEL", Build.MODEL);
    localHashMap.put("SDK_INT", "" + Build.VERSION.SDK_INT);
    localHashMap.put("time", "" + paramLong);
    localHashMap.put("filter_id", anjl.cem);
    localHashMap.put("front_camera", String.valueOf(anjl.cHs));
    anpc.a(VideoEnvironment.getContext()).collectPerformance(null, paramString, true, paramLong, anhm.dGc, localHashMap, "");
    if (QLog.isColorLevel()) {
      QLog.d("PerformenceDataTag", 2, "reportPerformance : tag = " + paramString + " ; duration = " + paramLong + " ; filter_id = " + anjl.cem + " ; front_camera = " + anjl.cHs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anjk
 * JD-Core Version:    0.7.0.1
 */