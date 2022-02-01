package com.tencent.mobileqq.activity.contacts.alphabet;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import atau.a;
import com.tencent.qphone.base.util.QLog;

public class IndexBarTipView
  extends View
{
  private static String TAG = "IndexBarTipView";
  private Matrix D;
  private RectF ao = new RectF();
  private int cbP;
  private int cbQ;
  private BitmapShader d;
  private Drawable ed;
  private int mItemHeight;
  private String mText = "";
  private int mTextColor;
  private Paint mTextPaint;
  private float mTextSize;
  private int mWidth;
  private Paint y;
  
  public IndexBarTipView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IndexBarTipView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IndexBarTipView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private void cnc()
  {
    if (this.ed == null) {
      return;
    }
    this.d = new BitmapShader(drawableToBitmap(this.ed), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
  }
  
  private void cnd()
  {
    if (this.ed == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "updateImagePaint mWidth =  " + this.mWidth + ", getWidth = " + getWidth());
    }
    int i = this.ed.getIntrinsicWidth();
    int j = this.ed.getIntrinsicHeight();
    if (i * 1.0F / j > 1.0F) {}
    for (float f = this.mWidth * 1.0F / i;; f = this.mWidth * 1.0F / j)
    {
      this.D.setScale(f, f);
      this.d.setLocalMatrix(this.D);
      this.y.setShader(this.d);
      this.mItemHeight = ((int)(f * j));
      this.ao.set(0.0F, 0.0F, this.mWidth, this.mItemHeight);
      return;
    }
  }
  
  private Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      ((BitmapDrawable)paramDrawable).getBitmap();
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    Bitmap localBitmap = createBitmapSafely(i, j, Bitmap.Config.ARGB_8888, 1);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, i, j);
    paramDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.mTextColor = paramContext.getResources().getColor(17170444);
    this.mTextSize = paramContext.getResources().getDimension(2131297475);
    if (paramAttributeSet != null)
    {
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, atau.a.qS);
      this.mTextColor = paramContext.getColor(2, this.mTextColor);
      this.mTextSize = paramContext.getDimension(5, this.mTextSize);
      this.ed = paramContext.getDrawable(7);
      paramContext.recycle();
    }
    this.mTextPaint = new Paint(1);
    this.mTextPaint.setColor(this.mTextColor);
    this.mTextPaint.setTypeface(Typeface.DEFAULT);
    this.mTextPaint.setTextAlign(Paint.Align.CENTER);
    this.mTextPaint.setTextSize(this.mTextSize);
    this.D = new Matrix();
    this.y = new Paint();
    this.y.setAntiAlias(true);
    cnc();
  }
  
  public Bitmap createBitmapSafely(int paramInt1, int paramInt2, Bitmap.Config paramConfig, int paramInt3)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      if (paramInt3 > 0)
      {
        System.gc();
        return createBitmapSafely(paramInt1, paramInt2, paramConfig, paramInt3 - 1);
      }
    }
    return null;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (TextUtils.isEmpty(this.mText)) {
      return;
    }
    if (this.ed != null) {
      paramCanvas.drawRect(this.ao, this.y);
    }
    paramCanvas.drawText(this.mText, this.cbP, this.cbQ, this.mTextPaint);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mWidth != getWidth())
    {
      this.mWidth = getWidth();
      cnd();
    }
    if (!TextUtils.isEmpty(this.mText))
    {
      Rect localRect = new Rect();
      this.mTextPaint.getTextBounds(this.mText, 0, this.mText.length(), localRect);
      this.cbP = ((int)(this.mWidth * 0.5D - localRect.width() / 2.0D));
      double d1 = this.mItemHeight;
      this.cbQ = ((int)(localRect.height() / 2.0D + d1 * 0.5D));
    }
  }
  
  public void setText(String paramString)
  {
    this.mText = paramString;
    paramString = new Rect();
    this.mTextPaint.getTextBounds(this.mText, 0, this.mText.length(), paramString);
    this.cbP = ((int)(this.mWidth * 0.5D - paramString.width() / 2.0D));
    double d1 = this.mItemHeight;
    this.cbQ = ((int)(paramString.height() / 2.0D + d1 * 0.5D));
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.IndexBarTipView
 * JD-Core Version:    0.7.0.1
 */