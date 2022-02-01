package com.tencent.biz.videostory.capture.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import ankt;
import atau.a;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class SquareRoundImageView
  extends ImageView
{
  private static int byB = ankt.dip2px(2.0F);
  private int JO;
  private PaintFlagsDrawFilter jdField_a_of_type_AndroidGraphicsPaintFlagsDrawFilter;
  private a jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView$a;
  private boolean aMw;
  private boolean aMx;
  private Paint bk;
  private Paint bl;
  private int byC = byB;
  private int mBitmapHeight;
  private BitmapShader mBitmapShader;
  private int mBitmapWidth;
  private Matrix mMatrix;
  private Paint mPaint;
  protected Path mPath;
  private int mViewHeight;
  
  public SquareRoundImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SquareRoundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.sl);
    int i = paramContext.getColor(0, Color.parseColor("#74000000"));
    this.byC = paramContext.getDimensionPixelSize(1, 2);
    this.mPath = new Path();
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.bl = new Paint();
    this.bl.setAntiAlias(true);
    this.bl.setColor(i);
    this.bl.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaintFlagsDrawFilter = new PaintFlagsDrawFilter(0, 3);
    paramContext.recycle();
    if (Build.VERSION.SDK_INT <= 19) {
      setLayerType(1, null);
    }
  }
  
  private void bzM()
  {
    if (this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView$a == null) {
      try
      {
        if (this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView$a == null) {
          this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView$a = new a(Looper.getMainLooper(), this, null);
        }
        return;
      }
      finally {}
    }
  }
  
  private void bzN()
  {
    int i = getWidth() - getPaddingLeft() - getPaddingRight();
    int j = getHeight() - getPaddingTop() - getPaddingBottom();
    if ((i != this.JO) || (j != this.mViewHeight))
    {
      this.JO = i;
      this.mViewHeight = j;
      eJ(this.JO, this.mViewHeight);
      if (this.mBitmapShader != null) {
        bzO();
      }
    }
  }
  
  private void bzO()
  {
    float f2 = 0.0F;
    if (this.mMatrix == null) {
      this.mMatrix = new Matrix();
    }
    for (;;)
    {
      if ((this.mBitmapWidth > 0) && (this.mBitmapHeight > 0) && (this.JO > 0) && (this.mViewHeight > 0))
      {
        ImageView.ScaleType localScaleType = getScaleType();
        if (ImageView.ScaleType.FIT_XY != localScaleType) {
          break;
        }
        this.mMatrix.setScale(this.JO / this.mBitmapWidth, this.mViewHeight / this.mBitmapHeight);
      }
      return;
      this.mMatrix.reset();
    }
    float f1;
    float f3;
    if (this.mBitmapWidth * this.mViewHeight > this.JO * this.mBitmapHeight)
    {
      f1 = this.mViewHeight / this.mBitmapHeight;
      f3 = (this.JO - this.mBitmapWidth * f1) * 0.5F;
    }
    for (;;)
    {
      this.mMatrix.setScale(f1, f1);
      this.mMatrix.postTranslate(Math.round(f3), Math.round(f2));
      return;
      f1 = this.JO / this.mBitmapWidth;
      f2 = this.mViewHeight;
      float f4 = this.mBitmapHeight;
      f3 = 0.0F;
      f2 = (f2 - f4 * f1) * 0.5F;
    }
  }
  
  private Bitmap d(Drawable paramDrawable)
  {
    if ((paramDrawable == null) || (Build.BRAND.contains("Meitu"))) {
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if ((i <= 0) || (j <= 0)) {
      return null;
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, i, j);
      paramDrawable.draw(localCanvas);
      return localBitmap;
    }
    catch (OutOfMemoryError paramDrawable)
    {
      return null;
    }
    catch (Exception paramDrawable) {}
    return null;
  }
  
  private void eJ(int paramInt1, int paramInt2)
  {
    this.mPath.reset();
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return;
    }
    float f1 = Math.min(paramInt1 * 0.0618F, paramInt2 * 0.0618F);
    float f2 = paramInt1 / 2.0F;
    float f3 = paramInt2 / 2.0F;
    this.mPath.moveTo(byB, f3);
    this.mPath.cubicTo(byB, f1, f1, byB, f2, byB);
    this.mPath.cubicTo(paramInt1 - f1, byB, paramInt1 - byB, f1, paramInt1 - byB, f3);
    this.mPath.cubicTo(paramInt1 - byB, paramInt2 - f1, paramInt1 - f1, paramInt2 - byB, f2, paramInt2 - byB);
    this.mPath.cubicTo(f1, paramInt2 - byB, byB, paramInt2 - f1, byB, f3);
  }
  
  private void updateBitmapShader()
  {
    Bitmap localBitmap = d(getDrawable());
    if (localBitmap != null)
    {
      this.mBitmapShader = new BitmapShader(localBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      this.mBitmapWidth = localBitmap.getWidth();
      this.mBitmapHeight = localBitmap.getHeight();
      bzO();
    }
    for (;;)
    {
      invalidate();
      return;
      this.mBitmapShader = null;
      this.mBitmapWidth = 0;
      this.mBitmapHeight = 0;
    }
  }
  
  public void bzL()
  {
    bzM();
    if (!this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView$a.hasMessages(1)) {
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView$a.sendEmptyMessage(1);
    }
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
    bzL();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mPath != null)
    {
      if (this.aMx) {
        paramCanvas.drawPath(this.mPath, this.bl);
      }
      if (this.mBitmapShader == null) {
        break label109;
      }
      this.mBitmapShader.setLocalMatrix(this.mMatrix);
      this.mPaint.setShader(this.mBitmapShader);
      paramCanvas.translate(getPaddingLeft(), getPaddingTop());
      paramCanvas.drawPath(this.mPath, this.mPaint);
    }
    for (;;)
    {
      if ((this.aMw) && (this.bk != null)) {
        paramCanvas.drawPath(this.mPath, this.bk);
      }
      return;
      try
      {
        label109:
        paramCanvas.setDrawFilter(this.jdField_a_of_type_AndroidGraphicsPaintFlagsDrawFilter);
        paramCanvas.save();
        this.mPath.offset(getPaddingLeft(), getPaddingRight());
        paramCanvas.clipPath(this.mPath);
        super.onDraw(paramCanvas);
        this.mPath.offset(0 - getPaddingLeft(), 0 - getPaddingRight());
        paramCanvas.restore();
      }
      catch (Exception localException)
      {
        super.onDraw(paramCanvas);
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != 0) && (paramInt2 != 0) && ((paramInt1 != paramInt3) || (paramInt2 != paramInt4))) {
      bzN();
    }
  }
  
  public void setDrawBack(boolean paramBoolean)
  {
    this.aMx = paramBoolean;
    invalidate();
  }
  
  public void setDrawChecked(boolean paramBoolean)
  {
    this.aMw = paramBoolean;
    if ((this.aMw) && (this.bk == null))
    {
      this.bk = new Paint();
      this.bk.setAntiAlias(true);
      this.bk.setColor(Color.parseColor("#FFFFFF"));
      this.bk.setStrokeWidth(this.byC);
      this.bk.setStyle(Paint.Style.STROKE);
    }
    invalidate();
  }
  
  public void setDrawShadowLayer()
  {
    this.mPaint.setShadowLayer(10.0F, 15.0F, 15.0F, -7829368);
  }
  
  public void setImageDrawable(@Nullable Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (paramDrawable == null)
    {
      bzM();
      if (this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView$a.hasMessages(1)) {
        this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView$a.removeMessages(1);
      }
      this.mBitmapShader = null;
      this.mBitmapHeight = 0;
      this.mBitmapWidth = 0;
      return;
    }
    bzL();
  }
  
  public void setImageResource(int paramInt)
  {
    if (getResources() == null) {
      return;
    }
    try
    {
      setImageDrawable(getResources().getDrawable(paramInt));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("SquareRoundImageView", 4, localException, new Object[0]);
    }
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    bzN();
  }
  
  static class a
    extends Handler
  {
    private WeakReference<SquareRoundImageView> mViewRef;
    
    private a(Looper paramLooper, SquareRoundImageView paramSquareRoundImageView)
    {
      super();
      this.mViewRef = new WeakReference(paramSquareRoundImageView);
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 1)
      {
        paramMessage = (SquareRoundImageView)this.mViewRef.get();
        if (paramMessage != null) {
          SquareRoundImageView.a(paramMessage);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.widgets.SquareRoundImageView
 * JD-Core Version:    0.7.0.1
 */