import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.style.ReplacementSpan;
import com.tencent.qphone.base.util.QLog;

public class aqqa
  extends ReplacementSpan
{
  public int mType;
  public int value;
  
  public aqqa(int paramInt1, int paramInt2)
  {
    this.mType = paramInt1;
    this.value = paramInt2;
  }
  
  public void draw(@NonNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NonNull Paint paramPaint)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorSpan", 2, "onDraw");
    }
  }
  
  public int getSize(@NonNull Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, @Nullable Paint.FontMetricsInt paramFontMetricsInt)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqqa
 * JD-Core Version:    0.7.0.1
 */