package dov.com.qq.im.cropvideo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class RegionView
  extends View
{
  boolean bsU = false;
  int caO = 1711276032;
  int ceO = 1;
  int clipHeight;
  int clipWidth;
  final Paint paint = new Paint();
  final Rect rect = new Rect();
  int targetHeight;
  int targetWidth;
  
  public RegionView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RegionView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RegionView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int MO()
  {
    return this.targetHeight;
  }
  
  public int getClipHeight()
  {
    return this.clipHeight;
  }
  
  public int getClipWidth()
  {
    return this.clipWidth;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.clipWidth == 0) {
      this.clipWidth = getWidth();
    }
    if (this.clipHeight == 0) {
      this.clipHeight = getHeight();
    }
    this.rect.left = ((getWidth() - this.clipWidth) / 2);
    this.rect.right = ((getWidth() + this.clipWidth) / 2);
    this.rect.top = ((getHeight() - this.clipHeight) / 2);
    this.rect.bottom = ((getHeight() + this.clipHeight) / 2);
    if (this.ceO == 0)
    {
      this.paint.setColor(this.caO);
      this.paint.setStyle(Paint.Style.FILL);
      localObject = new Path();
      f = this.rect.top + this.rect.height() * 0.5F;
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
    }
    while (1 != this.ceO)
    {
      float f;
      return;
    }
    Object localObject = new Rect[8];
    localObject[0] = new Rect(0, 0, this.rect.left, this.rect.top);
    localObject[1] = new Rect(this.rect.left, 0, this.rect.right, this.rect.top);
    localObject[2] = new Rect(this.rect.right, 0, getWidth(), this.rect.top);
    localObject[3] = new Rect(0, this.rect.top, this.rect.left, this.rect.bottom);
    localObject[4] = new Rect(this.rect.right, this.rect.top, getWidth(), this.rect.bottom);
    localObject[5] = new Rect(0, this.rect.bottom, this.rect.left, getHeight());
    localObject[6] = new Rect(this.rect.left, this.rect.bottom, this.rect.right, getHeight());
    localObject[7] = new Rect(this.rect.right, this.rect.bottom, getWidth(), getHeight());
    Rect localRect = new Rect();
    localRect.set(this.rect);
    localRect.left -= 2;
    localRect.right += 2;
    localRect.top -= 2;
    localRect.bottom += 2;
    this.paint.setColor(this.caO);
    this.paint.setStyle(Paint.Style.FILL);
    int i = 0;
    while (i < localObject.length)
    {
      paramCanvas.drawRect(localObject[i], this.paint);
      i += 1;
    }
    this.paint.setColor(0);
    paramCanvas.drawRect(localRect, this.paint);
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setStrokeWidth(5.0F);
    this.paint.setColor(1291845632);
    paramCanvas.drawRect(localRect, this.paint);
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setStrokeWidth(3.0F);
    this.paint.setColor(-1);
    paramCanvas.drawRect(localRect, this.paint);
  }
  
  public void setClipHeight(int paramInt)
  {
    this.clipHeight = paramInt;
  }
  
  public void setClipWidth(int paramInt)
  {
    this.clipWidth = paramInt;
  }
  
  public void setMaskColor(int paramInt)
  {
    this.caO = paramInt;
  }
  
  public void setMaskShapeType(int paramInt)
  {
    this.ceO = paramInt;
  }
  
  public void setTargetHeight(int paramInt)
  {
    this.targetHeight = paramInt;
  }
  
  public void setTargetWidth(int paramInt)
  {
    this.targetWidth = paramInt;
  }
  
  public void setUsedARGB(boolean paramBoolean)
  {
    this.bsU = paramBoolean;
  }
  
  public int yD()
  {
    return this.targetWidth;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.cropvideo.RegionView
 * JD-Core Version:    0.7.0.1
 */