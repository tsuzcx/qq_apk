package dov.com.qq.im.aeeditor.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.widget.ImageView;
import axog;

public class ClipThumbnailImageView
  extends ImageView
{
  private Context mContext;
  private boolean mIsSelected;
  private Paint mPaint;
  
  public ClipThumbnailImageView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public ClipThumbnailImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public ClipThumbnailImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mIsSelected = false;
    this.mContext = paramContext;
    this.mPaint = new Paint();
    this.mPaint.setColor(paramContext.getResources().getColor(2131165252));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.mIsSelected)
    {
      this.mPaint.setStyle(Paint.Style.FILL);
      int i = getWidth();
      int j = getHeight();
      int k = axog.dip2px(this.mContext, 2.0F);
      paramCanvas.drawRect(0.0F, 0.0F, i, k, this.mPaint);
      paramCanvas.drawRect(i - k, 0.0F, i, j, this.mPaint);
      paramCanvas.drawRect(0.0F, j - k, i, j, this.mPaint);
      paramCanvas.drawRect(0.0F, 0.0F, k, j, this.mPaint);
    }
  }
  
  public void setIsSelected(boolean paramBoolean)
  {
    this.mIsSelected = paramBoolean;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.ClipThumbnailImageView
 * JD-Core Version:    0.7.0.1
 */