import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.UUID;

public class gvy
  implements DialogInterface.OnClickListener
{
  public gvy(TroopFileItemOperation paramTroopFileItemOperation, TroopFileTransferManager paramTroopFileTransferManager, UUID paramUUID) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.c(this.jdField_a_of_type_JavaUtilUUID);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gvy
 * JD-Core Version:    0.7.0.1
 */