import android.view.View;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class dpw
  implements ActionSheet.OnButtonClickListener
{
  public dpw(TroopInfoActivity paramTroopInfoActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.af != this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.a.q) {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.p();
      }
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.c(1);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.a.q = 1;
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.c(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.a.q = 0;
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.a.q != 3)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.a.q = 2;
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.c(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dpw
 * JD-Core Version:    0.7.0.1
 */