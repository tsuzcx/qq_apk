package com.tencent.mobileqq.systemmsg;

import MessageSvcPack.UinPairReadInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.C2CMessageProcessor;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SystemMsgAIOData;
import com.tencent.mobileqq.data.SystemMsgOldData;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import efy;
import efz;
import ega;
import egb;
import egc;
import egd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class SystemMsgController
  implements SystemMsgUiActionInterface
{
  public static final int a = 4;
  private static SystemMsgController jdField_a_of_type_ComTencentMobileqqSystemmsgSystemMsgController;
  public static final int b = 2;
  public static final int c = 3;
  private static final int g = -1001;
  private static final int h = 5000;
  private long jdField_a_of_type_Long = 0L;
  private Handler jdField_a_of_type_AndroidOsHandler = new egb(this, Looper.getMainLooper());
  private MessageHandler jdField_a_of_type_ComTencentMobileqqAppMessageHandler = null;
  private MessageForSystemMsg jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private final String jdField_a_of_type_JavaLangString = SystemMsgController.class.getName();
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private structmsg.StructMsg jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = -1L;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private String jdField_b_of_type_JavaLangString = null;
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_b_of_type_Boolean = false;
  private long jdField_c_of_type_Long = -1L;
  private String jdField_c_of_type_JavaLangString = null;
  private HashMap jdField_c_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean = false;
  private int e = -1;
  private int f = -1;
  
  public static SystemMsgController a()
  {
    if (jdField_a_of_type_ComTencentMobileqqSystemmsgSystemMsgController == null) {
      jdField_a_of_type_ComTencentMobileqqSystemmsgSystemMsgController = new SystemMsgController();
    }
    return jdField_a_of_type_ComTencentMobileqqSystemmsgSystemMsgController;
  }
  
  private int c(QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0);
    if (paramQQAppInterface != null) {
      i = paramQQAppInterface.getInt("unread_friend_system_msg", 0);
    }
    return i;
  }
  
  private int d(QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0);
    if (paramQQAppInterface != null) {
      i = paramQQAppInterface.getInt("unread_group_system_msg", 0);
    }
    return i;
  }
  
  public int a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_d_of_type_Int == -1) {
      this.jdField_d_of_type_Int = c(paramQQAppInterface);
    }
    return this.jdField_d_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public MessageForSystemMsg a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg;
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString.equals("")))
      {
        paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0);
        if (paramQQAppInterface != null) {
          this.jdField_b_of_type_JavaLangString = paramQQAppInterface.getString("system_msg_tab_display", "");
        }
      }
      paramQQAppInterface = this.jdField_b_of_type_JavaLangString;
      return paramQQAppInterface;
    }
  }
  
  public structmsg.StructMsg a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg == null)
    {
      paramQQAppInterface = paramQQAppInterface.a().a(AppConstants.af, 0);
      if ((paramQQAppInterface == null) || (paramQQAppInterface.size() <= 0)) {}
    }
    try
    {
      structmsg.StructMsg localStructMsg = new structmsg.StructMsg();
      localStructMsg.mergeFrom(((MessageRecord)paramQQAppInterface.get(0)).msgData);
      this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = localStructMsg;
      return this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    }
    catch (InvalidProtocolBufferMicroException paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface.printStackTrace();
      }
    }
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
    Object localObject = this.jdField_b_of_type_JavaLangObject;
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
    SystemMsgOldData localSystemMsgOldData = new SystemMsgOldData();
    localSystemMsgOldData.uin = paramLong1;
    localSystemMsgOldData.msgtime = paramLong2;
    paramQQAppInterface.b(localSystemMsgOldData);
    paramQQAppInterface.a();
  }
  
  public void a(long paramLong, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (!this.jdField_c_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong))) {
        return;
      }
      SystemMsgAIOData localSystemMsgAIOData = (SystemMsgAIOData)this.jdField_c_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new UinPairReadInfo(paramLong, localSystemMsgAIOData.msgtime, 0L, null));
      if (localArrayList.size() > 0)
      {
        ((C2CMessageProcessor)paramQQAppInterface.a().a("c2c_processor")).b(localArrayList);
        this.jdField_c_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong));
        paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface.b(localSystemMsgAIOData);
          paramQQAppInterface.a();
        }
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_JavaLangString, 2, "sendSystemMsgAIODataReadConfirm uin=" + paramLong + ",msgTime=" + localSystemMsgAIOData.msgtime);
        }
      }
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    if (paramQQAppInterface == null) {
      return;
    }
    Object localObject = paramQQAppInterface.a(SystemMsgOldData.class, false, null, null, null, null, "msgtime desc", null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SystemMsgOldData localSystemMsgOldData = (SystemMsgOldData)((Iterator)localObject).next();
        this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(localSystemMsgOldData.uin), Long.valueOf(localSystemMsgOldData.msgtime));
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_JavaLangString, 2, "initSystemMsgOldData " + localSystemMsgOldData.uin + " " + localSystemMsgOldData.msgtime);
        }
      }
    }
    paramQQAppInterface.a();
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    paramQQAppInterface.a(new efy(this, paramQQAppInterface, paramInt));
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.a(new egd(this, paramQQAppInterface, paramBoolean));
  }
  
  public void a(MessageForSystemMsg paramMessageForSystemMsg)
  {
    this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg = paramMessageForSystemMsg;
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
  
  public void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_JavaLangString = paramString;
      paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.edit().putString("system_msg_tab_display", paramString).commit();
      }
      return;
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
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.jdField_c_of_type_JavaLangString = paramQQAppInterface.a();
    paramQQAppInterface.a(new egc(this, paramQQAppInterface, paramBoolean));
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
    if ((this.jdField_c_of_type_JavaLangString != null) && (!this.jdField_c_of_type_JavaLangString.equals(paramQQAppInterface.a()))) {
      this.jdField_d_of_type_Boolean = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0).getBoolean("system_msg_nomore_msg", false);
    }
    return this.jdField_d_of_type_Boolean;
  }
  
  public int b(QQAppInterface paramQQAppInterface)
  {
    if (this.e == -1) {
      this.e = d(paramQQAppInterface);
    }
    return this.e;
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
  
  public void b(long paramLong1, long paramLong2, QQAppInterface paramQQAppInterface)
  {
    Object localObject3 = this.jdField_b_of_type_JavaLangObject;
    Object localObject1 = null;
    Object localObject2;
    try
    {
      if (this.jdField_c_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong1)))
      {
        localObject2 = (SystemMsgAIOData)this.jdField_c_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1));
        localObject1 = localObject2;
        if (((SystemMsgAIOData)localObject2).msgtime >= paramLong2) {
          return;
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new SystemMsgAIOData();
      }
      ((SystemMsgAIOData)localObject2).uin = paramLong1;
      ((SystemMsgAIOData)localObject2).msgtime = paramLong2;
      this.jdField_c_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong1), localObject2);
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "addSystemMsgAIOData " + paramLong1 + " " + paramLong2);
      }
      paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
      if (paramQQAppInterface == null) {
        return;
      }
    }
    finally {}
    paramQQAppInterface.b((Entity)localObject2);
    paramQQAppInterface.a();
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    if (paramQQAppInterface == null) {
      return;
    }
    Object localObject = paramQQAppInterface.a(SystemMsgAIOData.class, false, null, null, null, null, null, null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SystemMsgAIOData localSystemMsgAIOData = (SystemMsgAIOData)((Iterator)localObject).next();
        this.jdField_c_of_type_JavaUtilHashMap.put(Long.valueOf(localSystemMsgAIOData.uin), localSystemMsgAIOData);
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_JavaLangString, 2, "initSystemMsgAIOData " + localSystemMsgAIOData.uin + " " + localSystemMsgAIOData.msgtime);
        }
      }
    }
    paramQQAppInterface.a();
  }
  
  public void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.f = paramInt;
    paramQQAppInterface.a(new efz(this, paramQQAppInterface, paramInt));
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
  
  public boolean b(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0);
    if (paramQQAppInterface != null) {
      bool = paramQQAppInterface.getBoolean("delete_system_msg_item", false);
    }
    return bool;
  }
  
  public void c()
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_d_of_type_Int = -1;
    this.e = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler = null;
    jdField_a_of_type_ComTencentMobileqqSystemmsgSystemMsgController = null;
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    Iterator localIterator;
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      localObject2 = this.jdField_b_of_type_JavaUtilHashMap.keySet();
      if (localObject2 == null) {
        return;
      }
      localIterator = ((Set)localObject2).iterator();
      if (localIterator == null) {
        return;
      }
    }
    Object localObject2 = new ArrayList();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      ((ArrayList)localObject2).add(new UinPairReadInfo(localLong.longValue(), ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(localLong)).longValue(), 0L, null));
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      ((C2CMessageProcessor)paramQQAppInterface.a().a("c2c_processor")).b((ArrayList)localObject2);
      this.jdField_b_of_type_JavaUtilHashMap.clear();
      paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.a(SystemMsgOldData.class);
        paramQQAppInterface.a();
      }
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "sendReadConfirm " + ((ArrayList)localObject2).toString());
      }
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.e = paramInt;
    paramQQAppInterface.a(new ega(this, paramQQAppInterface, paramInt));
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
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
 * Qualified Name:     com.tencent.mobileqq.systemmsg.SystemMsgController
 * JD-Core Version:    0.7.0.1
 */