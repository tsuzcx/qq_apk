package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
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
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    do
    {
      return;
      super.a(paramQQAppInterface, paramContext);
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = paramContext.getString(2131362952);
      }
      this.v = TroopNotificationUtils.a(paramQQAppInterface);
      paramContext = paramQQAppInterface.a().a(AppConstants.ae, 0);
    } while (paramContext == null);
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      paramContext = ((MessageForSystemMsg)paramContext.get(paramContext.size() - 1)).getSystemMsg();
      int i = GroupSystemMsgController.a().a(paramQQAppInterface);
      if ((paramContext == null) || (i <= 0)) {
        break label188;
      }
      this.jdField_a_of_type_Long = paramContext.msg_time.get();
      this.jdField_b_of_type_JavaLangCharSequence = GroupSystemMsgController.a().a(paramQQAppInterface);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_Long != 9223372036854775806L)) {
        this.jdField_b_of_type_JavaLangString = TimeManager.a().a(a(), this.jdField_a_of_type_Long);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.jumpTabMode = 0;
      return;
      paramContext = GroupSystemMsgController.a().a();
      break;
      label188:
      if (paramContext != null)
      {
        this.jdField_a_of_type_Long = paramContext.msg_time.get();
        this.jdField_b_of_type_JavaLangCharSequence = GroupSystemMsgController.a().a(paramQQAppInterface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopNotification
 * JD-Core Version:    0.7.0.1
 */