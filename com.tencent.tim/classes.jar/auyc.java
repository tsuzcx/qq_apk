import android.content.Context;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Date;

public class auyc
{
  protected float Df;
  private float Dg;
  private float Dh;
  private float Di;
  private float Dj;
  private float Dk;
  private float Dl;
  private boolean aOH;
  protected long azf;
  protected long azg;
  protected boolean cMd;
  protected double dm;
  protected int evs;
  protected int evt;
  protected int evu;
  private int evv;
  private int evw;
  private int evx;
  private int evy;
  protected int netType;
  public int state;
  
  public auyc()
  {
    initParam();
  }
  
  private long iG()
  {
    return new Date().getTime();
  }
  
  private long iH()
  {
    return new Date().getTime();
  }
  
  public int a(Context paramContext, long paramLong)
  {
    this.netType = aqiw.getSystemNetwork(BaseApplication.getContext());
    if (!this.cMd) {
      switch (this.netType)
      {
      default: 
        this.evs = 4096;
      }
    }
    for (;;)
    {
      if (paramLong < 102400L) {
        this.evs *= 4;
      }
      if (paramLong - this.evs <= this.evs / 2) {
        this.evs = ((int)paramLong);
      }
      return this.evs;
      this.evs = 32768;
      continue;
      this.evs = 16384;
      continue;
      this.evs = 8192;
    }
  }
  
  public int a(Context paramContext, long paramLong1, long paramLong2, int paramInt)
  {
    this.azf = iG();
    if (paramLong1 < 102400L) {}
    for (this.evx = 1; true == this.aOH; this.evx = 2)
    {
      initParam();
      this.evt = a(paramContext, paramLong1);
      this.aOH = false;
      return this.evt;
    }
    this.Dh = ((float)(this.evt / this.dm));
    label144:
    label176:
    float f;
    if (0.0F == this.Dj)
    {
      this.Dj = this.Dh;
      if (this.state != 2)
      {
        this.evy += 1;
        if (this.Di != 0.0F) {
          break label278;
        }
        this.Df = 1.0F;
        if (this.evy == this.evx) {
          this.Dg = this.Dj;
        }
      }
      switch (this.state)
      {
      default: 
        if (paramLong1 - paramLong2 - this.evt <= this.evt / 2) {
          this.evt = ((int)(paramLong1 - paramLong2));
        }
        if (this.evy == 0)
        {
          f = this.Di;
          label219:
          if ((paramInt <= 0) || ((this.evt >= 0) && (this.evt <= paramInt))) {
            break label646;
          }
          this.evt = paramInt;
        }
        break;
      }
    }
    for (;;)
    {
      return this.evt;
      this.Dj = ((float)(0.8D * this.Dh + 0.2D * this.Dj));
      break;
      label278:
      if (this.evy != this.evx) {
        break label144;
      }
      this.Df = ((float)((this.Dj - this.Di) / this.Dg / ((this.evt - this.evu) / (this.evs + 0.0D))));
      break label144;
      if (this.evy != this.evx) {
        break label176;
      }
      if (this.Df < 0.09D)
      {
        this.state = 1;
        this.evt = ((int)(1.05D * this.evu));
      }
      for (;;)
      {
        this.Dj = 0.0F;
        this.evy = 0;
        break;
        this.state = 0;
        this.evu = this.evt;
        this.evt = (this.evu * 2);
        this.Di = this.Dj;
      }
      if (this.evy != this.evx) {
        break label176;
      }
      if (this.Df < 0.09D)
      {
        this.state = 2;
        this.Dk = this.Dj;
        this.Di = 0.0F;
        this.evu = 0;
        this.Dl = this.Dj;
        break label176;
      }
      this.state = 1;
      this.evu = this.evt;
      this.evt = ((int)(1.05D * this.evu));
      this.Di = this.Dj;
      this.Dl = this.Dj;
      this.Dj = 0.0F;
      this.evy = 0;
      break label176;
      if (Math.abs(this.Dj - this.Dk) > 0.2D * this.Dk) {}
      for (this.evv += 1;; this.evv = 0)
      {
        if (this.evv >= this.evw) {
          break label596;
        }
        this.state = 2;
        break;
      }
      label596:
      this.evv = 0;
      this.state = 0;
      this.evt = this.evs;
      this.Di = 0.0F;
      this.evu = 0;
      this.Dj = 0.0F;
      this.evy = 0;
      break label176;
      f = this.Dj;
      break label219;
      label646:
      if (this.evt < 0)
      {
        this.evv = 0;
        this.state = 0;
        this.evt = this.evs;
        this.Di = 0.0F;
        this.evu = 0;
        this.Dj = 0.0F;
        this.evy = 0;
      }
    }
  }
  
  public void exX()
  {
    this.azg = iH();
    this.dm = ((this.azg - this.azf) / 1000.0D);
    QLog.d("upload", 2, "sendFilePakage time:" + this.dm);
  }
  
  public void initParam()
  {
    this.aOH = true;
    this.state = 0;
    this.evs = 0;
    this.evt = 0;
    this.evu = 0;
    this.Dg = 0.0F;
    this.Dh = 0.0F;
    this.Di = 0.0F;
    this.Dj = 0.0F;
    this.dm = 0.0D;
    this.azf = 0L;
    this.azg = 0L;
    this.Df = 0.0F;
    this.Dl = 0.0F;
    this.evv = 0;
    this.evy = 0;
    this.evw = 3;
    this.evx = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auyc
 * JD-Core Version:    0.7.0.1
 */