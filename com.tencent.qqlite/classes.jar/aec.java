import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter;
import com.tencent.mobileqq.activity.ImageViewParameter;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.httputils.PkgTools;

public class aec
  implements View.OnClickListener
{
  public aec(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, int paramInt, ImageViewParameter paramImageViewParameter, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Int == -3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.istroop == 1001))
    {
      paramView = PkgTools.c(this.jdField_a_of_type_JavaLangString);
      paramView = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.app, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a, paramView);
      if (paramView != null) {
        paramView.b();
      }
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_Int == -3000) || (this.jdField_a_of_type_Int == -3004) || (this.jdField_a_of_type_Int == -30002) || (this.jdField_a_of_type_Int == -30003))
      {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.app, this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.action, this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.shareAppID, this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.msgtype);
        return;
      }
      if (this.jdField_a_of_type_Int == -3005)
      {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.app, this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.action, this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.shareAppID, this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.msgtype);
        return;
      }
    } while (this.jdField_a_of_type_Int == -3001);
    PicItemBuilder.a(paramView.getContext(), paramView, this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a, ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     aec
 * JD-Core Version:    0.7.0.1
 */