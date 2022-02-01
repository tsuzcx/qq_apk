import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.NativeSoLoader.1;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class ankl
{
  public static boolean SP;
  private static AtomicBoolean dM = new AtomicBoolean(false);
  private static final byte[] dc = new byte[0];
  
  public static boolean bp(boolean paramBoolean)
  {
    if (!dM.get())
    {
      if (paramBoolean) {
        break label77;
      }
      dM.getAndSet(kQ("TKGLRenderer"));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TK_Config_NativeSoLoader", 2, "isisSoFileExistAsync[3D]: sInitSuccess= " + dM.get() + "  async=" + paramBoolean);
      }
      return dM.get();
      label77:
      ThreadManager.post(new NativeSoLoader.1(), 8, null, false);
    }
  }
  
  public static byte d(String paramString)
  {
    byte b = 0;
    if (paramString == null) {
      b = -1;
    }
    do
    {
      for (;;)
      {
        return b;
        paramString = zX() + "/lib" + paramString + ".so";
        if (QLog.isColorLevel()) {
          QLog.i("TK_Config_NativeSoLoader", 2, "start TKNativeSo: " + paramString);
        }
        File localFile = new File(paramString);
        if ((!SP) && (localFile.exists())) {
          try
          {
            System.load(paramString);
            if (QLog.isColorLevel())
            {
              QLog.i("TK_Config_NativeSoLoader", 2, "load " + paramString + " success!");
              return 0;
            }
          }
          catch (UnsatisfiedLinkError paramString)
          {
            if (QLog.isColorLevel()) {
              QLog.i("TK_Config_NativeSoLoader", 2, "load from tk dir failed: " + paramString.getMessage());
            }
            return -3;
          }
        }
      }
      b = -2;
    } while (!QLog.isColorLevel());
    QLog.i("TK_Config_NativeSoLoader", 2, "no tk so in ar dir");
    return -2;
  }
  
  public static boolean kQ(String paramString)
  {
    boolean bool2 = false;
    String str1 = zX() + "/lib" + paramString + ".so";
    ??? = new File(str1);
    if (QLog.isColorLevel()) {
      QLog.d("TK_Config_NativeSoLoader", 2, "isSoFileExist: exist= " + ((File)???).exists() + " isUncompressZip=" + SP);
    }
    if ((!SP) && (((File)???).exists())) {
      for (;;)
      {
        synchronized (dc)
        {
          String str2 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).getString("tk_native_" + paramString, null);
          if (str2 != null) {
            if (str2.equalsIgnoreCase(alab.getFileMD5String(str1)))
            {
              break label221;
              return bool1;
            }
            else
            {
              bool1 = bool2;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("TK_Config_NativeSoLoader", 2, "isSoFileExist: soName= " + paramString + " check md5 false!");
              bool1 = bool2;
            }
          }
        }
        label221:
        boolean bool1 = true;
      }
    }
    return false;
  }
  
  public static String zX()
  {
    File localFile = BaseApplicationImpl.sApplication.getFilesDir();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TK_Config_NativeSoLoader", 2, "getFilesDir is null");
      }
      return "";
    }
    return localFile.getParent() + "/tk";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ankl
 * JD-Core Version:    0.7.0.1
 */