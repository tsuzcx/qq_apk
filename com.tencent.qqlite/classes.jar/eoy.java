import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class eoy
  implements ActionSheet.OnButtonClickListener
{
  public eoy(TroopFileItemOperation paramTroopFileItemOperation, boolean paramBoolean, TroopFileInfo paramTroopFileInfo, ActionSheet paramActionSheet) {}
  
  public void a(View paramView, int paramInt)
  {
    int i = paramInt;
    if (!this.jdField_a_of_type_Boolean) {
      i = paramInt + 1;
    }
    switch (i)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      TroopFileTransferManager.a(TroopFileItemOperation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TroopFileItemOperation.jdField_a_of_type_Long).a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.a);
      ReportController.b(TroopFileItemOperation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Clk_delete_local", 0, 0, "", TroopFileItemOperation.jdField_a_of_type_Long + "", "", "");
      continue;
      if (TroopFileItemOperation.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation) != 0)
      {
        TroopFileManager.a(TroopFileItemOperation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TroopFileItemOperation.jdField_a_of_type_Long).a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo);
        ReportController.b(TroopFileItemOperation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Clk_delete_share", 0, 0, "", TroopFileItemOperation.jdField_a_of_type_Long + "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eoy
 * JD-Core Version:    0.7.0.1
 */