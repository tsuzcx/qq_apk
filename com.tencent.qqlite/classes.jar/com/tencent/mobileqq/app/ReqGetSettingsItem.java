package com.tencent.mobileqq.app;

import KQQ.ReqItem;
import KQQ.RespItem;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class ReqGetSettingsItem
  extends FriendListHandler
  implements CheckUpdateItemInterface
{
  private ToServiceMsg a;
  
  public ReqGetSettingsItem(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public int a()
  {
    return 1;
  }
  
  public ReqItem a()
  {
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.d == 2)
    {
      localObject1 = (RoamSettingController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(28);
      if (localObject1 != null) {
        ((RoamSettingController)localObject1).a(true, this);
      }
    }
    if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg != null)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqServiceMobileQQService.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getServiceCmd());
      if (localObject2 != null)
      {
        localObject1 = new UniPacket(true);
        ((UniPacket)localObject1).setEncodeName("utf-8");
        if (((BaseProtocolCoder)localObject2).a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, (UniPacket)localObject1))
        {
          localObject2 = new ReqItem();
          ((ReqItem)localObject2).eServiceID = 115;
          ((ReqItem)localObject2).vecParam = ((UniPacket)localObject1).encode();
          return localObject2;
        }
      }
    }
    return null;
  }
  
  public void a(RespItem paramRespItem)
  {
    if ((paramRespItem.eServiceID == 115) && (paramRespItem.cResult == 2))
    {
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "ProfileService.ReqGetSettings");
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.putWupBuffer(paramRespItem.vecUpdate);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, localFromServiceMsg);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoamSetting", 2, "ReqGetSettingsItem.send...");
    }
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg = paramToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ReqGetSettingsItem
 * JD-Core Version:    0.7.0.1
 */