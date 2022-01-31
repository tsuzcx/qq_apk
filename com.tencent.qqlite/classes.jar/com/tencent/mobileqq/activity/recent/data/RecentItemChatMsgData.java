package com.tencent.mobileqq.activity.recent.data;

import QQService.EVIPSPEC;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.systemmsg.SystemMsgController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;

public class RecentItemChatMsgData
  extends RecentUserBaseData
{
  public RecentItemChatMsgData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  private boolean a(FriendManager paramFriendManager, String paramString)
  {
    if ((paramFriendManager == null) || (TextUtils.isEmpty(paramString))) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return false;
        paramFriendManager = paramFriendManager.a(paramString);
      } while ((paramFriendManager == null) || (!paramFriendManager.isFriend()));
      bool1 = paramFriendManager.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP);
      bool2 = paramFriendManager.isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
    } while ((!bool1) && (!bool2));
    return true;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    QQMessageFacade.Message localMessage = null;
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
    if (localQQMessageFacade != null) {
      localMessage = localQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
    }
    Object localObject = paramQQAppInterface.a();
    if ((localObject != null) && (localMessage != null)) {}
    MsgSummary localMsgSummary;
    label267:
    int i;
    for (this.v = ((ConversationFacade)localObject).a(localMessage.frienduin, localMessage.istroop);; this.v = 0)
    {
      localMsgSummary = a();
      switch (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type)
      {
      default: 
        a(paramQQAppInterface);
        a(paramQQAppInterface, localMsgSummary);
        a(paramQQAppInterface, paramContext, localMsgSummary);
        if ((this.v <= 0) || (localMessage == null) || (localMessage.msgtype != -2025)) {
          break label1382;
        }
        if (this.jdField_a_of_type_JavaLangString == null) {
          break label1363;
        }
        paramQQAppInterface = this.jdField_a_of_type_JavaLangString;
        i = this.v;
        if (localMsgSummary.b == null) {
          break label1369;
        }
        paramContext = localMessage.msg;
        label286:
        if (this.b == null) {
          break label1375;
        }
        localObject = this.b;
        label299:
        paramQQAppInterface = String.format("%s,%d,%s,%s", new Object[] { paramQQAppInterface, Integer.valueOf(i), paramContext, localObject });
        this.jdField_c_of_type_JavaLangString = paramQQAppInterface;
        return;
      }
    }
    String str = ContactUtils.d(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
    localObject = (PhoneContactManager)paramQQAppInterface.getManager(10);
    if (localObject != null) {}
    label640:
    label1036:
    label1420:
    for (localObject = ((PhoneContactManager)localObject).c(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);; localObject = null)
    {
      if (localObject != null) {
        this.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject).name;
      }
      for (;;)
      {
        a(localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
        if ((localMessage == null) || ((localMessage.getMessageText() == null) && ((localMessage.msgtype != -2011) || (localMessage.msgData == null)))) {
          break label496;
        }
        this.jdField_a_of_type_Long = localMessage.time;
        break;
        if (str != null) {
          this.jdField_a_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, str, true);
        } else {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin;
        }
      }
      label496:
      this.jdField_a_of_type_Long = 0L;
      break;
      str = null;
      localObject = str;
      if (localMessage != null)
      {
        localObject = str;
        if (!TextUtils.isEmpty(localMessage.senderuin)) {
          if (!AppConstants.Z.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
          {
            localObject = str;
            if (!AppConstants.S.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {}
          }
          else
          {
            if (!AppConstants.S.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
              break label740;
            }
            localObject = ContactUtils.b(paramQQAppInterface, localMessage.senderuin, true);
            label595:
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              break label1576;
            }
            localObject = localMessage.senderuin;
          }
        }
      }
      label786:
      label1557:
      label1563:
      label1576:
      for (;;)
      {
        if ((localMessage != null) && ((localMessage.getMessageText() != null) || (localMessage.msgData != null)))
        {
          this.jdField_a_of_type_Long = localMessage.time;
          if ((localMessage == null) || (localMessage.msgtype != -1024)) {
            break label786;
          }
        }
        for (;;)
        {
          if (AppConstants.Z.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
          {
            this.jdField_a_of_type_JavaLangString = paramContext.getString(2131363251);
            if (localQQMessageFacade != null) {
              this.v = localQQMessageFacade.f();
            }
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              if ((localMessage.isSendFromLocal()) || (localObject == null) || (!((String)localObject).equals(localMessage.senderuin))) {
                break;
              }
              paramContext.getString(2131363481);
              break;
              label740:
              str = ContactUtils.m(paramQQAppInterface, localMessage.senderuin);
              localObject = str;
              if (!TextUtils.isEmpty(str)) {
                break label595;
              }
              localObject = ContactUtils.b(paramQQAppInterface, localMessage.senderuin, false);
              break label595;
              this.jdField_a_of_type_Long = 0L;
              break label640;
              boolean bool = false;
              if (AppConstants.Z.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
                bool = true;
              }
              MsgUtils.a(paramContext, paramQQAppInterface, localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, localMsgSummary, (String)localObject, bool, false);
              continue;
            }
            localMsgSummary.b = paramContext.getString(2131363252);
            break;
          }
        }
        if (AppConstants.S.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
        {
          this.jdField_a_of_type_JavaLangString = paramContext.getString(2131363253);
          if (localQQMessageFacade != null) {
            this.v = localQQMessageFacade.g();
          }
          if ((localMessage != null) && (-999 != localMessage.msgtype) && (localMessage.msg != null)) {
            break;
          }
          localMsgSummary.b = paramContext.getString(2131363254);
          break;
        }
        this.jdField_a_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true);
        break;
        this.jdField_c_of_type_JavaLangCharSequence = "";
        if (0 == 0) {}
        for (localObject = (FriendManager)paramQQAppInterface.getManager(8);; localObject = null)
        {
          if (a((FriendManager)localObject, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
          {
            this.u = 4;
            label985:
            if ((localMessage == null) || ((localMessage.getMessageText() == null) && (localMessage.msgData == null) && ((localMessage.msgtype != -2011) || (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type != 0)))) {
              break label1146;
            }
            this.jdField_a_of_type_Long = localMessage.time;
            a(localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
            if (!AppConstants.Y.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
              break label1154;
            }
            this.jdField_a_of_type_JavaLangString = paramContext.getString(2131363537);
            this.v = SystemMsgController.a().b(paramQQAppInterface);
          }
          for (;;)
          {
            if ((localMessage == null) || (localMessage.msgtype != -2025)) {
              break label1352;
            }
            if (this.v <= 0) {
              break label1354;
            }
            this.y = -881592;
            this.jdField_c_of_type_JavaLangCharSequence = localMessage.msg;
            localMsgSummary.b = "";
            break;
            this.u = 1;
            break label985;
            label1146:
            this.jdField_a_of_type_Long = 0L;
            break label1036;
            if (AppConstants.aa.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
            {
              this.jdField_a_of_type_JavaLangString = paramContext.getString(2131363535);
            }
            else if (AppConstants.W.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
            {
              this.jdField_a_of_type_JavaLangString = paramContext.getString(2131363543);
              if ((localMessage != null) && (localMessage.msg != null)) {
                localMsgSummary.b = localMessage.msg;
              }
            }
            else if (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type == 1000)
            {
              if (localObject != null)
              {
                localObject = ((FriendManager)localObject).g(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin);
                this.jdField_a_of_type_JavaLangString = ContactUtils.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin, true);
              }
            }
            else if (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type == 1004)
            {
              this.jdField_a_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
            }
            else
            {
              this.jdField_a_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true);
            }
          }
          label1352:
          break;
          label1354:
          this.jdField_c_of_type_JavaLangCharSequence = "";
          break;
          label1363:
          paramQQAppInterface = "";
          break label267;
          label1369:
          paramContext = "";
          break label286;
          label1375:
          localObject = "";
          break label299;
          label1382:
          if (this.v > 0)
          {
            if (this.jdField_a_of_type_JavaLangString != null)
            {
              paramQQAppInterface = this.jdField_a_of_type_JavaLangString;
              label1401:
              i = this.v;
              if (localMsgSummary.b == null) {
                break label1472;
              }
              paramContext = localMsgSummary.b;
              if (this.b == null) {
                break label1478;
              }
            }
            for (localObject = this.b;; localObject = "")
            {
              paramQQAppInterface = String.format("%s,%d,%s,%s", new Object[] { paramQQAppInterface, Integer.valueOf(i), paramContext, localObject });
              break;
              paramQQAppInterface = "";
              break label1401;
              paramContext = "";
              break label1420;
            }
          }
          label1472:
          label1478:
          if (this.jdField_a_of_type_JavaLangString != null)
          {
            paramQQAppInterface = this.jdField_a_of_type_JavaLangString;
            label1497:
            if (localMsgSummary.b == null) {
              break label1557;
            }
            paramContext = localMsgSummary.b;
            label1511:
            if (this.b == null) {
              break label1563;
            }
          }
          for (localObject = this.b;; localObject = "")
          {
            paramQQAppInterface = String.format("%s,%s,%s", new Object[] { paramQQAppInterface, paramContext, localObject });
            break;
            paramQQAppInterface = "";
            break label1497;
            paramContext = "";
            break label1511;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData
 * JD-Core Version:    0.7.0.1
 */