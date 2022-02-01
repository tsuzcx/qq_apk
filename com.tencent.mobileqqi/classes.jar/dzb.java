import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public class dzb
  extends ClickableSpan
{
  public dzb(GrayTipsItemBuilder paramGrayTipsItemBuilder, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    int j = 1;
    int i;
    if (this.jdField_a_of_type_JavaLangString.startsWith("mqqapi")) {
      if ((this.jdField_a_of_type_JavaLangString.contains("c2c")) && (GrayTipsItemBuilder.v(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder).jdField_a_of_type_Int == 0))
      {
        ChatActivityUtils.a(GrayTipsItemBuilder.k(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder), (Activity)GrayTipsItemBuilder.p(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder), GrayTipsItemBuilder.w(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder).jdField_a_of_type_Int, GrayTipsItemBuilder.x(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder).jdField_a_of_type_JavaLangString, GrayTipsItemBuilder.y(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder).d, null, true, GrayTipsItemBuilder.z(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder).b, true, true, null, "");
        i = 1;
      }
    }
    for (;;)
    {
      paramView = GrayTipsItemBuilder.o(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder);
      if (GrayTipsItemBuilder.C(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder).jdField_a_of_type_Int == 0) {}
      for (;;)
      {
        ReportController.a(paramView, "CliOper", "", "", "0X800416C", "0X800416C", 0, 0, String.valueOf(j), String.valueOf(2), String.valueOf(i), this.b);
        return;
        if ((!this.jdField_a_of_type_JavaLangString.contains("discussion")) || (GrayTipsItemBuilder.A(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder).jdField_a_of_type_Int != 3000)) {
          break label416;
        }
        ChatActivityUtils.a(GrayTipsItemBuilder.l(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder), (Activity)GrayTipsItemBuilder.q(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder), GrayTipsItemBuilder.B(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder).jdField_a_of_type_JavaLangString, true, true, null);
        i = 1;
        break;
        if (!this.jdField_a_of_type_JavaLangString.startsWith("http")) {
          break label416;
        }
        Object localObject = this.jdField_a_of_type_JavaLangString;
        paramView = (View)localObject;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          if (!((String)localObject).contains("?")) {
            break label374;
          }
        }
        label374:
        for (paramView = (String)localObject + "&sid=" + GrayTipsItemBuilder.m(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder).getSid();; paramView = (String)localObject + "?sid=" + GrayTipsItemBuilder.n(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder).getSid())
        {
          localObject = new Intent(GrayTipsItemBuilder.r(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder), QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", paramView);
          ((Intent)localObject).putExtra("hide_left_button", true);
          ((Intent)localObject).putExtra("show_right_close_button", true);
          ((Intent)localObject).putExtra("finish_animation_up_down", true);
          GrayTipsItemBuilder.s(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder).startActivity((Intent)localObject);
          i = 2;
          break;
        }
        j = 2;
      }
      label416:
      i = 1;
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(26, 144, 240));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dzb
 * JD-Core Version:    0.7.0.1
 */