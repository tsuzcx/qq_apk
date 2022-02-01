import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;
import android.util.TypedValue;

public class apuw
  extends ReplacementSpan
{
  private float As;
  private float At;
  private float Au;
  private int mBgColor;
  private Context mContext;
  private String mText;
  private int mTextColor;
  private float mTextSize;
  
  public apuw(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.mContext = paramContext.getApplicationContext();
    this.mBgColor = paramInt1;
    this.mText = paramString;
    this.As = TypedValue.applyDimension(1, paramInt2, this.mContext.getResources().getDisplayMetrics());
    this.Au = TypedValue.applyDimension(1, paramInt4, this.mContext.getResources().getDisplayMetrics());
    this.mTextSize = TypedValue.applyDimension(1, paramInt5, this.mContext.getResources().getDisplayMetrics());
    this.mTextColor = paramInt6;
    this.At = b(paramString, paramInt3);
  }
  
  private float b(String paramString, int paramInt)
  {
    if (paramString.length() > 1)
    {
      Rect localRect = new Rect();
      Paint localPaint = new Paint();
      localPaint.setTextSize(this.mTextSize);
      localPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
      float f = TypedValue.applyDimension(1, paramInt, this.mContext.getResources().getDisplayMetrics());
      return localRect.width() + f * 2.0F;
    }
    return this.As;
  }
  
  public void draw(@NonNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = new Paint();
    paramCharSequence.setColor(this.mBgColor);
    paramCharSequence.setStyle(Paint.Style.FILL);
    paramCharSequence.setAntiAlias(true);
    paramPaint = paramPaint.getFontMetrics();
    float f2 = paramPaint.descent;
    float f3 = paramPaint.ascent;
    float f1 = paramInt4;
    f2 = (f2 - f3 - this.As) / 2.0F;
    f1 = paramPaint.ascent + (f2 + f1);
    paramCanvas.drawRoundRect(new RectF(paramFloat, f1, this.At + paramFloat, this.As + f1), 0.0F, 0.0F, paramCharSequence);
    paramCharSequence = new TextPaint();
    paramCharSequence.setColor(this.mTextColor);
    paramCharSequence.setTextSize(this.mTextSize);
    paramCharSequence.setAntiAlias(true);
    paramCharSequence.setTextAlign(Paint.Align.CENTER);
    paramPaint = paramCharSequence.getFontMetrics();
    f2 = paramPaint.bottom;
    f3 = paramPaint.top;
    paramCanvas.drawText(this.mText, this.At / 2.0F + paramFloat, f1 + (this.As - (f2 - f3)) / 2.0F - paramPaint.top, paramCharSequence);
  }
  
  public int getSize(@NonNull Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    return (int)(this.At + this.Au);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apuw
 * JD-Core Version:    0.7.0.1
 */