import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.statistics.ReportController;

public class bvu
  extends ClickableSpan
{
  public bvu(GrayTipsItemBuilder paramGrayTipsItemBuilder, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent("android.intent.action.VIEW", Uri.parse(this.jdField_a_of_type_JavaLangString));
    ReportController.b(GrayTipsItemBuilder.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder), "CliOper", "", GrayTipsItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder).jdField_a_of_type_JavaLangString, "0X800491B", "0X800491B", 0, 0, "", "", "", "");
    try
    {
      GrayTipsItemBuilder.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder).startActivity(paramView);
      return;
    }
    catch (ActivityNotFoundException paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-16732929);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bvu
 * JD-Core Version:    0.7.0.1
 */