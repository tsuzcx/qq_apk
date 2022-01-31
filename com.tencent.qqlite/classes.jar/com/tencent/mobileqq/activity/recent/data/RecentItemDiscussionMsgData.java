package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.msg.TroopAtAllMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopAtMeMsg;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class RecentItemDiscussionMsgData
  extends RecentUserBaseData
{
  public RecentItemDiscussionMsgData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  private void a(Context paramContext)
  {
    int j = 0;
    if (a().msg == null)
    {
      this.jdField_c_of_type_JavaLangCharSequence = "";
      this.jdField_c_of_type_JavaLangString = "";
    }
    for (;;)
    {
      return;
      Object localObject;
      int i;
      if ((a().msg instanceof TroopAtMeMsg))
      {
        localObject = (TroopAtMeMsg)a().msg;
        if (localObject != null)
        {
          this.jdField_c_of_type_JavaLangCharSequence = ((TroopAtMeMsg)localObject).jdField_a_of_type_JavaLangString;
          i = 2131427515;
        }
      }
      while ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangCharSequence)) && (i > 0))
      {
        this.y = paramContext.getResources().getColor(i);
        return;
        this.jdField_c_of_type_JavaLangCharSequence = "";
        i = 0;
        continue;
        i = j;
        if ((a().msg instanceof TroopAtAllMsg))
        {
          localObject = (TroopAtAllMsg)a().msg;
          if (localObject != null)
          {
            this.jdField_c_of_type_JavaLangCharSequence = ((TroopAtAllMsg)localObject).jdField_a_of_type_JavaLangString;
            this.jdField_c_of_type_JavaLangString = String.format("与%s群的会话，有全体消息", new Object[] { this.jdField_a_of_type_JavaLangString });
            i = 2131427515;
          }
          else
          {
            this.jdField_c_of_type_JavaLangCharSequence = "";
            i = j;
          }
        }
      }
    }
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
    for (localObject1 = ((QQMessageFacade)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);; localObject1 = null)
    {
      if (localObject1 != null) {
        if ((((QQMessageFacade.Message)localObject1).istroop == 3000) && (((QQMessageFacade.Message)localObject1).msg == null) && (((QQMessageFacade.Message)localObject1).time == 0L)) {
          this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgtime;
        }
      }
      for (;;)
      {
        Object localObject3 = paramQQAppInterface.a();
        if (localObject3 != null)
        {
          this.v = ((ConversationFacade)localObject3).a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
          label125:
          localObject3 = (FriendManager)paramQQAppInterface.getManager(8);
          if (localObject3 != null) {
            localObject2 = ((FriendManager)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
          }
          if ((localObject2 != null) || (TimeManager.a().a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))) {}
        }
        try
        {
          long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
          ((DiscussionHandler)paramQQAppInterface.a(6)).a(l);
          TimeManager.a().a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true);
          if ((localObject1 != null) && (!TextUtils.isEmpty(((QQMessageFacade.Message)localObject1).senderuin)))
          {
            if (((QQMessageFacade.Message)localObject1).senderuin.equals(((QQMessageFacade.Message)localObject1).frienduin)) {
              ((QQMessageFacade.Message)localObject1).nickName = "";
            }
          }
          else
          {
            this.jdField_a_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
            if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
              this.jdField_a_of_type_JavaLangString = ContactUtils.a(paramContext, (DiscussionInfo)localObject2);
            }
            MsgSummary localMsgSummary = a();
            a((QQMessageFacade.Message)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
            localObject2 = "";
            localObject1 = localObject2;
            if (localObject3 != null)
            {
              i = ((FriendManager)localObject3).c(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
              localObject1 = localObject2;
              if (i > 0) {
                localObject1 = "(" + i + ")";
              }
            }
            this.jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject1);
            a(paramQQAppInterface);
            a(paramQQAppInterface, localMsgSummary);
            a(paramQQAppInterface, paramContext, localMsgSummary);
            if (localMsgSummary.a) {
              break label656;
            }
            a(paramContext);
            if (this.jdField_a_of_type_JavaLangString == null) {
              break label689;
            }
            paramQQAppInterface = this.jdField_a_of_type_JavaLangString + "讨论组";
            if (this.v <= 0) {
              break label708;
            }
            int i = this.v;
            if (localMsgSummary.b == null) {
              break label695;
            }
            paramContext = localMsgSummary.b;
            if (this.b == null) {
              break label701;
            }
            localObject1 = this.b;
            paramQQAppInterface = String.format("%s,%d,%s,%s", new Object[] { paramQQAppInterface, Integer.valueOf(i), paramContext, localObject1 });
            this.jdField_c_of_type_JavaLangString = paramQQAppInterface;
            return;
            this.jdField_a_of_type_Long = ((QQMessageFacade.Message)localObject1).time;
            continue;
            this.v = 0;
            break label125;
            this.v = 0;
            this.jdField_a_of_type_Long = 0L;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              QLog.e("discussion", 2, localNumberFormatException.toString());
              continue;
              if (!TextUtils.isEmpty(((QQMessageFacade.Message)localObject1).frienduin)) {
                ((QQMessageFacade.Message)localObject1).nickName = ContactUtils.b(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).senderuin);
              }
              if (TextUtils.isEmpty(((QQMessageFacade.Message)localObject1).nickName)) {
                ((QQMessageFacade.Message)localObject1).nickName = ContactUtils.b(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).senderuin, true);
              }
              if (TextUtils.isEmpty(((QQMessageFacade.Message)localObject1).nickName))
              {
                ((QQMessageFacade.Message)localObject1).nickName = ((QQMessageFacade.Message)localObject1).senderuin;
                continue;
                label656:
                if ((a().msg instanceof TroopAtMeMsg))
                {
                  this.jdField_c_of_type_JavaLangCharSequence = ((TroopAtMeMsg)a().msg).jdField_a_of_type_JavaLangString;
                  continue;
                  label689:
                  paramQQAppInterface = "讨论组";
                  continue;
                  label695:
                  paramContext = "";
                  continue;
                  label701:
                  localObject1 = "";
                }
              }
            }
          }
        }
      }
      label708:
      if (localNumberFormatException.b != null)
      {
        paramContext = localNumberFormatException.b;
        label722:
        if (this.b == null) {
          break label768;
        }
      }
      label768:
      for (localObject1 = this.b;; localObject1 = "")
      {
        paramQQAppInterface = String.format("%s,%s,%s", new Object[] { paramQQAppInterface, paramContext, localObject1 });
        break;
        paramContext = "";
        break label722;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemDiscussionMsgData
 * JD-Core Version:    0.7.0.1
 */