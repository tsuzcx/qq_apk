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
    super.a(paramQQAppInterface, paramContext);
    Object localObject1 = paramQQAppInterface.a();
    if (localObject1 != null) {}
    for (QQMessageFacade.Message localMessage = ((QQMessageFacade)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);; localMessage = null)
    {
      int i;
      if (localMessage != null)
      {
        this.jdField_a_of_type_Long = localMessage.time;
        localObject1 = paramQQAppInterface.a();
        if (localObject1 != null)
        {
          this.A = ((ConversationFacade)localObject1).a(localMessage.frienduin, localMessage.istroop);
          localObject1 = (FriendManager)paramQQAppInterface.getManager(8);
          i = this.F & 0xFFFFF0FF;
          if ((localObject1 == null) || (!((FriendManager)localObject1).f(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))) {
            break label459;
          }
          localObject1 = ((FriendManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
          if (localObject1 == null) {
            break label453;
          }
        }
      }
      Object localObject3;
      label453:
      for (localObject1 = ((OpenTroopInfo)localObject1).troopName;; localObject1 = null)
      {
        localObject3 = "";
        localObject2 = localObject1;
        localObject1 = localObject3;
        localObject3 = localObject2;
        this.F = i;
        i = paramQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
        if (i != 1) {
          break label520;
        }
        this.z = 1;
        label207:
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          break label538;
        }
        this.jdField_a_of_type_JavaLangString = ContactUtils.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true);
        label231:
        if ((localMessage != null) && (TextUtils.isEmpty(localMessage.nickName))) {
          localMessage.nickName = localMessage.senderuin;
        }
        localObject3 = a();
        a(localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, (MsgSummary)localObject3);
        if ((TextUtils.isEmpty(((MsgSummary)localObject3).b)) && (TextUtils.isEmpty(((MsgSummary)localObject3).jdField_c_of_type_JavaLangCharSequence)))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          ((MsgSummary)localObject3).b = ((CharSequence)localObject2);
        }
        a(paramQQAppInterface);
        a(paramQQAppInterface, (MsgSummary)localObject3);
        a(paramQQAppInterface, paramContext, (MsgSummary)localObject3);
        this.jdField_c_of_type_JavaLangString = String.format(paramContext.getResources().getString(2131559014), new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.A) });
        if (!((MsgSummary)localObject3).a) {
          b(paramQQAppInterface, paramContext);
        }
        paramQQAppInterface = a();
        if ((paramQQAppInterface != null) && (paramQQAppInterface.msg == null)) {
          paramQQAppInterface.reParse();
        }
        TimeManager.a().a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_Long);
        return;
        this.A = 0;
        break;
        this.jdField_a_of_type_Long = 0L;
        this.A = 0;
        break;
      }
      label459:
      if (localObject1 != null) {}
      for (localObject1 = ((FriendManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);; localObject1 = null)
      {
        if (localObject1 != null)
        {
          localObject3 = ((TroopInfo)localObject1).troopname;
          localObject2 = ((TroopInfo)localObject1).troopmemo;
        }
        for (localObject1 = localObject3;; localObject1 = null)
        {
          i |= 0x100;
          localObject3 = localObject1;
          localObject1 = localObject2;
          break;
          label520:
          if ((i != 2) && (i != 4)) {
            break label207;
          }
          this.z = 3;
          break label207;
          label538:
          this.jdField_a_of_type_JavaLangString = ((String)localObject3);
          break label231;
        }
      }
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    int i = 2131362120;
    if ((a().msg instanceof TroopSpecialAttentionMsg))
    {
      paramQQAppInterface = (TroopSpecialAttentionMsg)a().msg;
      if (paramQQAppInterface != null)
      {
        this.jdField_c_of_type_JavaLangCharSequence = paramQQAppInterface.jdField_c_of_type_JavaLangString;
        i = 2131362120;
      }
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangCharSequence)) && (i > 0)) {
        this.D = paramContext.getResources().getColor(i);
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
        if (paramQQAppInterface != null)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData
 * JD-Core Version:    0.7.0.1
 */