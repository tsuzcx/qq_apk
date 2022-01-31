package com.tencent.mobileqq.app;

import KQQ.ReqItem;
import KQQ.RespItem;
import SecurityAccountServer.RequestGetRecommendedList;
import SecurityAccountServer.RequestHeader;
import SecurityAccountServer.RespondHeader;
import SecurityAccountServer.RespondQueryQQBindingStat;
import SecurityAccountServer.ResponseGetRecommendedList;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.mybusiness.MyBusinessManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.phonecontact.ContactBindServlet;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.NewIntent;

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
  
  private void b(ResponseGetRecommendedList paramResponseGetRecommendedList)
  {
    boolean bool2 = true;
    Object localObject = new RespondQueryQQBindingStat();
    if (paramResponseGetRecommendedList != null)
    {
      ((RespondQueryQQBindingStat)localObject).mobileNo = paramResponseGetRecommendedList.mobileNo;
      ((RespondQueryQQBindingStat)localObject).nationCode = paramResponseGetRecommendedList.nationCode;
      ((RespondQueryQQBindingStat)localObject).lastUsedFlag = paramResponseGetRecommendedList.lastUsedFlag;
      ((RespondQueryQQBindingStat)localObject).MobileUniqueNo = paramResponseGetRecommendedList.MobileUniqueNo;
      ((RespondQueryQQBindingStat)localObject).originBinder = paramResponseGetRecommendedList.originBinder;
      ((RespondQueryQQBindingStat)localObject).isRecommend = 1L;
    }
    ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a((RespondQueryQQBindingStat)localObject);
    Bundle localBundle = new Bundle();
    if (((RespondQueryQQBindingStat)localObject).mobileNo != null)
    {
      bool1 = true;
      localBundle.putBoolean("bind_state", bool1);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramResponseGetRecommendedList == null) {
        break label140;
      }
    }
    label140:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((QQAppInterface)localObject).notifyObservers(ContactBindObserver.class, 12, bool1, localBundle);
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
    localRequestHeader.cmd = 22;
    RequestGetRecommendedList localRequestGetRecommendedList = new RequestGetRecommendedList();
    localRequestGetRecommendedList.nextFlag = 0L;
    localRequestGetRecommendedList.sessionSid = new byte[0];
    localRequestGetRecommendedList.timeStamp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("getRecommendedTimeStamp", 0L);
    localRequestGetRecommendedList.version = 1;
    localRequestGetRecommendedList.type = 2;
    UniPacket localUniPacket = new UniPacket();
    localUniPacket.setServantName("AccountServer");
    localUniPacket.setFuncName("AccountServerFunc");
    localUniPacket.put("RequestGetRecommendedList", localRequestGetRecommendedList);
    localUniPacket.put("RequestHeader", localRequestHeader);
    localReqItem.vecParam = localUniPacket.encode();
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountRecListItem", 2, "handleCheckUpdateItemData respitem.cResult:" + paramRespItem.cResult);
    }
    Object localObject = null;
    MyBusinessManager localMyBusinessManager;
    int i;
    if (paramRespItem.cResult == 2)
    {
      localObject = new UniPacket();
      ((UniPacket)localObject).setEncodeName("utf-8");
      ((UniPacket)localObject).decode(paramRespItem.vecUpdate);
      if (((RespondHeader)((UniPacket)localObject).getByClass("RespondHeader", new RespondHeader())).result == 0)
      {
        paramRespItem = (ResponseGetRecommendedList)((UniPacket)localObject).getByClass("ResponseGetRecommendedList", new ResponseGetRecommendedList());
        b(paramRespItem);
        a(paramRespItem);
        localMyBusinessManager = (MyBusinessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45);
        if (paramRespItem == null) {
          break label217;
        }
        localObject = paramRespItem.mobileNo;
        i = paramRespItem.type;
      }
    }
    for (paramRespItem = (RespItem)localObject;; paramRespItem = "")
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        localMyBusinessManager.a(paramRespItem, i, "");
        return;
        ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).b();
        paramRespItem = null;
        break;
        ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).b();
        paramRespItem = (RespItem)localObject;
        break;
      }
      localMyBusinessManager.b(paramRespItem, i, "");
      return;
      label217:
      i = 0;
    }
  }
  
  public void a(ResponseGetRecommendedList paramResponseGetRecommendedList)
  {
    Object localObject = paramResponseGetRecommendedList.alreadyBindContacts;
    ArrayList localArrayList = paramResponseGetRecommendedList.circleInfo;
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      a().b(localArrayList, paramResponseGetRecommendedList.timeStamp);
    }
    if ((localObject != null) && (((List)localObject).size() != 0)) {
      a().a((List)localObject, paramResponseGetRecommendedList.timeStamp);
    }
    if (paramResponseGetRecommendedList.nextFlag != 4294967295L)
    {
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
      ((NewIntent)localObject).putExtra("req_type", 22);
      ((NewIntent)localObject).putExtra("next_flag", paramResponseGetRecommendedList.nextFlag);
      ((NewIntent)localObject).putExtra("time_stamp", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("getRecommendedTimeStamp", 0L));
      ((NewIntent)localObject).putExtra("session_id", paramResponseGetRecommendedList.sessionSid);
      ((NewIntent)localObject).putExtra("recommend_type", 2);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
    ((SharedPreferences.Editor)localObject).putLong("getRecommendedTimeStamp", paramResponseGetRecommendedList.timeStamp);
    ((SharedPreferences.Editor)localObject).commit();
    localObject = new Bundle();
    if ((paramResponseGetRecommendedList.alreadyBindContacts != null) && (paramResponseGetRecommendedList.alreadyBindContacts.size() > 0)) {
      ((Bundle)localObject).putBoolean("hasUpdate", true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.notifyObservers(ContactBindObserver.class, 22, true, (Bundle)localObject);
      return;
      ((Bundle)localObject).putBoolean("hasUpdate", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.AccountRecListItem
 * JD-Core Version:    0.7.0.1
 */