package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
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
          this.v = ((ConversationFacade)localObject1).a(localMessage.frienduin, localMessage.istroop);
          localObject1 = (FriendManager)paramQQAppInterface.getManager(8);
          i = this.A & 0xFFFFF0FF;
          if ((localObject1 == null) || (!((FriendManager)localObject1).f(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))) {
            break label580;
          }
          localObject1 = ((FriendManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
          if (localObject1 == null) {
            break label574;
          }
        }
      }
      Object localObject3;
      label207:
      label231:
      MsgSummary localMsgSummary;
      label400:
      label413:
      label574:
      for (localObject1 = ((OpenTroopInfo)localObject1).troopName;; localObject1 = null)
      {
        localObject3 = "";
        localObject2 = localObject1;
        localObject1 = localObject3;
        localObject3 = localObject2;
        this.A = i;
        i = paramQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
        if (i != 1) {
          break label641;
        }
        this.u = 1;
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          break label659;
        }
        this.jdField_a_of_type_JavaLangString = ContactUtils.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true);
        if ((localMessage != null) && (TextUtils.isEmpty(localMessage.nickName))) {
          localMessage.nickName = localMessage.senderuin;
        }
        localMsgSummary = a();
        a(localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
        if ((TextUtils.isEmpty(localMsgSummary.jdField_b_of_type_JavaLangCharSequence)) && (TextUtils.isEmpty(localMsgSummary.jdField_c_of_type_JavaLangCharSequence)))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          localMsgSummary.jdField_b_of_type_JavaLangCharSequence = ((CharSequence)localObject2);
        }
        a(paramQQAppInterface);
        a(paramQQAppInterface, localMsgSummary);
        a(paramQQAppInterface, paramContext, localMsgSummary);
        if (this.jdField_a_of_type_JavaLangString == null) {
          break label668;
        }
        localObject1 = this.jdField_a_of_type_JavaLangString + "群";
        label373:
        if (this.v <= 0) {
          break label689;
        }
        i = this.v;
        if (localMsgSummary.jdField_b_of_type_JavaLangCharSequence == null) {
          break label675;
        }
        localObject2 = localMsgSummary.jdField_b_of_type_JavaLangCharSequence;
        if (this.jdField_b_of_type_JavaLangString == null) {
          break label682;
        }
        localObject3 = this.jdField_b_of_type_JavaLangString;
        localObject1 = String.format("%s,%d,%s,%s", new Object[] { localObject1, Integer.valueOf(i), localObject2, localObject3 });
        this.jdField_c_of_type_JavaLangString = ((String)localObject1);
        if (!localMsgSummary.a) {
          b(paramQQAppInterface, paramContext);
        }
        if ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangCharSequence)) && (localMessage != null) && (localMsgSummary != null) && (AnonymousChatHelper.a(localMessage))) {
          this.jdField_b_of_type_JavaLangCharSequence = localMsgSummary.a(paramContext, paramContext.getResources().getString(2131362568), -1);
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
      label580:
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
          label641:
          if ((i != 2) && (i != 4)) {
            break label207;
          }
          this.u = 3;
          break label207;
          label659:
          this.jdField_a_of_type_JavaLangString = ((String)localObject3);
          break label231;
          label668:
          localObject1 = "群";
          break label373;
          label675:
          localObject2 = "";
          break label400;
          label682:
          localObject3 = "";
          break label413;
          label689:
          if (localMsgSummary.jdField_b_of_type_JavaLangCharSequence != null)
          {
            localObject2 = localMsgSummary.jdField_b_of_type_JavaLangCharSequence;
            label704:
            if (this.jdField_b_of_type_JavaLangString == null) {
              break label753;
            }
          }
          label753:
          for (localObject3 = this.jdField_b_of_type_JavaLangString;; localObject3 = "")
          {
            localObject1 = String.format("%s,%s,%s", new Object[] { localObject1, localObject2, localObject3 });
            break;
            localObject2 = "";
            break label704;
          }
        }
      }
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    int i = 2131427515;
    if ((a().msg instanceof TroopSpecialAttentionMsg))
    {
      paramQQAppInterface = (TroopSpecialAttentionMsg)a().msg;
      if (paramQQAppInterface != null)
      {
        this.jdField_c_of_type_JavaLangCharSequence = paramQQAppInterface.jdField_c_of_type_JavaLangString;
        i = 2131427515;
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