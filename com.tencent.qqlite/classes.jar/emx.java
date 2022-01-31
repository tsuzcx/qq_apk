import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.UUID;

public class emx
  implements DialogInterface.OnClickListener
{
  public emx(TroopFileItemOperation paramTroopFileItemOperation, TroopFileTransferManager paramTroopFileTransferManager, UUID paramUUID) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.c(this.jdField_a_of_type_JavaUtilUUID);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     emx
 * JD-Core Version:    0.7.0.1
 */