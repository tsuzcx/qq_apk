package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.OpenTroopInfo;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.utils.ContactUtils;

public class RecentTroopAssistantItem
  extends RecentBaseData
{
  private TroopAssistantData a;
  
  public RecentTroopAssistantItem(TroopAssistantData paramTroopAssistantData)
  {
    if (paramTroopAssistantData == null) {
      throw new NullPointerException("TroopAssistantData is null");
    }
    this.jdField_a_of_type_ComTencentMobileqqDataTroopAssistantData = paramTroopAssistantData;
    this.z = 3;
  }
  
  public int a()
  {
    return 1;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopAssistantData.lastmsgtime;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopAssistantData.troopUin;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject2 = null;
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    String str = a();
    int j = a();
    Object localObject1 = paramQQAppInterface.a();
    if (localObject1 != null) {}
    for (QQMessageFacade.Message localMessage = ((QQMessageFacade)localObject1).a(str, j);; localMessage = null)
    {
      int i;
      if (localMessage != null)
      {
        this.jdField_a_of_type_Long = localMessage.time;
        localObject1 = paramQQAppInterface.a();
        if (localObject1 != null)
        {
          this.A = ((ConversationFacade)localObject1).a(localMessage.frienduin, localMessage.istroop);
          if ((TroopNotificationHelper.a(str)) || (TroopNotificationHelper.d(str)))
          {
            this.jdField_c_of_type_JavaLangCharSequence = BaseApplicationImpl.getContext().getString(2131561546);
            this.D = paramContext.getResources().getColor(2131362110);
          }
          i = this.F & 0xFFFFF0FF;
          localObject1 = (FriendManager)paramQQAppInterface.getManager(8);
          if ((localObject1 == null) || (!((FriendManager)localObject1).f(str))) {
            break label399;
          }
          localObject1 = ((FriendManager)localObject1).a(str);
          if (localObject1 == null) {
            break label393;
          }
        }
      }
      Object localObject3;
      label393:
      for (localObject1 = ((OpenTroopInfo)localObject1).troopName;; localObject1 = null)
      {
        localObject3 = "";
        localObject2 = localObject1;
        localObject1 = localObject3;
        localObject3 = localObject2;
        this.F = i;
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          break label455;
        }
        this.jdField_a_of_type_JavaLangString = ContactUtils.a(paramQQAppInterface, str, true);
        label231:
        localObject3 = a();
        if ((localMessage != null) && (TextUtils.isEmpty(localMessage.nickName))) {
          localMessage.nickName = localMessage.senderuin;
        }
        a(localMessage, j, paramQQAppInterface, paramContext, (MsgSummary)localObject3);
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
        this.jdField_c_of_type_JavaLangString = String.format(paramContext.getString(2131559016), new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.A) });
        return;
        this.A = 0;
        break;
        this.jdField_a_of_type_Long = 0L;
        this.A = 0;
        break;
      }
      label399:
      if (localObject1 != null) {}
      for (localObject1 = ((FriendManager)localObject1).a(str);; localObject1 = null)
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
          label455:
          this.jdField_a_of_type_JavaLangString = ((String)localObject3);
          break label231;
        }
      }
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopAssistantData.lastdrafttime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem
 * JD-Core Version:    0.7.0.1
 */