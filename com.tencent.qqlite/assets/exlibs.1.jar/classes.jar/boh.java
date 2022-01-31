import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ListAdapter;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class boh
  implements ActionSheet.OnButtonClickListener
{
  public boh(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void a(View paramView, int paramInt)
  {
    if (paramInt >= 3) {}
    for (int i = paramInt + 1;; i = paramInt)
    {
      if (this.a.w != i) {}
      switch (i)
      {
      default: 
      case 0: 
      case 1: 
      case 2: 
      case 3: 
      case 4: 
        for (;;)
        {
          if ((this.a.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.a.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
            this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
          }
          return;
          this.a.w = i;
          paramView = this.a.getResources().getStringArray(2131230732);
          this.a.a(this.a.jdField_a_of_type_ComTencentWidgetActionSheet, paramView);
          if ((i != 0) && (i != 3)) {
            break;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(8);
          this.a.a("Clk_def", this.a.p, "");
          if (i == 3) {
            this.a.a("Clk_distance", this.a.p, "");
          }
          label200:
          this.a.j();
          if (!this.a.g)
          {
            this.a.g = true;
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
          }
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
          }
          if (paramInt != 0) {
            break label433;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelectionFromTop(0, 0);
        }
        if (i == 1)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).setText(2131362875);
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).setText(2131362876);
          paramView = "Clk_lastactivetime";
        }
        break;
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(0);
        this.a.a(paramView, "1", this.a.p);
        break label200;
        if (i == 2)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).setText(2131362877);
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).setText(2131362878);
          paramView = "Clk_mberlevel";
        }
        else
        {
          if (i == 4)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).setText(2131362879);
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).setText(2131362880);
            paramView = "Clk_jointime";
            continue;
            label433:
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelectionFromTop(0, -this.a.getResources().getDimensionPixelSize(2131492948));
            break;
            this.a.n();
            break;
            this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new boi(this), 320L);
            break;
            this.a.b = true;
            this.a.q = "";
            this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            TroopMemberListActivity.a(this.a).setVisibility(8);
            if (this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) {
              this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
            }
            paramView = this.a.p;
            this.a.a("Clk_del", paramView, "");
            break;
          }
          paramView = "";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     boh
 * JD-Core Version:    0.7.0.1
 */