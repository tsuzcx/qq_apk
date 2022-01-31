import android.app.Activity;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.data.MessageForGrayTips;
import cooperation.dingdong.DingdongPluginHelper;

public class uwo
  extends ClickableSpan
{
  public uwo(GrayTipsItemBuilder paramGrayTipsItemBuilder, String paramString, MessageForGrayTips paramMessageForGrayTips) {}
  
  public void onClick(View paramView)
  {
    int i = Integer.parseInt(this.jdField_a_of_type_JavaLangString);
    DingdongPluginHelper.a((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.a, i, this.jdField_a_of_type_ComTencentMobileqqDataMessageForGrayTips.getExtInfoFromExtStr("approval_workid"));
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(26, 144, 240));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uwo
 * JD-Core Version:    0.7.0.1
 */