package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.subaccount.SubAccountAssistantImpl;
import com.tencent.mobileqq.utils.ContactUtils;

public class RecentItemSubAccount
  extends RecentUserBaseData
{
  public RecentItemSubAccount(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.z = 1;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    Object localObject1 = SubAccountAssistantImpl.a();
    MsgSummary localMsgSummary;
    Object localObject2;
    label116:
    String str1;
    if (a() == 9223372036854775804L)
    {
      this.jdField_b_of_type_JavaLangString = ((SubAccountAssistantImpl)localObject1).b(paramQQAppInterface);
      this.jdField_a_of_type_Long = 0L;
      localMsgSummary = a();
      this.jdField_a_of_type_JavaLangString = paramContext.getString(2131561706);
      localObject2 = ((SubAccountAssistantImpl)localObject1).a(paramQQAppInterface);
      if (localObject2 != null)
      {
        localMsgSummary.jdField_b_of_type_JavaLangCharSequence = ((CharSequence)localObject2);
        localMsgSummary.g = 1;
      }
      localObject2 = paramQQAppInterface.a();
      if (localObject2 == null) {
        break label423;
      }
      this.A = ((ConversationFacade)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
      str1 = ((SubAccountAssistantImpl)localObject1).a(paramQQAppInterface);
      if (!TextUtils.isEmpty(str1))
      {
        localObject1 = (FriendManager)paramQQAppInterface.getManager(8);
        if (localObject1 == null) {
          break label456;
        }
      }
    }
    label182:
    label448:
    label456:
    for (localObject1 = ((FriendManager)localObject1).c(str1);; localObject1 = null)
    {
      int i;
      if (localObject1 != null) {
        if (!TextUtils.isEmpty(((Friends)localObject1).remark))
        {
          localObject1 = ((Friends)localObject1).remark;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = localObject1;
            if (!((String)localObject1).equals(str1)) {}
          }
          else
          {
            String str2 = ContactUtils.b(paramQQAppInterface, str1, paramQQAppInterface.d);
            localObject2 = localObject1;
            if (!TextUtils.isEmpty(str2)) {
              localObject2 = str2;
            }
          }
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = str1;
          }
          this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + " ( " + (String)localObject1 + " ) ");
          if ((paramQQAppInterface.d) && (paramQQAppInterface.a != null) && (paramQQAppInterface.a.b()))
          {
            localObject1 = (FriendListHandler)paramQQAppInterface.a(1);
            if (localObject1 != null) {
              ((FriendListHandler)localObject1).a(str1);
            }
            paramQQAppInterface.d = false;
          }
          i = this.F & 0xFFFFFF0F;
          if (a() != 9223372036854775804L) {
            break label448;
          }
          i |= 0x20;
        }
      }
      for (;;)
      {
        this.F = i;
        a(paramQQAppInterface);
        a(paramQQAppInterface, paramContext, localMsgSummary);
        this.c = String.format("%s%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangCharSequence });
        return;
        this.jdField_b_of_type_JavaLangString = "";
        this.jdField_a_of_type_Long = a();
        break;
        this.A = 0;
        break label116;
        localObject1 = ((Friends)localObject1).name;
        break label182;
        localObject1 = str1;
        break label182;
        i |= 0x10;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemSubAccount
 * JD-Core Version:    0.7.0.1
 */