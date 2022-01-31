import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ListAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class uax
  implements ActionSheet.OnButtonClickListener
{
  public uax(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((!TroopMemberListActivity.c(this.a)) && (paramInt >= 5)) {}
    for (int i = paramInt + 1;; i = paramInt)
    {
      if (this.a.e) {
        if (paramInt == 0) {
          this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new uay(this), 320L);
        }
      }
      for (;;)
      {
        if ((this.a.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.a.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
          this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        }
        return;
        if (QLog.isColorLevel())
        {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "mOnActionSheetClickListener.OnClick, error : which = " + paramInt + ", troopUin = " + this.a.jdField_b_of_type_JavaLangString);
          continue;
          if (this.a.jdField_d_of_type_Int == 9) {
            switch (i)
            {
            default: 
              break;
            case 0: 
              this.a.c = true;
              this.a.t = "";
              this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
              this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
              this.a.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
              if (this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) {
                this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
              }
              ReportController.b(this.a.app, "P_CliOper", "Grp_pay", "", "un_pay_list", "Clk_del", 0, 0, this.a.jdField_b_of_type_JavaLangString, this.a.n, "", "");
              break;
            }
          } else {
            switch (i)
            {
            default: 
              break;
            case 0: 
              this.a.l();
              break;
            case 1: 
              this.a.o = String.format(this.a.o, new Object[] { this.a.jdField_b_of_type_JavaLangString });
              paramView = new Intent(this.a, QQBrowserActivity.class);
              paramView.putExtra("uin", this.a.app.getCurrentAccountUin());
              paramView.putExtra("url", this.a.o);
              this.a.startActivity(paramView);
              break;
            case 2: 
              this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new uaz(this), 320L);
              break;
            case 3: 
              this.a.jdField_d_of_type_Boolean = true;
              this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
              TroopMemberListActivity.a(this.a);
              this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
              this.a.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
              this.a.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
              this.a.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.a.findViewById(2131363473));
              this.a.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
              this.a.jdField_d_of_type_AndroidWidgetTextView.setText("取消");
              this.a.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new uba(this));
              if (this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) {
                this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
              }
              paramView = this.a.n;
              this.a.a("Clk_del", paramView, "");
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uax
 * JD-Core Version:    0.7.0.1
 */