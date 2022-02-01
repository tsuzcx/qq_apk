package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.tencent.mobileqq.activity.PortraitImageview;
import com.tencent.qphone.base.util.QLog;

public class RegionView
  extends View
{
  Rect ay;
  private PortraitImageview b;
  boolean bsU;
  int ceO;
  int clipHeight;
  int clipWidth;
  Rect[] d;
  final Paint paint = new Paint();
  final Rect rect = new Rect();
  int targetHeight;
  int targetWidth;
  
  public RegionView(Context paramContext, PortraitImageview paramPortraitImageview, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    super(paramContext);
    paramPortraitImageview.setRegionView(this);
    this.b = paramPortraitImageview;
    this.targetWidth = paramInt1;
    this.targetHeight = paramInt2;
    this.ceO = paramInt3;
    this.bsU = paramBoolean;
  }
  
  public Bitmap ao()
  {
    return this.b.ac();
  }
  
  public Bitmap getBitmap()
  {
    Matrix localMatrix = this.b.getImageViewMatrix();
    Object localObject = this.b.f();
    localMatrix.postTranslate(-((RectF)localObject).left, -((RectF)localObject).top);
    localMatrix.postScale(this.targetWidth / ((RectF)localObject).width(), this.targetHeight / ((RectF)localObject).height(), 0.0F, 0.0F);
    int i = this.targetWidth;
    int j = this.targetHeight;
    if (this.bsU) {}
    for (localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
      Bitmap localBitmap = this.b.ac();
      if ((localObject != null) && (localBitmap != null)) {
        new Canvas((Bitmap)localObject).drawBitmap(localBitmap, localMatrix, new Paint(6));
      }
      return localObject;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.b != null)
    {
      this.clipWidth = this.b.getClipWidth();
      this.clipHeight = this.b.getClipHeight();
    }
    this.rect.left = ((getWidth() - this.clipWidth) / 2);
    this.rect.right = ((getWidth() + this.clipWidth) / 2);
    this.rect.top = ((getHeight() - this.clipHeight) / 2);
    this.rect.bottom = ((getHeight() + this.clipHeight) / 2);
    if (this.ceO == 0)
    {
      this.paint.setColor(1711276032);
      this.paint.setStyle(Paint.Style.FILL);
      localObject = new Path();
      float f = this.rect.top + this.rect.height() * 0.5F;
      ((Path)localObject).moveTo(getWidth(), f);
      ((Path)localObject).addArc(new RectF(this.rect.left, this.rect.top, this.rect.right, this.rect.bottom), 0.0F, -360.0F);
      ((Path)localObject).moveTo(getWidth(), f);
      ((Path)localObject).lineTo(getWidth(), getHeight());
      ((Path)localObject).lineTo(0.0F, getHeight());
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(getWidth(), 0.0F);
      ((Path)localObject).moveTo(getWidth(), f);
      ((Path)localObject).close();
      paramCanvas.drawPath((Path)localObject, this.paint);
      this.paint.setAntiAlias(true);
      this.paint.setStyle(Paint.Style.STROKE);
      this.paint.setColor(1291845632);
      this.paint.setStrokeWidth(5.0F);
      paramCanvas.drawCircle(this.rect.left + this.rect.width() * 0.5F, f, this.rect.width() * 0.5F, this.paint);
      this.paint.setColor(-1);
      this.paint.setStrokeWidth(3.0F);
      paramCanvas.drawCircle(this.rect.left + this.rect.width() * 0.5F, f, this.rect.width() * 0.5F, this.paint);
      return;
    }
    this.d = new Rect[] { new Rect(0, 0, this.rect.left, this.rect.top), new Rect(this.rect.left, 0, this.rect.right, this.rect.top), new Rect(this.rect.right, 0, getWidth(), this.rect.top), new Rect(0, this.rect.top, this.rect.left, this.rect.bottom), new Rect(this.rect.right, this.rect.top, getWidth(), this.rect.bottom), new Rect(0, this.rect.bottom, this.rect.left, getHeight()), new Rect(this.rect.left, this.rect.bottom, this.rect.right, getHeight()), new Rect(this.rect.right, this.rect.bottom, getWidth(), getHeight()) };
    this.ay = new Rect();
    this.ay.set(this.rect);
    Object localObject = this.ay;
    ((Rect)localObject).left -= 2;
    localObject = this.ay;
    ((Rect)localObject).right += 2;
    localObject = this.ay;
    ((Rect)localObject).top -= 2;
    localObject = this.ay;
    ((Rect)localObject).bottom += 2;
    this.paint.setColor(1711276032);
    this.paint.setStyle(Paint.Style.FILL);
    int i = 0;
    while (i < this.d.length)
    {
      paramCanvas.drawRect(this.d[i], this.paint);
      i += 1;
    }
    this.paint.setColor(0);
    paramCanvas.drawRect(this.ay, this.paint);
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setStrokeWidth(5.0F);
    this.paint.setColor(1291845632);
    paramCanvas.drawRect(this.ay, this.paint);
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setStrokeWidth(3.0F);
    this.paint.setColor(-1);
    paramCanvas.drawRect(this.ay, this.paint);
  }
  
  public Rect s()
  {
    int j = 0;
    Object localObject2 = this.b.getImageViewMatrix();
    Object localObject1 = this.b.f();
    Bitmap localBitmap = this.b.ac();
    Matrix localMatrix = new Matrix();
    ((Matrix)localObject2).invert(localMatrix);
    localObject2 = new RectF();
    localMatrix.mapRect((RectF)localObject2, (RectF)localObject1);
    if (QLog.isColorLevel()) {
      QLog.i("RegionView", 2, String.format("getClipInfo src=[%.0f,%.0f,%.0f,%.0f],dst=[%.0f,%.0f,%.0f,%.0f],[tW,tH]=[%d,%d]", new Object[] { Float.valueOf(((RectF)localObject1).left), Float.valueOf(((RectF)localObject1).top), Float.valueOf(((RectF)localObject1).right), Float.valueOf(((RectF)localObject1).bottom), Float.valueOf(((RectF)localObject2).left), Float.valueOf(((RectF)localObject2).top), Float.valueOf(((RectF)localObject2).right), Float.valueOf(((RectF)localObject2).bottom), Integer.valueOf(localBitmap.getWidth()), Integer.valueOf(localBitmap.getHeight()) }));
    }
    localObject1 = new Rect();
    ((RectF)localObject2).round((Rect)localObject1);
    if (((Rect)localObject1).left < 0)
    {
      i = 0;
      ((Rect)localObject1).left = i;
      if (((Rect)localObject1).top >= 0) {
        break label304;
      }
      i = j;
      label240:
      ((Rect)localObject1).top = i;
      if (((Rect)localObject1).right <= localBitmap.getWidth()) {
        break label313;
      }
      i = localBitmap.getWidth();
      label263:
      ((Rect)localObject1).right = i;
      if (((Rect)localObject1).bottom <= localBitmap.getHeight()) {
        break label322;
      }
    }
    label304:
    label313:
    label322:
    for (int i = localBitmap.getHeight();; i = ((Rect)localObject1).bottom)
    {
      ((Rect)localObject1).bottom = i;
      return localObject1;
      i = ((Rect)localObject1).left;
      break;
      i = ((Rect)localObject1).top;
      break label240;
      i = ((Rect)localObject1).right;
      break label263;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.RegionView
 * JD-Core Version:    0.7.0.1
 */