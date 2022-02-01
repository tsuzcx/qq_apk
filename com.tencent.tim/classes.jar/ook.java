import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView.a;

final class ook
  extends ClickableSpan
{
  ook(FeedRichTextView.a parama, String paramString) {}
  
  public void onClick(@NonNull View paramView)
  {
    if (this.b != null) {
      this.b.pG(this.ady);
    }
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ook
 * JD-Core Version:    0.7.0.1
 */