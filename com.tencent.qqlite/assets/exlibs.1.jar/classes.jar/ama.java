import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.EmosmDetailActivity;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class ama
  implements View.OnClickListener
{
  public ama(EmosmDetailActivity paramEmosmDetailActivity, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    EmosmDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmosmDetailActivity.app, MarketFaceItemBuilder.a.frienduin, "ep_mall", "Clk_collect", 0);
    paramView = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext);
    paramView.a(this.jdField_a_of_type_AndroidContentContext.getString(2131364050));
    paramView.show();
    EmosmDetailActivity.a(6, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityEmosmDetailActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityEmosmDetailActivity.a, this.jdField_a_of_type_ComTencentMobileqqActivityEmosmDetailActivity.b, paramView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ama
 * JD-Core Version:    0.7.0.1
 */