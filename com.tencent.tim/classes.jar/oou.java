import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

final class oou
  extends ClickableSpan
{
  oou(String paramString) {}
  
  public void onClick(@NonNull View paramView)
  {
    opb.p(oor.getContext(), "biz_src_jc_gzh_weishi", "weishi://profile?person_id=" + this.wb);
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oou
 * JD-Core Version:    0.7.0.1
 */