import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCell;

public class vgh
  extends ClickableSpan
{
  public vgh(TextCell paramTextCell) {}
  
  public void onClick(View paramView)
  {
    if (this.a.clickable())
    {
      Intent localIntent = this.a.getIntent();
      if (localIntent != null) {
        paramView.getContext().startActivity(localIntent);
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(paramTextPaint.linkColor);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgh
 * JD-Core Version:    0.7.0.1
 */