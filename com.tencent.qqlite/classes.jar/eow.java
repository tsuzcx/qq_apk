import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;

public class eow
  implements DialogInterface.OnClickListener
{
  public eow(TroopFileItemOperation paramTroopFileItemOperation, TroopFileInfo paramTroopFileInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (TroopFileItemOperation.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation) == 0);
    TroopFileTransferManager.a(TroopFileItemOperation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TroopFileItemOperation.jdField_a_of_type_Long).c(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eow
 * JD-Core Version:    0.7.0.1
 */