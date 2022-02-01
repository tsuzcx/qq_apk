import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

class jcq
  extends ClickableSpan
{
  jcq(jci paramjci) {}
  
  public void onClick(View paramView)
  {
    this.b.atD();
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(paramTextPaint.getColor());
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jcq
 * JD-Core Version:    0.7.0.1
 */