import android.os.Build;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QzoneHardwareRestriction;

public class awcq
{
  private static awcq a;
  private static final String cPf = QzoneConfig.getInstance().getConfig("QZoneSetting", "PictureViewerPhotoDanmakuBlackList", "");
  private static final int eAc = QzoneConfig.getInstance().getConfig("QZoneSetting", "PictureViewerPhotoDanmakuCpuLevel", 1);
  private static final int eAd = QzoneConfig.getInstance().getConfig("QZoneSetting", "PictureViewerPhotoDanmakuMemoryLevel", 1);
  private volatile boolean KJ;
  private volatile String cPg;
  private long dH = -1L;
  
  public awcq()
  {
    if (this.dH == -1L) {
      this.dH = (QzoneHardwareRestriction.getTotalMem() / 1024L);
    }
  }
  
  public static awcq a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new awcq();
      }
      return a;
    }
    finally {}
  }
  
  private boolean aF(String paramString)
  {
    try
    {
      String str = Build.MODEL;
      if ((str == null) || (str.length() == 0))
      {
        QZLog.i("PhotoDanmakuUtil", 1, "buildModel is empty, hide PhotoDanmaku .命中禁止大图浮层策略");
        return true;
      }
      if (QZLog.isColorLevel()) {
        QZLog.d("PhotoDanmakuUtil", 2, "buildModel is '" + str + "'");
      }
      if ((paramString == null) || (paramString.length() == 0)) {
        break label150;
      }
      str = "," + str + ",";
      if (("," + paramString + ",").contains(str))
      {
        QZLog.i("PhotoDanmakuUtil", 1, "命中禁止大图浮层策略");
        return true;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      return false;
    }
    return false;
    label150:
    return false;
  }
  
  public boolean aMj()
  {
    if ((cPf != null) && (!cPf.equals(this.cPg))) {
      if (aF(cPf)) {
        break label64;
      }
    }
    label64:
    for (boolean bool = true;; bool = false)
    {
      this.KJ = bool;
      this.cPg = cPf;
      if ((!this.KJ) || (!QzoneHardwareRestriction.meetHardwareRestriction(eAd, eAc))) {
        break;
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awcq
 * JD-Core Version:    0.7.0.1
 */