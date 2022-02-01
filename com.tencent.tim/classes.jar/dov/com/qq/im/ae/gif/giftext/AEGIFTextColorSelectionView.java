package dov.com.qq.im.ae.gif.giftext;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import aqcx;

public class AEGIFTextColorSelectionView
  extends View
{
  private static String cTS = "#FFFFFF";
  private static String cTT = "#FFFFFF";
  private static String cTU = "#3CB6FF";
  private Paint aY;
  private String cTR;
  private Paint cZ;
  private int eEF;
  private int eEG;
  private int eEH;
  private Context mContext;
  private int mHeight;
  private Paint mRingPaint;
  private boolean mSelected;
  private int mWidth;
  
  public AEGIFTextColorSelectionView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public AEGIFTextColorSelectionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public AEGIFTextColorSelectionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    this.mSelected = true;
    this.cTR = cTS;
    this.aY = new Paint(1);
    this.aY.setColor(Color.parseColor(this.cTR));
    this.cZ = new Paint(1);
    this.cZ.setColor(Color.parseColor(cTT));
    this.mRingPaint = new Paint(1);
    this.mRingPaint.setColor(Color.parseColor(cTU));
    this.mRingPaint.setStyle(Paint.Style.STROKE);
    this.mRingPaint.setStrokeWidth(aqcx.dip2px(this.mContext, 2.0F));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.mSelected) {
      paramCanvas.drawCircle(this.mWidth / 2, this.mHeight / 2, this.eEH, this.mRingPaint);
    }
    paramCanvas.drawCircle(this.mWidth / 2, this.mHeight / 2, this.eEF, this.cZ);
    paramCanvas.drawCircle(this.mWidth / 2, this.mHeight / 2, this.eEG, this.aY);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.mWidth = View.MeasureSpec.getSize(paramInt1);
    this.mHeight = View.MeasureSpec.getSize(paramInt2);
    this.eEH = (this.mWidth / 2 - aqcx.dip2px(this.mContext, 1.0F));
    this.eEF = (this.eEH - aqcx.dip2px(this.mContext, 5.0F));
    this.eEG = (this.eEF - aqcx.dip2px(this.mContext, 2.0F));
  }
  
  public void p(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue() != this.mSelected)
    {
      this.mSelected = paramBoolean.booleanValue();
      invalidate();
    }
  }
  
  public void setColor(String paramString)
  {
    this.cTR = paramString;
    this.aY.setColor(Color.parseColor(paramString));
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.AEGIFTextColorSelectionView
 * JD-Core Version:    0.7.0.1
 */