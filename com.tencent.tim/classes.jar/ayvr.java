import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Scroller;
import com.tencent.qphone.base.util.QLog;

public class ayvr
  implements ayvp.a
{
  public static final boolean Ll;
  private ayvp jdField_a_of_type_Ayvp;
  private ayvq jdField_a_of_type_Ayvq;
  private ayvr.b jdField_a_of_type_Ayvr$b;
  private ayvs jdField_a_of_type_Ayvs;
  private Paint bf;
  private Rect bv;
  private Rect bw;
  private int ckJ;
  private int ckK;
  private final int ckL;
  private float fX;
  private float fY;
  private Bitmap mBitmap;
  private Canvas mCanvas;
  private GestureDetector mGestureDetector;
  private Paint mPaint;
  private Rect mRect;
  private Scroller mScroller;
  private int mTotalFrameCount;
  private float mm;
  private float rR;
  private float rS;
  private float rT;
  private float rU;
  private float rV;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 10) {}
    for (boolean bool = true;; bool = false)
    {
      Ll = bool;
      return;
    }
  }
  
  private boolean E(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) == 0.0F;
  }
  
  private void computeScroll()
  {
    this.mCanvas.drawColor(-16777216);
    if (this.mScroller.computeScrollOffset())
    {
      this.rR = this.mScroller.getCurrX();
      if (this.rR < this.rV)
      {
        this.rR = this.rV;
        this.mScroller.forceFinished(true);
      }
      if (this.rR > this.rU)
      {
        this.rR = this.rU;
        this.mScroller.forceFinished(true);
      }
      cyH();
      if (this.jdField_a_of_type_Ayvq != null) {
        this.jdField_a_of_type_Ayvq.invalidate();
      }
      float f1 = this.rR;
      float f2 = this.rS;
      this.rS = this.rR;
      if (!E(f1 - f2, 0.0F)) {
        break label157;
      }
    }
    label157:
    while (this.jdField_a_of_type_Ayvr$b == null)
    {
      return;
      this.jdField_a_of_type_Ayvs.gw(this.ckJ, this.ckK);
      break;
    }
    this.jdField_a_of_type_Ayvr$b.e(this.rR, -this.rR, this.rT - this.rR);
  }
  
  private void cyH()
  {
    if ((this.jdField_a_of_type_Ayvp == null) || (this.jdField_a_of_type_Ayvp.isEmpty())) {}
    int i;
    do
    {
      return;
      i = (int)(this.rR / this.fX);
      this.ckJ = Math.max(i, 0);
    } while (this.ckL < 6);
    this.ckK = Math.min(i + this.ckL, this.mTotalFrameCount);
  }
  
  public void GA(int paramInt)
  {
    int i = this.bw.left;
    float f = this.rU;
    this.rU = (i - paramInt + f);
    this.bw.left = paramInt;
    this.jdField_a_of_type_Ayvq.invalidate();
  }
  
  public void Gz(int paramInt)
  {
    int i = this.bv.right;
    float f = this.rV;
    this.rV = (i - paramInt + f);
    this.bv.right = paramInt;
    this.jdField_a_of_type_Ayvq.invalidate();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Ayvp == null) {
      return;
    }
    computeScroll();
    int i = Math.max(this.ckJ - 1, 0);
    float f = i;
    f = this.fX * f;
    this.mCanvas.translate(f - this.rR + this.mm, 0.0F);
    int k = Math.min(this.ckK + 3, this.mTotalFrameCount);
    int j = (int)this.fX;
    while (i < k)
    {
      ayvr.a locala = this.jdField_a_of_type_Ayvp.a(i);
      if (locala != null)
      {
        j = (int)Math.min(this.rT - f, this.fX);
        this.mRect.set(0, 0, j, (int)this.fY);
        this.mCanvas.drawBitmap(locala.ey, this.mRect, this.mRect, this.mPaint);
      }
      this.mCanvas.translate(j, 0.0F);
      f += j;
      i += 1;
    }
    this.mCanvas.translate(-f + this.rR - this.mm, 0.0F);
    paramCanvas.drawBitmap(this.mBitmap, 0.0F, 0.0F, this.mPaint);
    paramCanvas.drawBitmap(this.mBitmap, this.bv, this.bv, this.bf);
    paramCanvas.drawBitmap(this.mBitmap, this.bw, this.bw, this.bf);
  }
  
  public void onChanged()
  {
    this.jdField_a_of_type_Ayvq.postInvalidate();
  }
  
  public void processTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mGestureDetector != null) {
      this.mGestureDetector.onTouchEvent(paramMotionEvent);
    }
  }
  
  public static class a
  {
    public Bitmap ey;
    public int index;
    
    protected void finalize()
      throws Throwable
    {
      super.finalize();
      if ((this.ey != null) && (!this.ey.isRecycled()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Frames", 2, "recycle bitmap");
        }
        this.ey.recycle();
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void e(float paramFloat1, float paramFloat2, float paramFloat3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayvr
 * JD-Core Version:    0.7.0.1
 */