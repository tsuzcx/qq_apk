import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.VideoItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.TroopGagInfo;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.widget.QQToast;

public class vii
  implements View.OnClickListener
{
  public vii(VideoItemBuilder paramVideoItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (!VideoItemBuilder.a(this.a)) {}
    do
    {
      do
      {
        return;
        AIOUtils.m = true;
      } while ((!VcSystemInfo.c()) || (!VcSystemInfo.d()));
      paramView = (ChatItemBuilder.BaseHolder)AIOUtils.a(paramView);
    } while (paramView == null);
    paramView = (MessageForVideo)paramView.a;
    int i = paramView.istroop;
    boolean bool2;
    if (paramView.type == 13)
    {
      bool2 = true;
      if (i == 3000) {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Multi_call", "Multi_call_disobj", 0, 0, "", "", "", "");
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      for (;;)
      {
        if ((paramView.type == 2) || (paramView.type == 24)) {
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004009", "", 0, 0, "1", "", "", "");
        }
        if (paramView.type == 0) {
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800400A", "", 0, 0, "1", "", "", "");
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (paramView.extInt != 10)) {
          try
          {
            l = Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            i = UITools.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            l = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i, l);
            Object localObject = (TroopGagMgr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47);
            bool1 = ((TroopGagMgr)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            bool2 = ((TroopGagMgr)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            boolean bool3 = ((TroopGagMgr)localObject).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            localObject = ((TroopGagMgr)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            if ((l == 0L) && (((!bool3) && (bool1)) || ((!bool2) && (localObject != null) && (((TroopGagMgr.TroopGagInfo)localObject).a > 0L))))
            {
              QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, "禁言中，无法开启视频", 0).b(this.a.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
              return;
              bool1 = bool2;
              if (i != 1) {
                continue;
              }
              Long.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
              if (paramView.extInt == 10)
              {
                ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005924", "0X8005924", 0, 0, "", "", "", "");
                bool1 = bool2;
                continue;
              }
              ReportController.b(null, "dc00899", "Grp_video", "", "notice", "video", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "" + TroopUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "0", "");
              bool1 = bool2;
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            for (;;)
            {
              long l = 0L;
            }
            VideoItemBuilder.a(this.a, true, paramView);
            return;
          }
        }
      }
      VideoItemBuilder.a(this.a, paramView, bool1, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vii
 * JD-Core Version:    0.7.0.1
 */