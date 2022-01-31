import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.OpenTroopChatLogic;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class bzy
  extends MessageObserver
{
  private OpenTroopChatLogic jdField_a_of_type_ComTencentMobileqqActivityOpenTroopChatLogic = null;
  
  public bzy(TroopChatPie paramTroopChatPie) {}
  
  protected void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString == null) || (!paramString.equals(TroopChatPie.T(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie).jdField_a_of_type_JavaLangString)) || (paramInt1 != TroopChatPie.U(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie).jdField_a_of_type_Int)) {}
    while (paramInt1 != 1) {
      return;
    }
    switch (paramInt2)
    {
    default: 
      return;
    case 1: 
    case 2: 
      QQToast.a(TroopChatPie.y(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie), 2131362812, 1).b(TroopChatPie.x(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie).getTitleBarHeight());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.t();
      return;
      QQToast.a(TroopChatPie.A(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie), 2131362811, 1).b(TroopChatPie.z(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie).getTitleBarHeight());
    }
  }
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(TroopChatPie.Q(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie).jdField_a_of_type_JavaLangString)) || (paramInt1 != TroopChatPie.R(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie).jdField_a_of_type_Int))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopChatPie", 2, "onUpdateSendMsgError exception uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopChatPie", 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
    }
    if ((paramInt1 == 1) || (paramInt1 == 3000) || (paramInt1 == 0))
    {
      paramSendMessageHandler = TroopChatPie.p(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie).a().a(paramString1, paramInt1, paramLong2);
      if ((paramSendMessageHandler != null) && ((paramSendMessageHandler instanceof MessageForStructing)) && ("viewMultiMsg".equals(((MessageForStructing)paramSendMessageHandler).structingMsg.mMsgAction))) {
        MultiMsgManager.a().a(TroopChatPie.q(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie), paramString1, paramInt1, paramLong2, false);
      }
    }
    if (paramInt1 == 1)
    {
      if (!((FriendManager)TroopChatPie.r(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie).getManager(8)).f(paramString1)) {
        break label433;
      }
      if (paramInt2 != 108) {
        break label349;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityOpenTroopChatLogic == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityOpenTroopChatLogic = new OpenTroopChatLogic(TroopChatPie.S(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie), TroopChatPie.i(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie));
      }
      paramString1 = (ChatMessage)TroopChatPie.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie).getItem(TroopChatPie.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie).getCount() - 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityOpenTroopChatLogic.a(paramString1);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityOpenTroopChatLogic.a()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityOpenTroopChatLogic.a();
      }
    }
    label433:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a(196608);
      return;
      label349:
      if (paramInt2 == 102)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.t();
        QQToast.a(TroopChatPie.k(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie).getApplicationContext(), 2131362813, 1).b(TroopChatPie.j(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie).getTitleBarHeight());
      }
      else if (paramString2.length() > 0)
      {
        QQToast.a(TroopChatPie.m(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie), paramString2, 1).b(TroopChatPie.l(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie).getTitleBarHeight());
        continue;
        switch (paramInt2)
        {
        default: 
          break;
        case 1: 
        case 2: 
        case 101: 
        case 102: 
          QQToast.a(TroopChatPie.o(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie), 2131362812, 1).b(TroopChatPie.n(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie).getTitleBarHeight());
          break;
        case 3: 
        case 103: 
          QQToast.a(TroopChatPie.q(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie), 2131362811, 1).b(TroopChatPie.p(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie).getTitleBarHeight());
          break;
        case 130: 
          paramString1 = paramString2;
          if (TextUtils.isEmpty(paramString2)) {
            paramString1 = TroopChatPie.r(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie).getResources().getString(2131362620);
          }
          QQToast.a(TroopChatPie.t(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie), paramString1, 1).b(TroopChatPie.s(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie).getTitleBarHeight());
          break;
        case 131: 
          paramString1 = paramString2;
          if (TextUtils.isEmpty(paramString2)) {
            paramString1 = TroopChatPie.u(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie).getResources().getString(2131362621);
          }
          QQToast.a(TroopChatPie.w(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie), paramString1, 1).b(TroopChatPie.v(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie).getTitleBarHeight());
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1;
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopChatPie", 2, "onGetSystemMsgFin.success");
      }
      List localList = TroopChatPie.o(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie).a().a(AppConstants.ae, 0);
      Object localObject2 = null;
      localObject1 = localObject2;
      if (localList != null)
      {
        localObject1 = localObject2;
        if (localList.size() - 1 >= 0) {
          localObject1 = (MessageRecord)localList.get(localList.size() - 1);
        }
      }
      if ((localObject1 != null) && ((localObject1 instanceof MessageForSystemMsg))) {
        break label101;
      }
    }
    label101:
    long l;
    do
    {
      int i;
      do
      {
        do
        {
          return;
          localObject1 = ((MessageForSystemMsg)localObject1).getSystemMsg();
        } while ((((structmsg.StructMsg)localObject1).msg_type.get() != 2) || (((structmsg.StructMsg)localObject1).msg.get() == null));
        i = ((structmsg.StructMsg)localObject1).msg.group_msg_type.get();
      } while ((i != 3) && (i != 15));
      l = ((structmsg.StructMsg)localObject1).msg.group_code.get();
    } while ((TroopChatPie.O(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie).jdField_a_of_type_JavaLangString == null) || (!TroopChatPie.P(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie).jdField_a_of_type_JavaLangString.equalsIgnoreCase("" + l)));
    TroopChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.C();
    }
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a(65536);
  }
  
  protected void d(boolean paramBoolean, String paramString)
  {
    MultiMsgManager.a().b("send struct msg  ");
    MultiMsgManager.a().c();
    MultiMsgManager.a().a("all cost time ");
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(TroopChatPie.V(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie).jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.j = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a(131072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bzy
 * JD-Core Version:    0.7.0.1
 */