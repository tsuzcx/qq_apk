import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View.OnClickListener;

public abstract class amht
  extends ClickableSpan
  implements View.OnClickListener
{
  private int textColor;
  
  public amht(int paramInt)
  {
    this.textColor = paramInt;
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(this.textColor);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amht
 * JD-Core Version:    0.7.0.1
 */