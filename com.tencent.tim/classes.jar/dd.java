import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;

class dd
  extends ClickableSpan
{
  dd(db paramdb) {}
  
  public void onClick(View paramView)
  {
    ahav.h(this.this$0.b, this.this$0.app.getCurrentAccountUin(), acfp.m(2131696154), acfp.m(2131696154));
    anot.a(this.this$0.app, "CliOper", "", "", "0X800513D", "0X800513D", 0, 0, "", "", "", "");
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.parseColor("#00a5e0"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dd
 * JD-Core Version:    0.7.0.1
 */