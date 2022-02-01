import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class aszy
{
  public static boolean dgS;
  
  public static boolean aIU()
  {
    Object localObject = DeviceProfileManager.a().jf(DeviceProfileManager.DpcNames.vip_individuation.name());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject != null) && (localObject.length >= 2) && (!"0".equals(localObject[1]))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean cv(Context paramContext)
  {
    boolean bool = aIU();
    if ((!dgS) && (bool)) {
      dgS = AVSoUtils.ayu();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSharpPUtil", 2, "isSharpPAvaliable: " + dgS);
    }
    return (dgS) && (bool);
  }
  
  public static File f(File paramFile)
  {
    File localFile = new File(paramFile.getAbsolutePath() + ".shp");
    if (paramFile.exists()) {
      paramFile.renameTo(localFile);
    }
    return localFile;
  }
  
  public static String y(File paramFile)
  {
    return paramFile.getAbsolutePath() + ".shp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aszy
 * JD-Core Version:    0.7.0.1
 */