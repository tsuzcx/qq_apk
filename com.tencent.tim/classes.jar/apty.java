import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.webkit.URLUtil;
import com.tencent.mobileqq.data.MessageRecord;

final class apty
  extends ClickableSpan
{
  apty(String paramString, MessageRecord paramMessageRecord) {}
  
  public void onClick(View paramView)
  {
    String str = URLUtil.guessUrl(this.crw);
    ajhj.a(paramView.getContext(), str, true, true, true, false, this.k);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(paramTextPaint.linkColor);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apty
 * JD-Core Version:    0.7.0.1
 */