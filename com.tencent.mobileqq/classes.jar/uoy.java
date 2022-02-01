import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

final class uoy
  extends ClickableSpan
{
  uoy(String paramString) {}
  
  public void onClick(@NonNull View paramView)
  {
    upg.a(uov.a(), "biz_src_jc_gzh_weishi", "weishi://profile?person_id=" + this.a);
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uoy
 * JD-Core Version:    0.7.0.1
 */