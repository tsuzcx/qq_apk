package com.tencent.qqmail.utilities.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
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
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import com.tencent.androidqqmail.R.styleable;

public class MaskableImageView
  extends ImageView
{
  private static final int DEFAULT_BORDER_COLOR = 0;
  private static final int DEFAULT_Selector_STROKE_COLOR = 0;
  private static final String TAG = MaskableImageView.class.getSimpleName();
  private int borderColor;
  private Paint borderPaint;
  private int borderWidth;
  private int cornerRadius;
  private int height;
  private Bitmap image;
  private boolean isCircle = false;
  private boolean isOval = false;
  private boolean isSelected = false;
  private Paint paint;
  private float scale;
  private int selectorMaskColor;
  private ColorFilter selectorMaskFilter;
  private int selectorStrokeColor;
  private Paint selectorStrokePaint;
  private int selectorStrokeWidth;
  private BitmapShader shader;
  private int width;
  
  public MaskableImageView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public MaskableImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MaskableImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private void draw(Canvas paramCanvas, Paint paramPaint, float paramFloat)
  {
    int i = this.width / 2;
    int j = this.height / 2;
    RectF localRectF = new RectF(paramFloat, paramFloat, this.width - paramFloat, this.height - paramFloat);
    if (this.isCircle)
    {
      int k = this.width / 2;
      paramCanvas.drawCircle(i, j, k - paramFloat, paramPaint);
      return;
    }
    if (this.isOval)
    {
      paramCanvas.drawOval(localRectF, paramPaint);
      return;
    }
    paramCanvas.drawRoundRect(localRectF, this.cornerRadius, this.cornerRadius, paramPaint);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    this.borderPaint = new Paint();
    this.borderPaint.setAntiAlias(true);
    this.borderPaint.setStyle(Paint.Style.STROKE);
    this.selectorStrokePaint = new Paint();
    this.selectorStrokePaint.setAntiAlias(true);
    this.selectorStrokePaint.setStyle(Paint.Style.STROKE);
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CircularImageView);
    this.borderWidth = paramContext.getDimensionPixelSize(R.styleable.MaskableImageView_normal_border_width, 0);
    this.borderColor = paramContext.getColor(R.styleable.MaskableImageView_normal_border_color, 0);
    this.borderPaint.setStrokeWidth(this.borderWidth);
    this.borderPaint.setColor(this.borderColor);
    this.selectorMaskColor = paramContext.getColor(R.styleable.MaskableImageView_selector_mask_color, 0);
    this.selectorMaskFilter = new PorterDuffColorFilter(this.selectorMaskColor, PorterDuff.Mode.SRC_ATOP);
    this.selectorStrokeWidth = paramContext.getDimensionPixelSize(R.styleable.MaskableImageView_selector_stroke_width, 0);
    this.selectorStrokeColor = paramContext.getColor(R.styleable.MaskableImageView_selector_stroke_color, 0);
    this.selectorStrokePaint.setStrokeWidth(this.selectorStrokeWidth);
    this.selectorStrokePaint.setColor(this.selectorStrokeColor);
    this.isCircle = paramContext.getBoolean(R.styleable.MaskableImageView_is_circle, false);
    if (!this.isCircle) {
      this.isOval = paramContext.getBoolean(R.styleable.MaskableImageView_is_oval, false);
    }
    if (!this.isOval) {
      this.cornerRadius = paramContext.getDimensionPixelSize(R.styleable.MaskableImageView_corner_radius, 0);
    }
    paramContext.recycle();
    setClickable(true);
  }
  
  private int measureHeight(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i == 1073741824) {}
    while (i == -2147483648) {
      return paramInt;
    }
    return this.height;
  }
  
  private int measureWidth(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i == 1073741824) {}
    while (i == -2147483648) {
      return paramInt;
    }
    return this.width;
  }
  
  private void updateBitmapShader()
  {
    if ((this.width <= 0) || (this.height <= 0)) {}
    while (this.image == null) {
      return;
    }
    this.shader = new BitmapShader(this.image, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.scale = Math.max(this.width / this.image.getWidth(), this.height / this.image.getHeight());
    float f1 = this.image.getWidth();
    float f2 = this.scale;
    float f3 = this.image.getHeight();
    float f4 = this.scale;
    Matrix localMatrix = new Matrix();
    localMatrix.setScale(this.scale, this.scale);
    localMatrix.postTranslate((this.width - f1 * f2) / 2.0F, (this.height - f3 * f4) / 2.0F);
    this.shader.setLocalMatrix(localMatrix);
  }
  
  public int getBorderColor()
  {
    return this.borderColor;
  }
  
  public int getBorderWidth()
  {
    return this.borderWidth;
  }
  
  public int getCornerRadius()
  {
    return this.cornerRadius;
  }
  
  public int getSelectorMaskColor()
  {
    return this.selectorMaskColor;
  }
  
  public int getSelectorStrokeColor()
  {
    return this.selectorStrokeColor;
  }
  
  public int getSelectorStrokeWidth()
  {
    return this.selectorStrokeWidth;
  }
  
  public boolean isCircle()
  {
    return this.isCircle;
  }
  
  public boolean isOval()
  {
    if (this.isCircle) {
      return false;
    }
    return this.isOval;
  }
  
  public boolean isSelected()
  {
    return this.isSelected;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f = 0.0F;
    if (this.image == null) {}
    while ((this.image.getWidth() <= 0) || (this.image.getHeight() <= 0)) {
      return;
    }
    int i = this.height;
    int j = this.width;
    this.width = getWidth();
    this.height = getHeight();
    if ((this.width != j) || (this.height != i)) {
      updateBitmapShader();
    }
    this.paint.setShader(this.shader);
    if (this.isSelected)
    {
      this.paint.setColorFilter(this.selectorMaskFilter);
      if (this.selectorStrokeWidth == 0) {
        if (this.borderWidth != 0)
        {
          f = this.borderWidth / 2;
          draw(paramCanvas, this.borderPaint, f);
        }
      }
    }
    for (;;)
    {
      draw(paramCanvas, this.paint, f);
      return;
      f = this.selectorStrokeWidth / 2;
      draw(paramCanvas, this.selectorStrokePaint, f);
      continue;
      if (this.borderWidth != 0)
      {
        f = this.borderWidth / 2;
        this.paint.setColorFilter(null);
        draw(paramCanvas, this.borderPaint, f);
      }
      else
      {
        this.paint.setColorFilter(null);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = measureWidth(paramInt1);
    int j = measureHeight(paramInt2);
    if (this.image == null) {
      return;
    }
    int k = this.image.getWidth();
    int m = this.image.getHeight();
    if (i == 0)
    {
      paramInt2 = j * k / m;
      paramInt1 = j;
    }
    for (;;)
    {
      j = paramInt1;
      i = paramInt2;
      if (this.isCircle)
      {
        j = Math.min(paramInt2, paramInt1);
        i = j;
      }
      setMeasuredDimension(i, j);
      return;
      paramInt1 = j;
      paramInt2 = i;
      if (j == 0)
      {
        paramInt1 = i * m / k;
        paramInt2 = i;
      }
    }
  }
  
  public void setBorderColor(int paramInt)
  {
    this.borderColor = paramInt;
    if (this.borderPaint != null) {
      this.borderPaint.setColor(this.borderColor);
    }
    invalidate();
  }
  
  public void setBorderWidth(int paramInt)
  {
    this.borderWidth = paramInt;
    if (this.borderPaint != null) {
      this.borderPaint.setStrokeWidth(this.borderWidth);
    }
    requestLayout();
    invalidate();
  }
  
  public void setCircle(boolean paramBoolean)
  {
    this.isCircle = paramBoolean;
    requestLayout();
    invalidate();
  }
  
  public void setCornerRadius(int paramInt)
  {
    this.cornerRadius = paramInt;
    invalidate();
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    this.image = paramBitmap;
    updateBitmapShader();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    this.image = QMUIKit.drawableToBitmap(getDrawable());
    updateBitmapShader();
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    this.image = QMUIKit.drawableToBitmap(getDrawable());
    updateBitmapShader();
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    this.image = QMUIKit.drawableToBitmap(getDrawable());
    updateBitmapShader();
  }
  
  public void setOval(boolean paramBoolean)
  {
    this.isOval = paramBoolean;
    if (this.isOval) {
      this.isCircle = false;
    }
    requestLayout();
    invalidate();
  }
  
  public void setSelected(boolean paramBoolean)
  {
    if (this.isSelected == paramBoolean) {
      return;
    }
    this.isSelected = paramBoolean;
    invalidate();
  }
  
  public void setSelectorMaskColor(int paramInt)
  {
    this.selectorMaskFilter = new PorterDuffColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    invalidate();
  }
  
  public void setSelectorStrokeColor(int paramInt)
  {
    this.selectorStrokeColor = paramInt;
    if (this.selectorStrokePaint != null) {
      this.selectorStrokePaint.setColor(paramInt);
    }
    invalidate();
  }
  
  public void setSelectorStrokeWidth(int paramInt)
  {
    this.selectorStrokeWidth = paramInt;
    if (this.selectorStrokePaint != null) {
      this.selectorStrokePaint.setStrokeWidth(this.selectorStrokeWidth);
    }
    requestLayout();
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.MaskableImageView
 * JD-Core Version:    0.7.0.1
 */