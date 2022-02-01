import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

final class aagf
  extends ClickableSpan
{
  aagf(aagd.a parama, String paramString) {}
  
  public void onClick(View paramView)
  {
    this.a.zR(this.val$url);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aagf
 * JD-Core Version:    0.7.0.1
 */