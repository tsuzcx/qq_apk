package com.tencent.biz.pubaccount.readinjoy.ad.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import java.util.List;

public class ReadInjoyCutImageView
  extends NativeReadInjoyImageView
{
  private BitmapShader a;
  private Paint aA = new Paint(1);
  private boolean agR;
  private Paint az = new Paint(1);
  private BitmapShader b;
  private Bitmap bX;
  private Bitmap bY;
  private Bitmap bitmap;
  private List<a> go;
  private List<a> gp;
  private float height;
  private float ja;
  private float jb;
  private float jc;
  private float jd;
  Path q = new Path();
  Path r = new Path();
  private Matrix shaderMatrix = new Matrix();
  private Matrix u = new Matrix();
  private Matrix v = new Matrix();
  private float width;
  
  public ReadInjoyCutImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ReadInjoyCutImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(ImageView paramImageView, float paramFloat1, float paramFloat2)
  {
    float f1 = 1.0F;
    if ((this.bitmap == null) || (this.shaderMatrix == null)) {
      return;
    }
    this.shaderMatrix.set(null);
    float f2;
    if (paramImageView.getScaleType() == ImageView.ScaleType.CENTER_CROP)
    {
      if (paramFloat1 != this.bitmap.getWidth()) {
        f1 = paramFloat1 / this.bitmap.getWidth();
      }
      f2 = f1;
      if (this.bitmap.getHeight() * f1 < paramFloat2) {
        f2 = paramFloat2 / this.bitmap.getHeight();
      }
      f1 = this.bitmap.getHeight();
      float f3 = this.bitmap.getWidth();
      this.shaderMatrix.setScale(f2, f2);
      paramFloat1 = (paramFloat1 - f3 * f2) * 0.5F;
      paramFloat2 = (paramFloat2 - f1 * f2) * 0.5F;
    }
    for (;;)
    {
      this.shaderMatrix.postTranslate(paramFloat1 + 0.5F, paramFloat2 + 0.5F);
      return;
      f1 = paramFloat1 / this.bitmap.getWidth();
      f2 = paramFloat2 / this.bitmap.getHeight();
      paramFloat2 = (paramFloat2 - this.bitmap.getHeight() * f2) * 0.5F;
      paramFloat1 = (paramFloat1 - this.bitmap.getWidth() * f1) * 0.5F;
      this.shaderMatrix.setScale(f1, f2);
    }
  }
  
  private void aFv()
  {
    int j = 0;
    if (this.bitmap == null) {
      return;
    }
    Paint localPaint = new Paint(1);
    Object localObject = new BitmapShader(this.bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    localPaint.setShader((Shader)localObject);
    ((BitmapShader)localObject).setLocalMatrix(this.shaderMatrix);
    Canvas localCanvas;
    int i;
    label114:
    float f1;
    float f2;
    if (this.bX == null)
    {
      localObject = Bitmap.createBitmap(getWidth() + 2, getHeight() + 2, this.bitmap.getConfig());
      ((Bitmap)localObject).eraseColor(0);
      localCanvas = new Canvas((Bitmap)localObject);
      this.q.reset();
      i = 0;
      if (i >= this.go.size()) {
        break label240;
      }
      f1 = ((a)this.go.get(i)).x;
      f2 = ((a)this.go.get(i)).y;
      if (f1 != 0.0F) {
        break label206;
      }
      f1 = 1.0F;
      label169:
      if (f2 != 0.0F) {
        break label217;
      }
      f2 = 1.0F;
      label177:
      if (i != 0) {
        break label228;
      }
      this.q.moveTo(f1, f2);
    }
    for (;;)
    {
      i += 1;
      break label114;
      localObject = this.bX;
      break;
      label206:
      f1 = getWidth() * f1;
      break label169;
      label217:
      f2 = getHeight() * f2;
      break label177;
      label228:
      this.q.lineTo(f1, f2);
    }
    label240:
    localCanvas.drawPath(this.q, localPaint);
    this.a = new BitmapShader((Bitmap)localObject, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.az.setShader(this.a);
    if (this.bY == null)
    {
      localObject = Bitmap.createBitmap(getWidth() + 2, getHeight() + 2, this.bitmap.getConfig());
      ((Bitmap)localObject).eraseColor(0);
      localCanvas = new Canvas((Bitmap)localObject);
      this.r.reset();
      i = j;
      label340:
      if (i >= this.gp.size()) {
        break label466;
      }
      f1 = ((a)this.gp.get(i)).x;
      f2 = ((a)this.gp.get(i)).y;
      if (f1 != 0.0F) {
        break label432;
      }
      f1 = 1.0F;
      label395:
      if (f2 != 0.0F) {
        break label443;
      }
      f2 = 1.0F;
      label403:
      if (i != 0) {
        break label454;
      }
      this.r.moveTo(f1, f2);
    }
    for (;;)
    {
      i += 1;
      break label340;
      localObject = this.bY;
      break;
      label432:
      f1 = getWidth() * f1;
      break label395;
      label443:
      f2 = getHeight() * f2;
      break label403;
      label454:
      this.r.lineTo(f1, f2);
    }
    label466:
    localCanvas.drawPath(this.r, localPaint);
    this.b = new BitmapShader((Bitmap)localObject, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.aA.setShader(this.b);
  }
  
  private void releaseBitmap()
  {
    if (this.bY != null)
    {
      this.bY.recycle();
      this.bY = null;
      this.r.close();
    }
    if (this.bX != null)
    {
      this.bX.recycle();
      this.bX = null;
      this.q.close();
    }
  }
  
  public void aFw()
  {
    this.go = null;
    this.gp = null;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    releaseBitmap();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.agR) {
      super.onDraw(paramCanvas);
    }
    do
    {
      do
      {
        return;
        if ((this.go != null) && (this.a != null))
        {
          this.u.reset();
          this.u.postTranslate(this.ja, this.jb);
          this.a.setLocalMatrix(this.u);
          if (this.bitmap != null) {
            paramCanvas.drawPath(this.q, this.az);
          }
        }
      } while ((this.gp == null) || (this.b == null));
      this.v.reset();
      this.v.postTranslate(this.jc, this.jd);
      this.b.setLocalMatrix(this.v);
    } while (this.bitmap == null);
    paramCanvas.drawPath(this.r, this.aA);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.width = getMeasuredWidth();
    this.height = getMeasuredHeight();
    releaseBitmap();
    setupBitmap(this, this.width, this.height);
    invalidate();
  }
  
  public boolean performClick()
  {
    return super.performClick();
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    if (paramBoolean) {
      throw new IllegalArgumentException("adjustViewBounds not supported.");
    }
  }
  
  public void setClipArea(List<a> paramList1, List<a> paramList2)
  {
    this.go = paramList1;
    this.gp = paramList2;
    if (this.bitmap != null) {
      aFv();
    }
    postInvalidate();
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    setupBitmap(this, this.width, this.height);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    setupBitmap(this, this.width, this.height);
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    setupBitmap(this, this.width, this.height);
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    setupBitmap(this, this.width, this.height);
  }
  
  public void setIsShowSrc(boolean paramBoolean)
  {
    this.agR = paramBoolean;
    postInvalidate();
  }
  
  public void setLeftAreaTranslate(float paramFloat1, float paramFloat2)
  {
    this.ja = paramFloat1;
    this.jb = paramFloat2;
  }
  
  public void setRightAreaTranslate(float paramFloat1, float paramFloat2)
  {
    this.jc = paramFloat1;
    this.jd = paramFloat2;
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if ((paramScaleType == ImageView.ScaleType.CENTER_CROP) || (paramScaleType == ImageView.ScaleType.FIT_XY))
    {
      super.setScaleType(paramScaleType);
      return;
    }
    throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[] { paramScaleType }));
  }
  
  public void setupBitmap(ImageView paramImageView, float paramFloat1, float paramFloat2)
  {
    Object localObject = paramImageView.getDrawable();
    if (localObject == null) {}
    do
    {
      return;
      for (;;)
      {
        try
        {
          if (!(localObject instanceof BitmapDrawable)) {
            continue;
          }
          localObject = ((BitmapDrawable)localObject).getBitmap();
          this.bitmap = ((Bitmap)localObject);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          continue;
          if ((paramImageView.getScaleType() == ImageView.ScaleType.CENTER_CROP) || (paramImageView.getScaleType() == ImageView.ScaleType.FIT_XY)) {
            continue;
          }
          paramImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          a(paramImageView, paramFloat1, paramFloat2);
          paramImageView.invalidate();
        }
        if (this.bitmap != null) {
          continue;
        }
        paramImageView.invalidate();
        return;
        localObject = Bitmap.createBitmap(((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
      }
    } while ((this.go == null) || (this.gp == null));
    aFv();
  }
  
  public static class a
  {
    public float je;
    public float jf;
    public float x;
    public float y;
    
    public a(float paramFloat1, float paramFloat2)
    {
      this.x = paramFloat1;
      this.y = paramFloat2;
    }
    
    public a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.x = paramFloat1;
      this.y = paramFloat2;
      this.je = paramFloat3;
      this.jf = paramFloat4;
    }
    
    public a(a parama)
    {
      this.x = parama.x;
      this.y = parama.y;
    }
    
    public void a(a parama)
    {
      float f = this.x;
      this.x = parama.x;
      parama.x = f;
      f = this.y;
      this.y = parama.y;
      parama.y = f;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyCutImageView
 * JD-Core Version:    0.7.0.1
 */