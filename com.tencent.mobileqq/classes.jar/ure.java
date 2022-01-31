import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.TroopMemberLbs.TroopMemberLbsHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class ure
  implements ActionSheet.OnButtonClickListener
{
  public ure(PlusPanel paramPlusPanel, boolean paramBoolean, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
        PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
        }
      }
    }
    if (!NetworkUtil.d(BaseApplicationImpl.getContext()))
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2131433023, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131558448));
      return;
    }
    paramView = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).d(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      TroopMemberLbsHelper.a(paramView, bool, this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.getContext());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ure
 * JD-Core Version:    0.7.0.1
 */