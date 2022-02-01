import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.widget.QQToast;

class xmh
  implements DialogInterface.OnClickListener
{
  xmh(xmb paramxmb, MessageForReplyText paramMessageForReplyText) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_Xmb.sessionInfo.cZ == 1) && (((apsw)this.jdField_a_of_type_Xmb.app.getManager(48)).a(this.jdField_a_of_type_Xmb.sessionInfo.aTl, true).cSk) && ((this.jdField_a_of_type_Xmb.mContext instanceof BaseActivity)))
    {
      paramDialogInterface = (BaseActivity)this.jdField_a_of_type_Xmb.mContext;
      QQToast.a(this.jdField_a_of_type_Xmb.app.getApp(), 2131699615, 0).show(paramDialogInterface.getTitleBarHeight());
      return;
    }
    this.jdField_a_of_type_Xmb.app.b().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xmh
 * JD-Core Version:    0.7.0.1
 */