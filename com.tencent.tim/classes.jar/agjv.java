import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.UUID;

class agjv
  implements DialogInterface.OnClickListener
{
  agjv(agjt paramagjt, long paramLong, UUID paramUUID, ChatMessage paramChatMessage, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramDialogInterface = apsf.a(this.a.mApp, this.Hg);
      paramDialogInterface.g(paramDialogInterface.b(this.jdField_b_of_type_JavaUtilUUID));
      this.a.N(this.jdField_b_of_type_ComTencentMobileqqDataChatMessage);
      this.a.mApp.b().cc(this.a.h.aTl, this.a.h.cZ);
      return;
    }
    new apca(this.Hg, this.a.mApp, this.val$activity).a(this.jdField_b_of_type_JavaUtilUUID);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agjv
 * JD-Core Version:    0.7.0.1
 */