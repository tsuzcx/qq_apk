import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.activity.contact.newfriend.BaseNewFriendView.INewFriendContext;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class eeg
  implements ActionSheet.OnButtonClickListener
{
  public eeg(NewFriendActivity paramNewFriendActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (!NewFriendActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity))
      {
        paramView = new eeh(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity.b.a(paramView);
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity.a == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity.a = ((CircleManager)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity.b.getManager(33));
        }
        boolean bool;
        label127:
        QQAppInterface localQQAppInterface;
        if (NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity))
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity.a;
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity.c)
          {
            bool = true;
            paramView.a(bool, true);
            label133:
            localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity.b;
            if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity.c) {
              break label236;
            }
          }
        }
        label236:
        for (paramView = "0";; paramView = "1")
        {
          ReportController.b(localQQAppInterface, "CliOper", "", "", "Network_circle", "Network_circle_setting", 59, 0, paramView, "", "", "");
          break;
          bool = false;
          break label127;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity.isFinishing()) || (NewFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity) == null)) {
            break label133;
          }
          NewFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity).a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity.getResources().getString(2131562449), 1);
          break label133;
        }
        paramView = new eei(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity.b.a(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eeg
 * JD-Core Version:    0.7.0.1
 */