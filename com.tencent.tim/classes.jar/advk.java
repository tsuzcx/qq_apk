import android.os.Environment;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class advk
{
  public static String bvF = "";
  public static String bvG = "";
  public static String bvH = "";
  
  static
  {
    int i = 0;
    try
    {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      i = bool;
    }
    catch (Throwable localThrowable)
    {
      label28:
      File localFile;
      break label28;
    }
    if (i != 0) {}
    for (localFile = new File(acbn.SDCARD_PATH);; localFile = BaseApplicationImpl.getApplication().getCacheDir())
    {
      bvG = new File(localFile, "AR_MAP").getAbsolutePath();
      bvF = new File(localFile, "res_precover").getAbsolutePath();
      bvH = new File(bvG, "preload_map").getAbsolutePath();
      return;
    }
  }
  
  public static String sX()
  {
    return bvG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     advk
 * JD-Core Version:    0.7.0.1
 */