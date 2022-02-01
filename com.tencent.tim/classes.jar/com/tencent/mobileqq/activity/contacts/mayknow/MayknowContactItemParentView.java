package com.tencent.mobileqq.activity.contacts.mayknow;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import wja;

public class MayknowContactItemParentView
  extends RelativeLayout
{
  Path B;
  int ccy;
  int ccz;
  Drawable eg;
  int mBgColor;
  int mRadius;
  
  public MayknowContactItemParentView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public MayknowContactItemParentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public MayknowContactItemParentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    try
    {
      this.mBgColor = getResources().getColor(2131167363);
      this.eg = getResources().getDrawable(2130839754);
      this.mRadius = wja.dp2px(6.0F, getResources());
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        this.eg = null;
        QLog.i("MayknowContactItemParentView", 1, "init error:" + paramContext.getMessage());
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    for (;;)
    {
      try
      {
        paramCanvas.save();
        int i = getMeasuredWidth();
        int j = getMeasuredHeight();
        if ((this.B == null) || (i != this.ccy) || (j != this.ccz))
        {
          this.B = new Path();
          this.B.moveTo(0.0F, this.mRadius);
          this.B.arcTo(new RectF(0.0F, 0.0F, this.mRadius * 2, this.mRadius * 2), -180.0F, 90.0F);
          this.B.lineTo(i - this.mRadius, 0.0F);
          this.B.arcTo(new RectF(i - this.mRadius * 2, 0.0F, i, this.mRadius * 2), -90.0F, 90.0F);
          this.B.lineTo(i, j - this.mRadius);
          this.B.arcTo(new RectF(i - this.mRadius * 2, j - this.mRadius * 2, i, j), 0.0F, 90.0F);
          this.B.lineTo(this.mRadius, j);
          this.B.arcTo(new RectF(0.0F, j - this.mRadius * 2, this.mRadius * 2, j), 90.0F, 90.0F);
          this.B.close();
          this.ccy = i;
          this.ccz = j;
        }
        paramCanvas.clipPath(this.B);
        if (!"1103".equals(ThemeUtil.curThemeId)) {
          continue;
        }
        paramCanvas.drawColor(-15921907);
        paramCanvas.restore();
        if (this.eg != null)
        {
          this.eg.setBounds(getLeft(), getTop(), getRight(), getBottom());
          this.eg.draw(paramCanvas);
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.i("MayknowContactItemParentView", 1, "dispatchDraw error:" + localThrowable.getMessage());
        continue;
      }
      super.dispatchDraw(paramCanvas);
      return;
      paramCanvas.drawColor(this.mBgColor);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.mayknow.MayknowContactItemParentView
 * JD-Core Version:    0.7.0.1
 */