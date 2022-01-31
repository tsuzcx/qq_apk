import android.view.View;
import com.tencent.mobileqq.activity.TroopPrivilegeActivity;
import com.tencent.mobileqq.activity.TroopPrivilegeActivity.PrivilegeAdapter;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class bpj
  implements ActionSheet.OnButtonClickListener
{
  public bpj(TroopPrivilegeActivity paramTroopPrivilegeActivity, ActionSheet paramActionSheet) {}
  
  public void a(View paramView, int paramInt)
  {
    Object localObject1;
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity.jdField_a_of_type_JavaLangObject instanceof bpk)))
    {
      localObject1 = (bpk)this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity.jdField_a_of_type_JavaLangObject;
      if (((bpk)localObject1).jdField_a_of_type_Int - 1 == paramInt) {
        return;
      }
      paramView = (BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity.app.a(19);
      if (((bpk)localObject1).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity.getString(2131362361)))
      {
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity.jdField_a_of_type_JavaLangString;
        if (paramInt != 0) {
          break label349;
        }
        bool = true;
        paramView.a((String)localObject2, true, bool, false, false);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity$PrivilegeAdapter;
        String str = this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity.getString(2131362361);
        if (paramInt != 0) {
          break label355;
        }
        i = 1;
        label136:
        ((TroopPrivilegeActivity.PrivilegeAdapter)localObject2).a(str, i);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity$PrivilegeAdapter.notifyDataSetChanged();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity.app, "P_CliOper", "Grp_manage", "", "set", "modify_file", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity.jdField_a_of_type_JavaLangString, String.format("%d", new Object[] { Integer.valueOf(paramInt) }), "", "");
      }
      if (((bpk)localObject1).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity.getString(2131362360)))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity.jdField_a_of_type_JavaLangString;
        if (paramInt != 0) {
          break label360;
        }
        bool = true;
        label239:
        paramView.a((String)localObject1, false, false, true, bool);
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity$PrivilegeAdapter;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity.getString(2131362360);
        if (paramInt != 0) {
          break label366;
        }
      }
    }
    label349:
    label355:
    label360:
    label366:
    for (int i = 1;; i = 2)
    {
      paramView.a((String)localObject1, i);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity$PrivilegeAdapter.notifyDataSetChanged();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity.app, "P_CliOper", "Grp_manage", "", "set", "modify_photo", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity.jdField_a_of_type_JavaLangString, String.format("%d", new Object[] { Integer.valueOf(paramInt) }), "", "");
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      bool = false;
      break;
      i = 2;
      break label136;
      bool = false;
      break label239;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bpj
 * JD-Core Version:    0.7.0.1
 */