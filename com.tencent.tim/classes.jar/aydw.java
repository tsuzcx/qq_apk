import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aydw
{
  public static String azs;
  
  public static boolean b(long paramLong, Context paramContext)
  {
    azs = aceh.oM + "QQEditPic" + File.separator;
    paramContext = new File(azs);
    boolean bool1 = paramContext.mkdirs();
    boolean bool2 = paramContext.isDirectory();
    if (QLog.isColorLevel()) {
      QLog.e("initDirs", 2, "thumbFilesDirPath=" + bool1 + " isdir=" + bool2);
    }
    return (bool1) || (bool2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aydw
 * JD-Core Version:    0.7.0.1
 */