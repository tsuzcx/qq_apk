import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Scroller;
import com.tencent.qphone.base.util.QLog;

public class auvn
  extends Drawable
  implements Handler.Callback
{
  private int Fy;
  private Handler V;
  private auvn.a a;
  Rect db = new Rect();
  private boolean isResume;
  private Bitmap mBitmap;
  private int mBottom;
  private int mDisplayHeight;
  private int mDisplayWidth;
  private int mHeight;
  private Paint mPaint = new Paint();
  private Scroller mScroller;
  Rect mSrcRect = new Rect();
  private int mTop;
  private int mWidth;
  
  public auvn(Context paramContext, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    this.mWidth = paramBitmap.getWidth();
    this.mHeight = paramBitmap.getHeight();
    this.mBitmap = paramBitmap;
    this.mDisplayWidth = paramInt1;
    if (this.mDisplayWidth <= 0) {
      if ((paramContext == null) || (paramContext.getResources() == null)) {
        break label301;
      }
    }
    label301:
    for (this.mDisplayWidth = (ankt.SCREEN_WIDTH - paramContext.getResources().getDimensionPixelSize(2131298881));; this.mDisplayWidth = ankt.SCREEN_WIDTH)
    {
      int i = paramInt2;
      if (paramInt2 <= 0) {
        i = ankt.dip2px(170.0F);
      }
      this.mDisplayHeight = (this.mWidth * i / this.mDisplayWidth);
      this.mTop = (this.mHeight * 15 / 100);
      this.mBottom = (this.mHeight * 85 / 100);
      if (QLog.isColorLevel()) {
        QLog.i("UpSideDownDrawable", 2, String.format("UpSideDownDrawable bw=%d bh=%d dw=%d dh=%d mDisplayHeight=%d mTop=%d mBot=%d", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(this.mDisplayHeight), Integer.valueOf(this.mTop), Integer.valueOf(this.mBottom) }));
      }
      this.V = new auru(Looper.getMainLooper(), this);
      this.mScroller = new Scroller(paramContext, new AccelerateDecelerateInterpolator());
      this.Fy = this.mTop;
      this.a = new auvn.a();
      return;
    }
  }
  
  private void exA()
  {
    this.a.fromY = (this.mBottom - this.mDisplayHeight);
    this.a.toY = (-(this.mBottom - this.mTop - this.mDisplayHeight));
    this.a.euR = 12000;
    this.a.euS = 3;
  }
  
  private void exB()
  {
    this.a.fromY = this.mTop;
    this.a.toY = (this.mBottom - this.mTop - this.mDisplayHeight);
    this.a.euR = 12000;
    this.a.euS = 2;
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.mSrcRect.set(0, this.Fy, this.mBitmap.getWidth(), this.Fy + this.mDisplayHeight);
    this.db.set(0, 0, this.mBitmap.getWidth(), this.mDisplayHeight);
    paramCanvas.drawBitmap(this.mBitmap, this.mSrcRect, this.db, this.mPaint);
  }
  
  public Bitmap getBitmap()
  {
    return this.mBitmap;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mDisplayHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mWidth;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      this.mScroller.startScroll(0, this.a.fromY, 0, this.a.toY, this.a.euR);
      this.V.sendEmptyMessage(this.a.euS);
      this.isResume = true;
      return false;
    case 2: 
      this.V.removeMessages(2);
      if (this.mScroller.computeScrollOffset())
      {
        this.Fy = this.mScroller.getCurrY();
        if (this.Fy <= this.mBottom - this.mDisplayHeight)
        {
          invalidateSelf();
          this.V.sendEmptyMessageDelayed(2, 20L);
          return false;
        }
        exA();
        this.V.sendEmptyMessage(1);
        return false;
      }
      exA();
      this.V.sendEmptyMessage(1);
      return false;
    }
    this.V.removeMessages(3);
    if (this.mScroller.computeScrollOffset())
    {
      this.Fy = this.mScroller.getCurrY();
      if (this.Fy >= this.mTop)
      {
        invalidateSelf();
        this.V.sendEmptyMessageDelayed(3, 20L);
        return false;
      }
      exB();
      this.V.sendEmptyMessage(1);
      return false;
    }
    exB();
    this.V.sendEmptyMessage(1);
    return false;
  }
  
  public void pause()
  {
    if (!this.isResume) {
      return;
    }
    if (this.V.hasMessages(2))
    {
      this.a.euS = 2;
      this.a.toY = (this.mBottom - this.mTop - this.mDisplayHeight);
    }
    for (;;)
    {
      this.a.fromY = this.Fy;
      this.a.euR = (this.mScroller.getDuration() - this.mScroller.timePassed());
      this.mScroller.abortAnimation();
      this.V.removeMessages(2);
      this.V.removeMessages(3);
      this.isResume = false;
      return;
      if (this.V.hasMessages(3))
      {
        this.a.euS = 3;
        this.a.toY = (-(this.mBottom - this.mTop - this.mDisplayHeight));
      }
    }
  }
  
  public void resume()
  {
    if (this.isResume) {
      return;
    }
    this.V.sendEmptyMessage(1);
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.mPaint.getAlpha())
    {
      this.mPaint.setAlpha(paramInt);
      super.invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
    super.invalidateSelf();
  }
  
  public void start()
  {
    if (this.isResume) {
      return;
    }
    this.a.fromY = this.mTop;
    this.a.toY = (this.mBottom - this.mTop - this.mDisplayHeight);
    this.a.euR = 12000;
    this.a.euS = 2;
    this.V.sendEmptyMessage(1);
  }
  
  public void stop()
  {
    this.V.removeMessages(1);
    this.V.removeMessages(3);
    this.V.removeMessages(2);
    this.a.fromY = this.mTop;
    this.a.toY = (this.mBottom - this.mTop - this.mDisplayHeight);
    this.a.euR = 12000;
    this.a.euS = 2;
    this.Fy = this.mTop;
    this.isResume = false;
    invalidateSelf();
  }
  
  class a
  {
    public int euR;
    public int euS;
    public int fromY;
    public int toY;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auvn
 * JD-Core Version:    0.7.0.1
 */