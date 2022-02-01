import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.util.QZLog;

public class awij
  extends Drawable
  implements Animatable
{
  private awij.b a;
  public awij.a b;
  private boolean dqn;
  private boolean dqo;
  private boolean mRunning;
  private float mScale = 1.0F;
  long startTime;
  Handler uiHandler = new awil(this, Looper.getMainLooper());
  private boolean xp;
  
  public awij()
  {
    this.a = new awij.b(null);
  }
  
  public awij(awij.b paramb)
  {
    this.a = paramb;
  }
  
  public awij(String paramString, int paramInt)
  {
    this.a = new awij.b(null);
    hb(paramString, paramInt);
  }
  
  public void GE(int paramInt)
  {
    if ((this.a != null) && (this.a.c != null)) {
      this.a.c.a(paramInt, null);
    }
  }
  
  public String GY()
  {
    return this.a.Gs;
  }
  
  public void Xb(boolean paramBoolean)
  {
    this.dqo = paramBoolean;
  }
  
  public void Xc(boolean paramBoolean)
  {
    this.dqn = paramBoolean;
  }
  
  public void a(awij.a parama)
  {
    this.b = parama;
  }
  
  public void a(awiq paramawiq)
  {
    if (this.a.c != null) {
      this.a.c.a(paramawiq);
    }
  }
  
  public boolean aMy()
  {
    return (this.a != null) && (this.a.Hw);
  }
  
  public boolean aMz()
  {
    if ((this.a == null) || (this.a.c == null)) {}
    while (this.a.c.bi() == null) {
      return false;
    }
    return true;
  }
  
  public void acs(int paramInt)
  {
    if ((this.a != null) && (this.a.c != null)) {
      this.a.c.acs(paramInt);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((!this.mRunning) && (!this.dqn) && (!this.xp)) {}
    Drawable localDrawable;
    do
    {
      do
      {
        return;
      } while (!this.a.Hw);
      localDrawable = this.a.c.bi();
    } while (localDrawable == null);
    localDrawable.setBounds(getBounds());
    localDrawable.draw(paramCanvas);
  }
  
  @Deprecated
  public void eDG()
  {
    this.a.c.release();
  }
  
  public void eDH()
  {
    this.xp = true;
    this.a.c.a(new awik(this));
  }
  
  public int getDuration()
  {
    return this.a.Qe();
  }
  
  public int getIntrinsicHeight()
  {
    Drawable localDrawable;
    if (this.a.c != null)
    {
      localDrawable = this.a.c.bi();
      if (localDrawable != null) {}
    }
    else
    {
      return -1;
    }
    return (int)(localDrawable.getIntrinsicHeight() * this.mScale);
  }
  
  public int getIntrinsicWidth()
  {
    Drawable localDrawable;
    if (this.a.c != null)
    {
      localDrawable = this.a.c.bi();
      if (localDrawable != null) {}
    }
    else
    {
      return -1;
    }
    return (int)(localDrawable.getIntrinsicWidth() * this.mScale);
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void hb(String paramString, int paramInt)
  {
    this.a.hb(paramString, paramInt);
  }
  
  public boolean isRunning()
  {
    return this.mRunning;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.a.onBoundsChange(paramRect);
    super.onBoundsChange(paramRect);
  }
  
  public void release()
  {
    if ((this.a != null) && (this.a.c != null)) {
      this.a.c.release();
    }
  }
  
  public void restartAnimation()
  {
    this.mRunning = true;
    if (!this.a.Hw) {
      return;
    }
    this.a.c.a(0, null);
    this.mRunning = true;
    this.startTime = SystemClock.uptimeMillis();
    this.uiHandler.removeMessages(1000);
    this.uiHandler.sendEmptyMessageDelayed(1000, 1000 / this.a.frameRate);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void setScale(float paramFloat)
  {
    this.mScale = paramFloat;
    if (this.a.c != null) {
      this.a.c.setScale(this.mScale);
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (isVisible() != paramBoolean1)
    {
      i = 1;
      if (i != 0)
      {
        if (!paramBoolean1) {
          break label48;
        }
        if (this.mRunning) {
          this.uiHandler.sendEmptyMessage(1000);
        }
      }
    }
    for (;;)
    {
      return super.setVisible(paramBoolean1, paramBoolean2);
      i = 0;
      break;
      label48:
      this.uiHandler.removeMessages(1000);
    }
  }
  
  public void start()
  {
    this.mRunning = true;
    if (!this.a.Hw) {
      return;
    }
    restartAnimation();
  }
  
  public void stop()
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("ZipAnimationDrawable", 2, "stop");
    }
    this.uiHandler.removeMessages(1000);
    this.mRunning = false;
  }
  
  public void unscheduleSelf(Runnable paramRunnable)
  {
    this.mRunning = false;
    super.unscheduleSelf(paramRunnable);
  }
  
  public static abstract interface a
  {
    public abstract void onAnimationFinished();
    
    public abstract void onDrawableLoaded();
  }
  
  public final class b
    extends Drawable.ConstantState
  {
    String Gs;
    boolean Hw;
    awir b;
    awin c;
    int frameRate = 30;
    
    private b() {}
    
    public int Qe()
    {
      return getChildCount() * 1000 / this.frameRate;
    }
    
    public int getChangingConfigurations()
    {
      return 0;
    }
    
    public int getChildCount()
    {
      if (this.c == null) {
        return 0;
      }
      return this.c.getFrameCount();
    }
    
    public void hb(String paramString, int paramInt)
    {
      if ((this.Gs != null) && (!this.Gs.equals(paramString))) {
        this.Hw = false;
      }
      if (this.c == null)
      {
        this.c = new awin(BaseApplicationImpl.getApplication());
        if (this.b == null) {
          this.b = new awim(this);
        }
        this.c.a(this.b);
        if ((!this.Hw) || (this.Gs == null) || (!this.Gs.equals(paramString)))
        {
          if (!URLUtil.isNetworkUrl(paramString)) {
            break label148;
          }
          this.c.E(paramString, -1, true);
        }
      }
      for (;;)
      {
        if (paramInt > 0) {
          this.frameRate = paramInt;
        }
        this.Gs = paramString;
        return;
        if (this.Hw) {
          break;
        }
        this.c.release();
        break;
        label148:
        this.c.dO(paramString, true);
      }
    }
    
    public Drawable newDrawable()
    {
      return new awij(this);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      return new awij(this);
    }
    
    public void onBoundsChange(Rect paramRect)
    {
      this.c.onBoundsChange(paramRect);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awij
 * JD-Core Version:    0.7.0.1
 */