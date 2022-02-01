import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class ipd
{
  private static int arD = -1;
  private static int arE = -1;
  private static float gM = -1.0F;
  
  public static float S()
  {
    if (gM != -1.0F) {
      return gM;
    }
    for (;;)
    {
      try
      {
        iok localiok = iok.a();
        if (localiok == null) {
          continue;
        }
        gM = localiok.R();
        if (QLog.isColorLevel()) {
          QLog.w("LowlightAndDenoiseTools", 1, "getVideodenoiseRatio[" + gM + "]");
        }
      }
      catch (Exception localException)
      {
        QLog.w("LowlightAndDenoiseTools", 1, "getVideoDenoiseRatio, Excpetion", localException);
        gM = 15.0F;
        continue;
      }
      return gM;
      gM = 15.0F;
    }
  }
  
  static boolean tJ()
  {
    return iow.a(8, 1800000, -2147483648);
  }
  
  public static boolean uJ()
  {
    if (AudioHelper.jY(12) == 1)
    {
      AudioHelper.UA(acfp.m(2131707976));
      return true;
    }
    if (AudioHelper.jY(12) == 0)
    {
      AudioHelper.UA(acfp.m(2131707978));
      return true;
    }
    if (arD == -1) {}
    for (;;)
    {
      try
      {
        localiok = iok.a();
        if (localiok == null) {
          continue;
        }
        if (!localiok.uJ()) {
          continue;
        }
        arD = 1;
        i = 1;
      }
      catch (Exception localException)
      {
        iok localiok;
        QLog.w("LowlightAndDenoiseTools", 1, "isSupportLowlight, Excpetion", localException);
        arD = 0;
        continue;
        int i = 4;
        arD = 0;
        continue;
        i = 5;
        arD = 0;
        continue;
        i = 0;
        continue;
      }
      if (arD == -1)
      {
        if (!jkn.xF()) {
          continue;
        }
        if (!tJ()) {
          continue;
        }
        i = 3;
        arD = 1;
      }
      if (QLog.isColorLevel()) {
        QLog.w("LowlightAndDenoiseTools", 1, "isSupportLowlight[" + arD + "], step[" + i + "]");
      }
      if (arD == 1) {
        break;
      }
      return false;
      if (!localiok.uK()) {
        continue;
      }
      i = 2;
      arD = 0;
    }
  }
  
  public static boolean vc()
  {
    if (AudioHelper.jY(12) == 1)
    {
      AudioHelper.UA(acfp.m(2131707975));
      return true;
    }
    if (AudioHelper.jY(12) == 0)
    {
      AudioHelper.UA(acfp.m(2131707977));
      return true;
    }
    if (arE == -1) {}
    try
    {
      localiok = iok.a();
      if (localiok == null) {
        break label187;
      }
      if (!localiok.uL()) {
        break label145;
      }
      arE = 1;
      gM = 25.0F;
      i = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        iok localiok;
        label70:
        QLog.w("LowlightAndDenoiseTools", 1, "isSupportVideoDenoiseFlag, Excpetion", localException);
        arE = 0;
        continue;
        int i = 0;
      }
    }
    if (arE == -1)
    {
      if (!tJ()) {
        break label161;
      }
      arE = 1;
    }
    for (i = 3;; i = 4)
    {
      if (QLog.isColorLevel()) {
        QLog.w("LowlightAndDenoiseTools", 1, "isSupportVideoDenoiseFlag[" + arE + "], step[" + i + "]");
      }
      if (arE == 1) {
        break;
      }
      return false;
      label145:
      if (!localiok.uM()) {
        break label187;
      }
      arE = 0;
      i = 2;
      break label70;
      label161:
      arE = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ipd
 * JD-Core Version:    0.7.0.1
 */