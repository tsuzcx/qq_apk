package com.tencent.biz.troop;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import btk;
import btl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TroopMemberApiClient
{
  private static TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  static final String jdField_a_of_type_JavaLangString = "com.tencent.biz.troop.TroopMemberApiClient";
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new btk(this);
  public final Messenger a;
  public BizTroopObserver a;
  public List a;
  public Map a;
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public Messenger b;
  public List b;
  AtomicInteger b;
  
  private TroopMemberApiClient()
  {
    this.jdField_a_of_type_AndroidOsMessenger = new Messenger(new btl(this));
    this.jdField_b_of_type_AndroidOsMessenger = null;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  public static TroopMemberApiClient a()
  {
    if (jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null) {
        jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = new TroopMemberApiClient();
      }
      return jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
    }
    finally {}
  }
  
  private void a(int paramInt, Bundle paramBundle)
  {
    Message localMessage = Message.obtain(null, paramInt);
    localMessage.setData(paramBundle);
    if (this.jdField_b_of_type_AndroidOsMessenger == null) {
      try
      {
        this.jdField_b_of_type_JavaUtilList.add(localMessage);
        return;
      }
      finally {}
    }
    try
    {
      this.jdField_b_of_type_AndroidOsMessenger.send(localMessage);
      return;
    }
    catch (RemoteException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndAdd(1) == 0)
    {
      Context localContext = BaseApplicationImpl.getContext();
      localContext.bindService(new Intent(localContext, TroopMemberApiService.class), this.jdField_a_of_type_AndroidContentServiceConnection, 1);
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.troop.TroopMemberApiClient", 2, "Binding...");
      }
    }
  }
  
  public void a(long paramLong, long[] paramArrayOfLong, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopUin", paramLong);
    localBundle.putLongArray("uinsToDelete", paramArrayOfLong);
    localBundle.putBoolean("isBlack", paramBoolean);
    a(6, localBundle);
  }
  
  public void a(BizTroopObserver paramBizTroopObserver)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = paramBizTroopObserver;
  }
  
  public void a(TroopObserver paramTroopObserver)
  {
    if (paramTroopObserver == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("com.tencent.biz.troop.TroopMemberApiClient", 2, "RegisterObserver key:" + paramTroopObserver.hashCode());
      }
    } while (this.jdField_a_of_type_JavaUtilList.contains(paramTroopObserver));
    this.jdField_a_of_type_JavaUtilList.add(paramTroopObserver);
  }
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("groupCode", paramString);
    a(7, localBundle);
  }
  
  public void a(String paramString, TroopMemberApiClient.Callback paramCallback)
  {
    int i = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", i);
    localBundle.putString("troopUin", paramString);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramCallback);
    a(8, localBundle);
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    int i = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", i);
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("memberUin", paramString2);
    localBundle.putLong("seconds", paramLong);
    a(10, localBundle);
  }
  
  public void a(String paramString1, String paramString2, TroopMemberApiClient.Callback paramCallback)
  {
    int i = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", i);
    localBundle.putString("troopUin", paramString2);
    localBundle.putString("memberUin", paramString1);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramCallback);
    a(11, localBundle);
  }
  
  public void a(List paramList, TroopMemberApiClient.Callback paramCallback)
  {
    int j = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    Bundle localBundle1 = new Bundle();
    localBundle1.putInt("seq", j);
    Bundle[] arrayOfBundle = new Bundle[paramList.size()];
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)paramList.next();
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("uin", localTroopMemberInfo.memberuin);
      localBundle2.putString("troopnick", localTroopMemberInfo.troopnick);
      localBundle2.putString("autoremark", localTroopMemberInfo.autoremark);
      localBundle2.putString("friendnick", localTroopMemberInfo.friendnick);
      localBundle2.putString("troopuin", localTroopMemberInfo.troopuin);
      localBundle2.putInt("level", localTroopMemberInfo.level);
      arrayOfBundle[i] = localBundle2;
      i += 1;
    }
    localBundle1.putParcelableArray("list", arrayOfBundle);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(j), paramCallback);
    a(9, localBundle1);
  }
  
  public void a(boolean paramBoolean, long paramLong, long[] paramArrayOfLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isAdd", paramBoolean);
    localBundle.putLong("troopUin", paramLong);
    localBundle.putLongArray("uinsToFocus", paramArrayOfLong);
    a(5, localBundle);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("refresh", paramBoolean);
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("troopCode", paramString2);
    a(4, localBundle);
  }
  
  public void b()
  {
    Context localContext;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(-1) == 0)
    {
      localContext = BaseApplicationImpl.getContext();
      if (this.jdField_b_of_type_AndroidOsMessenger == null) {}
    }
    try
    {
      Message localMessage = Message.obtain(null, 2);
      this.jdField_b_of_type_AndroidOsMessenger.send(localMessage);
      label36:
      localContext.unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
      this.jdField_b_of_type_AndroidOsMessenger = null;
      try
      {
        this.jdField_b_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilMap.clear();
        if (QLog.isColorLevel()) {
          QLog.i("com.tencent.biz.troop.TroopMemberApiClient", 2, "Unbinding...");
        }
        return;
      }
      finally {}
    }
    catch (RemoteException localRemoteException)
    {
      break label36;
    }
  }
  
  public void b(TroopObserver paramTroopObserver)
  {
    if (paramTroopObserver == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("com.tencent.biz.troop.TroopMemberApiClient", 2, "unRegisterObserver key:" + paramTroopObserver.hashCode());
      }
    } while (!this.jdField_a_of_type_JavaUtilList.contains(paramTroopObserver));
    this.jdField_a_of_type_JavaUtilList.remove(paramTroopObserver);
  }
  
  public void b(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("video_url", paramString);
    a(13, localBundle);
  }
  
  public void b(String paramString, TroopMemberApiClient.Callback paramCallback)
  {
    int i = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    Bundle localBundle = new Bundle();
    localBundle.putString("video_url", paramString);
    localBundle.putInt("seq", i);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramCallback);
    a(12, localBundle);
  }
  
  public void c()
  {
    a(22, null);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiClient
 * JD-Core Version:    0.7.0.1
 */