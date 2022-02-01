import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class adkw
  implements adfh, adfi, adfj, SDKInitListener
{
  private long UU;
  private adfp jdField_a_of_type_Adfp;
  private adkw.a jdField_a_of_type_Adkw$a;
  private adkw.b jdField_a_of_type_Adkw$b;
  private adkw.c jdField_a_of_type_Adkw$c;
  private boolean bOC;
  private boolean bOD;
  private boolean bOE;
  private boolean bOF;
  private boolean bOG;
  private boolean bOH;
  private boolean bOI;
  private boolean bOJ;
  private boolean bOK;
  private int cIA;
  private int cIB;
  private int cIy;
  private int cIz;
  private Activity l;
  
  public adkw(Activity paramActivity, adfp paramadfp)
  {
    this.jdField_a_of_type_Adfp = paramadfp;
    this.l = paramActivity;
  }
  
  private boolean bT(long paramLong)
  {
    return (this.UU & 0x2) != 0L;
  }
  
  private void cSI()
  {
    if ((this.bOC) && (this.bOE)) {
      if (this.jdField_a_of_type_Adkw$a != null) {
        this.jdField_a_of_type_Adkw$a.cSK();
      }
    }
    while ((this.bOD) || (this.bOF) || (this.jdField_a_of_type_Adkw$a == null)) {
      return;
    }
    QLog.d("ScanEntryResourceDelegate", 1, "ARBaseSo res download fail");
    this.jdField_a_of_type_Adkw$a.cSL();
  }
  
  private void cSJ()
  {
    int i = 0;
    if (bT(2L)) {
      i = 0 + this.cIy;
    }
    int j = i;
    if (bT(8L)) {
      j = i + this.cIz;
    }
    if (this.jdField_a_of_type_Adkw$a != null) {
      this.jdField_a_of_type_Adkw$a.Li(j / 2);
    }
  }
  
  private void iO(long paramLong)
  {
    if (((paramLong & 0x2) != 0L) && (!this.bOD)) {
      cSF();
    }
    if (((0x8 & paramLong) != 0L) && (!this.bOF)) {
      cSG();
    }
    if (((paramLong & 0x2) != 0L) && ((!this.bOI) || (!this.bOF))) {
      cSH();
    }
  }
  
  public void Ky(int paramInt)
  {
    QLog.d("ScanEntryResourceDelegate", 1, "onArSoDownloadProcess process." + paramInt);
    this.cIy = paramInt;
    cSJ();
  }
  
  public void Lh(int paramInt)
  {
    QLog.d("ScanEntryResourceDelegate", 2, new Object[] { "notifyVoiceScanStatusChange state.", Integer.valueOf(paramInt) });
    if (this.jdField_a_of_type_Adfp != null) {}
    try
    {
      this.jdField_a_of_type_Adfp.yd(paramInt);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("ScanEntryResourceDelegate", 1, "notifyVoiceScanStatusChange fail.", localException);
    }
  }
  
  public void a(long paramLong, adkw.a parama, adkw.b paramb)
  {
    if (paramLong == 0L) {
      return;
    }
    this.UU = paramLong;
    this.jdField_a_of_type_Adkw$a = parama;
    this.jdField_a_of_type_Adkw$b = paramb;
    iO(paramLong);
  }
  
  public void a(adkw.c paramc)
  {
    this.jdField_a_of_type_Adkw$c = paramc;
  }
  
  public void a(ARCommonConfigInfo paramARCommonConfigInfo)
  {
    if (this.bOK) {
      return;
    }
    if (this.jdField_a_of_type_Adkw$c != null) {
      this.jdField_a_of_type_Adkw$c.b(paramARCommonConfigInfo);
    }
    this.bOK = true;
  }
  
  public void a(ArConfigInfo paramArConfigInfo) {}
  
  public void a(ArEffectConfig paramArEffectConfig)
  {
    adaq.a().b(paramArEffectConfig);
  }
  
  public boolean aeY()
  {
    boolean bool1;
    if (bT(2L)) {
      if (iN(2)) {
        bool1 = true;
      }
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (bT(8L))
      {
        if ((!bool1) || (!iN(8))) {
          break label76;
        }
        bool2 = true;
      }
      for (;;)
      {
        if (bT(4L))
        {
          if ((bool2) && (iN(4)))
          {
            return true;
            bool1 = false;
            break;
            label76:
            bool2 = false;
            continue;
          }
          return false;
        }
      }
      return bool2;
      bool1 = true;
    }
  }
  
  public boolean aeZ()
  {
    boolean bool3 = false;
    if (bT(2L)) {}
    for (boolean bool1 = this.bOD;; bool1 = false)
    {
      if (bT(8L)) {}
      for (boolean bool2 = this.bOF;; bool2 = false)
      {
        int i;
        if (bT(4L)) {
          if ((this.bOI) || (this.bOJ)) {
            i = 1;
          }
        }
        for (;;)
        {
          if ((!bool1) && (!bool2))
          {
            bool1 = bool3;
            if (i == 0) {}
          }
          else
          {
            bool1 = true;
          }
          return bool1;
          i = 0;
          continue;
          i = 0;
        }
      }
    }
  }
  
  public boolean afa()
  {
    return (this.bOC) && (this.bOE);
  }
  
  public boolean afb()
  {
    return (this.bOG) && (this.bOH);
  }
  
  public void ak(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Adkw$b != null) {
        this.jdField_a_of_type_Adkw$b.Lj((this.cIA + this.cIB) / 2);
      }
      return;
      this.cIA = paramInt2;
      continue;
      this.cIB = paramInt2;
    }
  }
  
  public void al(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Adkw$b != null)
      {
        QLog.d("ScanEntryResourceDelegate", 1, "face so download not ready download fail");
        this.jdField_a_of_type_Adkw$b.cSN();
      }
      return;
      this.bOG = false;
      this.bOI = false;
      continue;
      this.bOH = false;
      this.bOJ = false;
    }
  }
  
  public void cPS()
  {
    this.bOC = true;
    this.bOD = false;
    this.cIy = 100;
    cSI();
  }
  
  public void cPT()
  {
    this.bOC = false;
    this.bOD = false;
    cSI();
  }
  
  public void cRV()
  {
    this.UU = 0L;
    this.jdField_a_of_type_Adkw$a = null;
    this.jdField_a_of_type_Adkw$b = null;
  }
  
  public void cSE()
  {
    if (this.UU == 0L) {
      return;
    }
    a(this.UU, this.jdField_a_of_type_Adkw$a, this.jdField_a_of_type_Adkw$b);
  }
  
  public void cSF()
  {
    try
    {
      this.bOC = this.jdField_a_of_type_Adfp.adW();
      if (!this.bOC)
      {
        this.bOD = true;
        this.jdField_a_of_type_Adfp.cQW();
      }
      for (;;)
      {
        QLog.d("ScanEntryResourceDelegate", 1, String.format("downloadARResource mIsArSoReady=%s mArSoDownloading=%s", new Object[] { Boolean.valueOf(this.bOC), Boolean.valueOf(this.bOD) }));
        return;
        this.bOD = false;
        this.cIy = 100;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("ScanEntryResourceDelegate", 1, "downloadARResource fail");
    }
  }
  
  public void cSG()
  {
    this.bOE = allf.isSDKReady();
    if (!this.bOE)
    {
      this.bOF = true;
      if (!allf.isSDKReady()) {
        allf.a(BaseApplicationImpl.getContext(), this);
      }
    }
    for (;;)
    {
      QLog.d("ScanEntryResourceDelegate", 1, String.format("installVideoPlugin mIsVideoPluginReady=%s mVideoPluginDownloading=%s", new Object[] { Boolean.valueOf(this.bOE), Boolean.valueOf(this.bOF) }));
      return;
      this.bOF = false;
      this.cIz = 100;
    }
  }
  
  public void cSH()
  {
    this.bOH = adfc.aed();
    if (!this.bOH)
    {
      this.bOJ = true;
      this.jdField_a_of_type_Adfp.KR(1);
      this.bOG = adfb.aec();
      if (this.bOG) {
        break label158;
      }
      this.bOI = true;
      this.jdField_a_of_type_Adfp.KR(0);
      new HashMap().put("res_type", "model");
    }
    for (;;)
    {
      QLog.d("ScanEntryResourceDelegate", 1, String.format("downloadARFaceResources mIsFaceSoReady=%s mFaceSoDownloading=%s", new Object[] { Boolean.valueOf(this.bOH), Boolean.valueOf(this.bOJ) }));
      QLog.d("ScanEntryResourceDelegate", 1, String.format("downloadARFaceResources mIsFaceModelReady=%s mFaceModelDownloading=%s", new Object[] { Boolean.valueOf(this.bOG), Boolean.valueOf(this.bOI) }));
      return;
      this.bOJ = false;
      this.cIB = 100;
      break;
      label158:
      this.bOI = false;
      this.cIA = 100;
    }
  }
  
  public void eA(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((this.bOG) && (this.bOH) && (this.jdField_a_of_type_Adkw$b != null)) {
        this.jdField_a_of_type_Adkw$b.cSM();
      }
      return;
      this.bOG = true;
      this.bOI = false;
      this.cIA = 100;
      continue;
      this.bOH = true;
      this.bOJ = false;
      this.cIB = 100;
    }
  }
  
  public void ez(int paramInt) {}
  
  public boolean iN(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 2: 
    case 4: 
      do
      {
        return false;
        return this.bOC;
      } while ((!this.bOG) || (!this.bOH));
      return true;
    }
    return this.bOE;
  }
  
  public void m(long paramLong1, long paramLong2) {}
  
  public void onDownloadSuccess() {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    QLog.d("ScanEntryResourceDelegate", 1, "onSDKInited success." + paramBoolean);
    if (paramBoolean)
    {
      this.bOE = true;
      this.bOF = false;
      this.cIz = 100;
      cSI();
      return;
    }
    this.bOE = false;
    this.bOF = false;
    cSI();
  }
  
  public void zE() {}
  
  public static abstract interface a
  {
    public abstract void Li(int paramInt);
    
    public abstract void cSK();
    
    public abstract void cSL();
  }
  
  public static abstract interface b
  {
    public abstract void Lj(int paramInt);
    
    public abstract void cSM();
    
    public abstract void cSN();
  }
  
  public static abstract interface c
  {
    public abstract void b(ARCommonConfigInfo paramARCommonConfigInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adkw
 * JD-Core Version:    0.7.0.1
 */