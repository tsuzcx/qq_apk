import Wallet.GoldMsgSetReq;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.QWalletCommonServlet;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormEditItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import mqq.manager.TicketManager;

public class uje
  implements DialogInterface.OnClickListener
{
  public uje(PlusPanel paramPlusPanel, Context paramContext, String paramString1, long paramLong, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject1 = (QQCustomDialog)paramDialogInterface;
    long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    String str = "";
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    TicketManager localTicketManager = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    if (localTicketManager != null) {
      str = localTicketManager.getSkey((String)localObject2);
    }
    boolean bool = ((FormSwitchItem)((QQCustomDialog)localObject1).findViewById(2131364060)).a().isChecked();
    if (bool) {}
    for (paramInt = 1; !bool; paramInt = 0)
    {
      QWalletCommonServlet.a(new GoldMsgSetReq(l1, paramInt, 1L, str), null);
      return;
    }
    localObject2 = (FormEditItem)((QQCustomDialog)localObject1).findViewById(2131364061);
    localObject1 = ((FormEditItem)localObject2).a().toString();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = ((FormEditItem)localObject2).a().getHint() + "";
    }
    for (;;)
    {
      long l2;
      try
      {
        l2 = (Double.valueOf((String)localObject1).doubleValue() * 100.0D);
        if (l2 < 1L)
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, 0).a();
          return;
        }
      }
      catch (NumberFormatException paramDialogInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("View", 2, "invalid value:", paramDialogInterface);
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131432271, 0).a();
        return;
      }
      if (l2 > this.jdField_a_of_type_Long)
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.b, 0).a();
        return;
      }
      QWalletCommonServlet.a(new GoldMsgSetReq(l1, paramInt, l2, str), null);
      paramDialogInterface.dismiss();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uje
 * JD-Core Version:    0.7.0.1
 */