package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;

public class RecentItemTroopAssistant
  extends RecentUserBaseData
{
  public RecentItemTroopAssistant(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.z = 0;
  }
  
  public void a(Context paramContext)
  {
    if (this.A > 0)
    {
      this.jdField_c_of_type_JavaLangCharSequence = String.format(paramContext.getString(2131561537), new Object[0]);
      this.D = paramContext.getResources().getColor(2131362108);
      return;
    }
    this.jdField_c_of_type_JavaLangCharSequence = "";
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.y = 0;
    TroopAssistantData localTroopAssistantData = TroopAssistantManager.a().a(paramQQAppInterface);
    if ((localTroopAssistantData == null) || (TextUtils.isEmpty(localTroopAssistantData.troopUin))) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.a();
    } while (paramQQAppInterface == null);
    paramQQAppInterface = paramQQAppInterface.a(localTroopAssistantData.troopUin, 1);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.getSummary())))
    {
      this.y = 4;
      return;
    }
    this.y = 0;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramContext.getString(2131562182);
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
    TroopAssistantManager localTroopAssistantManager;
    Object localObject;
    if (localQQMessageFacade != null)
    {
      localTroopAssistantManager = TroopAssistantManager.a();
      localObject = localTroopAssistantManager.a(paramQQAppInterface);
      if (localObject != null) {
        localObject = localQQMessageFacade.a(((TroopAssistantData)localObject).troopUin, 1);
      }
    }
    for (;;)
    {
      MsgSummary localMsgSummary = a();
      int i;
      if (localObject != null)
      {
        this.A = localTroopAssistantManager.a(localQQMessageFacade);
        this.jdField_a_of_type_Long = ((QQMessageFacade.Message)localObject).time;
        a((QQMessageFacade.Message)localObject, 1, paramQQAppInterface, paramContext, localMsgSummary);
        if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_Long != 9223372036854775806L)) {
          this.jdField_b_of_type_JavaLangString = TimeManager.a().a(a(), this.jdField_a_of_type_Long);
        }
        if ((TextUtils.isEmpty(localMsgSummary.jdField_b_of_type_JavaLangCharSequence)) && (TextUtils.isEmpty(localMsgSummary.jdField_c_of_type_JavaLangCharSequence)))
        {
          localMsgSummary.jdField_a_of_type_JavaLangCharSequence = null;
          localMsgSummary.jdField_b_of_type_JavaLangCharSequence = paramContext.getString(2131562349);
        }
        i = this.F & 0xFFFFFF0F;
        if (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgtime != 9223372036854775805L) {
          break label286;
        }
        i |= 0x20;
      }
      for (;;)
      {
        this.F = i;
        a(paramQQAppInterface);
        a(paramQQAppInterface, localMsgSummary);
        a(paramQQAppInterface, paramContext, localMsgSummary);
        a(paramContext);
        if (this.A <= 0) {
          break label294;
        }
        this.jdField_c_of_type_JavaLangString = String.format(paramContext.getString(2131559013), new Object[] { Integer.valueOf(this.A) });
        return;
        this.A = 0;
        this.jdField_a_of_type_Long = 0L;
        break;
        label286:
        i |= 0x10;
      }
      label294:
      this.jdField_c_of_type_JavaLangString = paramContext.getString(2131559013);
      return;
      localObject = null;
      continue;
      localTroopAssistantManager = null;
      localObject = null;
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    super.a(paramQQAppInterface, paramContext, paramMsgSummary);
    if (this.A > 0) {
      this.jdField_b_of_type_JavaLangCharSequence = "";
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.jdField_a_of_type_Boolean = false;
      paramMsgSummary.d = null;
    }
    Object localObject = paramQQAppInterface.a();
    if (localObject == null) {}
    TroopAssistantData localTroopAssistantData;
    do
    {
      do
      {
        return;
        localTroopAssistantData = TroopAssistantManager.a().a(paramQQAppInterface);
      } while ((localTroopAssistantData == null) || (TextUtils.isEmpty(localTroopAssistantData.troopUin)) || (this.jdField_a_of_type_Long >= localTroopAssistantData.lastdrafttime));
      localObject = ((QQMessageFacade)localObject).a(localTroopAssistantData.troopUin, 1);
    } while ((localObject == null) || (TextUtils.isEmpty(((DraftSummaryInfo)localObject).getSummary())));
    this.jdField_a_of_type_Long = ((DraftSummaryInfo)localObject).getTime();
    paramMsgSummary.jdField_a_of_type_Boolean = true;
    localObject = ((DraftSummaryInfo)localObject).getSummary();
    paramQQAppInterface = ContactUtils.a(paramQQAppInterface, localTroopAssistantData.troopUin, true);
    paramMsgSummary.d = new QQText(paramQQAppInterface + ": " + (String)localObject, 3, 16);
  }
  
  protected void a(QQMessageFacade.Message paramMessage, int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    String str = ContactUtils.a(paramQQAppInterface, paramMessage.frienduin, true);
    MsgUtils.a(paramContext, paramQQAppInterface, paramMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramMsgSummary, str, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopAssistant
 * JD-Core Version:    0.7.0.1
 */