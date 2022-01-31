package com.tencent.mobileqq.systemmsg;

import MessageSvcPack.UinPairReadInfo;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.C2CMessageProcessor;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.GroupSystemMsgOldData;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.newfriend.TroopSystemMessage;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import egy;
import egz;
import eha;
import ehb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class GroupSystemMsgController
  implements SystemMsgUiActionInterface
{
  private static GroupSystemMsgController jdField_a_of_type_ComTencentMobileqqSystemmsgGroupSystemMsgController;
  private static final int jdField_b_of_type_Int = -1001;
  private static final int jdField_c_of_type_Int = 5000;
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = 0L;
  private Handler jdField_a_of_type_AndroidOsHandler = new eha(this, Looper.getMainLooper());
  private MessageHandler jdField_a_of_type_ComTencentMobileqqAppMessageHandler = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private final String jdField_a_of_type_JavaLangString = GroupSystemMsgController.class.getName();
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private structmsg.StructMsg jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = null;
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = -1L;
  private String jdField_b_of_type_JavaLangString = null;
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_b_of_type_Boolean = false;
  private long jdField_c_of_type_Long = -1L;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d = false;
  
  public static GroupSystemMsgController a()
  {
    if (jdField_a_of_type_ComTencentMobileqqSystemmsgGroupSystemMsgController == null) {
      jdField_a_of_type_ComTencentMobileqqSystemmsgGroupSystemMsgController = new GroupSystemMsgController();
    }
    return jdField_a_of_type_ComTencentMobileqqSystemmsgGroupSystemMsgController;
  }
  
  private int b(QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0);
    if (paramQQAppInterface != null) {
      i = paramQQAppInterface.getInt("unread_Group_system_msg", 0);
    }
    return i;
  }
  
  public int a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = b(paramQQAppInterface);
    }
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.getString("group_display", "");
    }
    return "";
  }
  
  public structmsg.StructMsg a()
  {
    return this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
  }
  
  public structmsg.StructMsg a(Long paramLong)
  {
    structmsg.StructMsg localStructMsg = null;
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      localStructMsg = (structmsg.StructMsg)this.jdField_a_of_type_JavaUtilHashMap.get(paramLong);
    }
    return localStructMsg;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public void a(long paramLong1, long paramLong2, QQAppInterface paramQQAppInterface)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    long l = 0L;
    try
    {
      if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong1))) {
        l = ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1))).longValue();
      }
      if (l >= paramLong2) {
        return;
      }
      this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "addSystemMsgOldData " + paramLong1 + " " + paramLong2);
      }
      paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
      if (paramQQAppInterface == null) {
        return;
      }
    }
    finally {}
    GroupSystemMsgOldData localGroupSystemMsgOldData = new GroupSystemMsgOldData();
    localGroupSystemMsgOldData.uin = paramLong1;
    localGroupSystemMsgOldData.msgtime = paramLong2;
    paramQQAppInterface.b(localGroupSystemMsgOldData);
    paramQQAppInterface.a();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Int > 0) {
      ((NewFriendManager)paramQQAppInterface.getManager(31)).a();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    paramQQAppInterface.a(new egy(this, paramQQAppInterface, paramInt));
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if ((paramQQAppInterface != null) && (paramLong <= 0L)) {}
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface.a(new egz(this, paramQQAppInterface, paramString));
  }
  
  public void a(Long paramLong, structmsg.StructMsg paramStructMsg)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "putStructMsgToMap key=" + paramLong);
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramLong, paramStructMsg);
    }
  }
  
  public void a(structmsg.StructMsg paramStructMsg)
  {
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = paramStructMsg;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    this.d = paramBoolean;
    this.jdField_b_of_type_JavaLangString = paramQQAppInterface.a();
    paramQQAppInterface.a(new ehb(this, paramQQAppInterface, paramBoolean));
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean a(MessageHandler paramMessageHandler)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 2, "checkHoldSystemMsg mListViewIsScroll");
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler = paramMessageHandler;
    }
    for (;;)
    {
      return this.jdField_b_of_type_Boolean;
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Long < 5000L)
      {
        if (QLog.isColorLevel()) {
          QLog.w(this.jdField_a_of_type_JavaLangString, 2, "checkHoldSystemMsg distance limit");
        }
        this.jdField_b_of_type_Boolean = true;
        if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(-1001))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler = paramMessageHandler;
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(-1001, 5000L);
        }
      }
      else
      {
        this.jdField_a_of_type_Long = l;
        this.jdField_b_of_type_Boolean = false;
      }
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_b_of_type_JavaLangString != null) && (!this.jdField_b_of_type_JavaLangString.equals(paramQQAppInterface.a()))) {
      this.d = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0).getBoolean("group_system_msg_nomore_msg", false);
    }
    return this.d;
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(3);
    }
  }
  
  public void b(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      Object localObject = paramQQAppInterface.a().a(AppConstants.ah, 0);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = new TroopSystemMessage((MessageForSystemMsg)((List)localObject).get(0), this.jdField_a_of_type_Int, paramQQAppInterface);
        ((NewFriendManager)paramQQAppInterface.getManager(31)).a((NewFriendMessage)localObject);
      }
      return;
    }
    ((NewFriendManager)paramQQAppInterface.getManager(31)).a(new TroopSystemMessage(0));
  }
  
  public boolean b(MessageHandler paramMessageHandler)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler = paramMessageHandler;
    }
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler = null;
    jdField_a_of_type_ComTencentMobileqqSystemmsgGroupSystemMsgController = null;
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    if (paramQQAppInterface == null) {
      return;
    }
    Object localObject = paramQQAppInterface.a(GroupSystemMsgOldData.class, false, null, null, null, null, "msgtime desc", null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GroupSystemMsgOldData localGroupSystemMsgOldData = (GroupSystemMsgOldData)((Iterator)localObject).next();
        this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(localGroupSystemMsgOldData.uin), Long.valueOf(localGroupSystemMsgOldData.msgtime));
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_JavaLangString, 2, "initSystemMsgOldData " + localGroupSystemMsgOldData.uin + " " + localGroupSystemMsgOldData.msgtime);
        }
      }
    }
    paramQQAppInterface.a();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public void d(QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_b_of_type_JavaUtilHashMap == null) {
        return;
      }
      localObject2 = this.jdField_b_of_type_JavaUtilHashMap.keySet();
      if (localObject2 == null) {
        return;
      }
    }
    Object localObject2 = ((Set)localObject2).iterator();
    if (localObject2 == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    while (((Iterator)localObject2).hasNext())
    {
      Long localLong = (Long)((Iterator)localObject2).next();
      localArrayList.add(new UinPairReadInfo(localLong.longValue(), ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(localLong)).longValue(), 0L, null));
    }
    if (localArrayList.size() > 0)
    {
      ((C2CMessageProcessor)paramQQAppInterface.a().a("c2c_processor")).b(localArrayList);
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "sendSystemMsgOldDataReadConfirm " + this.jdField_b_of_type_JavaUtilHashMap.toString());
      }
      this.jdField_b_of_type_JavaUtilHashMap.clear();
      paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.a(GroupSystemMsgOldData.class);
        paramQQAppInterface.a();
      }
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void f()
  {
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.systemmsg.GroupSystemMsgController
 * JD-Core Version:    0.7.0.1
 */