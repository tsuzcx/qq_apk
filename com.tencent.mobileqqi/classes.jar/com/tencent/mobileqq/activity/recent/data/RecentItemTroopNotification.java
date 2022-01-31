package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class RecentItemTroopNotification
  extends RecentUserBaseData
{
  public RecentItemTroopNotification(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext, RecommendTroopManagerImp paramRecommendTroopManagerImp, MessageRecord paramMessageRecord)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (paramRecommendTroopManagerImp == null) || (paramMessageRecord == null)) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Long = paramMessageRecord.time;
        if (paramMessageRecord.msgtype != -1039) {
          break;
        }
      } while (paramRecommendTroopManagerImp == null);
      this.jdField_b_of_type_JavaLangCharSequence = (paramContext.getResources().getString(2131560606) + paramRecommendTroopManagerImp.a());
      return;
    } while ((paramMessageRecord.msgtype != -1040) || (paramRecommendTroopManagerImp == null));
    this.jdField_b_of_type_JavaLangCharSequence = paramRecommendTroopManagerImp.a();
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    label209:
    label220:
    label348:
    for (;;)
    {
      return;
      super.a(paramQQAppInterface, paramContext);
      this.jdField_a_of_type_JavaLangString = paramContext.getString(2131562195);
      RecommendTroopManagerImp localRecommendTroopManagerImp = (RecommendTroopManagerImp)paramQQAppInterface.getManager(19);
      this.A = TroopNotificationUtils.a(paramQQAppInterface);
      MessageRecord localMessageRecord;
      Object localObject;
      label118:
      int j;
      if (localRecommendTroopManagerImp != null)
      {
        localMessageRecord = localRecommendTroopManagerImp.a();
        localObject = paramQQAppInterface.a().a(AppConstants.aa, 0);
        if ((localObject == null) && (localMessageRecord == null)) {
          continue;
        }
        if ((localObject == null) || (((List)localObject).size() <= 0)) {
          break label209;
        }
        localObject = ((MessageForSystemMsg)((List)localObject).get(((List)localObject).size() - 1)).getSystemMsg();
        int i = GroupSystemMsgController.a().a(paramQQAppInterface);
        j = RecommendTroopManagerImp.a(paramQQAppInterface);
        if ((localObject == null) || (i <= 0)) {
          break label220;
        }
        this.jdField_a_of_type_Long = ((structmsg.StructMsg)localObject).msg_time.get();
        this.jdField_b_of_type_JavaLangCharSequence = GroupSystemMsgController.a().a(paramQQAppInterface);
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_Long <= 0L) || (this.jdField_a_of_type_Long == 9223372036854775806L)) {
          break label348;
        }
        this.jdField_b_of_type_JavaLangString = TimeManager.a().a(a(), this.jdField_a_of_type_Long);
        return;
        localMessageRecord = null;
        break;
        localObject = GroupSystemMsgController.a().a();
        break label118;
        if (j > 0)
        {
          a(paramQQAppInterface, paramContext, localRecommendTroopManagerImp, localMessageRecord);
        }
        else if ((localObject != null) && (localMessageRecord != null))
        {
          if (((structmsg.StructMsg)localObject).msg_time.get() > localMessageRecord.time)
          {
            this.jdField_a_of_type_Long = ((structmsg.StructMsg)localObject).msg_time.get();
            this.jdField_b_of_type_JavaLangCharSequence = GroupSystemMsgController.a().a(paramQQAppInterface);
          }
          else
          {
            a(paramQQAppInterface, paramContext, localRecommendTroopManagerImp, localMessageRecord);
          }
        }
        else
        {
          if (localObject != null)
          {
            this.jdField_a_of_type_Long = ((structmsg.StructMsg)localObject).msg_time.get();
            this.jdField_b_of_type_JavaLangCharSequence = GroupSystemMsgController.a().a(paramQQAppInterface);
          }
          if (localMessageRecord != null) {
            a(paramQQAppInterface, paramContext, localRecommendTroopManagerImp, localMessageRecord);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopNotification
 * JD-Core Version:    0.7.0.1
 */