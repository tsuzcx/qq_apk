package com.tencent.biz.TroopRedpoint;

import android.content.SharedPreferences;
import com.tencent.biz.ProtoServlet;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.observer.GetRedPointExObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kj;
import kk;
import kl;
import km;
import kn;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import tencent.im.oidb.cmd0x791.oidb_0x791.GetRedDotOpt;
import tencent.im.oidb.cmd0x791.oidb_0x791.GetRedDotRes;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import tencent.im.oidb.cmd0x791.oidb_0x791.ReqBody;
import tencent.im.oidb.cmd0x791.oidb_0x791.RspBody;
import tencent.im.oidb.cmd0x791.oidb_0x791.SetRedDotOpt;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x69.Submsgtype0x69;

public class TroopRedTouchHandler
  extends BusinessHandler
{
  public static final int a = 105;
  static final String jdField_a_of_type_JavaLangString = "OidbSvc.0x791";
  private BusinessObserver jdField_a_of_type_ComTencentMobileqqAppBusinessObserver = new kn(this);
  
  public TroopRedTouchHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ThreadManager.b(new km(paramQQAppInterface, paramLong));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramQQAppInterface != null)) {}
    for (;;)
    {
      try
      {
        Submsgtype0x69 localSubmsgtype0x69 = new Submsgtype0x69();
        localSubmsgtype0x69.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = new oidb_0x791.RedDotInfo();
        paramArrayOfByte.uint32_appid.set(localSubmsgtype0x69.uint32_appid.get());
        paramArrayOfByte.bool_display_reddot.set(localSubmsgtype0x69.bool_display_reddot.get());
        paramArrayOfByte.uint32_number.set(localSubmsgtype0x69.uint32_number.get());
        paramArrayOfByte.uint32_reason.set(localSubmsgtype0x69.uint32_reason.get());
        paramArrayOfByte.uint32_last_time.set(localSubmsgtype0x69.uint32_last_time.get());
        paramArrayOfByte.uint64_cmd_uin.set(localSubmsgtype0x69.uint64_cmd_uin.get());
        ((TroopRedTouchManager)paramQQAppInterface.getManager(55)).a(paramArrayOfByte);
        bool = true;
        return bool;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return false;
      }
      boolean bool = false;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    try
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.mergeFrom(paramArrayOfByte);
      if ((localOIDBSSOPkg == null) || (!localOIDBSSOPkg.uint32_result.has()) || (localOIDBSSOPkg.uint32_result.get() != 0) || (!localOIDBSSOPkg.bytes_bodybuffer.has()) || (localOIDBSSOPkg.bytes_bodybuffer.get() == null))
      {
        a(paramQQAppInterface, 120L);
        return;
      }
      paramArrayOfByte = new oidb_0x791.RspBody();
      paramArrayOfByte.mergeFrom(localOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
      paramArrayOfByte = (oidb_0x791.GetRedDotRes)paramArrayOfByte.msg_get_reddot_res.get();
      if (paramArrayOfByte != null)
      {
        a(paramQQAppInterface, paramArrayOfByte.uint32_interval.get());
        ((TroopRedTouchManager)paramQQAppInterface.getManager(55)).a(paramArrayOfByte);
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  private void e()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "RedTouchExManager_GetTime", 0);
    long l1 = ((SharedPreferences)localObject1).getLong("last_get_time", 0L);
    long l2 = ((SharedPreferences)localObject1).getLong("interval_time", 0L);
    if (Math.abs(System.currentTimeMillis() / 1000L - l1) < l2) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("SplashActivity", 4, "getRedPointInfo() start");
    }
    Object localObject2 = new ArrayList();
    ((List)localObject2).add(Integer.valueOf(1));
    localObject1 = new oidb_0x791.GetRedDotOpt();
    ((oidb_0x791.GetRedDotOpt)localObject1).uint64_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    ((oidb_0x791.GetRedDotOpt)localObject1).rpt_uint32_appid.addAll((Collection)localObject2);
    localObject2 = new oidb_0x791.ReqBody();
    ((oidb_0x791.ReqBody)localObject2).msg_get_reddot.set((MessageMicro)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1937);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x791.ReqBody)localObject2).toByteArray()));
    localObject2 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ProtoServlet.class);
    ((NewIntent)localObject2).setWithouLogin(true);
    ((NewIntent)localObject2).putExtra("cmd", "OidbSvc.0x791_0");
    ((NewIntent)localObject2).putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((NewIntent)localObject2).setObserver(new kk(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject2);
  }
  
  protected Class a()
  {
    return GetRedPointExObserver.class;
  }
  
  public void a()
  {
    ThreadManager.a(new kj(this));
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    if (paramRedDotInfo == null) {
      return;
    }
    Object localObject1 = new oidb_0x791.SetRedDotOpt();
    ((oidb_0x791.SetRedDotOpt)localObject1).uint64_cmd_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())));
    ((oidb_0x791.SetRedDotOpt)localObject1).rpt_uint64_uin.set((List)localObject2);
    ((oidb_0x791.SetRedDotOpt)localObject1).bool_clear.set(true);
    localObject2 = new oidb_0x791.ReqBody();
    ((oidb_0x791.ReqBody)localObject2).msg_set_reddot.set((MessageMicro)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1937);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(paramRedDotInfo.uint32_appid.get());
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x791.ReqBody)localObject2).toByteArray()));
    localObject2 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ProtoServlet.class);
    ((NewIntent)localObject2).putExtra("cmd", "OidbSvc.0x791_" + String.valueOf(paramRedDotInfo.uint32_appid.get()));
    ((NewIntent)localObject2).putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((NewIntent)localObject2).setObserver(new kl(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject2);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.biz.TroopRedpoint.TroopRedTouchHandler
 * JD-Core Version:    0.7.0.1
 */