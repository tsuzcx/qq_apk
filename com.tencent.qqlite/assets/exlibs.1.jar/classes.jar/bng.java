import android.view.View;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class bng
  implements ActionSheet.OnButtonClickListener
{
  public bng(TroopInfoActivity paramTroopInfoActivity, ActionSheet paramActionSheet) {}
  
  public void a(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.aN != this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.a.r) {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.m();
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
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.a.r = 1;
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.c(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.a.r = 0;
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.a.r != 3)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.a.r = 2;
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.c(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bng
 * JD-Core Version:    0.7.0.1
 */