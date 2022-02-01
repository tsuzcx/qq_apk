import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

public class ayzj
{
  private static final String[] gA = { "libimage_filter_common.so", "libimage_filter_gpu.so", "libpitu_tools.so", "libimage_filter_cpu.so", "libalgo_youtu_jni.so", "libformat_convert.so" };
  private static final String[] gz = { "art_res_cache" };
  
  static boolean aj(String paramString, int paramInt)
  {
    String str = paramString.trim();
    VideoEnvironment.k("PendantVersionManager", "checkSignatureVersionIsOK signature=" + paramString, null);
    paramString = azah.a(str);
    int i = paramString.Jm();
    VideoEnvironment.k("PendantVersionManager", "checkSignatureVersionIsOK errCode=" + i + ",trimSignature=" + str, null);
    if (i == 0)
    {
      paramString = paramString.getVersion().trim();
      VideoEnvironment.k("PendantVersionManager", "checkSignatureVersionIsOK versionValid=" + paramString, null);
      i = Integer.parseInt(paramString);
      VideoEnvironment.k("PendantVersionManager", "checkSignatureVersionIsOK version=" + i + ",limitVersion=" + paramInt, null);
      if (i >= paramInt) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean oU(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < gz.length)
      {
        if (paramString.equals(gz[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static String zt()
  {
    String str = BaseApplicationImpl.getApplication().getSharedPreferences("pendant_short_video_mgr_sp", 4).getString("pendant_sv_md5_version_soname_key", "Pendant000_0");
    boolean bool = aj(str, 2);
    VideoEnvironment.k("PendantVersionManager", "getCurrentPendantUnzipPath success=" + bool + ",md5Version=" + str, null);
    if (bool) {
      return str;
    }
    return "Pendant000_0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayzj
 * JD-Core Version:    0.7.0.1
 */