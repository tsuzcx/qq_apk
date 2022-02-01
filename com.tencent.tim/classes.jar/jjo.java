import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class jjo
{
  private static float alpha = 0.02F;
  private static long pQ;
  private boolean TF = true;
  private boolean ZI;
  boolean ZJ = false;
  boolean ZK = false;
  private int aAo = 0;
  private int aAp;
  private int aAq;
  public jjo c;
  private int dataLen;
  private int format;
  private float hZ = 0.0F;
  private int height;
  private float ia = 0.0F;
  private final long mo;
  private long pE;
  private long pF;
  private long pG;
  private long pH;
  private long pI;
  private long pJ;
  private long pK;
  private long pL;
  private long pM;
  private long pN;
  private long pO;
  private long pP;
  private long pR;
  private int rotation;
  private int width;
  
  public jjo(jjo paramjjo, long paramLong)
  {
    this.mo = paramLong;
    this.c = paramjjo;
  }
  
  static float a(float paramFloat, long paramLong)
  {
    float f;
    if (paramFloat == 0.0F) {
      f = (float)paramLong;
    }
    do
    {
      return f;
      f = paramFloat;
    } while (paramLong == 0L);
    return (1.0F - alpha) * paramFloat + (float)paramLong * alpha;
  }
  
  static long c(long paramLong1, long paramLong2)
  {
    if (paramLong1 == 0L) {}
    while (paramLong2 == 0L) {
      return 0L;
    }
    return paramLong1 - paramLong2;
  }
  
  public static boolean enable()
  {
    return true;
  }
  
  static int i(float paramFloat)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(1000000.0F / paramFloat * 100.0F);
  }
  
  private void kI(String paramString)
  {
    axi();
    log(paramString);
    this.c = null;
  }
  
  private void log(String paramString)
  {
    boolean bool = xC();
    if ((bool) || (AudioHelper.jY(18) == 1))
    {
      int i = i(this.hZ);
      int j = i(this.ia);
      String str = "frameIndex[" + this.c + "->" + this.mo + "], dataLen[" + this.dataLen + "], width[" + this.width + "], height[" + this.height + "], format[" + this.format + "], CamAngle[" + this.aAp + "], FinalAngle[" + this.aAq + "], CamFPS[" + this.pR + "], PreviewDataFPS[" + i + "], SendFPS[" + j + "], isFront[" + this.TF + "], effect[" + this.ZI + "], business[" + String.format("%08x", new Object[] { Integer.valueOf(this.aAo) }) + "]";
      paramString = null;
      if (xB()) {
        paramString = ", intervalPreviewData[" + this.pF + "], intervalSendCameraFrame2Native[" + this.pP + "], render[" + c(this.pN, this.pG) + "], CheckLowligh[" + c(this.pH, this.pG) + "], Beauty2[" + c(this.pI, this.pH) + "], DenoiseRender[" + c(this.pJ, this.pI) + "], LowLightRender[" + c(this.pK, this.pJ) + "], Beauty3[" + c(this.pL, this.pK) + "], RenderChain[" + c(this.pM, this.pL) + "], post[" + c(this.pN, this.pM) + "], buildExtInfo[" + c(this.pO, this.pN) + "]";
      }
      paramString = "PerfLog, " + str + paramString;
      paramString = paramString + ", onPreviewData[" + this.pE + "], renderBegin[" + this.pG + "], afterCheckLowligh[" + this.pH + "], afterDenoiseRender[" + this.pJ + "], afterLowLightRender[" + this.pK + "], afterBeautyRender[" + this.pL + "], afterRenderChain[" + this.pM + "], renderEnd[" + this.pN + "], sendCameraFrame2Native[" + this.pO + "]";
      if (bool) {
        QLog.w("FramePerfDataK_" + this.ZK, 1, paramString);
      }
    }
    else
    {
      return;
    }
    QLog.w("FramePerfData_" + this.ZK, 1, paramString);
  }
  
  public static boolean xB()
  {
    return QLog.isColorLevel();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.dataLen = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.format = paramInt4;
    this.aAp = paramInt5;
    this.rotation = paramInt6;
    this.pR = paramLong;
    this.TF = paramBoolean1;
    this.ZI = paramBoolean2;
  }
  
  void axi()
  {
    float f2 = 0.0F;
    for (jjo localjjo = this.c; (localjjo != null) && (!localjjo.ZJ); localjjo = localjjo.c) {
      localjjo.ZK = true;
    }
    this.c = localjjo;
    if (localjjo != null)
    {
      if (localjjo.pE != 0L) {
        this.pF = (this.pE - localjjo.pE);
      }
      if (localjjo.pO != 0L) {
        this.pP = (this.pO - localjjo.pO);
      }
    }
    if (localjjo == null)
    {
      f1 = 0.0F;
      this.hZ = a(f1, this.pF / 1000L);
      if (localjjo != null) {
        break label137;
      }
    }
    label137:
    for (float f1 = f2;; f1 = localjjo.ia)
    {
      this.ia = a(f1, this.pP / 1000L);
      return;
      f1 = localjjo.hZ;
      break;
    }
  }
  
  public void axj()
  {
    if (xB()) {
      this.pE = AudioHelper.elapsedRealtimeNanos();
    }
  }
  
  public void axk()
  {
    if (xB()) {
      this.pG = AudioHelper.elapsedRealtimeNanos();
    }
  }
  
  public void axl()
  {
    if (xB()) {
      this.pN = AudioHelper.elapsedRealtimeNanos();
    }
  }
  
  public void axm()
  {
    if (xB()) {
      this.pH = AudioHelper.elapsedRealtimeNanos();
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (xB())
    {
      this.pM = AudioHelper.elapsedRealtimeNanos();
      if (paramBoolean1) {
        this.aAo |= 0x20;
      }
      if (paramBoolean2) {
        this.aAo |= 0x10;
      }
      if (paramBoolean3) {
        this.aAo |= 0x40;
      }
      if (paramBoolean4) {
        this.aAo |= 0x80;
      }
    }
  }
  
  public boolean clear()
  {
    if (this.ZJ) {
      return true;
    }
    this.ZJ = true;
    kI("clear");
    return false;
  }
  
  public void finish()
  {
    this.ZJ = true;
    if (xB()) {
      this.pO = AudioHelper.elapsedRealtimeNanos();
    }
    kI("finish");
  }
  
  public void lc(boolean paramBoolean)
  {
    if (xB())
    {
      this.pI = AudioHelper.elapsedRealtimeNanos();
      if (paramBoolean) {
        this.aAo |= 0x1;
      }
    }
  }
  
  public void ld(boolean paramBoolean)
  {
    if (xB())
    {
      this.pJ = AudioHelper.elapsedRealtimeNanos();
      if (paramBoolean) {
        this.aAo |= 0x2;
      }
    }
  }
  
  public void le(boolean paramBoolean)
  {
    if (xB())
    {
      this.pK = AudioHelper.elapsedRealtimeNanos();
      if (paramBoolean) {
        this.aAo |= 0x4;
      }
    }
  }
  
  public void lf(boolean paramBoolean)
  {
    if (xB())
    {
      this.pL = AudioHelper.elapsedRealtimeNanos();
      if (paramBoolean) {
        this.aAo |= 0x8;
      }
    }
  }
  
  public void nI(int paramInt)
  {
    this.aAq = paramInt;
  }
  
  public String toString()
  {
    return this.mo + "";
  }
  
  boolean xC()
  {
    if (System.currentTimeMillis() - pQ >= 4000L)
    {
      pQ = System.currentTimeMillis();
      return true;
    }
    jjo localjjo = this.c;
    if (localjjo != null)
    {
      if ((localjjo.dataLen != this.dataLen) || (localjjo.width != this.width) || (localjjo.height != this.height) || (localjjo.format != this.format) || (localjjo.aAp != this.aAp) || (localjjo.rotation != this.rotation) || (localjjo.pR != this.pR) || (localjjo.TF != this.TF) || (localjjo.ZI != this.ZI) || (localjjo.aAq != this.aAq) || (localjjo.aAo != this.aAo) || (localjjo.mo + 1L != this.mo))
      {
        pQ = System.currentTimeMillis();
        return true;
      }
    }
    else
    {
      pQ = System.currentTimeMillis();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jjo
 * JD-Core Version:    0.7.0.1
 */