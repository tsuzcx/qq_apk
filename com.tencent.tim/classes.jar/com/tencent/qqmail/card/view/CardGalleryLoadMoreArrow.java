package com.tencent.qqmail.card.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.qqmail.utilities.ui.QMUIKit;

public class CardGalleryLoadMoreArrow
  extends ImageView
{
  private int mOffset = 0;
  private Paint mPaint = new Paint(1);
  private Path path = new Path();
  
  public CardGalleryLoadMoreArrow(Context paramContext)
  {
    super(paramContext);
  }
  
  public CardGalleryLoadMoreArrow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CardGalleryLoadMoreArrow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.mPaint.setAntiAlias(true);
    this.mPaint.setColor(getResources().getColor(2131165533));
    this.mPaint.setStrokeWidth(QMUIKit.dpToPx(3));
    this.mPaint.setStyle(Paint.Style.STROKE);
    int i = QMUIKit.dpToPx(3);
    int j = getWidth();
    int k = getHeight();
    this.path.moveTo(j - this.mOffset - i, i);
    this.path.lineTo(Math.min(this.mOffset, j) + i, k / 2);
    this.path.lineTo(j - this.mOffset - i, k - i);
    paramCanvas.drawPath(this.path, this.mPaint);
  }
  
  public void reDrawArrow(int paramInt)
  {
    if (Math.abs(paramInt) > 30)
    {
      this.mOffset = Math.min(getWidth() - QMUIKit.dpToPx(3) * 2, (int)((Math.abs(paramInt) - 30) * 0.15D));
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.view.CardGalleryLoadMoreArrow
 * JD-Core Version:    0.7.0.1
 */