import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

final class aued
  extends ClickableSpan
{
  aued(audx.c paramc) {}
  
  public void onClick(View paramView)
  {
    if (this.b != null) {
      this.b.onClick(paramView);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.parseColor("#1E6FFF"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aued
 * JD-Core Version:    0.7.0.1
 */