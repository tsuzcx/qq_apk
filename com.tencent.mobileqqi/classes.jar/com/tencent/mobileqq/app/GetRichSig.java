package com.tencent.mobileqq.app;

import KQQ.ReqItem;
import KQQ.RespItem;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.subaccount.SubAccountAssistantImpl;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;

public class GetRichSig
  extends FriendListHandler
  implements CheckUpdateItemInterface
{
  private ToServiceMsg a;
  
  public GetRichSig(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public int a()
  {
    return 1;
  }
  
  public ReqItem a()
  {
    Object localObject2 = null;
    Object localObject1 = new ArrayList(2);
    ((ArrayList)localObject1).add(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    Object localObject3 = SubAccountAssistantImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((localObject3 != null) && (((String)localObject3).length() > 0)) {
      ((ArrayList)localObject1).add(localObject3);
    }
    localObject3 = new String[((ArrayList)localObject1).size()];
    ((ArrayList)localObject1).toArray((Object[])localObject3);
    a((String[])localObject3);
    localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg != null)
    {
      BaseProtocolCoder localBaseProtocolCoder = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getServiceCmd());
      localObject1 = localObject2;
      if (localBaseProtocolCoder != null)
      {
        localObject3 = new UniPacket(true);
        ((UniPacket)localObject3).setEncodeName("utf-8");
        localObject1 = localObject2;
        if (localBaseProtocolCoder.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, (UniPacket)localObject3))
        {
          localObject1 = new ReqItem();
          ((ReqItem)localObject1).eServiceID = 119;
          ((ReqItem)localObject1).vecParam = ((UniPacket)localObject3).encode();
        }
      }
    }
    return localObject1;
  }
  
  public void a(RespItem paramRespItem)
  {
    if ((paramRespItem.eServiceID == 119) && (paramRespItem.cResult == 2))
    {
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "ProfileService.GetRichSig");
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.putWupBuffer(paramRespItem.vecUpdate);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, localFromServiceMsg);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg = paramToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.GetRichSig
 * JD-Core Version:    0.7.0.1
 */