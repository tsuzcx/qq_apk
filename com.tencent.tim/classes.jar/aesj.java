import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

class aesj
  extends ClickableSpan
{
  aesj(aesh paramaesh, String paramString) {}
  
  public void onClick(View paramView)
  {
    aqlt.b(aesh.a(this.a), BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramView.getContext());
    aesh.aD("0X800AE6D", this.bAQ, "");
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#4D94FF"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aesj
 * JD-Core Version:    0.7.0.1
 */