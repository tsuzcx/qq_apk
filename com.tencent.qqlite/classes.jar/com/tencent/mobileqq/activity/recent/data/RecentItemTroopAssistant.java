package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
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
    this.u = 0;
  }
  
  public void a(Context paramContext)
  {
    if (this.v > 0)
    {
      this.jdField_c_of_type_JavaLangCharSequence = String.format(paramContext.getString(2131364245), new Object[] { Integer.valueOf(this.v) });
      this.y = paramContext.getResources().getColor(2131427509);
      return;
    }
    this.jdField_c_of_type_JavaLangCharSequence = "";
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.t = 0;
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
      this.t = 4;
      return;
    }
    this.t = 0;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    QQMessageFacade.Message localMessage = null;
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = paramContext.getString(2131363618);
    }
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
    Object localObject2;
    if (localQQMessageFacade != null)
    {
      localObject2 = TroopAssistantManager.a();
      TroopAssistantData localTroopAssistantData = ((TroopAssistantManager)localObject2).a(paramQQAppInterface);
      localObject1 = localObject2;
      if (localTroopAssistantData != null) {
        localMessage = localQQMessageFacade.a(localTroopAssistantData.troopUin, 1);
      }
    }
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      localObject2 = a();
      int i;
      if (localMessage != null)
      {
        this.v = localObject1.a(localQQMessageFacade);
        this.jdField_a_of_type_Long = localMessage.time;
        a(localMessage, 1, paramQQAppInterface, paramContext, (MsgSummary)localObject2);
        if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_Long != 9223372036854775806L)) {
          this.jdField_b_of_type_JavaLangString = TimeManager.a().a(a(), this.jdField_a_of_type_Long);
        }
        i = this.A & 0xFFFFFF0F;
        if (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgtime != 9223372036854775805L) {
          break label312;
        }
        i |= 0x20;
        label190:
        this.A = i;
        a(paramQQAppInterface);
        a(paramQQAppInterface, (MsgSummary)localObject2);
        a(paramQQAppInterface, paramContext, (MsgSummary)localObject2);
        a(paramContext);
        if (this.v <= 0) {
          break label320;
        }
      }
      label312:
      label320:
      for (this.jdField_c_of_type_JavaLangString = String.format("进入群助手界面，有%d个群有新消息。", new Object[] { Integer.valueOf(this.v) });; this.jdField_c_of_type_JavaLangString = "进入群助手界面，无新消息。")
      {
        if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangCharSequence)) || (localMessage == null) || (localObject2 == null) || (!AnonymousChatHelper.a(localMessage))) {
          break label327;
        }
        this.jdField_b_of_type_JavaLangCharSequence = ((MsgSummary)localObject2).a(paramContext, paramContext.getResources().getString(2131362566), -1);
        return;
        this.v = 0;
        this.jdField_a_of_type_Long = 0L;
        break;
        i |= 0x10;
        break label190;
      }
      label327:
      break;
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    super.a(paramQQAppInterface, paramContext, paramMsgSummary);
    if (this.v > 0) {
      this.jdField_b_of_type_JavaLangCharSequence = "";
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.a = false;
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
    paramMsgSummary.a = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopAssistant
 * JD-Core Version:    0.7.0.1
 */