import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;

public class eov
  implements DialogInterface.OnClickListener
{
  public eov(TroopFileItemOperation paramTroopFileItemOperation, TroopFileInfo paramTroopFileInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    }
    TroopFileTransferManager.a(TroopFileItemOperation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TroopFileItemOperation.jdField_a_of_type_Long).a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.a);
    ReportController.b(TroopFileItemOperation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Cancel_pause_download", 0, 0, "", TroopFileItemOperation.jdField_a_of_type_Long + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eov
 * JD-Core Version:    0.7.0.1
 */