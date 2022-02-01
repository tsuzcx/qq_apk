package dov.com.qq.im.aeeditor.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import axog;

public class AEEditorClipIndexView
  extends View
{
  private Paint mCirclePaint;
  private Context mContext;
  private int mIndex;
  private Paint mTextPaint;
  
  public AEEditorClipIndexView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public AEEditorClipIndexView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public AEEditorClipIndexView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    this.mCirclePaint = new Paint();
    this.mTextPaint = new Paint();
    this.mIndex = 1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = Math.min(getWidth(), getHeight()) / 2;
    this.mCirclePaint.setAntiAlias(true);
    this.mCirclePaint.setColor(this.mContext.getResources().getColor(2131167654));
    paramCanvas.drawCircle(i, i, i, this.mCirclePaint);
    this.mCirclePaint.setColor(this.mContext.getResources().getColor(2131165252));
    int j = axog.dip2px(this.mContext, 1.0F);
    paramCanvas.drawCircle(i, i, i - j, this.mCirclePaint);
    this.mTextPaint.setStyle(Paint.Style.FILL);
    this.mTextPaint.setTextSize(axog.dip2px(this.mContext, 17.0F));
    this.mTextPaint.setColor(this.mContext.getResources().getColor(2131167654));
    this.mTextPaint.setTextAlign(Paint.Align.CENTER);
    Paint.FontMetrics localFontMetrics = this.mTextPaint.getFontMetrics();
    float f1 = (localFontMetrics.bottom - localFontMetrics.top) / 2.0F;
    float f2 = localFontMetrics.bottom;
    float f3 = getHeight() / 2.0F;
    paramCanvas.drawText(this.mIndex + "", getWidth() / 2, f1 - f2 + f3, this.mTextPaint);
  }
  
  public void setIndex(int paramInt)
  {
    this.mIndex = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.AEEditorClipIndexView
 * JD-Core Version:    0.7.0.1
 */