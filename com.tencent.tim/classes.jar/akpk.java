import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.mobileqq.ocr.view.gesture.Settings;
import com.tencent.mobileqq.ocr.view.gesture.Settings.Fit;

public class akpk
{
  private static final RectF aI = new RectF();
  private static final Matrix s = new Matrix();
  private final Settings a;
  private float xJ;
  private float xK;
  private float ye;
  
  public akpk(Settings paramSettings)
  {
    this.a = paramSettings;
  }
  
  public akpk a(akpm paramakpm)
  {
    float f5 = this.a.GY();
    float f6 = this.a.GZ();
    float f7 = this.a.GW();
    float f8 = this.a.GX();
    if ((f5 == 0.0F) || (f6 == 0.0F) || (f7 == 0.0F) || (f8 == 0.0F))
    {
      this.ye = 1.0F;
      this.xK = 1.0F;
      this.xJ = 1.0F;
      return this;
    }
    this.xJ = this.a.bh();
    this.xK = this.a.getMaxZoom();
    float f9 = paramakpm.getRotation();
    float f3 = f8;
    float f1 = f7;
    float f2 = f6;
    float f4 = f5;
    label262:
    label267:
    if (!akpm.equals(f9, 0.0F))
    {
      if (this.a.a() == Settings.Fit.OUTSIDE)
      {
        s.setRotate(-f9);
        aI.set(0.0F, 0.0F, f7, f8);
        s.mapRect(aI);
        f1 = aI.width();
        f3 = aI.height();
        f4 = f5;
        f2 = f6;
      }
    }
    else {
      label202:
      switch (akpl.mg[this.a.a().ordinal()])
      {
      default: 
        if (this.xJ > 0.0F)
        {
          f1 = this.xJ;
          this.ye = f1;
          if (this.xJ <= 0.0F) {
            this.xJ = this.ye;
          }
          if (this.xK <= 0.0F) {
            this.xK = this.ye;
          }
          if (this.ye > this.xK)
          {
            if (!this.a.isFillViewport()) {
              break label501;
            }
            this.xK = this.ye;
          }
        }
        break;
      }
    }
    for (;;)
    {
      if (this.xJ > this.xK) {
        this.xJ = this.xK;
      }
      if (this.ye >= this.xJ) {
        break;
      }
      if (!this.a.isFillViewport()) {
        break label512;
      }
      this.xJ = this.ye;
      return this;
      s.setRotate(f9);
      aI.set(0.0F, 0.0F, f5, f6);
      s.mapRect(aI);
      f4 = aI.width();
      f2 = aI.height();
      f3 = f8;
      f1 = f7;
      break label202;
      this.ye = (f1 / f4);
      break label267;
      this.ye = (f3 / f2);
      break label267;
      this.ye = Math.min(f1 / f4, f3 / f2);
      break label267;
      this.ye = Math.max(f1 / f4, f3 / f2);
      break label267;
      f1 = 1.0F;
      break label262;
      label501:
      this.ye = this.xK;
    }
    label512:
    this.ye = this.xJ;
    return this;
  }
  
  public float bh()
  {
    return this.xJ;
  }
  
  public float bo()
  {
    return this.ye;
  }
  
  public float getMaxZoom()
  {
    return this.xK;
  }
  
  public float k(float paramFloat1, float paramFloat2)
  {
    return akpp.d(paramFloat1, this.xJ / paramFloat2, this.xK * paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akpk
 * JD-Core Version:    0.7.0.1
 */