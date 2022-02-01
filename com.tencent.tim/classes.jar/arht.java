import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.lang.ref.WeakReference;

public class arht
  extends Drawable
{
  static LruCache<String, Typeface> J = new LruCache(8);
  public float BP = 4.0F;
  float BQ;
  public arht.a a = new arht.a();
  RectF bl;
  RectF bm;
  public String cAw;
  private Paint cG;
  WeakReference<arht.b> dQ;
  public boolean dba;
  public boolean dbb;
  public boolean dbc = true;
  public boolean dbd = true;
  private boolean dbe;
  public boolean dbf = true;
  private boolean dbg;
  public int ehH = -90;
  public int ehI = 1;
  public int ehJ = 25;
  public Drawable gi;
  public int mAnimationStep = 2;
  public Paint mBackgroundPaint;
  public WeakReference<Context> mContext;
  DisplayMetrics mDisplayMetrics;
  Rect mImageRect;
  public int mMax = 100;
  public int mProgress = 0;
  public Paint mProgressPaint;
  public boolean mShowText = true;
  public Paint mStrokePaint;
  public float mStrokeWidth = 1.5F;
  public String mText;
  public Paint mTextPaint;
  public float mTextSize = 14.0F;
  
  public arht(Context paramContext)
  {
    this.mContext = new WeakReference(paramContext);
    init(paramContext);
  }
  
  public void TM(boolean paramBoolean)
  {
    this.dbg = paramBoolean;
  }
  
  public void YE(int paramInt)
  {
    this.BQ = paramInt;
  }
  
  public void YF(int paramInt)
  {
    this.a.removeMessages(0);
    if (!mJ(paramInt)) {
      throw new IllegalArgumentException(String.format("Animation progress (%d) is greater than the max progress (%d) or lower than 0 ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mMax) }));
    }
    this.a.YG(paramInt);
    this.a.sendEmptyMessage(0);
    invalidateSelf();
  }
  
  public void a(arht.b paramb)
  {
    this.dQ = new WeakReference(paramb);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (!isVisible()) {
      return;
    }
    Rect localRect = getBounds();
    this.bl.set(0.0F, 0.0F, this.BQ, this.BQ);
    this.bl.offset((localRect.width() - this.BQ) / 2.0F, (localRect.height() - this.BQ) / 2.0F);
    int i;
    if (this.dbc)
    {
      i = (int)(this.mStrokePaint.getStrokeWidth() / 2.0F + 0.5F);
      this.bl.inset(i, i);
    }
    float f3 = this.bl.centerX();
    float f4 = this.bl.centerY();
    float f2;
    float f1;
    if (this.dbf)
    {
      this.bm.set(this.bl);
      paramCanvas.drawArc(this.bm, 0.0F, 360.0F, true, this.mBackgroundPaint);
      switch (this.ehI)
      {
      default: 
        throw new IllegalArgumentException("Invalid Progress Fill = " + this.ehI);
      case 0: 
      case 1: 
        f2 = this.mProgress * 360 / this.mMax;
        f1 = f2;
        if (this.dba) {
          f1 = f2 - 360.0F;
        }
        if (this.dbb) {
          f1 = -f1;
        }
        break;
      }
    }
    for (;;)
    {
      if (this.ehI == 0)
      {
        if (this.dbg) {
          paramCanvas.drawArc(this.bm, 0.0F, 360.0F, true, this.cG);
        }
        paramCanvas.drawArc(this.bm, this.ehH, f1, true, this.mProgressPaint);
        label298:
        if ((!TextUtils.isEmpty(this.mText)) && (this.mShowText))
        {
          if (!TextUtils.isEmpty(this.cAw))
          {
            Typeface localTypeface2 = (Typeface)J.get(this.cAw);
            Typeface localTypeface1 = localTypeface2;
            if (localTypeface2 == null)
            {
              localTypeface1 = localTypeface2;
              if (getResources() != null)
              {
                AssetManager localAssetManager = getResources().getAssets();
                localTypeface1 = localTypeface2;
                if (localAssetManager != null)
                {
                  localTypeface1 = Typeface.createFromAsset(localAssetManager, this.cAw);
                  J.put(this.cAw, localTypeface1);
                }
              }
            }
            this.mTextPaint.setTypeface(localTypeface1);
          }
          i = (int)f3;
          int j = (int)(f4 - (this.mTextPaint.descent() + this.mTextPaint.ascent()) / 2.0F);
          paramCanvas.drawText(this.mText, i, j, this.mTextPaint);
        }
        if ((this.gi != null) && (this.dbd))
        {
          if (!this.dbe) {
            break label674;
          }
          this.mImageRect.set(0, 0, localRect.width(), localRect.height());
        }
      }
      for (;;)
      {
        this.gi.setBounds(this.mImageRect);
        this.gi.draw(paramCanvas);
        if ((!this.dbc) || (!this.dbf)) {
          break;
        }
        paramCanvas.drawOval(this.bl, this.mStrokePaint);
        return;
        i = (int)(this.mProgressPaint.getStrokeWidth() / 2.0F + 0.5F);
        this.bm.inset(i, i);
        if (this.dbg) {
          paramCanvas.drawArc(this.bm, 0.0F, 360.0F, false, this.cG);
        }
        paramCanvas.drawArc(this.bm, this.ehH, f1, false, this.mProgressPaint);
        break label298;
        f2 = this.BQ / 2.0F * (this.mProgress / this.mMax);
        f1 = f2;
        if (this.dbc) {
          f1 = f2 + 0.5F - this.mStrokePaint.getStrokeWidth();
        }
        paramCanvas.drawCircle(f3, f4, f1, this.mProgressPaint);
        break label298;
        label674:
        i = this.gi.getIntrinsicWidth();
        this.mImageRect.set(0, 0, i, i);
        this.mImageRect.offset((localRect.width() - i) / 2, (localRect.height() - i) / 2);
      }
    }
  }
  
  public int getIntrinsicHeight()
  {
    return (int)this.BQ;
  }
  
  public int getIntrinsicWidth()
  {
    return (int)this.BQ;
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public int getProgress()
  {
    return this.mProgress;
  }
  
  public Resources getResources()
  {
    if (this.mContext.get() == null) {
      return null;
    }
    return ((Context)this.mContext.get()).getResources();
  }
  
  void init(Context paramContext)
  {
    this.mDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    this.mStrokeWidth *= this.mDisplayMetrics.density;
    this.BP *= this.mDisplayMetrics.density;
    this.mTextSize *= this.mDisplayMetrics.scaledDensity;
    this.mBackgroundPaint = new Paint(1);
    this.mBackgroundPaint.setColor(0);
    this.mBackgroundPaint.setStyle(Paint.Style.FILL);
    this.cG = new Paint(1);
    this.cG.setColor(-1493172225);
    this.mProgressPaint = new Paint(1);
    this.mProgressPaint.setColor(16777215);
    if (this.ehI == 1)
    {
      this.mProgressPaint.setStyle(Paint.Style.STROKE);
      this.mProgressPaint.setStrokeWidth(this.BP);
      this.cG.setStyle(Paint.Style.STROKE);
      this.cG.setStrokeWidth(this.BP);
    }
    for (;;)
    {
      this.mStrokePaint = new Paint(1);
      this.mStrokePaint.setColor(16777215);
      this.mStrokePaint.setStyle(Paint.Style.STROKE);
      this.mStrokePaint.setStrokeWidth(this.mStrokeWidth);
      this.mTextPaint = new Paint(1);
      this.mTextPaint.setColor(3355443);
      this.mTextPaint.setTextSize(this.mTextSize);
      this.mTextPaint.setTextAlign(Paint.Align.CENTER);
      this.bl = new RectF();
      this.mImageRect = new Rect();
      this.bm = new RectF();
      return;
      this.mProgressPaint.setStyle(Paint.Style.FILL);
      this.cG.setStyle(Paint.Style.FILL);
    }
  }
  
  public boolean mJ(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= this.mMax);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    return super.onLevelChange(paramInt);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setBackgroundColor(int paramInt)
  {
    this.mBackgroundPaint.setColor(paramInt);
    invalidateSelf();
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setBounds(Rect paramRect)
  {
    super.setBounds(paramRect);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void setDrawImageFillView(boolean paramBoolean)
  {
    this.dbe = paramBoolean;
  }
  
  public void setProgress(int paramInt)
  {
    if (!mJ(paramInt)) {
      throw new IllegalArgumentException(String.format("Progress (%d) must be between %d and %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0), Integer.valueOf(this.mMax) }));
    }
    this.mProgress = paramInt;
    arht.b localb;
    if (this.dQ != null)
    {
      localb = (arht.b)this.dQ.get();
      if (localb != null)
      {
        if (this.mProgress != this.mMax) {
          break label100;
        }
        localb.a(this);
      }
    }
    for (;;)
    {
      invalidateSelf();
      return;
      label100:
      localb.a(this, this.mProgress, this.mMax);
    }
  }
  
  public void setProgressColor(int paramInt)
  {
    this.mProgressPaint.setColor(paramInt);
    invalidateSelf();
  }
  
  public void setProgressStrokeWidth(int paramInt)
  {
    if (this.mProgressPaint.getStyle() == Paint.Style.STROKE)
    {
      this.BP = (paramInt * this.mDisplayMetrics.density);
      this.mProgressPaint.setStrokeWidth(this.BP);
      this.cG.setStrokeWidth(this.BP);
      invalidateSelf();
    }
  }
  
  public void setShowImage(boolean paramBoolean)
  {
    this.dbd = paramBoolean;
    invalidateSelf();
  }
  
  public void setShowStroke(boolean paramBoolean)
  {
    this.dbc = paramBoolean;
    invalidateSelf();
  }
  
  public void setShowText(boolean paramBoolean)
  {
    this.mShowText = paramBoolean;
    invalidateSelf();
  }
  
  public void setText(String paramString)
  {
    this.mText = paramString;
    invalidateSelf();
  }
  
  public void setTextColor(int paramInt)
  {
    this.mTextPaint.setColor(paramInt);
    invalidateSelf();
  }
  
  public void stopAnimating()
  {
    this.a.removeMessages(0);
    this.a.YG(this.mProgress);
    invalidateSelf();
  }
  
  class a
    extends Handler
  {
    public int ehK;
    
    a() {}
    
    public void YG(int paramInt)
    {
      this.ehK = paramInt;
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (!arht.this.isVisible())
      {
        arht.this.mProgress = this.ehK;
        return;
      }
      if (arht.this.mProgress > this.ehK)
      {
        arht.this.setProgress(arht.this.mProgress - 1);
        sendEmptyMessageDelayed(0, arht.this.ehJ);
        return;
      }
      if (arht.this.mProgress < this.ehK)
      {
        int i = arht.this.mProgress + arht.this.mAnimationStep;
        if (i <= this.ehK) {
          arht.this.setProgress(i);
        }
        for (;;)
        {
          sendEmptyMessageDelayed(0, arht.this.ehJ);
          return;
          arht.this.setProgress(this.ehK);
        }
      }
      removeMessages(0);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(arht paramarht);
    
    public abstract void a(arht paramarht, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arht
 * JD-Core Version:    0.7.0.1
 */