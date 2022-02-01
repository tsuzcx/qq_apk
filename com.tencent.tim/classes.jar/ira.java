import java.util.List;

public class ira
{
  private boolean Uj;
  private boolean Uk;
  private ira.a a;
  private float currentX;
  private float currentY;
  private iqt d;
  private float gV;
  private float gW;
  private float gX;
  private float gY;
  private float gZ;
  private float ha;
  private float hb;
  private float hc = 1.0F;
  private float hd = 1.0F;
  private float he;
  private float hf = 1.0F;
  private float hg = 1.0F;
  private float hh = 1.0F;
  private float hi = 1.0F;
  private float hj;
  private float hk;
  private float hl;
  private float hm;
  private float hn;
  private float ho;
  private float hp;
  private float hq;
  private float hr;
  private float hs;
  private float ht;
  private boolean isEnd = false;
  private boolean isRotate;
  private boolean isTranslate;
  private int mDuration = 1000;
  private long mStartTime;
  private int speedType = 0;
  
  public float T()
  {
    return this.currentX;
  }
  
  public float U()
  {
    return this.currentY;
  }
  
  public float V()
  {
    return this.hb;
  }
  
  public float W()
  {
    return this.hj;
  }
  
  public float X()
  {
    return this.hk;
  }
  
  public float Y()
  {
    return this.hr;
  }
  
  public float Z()
  {
    return this.hs;
  }
  
  public void a(ira.a parama)
  {
    this.a = parama;
  }
  
  public float aa()
  {
    return this.ht;
  }
  
  public void apD()
  {
    if (this.d != null) {}
    synchronized (this.d.al())
    {
      this.d.al().remove(this);
      if (this.a != null)
      {
        this.a.onAnimationEnd();
        this.a = null;
      }
      return;
    }
  }
  
  public boolean aw(long paramLong)
  {
    if (this.isEnd)
    {
      apD();
      return this.isEnd;
    }
    if (this.mStartTime == -1L) {
      this.mStartTime = paramLong;
    }
    long l = paramLong - this.mStartTime;
    if (l == 0L) {
      return false;
    }
    paramLong = l;
    if (l >= this.mDuration)
    {
      paramLong = this.mDuration;
      this.isEnd = true;
      apD();
    }
    float f1;
    if (this.speedType == 0) {
      f1 = (float)paramLong * 1.0F / this.mDuration;
    }
    for (;;)
    {
      if (this.isTranslate)
      {
        this.currentX = (this.gV + (this.gW - this.gV) * f1);
        this.currentY = (this.gX + (this.gY - this.gX) * f1);
        this.hb = (this.gZ + (this.ha - this.gZ) * f1);
      }
      if (this.Uk)
      {
        this.hj = (this.hf + (this.hh - this.hf) * f1);
        this.hk = (this.hg + (this.hi - this.hg) * f1);
      }
      if (this.isRotate)
      {
        this.hr = (this.hl + (this.hm - this.hl) * f1);
        this.hs = (this.hn + (this.ho - this.hn) * f1);
        this.ht = (this.hp + (this.hq - this.hp) * f1);
      }
      if (!this.Uj) {
        break;
      }
      float f2 = this.hc;
      this.he = (f1 * (this.hd - this.hc) + f2);
      break;
      if (this.speedType == 1)
      {
        f1 = (float)paramLong;
        f1 = (float)paramLong * (1.0F * f1) / this.mDuration / this.mDuration;
      }
      else if (this.speedType == 2)
      {
        l = this.mDuration;
        if (paramLong == 0L)
        {
          f1 = 0.0F;
        }
        else
        {
          f1 = (float)paramLong * 1.0F * (float)paramLong / (float)l / (float)l;
          f1 = ((float)l * 2.0F / (float)paramLong - 1.0F) * f1;
        }
      }
      else
      {
        f1 = 1.0F;
      }
    }
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.isTranslate = true;
    this.gV = paramFloat1;
    this.currentX = paramFloat1;
    this.gX = paramFloat2;
    this.currentY = paramFloat2;
    this.gZ = paramFloat3;
    this.hb = paramFloat3;
    this.gW = paramFloat4;
    this.gY = paramFloat5;
    this.ha = paramFloat6;
  }
  
  public void b(iqt paramiqt)
  {
    this.d = paramiqt;
  }
  
  public void c(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.isRotate = true;
    this.hl = paramFloat1;
    this.hr = paramFloat1;
    this.hm = paramFloat2;
    this.hn = paramFloat3;
    this.hs = paramFloat3;
    this.ho = paramFloat4;
    this.hp = paramFloat5;
    this.ht = paramFloat5;
    this.hq = paramFloat6;
  }
  
  public boolean isRotate()
  {
    return this.isRotate;
  }
  
  public boolean isScale()
  {
    return this.Uk;
  }
  
  public void setDuration(int paramInt)
  {
    this.mDuration = Math.abs(paramInt);
    if (this.mDuration == 0) {
      this.mDuration = 1;
    }
  }
  
  public void setScale(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.Uk = true;
    this.hf = paramFloat1;
    this.hj = paramFloat1;
    this.hg = paramFloat2;
    this.hk = paramFloat2;
    this.hh = paramFloat3;
    this.hi = paramFloat4;
  }
  
  public void setSpeedType(int paramInt)
  {
    this.speedType = paramInt;
  }
  
  public void startAnimation()
  {
    this.mStartTime = -1L;
  }
  
  public boolean vj()
  {
    return this.isTranslate;
  }
  
  public static abstract interface a
  {
    public abstract void onAnimationEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ira
 * JD-Core Version:    0.7.0.1
 */