import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

final class upz
  extends ClickableSpan
{
  upz(String paramString) {}
  
  public void onClick(@NonNull View paramView)
  {
    uqh.a(upw.a(), "biz_src_jc_gzh_weishi", "weishi://profile?person_id=" + this.a);
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     upz
 * JD-Core Version:    0.7.0.1
 */