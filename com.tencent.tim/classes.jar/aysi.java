import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Property;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerContainer;

public class aysi
  extends Drawable
  implements Animatable
{
  private float Gr;
  Property<aysi, Integer> b = new aysk(this, Integer.class, "backAlpha");
  private ValueAnimator d;
  private boolean dAA;
  private boolean dAB;
  private Rect dv = new Rect();
  private int eME = 255;
  Property<aysi, Float> j = new aysj(this, Float.class, "backScale");
  private Context mContext;
  private Drawable mDrawable;
  private float mHeight;
  private float mScale;
  private int mState = 0;
  private String mText;
  private float mWidth;
  
  private int Sb()
  {
    return this.eME;
  }
  
  private void afu(int paramInt)
  {
    this.eME = paramInt;
  }
  
  private void bH(float paramFloat)
  {
    this.Gr = paramFloat;
    int i = this.dv.centerX();
    int k = this.dv.centerY();
    int m = (int)(this.mWidth * (paramFloat - 1.0F)) / 2;
    int n = (int)(this.mHeight * (paramFloat - 1.0F)) / 2;
    this.dv.set((int)(i - m - this.mWidth / 2.0F), (int)(k - n - this.mHeight / 2.0F), (int)(i + m + this.mWidth / 2.0F), (int)(k + n + this.mHeight / 2.0F));
  }
  
  private float cl()
  {
    return this.Gr;
  }
  
  private void lC(int paramInt1, int paramInt2)
  {
    if (this.d != null)
    {
      this.d.cancel();
      this.d.removeAllUpdateListeners();
      this.d = null;
    }
    if (paramInt1 == 1)
    {
      this.d = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(this.j, new float[] { this.mScale, 1.0F }), PropertyValuesHolder.ofInt(this.b, new int[] { 0, 255 }) });
      this.d.setDuration(paramInt2);
    }
    for (;;)
    {
      if (this.d != null)
      {
        this.d.setRepeatMode(1);
        this.d.setRepeatCount(0);
        this.d.setStartDelay(0L);
        this.d.addUpdateListener(new aysl(this));
        this.d.addListener(new aysm(this));
        this.d.start();
      }
      return;
      if (paramInt1 == 2)
      {
        this.d = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(this.b, new int[] { 255, 0 }) });
        this.d.setDuration(paramInt2);
      }
    }
  }
  
  private Drawable x(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.mContext == null)) {}
    for (;;)
    {
      return null;
      try
      {
        if ("1/4".equals(paramString)) {
          return this.mContext.getResources().getDrawable(2130842327);
        }
        if ("1/2".equals(paramString)) {
          return this.mContext.getResources().getDrawable(2130842326);
        }
        if ("1x".equals(paramString)) {
          return this.mContext.getResources().getDrawable(2130842328);
        }
        if ("2x".equals(paramString)) {
          return this.mContext.getResources().getDrawable(2130842329);
        }
        if ("4x".equals(paramString)) {
          return this.mContext.getResources().getDrawable(2130842330);
        }
        if (PickerContainer.cXS.equals(paramString))
        {
          paramString = this.mContext.getResources().getDrawable(2130842331);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        QLog.e("HintDrawable", 2, "getDrawableByText exception:" + paramString.toString());
        return null;
      }
      catch (OutOfMemoryError paramString)
      {
        QLog.e("HintDrawable", 2, "getDrawableByText OOM!!");
      }
    }
    return null;
  }
  
  public int Sf()
  {
    return this.mState;
  }
  
  public void ZN(boolean paramBoolean)
  {
    this.dAB = paramBoolean;
  }
  
  public boolean a(Context paramContext, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramContext == null) {
      return false;
    }
    this.mWidth = paramFloat1;
    this.mHeight = paramFloat2;
    this.mScale = paramFloat3;
    this.mContext = paramContext;
    return true;
  }
  
  public void afv(int paramInt)
  {
    this.mState = paramInt;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mState == 0) {}
    while (this.mDrawable == null) {
      return;
    }
    this.mDrawable.setAlpha(this.eME);
    this.mDrawable.setBounds(this.dv);
    this.mDrawable.draw(paramCanvas);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isRunning()
  {
    return this.dAA;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.dv.set(paramRect);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void start()
  {
    if (isRunning()) {
      stop();
    }
    this.dAA = true;
    if (QLog.isColorLevel()) {
      QLog.d("HintDrawable", 2, "start :" + this.mState);
    }
    lC(this.mState, 150);
  }
  
  public void stop()
  {
    if (!this.dAA) {}
    do
    {
      return;
      this.dAA = false;
    } while (this.d == null);
    this.d.cancel();
    this.d.removeAllUpdateListeners();
    this.d = null;
  }
  
  public void unInit()
  {
    this.dAA = false;
    this.mContext = null;
    this.mDrawable = null;
    if (this.d != null)
    {
      this.d.cancel();
      this.d.removeAllUpdateListeners();
      this.d = null;
    }
    this.j = null;
    this.b = null;
  }
  
  public boolean up(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (paramString.equals(this.mText)) {
      return false;
    }
    this.mText = paramString;
    this.mDrawable = x(paramString);
    invalidateSelf();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aysi
 * JD-Core Version:    0.7.0.1
 */