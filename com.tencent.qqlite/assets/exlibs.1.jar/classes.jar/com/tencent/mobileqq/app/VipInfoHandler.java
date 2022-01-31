package com.tencent.mobileqq.app;

import VIP.VipUserInfo;
import android.os.Bundle;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class VipInfoHandler
  extends BusinessHandler
{
  static int a = 0;
  public static final String a = "ClubInfoSvc.GetVipInfoReq";
  static String b;
  static String c;
  static String d;
  private static String e = "VipInfoHandler";
  
  static
  {
    b = "k_uin";
    c = "k_type";
    d = "k_skey";
    jdField_a_of_type_Int = 1;
  }
  
  VipInfoHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private int a(VipUserInfo paramVipUserInfo, int paramInt1, int paramInt2)
  {
    if ((paramVipUserInfo == null) || (paramInt1 > 2) || (paramInt1 < 1)) {
      return paramInt2;
    }
    if (1 == paramInt1) {}
    for (paramInt1 = paramVipUserInfo.iOpenVip;; paramInt1 = paramVipUserInfo.iOpenSVip) {
      return (paramInt1 << 8 | (byte)paramVipUserInfo.iVipType) << 16 | (short)paramVipUserInfo.iVipLevel;
    }
  }
  
  protected Class a()
  {
    return VipInfoObserver.class;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = paramToServiceMsg.getServiceCmd();
    int i = Integer.valueOf(paramToServiceMsg.extraData.getInt(c)).intValue();
    boolean bool = paramFromServiceMsg.isSuccess();
    if ("ClubInfoSvc.GetVipInfoReq".equals(localObject))
    {
      if ((i != jdField_a_of_type_Int) || (!bool)) {
        break label197;
      }
      localObject = paramToServiceMsg.extraData.getString(b);
      paramToServiceMsg = (VipUserInfo)paramObject;
      if ((paramToServiceMsg == null) || (paramToServiceMsg.iOpenVip < 0) || (paramToServiceMsg.iOpenSVip < 0)) {
        break label191;
      }
      paramFromServiceMsg = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      localObject = paramFromServiceMsg.b((String)localObject);
      ((Friends)localObject).qqVipInfo = a(paramToServiceMsg, 1, ((Friends)localObject).qqVipInfo);
      ((Friends)localObject).superVipInfo = a(paramToServiceMsg, 2, ((Friends)localObject).superVipInfo);
      paramFromServiceMsg.a((Friends)localObject);
    }
    label191:
    label197:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(e, 2, "onReceive: GetBaseVipInfoReq,isSuccess=" + bool);
      }
      a(jdField_a_of_type_Int, bool, paramObject);
      return;
      bool = false;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "ClubInfoSvc.GetVipInfoReq");
    localToServiceMsg.extraData.putString(b, paramString2);
    localToServiceMsg.extraData.putInt(c, jdField_a_of_type_Int);
    localToServiceMsg.extraData.putString(d, paramString1);
    a(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d(e, 2, "sendGetBaseVipInfoReq: on send--cmd=ClubInfoSvc.GetVipInfoReq");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.VipInfoHandler
 * JD-Core Version:    0.7.0.1
 */