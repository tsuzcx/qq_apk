import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.FriendHotTipsBar;
import com.tencent.mobileqq.activity.aio.tips.QQOperateTips;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.statistics.ReportController;
import java.lang.ref.WeakReference;
import mqq.manager.TicketManager;

public class wdf
  implements View.OnClickListener
{
  public wdf(QQOperateTips paramQQOperateTips, QQOperationViopTipTask paramQQOperationViopTipTask) {}
  
  public void onClick(View paramView)
  {
    if ((QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips) == null) || (QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).get() == null)) {
      return;
    }
    FriendHotTipsBar.c(QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips), QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).jdField_a_of_type_JavaLangString);
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url.startsWith("mqqapi")) {
      if ((this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url.contains("c2c")) && (QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).jdField_a_of_type_Int == 0))
      {
        ChatActivityUtils.a(QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips), (Context)QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).get(), QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).jdField_a_of_type_Int, QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).jdField_a_of_type_JavaLangString, QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).d, null, true, QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).b, true, true, null, "from_internal");
        i = 1;
      }
    }
    for (;;)
    {
      paramView = QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips);
      if (QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).jdField_a_of_type_Int == 0) {}
      for (int j = 1;; j = 2)
      {
        ReportController.b(paramView, "CliOper", "", "", "0X800416C", "0X800416C", 0, 0, String.valueOf(j), String.valueOf(1), String.valueOf(i), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.taskid));
        return;
        if ((!this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url.contains("discussion")) || (QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).jdField_a_of_type_Int != 3000)) {
          break label557;
        }
        ChatActivityUtils.a(QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips), (Context)QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).get(), QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).jdField_a_of_type_Int, QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).jdField_a_of_type_JavaLangString, true, true, null, null);
        i = 1;
        break;
        if (!this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url.startsWith("http")) {
          break label552;
        }
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url;
        paramView = (View)localObject;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if (!((String)localObject).contains("?")) {
            break label489;
          }
          paramView = (TicketManager)QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).getManager(2);
        }
        for (paramView = (String)localObject + "&sid=" + paramView.getSkey(QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).getCurrentAccountUin());; paramView = (String)localObject + "?sid=" + paramView.getSkey(QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).getCurrentAccountUin()))
        {
          localObject = new Intent((Context)QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).get(), QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", paramView);
          ((Intent)localObject).putExtra("hide_left_button", true);
          ((Intent)localObject).putExtra("show_right_close_button", true);
          ((Intent)localObject).putExtra("finish_animation_up_down", true);
          ((Context)QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).get()).startActivity((Intent)localObject);
          i = 2;
          break;
          label489:
          paramView = (TicketManager)QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).getManager(2);
        }
      }
      label552:
      i = 1;
      continue;
      label557:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wdf
 * JD-Core Version:    0.7.0.1
 */