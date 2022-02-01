import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.UUID;

class xpy
  implements DialogInterface.OnClickListener
{
  xpy(xpw paramxpw, long paramLong, UUID paramUUID, ChatMessage paramChatMessage, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramDialogInterface = apsf.a(this.this$0.app, this.Hg);
      paramDialogInterface.g(paramDialogInterface.b(this.jdField_b_of_type_JavaUtilUUID));
      this.this$0.J(this.jdField_b_of_type_ComTencentMobileqqDataChatMessage);
      this.this$0.app.b().cc(this.this$0.sessionInfo.aTl, this.this$0.sessionInfo.cZ);
      return;
    }
    new apca(this.Hg, this.this$0.app, this.val$activity).a(this.jdField_b_of_type_JavaUtilUUID);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xpy
 * JD-Core Version:    0.7.0.1
 */