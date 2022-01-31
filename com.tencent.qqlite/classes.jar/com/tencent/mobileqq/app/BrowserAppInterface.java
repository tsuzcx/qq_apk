package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.format.Time;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cqi;
import cqj;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

public class BrowserAppInterface
  extends AppInterface
{
  public static final String b = BrowserAppInterface.class.getSimpleName();
  long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new cqi(this);
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  protected final Object a;
  
  public BrowserAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    this.jdField_a_of_type_JavaLangObject = new Object();
  }
  
  private SharedPreferences a()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = PreferenceManager.getDefaultSharedPreferences(a());
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences;
  }
  
  public static String a(ArrayList paramArrayList, boolean paramBoolean)
  {
    Time localTime = new Time();
    localTime.setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(localTime.year).append(localTime.month + 1).append(localTime.monthDay);
    localStringBuilder.append(localTime.hour);
    if (paramBoolean)
    {
      localStringBuilder.append(localTime.minute - 1);
      if (paramArrayList != null) {
        break label134;
      }
    }
    label134:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = MD5.toMD5(localStringBuilder.toString());
      return MD5.toMD5(paramArrayList + localStringBuilder.toString());
      localStringBuilder.append(localTime.minute);
      break;
    }
  }
  
  private void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.process.exit");
    localIntentFilter.addAction("mqql.intent.action.EXIT_" + this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName());
    localIntentFilter.addAction("mqql.intent.action.LOGOUT");
    localIntentFilter.addAction("mqql.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqql.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqql.intent.action.ACCOUNT_EXPIRED");
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  public static boolean a(String paramString, ArrayList paramArrayList)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while ((!paramString.equals(a(paramArrayList, false))) && (!paramString.equals(a(paramArrayList, true)))) {
      return false;
    }
    return true;
  }
  
  public static boolean a(ArrayList paramArrayList, Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      bool1 = true;
      return bool1;
    }
    paramContext = MobileQQ.getMobileQQ().getProcessName();
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= paramArrayList.size()) {
        break;
      }
      if (paramContext.equals(paramArrayList.get(i))) {
        return true;
      }
      i += 1;
    }
  }
  
  private void b()
  {
    new cqj(this).start();
  }
  
  public int a()
  {
    return 0;
  }
  
  public EntityManagerFactory a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = new QQEntityManagerFactory(getAccount());
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  }
  
  public BaseApplication a()
  {
    return this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  }
  
  public String a()
  {
    return getAccount();
  }
  
  public void a(boolean paramBoolean)
  {
    a().edit().putBoolean(a().getString(2131363055) + a(), paramBoolean).commit();
  }
  
  public final boolean a()
  {
    return a().getBoolean(a().getString(2131363055) + a(), false);
  }
  
  public String b()
  {
    return ((TicketManager)getManager(2)).getVkey(getAccount());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(b, 2, "unregisterReceiver: ", localIllegalArgumentException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BrowserAppInterface
 * JD-Core Version:    0.7.0.1
 */