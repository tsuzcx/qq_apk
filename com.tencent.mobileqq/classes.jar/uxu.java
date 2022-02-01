import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

final class uxu
  extends ClickableSpan
{
  uxu(String paramString) {}
  
  public void onClick(@NonNull View paramView)
  {
    uyc.a(uxr.a(), "biz_src_jc_gzh_weishi", "weishi://profile?person_id=" + this.a);
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uxu
 * JD-Core Version:    0.7.0.1
 */