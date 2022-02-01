import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.qphone.base.util.QLog;

public class adud
  extends akzb
{
  protected RectF ax = new RectF();
  public int cJX;
  public int endY;
  public boolean mAnimating;
  public Context mContext;
  public long mDuration = 1L;
  private Interpolator mInterpolator;
  public View mParentView;
  public long mStartTime;
  public int mState = 2;
  public int offsetY;
  public int startY;
  
  public adud(View paramView)
  {
    this.mParentView = paramView;
    this.mContext = paramView.getContext();
  }
  
  private void cUp()
  {
    Lw(this.cJX);
    this.mAnimating = false;
    this.mStartTime = -1L;
    this.mDuration = 1L;
    this.mState = 2;
  }
  
  private void iV(long paramLong)
  {
    this.mDuration = paramLong;
    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
    this.mAnimating = true;
  }
  
  public void Lw(int paramInt)
  {
    int i = paramInt;
    if (this.mAnimating) {
      i = (int)(paramInt + this.cJX * (this.scaleY - 1.0F));
    }
    this.y = i;
  }
  
  public RectF a(int paramInt)
  {
    this.ax.set(this.x - 0.0F, this.y - 0.0F - paramInt, this.x + this.width + 0.0F, 0.0F + (this.y + this.height) - paramInt);
    return this.ax;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    this.cJX = paramInt2;
  }
  
  protected void aM(Canvas paramCanvas) {}
  
  protected void aN(Canvas paramCanvas) {}
  
  public void ad(int paramInt, long paramLong)
  {
    this.startY = this.cJX;
    this.endY = (this.cJX + paramInt);
    this.mInterpolator = new DecelerateInterpolator();
    this.mState = 1;
    iV(paramLong);
  }
  
  public void animateUp()
  {
    this.startY = this.y;
    this.endY = this.cJX;
    this.mState = 3;
    this.mInterpolator = new adud.a();
    iV(1500L);
  }
  
  public void cUo() {}
  
  public void cUq() {}
  
  public boolean draw(Canvas paramCanvas)
  {
    boolean bool2 = false;
    update();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.offsetY);
    aM(paramCanvas);
    if (this.drawable != null) {}
    for (boolean bool1 = super.draw(paramCanvas);; bool1 = false)
    {
      aN(paramCanvas);
      paramCanvas.restore();
      if ((this.mAnimating) || (bool1)) {
        bool2 = true;
      }
      return bool2;
    }
  }
  
  public void stopAnimation()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConvActivePendantHolderBase", 2, "stopActiveSanHua stopAnimation");
    }
    super.stopAnimation();
    cUp();
    this.scaleY = 1.0F;
    this.scaleX = 1.0F;
  }
  
  public void update()
  {
    if (!this.mAnimating) {
      return;
    }
    float f2 = (float)(AnimationUtils.currentAnimationTimeMillis() - this.mStartTime) * 1.0F / (float)this.mDuration;
    if (this.mInterpolator != null) {}
    for (float f1 = this.mInterpolator.getInterpolation(f2);; f1 = f2)
    {
      float f3 = this.startY;
      Lw((int)(f1 * (this.endY - this.startY) + f3));
      if (f2 <= 0.99D) {
        break;
      }
      switch (this.mState)
      {
      case 2: 
      default: 
        cUp();
        return;
      case 1: 
        this.mState = 3;
        animateUp();
        return;
      }
      this.mState = 2;
      return;
    }
  }
  
  class a
    implements Interpolator
  {
    a() {}
    
    public float getInterpolation(float paramFloat)
    {
      if (paramFloat < 0.2094D) {
        return (float)(-34.0D * (paramFloat - 0.18D) * (paramFloat - 0.18D) + 1.08D);
      }
      if (paramFloat < 0.404D) {
        return (float)(5.9D * (paramFloat - 0.34D) * (paramFloat - 0.34D) + 0.95D);
      }
      if (paramFloat < 0.6045D) {
        return (float)(-3.0D * (paramFloat - 0.53D) * (paramFloat - 0.53D) + 1.02D);
      }
      if (paramFloat < 0.8064D) {
        return (float)((paramFloat - 0.72D) * (paramFloat - 0.72D) + 0.99D);
      }
      return (float)(-0.3D * (paramFloat - 0.915D) * (paramFloat - 0.915D) + 1.001D);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adud
 * JD-Core Version:    0.7.0.1
 */