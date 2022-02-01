import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.tencent.qphone.base.util.QLog;

public class ayrt
  extends Drawable
  implements Animatable
{
  Property<ayrt, Integer> b = new ayru(this, Integer.class, "backAlpha");
  private RectF bS = new RectF();
  private ValueAnimator d;
  private boolean dAA;
  private boolean dAB;
  private int eME = 127;
  private Paint mPaint;
  private int mState = 0;
  
  private int Sb()
  {
    return this.eME;
  }
  
  private void afu(int paramInt)
  {
    this.eME = paramInt;
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
      this.d = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(this.b, new int[] { 0, 127 }) });
      this.d.setDuration(paramInt2);
    }
    for (;;)
    {
      if (this.d != null)
      {
        this.d.setRepeatMode(1);
        this.d.setRepeatCount(0);
        this.d.setStartDelay(0L);
        this.d.addUpdateListener(new ayrv(this));
        this.d.addListener(new ayrw(this));
        this.d.start();
      }
      return;
      if (paramInt1 == 2)
      {
        this.d = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(this.b, new int[] { 127, 0 }) });
        this.d.setDuration(paramInt2);
      }
    }
  }
  
  public void ZN(boolean paramBoolean)
  {
    this.dAB = paramBoolean;
  }
  
  public void afv(int paramInt)
  {
    this.mState = paramInt;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mState == 0) {
      return;
    }
    this.mPaint.setAlpha(this.eME);
    paramCanvas.drawRect(this.bS, this.mPaint);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean init(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    if (this.mPaint == null)
    {
      this.mPaint = new Paint();
      this.mPaint.setAntiAlias(true);
    }
    this.mPaint.setColor(0);
    return true;
  }
  
  public boolean isRunning()
  {
    return this.dAA;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.bS.set(paramRect);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.mPaint != null) {
      this.mPaint.setColorFilter(paramColorFilter);
    }
  }
  
  public void start()
  {
    if (isRunning()) {
      stop();
    }
    this.dAA = true;
    if (QLog.isColorLevel()) {
      QLog.d("HintDrawable", 2, "start :" + this.mState);
    }
    if (this.mState == 1)
    {
      j = this.mState;
      if (this.dAB)
      {
        i = 150;
        lC(j, i);
      }
    }
    while (this.mState != 2) {
      for (;;)
      {
        int j;
        return;
        int i = 300;
      }
    }
    lC(this.mState, 200);
  }
  
  public void stop()
  {
    if (!this.dAA) {
      return;
    }
    this.dAA = false;
    if (this.d != null)
    {
      this.d.cancel();
      this.d.removeAllUpdateListeners();
      this.d = null;
    }
    this.mState = 0;
  }
  
  public void unInit()
  {
    this.dAA = false;
    this.mPaint = null;
    if (this.d != null)
    {
      this.d.cancel();
      this.d.removeAllUpdateListeners();
      this.d = null;
    }
    this.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayrt
 * JD-Core Version:    0.7.0.1
 */