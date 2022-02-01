import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

final class ahbe
  extends ClickableSpan
{
  ahbe(ahav.d paramd) {}
  
  public void onClick(View paramView)
  {
    if (this.a != null) {
      this.a.onClick(paramView);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-14782465);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahbe
 * JD-Core Version:    0.7.0.1
 */