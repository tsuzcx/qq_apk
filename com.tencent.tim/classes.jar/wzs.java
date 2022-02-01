import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;

class wzs
  implements DialogInterface.OnClickListener
{
  wzs(wzr paramwzr, MessageForArkApp paramMessageForArkApp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (MessageForArkApp)anbi.e(this.c);
    if (paramDialogInterface.msgData == null) {
      if (paramDialogInterface.ark_app_message == null) {
        ArkAppCenter.r("ArkApp", String.format("resendMessage, msgData and ark_app_message are null", new Object[0]));
      }
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramDialogInterface.msgData = paramDialogInterface.ark_app_message.toBytes();
          } while (this.a.sessionInfo == null);
          if ((paramDialogInterface.ark_app_message.containStructMsg == null) && (this.c.ark_app_message.containStructMsg != null)) {
            paramDialogInterface.ark_app_message.containStructMsg = this.c.ark_app_message.containStructMsg;
          }
          paramInt = paramDialogInterface.getProcessState();
          if (QLog.isColorLevel()) {
            QLog.d("ArkAppShareMultiItemBuilder", 2, new Object[] { "AAShare.get multiItem resend msg stat=", Integer.valueOf(paramInt), ", old.uniseq=", Long.valueOf(this.c.uniseq), ", new uniseq=", Long.valueOf(paramDialogInterface.uniseq) });
          }
          this.a.app.b().t(this.a.sessionInfo.aTl, this.a.sessionInfo.cZ, this.c.uniseq);
          if ((paramInt == 1002) || (paramInt == 0)) {
            break;
          }
          localObject = BaseApplicationImpl.getApplication().getRuntime();
        } while (!(localObject instanceof QQAppInterface));
        localObject = (ArkAppCenter)((QQAppInterface)localObject).getManager(121);
      } while (localObject == null);
      localObject = ((ArkAppCenter)localObject).a();
    } while (localObject == null);
    ((adtu)localObject).d(paramDialogInterface);
    return;
    this.a.app.b().a(paramDialogInterface, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wzs
 * JD-Core Version:    0.7.0.1
 */