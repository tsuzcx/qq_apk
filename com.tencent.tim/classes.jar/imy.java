import com.tencent.av.gameplay.GPNativeSoLoader.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class imy
{
  public static boolean SP;
  private static boolean isLoadSo;
  
  public static byte b(String paramString)
  {
    byte b = 0;
    if (paramString == null) {
      return -1;
    }
    imz localimz = imz.a();
    String str = inf.getSoDir() + "lib" + paramString + ".so";
    if (QLog.isColorLevel()) {
      QLog.i("Qav_GamePlayNativeSoLoader", 2, "start arNativeSo: " + str);
    }
    Object localObject = new File(str);
    if ((!SP) && (((File)localObject).exists())) {}
    for (;;)
    {
      try
      {
        System.load(str);
        isLoadSo = true;
        localObject = "null";
        if (localimz != null) {
          localObject = localimz.MD5_zip_so;
        }
        QLog.w("Qav_GamePlayNativeSoLoader", 1, "loadGamePlayNativeSo, libPath[" + str + "], libName[" + paramString + "], md5[" + (String)localObject + "], isLoadSo[" + isLoadSo + "], result[" + b + "]");
        return b;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        b = -3;
        QLog.i("Qav_GamePlayNativeSoLoader", 1, "loadGamePlayNativeSo load fail", localUnsatisfiedLinkError);
        continue;
      }
      b = -2;
    }
  }
  
  public static boolean ue()
  {
    if (isLoadSo) {}
    do
    {
      return true;
      if (!ina.a().ug()) {
        break;
      }
    } while (b("qavgameplayengine") == 0);
    return false;
    ThreadManager.getUIHandler().post(new GPNativeSoLoader.1());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     imy
 * JD-Core Version:    0.7.0.1
 */