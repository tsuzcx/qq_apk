package com.tencent.mobileqq.app;

import KQQ.ReqItem;
import KQQ.RespItem;
import SecurityAccountServer.RequestGetRecommendedListV2;
import SecurityAccountServer.RequestHeader;
import SecurityAccountServer.RespondHeader;
import SecurityAccountServer.RespondQueryQQBindingStat;
import SecurityAccountServer.ResponseGetRecommendedListV2;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.phonecontact.ContactBindServlet;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class AccountRecListItem
  implements CheckUpdateItemInterface
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  PhoneContactManager jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager = null;
  private final String jdField_a_of_type_JavaLangString = "AccountRecListItem";
  private boolean jdField_a_of_type_Boolean = false;
  
  public AccountRecListItem(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private PhoneContactManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10));
    }
    return this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager;
  }
  
  private void a(ResponseGetRecommendedListV2 paramResponseGetRecommendedListV2)
  {
    boolean bool2 = true;
    Object localObject1 = new RespondQueryQQBindingStat();
    Object localObject2 = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if (paramResponseGetRecommendedListV2 != null)
    {
      ((RespondQueryQQBindingStat)localObject1).mobileNo = paramResponseGetRecommendedListV2.mobileNo;
      ((RespondQueryQQBindingStat)localObject1).nationCode = paramResponseGetRecommendedListV2.nationCode;
      ((RespondQueryQQBindingStat)localObject1).lastUsedFlag = paramResponseGetRecommendedListV2.lastUsedFlag;
      ((RespondQueryQQBindingStat)localObject1).MobileUniqueNo = paramResponseGetRecommendedListV2.MobileUniqueNo;
      ((RespondQueryQQBindingStat)localObject1).originBinder = paramResponseGetRecommendedListV2.originBinder;
      ((RespondQueryQQBindingStat)localObject1).isRecommend = 1L;
      ((PhoneContactManagerImp)localObject2).a(paramResponseGetRecommendedListV2.ConfigVersion, paramResponseGetRecommendedListV2.PopWindowsCount, paramResponseGetRecommendedListV2.PopWindowsTime, paramResponseGetRecommendedListV2.PopCloseCount, paramResponseGetRecommendedListV2.ForcePopSwitch);
    }
    ((PhoneContactManagerImp)localObject2).a((RespondQueryQQBindingStat)localObject1);
    localObject2 = new Bundle();
    if (((RespondQueryQQBindingStat)localObject1).mobileNo != null)
    {
      bool1 = true;
      ((Bundle)localObject2).putBoolean("bind_state", bool1);
      ((Bundle)localObject2).putBoolean("bind_strategy", true);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramResponseGetRecommendedListV2 == null) {
        break label177;
      }
    }
    label177:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((QQAppInterface)localObject1).notifyObservers(ContactBindObserver.class, 12, bool1, (Bundle)localObject2);
      return;
      bool1 = false;
      break;
    }
  }
  
  public int a()
  {
    return 5;
  }
  
  public ReqItem a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountRecListItem", 2, "getCheckUpdateItemData");
    }
    ReqItem localReqItem = new ReqItem();
    localReqItem.eServiceID = 112;
    RequestHeader localRequestHeader = ContactBindServlet.a(0, 0, 0);
    localRequestHeader.cmd = 29;
    RequestGetRecommendedListV2 localRequestGetRecommendedListV2 = new RequestGetRecommendedListV2();
    localRequestGetRecommendedListV2.nextFlag = 0L;
    localRequestGetRecommendedListV2.sessionSid = new byte[0];
    localRequestGetRecommendedListV2.timeStamp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("getRecommendedTimeStamp", 0L);
    localRequestGetRecommendedListV2.type = 2;
    localRequestGetRecommendedListV2.PopVersion = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("contact_bind_info" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getLong("contact_bind_strategy_version", 0L);
    UniPacket localUniPacket = new UniPacket();
    localUniPacket.setServantName("AccountServer");
    localUniPacket.setFuncName("AccountServerFunc");
    localUniPacket.put("RequestGetRecommendedListV2", localRequestGetRecommendedListV2);
    localUniPacket.put("RequestHeader", localRequestHeader);
    localReqItem.vecParam = localUniPacket.encode();
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountRecListItem", 2, "handleCheckUpdateItemData respitem.cResult:" + paramRespItem.cResult);
    }
    if (paramRespItem.cResult == 2)
    {
      UniPacket localUniPacket = new UniPacket();
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramRespItem.vecUpdate);
      if (((RespondHeader)localUniPacket.getByClass("RespondHeader", new RespondHeader())).result == 0)
      {
        a((ResponseGetRecommendedListV2)localUniPacket.getByClass("ResponseGetRecommendedListV2", new ResponseGetRecommendedListV2()));
        return;
      }
      ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).c();
      return;
    }
    ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.AccountRecListItem
 * JD-Core Version:    0.7.0.1
 */