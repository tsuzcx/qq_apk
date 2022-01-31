package com.tencent.mobileqq.equipmentlock;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.observer.WtloginObserver;

public abstract interface EquipmentLockInterface
{
  public static final int c = -1;
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 90000;
  public static final int g = 80000;
  public static final int h = 80001;
  public static final int i = 59555;
  public static final int j = 59556;
  public static final int k = 59557;
  public static final int l = 59558;
  
  public abstract int a(QQAppInterface paramQQAppInterface, Context paramContext);
  
  public abstract int a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, boolean paramBoolean);
  
  public abstract int a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, byte[] paramArrayOfByte, WtloginObserver paramWtloginObserver);
  
  public abstract int a(QQAppInterface paramQQAppInterface, String paramString, WtloginObserver paramWtloginObserver);
  
  public abstract int a(QQAppInterface paramQQAppInterface, String paramString, byte[] paramArrayOfByte, WtloginObserver paramWtloginObserver);
  
  public abstract int a(QQAppInterface paramQQAppInterface, VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver);
  
  public abstract int a(String paramString);
  
  public abstract int a(AppRuntime paramAppRuntime, VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver);
  
  public abstract int a(AppRuntime paramAppRuntime, VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver, String paramString);
  
  public abstract String a();
  
  public abstract boolean a(QQAppInterface paramQQAppInterface, long paramLong, byte paramByte, byte[] paramArrayOfByte, int paramInt);
  
  public abstract boolean a(QQAppInterface paramQQAppInterface, String paramString, long paramLong);
  
  public abstract boolean a(QQAppInterface paramQQAppInterface, String paramString, ArrayList paramArrayList, int paramInt);
  
  public abstract boolean a(QQAppInterface paramQQAppInterface, String paramString, ArrayList paramArrayList, int paramInt, boolean paramBoolean, long paramLong);
  
  public abstract int b(QQAppInterface paramQQAppInterface, String paramString, WtloginObserver paramWtloginObserver);
  
  public abstract boolean b();
  
  public abstract boolean b(QQAppInterface paramQQAppInterface, String paramString, long paramLong);
  
  public abstract int c(QQAppInterface paramQQAppInterface, String paramString, WtloginObserver paramWtloginObserver);
  
  public abstract boolean c(QQAppInterface paramQQAppInterface, String paramString, long paramLong);
  
  public abstract int d(QQAppInterface paramQQAppInterface, String paramString, WtloginObserver paramWtloginObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.equipmentlock.EquipmentLockInterface
 * JD-Core Version:    0.7.0.1
 */