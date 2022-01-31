import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.EmosmDetailActivity;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticon.EmoticonController;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class crm
  implements View.OnClickListener
{
  public crm(EmosmDetailActivity paramEmosmDetailActivity, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    if ((2 == this.jdField_a_of_type_ComTencentMobileqqActivityEmosmDetailActivity.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType) && (!EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmosmDetailActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface).a()))
    {
      ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131562210, 0);
      return;
    }
    MarketFaceItemBuilder.m = 2;
    EmosmDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmosmDetailActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, MarketFaceItemBuilder.a.frienduin, "ep_mall", "Ep_detail_forward", 0);
    paramView = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext);
    paramView.a(this.jdField_a_of_type_AndroidContentContext.getString(2131562658));
    paramView.show();
    EmosmDetailActivity.a(7, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityEmosmDetailActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityEmosmDetailActivity.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, this.jdField_a_of_type_ComTencentMobileqqActivityEmosmDetailActivity.jdField_b_of_type_AndroidWidgetImageView, paramView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     crm
 * JD-Core Version:    0.7.0.1
 */