import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public class bwa
  extends ClickableSpan
{
  public bwa(GrayTipsItemBuilder paramGrayTipsItemBuilder, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    int j = 1;
    Object localObject;
    if (this.jdField_a_of_type_JavaLangString.startsWith("http"))
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      paramView = (View)localObject;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (((String)localObject).contains("?")) {
          paramView = (String)localObject + "&sid=" + GrayTipsItemBuilder.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder).getSid();
        }
      }
      else
      {
        localObject = new Intent(GrayTipsItemBuilder.j(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder), QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramView);
        ((Intent)localObject).putExtra("hide_left_button", true);
        ((Intent)localObject).putExtra("show_right_close_button", true);
        ((Intent)localObject).putExtra("finish_animation_up_down", true);
        GrayTipsItemBuilder.k(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder).startActivity((Intent)localObject);
      }
    }
    for (int i = 2;; i = 1)
    {
      paramView = GrayTipsItemBuilder.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder);
      if (GrayTipsItemBuilder.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder).a == 0) {}
      for (;;)
      {
        ReportController.a(paramView, "CliOper", "", "", "0X800416C", "0X800416C", 0, 0, String.valueOf(j), String.valueOf(2), String.valueOf(i), this.b);
        return;
        paramView = (String)localObject + "?sid=" + GrayTipsItemBuilder.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder).getSid();
        break;
        j = 2;
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(26, 144, 240));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bwa
 * JD-Core Version:    0.7.0.1
 */