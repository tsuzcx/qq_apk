import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import java.util.UUID;

public class ebi
  implements DialogInterface.OnClickListener
{
  public ebi(TroopFileItemBuilder paramTroopFileItemBuilder, long paramLong, UUID paramUUID, ChatMessage paramChatMessage, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramDialogInterface = TroopFileManager.a(TroopFileItemBuilder.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileItemBuilder), this.jdField_a_of_type_Long);
      paramDialogInterface.a(paramDialogInterface.a(this.jdField_a_of_type_JavaUtilUUID));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      TroopFileItemBuilder.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileItemBuilder).a().e(TroopFileItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileItemBuilder).jdField_a_of_type_JavaLangString, TroopFileItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileItemBuilder).jdField_a_of_type_Int);
      return;
    }
    new TroopFileItemOperation(this.jdField_a_of_type_Long, TroopFileItemBuilder.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileItemBuilder), this.jdField_a_of_type_AndroidAppActivity).a(this.jdField_a_of_type_JavaUtilUUID);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ebi
 * JD-Core Version:    0.7.0.1
 */