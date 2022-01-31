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
    QQMessageFacade.Message localMessage = null;
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
    if (localQQMessageFacade != null) {
      localMessage = localQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
    }
    Object localObject = paramQQAppInterface.a();
    if ((localObject != null) && (localMessage != null)) {}
    MsgSummary localMsgSummary;
    label263:
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
          break label1378;
        }
        if (this.jdField_a_of_type_JavaLangString == null) {
          break label1359;
        }
        paramQQAppInterface = this.jdField_a_of_type_JavaLangString;
        i = this.v;
        if (localMsgSummary.b == null) {
          break label1365;
        }
        paramContext = localMessage.msg;
        label282:
        if (this.b == null) {
          break label1371;
        }
        localObject = this.b;
        label295:
        paramQQAppInterface = String.format("%s,%d,%s,%s", new Object[] { paramQQAppInterface, Integer.valueOf(i), paramContext, localObject });
        this.jdField_c_of_type_JavaLangString = paramQQAppInterface;
        return;
      }
    }
    String str = ContactUtils.d(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
    localObject = (PhoneContactManager)paramQQAppInterface.getManager(10);
    if (localObject != null) {}
    label1032:
    label1416:
    for (localObject = ((PhoneContactManager)localObject).c(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);; localObject = null)
    {
      if (localObject != null) {
        this.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject).name;
      }
      for (;;)
      {
        a(localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
        if ((localMessage == null) || ((localMessage.getMessageText() == null) && ((localMessage.msgtype != -2011) || (localMessage.msgData == null)))) {
          break label492;
        }
        this.jdField_a_of_type_Long = localMessage.time;
        break;
        if (str != null) {
          this.jdField_a_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, str, true);
        } else {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin;
        }
      }
      label492:
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
              break label736;
            }
            localObject = ContactUtils.b(paramQQAppInterface, localMessage.senderuin, true);
            label591:
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              break label1572;
            }
            localObject = localMessage.senderuin;
          }
        }
      }
      label782:
      label1553:
      label1559:
      label1572:
      for (;;)
      {
        if ((localMessage != null) && ((localMessage.getMessageText() != null) || (localMessage.msgData != null)))
        {
          this.jdField_a_of_type_Long = localMessage.time;
          label636:
          if ((localMessage == null) || (localMessage.msgtype != -1024)) {
            break label782;
          }
        }
        for (;;)
        {
          if (AppConstants.Z.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
          {
            this.jdField_a_of_type_JavaLangString = paramContext.getString(2131363238);
            if (localQQMessageFacade != null) {
              this.v = localQQMessageFacade.f();
            }
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              if ((localMessage.isSendFromLocal()) || (localObject == null) || (!((String)localObject).equals(localMessage.senderuin))) {
                break;
              }
              paramContext.getString(2131363469);
              break;
              label736:
              str = ContactUtils.m(paramQQAppInterface, localMessage.senderuin);
              localObject = str;
              if (!TextUtils.isEmpty(str)) {
                break label591;
              }
              localObject = ContactUtils.b(paramQQAppInterface, localMessage.senderuin, false);
              break label591;
              this.jdField_a_of_type_Long = 0L;
              break label636;
              boolean bool = false;
              if (AppConstants.Z.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
                bool = true;
              }
              MsgUtils.a(paramContext, paramQQAppInterface, localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, localMsgSummary, (String)localObject, bool, false);
              continue;
            }
            localMsgSummary.b = paramContext.getString(2131363239);
            break;
          }
        }
        if (AppConstants.S.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
        {
          this.jdField_a_of_type_JavaLangString = paramContext.getString(2131363240);
          if (localQQMessageFacade != null) {
            this.v = localQQMessageFacade.g();
          }
          if ((localMessage != null) && (-999 != localMessage.msgtype) && (localMessage.msg != null)) {
            break;
          }
          localMsgSummary.b = paramContext.getString(2131363241);
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
            label981:
            if ((localMessage == null) || ((localMessage.getMessageText() == null) && (localMessage.msgData == null) && ((localMessage.msgtype != -2011) || (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type != 0)))) {
              break label1142;
            }
            this.jdField_a_of_type_Long = localMessage.time;
            a(localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
            if (!AppConstants.Y.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
              break label1150;
            }
            this.jdField_a_of_type_JavaLangString = paramContext.getString(2131363525);
            this.v = SystemMsgController.a().b(paramQQAppInterface);
          }
          for (;;)
          {
            if ((localMessage == null) || (localMessage.msgtype != -2025)) {
              break label1348;
            }
            if (this.v <= 0) {
              break label1350;
            }
            this.y = -881592;
            this.jdField_c_of_type_JavaLangCharSequence = localMessage.msg;
            localMsgSummary.b = "";
            break;
            this.u = 1;
            break label981;
            label1142:
            this.jdField_a_of_type_Long = 0L;
            break label1032;
            label1150:
            if (AppConstants.aa.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
            {
              this.jdField_a_of_type_JavaLangString = paramContext.getString(2131363523);
            }
            else if (AppConstants.W.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
            {
              this.jdField_a_of_type_JavaLangString = paramContext.getString(2131363537);
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
          label1348:
          break;
          label1350:
          this.jdField_c_of_type_JavaLangCharSequence = "";
          break;
          label1359:
          paramQQAppInterface = "";
          break label263;
          label1365:
          paramContext = "";
          break label282;
          label1371:
          localObject = "";
          break label295;
          label1378:
          if (this.v > 0)
          {
            if (this.jdField_a_of_type_JavaLangString != null)
            {
              paramQQAppInterface = this.jdField_a_of_type_JavaLangString;
              label1397:
              i = this.v;
              if (localMsgSummary.b == null) {
                break label1468;
              }
              paramContext = localMsgSummary.b;
              if (this.b == null) {
                break label1474;
              }
            }
            for (localObject = this.b;; localObject = "")
            {
              paramQQAppInterface = String.format("%s,%d,%s,%s", new Object[] { paramQQAppInterface, Integer.valueOf(i), paramContext, localObject });
              break;
              paramQQAppInterface = "";
              break label1397;
              paramContext = "";
              break label1416;
            }
          }
          label1468:
          label1474:
          if (this.jdField_a_of_type_JavaLangString != null)
          {
            paramQQAppInterface = this.jdField_a_of_type_JavaLangString;
            label1493:
            if (localMsgSummary.b == null) {
              break label1553;
            }
            paramContext = localMsgSummary.b;
            label1507:
            if (this.b == null) {
              break label1559;
            }
          }
          for (localObject = this.b;; localObject = "")
          {
            paramQQAppInterface = String.format("%s,%s,%s", new Object[] { paramQQAppInterface, paramContext, localObject });
            break;
            paramQQAppInterface = "";
            break label1493;
            paramContext = "";
            break label1507;
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