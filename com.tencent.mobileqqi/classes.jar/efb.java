import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PASingleItemBuilder;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;

public class efb
  implements View.OnClickListener
{
  public efb(PASingleItemBuilder paramPASingleItemBuilder) {}
  
  public void onClick(View paramView)
  {
    efc localefc = (efc)AIOUtils.a(paramView);
    JumpAction localJumpAction;
    int i;
    if (TextUtils.isEmpty(localefc.f))
    {
      paramView = localefc.e;
      if (TextUtils.isEmpty(paramView)) {
        break label556;
      }
      localJumpAction = JumpParser.a(PASingleItemBuilder.a(this.a), PASingleItemBuilder.a(this.a), paramView);
      if (localJumpAction != null) {
        break label346;
      }
      if (localefc.jdField_a_of_type_Long != 0L) {
        break label260;
      }
      i = 0;
      label66:
      if (i == 0) {
        break label294;
      }
      if (PASingleItemBuilder.a(PASingleItemBuilder.b(this.a), PASingleItemBuilder.b(this.a), localefc.jdField_a_of_type_JavaLangString, localefc.jdField_a_of_type_Long, paramView)) {
        break label265;
      }
      PASingleItemBuilder.a(PASingleItemBuilder.c(this.a), PASingleItemBuilder.c(this.a), localefc.jdField_a_of_type_JavaLangString, localefc.b, localefc.c, PASingleItemBuilder.a(this.a).jdField_a_of_type_JavaLangString, PASingleItemBuilder.b(this.a).d);
    }
    for (;;)
    {
      PublicAccountHandler.a(PASingleItemBuilder.k(this.a), PASingleItemBuilder.l(this.a).jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_32", "singlepic_allclick");
      paramView = localefc.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((paramView instanceof MessageForPubAccount))
      {
        paramView = (MessageForPubAccount)paramView;
        if ((paramView.mPAMessage != null) && (paramView.mPAMessage.mMsgId > 0L)) {
          ReportController.b(PASingleItemBuilder.m(this.a), "P_CliOper", "Pb_account_lifeservice", paramView.frienduin, "mp_msg_sys_14", "msg_click", 0, 1, 0, Long.toString(paramView.mPAMessage.mMsgId), "", "", "");
        }
      }
      return;
      paramView = localefc.f;
      break;
      label260:
      i = 1;
      break label66;
      label265:
      PublicAccountHandler.a(PASingleItemBuilder.d(this.a), PASingleItemBuilder.c(this.a).jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_34", "singlepic_appclick");
      continue;
      label294:
      PASingleItemBuilder.a(PASingleItemBuilder.e(this.a), PASingleItemBuilder.d(this.a), localefc.jdField_a_of_type_JavaLangString, localefc.b, localefc.c, PASingleItemBuilder.d(this.a).jdField_a_of_type_JavaLangString, PASingleItemBuilder.e(this.a).d);
      continue;
      label346:
      if (TextUtils.isEmpty(localJumpAction.a()))
      {
        if (!PASingleItemBuilder.a(PASingleItemBuilder.f(this.a), PASingleItemBuilder.e(this.a), localefc.jdField_a_of_type_JavaLangString, localefc.jdField_a_of_type_Long, paramView)) {
          PASingleItemBuilder.a(PASingleItemBuilder.g(this.a), PASingleItemBuilder.f(this.a), localefc.jdField_a_of_type_JavaLangString, localefc.b, localefc.c, PASingleItemBuilder.f(this.a).jdField_a_of_type_JavaLangString, PASingleItemBuilder.g(this.a).d);
        } else {
          PublicAccountHandler.a(PASingleItemBuilder.h(this.a), PASingleItemBuilder.h(this.a).jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_34", "singlepic_appclick");
        }
      }
      else if (!localJumpAction.b()) {
        PASingleItemBuilder.a(PASingleItemBuilder.i(this.a), PASingleItemBuilder.g(this.a), localefc.jdField_a_of_type_JavaLangString, localefc.b, localefc.c, PASingleItemBuilder.i(this.a).jdField_a_of_type_JavaLangString, PASingleItemBuilder.j(this.a).d);
      } else {
        PublicAccountHandler.a(PASingleItemBuilder.j(this.a), PASingleItemBuilder.k(this.a).jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_33", "singlepic_mqqclick");
      }
    }
    label556:
    PASingleItemBuilder.a(PASingleItemBuilder.l(this.a), PASingleItemBuilder.h(this.a), localefc.jdField_a_of_type_JavaLangString, localefc.b, localefc.c, PASingleItemBuilder.m(this.a).jdField_a_of_type_JavaLangString, PASingleItemBuilder.n(this.a).d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     efb
 * JD-Core Version:    0.7.0.1
 */