import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFramesFetcher;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFramesRetriever;
import com.tencent.qphone.base.util.QLog;

public class aauy
  implements aauw.a
{
  public static final boolean Ll;
  private aauw jdField_a_of_type_Aauw;
  private aaux jdField_a_of_type_Aaux;
  private aauy.b jdField_a_of_type_Aauy$b;
  private aava jdField_a_of_type_Aava;
  private float[] aS = { 0.33F, 0.5F, 0.11F, 0.0F, -50.0F, 0.33F, 0.5F, 0.11F, 0.0F, -50.0F, 0.33F, 0.5F, 0.11F, 0.0F, -50.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  private Paint bf = new Paint();
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
  private GestureDetector.OnGestureListener mGestureListener = new aauz(this);
  private Paint mPaint = new Paint();
  private Rect mRect = new Rect();
  private Scroller mScroller;
  private int mTotalFrameCount;
  private float mm;
  private float of;
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
  
  public aauy(aaux paramaaux, String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, float paramFloat3, int paramInt4)
  {
    this.jdField_a_of_type_Aaux = paramaaux;
    this.fX = paramFloat1;
    this.fY = paramFloat2;
    this.mTotalFrameCount = paramInt2;
    this.of = paramInt3;
    this.rT = (1.0F * paramInt1 / paramInt4 * paramFloat1);
    this.rU = Math.max(this.rT - paramInt2 * paramFloat1, 0.0F);
    this.rV = 0.0F;
    if (QLog.isColorLevel()) {
      QLog.d("FramesProcessor", 2, "mTotalRange=" + this.rT + ", mMaxMovedDistance=" + this.rU);
    }
    this.rR = 0.0F;
    this.mBitmap = Bitmap.createBitmap(paramInt3, (int)this.fY, Bitmap.Config.RGB_565);
    this.mCanvas = new Canvas(this.mBitmap);
    this.bf.setColorFilter(new ColorMatrixColorFilter(this.aS));
    this.mm = paramFloat3;
    this.bv = new Rect(0, 0, (int)paramFloat3, (int)this.fY);
    this.bw = new Rect((int)(Math.min(1.0F * paramInt1 / paramInt4 * paramFloat1, paramInt2 * paramFloat1) + paramFloat3), 0, paramInt3, (int)this.fY);
    this.mScroller = new Scroller(this.jdField_a_of_type_Aaux.getContext());
    this.mGestureDetector = new GestureDetector(this.jdField_a_of_type_Aaux.getContext(), this.mGestureListener);
    this.jdField_a_of_type_Aauw = new aauw(this);
    this.ckK = ((int)Math.ceil(1.0F * paramInt3 / this.fX));
    this.ckK = Math.min(this.ckK, paramInt2);
    this.ckL = this.ckK;
    this.ckJ = 0;
    if (Ll) {}
    for (this.jdField_a_of_type_Aava = new VideoFramesRetriever(paramString, paramFloat1);; this.jdField_a_of_type_Aava = new VideoFramesFetcher())
    {
      this.jdField_a_of_type_Aava.a(paramInt4, paramInt1, this.jdField_a_of_type_Aauw);
      this.jdField_a_of_type_Aava.gw(this.ckJ, this.ckK);
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
      if (this.jdField_a_of_type_Aaux != null) {
        this.jdField_a_of_type_Aaux.invalidate();
      }
      float f1 = this.rR;
      float f2 = this.rS;
      this.rS = this.rR;
      if (!E(f1 - f2, 0.0F)) {
        break label158;
      }
    }
    label158:
    while (this.jdField_a_of_type_Aauy$b == null)
    {
      return;
      this.jdField_a_of_type_Aava.gw(this.ckJ, this.ckK);
      break;
    }
    this.jdField_a_of_type_Aauy$b.e(this.rR, -this.rR, this.rT - this.rR);
  }
  
  private void cyH()
  {
    if ((this.jdField_a_of_type_Aauw == null) || (this.jdField_a_of_type_Aauw.isEmpty())) {}
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
    this.jdField_a_of_type_Aaux.invalidate();
  }
  
  public void Gz(int paramInt)
  {
    int i = this.bv.right;
    float f = this.rV;
    this.rV = (i - paramInt + f);
    this.bv.right = paramInt;
    this.jdField_a_of_type_Aaux.invalidate();
  }
  
  public void a(aauy.b paramb)
  {
    this.jdField_a_of_type_Aauy$b = paramb;
    if (this.jdField_a_of_type_Aauy$b != null) {
      this.jdField_a_of_type_Aauy$b.e(this.rR, -this.rR, this.rT - this.rR);
    }
  }
  
  public void destroy()
  {
    this.jdField_a_of_type_Aauy$b = null;
    if (this.jdField_a_of_type_Aava != null) {
      this.jdField_a_of_type_Aava.release();
    }
    if (this.jdField_a_of_type_Aauw != null) {
      this.jdField_a_of_type_Aauw.destroy();
    }
    this.jdField_a_of_type_Aauw = null;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Aauw == null) {
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
      aauy.a locala = this.jdField_a_of_type_Aauw.a(i);
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
  
  public boolean hasChanged()
  {
    return !E(this.rR, 0.0F);
  }
  
  public void onChanged()
  {
    this.jdField_a_of_type_Aaux.postInvalidate();
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
  }
  
  public static abstract interface b
  {
    public abstract void e(float paramFloat1, float paramFloat2, float paramFloat3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aauy
 * JD-Core Version:    0.7.0.1
 */