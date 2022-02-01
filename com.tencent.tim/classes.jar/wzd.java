import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;

class wzd
  implements DialogInterface.OnClickListener
{
  wzd(wzb paramwzb, MessageForArkApp paramMessageForArkApp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (ahjz.a(this.c, this.a.mContext)) {}
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
            paramDialogInterface = (MessageForArkApp)anbi.e(this.c);
            if (paramDialogInterface.msgData == null)
            {
              if (paramDialogInterface.ark_app_message == null)
              {
                ArkAppCenter.r("ArkApp", String.format("resendMessage, msgData and ark_app_message are null", new Object[0]));
                return;
              }
              paramDialogInterface.msgData = paramDialogInterface.ark_app_message.toBytes();
            }
          } while (this.a.sessionInfo == null);
          paramInt = paramDialogInterface.getProcessState();
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
 * Qualified Name:     wzd
 * JD-Core Version:    0.7.0.1
 */