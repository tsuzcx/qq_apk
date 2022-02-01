import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import com.tencent.qphone.base.util.QLog;

public abstract class alhu
{
  public static class a
    extends ScaleAnimation
  {
    private alhu.d a;
    private GradientDrawable i;
    private int mDest;
    private Animation.AnimationListener mListener;
    private int mSrc;
    private float mSrcX;
    private float yH;
    
    public a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, float paramFloat5, int paramInt2, float paramFloat6, alhu.d paramd)
    {
      super(paramFloat2, paramFloat3, paramFloat4, paramInt1, paramFloat5, paramInt2, paramFloat6);
      this.mSrcX = paramFloat1;
      this.yH = (paramFloat2 - paramFloat1);
      this.a = paramd;
    }
    
    public void a(GradientDrawable paramGradientDrawable, int paramInt1, int paramInt2)
    {
      this.i = paramGradientDrawable;
      this.mSrc = paramInt1;
      this.mDest = paramInt2;
      if (QLog.isDevelopLevel()) {
        QLog.d("LsRecord", 4, "LS setColorChanger: " + paramInt1 + " --> " + paramInt2);
      }
    }
    
    public void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      super.applyTransformation(paramFloat, paramTransformation);
      if ((this.mListener != null) && ((this.mListener instanceof alhu.c))) {
        ((alhu.c)this.mListener).a(this, paramFloat);
      }
      this.a.yI = (this.mSrcX + this.yH * paramFloat);
      if (QLog.isDevelopLevel()) {
        QLog.d("LsRecord", 4, "LS applyTransformation: " + paramFloat + " F: " + this.a.yI);
      }
      int j;
      if (this.i != null)
      {
        j = this.mDest;
        if (paramFloat >= 1.0F) {
          break label296;
        }
        j = Color.argb((int)(Color.alpha(this.mSrc) + (Color.alpha(this.mDest) - Color.alpha(this.mSrc)) * paramFloat), (int)(Color.red(this.mSrc) + (Color.red(this.mDest) - Color.red(this.mSrc)) * paramFloat), (int)(Color.green(this.mSrc) + (Color.green(this.mDest) - Color.green(this.mSrc)) * paramFloat), (int)(Color.blue(this.mSrc) + (Color.blue(this.mDest) - Color.blue(this.mSrc)) * paramFloat));
        this.i.setColor(j);
      }
      for (;;)
      {
        this.a.mColor = j;
        if (QLog.isDevelopLevel()) {
          QLog.d("LsRecord", 4, "LS applyTransformation: " + paramFloat + " CLR: " + this.a.mColor);
        }
        return;
        label296:
        this.i.setColor(j);
        this.i = null;
      }
    }
    
    public void setAnimationListener(Animation.AnimationListener paramAnimationListener)
    {
      super.setAnimationListener(paramAnimationListener);
      this.mListener = paramAnimationListener;
    }
  }
  
  public static class b
    extends Animation
  {
    private View Gg;
    private alhu.d a;
    private int mDest;
    private Animation.AnimationListener mListener;
    private int mSrc;
    
    public b(View paramView, int paramInt1, int paramInt2, alhu.d paramd)
    {
      this.Gg = paramView;
      this.mSrc = paramInt1;
      this.mDest = paramInt2;
      this.a = paramd;
    }
    
    public void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      super.applyTransformation(paramFloat, paramTransformation);
      if ((this.mListener != null) && ((this.mListener instanceof alhu.c))) {
        ((alhu.c)this.mListener).a(this, paramFloat);
      }
      if (this.Gg == null) {
        return;
      }
      int i = this.mDest;
      if (paramFloat < 1.0F)
      {
        i = Color.argb((int)(Color.alpha(this.mSrc) + (Color.alpha(this.mDest) - Color.alpha(this.mSrc)) * paramFloat), (int)(Color.red(this.mSrc) + (Color.red(this.mDest) - Color.red(this.mSrc)) * paramFloat), (int)(Color.green(this.mSrc) + (Color.green(this.mDest) - Color.green(this.mSrc)) * paramFloat), (int)(Color.blue(this.mSrc) + (Color.blue(this.mDest) - Color.blue(this.mSrc)) * paramFloat));
        this.Gg.setBackgroundColor(i);
      }
      for (;;)
      {
        if (this.a != null) {
          this.a.mColor = i;
        }
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("LsRecord", 4, "LS applyTransformation: " + paramFloat + " CLR: " + i);
        return;
        this.Gg.setBackgroundColor(i);
        this.Gg = null;
      }
    }
    
    public void setAnimationListener(Animation.AnimationListener paramAnimationListener)
    {
      super.setAnimationListener(paramAnimationListener);
      this.mListener = paramAnimationListener;
    }
  }
  
  public static class c
    implements Animation.AnimationListener
  {
    public void a(Animation paramAnimation, float paramFloat) {}
    
    public void onAnimationEnd(Animation paramAnimation) {}
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
  
  public static class d
  {
    public float mAlpha = -1.0F;
    public int mColor = -1;
    public float yI = -1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alhu
 * JD-Core Version:    0.7.0.1
 */