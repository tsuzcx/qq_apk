import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ahfv
{
  private static final String bKo = acbn.SDCARD_ROOT + File.separator + "qflutter";
  private static final String bKp = BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath() + File.separator + "qflutter-so" + File.separator;
  
  public static boolean anf()
  {
    return false;
  }
  
  public static void dnl()
  {
    if (ahbj.isFileExists(bKo))
    {
      int i = aqhq.a(bKo, bKp, false, true, true);
      if (i == 0)
      {
        QLog.d("QFlutter.launcher", 4, String.format("checkDebugInstall copy result: %s", new Object[] { Integer.valueOf(i) }));
        File[] arrayOfFile = new File(bKp).listFiles();
        int j = arrayOfFile.length;
        i = 0;
        while (i < j)
        {
          File localFile = arrayOfFile[i];
          QLog.d("QFlutter.launcher", 4, String.format("path: %s, time: %s, size: %s byte", new Object[] { localFile.getAbsolutePath(), Long.valueOf(localFile.lastModified()), Long.valueOf(localFile.length()) }));
          i += 1;
        }
        ahfz.a().c(true, bKp, true, true);
        return;
      }
    }
    ahfz.a().c(false, bKp, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahfv
 * JD-Core Version:    0.7.0.1
 */