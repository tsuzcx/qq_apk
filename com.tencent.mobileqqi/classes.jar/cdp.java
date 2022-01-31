import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.statistics.ReportController;

public class cdp
  implements View.OnClickListener
{
  public cdp(ChatActivity paramChatActivity, QQOperationViopTipTask paramQQOperationViopTipTask) {}
  
  public void onClick(View paramView)
  {
    int j = 2;
    ChatActivityFacade.d(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.b, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.jdField_a_of_type_JavaLangString);
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url.startsWith("mqqapi")) {
      if ((this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url.contains("c2c")) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.jdField_a_of_type_Int == 0))
      {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.b, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.d, null, true, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.b, true, true, null, "from_internal");
        i = 1;
      }
    }
    for (;;)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.b;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.jdField_a_of_type_Int == 0) {
        j = 1;
      }
      ReportController.a(paramView, "CliOper", "", "", "0X800416C", "0X800416C", 0, 0, String.valueOf(j), String.valueOf(1), String.valueOf(i), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.taskid));
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url.contains("discussion")) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.jdField_a_of_type_Int == 3000))
      {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.b, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.jdField_a_of_type_JavaLangString, true, true, null);
        i = 1;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url.startsWith("http"))
        {
          Object localObject = this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url;
          paramView = (View)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            if (!((String)localObject).contains("?")) {
              break label399;
            }
          }
          label399:
          for (paramView = (String)localObject + "&sid=" + this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.b.getSid();; paramView = (String)localObject + "?sid=" + this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.b.getSid())
          {
            localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, QQBrowserActivity.class);
            ((Intent)localObject).putExtra("url", paramView);
            ((Intent)localObject).putExtra("hide_left_button", true);
            ((Intent)localObject).putExtra("show_right_close_button", true);
            ((Intent)localObject).putExtra("finish_animation_up_down", true);
            this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.startActivity((Intent)localObject);
            i = 2;
            break;
          }
        }
      }
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cdp
 * JD-Core Version:    0.7.0.1
 */