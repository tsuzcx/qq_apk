package com.tencent.mobileqq.subaccount;

import QQService.BindUin;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;

public class SubAccountAssistantImpl
  implements SubAccountAssistInterface
{
  public static final long a = 9223372036854775804L;
  private static SubAccountAssistantImpl jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantImpl = null;
  public static final String a = "param_FailCode";
  public static final boolean a = true;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  public static final String b = "fail_step";
  public static final String c = "fail_location";
  static final String d = "subaccount_sp";
  private static final String e = "Q.subaccount.SubAccountAssistantImpl";
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  
  public static SubAccountAssistantImpl a()
  {
    if (jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantImpl == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantImpl == null) {
        jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantImpl = new SubAccountAssistantImpl();
      }
      return jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantImpl;
    }
  }
  
  public int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return SubAccountDataControll.a().a(paramString);
  }
  
  public int a(String paramString)
  {
    int j = 0;
    int i = j;
    if (paramString != null)
    {
      if (paramString.length() != 0) {
        break label19;
      }
      i = j;
    }
    label19:
    do
    {
      SharedPreferences localSharedPreferences;
      do
      {
        return i;
        localSharedPreferences = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
        i = j;
      } while (localSharedPreferences == null);
      paramString = "stick2top_" + paramString;
      j = localSharedPreferences.getInt(paramString, 0);
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("Q.subaccount.SubAccountAssistantImpl", 2, paramString + ":" + j);
    return j;
  }
  
  public long a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return paramQQAppInterface.a().getSharedPreferences("acc_info" + paramString, 0).getLong("getProfileStatusNew", 11L);
  }
  
  public CharSequence a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      localObject2 = "";
      return localObject2;
    }
    Object localObject2 = a(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubAccountAssistantImpl", 2, "getSubAccountLastMsg:start ");
    }
    long l = System.currentTimeMillis();
    Object localObject3 = paramQQAppInterface.getApplication().getAllNotSynAccountList();
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubAccountAssistantImpl", 2, "getSubAccountLastMsg: end time =  " + (System.currentTimeMillis() - l));
    }
    Object localObject1;
    int i;
    Object localObject4;
    int j;
    if ((localObject2 != null) && (((String)localObject2).length() > 0))
    {
      localObject1 = SubAccountDataControll.a();
      if ((localObject3 == null) || (((List)localObject3).size() == 0)) {
        return paramQQAppInterface.a().getResources().getString(2131563251);
      }
      i = 0;
      if (i >= ((List)localObject3).size()) {
        break label992;
      }
      localObject4 = (SimpleAccount)((List)localObject3).get(i);
      if (localObject4 == null) {}
      while ((((SimpleAccount)localObject4).getUin() == null) || (!((SimpleAccount)localObject4).getUin().equalsIgnoreCase((String)localObject2)))
      {
        i += 1;
        break;
      }
      j = 1;
      if (!((SimpleAccount)localObject4).isLogined()) {
        break label987;
      }
      i = 1;
    }
    for (;;)
    {
      if (j != 0)
      {
        if (i != 0)
        {
          if (!TextUtils.isEmpty(a()))
          {
            localObject2 = ((SubAccountDataControll)localObject1).a(paramQQAppInterface);
            localObject3 = new SpannableStringBuilder();
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject4 = ((SubAccountDataControll)localObject1).b(paramQQAppInterface);
              if (!TextUtils.isEmpty((CharSequence)localObject4))
              {
                ((SpannableStringBuilder)localObject3).append((CharSequence)localObject4);
                ((SpannableStringBuilder)localObject3).append(":");
                ((SpannableStringBuilder)localObject3).append((CharSequence)localObject2);
                return localObject3;
              }
              ((SpannableStringBuilder)localObject3).append(((SubAccountDataControll)localObject1).a(paramQQAppInterface));
              ((SpannableStringBuilder)localObject3).append(":");
              ((SpannableStringBuilder)localObject3).append("");
              return localObject3;
            }
            return paramQQAppInterface.a().getString(2131562499);
          }
          localObject3 = ContactUtils.b(paramQQAppInterface, (String)localObject2, true);
          localObject1 = localObject3;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            localObject1 = localObject2;
          }
          return paramQQAppInterface.a().getString(2131563253, new Object[] { localObject1 });
        }
        i = a(paramQQAppInterface, (String)localObject2);
        if (i != 0)
        {
          switch (i)
          {
          default: 
            localObject1 = paramQQAppInterface.a().getString(2131561673);
          }
          for (;;)
          {
            if (localObject1 != null)
            {
              localObject2 = localObject1;
              if (((String)localObject1).trim().length() != 0) {
                break;
              }
            }
            return paramQQAppInterface.a().getResources().getString(2131563255);
            localObject2 = b(paramQQAppInterface, (String)localObject2);
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              if (((String)localObject2).trim().length() != 0) {}
            }
            else
            {
              localObject1 = paramQQAppInterface.a().getString(2131561673);
              continue;
              localObject2 = b(paramQQAppInterface, (String)localObject2);
              if (localObject2 != null)
              {
                localObject1 = localObject2;
                if (((String)localObject2).trim().length() != 0) {}
              }
              else
              {
                localObject1 = paramQQAppInterface.a().getString(2131561474);
                continue;
                localObject2 = b(paramQQAppInterface, (String)localObject2);
                if (localObject2 != null)
                {
                  localObject1 = localObject2;
                  if (((String)localObject2).trim().length() != 0) {}
                }
                else
                {
                  localObject1 = paramQQAppInterface.a().getString(2131561672);
                  continue;
                  localObject2 = b(paramQQAppInterface, (String)localObject2);
                  if (localObject2 != null)
                  {
                    localObject1 = localObject2;
                    if (((String)localObject2).trim().length() != 0) {}
                  }
                  else
                  {
                    localObject1 = paramQQAppInterface.a().getString(2131561673);
                    continue;
                    localObject2 = b(paramQQAppInterface, (String)localObject2);
                    if (localObject2 != null)
                    {
                      localObject1 = localObject2;
                      if (((String)localObject2).trim().length() != 0) {}
                    }
                    else
                    {
                      localObject1 = paramQQAppInterface.a().getString(2131561673);
                    }
                  }
                }
              }
            }
          }
        }
        return paramQQAppInterface.a().getResources().getString(2131563255);
      }
      if (TextUtils.isEmpty(ContactUtils.b(paramQQAppInterface, (String)localObject2, true))) {}
      return paramQQAppInterface.a().getString(2131563255);
      if (DBUtils.a().a(paramQQAppInterface.getAccount(), paramQQAppInterface.a()) == 1) {
        return paramQQAppInterface.a().getResources().getString(2131563291);
      }
      if ((localObject3 != null) && (((List)localObject3).size() > 1))
      {
        localObject4 = (SimpleAccount)((List)localObject3).get(0);
        localObject2 = null;
        localObject1 = localObject2;
        if (localObject4 != null)
        {
          localObject1 = localObject2;
          if (((SimpleAccount)localObject4).getUin() != null)
          {
            localObject2 = ((SimpleAccount)localObject4).getUin();
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              if (((String)localObject2).equalsIgnoreCase(paramQQAppInterface.getAccount())) {
                localObject1 = ((SimpleAccount)((List)localObject3).get(1)).getUin();
              }
            }
          }
        }
        if ((localObject1 == null) || (((String)localObject1).length() < 5)) {
          return paramQQAppInterface.a().getResources().getString(2131563251);
        }
        localObject3 = null;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject3 = ContactUtils.g(paramQQAppInterface, (String)localObject1);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject2 = localObject3;
          if (!((String)localObject3).equals(localObject1)) {}
        }
        else
        {
          localObject2 = ContactUtils.b(paramQQAppInterface, (String)localObject1, true);
        }
        localObject3 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject3 = localObject1;
        }
        return paramQQAppInterface.a().getResources().getString(2131561725, new Object[] { localObject3 });
      }
      return paramQQAppInterface.a().getResources().getString(2131563251);
      label987:
      i = 0;
      continue;
      label992:
      i = 0;
      j = 0;
    }
  }
  
  public String a()
  {
    return SubAccountDataControll.a().a("");
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    SubAccountInfo localSubAccountInfo = SubAccountDataControll.a().a(paramQQAppInterface);
    Object localObject = null;
    paramQQAppInterface = localObject;
    if (localSubAccountInfo != null)
    {
      paramQQAppInterface = localObject;
      if (!TextUtils.isEmpty(localSubAccountInfo.subuin)) {
        paramQQAppInterface = localSubAccountInfo.subuin;
      }
    }
    return paramQQAppInterface;
  }
  
  public String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ContactUtils.b(paramQQAppInterface, paramString, true);
  }
  
  public String a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    paramString1 = null;
    Object localObject = null;
    BaseApplication localBaseApplication = paramQQAppInterface.a();
    if (SystemMsg.isSystemMessage(paramInt)) {
      switch (paramInt)
      {
      default: 
        paramString1 = localObject;
      }
    }
    for (;;)
    {
      paramQQAppInterface = ContactUtils.b(paramQQAppInterface, paramString2, true);
      if ((paramQQAppInterface == null) || (paramQQAppInterface.trim().length() <= 0) || (paramQQAppInterface.equals(paramString2))) {
        break;
      }
      paramString2 = new StringBuilder();
      paramString2.append(paramQQAppInterface).append(paramString1);
      paramString1 = paramString2.toString();
      return paramString1;
      paramString1 = localBaseApplication.getString(2131561412);
      continue;
      paramString1 = localBaseApplication.getString(2131561403);
      continue;
      paramString1 = localBaseApplication.getString(2131561405);
      continue;
      paramString1 = localBaseApplication.getString(2131561407);
      continue;
      paramString1 = localBaseApplication.getString(2131561406);
    }
    return paramString2 + paramString1;
  }
  
  public String a(String paramString)
  {
    return SubAccountDataControll.a().a(paramString);
  }
  
  public List a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return SubAccountDataControll.a().b(paramQQAppInterface, paramString);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubAccountAssistantImpl", 2, "doSomething: test");
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (SubAccountProtocManager)paramQQAppInterface.getManager(25);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, byte paramByte, long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    paramQQAppInterface = (FriendListHandler)paramQQAppInterface.a(1);
    BindUin localBindUin;
    if (paramQQAppInterface != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubAccountAssistantImpl", 2, "setBindUinStatus status = " + paramInt);
      }
      localBindUin = new BindUin();
      localBindUin.iStatus = paramInt;
      localBindUin.lUin = paramLong;
      if (paramArrayOfByte != null) {
        break label107;
      }
    }
    label107:
    for (localBindUin.sKey = new byte[0];; localBindUin.sKey = paramArrayOfByte)
    {
      paramArrayOfByte = new ArrayList();
      paramArrayOfByte.add(localBindUin);
      paramQQAppInterface.a(paramByte, paramArrayOfByte);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramQQAppInterface == null) {}
    while (b(paramQQAppInterface)) {
      return;
    }
    ProxyManager localProxyManager = paramQQAppInterface.a();
    long l = SubAccountDataControll.a().a(paramQQAppInterface);
    if (l == 9223372036854775804L) {}
    while (l <= paramLong)
    {
      SubAccountAssistantManager.a().a(localProxyManager, paramLong);
      SubAccountDataControll.a().a(paramLong);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SubAccountMessage paramSubAccountMessage, String paramString)
  {
    if (paramSubAccountMessage != null) {
      SubAccountDataControll.a().a(paramQQAppInterface, paramSubAccountMessage, paramString);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      SubAccountDataControll.a().a(paramQQAppInterface);
    }
    while (paramQQAppInterface == null) {
      return;
    }
    SubAccountDataControll.a().c(paramQQAppInterface, paramString);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    if (paramQQAppInterface != null) {
      SubAccountDataControll.a().a(paramQQAppInterface, paramString1, paramInt, paramString2);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    SubAccountDataControll.a().a(paramQQAppInterface, paramString1, paramString2);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, byte[] paramArrayOfByte)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    SubAccountDataControll.a().a(paramQQAppInterface, paramString, paramArrayOfByte);
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    DBUtils.a().a(paramBoolean, paramQQAppInterface.getAccount(), paramQQAppInterface.a());
    ProxyManager localProxyManager = paramQQAppInterface.a();
    if (paramBoolean)
    {
      SubAccountAssistantManager.a().a(localProxyManager, 9223372036854775804L);
      SubAccountDataControll.a().a(9223372036854775804L);
    }
    for (;;)
    {
      paramQQAppInterface = paramQQAppInterface.a(Conversation.class);
      if (paramQQAppInterface == null) {
        break;
      }
      paramQQAppInterface.sendEmptyMessage(1009);
      return;
      long l2 = SubAccountDataControll.a().b(paramQQAppInterface);
      long l1;
      if (l2 != 0L)
      {
        l1 = l2;
        if (l2 != 9223372036854775804L) {}
      }
      else
      {
        l1 = System.currentTimeMillis() / 1000L;
      }
      SubAccountAssistantManager.a().a(localProxyManager, l1);
      SubAccountDataControll.a().a(l1);
    }
  }
  
  public void a(String paramString)
  {
    SubAccountDataControll.a().a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      SharedPreferences localSharedPreferences;
      do
      {
        return;
        localSharedPreferences = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
      } while (localSharedPreferences == null);
      paramString = "stick2top_" + paramString;
      paramInt += 1;
      localSharedPreferences.edit().putInt(paramString, paramInt).commit();
    } while (!QLog.isColorLevel());
    QLog.d("Q.subaccount.SubAccountAssistantImpl", 2, "set " + paramString + "=" + paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
    if (localSharedPreferences == null) {}
    do
    {
      return;
      localSharedPreferences.edit().putBoolean("hasShowBindDialog", paramBoolean).commit();
    } while (!QLog.isColorLevel());
    QLog.d("Q.subaccount.SubAccountAssistantImpl", 2, "setHasShowBindDialog:" + paramBoolean);
  }
  
  public boolean a()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
    boolean bool1;
    if (localSharedPreferences == null) {
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = localSharedPreferences.getBoolean("hasShowBindDialog", false);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("Q.subaccount.SubAccountAssistantImpl", 2, "hasShowBindDialog:" + bool2);
    return bool2;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null) {
      return SubAccountDataControll.a().a(paramQQAppInterface);
    }
    return false;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    Object localObject;
    if ((paramQQAppInterface == null) || (paramString == null)) {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("isSubAccountLogin app is null?=>");
        if (paramQQAppInterface != null) {
          break label81;
        }
        bool1 = true;
        paramQQAppInterface = ((StringBuilder)localObject).append(bool1).append(";subaccount is null?=>");
        if (paramString != null) {
          break label87;
        }
        bool1 = bool2;
        label64:
        QLog.d("Q.subaccount.SubAccountAssistantImpl", 2, bool1);
      }
    }
    label81:
    label87:
    do
    {
      return false;
      bool1 = false;
      break;
      bool1 = false;
      break label64;
      paramQQAppInterface = paramQQAppInterface.getApplication().getAllAccounts();
      if ((paramQQAppInterface != null) && (paramQQAppInterface.size() != 0)) {
        break label161;
      }
    } while (!QLog.isColorLevel());
    paramString = new StringBuilder().append("isSubAccountLogin tmpListSimpleAccount is null? =>");
    if (paramQQAppInterface == null) {}
    for (;;)
    {
      QLog.d("Q.subaccount.SubAccountAssistantImpl", 2, bool1);
      return false;
      bool1 = false;
    }
    label161:
    int i = 0;
    label163:
    if (i < paramQQAppInterface.size())
    {
      localObject = (SimpleAccount)paramQQAppInterface.get(i);
      if (localObject != null) {
        break label212;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.subaccount.SubAccountAssistantImpl", 2, "isSubAccountLogin sAccount == null");
      }
    }
    label212:
    label238:
    do
    {
      for (;;)
      {
        i += 1;
        break label163;
        break;
        if (((SimpleAccount)localObject).getUin() != null) {
          break label238;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.subaccount.SubAccountAssistantImpl", 2, "isSubAccountLogin sAccount.getUin() == null");
        }
      }
    } while ((!((SimpleAccount)localObject).getUin().equalsIgnoreCase(paramString)) || (!((SimpleAccount)localObject).isLogined()));
    return true;
  }
  
  public byte[] a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = SubAccountDataControll.a().a(paramQQAppInterface);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.cookie != null)) {
      return (byte[])paramQQAppInterface.cookie.clone();
    }
    return null;
  }
  
  public String b(QQAppInterface paramQQAppInterface)
  {
    return SubAccountDataControll.a().c(paramQQAppInterface);
  }
  
  public String b(QQAppInterface paramQQAppInterface, String paramString)
  {
    return SubAccountDataControll.a().b(paramString);
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null) {
      SubAccountDataControll.a().d(paramQQAppInterface, null);
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (SubAccountProtocManager)paramQQAppInterface.getManager(25);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(paramString);
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    paramQQAppInterface = (SubAccountProtocManager)paramQQAppInterface.getManager(25);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(paramString1, paramString2);
    }
  }
  
  public void b(String paramString)
  {
    SubAccountDataControll.a().b(paramString);
  }
  
  public boolean b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return DBUtils.a().b(paramQQAppInterface.getAccount(), paramQQAppInterface.a());
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    boolean bool = DBUtils.a().a(paramQQAppInterface.getAccount(), paramQQAppInterface.a());
    Object localObject;
    String str;
    BaseApplication localBaseApplication;
    if (!bool)
    {
      localObject = DBUtils.a();
      str = paramQQAppInterface.getAccount();
      localBaseApplication = paramQQAppInterface.a();
      if (bool) {
        break label102;
      }
    }
    label102:
    for (bool = true;; bool = false)
    {
      ((DBUtils)localObject).a(str, localBaseApplication, bool);
      localObject = paramQQAppInterface.a();
      SubAccountAssistantManager.a().a((ProxyManager)localObject, System.currentTimeMillis() / 1000L);
      SubAccountDataControll.a().b(paramQQAppInterface);
      paramQQAppInterface = paramQQAppInterface.a(Conversation.class);
      if (paramQQAppInterface == null) {
        break;
      }
      paramQQAppInterface.sendEmptyMessage(1009);
      return;
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString))) {
      SubAccountDataControll.a().d(paramQQAppInterface, paramString);
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    SubAccountDataControll.a().a(paramQQAppInterface, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.SubAccountAssistantImpl
 * JD-Core Version:    0.7.0.1
 */