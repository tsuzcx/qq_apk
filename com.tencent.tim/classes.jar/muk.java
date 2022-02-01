import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

final class muk
  extends ClickableSpan
{
  muk(TextView paramTextView) {}
  
  public void onClick(View paramView)
  {
    this.val$textView.performClick();
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.parseColor("#FF00CAFC"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     muk
 * JD-Core Version:    0.7.0.1
 */