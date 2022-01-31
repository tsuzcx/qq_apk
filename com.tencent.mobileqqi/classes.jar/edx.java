import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class edx
  extends ClickableSpan
{
  public edx(GrayTipsItemBuilder paramGrayTipsItemBuilder, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    paramView = GrayTipsItemBuilder.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder).getString(2131561734) + " " + this.jdField_a_of_type_JavaLangString;
    paramView = DialogUtil.a(GrayTipsItemBuilder.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder), 230).setTitle(paramView).setMessage(this.b);
    paramView.setPositiveButton(GrayTipsItemBuilder.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder).getString(2131561726), new edz(this)).setNegativeButton(GrayTipsItemBuilder.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder).getString(2131561746), new edy(this));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     edx
 * JD-Core Version:    0.7.0.1
 */