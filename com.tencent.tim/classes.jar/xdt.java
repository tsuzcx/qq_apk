import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;

class xdt
  extends ClickableSpan
{
  xdt(xci paramxci, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.mContext instanceof Activity))
    {
      paramView = ausj.b(this.this$0.mContext);
      paramView.addButton(2131692984);
      paramView.addCancelButton(2131721058);
      paramView.a(new xdu(this, paramView));
      paramView.show();
      BaseChatPie localBaseChatPie = ((FragmentActivity)this.this$0.mContext).getChatFragment().a();
      if ((localBaseChatPie instanceof xyi)) {
        ((xyi)localBaseChatPie).Z = paramView;
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-14782465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xdt
 * JD-Core Version:    0.7.0.1
 */