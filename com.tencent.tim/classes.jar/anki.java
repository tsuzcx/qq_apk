import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class anki
{
  public static anki a;
  public int dIK = 1;
  public int dIL = 1;
  public int dIM = 1;
  public int dIN = 1;
  public int dIO = 1;
  public int dIP = -1;
  public int dIQ = 1;
  public int dIR = 6000;
  public int dIS = 1;
  public int dIT = 0;
  public int dIU = 3;
  public int dIV = 0;
  public int dIW = 0;
  public int dIX = 1;
  public int dIY = 0;
  public int dIZ = 1;
  public int dJa = 1;
  public int dJb = 1;
  public int dJc = 1;
  public int dJd = 1;
  public int dJe = -1;
  public int dJf = -1;
  public float zP = 1.0F;
  
  public static int JL()
  {
    anki localanki = a();
    if (localanki != null) {
      return localanki.dIP;
    }
    return -1;
  }
  
  public static int JM()
  {
    anki localanki = a();
    if (localanki != null) {
      return localanki.dIR;
    }
    return 6000;
  }
  
  public static int JN()
  {
    anki localanki = a();
    if (localanki != null) {
      return localanki.dIU;
    }
    return 3;
  }
  
  public static int JO()
  {
    int j = 1;
    anki localanki = a();
    int i = j;
    if (localanki != null)
    {
      i = localanki.dJd;
      if (i != 1) {
        return i;
      }
      i = j;
      if (ankj.axR()) {
        i = 2;
      }
    }
    return i;
    return i;
  }
  
  public static int JP()
  {
    anki localanki = a();
    if (localanki != null) {
      return localanki.dJe;
    }
    return -1;
  }
  
  public static int JQ()
  {
    anki localanki = a();
    if (localanki != null) {
      return localanki.dJf;
    }
    return -1;
  }
  
  public static anki a()
  {
    if (a == null) {
      a = b();
    }
    return a;
  }
  
  public static boolean ahh()
  {
    anki localanki = a();
    return (localanki != null) && (localanki.dIK == 1);
  }
  
  public static boolean axG()
  {
    anki localanki = a();
    return (localanki != null) && (localanki.dIN == 1);
  }
  
  public static boolean axH()
  {
    anki localanki = a();
    return (localanki != null) && (localanki.dIQ == 1);
  }
  
  public static boolean axI()
  {
    anki localanki = a();
    return (localanki != null) && (localanki.dIS == 1);
  }
  
  public static boolean axJ()
  {
    anki localanki = a();
    return (localanki != null) && (localanki.dIT == 1);
  }
  
  public static boolean axK()
  {
    anki localanki = a();
    return (localanki != null) && (localanki.dIW == 1);
  }
  
  public static boolean axL()
  {
    anki localanki = a();
    return (localanki != null) && (localanki.dIX == 1);
  }
  
  public static boolean axM()
  {
    anki localanki = a();
    return (localanki != null) && (localanki.dIY == 1);
  }
  
  public static boolean axN()
  {
    anki localanki = a();
    return (localanki != null) && (localanki.dIZ == 1);
  }
  
  public static boolean axO()
  {
    if (!anii.canChangePreviewSize()) {}
    anki localanki;
    do
    {
      return false;
      localanki = a();
    } while ((localanki != null) && (localanki.dJb == 0));
    return true;
  }
  
  public static boolean axP()
  {
    anki localanki = a();
    return (localanki != null) && (localanki.dJa == 1);
  }
  
  public static boolean axQ()
  {
    anki localanki = a();
    return (localanki == null) || (localanki.dJc == 1);
  }
  
  public static anki b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaCodecDPC", 2, "loadMediaCodecDPC!");
    }
    anki localanki = new anki();
    Object localObject = DeviceProfileManager.a().jf(DeviceProfileManager.DpcNames.SVideoCfg.name());
    if (QLog.isColorLevel()) {
      QLog.i("MediaCodecDPC", 2, "loadMediaCodecDPC dpcValue: " + (String)localObject);
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return localanki;
    }
    for (;;)
    {
      try
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject == null) {
          break;
        }
        if (localObject.length >= 1) {
          localanki.dIK = Integer.valueOf(localObject[0]).intValue();
        }
        if (localObject.length >= 2) {
          localanki.dIL = Integer.valueOf(localObject[1]).intValue();
        }
        if (localObject.length >= 4)
        {
          f = Float.valueOf(localObject[2]).floatValue();
          localanki.dIM = Integer.valueOf(localObject[3]).intValue();
          if ((f > 1.0D) || (f <= 0.0F)) {
            continue;
          }
          localanki.zP = f;
        }
        if (localObject.length >= 5) {
          localanki.dIN = Integer.valueOf(localObject[4]).intValue();
        }
        if (localObject.length >= 6) {
          localanki.dIO = Integer.valueOf(localObject[5]).intValue();
        }
        if (localObject.length >= 7) {
          localanki.dIP = Integer.valueOf(localObject[6]).intValue();
        }
        if (localObject.length >= 8) {
          localanki.dIQ = Integer.valueOf(localObject[7]).intValue();
        }
        if (localObject.length >= 9) {
          localanki.dIR = Integer.valueOf(localObject[8]).intValue();
        }
        if (localObject.length >= 10) {
          localanki.dIS = Integer.valueOf(localObject[9]).intValue();
        }
        if (localObject.length >= 12)
        {
          localanki.dIT = Integer.valueOf(localObject[10]).intValue();
          localanki.dIU = Integer.valueOf(localObject[11]).intValue();
        }
        if (localObject.length >= 13) {
          localanki.dIV = Integer.valueOf(localObject[12]).intValue();
        }
        if (localObject.length >= 14) {
          localanki.dIW = Integer.valueOf(localObject[13]).intValue();
        }
        if (localObject.length >= 15) {
          localanki.dIX = Integer.valueOf(localObject[14]).intValue();
        }
        if (localObject.length >= 16) {
          localanki.dIY = Integer.valueOf(localObject[15]).intValue();
        }
        if (localObject.length >= 17) {
          localanki.dIZ = Integer.valueOf(localObject[16]).intValue();
        }
        if (localObject.length >= 18) {
          localanki.dJa = Integer.valueOf(localObject[17]).intValue();
        }
        if (localObject.length >= 19) {
          localanki.dJb = Integer.valueOf(localObject[18]).intValue();
        }
        if (localObject.length >= 21)
        {
          localanki.dJc = Integer.valueOf(localObject[19]).intValue();
          localanki.dJd = Integer.valueOf(localObject[20]).intValue();
        }
        if (localObject.length >= 23)
        {
          localanki.dJe = Integer.valueOf(localObject[21]).intValue();
          localanki.dJf = Integer.valueOf(localObject[22]).intValue();
        }
      }
      catch (Exception localException)
      {
        float f;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MediaCodecDPC", 2, "loadMediaCodecDPC exception:", localException);
        continue;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("MediaCodecDPC", 2, "MediaCodecDPC:" + localanki.toString());
      return localanki;
      QLog.e("MediaCodecDPC", 1, new Object[] { "MediaCodecDPC:  beautyRate: ", Float.valueOf(f) });
    }
  }
  
  public static float getBeatyRate()
  {
    anki localanki = a();
    if (localanki != null) {
      return localanki.zP;
    }
    return 1.0F;
  }
  
  public static boolean isBeautySwitchOpen()
  {
    anki localanki = a();
    return (localanki != null) && (localanki.dIL == 1);
  }
  
  public static boolean isDeNoiseSwitchOpen()
  {
    anki localanki = a();
    return (localanki != null) && (localanki.dIO == 1);
  }
  
  public static boolean isPortraitSwitchOpen()
  {
    anki localanki = a();
    return (localanki != null) && (localanki.dIV == 1);
  }
  
  public static boolean isSvafSwitchOpen()
  {
    anki localanki = a();
    return (localanki != null) && (localanki.dIM == 1);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mediaCodecSwitch: ").append(this.dIK);
    localStringBuilder.append(" beautySwitch: ").append(this.dIL);
    localStringBuilder.append(" beautyRate: ").append(this.zP);
    localStringBuilder.append(" svafSwitch: ").append(this.dIM);
    localStringBuilder.append(" gestureDPCSwitch: ").append(this.dIN);
    localStringBuilder.append(" deNoiseDPCSwitch: ").append(this.dIO);
    localStringBuilder.append(" qmcfDPCFrameType: ").append(this.dIP);
    localStringBuilder.append(" cqBitrateModeSwitch: ").append(this.dIQ);
    localStringBuilder.append(" cqMaxBitrate: ").append(this.dIR);
    localStringBuilder.append(" faceDanceDPCSwitch: ").append(this.dIS);
    localStringBuilder.append(" portraitDPCSwitch: ").append(this.dIV);
    localStringBuilder.append(" danceRankingSwitch: ").append(this.dIW);
    localStringBuilder.append(" arParticleDPCSwitch: ").append(this.dIX);
    localStringBuilder.append(" rijiCameraDPCSwitch: ").append(this.dIY);
    localStringBuilder.append(" segmentMediaCodecEncodeSwitch: ").append(this.dIZ);
    localStringBuilder.append(" transitionSwitch: ").append(this.dJa);
    localStringBuilder.append(" rijiCamera720PSwitch: ").append(this.dJb);
    localStringBuilder.append(" followCaptureSwitch: ").append(this.dJc);
    localStringBuilder.append(" followCaptureGopSize: ").append(this.dJd);
    localStringBuilder.append(" mLimittedSdkVersion: ").append(this.dJe);
    localStringBuilder.append(" camera2Switch: ").append(this.dJf);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anki
 * JD-Core Version:    0.7.0.1
 */