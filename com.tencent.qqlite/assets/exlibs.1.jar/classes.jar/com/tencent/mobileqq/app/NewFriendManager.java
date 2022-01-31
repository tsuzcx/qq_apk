package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.newfriend.NewFriendPushListener;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import cub;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Set;
import java.util.TreeSet;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class NewFriendManager
  extends Observable
  implements Manager
{
  public static final int a = 2130838054;
  public static final String a = "新朋友";
  public static final String b = "_" + "data_spliter".hashCode() + "_";
  private static final String c = "NewFriendManager";
  private static final String d = "new_friend_recent_deleted";
  public QQAppInterface a;
  private NewFriendPushListener jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendPushListener;
  Set jdField_a_of_type_JavaUtilSet = new TreeSet();
  
  public NewFriendManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_JavaUtilSet == null) {
      this.jdField_a_of_type_JavaUtilSet = new TreeSet();
    }
  }
  
  private int a(RecentUser paramRecentUser)
  {
    if ((paramRecentUser.msg != null) && ((paramRecentUser.msg instanceof String)))
    {
      paramRecentUser = (String)paramRecentUser.msg;
      int i = paramRecentUser.indexOf(b);
      if (i >= 0) {
        return Integer.valueOf(paramRecentUser.substring(i + b.length())).intValue();
      }
    }
    return 0;
  }
  
  private NewFriendMessage a(int paramInt)
  {
    Object localObject1 = null;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilSet)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
        if (localIterator.hasNext())
        {
          NewFriendMessage localNewFriendMessage = (NewFriendMessage)localIterator.next();
          if (localNewFriendMessage.n == paramInt) {
            localObject1 = localNewFriendMessage;
          }
        }
        else
        {
          if (localObject1 != null) {
            this.jdField_a_of_type_JavaUtilSet.remove(localObject1);
          }
          return localObject1;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface.getApplication().getSharedPreferences("new_friend_recent_deleted" + paramQQAppInterface.getAccount(), 0).edit().putBoolean("new_friend_recent_deleted", paramBoolean).commit();
  }
  
  private void a(RecentUser paramRecentUser, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendManager", 2, "resetRecentUserUnreadCount | count = " + paramInt);
    }
    if ((paramRecentUser.msg != null) && ((paramRecentUser.msg instanceof String)))
    {
      String str = (String)paramRecentUser.msg;
      int i = str.indexOf(b);
      if (i >= 0)
      {
        str = str.substring(0, i + b.length());
        if (QLog.isColorLevel()) {
          QLog.d("NewFriendManager", 2, "resetRecentUserUnreadCount | temp str = " + str);
        }
        paramRecentUser.msg = (str + paramInt);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendManager", 2, "resetRecentUserUnreadCount | ru.msg = " + paramRecentUser.msg);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return paramQQAppInterface.getApplication().getSharedPreferences("new_friend_recent_deleted" + paramQQAppInterface.getAccount(), 0).getBoolean("new_friend_recent_deleted", false);
  }
  
  private boolean a(NewFriendMessage paramNewFriendMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    RecentUserProxy localRecentUserProxy;
    do
    {
      return false;
      localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    } while ((paramNewFriendMessage == null) || (localRecentUserProxy == null) || (paramNewFriendMessage.jdField_a_of_type_Boolean) || ((paramNewFriendMessage.o == 0) && (!localRecentUserProxy.a(AppConstants.V, 4000))));
    return true;
  }
  
  private NewFriendMessage b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilSet)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        NewFriendMessage localNewFriendMessage = (NewFriendMessage)localIterator.next();
        if (localNewFriendMessage != null) {
          return localNewFriendMessage;
        }
      }
      return null;
    }
  }
  
  private NewFriendMessage b(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilSet)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        NewFriendMessage localNewFriendMessage = (NewFriendMessage)localIterator.next();
        if (localNewFriendMessage.n == paramInt) {
          return localNewFriendMessage;
        }
      }
      return null;
    }
  }
  
  private void b(NewFriendMessage paramNewFriendMessage)
  {
    if (paramNewFriendMessage.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      c(paramNewFriendMessage);
    } while (this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendPushListener == null);
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendManager", 2, "notifyNewMessage is init msg = " + paramNewFriendMessage.jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendPushListener.a(null);
  }
  
  private void c(NewFriendMessage paramNewFriendMessage)
  {
    if (!a(paramNewFriendMessage)) {}
    RecentUserProxy localRecentUserProxy;
    RecentUser localRecentUser;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendManager", 2, "refreshRecentData | isShouldCreateOrGetRecentUser = true");
      }
      paramNewFriendMessage = b();
      localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localRecentUser = localRecentUserProxy.a(AppConstants.V, 4000);
      if ((localRecentUser.msg == null) || ((localRecentUser.msg instanceof String))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("NewFriendManager", 2, "wrong ru.msg error | type is :" + localRecentUser.msg.getClass().toString());
    return;
    localRecentUser.msgType = 5;
    localRecentUser.displayName = "新朋友";
    Object localObject;
    if (paramNewFriendMessage == null)
    {
      a(localRecentUser, 0);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("refreshRecentData | ru.msg = ").append(localRecentUser.msg).append("msgType = ");
        if (paramNewFriendMessage == null) {
          break label416;
        }
      }
    }
    label414:
    label416:
    for (paramNewFriendMessage = Integer.valueOf(paramNewFriendMessage.n);; paramNewFriendMessage = "null")
    {
      QLog.d("NewFriendManager", 2, paramNewFriendMessage);
      localRecentUserProxy.a(localRecentUser);
      return;
      if (localRecentUser.lastmsgtime < paramNewFriendMessage.jdField_a_of_type_Long) {
        localRecentUser.lastmsgtime = paramNewFriendMessage.jdField_a_of_type_Long;
      }
      if ((paramNewFriendMessage.n == 1) && (TextUtils.isEmpty(paramNewFriendMessage.jdField_a_of_type_JavaLangString)) && (localRecentUser.msg != null))
      {
        int i = ((String)localRecentUser.msg).indexOf(b);
        if (i >= 0)
        {
          localObject = ((String)localRecentUser.msg).substring(0, i + b.length());
          if (QLog.isColorLevel()) {
            QLog.d("NewFriendManager", 2, "resetRecentUserUnreadCount | temp str = " + (String)localObject);
          }
        }
      }
      for (localRecentUser.msg = ((String)localObject + a());; localRecentUser.msg = (paramNewFriendMessage.jdField_a_of_type_JavaLangString + b + a()))
      {
        if (localRecentUser.msgData != null) {
          break label414;
        }
        localRecentUser.msgData = String.valueOf(localRecentUser.msg).getBytes();
        break;
      }
      break;
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    c();
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new cub(this));
  }
  
  public int a()
  {
    int i = 0;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilSet)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
        if (localIterator.hasNext())
        {
          NewFriendMessage localNewFriendMessage = (NewFriendMessage)localIterator.next();
          if (localNewFriendMessage != null) {
            i = localNewFriendMessage.d() + i;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("NewFriendManager", 2, "getUnreadMessageCount = " + i);
          }
          return i;
        }
      }
    }
  }
  
  public int a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilSet)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        NewFriendMessage localNewFriendMessage = (NewFriendMessage)localIterator.next();
        if ((localNewFriendMessage != null) && (localNewFriendMessage.b() == paramInt))
        {
          paramInt = localNewFriendMessage.d();
          return paramInt;
        }
      }
      return 0;
    }
  }
  
  public NewFriendMessage a()
  {
    return b();
  }
  
  public void a()
  {
    notifyObservers(null);
  }
  
  public void a(NewFriendMessage paramNewFriendMessage)
  {
    if (paramNewFriendMessage == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendManager", 2, "showNewMessage msg count is:" + paramNewFriendMessage.d() + "   msg type is" + paramNewFriendMessage.b());
      }
    } while (paramNewFriendMessage.n > 1);
    synchronized (this.jdField_a_of_type_JavaUtilSet)
    {
      this.jdField_a_of_type_JavaUtilSet.remove(paramNewFriendMessage);
      if (paramNewFriendMessage.d() > 0) {
        this.jdField_a_of_type_JavaUtilSet.add(paramNewFriendMessage);
      }
      b(paramNewFriendMessage);
      setChanged();
      notifyObservers(paramNewFriendMessage);
      return;
    }
  }
  
  public void a(NewFriendPushListener paramNewFriendPushListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendPushListener = paramNewFriendPushListener;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendPushListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendPushListener.a(null);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    RecentUserProxy localRecentUserProxy;
    RecentUser localRecentUser;
    do
    {
      return;
      localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localRecentUser = localRecentUserProxy.b(AppConstants.V, 4000);
    } while (localRecentUser == null);
    localRecentUserProxy.b(localRecentUser);
  }
  
  public void d()
  {
    boolean bool = true;
    Object localObject1 = a(0);
    Object localObject2 = b(1);
    RecentUser localRecentUser;
    if (localObject2 != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localRecentUser = ((RecentUserProxy)localObject1).b(AppConstants.V, 4000);
      if (localRecentUser != null)
      {
        a(localRecentUser, ((NewFriendMessage)localObject2).o);
        b();
        ((RecentUserProxy)localObject1).a(localRecentUser);
      }
    }
    do
    {
      do
      {
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)) {
          break;
        }
      } while (!QLog.isColorLevel());
      localObject1 = new StringBuilder().append("handleDeleteRecommend | warning!!!! app = null is ");
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
      for (;;)
      {
        QLog.d("NewFriendManager", 2, bool);
        return;
        bool = false;
      }
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.ad, 0);
      if ((localObject3 == null) || (((List)localObject3).size() <= 0))
      {
        c();
        return;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localRecentUser = ((RecentUserProxy)localObject2).b(AppConstants.V, 4000);
    } while (localRecentUser == null);
    localRecentUser.msgType = 5;
    localRecentUser.displayName = "新朋友";
    Object localObject3 = (MessageForSystemMsg)((List)localObject3).get(((List)localObject3).size() - 1);
    int j = a(localRecentUser);
    int i = j;
    if (localObject1 != null) {
      i = j - ((NewFriendMessage)localObject1).o;
    }
    localRecentUser.msg = (((MessageForSystemMsg)localObject3).extStr + b + Math.max(i, 0));
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendManager", 2, "handleDeleteRecommend | system msg != null  ru.msg = " + localRecentUser.msg);
    }
    b();
    ((RecentUserProxy)localObject2).a(localRecentUser);
  }
  
  public void e()
  {
    Object localObject = b(0);
    if (localObject != null)
    {
      b((NewFriendMessage)localObject);
      setChanged();
      notifyObservers(localObject);
      return;
    }
    localObject = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    c();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilSet.clear();
    RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    RecentUser localRecentUser = localRecentUserProxy.a(AppConstants.V, 4000);
    if (localRecentUser != null)
    {
      a(localRecentUser, 0);
      localRecentUserProxy.a(localRecentUser);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendPushListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendPushListener.a(null);
    }
    k();
  }
  
  public void g()
  {
    this.jdField_a_of_type_JavaUtilSet.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendPushListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendPushListener.a(null);
    }
    k();
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_JavaUtilSet != null) {
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
    ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).j();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b();
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_JavaUtilSet != null) {
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.w();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendManager", 2, "onDestroy");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendPushListener = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.NewFriendManager
 * JD-Core Version:    0.7.0.1
 */