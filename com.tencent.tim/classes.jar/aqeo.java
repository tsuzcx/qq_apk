import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;

public class aqeo
  extends Drawable
{
  private String cst;
  private Bitmap mBitmap;
  private Context mContext;
  private Paint mPaint = new Paint(7);
  private TextPaint mTextPaint = new TextPaint();
  private int mWidth;
  
  public aqeo(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.cst = paramString;
    this.mBitmap = aqcu.f(this.mContext.getResources(), 2130842937);
    this.mTextPaint.setAntiAlias(true);
    this.mTextPaint.setColor(-1);
    this.mWidth = Math.min(this.mBitmap.getWidth(), this.mBitmap.getHeight());
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    float f1 = localRect.width() / this.mWidth;
    float f2 = this.mWidth / 2;
    this.mTextPaint.setTextSize(f1 * f2);
    Paint.FontMetrics localFontMetrics = this.mTextPaint.getFontMetrics();
    paramCanvas.drawBitmap(this.mBitmap, 0.0F, 0.0F, this.mPaint);
    if (this.cst != null) {
      if (this.cst != null) {
        break label172;
      }
    }
    label172:
    for (int i = 0;; i = (int)Layout.getDesiredWidth(this.cst, this.mTextPaint))
    {
      int j = (int)(localFontMetrics.descent - localFontMetrics.ascent);
      j = localRect.left;
      i = (localRect.width() - i) / 2;
      f1 = localRect.top;
      int k = (int)(localRect.height() / 2.0F + f1 - (localFontMetrics.bottom - localFontMetrics.top) / 2.0F - localFontMetrics.top);
      paramCanvas.drawText(this.cst, i + j, k, this.mTextPaint);
      return;
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.mBitmap.getHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.mBitmap.getWidth();
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqeo
 * JD-Core Version:    0.7.0.1
 */