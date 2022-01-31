package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import java.util.HashMap;
import java.util.Map;

public class BaseMessageManager$AddMessageContext
{
  public ConversationFacade a;
  public RecentUserProxy a;
  public FriendManager a;
  public TroopInfoManager a;
  public Map a;
  public Map b = new HashMap();
  public Map c = new HashMap();
  public Map d = new HashMap();
  
  public BaseMessageManager$AddMessageContext(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqModelFriendManager = ((FriendManager)paramQQAppInterface.getManager(8));
    this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager = ((TroopInfoManager)paramQQAppInterface.getManager(35));
    this.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy = paramQQAppInterface.a().a();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageConversationFacade = paramQQAppInterface.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.BaseMessageManager.AddMessageContext
 * JD-Core Version:    0.7.0.1
 */