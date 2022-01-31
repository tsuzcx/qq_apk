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
          i = 2131362110;
        }
      }
      while ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangCharSequence)) && (i > 0))
      {
        this.D = paramContext.getResources().getColor(i);
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
            i = 2131362110;
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
          this.A = ((ConversationFacade)localObject3).a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
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
            if (!TextUtils.isEmpty(((QQMessageFacade.Message)localObject1).frienduin)) {
              ((QQMessageFacade.Message)localObject1).nickName = ContactUtils.b(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).senderuin);
            }
            if (TextUtils.isEmpty(((QQMessageFacade.Message)localObject1).nickName)) {
              ((QQMessageFacade.Message)localObject1).nickName = ContactUtils.b(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).senderuin, true);
            }
            if (TextUtils.isEmpty(((QQMessageFacade.Message)localObject1).nickName)) {
              ((QQMessageFacade.Message)localObject1).nickName = ((QQMessageFacade.Message)localObject1).senderuin;
            }
          }
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
            int i = ((FriendManager)localObject3).c(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
            localObject1 = localObject2;
            if (i > 0) {
              localObject1 = "(" + i + ")";
            }
          }
          this.jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject1);
          a(paramQQAppInterface);
          a(paramQQAppInterface, localMsgSummary);
          a(paramQQAppInterface, paramContext, localMsgSummary);
          if (!localMsgSummary.a)
          {
            a(paramContext);
            this.jdField_c_of_type_JavaLangString = String.format(paramContext.getString(2131559010), new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.A) });
            return;
            this.jdField_a_of_type_Long = ((QQMessageFacade.Message)localObject1).time;
            continue;
            this.A = 0;
            break label125;
            this.A = 0;
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
              if ((a().msg instanceof TroopAtMeMsg)) {
                this.jdField_c_of_type_JavaLangCharSequence = ((TroopAtMeMsg)a().msg).jdField_a_of_type_JavaLangString;
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemDiscussionMsgData
 * JD-Core Version:    0.7.0.1
 */