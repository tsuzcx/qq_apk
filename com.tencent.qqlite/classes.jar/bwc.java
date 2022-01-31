import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PAMultiItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PASingleItemBuilder;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class bwc
  implements View.OnClickListener
{
  public bwc(PAMultiItemBuilder paramPAMultiItemBuilder) {}
  
  public void onClick(View paramView)
  {
    bwd localbwd = (bwd)paramView.getTag();
    paramView = AIOUtils.a(paramView);
    if ((localbwd == null) || (!(paramView instanceof MessageForPubAccount))) {
      if (QLog.isColorLevel()) {
        QLog.d(ChatItemBuilder.a, 2, "PAMultiItemBuilder onClickListener holder = " + localbwd + ", msg = " + paramView);
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
    PAMessage.Item localItem = (PAMessage.Item)localMessageForPubAccount.mPAMessage.items.get(localbwd.jdField_c_of_type_Int);
    if ((PAMultiItemBuilder.a(this.a) instanceof QQAppInterface)) {
      ReportController.b(PAMultiItemBuilder.b(this.a), "P_CliOper", "Pb_account_lifeservice", PAMultiItemBuilder.a(this.a).a, "mp_msg_msgpic_click", "aio_morpic_click", localbwd.jdField_c_of_type_Int + 1, 0, "", "", Long.toString(localMessageForPubAccount.mPAMessage.mMsgId), "");
    }
    label228:
    JumpAction localJumpAction;
    int i;
    if (TextUtils.isEmpty(localItem.a_actionData))
    {
      paramView = localItem.actionData;
      if (TextUtils.isEmpty(paramView)) {
        break label755;
      }
      localJumpAction = JumpParser.a(PAMultiItemBuilder.c(this.a), PAMultiItemBuilder.a(this.a), paramView);
      if (localJumpAction != null) {
        break label535;
      }
      if (localItem.appId != 0L) {
        break label446;
      }
      i = 0;
      label272:
      if (i == 0) {
        break label480;
      }
      if (PASingleItemBuilder.a(PAMultiItemBuilder.d(this.a), PAMultiItemBuilder.b(this.a), localItem.nativeJumpString, localItem.appId, paramView)) {
        break label451;
      }
      PASingleItemBuilder.a(PAMultiItemBuilder.e(this.a), PAMultiItemBuilder.c(this.a), localbwd.a, localbwd.b, localbwd.jdField_c_of_type_JavaLangString, PAMultiItemBuilder.b(this.a).a, PAMultiItemBuilder.c(this.a).d);
      label359:
      PublicAccountHandler.a(PAMultiItemBuilder.m(this.a), PAMultiItemBuilder.m(this.a).a, "Pb_account_lifeservice", "mp_msg_sys_35", "singlepic_allclick");
    }
    for (;;)
    {
      long l = localMessageForPubAccount.mPAMessage.mMsgId;
      if (l <= 0L) {
        break;
      }
      ReportController.b(PAMultiItemBuilder.o(this.a), "P_CliOper", "Pb_account_lifeservice", localMessageForPubAccount.frienduin, "mp_msg_sys_14", "msg_click", 0, 1, 0, Long.toString(l), "", "", "");
      return;
      paramView = localItem.a_actionData;
      break label228;
      label446:
      i = 1;
      break label272;
      label451:
      PublicAccountHandler.a(PAMultiItemBuilder.f(this.a), PAMultiItemBuilder.d(this.a).a, "Pb_account_lifeservice", "mp_msg_sys_37", "singlepic_appclick");
      break label359;
      label480:
      PASingleItemBuilder.a(PAMultiItemBuilder.g(this.a), PAMultiItemBuilder.d(this.a), localbwd.a, localbwd.b, localbwd.jdField_c_of_type_JavaLangString, PAMultiItemBuilder.e(this.a).a, PAMultiItemBuilder.f(this.a).d);
      break label359;
      label535:
      if (TextUtils.isEmpty(localJumpAction.a()))
      {
        if (!PASingleItemBuilder.a(PAMultiItemBuilder.h(this.a), PAMultiItemBuilder.e(this.a), localItem.nativeJumpString, localItem.appId, paramView))
        {
          PASingleItemBuilder.a(PAMultiItemBuilder.i(this.a), PAMultiItemBuilder.f(this.a), localbwd.a, localbwd.b, localbwd.jdField_c_of_type_JavaLangString, PAMultiItemBuilder.g(this.a).a, PAMultiItemBuilder.h(this.a).d);
          break label359;
        }
        PublicAccountHandler.a(PAMultiItemBuilder.j(this.a), PAMultiItemBuilder.i(this.a).a, "Pb_account_lifeservice", "mp_msg_sys_37", "singlepic_appclick");
        break label359;
      }
      if (!localJumpAction.b())
      {
        PASingleItemBuilder.a(PAMultiItemBuilder.k(this.a), PAMultiItemBuilder.g(this.a), localbwd.a, localbwd.b, localbwd.jdField_c_of_type_JavaLangString, PAMultiItemBuilder.j(this.a).a, PAMultiItemBuilder.k(this.a).d);
        break label359;
      }
      PublicAccountHandler.a(PAMultiItemBuilder.l(this.a), PAMultiItemBuilder.l(this.a).a, "Pb_account_lifeservice", "mp_msg_sys_36", "singlepic_mqqclick");
      break label359;
      label755:
      PASingleItemBuilder.a(PAMultiItemBuilder.n(this.a), PAMultiItemBuilder.h(this.a), localbwd.a, localbwd.b, localbwd.jdField_c_of_type_JavaLangString, PAMultiItemBuilder.n(this.a).a, PAMultiItemBuilder.o(this.a).d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bwc
 * JD-Core Version:    0.7.0.1
 */