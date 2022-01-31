package com.tencent.mobileqq.service.message;

import AccostSvc.ReqGetBlackList;
import AccostSvc.ReqHeader;
import AccostSvc.RespGetBlackList;
import KQQ.ReqItem;
import KQQ.RespItem;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;

public class GetBlackListItem
  implements CheckUpdateItemInterface
{
  public static String a;
  private final QQAppInterface a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "GetBlackListItem";
  }
  
  public GetBlackListItem(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public int a()
  {
    return 1;
  }
  
  public ReqItem a()
  {
    ReqItem localReqItem = new ReqItem();
    localReqItem.eServiceID = 116;
    Object localObject = new ReqHeader();
    ((ReqHeader)localObject).shVersion = 0;
    ((ReqHeader)localObject).lMID = MessageFactorySender.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()));
    ((ReqHeader)localObject).iAppID = AppSetting.a;
    localObject = new ReqGetBlackList((ReqHeader)localObject, 0L, 1, 0);
    UniPacket localUniPacket = new UniPacket();
    localUniPacket.setServantName("AccostObj");
    localUniPacket.setFuncName("CMD_GET_BlackList");
    localUniPacket.put("ReqGetBlackList", localObject);
    localReqItem.vecParam = localUniPacket.encode();
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if ((paramRespItem.eServiceID == 116) && (paramRespItem.cResult == 2))
    {
      Object localObject = new UniPacket();
      ((UniPacket)localObject).setEncodeName("utf-8");
      ((UniPacket)localObject).decode(paramRespItem.vecUpdate);
      paramRespItem = (RespGetBlackList)((UniPacket)localObject).getByClass("RespGetBlackList", new RespGetBlackList());
      localObject = (MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
      FromServiceMsg localFromServiceMsg = new FromServiceMsg();
      localFromServiceMsg.setMsgSuccess();
      ((MessageHandler)localObject).b(null, localFromServiceMsg, paramRespItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.GetBlackListItem
 * JD-Core Version:    0.7.0.1
 */