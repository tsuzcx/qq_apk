package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.qphone.base.util.QLog;

public class RecentItemNewFriendMsgData
  extends RecentUserBaseData
{
  private static final String h = "RecentItemNewFriendMsgData";
  int B = 0;
  private boolean a;
  
  public RecentItemNewFriendMsgData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().a().a(AppConstants.V, 4000);
    if (QLog.isColorLevel()) {
      QLog.d("RecentItemNewFriendMsgData", 2, "resetRecentUser data.msg");
    }
    a(paramQQAppInterface);
  }
  
  private void d()
  {
    Object localObject = a();
    if (QLog.isColorLevel()) {
      QLog.d("RecentItemNewFriendMsgData", 2, "initMsgAndCount");
    }
    if (((RecentUser)localObject).msg != null)
    {
      this.jdField_a_of_type_Long = ((RecentUser)localObject).lastmsgtime;
      if ((((RecentUser)localObject).msg instanceof String))
      {
        localObject = ((String)((RecentUser)localObject).msg).split(NewFriendManager.jdField_b_of_type_JavaLangString);
        if (localObject.length != 2) {
          break label100;
        }
        this.jdField_b_of_type_JavaLangCharSequence = localObject[0];
        this.v = Integer.parseInt(localObject[1]);
        this.jdField_b_of_type_JavaLangString = TimeManager.a().a(a(), this.jdField_a_of_type_Long);
      }
    }
    return;
    label100:
    this.jdField_b_of_type_JavaLangCharSequence = "";
    this.v = 0;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentItemNewFriendMsgData", 2, "RecentItemNewFriendMsgData update");
    }
    NewFriendManager localNewFriendManager = (NewFriendManager)paramQQAppInterface.getManager(31);
    NewFriendMessage localNewFriendMessage = localNewFriendManager.a();
    this.jdField_a_of_type_JavaLangString = paramContext.getString(this.B);
    if (QLog.isColorLevel()) {
      QLog.d("RecentItemNewFriendMsgData", 2, "mUser = " + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser);
    }
    if (localNewFriendMessage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentItemNewFriendMsgData", 2, "isFirstShow = " + this.jdField_a_of_type_Boolean);
      }
      if ((this.jdField_a_of_type_Boolean) && (a().msg == null))
      {
        this.jdField_a_of_type_Boolean = false;
        a().reParse();
      }
      for (;;)
      {
        d();
        return;
        b(paramQQAppInterface);
      }
    }
    if (localNewFriendMessage.jdField_a_of_type_Boolean)
    {
      b(paramQQAppInterface);
      d();
      return;
    }
    if (localNewFriendMessage.jdField_a_of_type_JavaLangString != null) {}
    for (paramQQAppInterface = localNewFriendMessage.jdField_a_of_type_JavaLangString;; paramQQAppInterface = this.jdField_b_of_type_JavaLangCharSequence)
    {
      this.jdField_b_of_type_JavaLangCharSequence = paramQQAppInterface;
      this.v = localNewFriendManager.a();
      if (this.jdField_a_of_type_Long < localNewFriendMessage.jdField_a_of_type_Long) {
        this.jdField_a_of_type_Long = localNewFriendMessage.jdField_a_of_type_Long;
      }
      this.jdField_b_of_type_JavaLangString = TimeManager.a().a(a(), this.jdField_a_of_type_Long);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemNewFriendMsgData
 * JD-Core Version:    0.7.0.1
 */