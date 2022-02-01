import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView.a;

final class ooj
  extends ClickableSpan
{
  ooj(FeedRichTextView.a parama, String paramString) {}
  
  public void onClick(@NonNull View paramView)
  {
    if (this.b != null) {
      this.b.pF(this.wb);
    }
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ooj
 * JD-Core Version:    0.7.0.1
 */