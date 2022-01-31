package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.msg.TroopAtAllMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopAtMeMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopNotificationMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopSpecialAttentionMsg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.OpenTroopInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.utils.ContactUtils;

public class RecentItemTroopMsgData
  extends RecentUserBaseData
{
  public RecentItemTroopMsgData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject2 = null;
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    Object localObject1 = paramQQAppInterface.a();
    if (localObject1 != null) {}
    for (Object localObject3 = ((QQMessageFacade)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);; localObject3 = null)
    {
      int i;
      if (localObject3 != null)
      {
        this.jdField_a_of_type_Long = ((QQMessageFacade.Message)localObject3).time;
        localObject1 = paramQQAppInterface.a();
        if (localObject1 != null)
        {
          this.v = ((ConversationFacade)localObject1).a(((QQMessageFacade.Message)localObject3).frienduin, ((QQMessageFacade.Message)localObject3).istroop);
          localObject1 = (FriendManager)paramQQAppInterface.getManager(8);
          i = this.A & 0xFFFFF0FF;
          if ((localObject1 == null) || (!((FriendManager)localObject1).f(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))) {
            break label526;
          }
          localObject1 = ((FriendManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
          if (localObject1 == null) {
            break label520;
          }
        }
      }
      Object localObject4;
      label520:
      for (localObject1 = ((OpenTroopInfo)localObject1).troopName;; localObject1 = null)
      {
        localObject4 = "";
        localObject2 = localObject1;
        localObject1 = localObject4;
        localObject4 = localObject2;
        this.A = i;
        i = paramQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
        if (i != 1) {
          break label587;
        }
        this.u = 1;
        label201:
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          break label605;
        }
        this.jdField_a_of_type_JavaLangString = ContactUtils.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true);
        label225:
        if ((localObject3 != null) && (TextUtils.isEmpty(((QQMessageFacade.Message)localObject3).nickName))) {
          ((QQMessageFacade.Message)localObject3).nickName = ((QQMessageFacade.Message)localObject3).senderuin;
        }
        localObject4 = a();
        a((QQMessageFacade.Message)localObject3, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, (MsgSummary)localObject4);
        if ((TextUtils.isEmpty(((MsgSummary)localObject4).b)) && (TextUtils.isEmpty(((MsgSummary)localObject4).jdField_c_of_type_JavaLangCharSequence)))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          ((MsgSummary)localObject4).b = ((CharSequence)localObject2);
        }
        a(paramQQAppInterface);
        a(paramQQAppInterface, (MsgSummary)localObject4);
        a(paramQQAppInterface, paramContext, (MsgSummary)localObject4);
        if (this.jdField_a_of_type_JavaLangString == null) {
          break label614;
        }
        localObject1 = this.jdField_a_of_type_JavaLangString + "群";
        label367:
        if (this.v <= 0) {
          break label635;
        }
        i = this.v;
        if (((MsgSummary)localObject4).b == null) {
          break label621;
        }
        localObject2 = ((MsgSummary)localObject4).b;
        label394:
        if (this.b == null) {
          break label628;
        }
        localObject3 = this.b;
        label407:
        localObject1 = String.format("%s,%d,%s,%s", new Object[] { localObject1, Integer.valueOf(i), localObject2, localObject3 });
        this.jdField_c_of_type_JavaLangString = ((String)localObject1);
        if (!((MsgSummary)localObject4).a) {
          b(paramQQAppInterface, paramContext);
        }
        paramQQAppInterface = a();
        if ((paramQQAppInterface != null) && (paramQQAppInterface.msg == null)) {
          paramQQAppInterface.reParse();
        }
        TimeManager.a().a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_Long);
        return;
        this.v = 0;
        break;
        this.jdField_a_of_type_Long = 0L;
        this.v = 0;
        break;
      }
      label526:
      if (localObject1 != null) {}
      for (localObject1 = ((FriendManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);; localObject1 = null)
      {
        if (localObject1 != null)
        {
          localObject4 = ((TroopInfo)localObject1).troopname;
          localObject2 = ((TroopInfo)localObject1).troopmemo;
        }
        for (localObject1 = localObject4;; localObject1 = null)
        {
          i |= 0x100;
          localObject4 = localObject1;
          localObject1 = localObject2;
          break;
          label587:
          if ((i != 2) && (i != 4)) {
            break label201;
          }
          this.u = 3;
          break label201;
          label605:
          this.jdField_a_of_type_JavaLangString = ((String)localObject4);
          break label225;
          label614:
          localObject1 = "群";
          break label367;
          label621:
          localObject2 = "";
          break label394;
          label628:
          localObject3 = "";
          break label407;
          label635:
          if (((MsgSummary)localObject4).b != null)
          {
            localObject2 = ((MsgSummary)localObject4).b;
            if (this.b == null) {
              break label699;
            }
          }
          label650:
          label699:
          for (localObject3 = this.b;; localObject3 = "")
          {
            localObject1 = String.format("%s,%s,%s", new Object[] { localObject1, localObject2, localObject3 });
            break;
            localObject2 = "";
            break label650;
          }
        }
      }
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    int i = 2131427514;
    if ((a().msg instanceof TroopSpecialAttentionMsg))
    {
      paramQQAppInterface = (TroopSpecialAttentionMsg)a().msg;
      if (paramQQAppInterface != null)
      {
        this.jdField_c_of_type_JavaLangCharSequence = paramQQAppInterface.jdField_c_of_type_JavaLangString;
        i = 2131427514;
      }
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangCharSequence)) && (i > 0)) {
        this.y = paramContext.getResources().getColor(i);
      }
      return;
      this.jdField_c_of_type_JavaLangCharSequence = "";
      i = 0;
      continue;
      if (!(a().msg instanceof TroopAtMeMsg)) {
        break label130;
      }
      paramQQAppInterface = (TroopAtMeMsg)a().msg;
      if (paramQQAppInterface == null) {
        break;
      }
      this.jdField_c_of_type_JavaLangCharSequence = paramQQAppInterface.jdField_a_of_type_JavaLangString;
    }
    this.jdField_c_of_type_JavaLangCharSequence = "";
    for (;;)
    {
      i = 0;
      break;
      label130:
      if ((a().msg instanceof TroopAtAllMsg))
      {
        paramQQAppInterface = (TroopAtAllMsg)a().msg;
        if (paramQQAppInterface != null)
        {
          this.jdField_c_of_type_JavaLangCharSequence = paramQQAppInterface.jdField_a_of_type_JavaLangString;
          this.jdField_c_of_type_JavaLangString = String.format("与%s群的会话，有全体消息", new Object[] { this.jdField_a_of_type_JavaLangString });
          break;
        }
        this.jdField_c_of_type_JavaLangCharSequence = "";
        continue;
      }
      if ((a().msg instanceof TroopNotificationMsg))
      {
        paramQQAppInterface = (TroopNotificationMsg)a().msg;
        if ((paramQQAppInterface != null) && ((TroopNotificationHelper.b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) || (TroopNotificationHelper.d(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))))
        {
          this.jdField_c_of_type_JavaLangCharSequence = paramQQAppInterface.jdField_a_of_type_JavaLangString;
          break;
        }
        this.jdField_c_of_type_JavaLangCharSequence = "";
        continue;
      }
      this.jdField_c_of_type_JavaLangCharSequence = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData
 * JD-Core Version:    0.7.0.1
 */