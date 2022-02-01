import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.UUID;

public class ebh
  implements DialogInterface.OnClickListener
{
  public ebh(TroopFileItemBuilder paramTroopFileItemBuilder, long paramLong, UUID paramUUID, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      TroopFileTransferManager.a(TroopFileItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileItemBuilder), this.jdField_a_of_type_Long).a(this.jdField_a_of_type_JavaUtilUUID);
      return;
    }
    new TroopFileItemOperation(this.jdField_a_of_type_Long, TroopFileItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileItemBuilder), this.jdField_a_of_type_AndroidAppActivity).b(this.jdField_a_of_type_JavaUtilUUID);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ebh
 * JD-Core Version:    0.7.0.1
 */