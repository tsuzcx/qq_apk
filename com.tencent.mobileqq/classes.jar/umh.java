import android.content.Context;
import android.view.View;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.VideoActionSheet;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.jumplightalk.AIOJumpLightalkConfig;
import com.tencent.mobileqq.jumplightalk.JumpLightalkUtil;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qidian.QidianManager;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public final class umh
  implements ActionSheet.OnButtonClickListener
{
  public umh(VideoActionSheet paramVideoActionSheet, int[] paramArrayOfInt, int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, PstnSessionInfo paramPstnSessionInfo, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUtilsVideoActionSheet.dismiss();
    Object localObject;
    switch (this.jdField_a_of_type_ArrayOfInt[paramInt])
    {
    default: 
    case 4: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          do
          {
            return;
            if ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2))
            {
              ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo, 0);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006406", "0X8006406", 6, 0, "", "", "", "");
              return;
            }
          } while (this.jdField_a_of_type_Int != 5);
          PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 1, 3);
          return;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002))
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005150", "0X8005150", 0, 0, "", "", "", "");
            if (!LBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getString(2131437410));
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005154", "0X8005154", 0, 0, "", "", "", "");
              localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) {}
              for (paramView = "0";; paramView = "1")
              {
                ReportController.b((QQAppInterface)localObject, "dc00899", "grp_lbs", "", "c2c_tmp", "tip_annoy", 0, 0, paramView, "0", "", "");
                return;
              }
            }
          }
          else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010) && (!DatingUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getString(2131437410));
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049C8", "0X80049C8", 0, 0, "", "", "", "");
            return;
          }
          PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, this.jdField_a_of_type_JavaLangString, null);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004861", "0X8004861", 0, 0, "", "", "", "");
        } while (this.jdField_a_of_type_ArrayOfInt[3] != 3);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B03", "0X8005B03", 0, 0, "", "", "", "");
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002))
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005151", "0X8005151", 0, 0, "", "", "", "");
          if (!LBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getString(2131437411));
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005155", "0X8005155", 0, 0, "", "", "", "");
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) {}
            for (paramView = "0";; paramView = "1")
            {
              ReportController.b((QQAppInterface)localObject, "dc00899", "grp_lbs", "", "c2c_tmp", "tip_annoy", 0, 0, paramView, "1", "", "");
              return;
            }
          }
        }
        else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010) && (!DatingUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getString(2131437411));
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049C8", "0X80049C8", 0, 0, "", "", "", "");
          return;
        }
        PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, this.jdField_a_of_type_JavaLangString, null);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004C09", "0X8004C09", 0, 0, "", "", "", "");
      } while (this.jdField_a_of_type_ArrayOfInt[3] != 3);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B04", "0X8005B04", 0, 0, "", "", "", "");
      return;
    case 3: 
      if (JumpLightalkUtil.a(this.jdField_a_of_type_AndroidContentContext))
      {
        paramView = null;
        localObject = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          paramView = ((PhoneContact)localObject).mobileNo;
        }
        JumpLightalkUtil.a(this.jdField_a_of_type_AndroidContentContext, paramView, "10001", "com.tencent.mobileqq", "", "0", "0");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B02", "0X8005B02", 0, 1, "", "", "", "");
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B02", "0X8005B02", 0, 0, "", "", "", "");
        return;
        JumpLightalkUtil.a(this.jdField_a_of_type_AndroidContentContext, ((FriendChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).a().f);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B02", "0X8005B02", 0, 2, "", "", "", "");
      }
    }
    paramView = ((QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(164)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     umh
 * JD-Core Version:    0.7.0.1
 */