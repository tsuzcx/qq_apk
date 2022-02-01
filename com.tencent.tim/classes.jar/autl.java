import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class autl
{
  private float CD;
  private float CE;
  private float CF;
  private float CG;
  private float CH;
  private float CI;
  private float CJ;
  private float CK;
  private float CL;
  private float CM;
  private float CN;
  private float CO;
  private float CP;
  private final int esR = 300;
  private Drawable gy;
  private Drawable gz;
  private int mHeight;
  private final Interpolator mInterpolator;
  private final int mMinWidth;
  private long mStartTime;
  private int mState = 0;
  private int mWidth;
  private float yG;
  
  public autl(Context paramContext)
  {
    paramContext = paramContext.getResources();
    this.gy = paramContext.getDrawable(2130842297);
    this.gz = paramContext.getDrawable(2130842298);
    this.mMinWidth = ((int)(paramContext.getDisplayMetrics().density * 300.0F + 0.5F));
    this.mInterpolator = new DecelerateInterpolator();
  }
  
  private void update()
  {
    float f1 = Math.min((float)(AnimationUtils.currentAnimationTimeMillis() - this.mStartTime) / this.yG, 1.0F);
    float f2 = this.mInterpolator.getInterpolation(f1);
    this.CD = (this.CH + (this.CI - this.CH) * f2);
    this.CE = (this.CJ + (this.CK - this.CJ) * f2);
    this.CF = (this.CL + (this.CM - this.CL) * f2);
    this.CG = (this.CN + (this.CO - this.CN) * f2);
    if (f1 >= 0.999F) {}
    switch (this.mState)
    {
    default: 
      return;
    case 2: 
      this.mState = 3;
      this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
      this.yG = 1000.0F;
      this.CH = this.CD;
      this.CJ = this.CE;
      this.CL = this.CF;
      this.CN = this.CG;
      this.CI = 0.0F;
      this.CK = 0.0F;
      this.CM = 0.0F;
      this.CO = 0.0F;
      return;
    case 1: 
      this.mState = 4;
      this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
      this.yG = 1000.0F;
      this.CH = this.CD;
      this.CJ = this.CE;
      this.CL = this.CF;
      this.CN = this.CG;
      this.CI = 0.0F;
      this.CK = 0.0F;
      this.CM = 0.0F;
      this.CO = 0.0F;
      return;
    case 4: 
      if (this.CO != 0.0F) {}
      for (f1 = 1.0F / (this.CO * this.CO);; f1 = 3.4028235E+38F)
      {
        float f3 = this.CJ;
        this.CE = (f1 * (f2 * (this.CK - this.CJ)) + f3);
        this.mState = 3;
        return;
      }
    }
    this.mState = 0;
  }
  
  public void ah(Drawable paramDrawable)
  {
    this.gy = paramDrawable;
    this.gz = paramDrawable;
  }
  
  public boolean draw(Canvas paramCanvas)
  {
    boolean bool = false;
    update();
    int i = this.gy.getIntrinsicHeight();
    this.gy.getIntrinsicWidth();
    int j = this.gz.getIntrinsicHeight();
    int k = this.gz.getIntrinsicWidth();
    this.gz.setAlpha((int)(Math.max(0.0F, Math.min(this.CF, 1.0F)) * 255.0F));
    j = (int)Math.min(j * this.CG * j / k * 0.6F, j * 4.0F);
    if (this.mWidth < this.mMinWidth)
    {
      k = (this.mWidth - this.mMinWidth) / 2;
      this.gz.setBounds(k, 0, this.mWidth - k, j);
      this.gz.draw(paramCanvas);
      this.gy.setAlpha((int)(Math.max(0.0F, Math.min(this.CD, 1.0F)) * 255.0F));
      i = (int)(i * this.CE);
      if (this.mWidth >= this.mMinWidth) {
        break label249;
      }
      j = (this.mWidth - this.mMinWidth) / 2;
      this.gy.setBounds(j, 0, this.mWidth - j, i);
    }
    for (;;)
    {
      this.gy.draw(paramCanvas);
      if (this.mState != 0) {
        bool = true;
      }
      return bool;
      this.gz.setBounds(0, 0, this.mWidth, j);
      break;
      label249:
      this.gy.setBounds(0, 0, this.mWidth, i);
    }
  }
  
  public void finish()
  {
    this.mState = 0;
  }
  
  public boolean isFinished()
  {
    return this.mState == 0;
  }
  
  public void onAbsorb(int paramInt)
  {
    this.mState = 2;
    paramInt = Math.max(100, Math.abs(paramInt));
    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
    this.yG = (0.1F + paramInt * 0.03F);
    this.CH = 0.0F;
    this.CJ = 0.0F;
    this.CE = 0.0F;
    this.CL = 0.5F;
    this.CN = 0.0F;
    this.CI = Math.max(0, Math.min(paramInt * 8, 1));
    this.CK = Math.max(0.5F, Math.min(paramInt * 8, 1.0F));
    this.CO = Math.min(0.025F + paramInt / 100 * paramInt * 0.00015F, 1.75F);
    this.CM = Math.max(this.CL, Math.min(paramInt * 16 * 1.0E-005F, 0.8F));
  }
  
  public void onPull(float paramFloat)
  {
    long l = AnimationUtils.currentAnimationTimeMillis();
    if ((this.mState == 4) && ((float)(l - this.mStartTime) < this.yG)) {
      return;
    }
    if (this.mState != 1) {
      this.CG = 1.0F;
    }
    this.mState = 1;
    this.mStartTime = l;
    this.yG = 167.0F;
    this.CP += paramFloat;
    float f1 = Math.abs(this.CP);
    float f2 = Math.max(0.6F, Math.min(f1, 0.8F));
    this.CH = f2;
    this.CD = f2;
    f1 = Math.max(0.5F, Math.min(f1 * 7.0F, 1.0F));
    this.CJ = f1;
    this.CE = f1;
    f1 = Math.min(0.8F, this.CF + Math.abs(paramFloat) * 1.1F);
    this.CL = f1;
    this.CF = f1;
    f2 = Math.abs(paramFloat);
    f1 = f2;
    if (paramFloat > 0.0F)
    {
      f1 = f2;
      if (this.CP < 0.0F) {
        f1 = -f2;
      }
    }
    if (this.CP == 0.0F) {
      this.CG = 0.0F;
    }
    paramFloat = Math.min(4.0F, Math.max(0.0F, f1 * 7.0F + this.CG));
    this.CN = paramFloat;
    this.CG = paramFloat;
    this.CI = this.CD;
    this.CK = this.CE;
    this.CM = this.CF;
    this.CO = this.CG;
  }
  
  public void onRelease()
  {
    this.CP = 0.0F;
    if ((this.mState != 1) && (this.mState != 4)) {
      return;
    }
    this.mState = 3;
    this.CH = this.CD;
    this.CJ = this.CE;
    this.CL = this.CF;
    this.CN = this.CG;
    this.CI = 0.0F;
    this.CK = 0.0F;
    this.CM = 0.0F;
    this.CO = 0.0F;
    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
    this.yG = 1000.0F;
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     autl
 * JD-Core Version:    0.7.0.1
 */