import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.support.annotation.NonNull;
import android.view.animation.LinearInterpolator;
import com.etrump.mixlayout.ETFont;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public abstract class k
{
  public int[] M = { -1, -1 };
  public ValueAnimator a;
  protected Canvas c = new Canvas();
  public Bitmap d;
  public int frameIndex;
  public ETFont mFont;
  
  public abstract void O();
  
  protected void P()
  {
    this.a = ValueAnimator.ofInt(new int[] { 0, this.M[0] });
    this.a.setDuration(this.M[0] * this.M[1]);
    this.a.setRepeatCount(0);
    this.a.setInterpolator(new LinearInterpolator());
  }
  
  protected void Q()
  {
    if (this.c == null) {
      this.c = new Canvas();
    }
    this.c.setBitmap(this.d);
    this.c.drawColor(0, PorterDuff.Mode.CLEAR);
  }
  
  public void V()
  {
    if ((this.a != null) && (this.a.isRunning()) && (this.frameIndex > 0))
    {
      j.i("FounderBaseLayout", "PauseAnimation...... animInfo:" + Arrays.toString(this.M) + "  frameIndex:" + this.frameIndex);
      this.a.cancel();
      this.mFont.mShouldDisplayAnimation = false;
    }
  }
  
  public void W()
  {
    if ((this.mFont == null) || (this.M[0] <= 0) || (this.M[1] <= 0)) {}
    while ((this.a == null) || (this.a.isRunning()) || (this.frameIndex <= 0) || (this.frameIndex >= this.M[0])) {
      return;
    }
    j.i("FounderBaseLayout", "RestartAnimation...... animInfo:" + Arrays.toString(this.M) + "  frameIndex:" + this.frameIndex);
    this.mFont.mShouldDisplayAnimation = true;
    this.a.setIntValues(new int[] { this.frameIndex, this.M[0] });
    this.a.setDuration((this.M[0] - this.frameIndex) * this.M[1]);
    this.a.start();
  }
  
  public void X()
  {
    this.mFont.mShouldDisplayAnimation = true;
    if (this.a == null)
    {
      P();
      this.a.start();
    }
    while (this.a.isRunning()) {
      return;
    }
    this.a.setIntValues(new int[] { this.M[0] });
    this.a.setDuration(this.M[0] * this.M[1]);
    this.a.start();
  }
  
  public abstract int a(int paramInt1, int paramInt2, lc paramlc);
  
  public abstract int[] a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, ETFont paramETFont)
    throws Exception;
  
  protected boolean c(int paramInt1, int paramInt2)
  {
    try
    {
      if (this.d == null) {
        this.d = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      } else if ((paramInt1 > this.d.getWidth()) || (paramInt2 > this.d.getHeight()) || ((paramInt1 << 1 < this.d.getWidth()) && (paramInt2 << 1 < this.d.getHeight()))) {
        this.d = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("FounderBaseLayout", 2, "FounderColorLayout#createNewWordBitmapIfNeed w=" + paramInt1 + " h=" + paramInt2, localOutOfMemoryError);
      return false;
    }
    return true;
  }
  
  public void clearAnimation()
  {
    u(true);
    this.a = null;
    this.frameIndex = 0;
    this.M[0] = -1;
    this.M[1] = -1;
  }
  
  protected String getTag()
  {
    if (i.isDebug) {
      return getClass().getSimpleName();
    }
    return "BaseLayout";
  }
  
  public abstract boolean onDraw(Canvas paramCanvas);
  
  public void release()
  {
    j.i("FounderBaseLayout", "release....");
    if (this.d != null)
    {
      this.d.recycle();
      this.d = null;
    }
    if (this.a != null)
    {
      this.a.cancel();
      this.a = null;
    }
    this.c = null;
  }
  
  public void u(boolean paramBoolean)
  {
    this.frameIndex = 0;
    this.mFont.mShouldDisplayAnimation = false;
    if (this.a != null)
    {
      j.i("FounderBaseLayout", "StopAnimation......");
      this.a.cancel();
    }
  }
  
  public static abstract interface a
  {
    public abstract void clearHighlightContent();
    
    public abstract void f(int paramInt1, int paramInt2);
    
    public abstract void locationByIndex(int paramInt, @NonNull int[] paramArrayOfInt, boolean paramBoolean);
    
    public abstract int touchIndex(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     k
 * JD-Core Version:    0.7.0.1
 */