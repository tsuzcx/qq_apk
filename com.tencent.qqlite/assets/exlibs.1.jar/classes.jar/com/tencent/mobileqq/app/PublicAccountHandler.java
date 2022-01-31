package com.tencent.mobileqq.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.GetUserFollowListRequest;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.NewIntent;
import mqq.manager.ServerConfigManager.ConfigType;
import tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28.RspTypeList;

public class PublicAccountHandler
  extends BusinessHandler
{
  private static final int jdField_a_of_type_Int = 20;
  public static final String a = "Pb_account_lifeservice";
  private static final int jdField_b_of_type_Int = 1;
  private static final String jdField_b_of_type_JavaLangString = PublicAccountHandler.class.getSimpleName();
  private static final int jdField_c_of_type_Int = 2;
  private static final String jdField_c_of_type_JavaLangString = "PublicAccount_TotalSwitch";
  private static final int jdField_d_of_type_Int = 1;
  private static final String jdField_d_of_type_JavaLangString = "PublicAccount_SearchSwitch";
  private static final int jdField_e_of_type_Int = 2;
  private static final String jdField_e_of_type_JavaLangString = "PublicAccountFollowSeq2";
  private static final int jdField_f_of_type_Int = 3;
  private static final String jdField_f_of_type_JavaLangString = "PublicAccountDataSeq2";
  private static final String g = "time_stamp";
  private static final String h = "get_user_follow_list_begin";
  private static final String i = "get_user_follow_list_follow_seq";
  private static final String j = "get_user_follow_list_data_seq";
  private static final String k = "get_user_follow_list_is_increment";
  public List a;
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  
  PublicAccountHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilList = null;
    this.c = true;
    String str = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, "PublicAccount_TotalSwitch");
    if (str != null) {}
    try
    {
      this.jdField_a_of_type_Boolean = Boolean.parseBoolean(str);
      label37:
      paramQQAppInterface = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, "PublicAccount_SearchSwitch");
      if (paramQQAppInterface != null) {}
      try
      {
        this.jdField_b_of_type_Boolean = Boolean.parseBoolean(paramQQAppInterface);
        return;
      }
      catch (Exception paramQQAppInterface) {}
    }
    catch (Exception localException)
    {
      break label37;
    }
  }
  
  private int a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "get_follow_list");
    mobileqq_mp.GetUserFollowListRequest localGetUserFollowListRequest = new mobileqq_mp.GetUserFollowListRequest();
    localGetUserFollowListRequest.follow_seqno.set(Utils.a(paramLong1));
    localGetUserFollowListRequest.public_account_seqno.set(Utils.a(paramLong2));
    localGetUserFollowListRequest.begin.set(Utils.a(paramLong3));
    localGetUserFollowListRequest.limit.set(Utils.a(paramLong4));
    localGetUserFollowListRequest.version.set(1);
    localGetUserFollowListRequest.is_increment.set(paramBoolean);
    localNewIntent.putExtra("data", localGetUserFollowListRequest.toByteArray());
    localNewIntent.putExtra("get_user_follow_list_begin", paramLong3);
    localNewIntent.putExtra("get_user_follow_list_follow_seq", paramLong1);
    localNewIntent.putExtra("get_user_follow_list_data_seq", paramLong2);
    localNewIntent.putExtra("time_stamp", paramLong5);
    localNewIntent.putExtra("get_user_follow_list_is_increment", paramBoolean);
    PublicAccountServlet.a(localNewIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    return 0;
  }
  
  private long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getLong("PublicAccountFollowSeq2", 0L);
  }
  
  private void a(long paramLong)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit();
    localEditor.putLong("PublicAccountFollowSeq2", paramLong);
    localEditor.commit();
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    QQAppInterface localQQAppInterface = null;
    if ((paramAppInterface instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)paramAppInterface;
    }
    ReportController.b(localQQAppInterface, "P_CliOper", paramString2, "", paramString3, paramString4, 0, 0, paramString1, "", "", "");
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    QQAppInterface localQQAppInterface = null;
    if ((paramAppInterface instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)paramAppInterface;
    }
    ReportController.b(localQQAppInterface, "P_CliOper", paramString2, "", paramString3, paramString4, 0, 0, paramString1, paramString5, "", "");
  }
  
  private void a(SubMsgType0x28.RspTypeList paramRspTypeList) {}
  
  private long b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getLong("PublicAccountDataSeq2", 0L);
  }
  
  private void b(long paramLong)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit();
    localEditor.putLong("PublicAccountDataSeq2", paramLong);
    localEditor.commit();
  }
  
  public int a()
  {
    long l1 = a();
    long l2 = b();
    long l3 = SystemClock.uptimeMillis();
    EnterpriseQQHandler localEnterpriseQQHandler = (EnterpriseQQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(18);
    if (localEnterpriseQQHandler != null) {
      localEnterpriseQQHandler.a(l3);
    }
    return a(l1, l2, 0L, 20L, l3, true);
  }
  
  protected Class a()
  {
    return PublicAccountObserver.class;
  }
  
  public void a()
  {
    a(103, true, null);
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte) {}
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramIntent = paramIntent.getStringExtra("cmd");
    paramFromServiceMsg = (byte[])paramObject;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "<<---onReceive " + paramIntent);
    }
    if (paramIntent.equals("get_follow_list")) {}
    while (!paramIntent.equals("get_business_recommend")) {
      return;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.c = false;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c()
  {
    b(0L);
    a(0L);
  }
  
  public boolean c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PublicAccountHandler
 * JD-Core Version:    0.7.0.1
 */