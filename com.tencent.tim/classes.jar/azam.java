import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import com.tencent.maxvideo.common.GlobalInit;
import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class azam
{
  public static Context F = ;
  public static int SCREEN_HEIGHT = 1;
  public static int SCREEN_WIDTH;
  public static String cdR;
  private static String cdS;
  private static String cdT;
  private static String cdU;
  private static String cdV;
  private static String cdW;
  public static int dGc = 640;
  public static int dGd = 480;
  public static final int[] ns = { 960, 640 };
  public static final int[] nt = { 720, 480 };
  public static final int[] nu = { 720, 540, 640, 480, 480, 360, 320, 240 };
  public static final int[] nv = { 1, 1, 0 };
  public static final int[] nw = { 1, 0, 0 };
  public static final int[] nx = { 1, 1, 0 };
  public static final int[] ny = { 1280, 800 };
  public static final int[] nz = { 720, 480 };
  public static long sUin = -1L;
  
  static
  {
    SCREEN_WIDTH = 1;
  }
  
  public static void ahH()
  {
    try
    {
      AudioManager localAudioManager = (AudioManager)VideoEnvironment.getContext().getSystemService("audio");
      int j = localAudioManager.requestAudioFocus(null, 3, 2);
      int i = j;
      if (j == 0) {
        i = localAudioManager.requestAudioFocus(null, 3, 1);
      }
      if (i == 0) {
        localAudioManager.requestAudioFocus(null, 3, 3);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void ahI()
  {
    try
    {
      ((AudioManager)VideoEnvironment.getContext().getSystemService("audio")).abandonAudioFocus(null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static boolean c(long paramLong, Context paramContext)
  {
    if (paramLong <= 0L) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            bool1 = aqhq.aCJ();
            if (!bool1)
            {
              if (QLog.isColorLevel()) {
                QLog.e("initDirs", 2, "hasSDCardAndWritable = false");
              }
              return bool1;
            }
            paramContext = azce.a().JE;
            if (!TextUtils.isEmpty(paramContext)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("initDirs", 2, "sdcardDirPath = empty");
          return false;
          if (QLog.isColorLevel()) {
            QLog.e("initDirs", 2, "sdcardDirPath:storeVideoPath=" + paramContext);
          }
          localFile = new File(paramContext);
          if ((localFile.exists()) && (localFile.isDirectory()) && (localFile.canWrite())) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("initDirs", 2, "exists OR isDirectory OR canWrite = false");
        return false;
        cdR = paramContext + File.separator + "trimvideo";
        File localFile = new File(cdR);
        bool1 = localFile.mkdirs();
        bool2 = localFile.isDirectory();
        if (QLog.isColorLevel()) {
          QLog.e("initDirs", 2, "trimVideoFilesDirPath:mkd=" + bool1 + " isdir=" + bool2);
        }
      } while ((!bool1) && (!bool2));
      cdV = paramContext + "/Product";
      cdU = paramContext + "/Material";
      cdW = cdU + "/ProcessedMaterial";
      cdS = paramContext + "/log.txt";
      cdT = paramContext + File.separator + "Source";
      paramContext = new File(cdT);
      bool1 = paramContext.mkdirs();
      bool2 = paramContext.isDirectory();
      if (QLog.isColorLevel()) {
        QLog.e("initDirs", 2, "avSourceFilesDirPath:mkd=" + bool1 + " isdir=" + bool2);
      }
    } while ((!bool1) && (!bool2));
    return true;
  }
  
  public static void unInit()
  {
    GlobalInit.nativeSyncProcessMsg(new MessageStruct(7), null, null);
    sUin = -1L;
  }
  
  public static String zR()
  {
    return cdT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     azam
 * JD-Core Version:    0.7.0.1
 */