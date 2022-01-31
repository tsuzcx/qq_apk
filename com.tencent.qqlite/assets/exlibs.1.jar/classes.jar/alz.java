import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.EmosmDetailActivity;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class alz
  implements View.OnClickListener
{
  public alz(EmosmDetailActivity paramEmosmDetailActivity, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    paramView = (EmojiManager)this.jdField_a_of_type_ComTencentMobileqqActivityEmosmDetailActivity.app.getManager(39);
    if ((2 == this.jdField_a_of_type_ComTencentMobileqqActivityEmosmDetailActivity.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType) && (!paramView.a()))
    {
      ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131364122, 0);
      return;
    }
    MarketFaceItemBuilder.m = 2;
    EmosmDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmosmDetailActivity.app, MarketFaceItemBuilder.a.frienduin, "ep_mall", "Ep_detail_forward", 0);
    paramView = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext);
    paramView.a(this.jdField_a_of_type_AndroidContentContext.getString(2131364051));
    paramView.show();
    EmosmDetailActivity.a(7, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityEmosmDetailActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityEmosmDetailActivity.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, this.jdField_a_of_type_ComTencentMobileqqActivityEmosmDetailActivity.b, paramView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     alz
 * JD-Core Version:    0.7.0.1
 */