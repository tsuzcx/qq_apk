import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PAMultiItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PASingleItemBuilder;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class dzx
  implements View.OnClickListener
{
  public dzx(PAMultiItemBuilder paramPAMultiItemBuilder) {}
  
  public void onClick(View paramView)
  {
    dzy localdzy = (dzy)paramView.getTag();
    paramView = AIOUtils.a(paramView);
    if ((localdzy == null) || (!(paramView instanceof MessageForPubAccount))) {
      if (QLog.isColorLevel()) {
        QLog.d(ChatItemBuilder.a, 2, "PAMultiItemBuilder onClickListener holder = " + localdzy + ", msg = " + paramView);
      }
    }
    MessageForPubAccount localMessageForPubAccount;
    do
    {
      return;
      localMessageForPubAccount = (MessageForPubAccount)paramView;
      if ((localMessageForPubAccount.mPAMessage != null) && (localMessageForPubAccount.mPAMessage.items != null) && (!localMessageForPubAccount.mPAMessage.items.isEmpty())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(ChatItemBuilder.a, 2, "PAMultiItemBuilder onClickListener mPAMessage or items is empty !");
    return;
    PAMessage.Item localItem = (PAMessage.Item)localMessageForPubAccount.mPAMessage.items.get(localdzy.jdField_c_of_type_Int);
    label162:
    JumpAction localJumpAction;
    int i;
    if (TextUtils.isEmpty(localItem.a_actionData))
    {
      paramView = localItem.actionData;
      if (TextUtils.isEmpty(paramView)) {
        break label689;
      }
      localJumpAction = JumpParser.a(PAMultiItemBuilder.a(this.a), PAMultiItemBuilder.a(this.a), paramView);
      if (localJumpAction != null) {
        break label469;
      }
      if (localItem.appId != 0L) {
        break label380;
      }
      i = 0;
      label206:
      if (i == 0) {
        break label414;
      }
      if (PASingleItemBuilder.a(PAMultiItemBuilder.b(this.a), PAMultiItemBuilder.b(this.a), localItem.nativeJumpString, localItem.appId, paramView)) {
        break label385;
      }
      PASingleItemBuilder.a(PAMultiItemBuilder.c(this.a), PAMultiItemBuilder.c(this.a), localdzy.a, localdzy.b, localdzy.jdField_c_of_type_JavaLangString, PAMultiItemBuilder.a(this.a).a, PAMultiItemBuilder.b(this.a).d);
      label293:
      PublicAccountHandler.a(PAMultiItemBuilder.k(this.a), PAMultiItemBuilder.l(this.a).a, "Pb_account_lifeservice", "mp_msg_sys_35", "singlepic_allclick");
    }
    for (;;)
    {
      long l = localMessageForPubAccount.mPAMessage.mMsgId;
      if (l <= 0L) {
        break;
      }
      ReportController.b(PAMultiItemBuilder.m(this.a), "P_CliOper", "Pb_account_lifeservice", localMessageForPubAccount.frienduin, "mp_msg_sys_14", "msg_click", 0, 1, 0, Long.toString(l), "", "", "");
      return;
      paramView = localItem.a_actionData;
      break label162;
      label380:
      i = 1;
      break label206;
      label385:
      PublicAccountHandler.a(PAMultiItemBuilder.d(this.a), PAMultiItemBuilder.c(this.a).a, "Pb_account_lifeservice", "mp_msg_sys_37", "singlepic_appclick");
      break label293;
      label414:
      PASingleItemBuilder.a(PAMultiItemBuilder.e(this.a), PAMultiItemBuilder.d(this.a), localdzy.a, localdzy.b, localdzy.jdField_c_of_type_JavaLangString, PAMultiItemBuilder.d(this.a).a, PAMultiItemBuilder.e(this.a).d);
      break label293;
      label469:
      if (TextUtils.isEmpty(localJumpAction.a()))
      {
        if (!PASingleItemBuilder.a(PAMultiItemBuilder.f(this.a), PAMultiItemBuilder.e(this.a), localItem.nativeJumpString, localItem.appId, paramView))
        {
          PASingleItemBuilder.a(PAMultiItemBuilder.g(this.a), PAMultiItemBuilder.f(this.a), localdzy.a, localdzy.b, localdzy.jdField_c_of_type_JavaLangString, PAMultiItemBuilder.f(this.a).a, PAMultiItemBuilder.g(this.a).d);
          break label293;
        }
        PublicAccountHandler.a(PAMultiItemBuilder.h(this.a), PAMultiItemBuilder.h(this.a).a, "Pb_account_lifeservice", "mp_msg_sys_37", "singlepic_appclick");
        break label293;
      }
      if (!localJumpAction.b())
      {
        PASingleItemBuilder.a(PAMultiItemBuilder.i(this.a), PAMultiItemBuilder.g(this.a), localdzy.a, localdzy.b, localdzy.jdField_c_of_type_JavaLangString, PAMultiItemBuilder.i(this.a).a, PAMultiItemBuilder.j(this.a).d);
        break label293;
      }
      PublicAccountHandler.a(PAMultiItemBuilder.j(this.a), PAMultiItemBuilder.k(this.a).a, "Pb_account_lifeservice", "mp_msg_sys_36", "singlepic_mqqclick");
      break label293;
      label689:
      PASingleItemBuilder.a(PAMultiItemBuilder.l(this.a), PAMultiItemBuilder.h(this.a), localdzy.a, localdzy.b, localdzy.jdField_c_of_type_JavaLangString, PAMultiItemBuilder.m(this.a).a, PAMultiItemBuilder.n(this.a).d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dzx
 * JD-Core Version:    0.7.0.1
 */