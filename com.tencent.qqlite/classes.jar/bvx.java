import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class bvx
  extends ClickableSpan
{
  public bvx(GrayTipsItemBuilder paramGrayTipsItemBuilder, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    paramView = GrayTipsItemBuilder.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder).getString(2131363596) + " " + this.jdField_a_of_type_JavaLangString;
    paramView = DialogUtil.a(GrayTipsItemBuilder.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder), 230).setTitle(paramView).setMessage(this.b);
    paramView.setPositiveButton(GrayTipsItemBuilder.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder).getString(2131363598), new bvz(this)).setNegativeButton(GrayTipsItemBuilder.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder).getString(2131362801), new bvy(this));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bvx
 * JD-Core Version:    0.7.0.1
 */