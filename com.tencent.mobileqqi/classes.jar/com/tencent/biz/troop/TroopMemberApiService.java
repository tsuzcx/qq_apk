package com.tencent.biz.troop;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import btv;
import btw;
import btx;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppService;

public class TroopMemberApiService
  extends AppService
{
  public static final int a = 1;
  static final String jdField_a_of_type_JavaLangString = "com.tencent.biz.troop.TroopMemberApiService";
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 8;
  public static final int i = 9;
  public static final int j = 10;
  public static final int k = 11;
  public static final int l = 12;
  public static final int m = 13;
  public static final int n = 22;
  final Messenger jdField_a_of_type_AndroidOsMessenger = new Messenger(new btx(this));
  public BizTroopHandler a;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new btw(this);
  public QQMapActivityProxy a;
  public TroopHandler a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new btv(this);
  public Messenger b = null;
  
  public TroopMemberApiService()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = null;
  }
  
  public static Bundle a(TroopInfo paramTroopInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopowneruin", paramTroopInfo.troopowneruin);
    localBundle.putString("Administrator", paramTroopInfo.Administrator);
    localBundle.putString("troopuin", paramTroopInfo.troopuin);
    localBundle.putString("troopcode", paramTroopInfo.troopcode);
    localBundle.putString("troopname", paramTroopInfo.troopname);
    localBundle.putShort("troopface", paramTroopInfo.troopface);
    localBundle.putString("fingertroopmemo", paramTroopInfo.fingertroopmemo);
    localBundle.putLong("dwGroupClassExt", paramTroopInfo.dwGroupClassExt);
    localBundle.putInt("wMemberNum", paramTroopInfo.wMemberNum);
    localBundle.putString("strLocation", paramTroopInfo.strLocation);
    return localBundle;
  }
  
  public static TroopInfo a(Bundle paramBundle)
  {
    TroopInfo localTroopInfo = new TroopInfo();
    localTroopInfo.troopowneruin = paramBundle.getString("troopowneruin");
    localTroopInfo.Administrator = paramBundle.getString("Administrator");
    localTroopInfo.troopuin = paramBundle.getString("troopuin");
    localTroopInfo.troopcode = paramBundle.getString("troopcode");
    localTroopInfo.troopname = paramBundle.getString("troopname");
    localTroopInfo.troopface = paramBundle.getShort("troopface");
    localTroopInfo.fingertroopmemo = paramBundle.getString("fingertroopmemo");
    localTroopInfo.dwGroupClassExt = paramBundle.getLong("dwGroupClassExt");
    localTroopInfo.wMemberNum = paramBundle.getInt("wMemberNum");
    localTroopInfo.strLocation = paramBundle.getString("strLocation");
    return localTroopInfo;
  }
  
  private void a(int paramInt, Bundle paramBundle)
  {
    Message localMessage = Message.obtain(null, paramInt);
    localMessage.setData(paramBundle);
    paramBundle = this.b;
    if (paramBundle != null) {}
    try
    {
      paramBundle.send(localMessage);
      return;
    }
    catch (RemoteException paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("com.tencent.biz.troop.TroopMemberApiService", 2, "messeage not sent:" + paramBundle.getMessage());
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "MessengerService onBind");
    }
    return this.jdField_a_of_type_AndroidOsMessenger.getBinder();
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "MessengerService onCreate");
    }
    super.onCreate();
    if ((this.app instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)((QQAppInterface)this.app).a(19));
      ((QQAppInterface)this.app).a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler = ((BizTroopHandler)((QQAppInterface)this.app).a(21));
      ((QQAppInterface)this.app).a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver, true);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "MessengerService onDestroy");
    }
    super.onDestroy();
    if ((this.app instanceof QQAppInterface)) {
      ((QQAppInterface)this.app).c(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
    this.app = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService
 * JD-Core Version:    0.7.0.1
 */