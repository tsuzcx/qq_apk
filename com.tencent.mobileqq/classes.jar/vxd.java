import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessHandler;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vxd
  implements ActionSheet.OnButtonClickListener
{
  public vxd(ConfessChatPie paramConfessChatPie, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.a() == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(paramView)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
      for (;;)
      {
        try
        {
          localObject1 = ConfessChatPie.a(paramView, "6bW#X@~L.+X)4%$>");
          if (QLog.isColorLevel()) {
            QLog.i("Q.aio.ConfessChatPie", 2, "openMoreOptions uin:" + paramView + " uinCode:" + (String)localObject1);
          }
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.a();
          localObject2 = new ArrayList();
          if (localObject3 != null)
          {
            localObject3 = ((List)localObject3).iterator();
            if (((Iterator)localObject3).hasNext())
            {
              ((List)localObject2).add((ChatMessage)((Iterator)localObject3).next());
              continue;
            }
          }
          localObject2 = ProfileCardUtil.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 3001, 10, (List)localObject2);
        }
        catch (Throwable paramView)
        {
          QLog.e("Q.aio.ConfessChatPie", 1, "openMoreOptions safetyReport error" + paramView.getMessage());
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80091A4", "0X80091A4", 0, 0, "", "", "", "");
          return;
        }
        Object localObject3 = ((String)localObject2).replaceAll(paramView, (String)localObject1);
        if (QLog.isColorLevel()) {
          QLog.i("Q.aio.ConfessChatPie", 2, "openMoreOptions safetyReport reportMsgOrg: " + (String)localObject2 + "  reportMsg: " + (String)localObject3);
        }
        ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.a(), paramView, (String)localObject1, null, null, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 3001, (String)localObject3);
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.a() == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(paramView)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
    Object localObject1 = (ConfessHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(125);
    Object localObject2 = ((ConfessManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(268)).b();
    if (localObject2 == null) {}
    for (paramInt = 24;; paramInt = ((ConfessConfig)localObject2).i)
    {
      ((ConfessHandler)localObject1).a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo, paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.a(0, "正在屏蔽...", 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vxd
 * JD-Core Version:    0.7.0.1
 */