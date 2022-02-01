import android.app.Activity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

class xdb
  extends ClickableSpan
{
  xdb(xci paramxci) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.mContext instanceof Activity))
    {
      paramView = ausj.b(this.this$0.mContext);
      paramView.addButton(2131721252);
      paramView.addCancelButton(2131721058);
      paramView.a(new xdc(this));
      paramView.a(new xdd(this, paramView));
      paramView.show();
      anot.a(this.this$0.app, "CliOper", "", "", "0X8005975", "0X8005975", 0, 0, "", "", "", "");
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-14782465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xdb
 * JD-Core Version:    0.7.0.1
 */