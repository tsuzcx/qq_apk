import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class adfw
{
  private static adfw a;
  public boolean bMG;
  public boolean bMH;
  public boolean bMI;
  public boolean bMJ;
  public boolean bMK;
  public boolean bML;
  public boolean bMM;
  public int cEY;
  public int cEZ;
  public int cFa;
  public float uD;
  
  public static adfw a()
  {
    if (a == null)
    {
      a = new adfw();
      a.cRo();
    }
    return a;
  }
  
  private void cRo()
  {
    long l = System.currentTimeMillis();
    cRp();
    Object localObject = DeviceProfileManager.b().jf(DeviceProfileManager.DpcNames.ARCfg.name());
    QLog.d("ScanEntranceDPC", 1, String.format("loadDPC dpcValue=%s", new Object[] { localObject }));
    int k = -1;
    m = k;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      j = k;
    }
    for (;;)
    {
      try
      {
        localObject = ((String)localObject).split("\\|");
        j = k;
        if (localObject.length < 9) {
          continue;
        }
        j = k;
        if (Integer.valueOf(localObject[1]).intValue() != 1) {
          continue;
        }
        bool = true;
        j = k;
        this.bMG = bool;
        j = k;
        int i = Integer.valueOf(localObject[2]).intValue();
        if (i >= 0)
        {
          j = k;
          this.cEY = i;
        }
        j = k;
        float f = Float.valueOf(localObject[3]).floatValue();
        if ((f >= 0.05F) && (f <= 0.95F))
        {
          j = k;
          this.uD = f;
        }
        j = k;
        if (Integer.valueOf(localObject[4]).intValue() != 1) {
          continue;
        }
        bool = true;
        j = k;
        this.bMH = bool;
        j = k;
        i = Integer.valueOf(localObject[5]).intValue();
        if (i >= 0)
        {
          j = k;
          this.cEZ = i;
        }
        j = k;
        if (Integer.valueOf(localObject[6]).intValue() != 1) {
          continue;
        }
        bool = true;
        j = k;
        this.bMI = bool;
        j = k;
        if (Integer.valueOf(localObject[7]).intValue() != 1) {
          continue;
        }
        bool = true;
        j = k;
        this.bMJ = bool;
        j = k;
        i = Integer.valueOf(localObject[8]).intValue();
        if ((i >= 0) && (i <= 255))
        {
          j = k;
          this.cFa = i;
        }
        j = k;
        if (localObject.length >= 12)
        {
          j = k;
          if (Integer.valueOf(localObject[11]).intValue() != 1) {
            continue;
          }
          bool = true;
          j = k;
          this.bMK = bool;
        }
        i = k;
        j = k;
        if (localObject.length > 12)
        {
          j = k;
          i = Integer.valueOf(localObject[12]).intValue();
        }
        j = i;
        if (localObject.length >= 18)
        {
          j = i;
          if (Integer.valueOf(localObject[17]).intValue() != 1) {
            continue;
          }
          bool = true;
          j = i;
          this.bML = bool;
        }
        m = i;
        j = i;
        if (localObject.length >= 19)
        {
          j = i;
          if (Integer.valueOf(localObject[18]).intValue() != 1) {
            continue;
          }
          bool = true;
          j = i;
          this.bMM = bool;
          m = i;
        }
      }
      catch (Exception localException)
      {
        boolean bool;
        QLog.e("ScanEntranceDPC", 1, "loadDPC fail, use default value.", localException);
        cRp();
        m = j;
        continue;
      }
      QLog.d("ScanEntranceDPC", 1, String.format("loadDPC mHighPerfDevice=%s mCameraZoom=%s mScanRectRadio=%s mContinuousFocus=%s mARRecogInterval=%s mRecycleFaceResource=%s mRecordEnable=%s mDarkThreshold=%s mNeonCfgSwitch=%s, disableWorldCup=%s mMiniDecodeSwitch=%s mMiniDetectSwitch=%s", new Object[] { Boolean.valueOf(this.bMG), Integer.valueOf(this.cEY), Float.valueOf(this.uD), Boolean.valueOf(this.bMH), Integer.valueOf(this.cEZ), Boolean.valueOf(this.bMI), Boolean.valueOf(this.bMJ), Integer.valueOf(this.cFa), Boolean.valueOf(this.bMK), Integer.valueOf(m), Boolean.valueOf(this.bML), Boolean.valueOf(this.bMM) }));
      QLog.d("ScanEntranceDPC", 1, String.format("loadDPC time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
      return;
      bool = false;
      continue;
      bool = false;
      continue;
      bool = false;
      continue;
      bool = false;
      continue;
      bool = false;
      continue;
      bool = false;
      continue;
      bool = false;
      continue;
      j = k;
      QLog.e("ScanEntranceDPC", 1, "loadDPC dpc length invalid, use default value.");
      m = k;
    }
  }
  
  private void cRp()
  {
    this.bMG = false;
    this.cEY = 2;
    this.uD = 0.7F;
    this.bMH = false;
    this.cEZ = 500;
    this.bMI = true;
    this.bMJ = true;
    this.cFa = 28;
    this.bMK = false;
    this.bML = false;
    this.bMM = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adfw
 * JD-Core Version:    0.7.0.1
 */