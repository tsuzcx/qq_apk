package com.tencent.moai.nativepages.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

public class CircularImageView
  extends ImageView
{
  private static final int SHADOW_COLOR = -16777216;
  private static final float SHADOW_DX = 0.0F;
  private static final float SHADOW_DY = 2.0F;
  private static final boolean SHADOW_ENABLED = false;
  private static final float SHADOW_RADIUS = 4.0F;
  private static final String TAG = CircularImageView.class.getSimpleName();
  private int borderWidth;
  private int canvasSize;
  private boolean hasBorder;
  private boolean hasSelector;
  private Bitmap image;
  private boolean isSelected;
  private Paint paint;
  private Paint paintBorder;
  private Paint paintSelectorBorder;
  private ColorFilter selectorFilter;
  private int selectorStrokeWidth;
  private BitmapShader shader;
  private int shadowColor;
  private float shadowDx;
  private float shadowDy;
  private boolean shadowEnabled;
  private float shadowRadius;
  
  public CircularImageView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public CircularImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, null, 0);
  }
  
  public CircularImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet, paramInt);
  }
  
  @TargetApi(21)
  public CircularImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    init(paramContext, paramAttributeSet, paramInt1);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    this.paintBorder = new Paint();
    this.paintBorder.setAntiAlias(true);
    this.paintBorder.setStyle(Paint.Style.STROKE);
    this.paintSelectorBorder = new Paint();
    this.paintSelectorBorder.setAntiAlias(true);
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
  }
  
  private int measureHeight(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i == 1073741824) {}
    for (;;)
    {
      return paramInt + 2;
      if (i != -2147483648) {
        paramInt = this.canvasSize;
      }
    }
  }
  
  private int measureWidth(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i == 1073741824) {}
    while (i == -2147483648) {
      return paramInt;
    }
    return this.canvasSize;
  }
  
  private void updateShadow()
  {
    if (this.shadowEnabled) {}
    for (float f = this.shadowRadius;; f = 0.0F)
    {
      this.paintBorder.setShadowLayer(f, this.shadowDx, this.shadowDy, this.shadowColor);
      this.paintSelectorBorder.setShadowLayer(f, this.shadowDx, this.shadowDy, this.shadowColor);
      return;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isClickable())
    {
      this.isSelected = false;
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      invalidate();
      return super.dispatchTouchEvent(paramMotionEvent);
      this.isSelected = true;
      continue;
      this.isSelected = false;
    }
  }
  
  public Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    int i;
    int j;
    do
    {
      return null;
      if ((paramDrawable instanceof BitmapDrawable)) {
        return ((BitmapDrawable)paramDrawable).getBitmap();
      }
      i = paramDrawable.getIntrinsicWidth();
      j = paramDrawable.getIntrinsicHeight();
    } while ((i <= 0) || (j <= 0));
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localBitmap;
    }
    catch (OutOfMemoryError paramDrawable) {}
    return null;
  }
  
  public boolean isSelected()
  {
    return this.isSelected;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int j = 0;
    if (this.image == null) {}
    while ((this.image.getHeight() == 0) || (this.image.getWidth() == 0)) {
      return;
    }
    int k = this.canvasSize;
    int i;
    if (getWidth() < getHeight())
    {
      i = getWidth();
      this.canvasSize = i;
      if (k != this.canvasSize) {
        updateBitmapShader();
      }
      this.paint.setShader(this.shader);
      i = this.canvasSize / 2;
      if ((!this.hasSelector) || (!this.isSelected)) {
        break label199;
      }
      j = this.selectorStrokeWidth;
      i = (this.canvasSize - j * 2) / 2;
      this.paint.setColorFilter(this.selectorFilter);
      paramCanvas.drawCircle(i + j, i + j, (this.canvasSize - j * 2) / 2 + j - 4.0F, this.paintSelectorBorder);
    }
    for (;;)
    {
      paramCanvas.drawCircle(i + j, i + j, (this.canvasSize - j * 2) / 2, this.paint);
      return;
      i = getHeight();
      break;
      label199:
      if (this.hasBorder)
      {
        j = this.borderWidth;
        i = (this.canvasSize - j * 2) / 2;
        this.paint.setColorFilter(null);
        paramCanvas.drawArc(new RectF(j / 2 + 0, j / 2 + 0, this.canvasSize - j / 2, this.canvasSize - j / 2), 360.0F, 360.0F, false, this.paintBorder);
      }
      else
      {
        this.paint.setColorFilter(null);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(measureWidth(paramInt1), measureHeight(paramInt2));
  }
  
  public void setBorderColor(int paramInt)
  {
    if (this.paintBorder != null) {
      this.paintBorder.setColor(paramInt);
    }
    invalidate();
  }
  
  public void setBorderWidth(int paramInt)
  {
    this.borderWidth = paramInt;
    if (this.paintBorder != null) {
      this.paintBorder.setStrokeWidth(paramInt);
    }
    requestLayout();
    invalidate();
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    this.image = paramBitmap;
    if (this.canvasSize > 0) {
      updateBitmapShader();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    this.image = drawableToBitmap(getDrawable());
    if (this.canvasSize > 0) {
      updateBitmapShader();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    this.image = drawableToBitmap(getDrawable());
    if (this.canvasSize > 0) {
      updateBitmapShader();
    }
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    this.image = drawableToBitmap(getDrawable());
    if (this.canvasSize > 0) {
      updateBitmapShader();
    }
  }
  
  public void setSelectorColor(int paramInt)
  {
    this.selectorFilter = new PorterDuffColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    invalidate();
  }
  
  public void setSelectorStrokeColor(int paramInt)
  {
    if (this.paintSelectorBorder != null) {
      this.paintSelectorBorder.setColor(paramInt);
    }
    invalidate();
  }
  
  public void setSelectorStrokeWidth(int paramInt)
  {
    this.selectorStrokeWidth = paramInt;
    requestLayout();
    invalidate();
  }
  
  public void setShadow(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    this.shadowRadius = paramFloat1;
    this.shadowDx = paramFloat2;
    this.shadowDy = paramFloat3;
    this.shadowColor = paramInt;
    updateShadow();
  }
  
  public void setShadowEnabled(boolean paramBoolean)
  {
    this.shadowEnabled = paramBoolean;
    updateShadow();
  }
  
  public void updateBitmapShader()
  {
    if (this.image == null) {}
    do
    {
      return;
      this.shader = new BitmapShader(this.image, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    } while ((this.canvasSize == this.image.getWidth()) && (this.canvasSize == this.image.getHeight()));
    Matrix localMatrix = new Matrix();
    float f = this.canvasSize / this.image.getWidth();
    localMatrix.setScale(f, f);
    this.shader.setLocalMatrix(localMatrix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.view.CircularImageView
 * JD-Core Version:    0.7.0.1
 */