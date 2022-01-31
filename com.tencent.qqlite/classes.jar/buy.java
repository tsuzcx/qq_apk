import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class buy
  extends ClickableSpan
{
  public buy(GrayTipsItemBuilder paramGrayTipsItemBuilder, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    paramView = GrayTipsItemBuilder.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder).getString(2131363585) + " " + this.jdField_a_of_type_JavaLangString;
    paramView = DialogUtil.a(GrayTipsItemBuilder.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder), 230).setTitle(paramView).setMessage(this.b);
    paramView.setPositiveButton(GrayTipsItemBuilder.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder).getString(2131363587), new bva(this)).setNegativeButton(GrayTipsItemBuilder.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder).getString(2131362794), new buz(this));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     buy
 * JD-Core Version:    0.7.0.1
 */