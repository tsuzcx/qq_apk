package com.tencent.mobileqq.subaccount;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountAssistantCache;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountDBOperation;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gli;
import java.util.List;

public class SubAccountDataControll
{
  public static final int a = 0;
  private static SubAccountDataControll jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountDataControll;
  private static final String jdField_a_of_type_JavaLangString = "Q.subaccount.SubAccountDataControll";
  private static byte[] jdField_a_of_type_ArrayOfByte = { 0 };
  public static final int b = 1;
  public static final int c = 1;
  public static final int d = 0;
  private SubAccountAssistantCache jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache = null;
  private SubAccountDBOperation jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation = null;
  
  public static SubAccountDataControll a()
  {
    if (jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountDataControll == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountDataControll == null) {
        jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountDataControll = new SubAccountDataControll();
      }
      return jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountDataControll;
    }
  }
  
  private boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache != null) && (!TextUtils.isEmpty(paramString))) {
      return this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.a(paramString);
    }
    return true;
  }
  
  public int a()
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.d();
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.subaccount.SubAccountDataControll", 4, "getUnNotificationSenderNum=" + i);
    }
    return i;
  }
  
  public int a(QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.b();
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.subaccount.SubAccountDataControll", 4, "getUnreadSenderNum=" + i);
    }
    return i;
  }
  
  public int a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    int k = 0;
    int i = 0;
    int j = i;
    if (a(paramString1))
    {
      if (!TextUtils.isEmpty(paramString2)) {
        break label32;
      }
      j = i;
    }
    label32:
    do
    {
      return j;
      if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation != null) {
        this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation.a(paramQQAppInterface, paramString2);
      }
      i = k;
      if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache != null) {
        i = this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.a(paramQQAppInterface, paramString2);
      }
      j = i;
    } while (!QLog.isColorLevel());
    QLog.d("Q.subaccount.SubAccountDataControll", 2, "deleteMessage: uin = " + paramString2);
    return i;
  }
  
  public int a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (!a(paramString1)) {}
    do
    {
      return j;
      if ((!QLog.isDevelopLevel()) || (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation != null))
      {
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation.a(paramQQAppInterface, paramString2);
        if (paramString1 != null)
        {
          paramString1.isread = paramBoolean;
          this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation.a(paramQQAppInterface, paramString1);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache != null) {
        i = this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.a(paramString2, paramBoolean);
      }
      j = i;
    } while (!QLog.isDevelopLevel());
    return i;
  }
  
  public int a(String paramString)
  {
    if ((!QLog.isDevelopLevel()) || (!a(paramString))) {}
    while (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.a();
  }
  
  public long a(QQAppInterface paramQQAppInterface)
  {
    long l = 0L;
    if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache != null) {
      l = this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.b();
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.subaccount.SubAccountDataControll", 4, "getRecentLastTime：time=" + l);
    }
    return l;
  }
  
  public SubAccountInfo a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = null;
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.subaccount.SubAccountDataControll", 4, "getSubAccountInfo:no uin start.");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache != null) {
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.a();
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.subaccount.SubAccountDataControll", 4, "getSubAccountInfo:no uin finish.");
    }
    return paramQQAppInterface;
  }
  
  public CharSequence a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = "";
    if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache != null) {
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.a();
    }
    return paramQQAppInterface;
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = "";
    if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache != null) {
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.c();
    }
    if (QLog.isDevelopLevel()) {}
    return paramQQAppInterface;
  }
  
  public String a(String paramString)
  {
    if ((!QLog.isDevelopLevel()) || (!a(paramString))) {}
    while (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.b();
  }
  
  public List a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (!a(paramString)) {}
    do
    {
      return null;
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.subaccount.SubAccountDataControll", 4, "getAllMessage: begin.");
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache == null);
    return this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache != null) {
      this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.d();
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache != null) {
      this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.a(paramLong);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.subaccount.SubAccountDataControll", 4, "onUnbindAccount: start.");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation != null) {
        this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation.c(paramQQAppInterface);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.b();
        this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.b("");
        this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.a();
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.subaccount.SubAccountDataControll", 4, "onUnbindAccount: finish.");
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SubAccountMessage paramSubAccountMessage, String paramString)
  {
    if (!a(paramString)) {}
    do
    {
      do
      {
        return;
      } while ((paramSubAccountMessage == null) || (TextUtils.isEmpty(paramSubAccountMessage.senderuin)));
      if ((!QLog.isDevelopLevel()) || (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation != null)) {
        this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation.a(paramQQAppInterface, paramSubAccountMessage);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache != null) {
        this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.a(paramSubAccountMessage, paramQQAppInterface);
      }
    } while (!QLog.isDevelopLevel());
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (!a(paramString)) {}
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.subaccount.SubAccountDataControll", 4, "clearAllMessage:start.");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation != null) {
        this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation.b(paramQQAppInterface);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache != null) {
        this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.a();
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("Q.subaccount.SubAccountDataControll", 4, "clearAllMessage:finished.");
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    if (paramQQAppInterface != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.subaccount.SubAccountDataControll", 4, "setAccountError: begin subuin=" + paramString1 + ",type=" + paramInt + ",msg=" + paramString2);
      }
      if (a(paramString1)) {
        break label63;
      }
    }
    label63:
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation == null) {
          break;
        }
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation.b(paramQQAppInterface);
      } while ((paramString1 == null) || (paramString1.size() <= 0) || (paramString1.get(0) == null));
      paramString1 = (SubAccountInfo)paramString1.get(0);
      paramString1.serverErrorType = paramInt;
      paramString1.serverErrorMsg = paramString2;
      this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation.a(paramQQAppInterface, paramString1);
    } while (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache == null);
    this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.a(paramInt, paramString2);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((!QLog.isDevelopLevel()) || (!a(paramString1))) {}
    for (;;)
    {
      return;
      if (paramString2 == null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation != null) {
          this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation.a(paramQQAppInterface, paramString1, null);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache != null) {
          this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.a(paramString1, null);
        }
      }
      while (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.b(paramString2);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation != null) {
          this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation.a(paramQQAppInterface, paramString1, 0, "");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache != null) {
          this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.a(0, "");
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, long paramLong1, boolean paramBoolean, String paramString4, int paramInt1, long paramLong2, int paramInt2)
  {
    if (!a(paramString1)) {}
    do
    {
      return;
      if ((!QLog.isDevelopLevel()) || (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation != null))
      {
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation.a(paramQQAppInterface, paramString2);
        if (paramString1 != null)
        {
          if (paramString3 != null) {
            paramString1.msg = paramString3;
          }
          if (paramLong1 > 0L) {
            paramString1.time = paramLong1;
          }
          paramString1.isread = paramBoolean;
          if ((paramString4 != null) && (paramString4.length() > 0)) {
            paramString1.sendername = paramString4;
          }
          paramString1.istroop = paramInt1;
          paramString1.msgseq = paramLong2;
          paramString1.msgtype = paramInt2;
          this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation.a(paramQQAppInterface, paramString1);
        }
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache == null);
    this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.a(paramQQAppInterface, paramString2, paramString3, paramLong1, paramBoolean, paramString4, paramInt1, paramLong2, paramInt2);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, byte[] paramArrayOfByte)
  {
    if ((paramQQAppInterface == null) || (paramString == null)) {}
    do
    {
      do
      {
        return;
      } while (!a(paramString));
      if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation != null) {
        this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation.a(paramQQAppInterface, paramString, paramArrayOfByte);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache == null);
    this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.a(paramString, paramArrayOfByte);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache != null) {
      this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.a(paramString);
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    paramQQAppInterface = null;
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.subaccount.SubAccountDataControll", 4, "checkAccountBind: start.");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache != null) {
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.a();
    }
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramQQAppInterface.subuin)) {
        bool1 = true;
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.subaccount.SubAccountDataControll", 4, "checkAccountBind: finish.ret=" + bool1);
    }
    return bool1;
  }
  
  public int b(QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.c();
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.subaccount.SubAccountDataControll", 4, "getUnreadAllMsgNum=" + i);
    }
    return i;
  }
  
  public long b(QQAppInterface paramQQAppInterface)
  {
    long l = 0L;
    if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache != null) {
      l = this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.a();
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.subaccount.SubAccountDataControll", 4, "getLatestTimeL:time=" + l);
    }
    return l;
  }
  
  public String b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = "";
    if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache != null) {
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.d();
    }
    return paramQQAppInterface;
  }
  
  public String b(String paramString)
  {
    if ((!QLog.isDevelopLevel()) || (!a(paramString))) {}
    while (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.a();
  }
  
  public List b(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (!a(paramString)) {}
    do
    {
      do
      {
        return localObject1;
      } while (paramQQAppInterface == null);
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.subaccount.SubAccountDataControll", 4, "getMessageFromDB:getMessageFromDB(directed).start.");
      }
      paramString = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation != null) {
        paramString = this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation.a(paramQQAppInterface);
      }
      localObject1 = paramString;
    } while (!QLog.isDevelopLevel());
    return paramString;
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache == null) {
      this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache = new SubAccountAssistantCache();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation == null) {
      this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation = new SubAccountDBOperation();
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.subaccount.SubAccountDataControll", 4, "initCache: begin.");
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation.b(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.a(BaseApplication.getContext());
    this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.b();
    this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.a();
    RecentUser localRecentUser = paramQQAppInterface.a().a().b(String.valueOf(9992L), 7000);
    if (localRecentUser != null) {
      this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.a(localRecentUser.lastmsgtime);
    }
    if ((localList != null) && (localList.size() > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.a((SubAccountInfo)localList.get(0));
      if (SubAccountAssistantImpl.a().a(paramQQAppInterface, ((SubAccountInfo)localList.get(0)).subuin)) {
        paramQQAppInterface.getSubAccountKey(paramQQAppInterface.getAccount(), ((SubAccountInfo)localList.get(0)).subuin, new gli(this, paramQQAppInterface, localRecentUser));
      }
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.subaccount.SubAccountDataControll", 4, "initCache: finish.");
      }
      return;
      if (localRecentUser != null)
      {
        if (localRecentUser.lastmsgtime == 9223372036854775804L) {
          this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.c("");
        } else {
          this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.c(TimeFormatterUtils.a(localRecentUser.lastmsgtime * 1000L, true, SubAccountAssistantCache.a));
        }
      }
      else {
        this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.c("");
      }
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (!a(paramString)) {}
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.subaccount.SubAccountDataControll", 4, "setAllMessageReaded: setAllMessageReaded.start.");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation != null) {
        this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation.a(paramQQAppInterface);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache != null) {
        this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.a(true);
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("Q.subaccount.SubAccountDataControll", 4, "setAllMessageReaded: setMessageReaded.finish.");
  }
  
  public void b(String paramString)
  {
    if (!a(paramString)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.c();
  }
  
  public String c(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = "";
    if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache != null) {
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.e();
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.subaccount.SubAccountDataControll", 4, "getLatestTimeStr：time=" + paramQQAppInterface);
    }
    return paramQQAppInterface;
  }
  
  public void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface != null) && (paramString != null))
    {
      SubAccountInfo localSubAccountInfo = null;
      if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation != null) {
        localSubAccountInfo = this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation.a(paramQQAppInterface, paramString);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache != null) {
        this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.a(localSubAccountInfo);
      }
    }
  }
  
  public void d(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || ((!QLog.isDevelopLevel()) || (!a(paramString)))) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation != null)
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label86;
      }
      this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation.c(paramQQAppInterface);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation.b(paramQQAppInterface);
      if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.b();
        this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.a();
        this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountAssistantCache.b("");
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      return;
      label86:
      this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountDBOperation.b(paramQQAppInterface, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.SubAccountDataControll
 * JD-Core Version:    0.7.0.1
 */