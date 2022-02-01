import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.io.File;
import java.text.SimpleDateFormat;

public class adcs
{
  public static boolean adD()
  {
    return (Build.VERSION.SDK_INT >= 18) && (adfw.a().bMJ) && (!Build.MODEL.equalsIgnoreCase("CAM-TL00"));
  }
  
  public static String sh()
  {
    String str = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();
    return str + "/Camera/ARVideoRecord.tmp";
  }
  
  public static String si()
  {
    String str = ShortVideoUtils.getCameraPath();
    str = str + new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Long.valueOf(System.currentTimeMillis()));
    str = str + jgn.RT;
    File localFile = new File(str).getParentFile();
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adcs
 * JD-Core Version:    0.7.0.1
 */