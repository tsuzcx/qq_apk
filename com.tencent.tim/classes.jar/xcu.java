import android.app.Activity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

class xcu
  extends ClickableSpan
{
  xcu(xci paramxci) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.mContext instanceof Activity))
    {
      paramView = ausj.b(this.this$0.mContext);
      paramView.addButton(2131721238);
      paramView.addCancelButton(2131721058);
      paramView.a(new xcv(this));
      paramView.a(new xcw(this, paramView));
      paramView.show();
      anot.a(this.this$0.app, "CliOper", "", "", "0X8005973", "0X8005973", 0, 0, "", "", "", "");
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-14782465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xcu
 * JD-Core Version:    0.7.0.1
 */