package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;

public class PhotoViewSelectedImageView
  extends URLImageView
{
  private Paint aJ = new Paint();
  private boolean selected;
  
  public PhotoViewSelectedImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PhotoViewSelectedImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PhotoViewSelectedImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.aJ.setStyle(Paint.Style.FILL);
    this.aJ.setColor(-16730881);
    this.aJ.setAntiAlias(true);
  }
  
  public boolean isSelected()
  {
    return this.selected;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (isSelected()) {
      paramCanvas.drawRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), 5.0F, 5.0F, this.aJ);
    }
    super.onDraw(paramCanvas);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    this.selected = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PhotoViewSelectedImageView
 * JD-Core Version:    0.7.0.1
 */