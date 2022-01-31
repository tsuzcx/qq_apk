import android.app.Activity;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie;
import com.tencent.widget.ActionSheet;

public class uwp
  extends ClickableSpan
{
  public uwp(GrayTipsItemBuilder paramGrayTipsItemBuilder, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.a instanceof Activity))
    {
      paramView = ActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.a);
      paramView.b(2131436671);
      paramView.c(2131432998);
      paramView.a(new uwq(this, paramView));
      paramView.show();
      BaseChatPie localBaseChatPie = ((FragmentActivity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.a).getChatFragment().a();
      if ((localBaseChatPie instanceof DiscussChatPie)) {
        ((DiscussChatPie)localBaseChatPie).a = paramView;
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(26, 144, 240));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uwp
 * JD-Core Version:    0.7.0.1
 */