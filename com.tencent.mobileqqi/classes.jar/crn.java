import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.EmosmDetailActivity;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class crn
  implements View.OnClickListener
{
  public crn(EmosmDetailActivity paramEmosmDetailActivity, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    EmosmDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmosmDetailActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, MarketFaceItemBuilder.a.frienduin, "ep_mall", "Clk_collect", 0);
    paramView = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext);
    paramView.a(this.jdField_a_of_type_AndroidContentContext.getString(2131561618));
    paramView.show();
    EmosmDetailActivity.a(6, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityEmosmDetailActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityEmosmDetailActivity.a, this.jdField_a_of_type_ComTencentMobileqqActivityEmosmDetailActivity.jdField_b_of_type_AndroidWidgetImageView, paramView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     crn
 * JD-Core Version:    0.7.0.1
 */