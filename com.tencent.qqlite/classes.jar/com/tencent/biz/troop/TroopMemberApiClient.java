package com.tencent.biz.troop;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.biz.apiproxy.QQMusicClient;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import qw;
import qx;

public class TroopMemberApiClient
{
  private static TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  static final String jdField_a_of_type_JavaLangString = "com.tencent.biz.troop.TroopMemberApiClient";
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new qw(this);
  public final Messenger a;
  QQMusicClient jdField_a_of_type_ComTencentBizApiproxyQQMusicClient;
  public BizTroopObserver a;
  public List a;
  public Map a;
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public Messenger b;
  public List b;
  AtomicInteger b;
  
  private TroopMemberApiClient()
  {
    this.jdField_a_of_type_AndroidOsMessenger = new Messenger(new qx(this));
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
  
  public int a(TroopMemberApiClient.Callback paramCallback)
  {
    int i = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramCallback);
    return i;
  }
  
  public QQMusicClient a()
  {
    if (this.jdField_a_of_type_ComTencentBizApiproxyQQMusicClient == null) {
      this.jdField_a_of_type_ComTencentBizApiproxyQQMusicClient = new QQMusicClient(this);
    }
    return this.jdField_a_of_type_ComTencentBizApiproxyQQMusicClient;
  }
  
  public TroopMemberApiClient.Callback a(int paramInt)
  {
    return (TroopMemberApiClient.Callback)this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt));
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
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("lat", paramInt1);
    localBundle.putInt("lon", paramInt2);
    localBundle.putInt("radius", paramInt3);
    localBundle.putBoolean("isClickable", paramBoolean);
    localBundle.putString("methord_name", "getAreaList");
    a(9, localBundle);
  }
  
  public void a(int paramInt, Bundle paramBundle)
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
  
  public void a(BizTroopObserver paramBizTroopObserver)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = paramBizTroopObserver;
  }
  
  public void a(BusinessObserver paramBusinessObserver)
  {
    if (paramBusinessObserver == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("com.tencent.biz.troop.TroopMemberApiClient", 2, "RegisterObserver key:" + paramBusinessObserver.hashCode());
      }
    } while (this.jdField_a_of_type_JavaUtilList.contains(paramBusinessObserver));
    this.jdField_a_of_type_JavaUtilList.add(paramBusinessObserver);
  }
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("video_url", paramString);
    a(5, localBundle);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("areaName", paramString);
    localBundle.putInt("lat", paramInt1);
    localBundle.putInt("lon", paramInt2);
    localBundle.putInt("startIndex", paramInt3);
    localBundle.putInt("count", paramInt4);
    localBundle.putString("methord_name", "getGroupInArea");
    a(9, localBundle);
  }
  
  public void a(String paramString1, long paramLong, int paramInt1, String paramString2, int paramInt2, TroopMemberApiClient.Callback paramCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putLong("bubbleId", paramLong);
    localBundle.putInt("headId", paramInt1);
    localBundle.putString("nickName", paramString2);
    localBundle.putInt("expireTime", paramInt2);
    localBundle.putInt("seq", a(paramCallback));
    a(13, localBundle);
  }
  
  public void a(String paramString, TroopMemberApiClient.Callback paramCallback)
  {
    int i = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    Bundle localBundle = new Bundle();
    localBundle.putString("video_url", paramString);
    localBundle.putInt("seq", i);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramCallback);
    a(4, localBundle);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("gcode", paramString1);
    localBundle.putString("anId", paramString2);
    a(7, localBundle);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isFirst", paramBoolean);
    localBundle.putInt("lat", paramInt1);
    localBundle.putInt("lon", paramInt2);
    localBundle.putInt("sortType", paramInt3);
    localBundle.putString("strGroupArea", paramString);
    localBundle.putString("methord_name", "getNearbyTroops");
    a(9, localBundle);
  }
  
  public void a(String[] paramArrayOfString, TroopMemberApiClient.Callback paramCallback)
  {
    int i = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    Bundle localBundle = new Bundle();
    localBundle.putStringArray("paths", paramArrayOfString);
    localBundle.putInt("seq", i);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramCallback);
    a(11, localBundle);
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
  
  public void b(BusinessObserver paramBusinessObserver)
  {
    if (paramBusinessObserver == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("com.tencent.biz.troop.TroopMemberApiClient", 2, "unRegisterObserver key:" + paramBusinessObserver.hashCode());
      }
    } while (!this.jdField_a_of_type_JavaUtilList.contains(paramBusinessObserver));
    this.jdField_a_of_type_JavaUtilList.remove(paramBusinessObserver);
  }
  
  public void b(String paramString)
  {
    int i = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    Bundle localBundle = new Bundle();
    localBundle.putString("path", paramString);
    localBundle.putInt("seq", i);
    a(12, localBundle);
  }
  
  public void c()
  {
    a(6, null);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiClient
 * JD-Core Version:    0.7.0.1
 */