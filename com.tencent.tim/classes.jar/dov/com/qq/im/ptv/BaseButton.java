package dov.com.qq.im.ptv;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.View;
import azbx;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class BaseButton
  extends View
{
  protected Paint Q;
  protected int backgroundColor;
  private boolean dxx;
  private boolean dxy;
  protected int eIX;
  protected int eIY = azbx.dip2px(10.0F);
  private int imageHeight;
  private int imageWidth;
  private Paint mBitmapPaint;
  private HashMap<Integer, Bitmap> mCache = new HashMap();
  private Drawable mDrawable;
  private int mHeight;
  private Bitmap mImage;
  private int mResourceId;
  protected Paint mShadowPaint;
  private int mWidth;
  private Rect rect = new Rect();
  protected int shadowColor;
  
  public BaseButton(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public BaseButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void N(Canvas paramCanvas)
  {
    this.mShadowPaint.setColor(this.shadowColor);
    this.mShadowPaint.setStrokeWidth(this.eIX);
    int i = this.mWidth / 2;
    int j = this.eIY;
    int k = this.eIX / 2;
    paramCanvas.drawCircle(this.mWidth / 2, this.mHeight / 2, i - j + k, this.mShadowPaint);
  }
  
  @TargetApi(21)
  private Drawable bj()
  {
    return getContext().getDrawable(this.mResourceId);
  }
  
  private void ca(Canvas paramCanvas)
  {
    this.rect.top = ((this.mHeight - this.imageHeight) / 2);
    this.rect.left = ((this.mWidth - this.imageWidth) / 2);
    this.rect.bottom = (this.rect.top + this.imageHeight);
    this.rect.right = (this.rect.left + this.imageWidth);
    if (this.mDrawable != null)
    {
      this.mDrawable.setBounds(this.rect);
      this.mDrawable.draw(paramCanvas);
    }
    while (this.mImage == null) {
      return;
    }
    this.mBitmapPaint.setFilterBitmap(true);
    paramCanvas.drawBitmap(this.mImage, null, this.rect, this.mBitmapPaint);
    this.mBitmapPaint.setFilterBitmap(true);
  }
  
  private void drawBackground(Canvas paramCanvas)
  {
    this.Q.setColor(this.backgroundColor);
    if (!this.dxx) {
      this.Q.setShadowLayer(this.eIX, 0.0F, 0.0F, this.shadowColor);
    }
    int i = this.mWidth / 2;
    int j = this.eIY;
    paramCanvas.drawCircle(this.mWidth / 2, this.mHeight / 2, i - j, this.Q);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (isStateful())
    {
      int[] arrayOfInt = getDrawableState();
      if (StateSet.stateSetMatches(PRESSED_WINDOW_FOCUSED_STATE_SET, arrayOfInt)) {
        setAlpha(0.4901961F);
      }
    }
    else
    {
      return;
    }
    setAlpha(1.0F);
  }
  
  protected void init()
  {
    setLayerType(1, null);
    this.mShadowPaint = new Paint();
    this.mShadowPaint.setAntiAlias(true);
    this.mShadowPaint.setStyle(Paint.Style.STROKE);
    this.mShadowPaint.setDither(true);
    this.Q = new Paint();
    this.Q.setAntiAlias(true);
    this.Q.setStyle(Paint.Style.FILL_AND_STROKE);
    this.mBitmapPaint = new Paint();
    this.mBitmapPaint.setAntiAlias(true);
  }
  
  public boolean isStateful()
  {
    return this.dxy;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.mWidth = getWidth();
    this.mHeight = getHeight();
    if (this.mWidth <= 0) {
      return;
    }
    if (this.dxx) {
      N(paramCanvas);
    }
    drawBackground(paramCanvas);
    ca(paramCanvas);
  }
  
  public boolean performClick()
  {
    return super.performClick();
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.backgroundColor = paramInt;
    invalidate();
  }
  
  public void setImageHeight(int paramInt)
  {
    this.imageHeight = paramInt;
  }
  
  public void setImageResource(int paramInt)
  {
    if (this.mResourceId == paramInt) {
      return;
    }
    this.mResourceId = paramInt;
    if (Build.VERSION.SDK_INT >= 21) {
      this.mDrawable = bj();
    }
    Bitmap localBitmap;
    if (this.mDrawable == null)
    {
      localBitmap = (Bitmap)this.mCache.get(Integer.valueOf(this.mResourceId));
      if (localBitmap == null) {
        break label69;
      }
      this.mImage = localBitmap;
    }
    for (;;)
    {
      invalidate();
      return;
      try
      {
        label69:
        localBitmap = BitmapFactory.decodeResource(getResources(), this.mResourceId);
        if (localBitmap != null)
        {
          this.mCache.put(Integer.valueOf(this.mResourceId), localBitmap);
          this.mImage = localBitmap;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          Object localObject = null;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("BaseButton", 2, "setImageResource error Id=" + this.mResourceId);
      }
    }
  }
  
  public void setImageWidth(int paramInt)
  {
    this.imageWidth = paramInt;
  }
  
  public void setShadowColor(int paramInt)
  {
    this.shadowColor = paramInt;
    invalidate();
  }
  
  public void setShadowDraw(boolean paramBoolean)
  {
    this.dxx = paramBoolean;
  }
  
  public void setShadowStrokeMaxWidth(int paramInt)
  {
    this.eIY = paramInt;
    invalidate();
  }
  
  public void setShadowStrokeWidth(int paramInt)
  {
    this.eIX = paramInt;
    invalidate();
  }
  
  public void setStateful(boolean paramBoolean)
  {
    this.dxy = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ptv.BaseButton
 * JD-Core Version:    0.7.0.1
 */