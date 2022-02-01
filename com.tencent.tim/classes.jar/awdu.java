import android.os.Build;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QzoneHardwareRestriction;

public class awdu
{
  public static final int bpx = QzoneConfig.getInstance().getConfig("PhotoUpload", "secondary_gif_delay", 200);
  public static final int eAj = QzoneConfig.getInstance().getConfig("PhotoUpload", "createGifLowDeviceSize", 720);
  public static final int eAk = QzoneConfig.getInstance().getConfig("PhotoUpload", "createGifMiddleDeviceSize", 720);
  public static final int eAl = QzoneConfig.getInstance().getConfig("PhotoUpload", "createGifHighDeviceSize", 720);
  public static final int eAm = QzoneConfig.getInstance().getConfig("PhotoUpload", "secondary_gif_size_limit", 64);
  public static final int eAn = QzoneConfig.getInstance().getConfig("PhotoUpload", "secondary_gif_max_speed", 20);
  public static final int eAo = QzoneConfig.getInstance().getConfig("PhotoUpload", "secondary_gif_min_multiple_speed", 3);
  private static int eAp = -1;
  
  public static int PZ()
  {
    int i = 2;
    if (QzoneHardwareRestriction.meetHardwareRestriction(2, 2)) {
      i = 3;
    }
    while (QzoneHardwareRestriction.meetHardwareRestriction(1, 1)) {
      return i;
    }
    return 1;
  }
  
  public static int Qa()
  {
    int i = PZ();
    if (i == 1) {
      return eAj;
    }
    if (i == 2) {
      return eAk;
    }
    if (i == 3) {
      return eAl;
    }
    return 720;
  }
  
  public static boolean aMt()
  {
    if (eAp >= 0) {
      return eAp == 1;
    }
    String[] arrayOfString = QzoneConfig.getInstance().getConfig("QZoneSetting", "GenerateGifBlackList", "X9007,MI 2C,A0001").split(",");
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (Build.MODEL.equalsIgnoreCase(str))
      {
        eAp = 1;
        return true;
      }
      i += 1;
    }
    eAp = 0;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awdu
 * JD-Core Version:    0.7.0.1
 */