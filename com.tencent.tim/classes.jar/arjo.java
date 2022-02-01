import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;

public class arjo
  extends VerticalCenterImageSpan
{
  private int dwW;
  
  public arjo(Drawable paramDrawable)
  {
    super(paramDrawable, 0);
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    return super.getSize(paramPaint, paramCharSequence, paramInt1, paramInt2, paramFontMetricsInt) + this.dwW;
  }
  
  public void setRightMargin(int paramInt)
  {
    this.dwW = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arjo
 * JD-Core Version:    0.7.0.1
 */