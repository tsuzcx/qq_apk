package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.QQToast;
import dur;
import dus;
import dut;
import duu;
import duv;
import duw;
import dux;
import duy;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class FMToastUtil
{
  private static int jdField_a_of_type_Int = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131492887) - (int)DisplayUtils.a(BaseApplicationImpl.getContext(), 5.0F);
  private static Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private static final int jdField_b_of_type_Int = 2000;
  private static Map jdField_b_of_type_JavaUtilMap;
  
  static
  {
    b = new HashMap();
  }
  
  public static void a(int paramInt)
  {
    if (((QQAppInterface)BaseApplicationImpl.a.a()).isBackground_Pause) {}
    while (!a(paramInt)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new dur(paramInt));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, paramInt, 0).b(jdField_a_of_type_Int);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (((QQAppInterface)BaseApplicationImpl.a.a()).isBackground_Pause) {}
    while (!a(paramInt2)) {
      return;
    }
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread())
    {
      new Handler((Looper)localObject).post(new duy(paramInt2));
      return;
    }
    localObject = new QQToast(BaseApplicationImpl.getContext());
    ((QQToast)localObject).a(2130837966);
    ((QQToast)localObject).c(3000);
    ((QQToast)localObject).b(paramInt2);
    ((QQToast)localObject).b(jdField_a_of_type_Int);
  }
  
  public static void a(String paramString)
  {
    if (BaseApplicationImpl.a.a().isBackground_Pause) {}
    while (!a(paramString)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new dus(paramString));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, paramString, 0).b(jdField_a_of_type_Int);
  }
  
  private static boolean a(int paramInt)
  {
    if (jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt)))
    {
      long l1 = ((Long)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt))).longValue();
      long l2 = SystemClock.uptimeMillis();
      if (l1 + 2000L < l2)
      {
        jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Long.valueOf(l2));
        return true;
      }
    }
    else
    {
      jdField_a_of_type_JavaUtilMap.clear();
      jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Long.valueOf(SystemClock.uptimeMillis()));
      return true;
    }
    return false;
  }
  
  private static boolean a(String paramString)
  {
    if (b.containsKey(paramString))
    {
      long l1 = ((Long)b.get(paramString)).longValue();
      long l2 = SystemClock.uptimeMillis();
      if (l1 + 2000L < l2)
      {
        b.put(paramString, Long.valueOf(l2));
        return true;
      }
    }
    else
    {
      b.clear();
      b.put(paramString, Long.valueOf(SystemClock.uptimeMillis()));
      return true;
    }
    return false;
  }
  
  public static void b(int paramInt)
  {
    if (((QQAppInterface)BaseApplicationImpl.a.a()).isBackground_Pause) {}
    while (!a(paramInt)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new dut(paramInt));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2, paramInt, 0).b(jdField_a_of_type_Int);
  }
  
  public static void b(String paramString)
  {
    if (((QQAppInterface)BaseApplicationImpl.a.a()).isBackground_Pause) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new duu(paramString));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2, paramString, 0).b(jdField_a_of_type_Int);
  }
  
  public static void c(int paramInt)
  {
    if (((QQAppInterface)BaseApplicationImpl.a.a()).isBackground_Pause) {}
    while (!a(paramInt)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new duw(paramInt));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 0, paramInt, 0).b(jdField_a_of_type_Int);
  }
  
  public static void c(String paramString)
  {
    if (((QQAppInterface)BaseApplicationImpl.a.a()).isBackground_Pause) {}
    while (!a(paramString)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new duv(paramString));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2, paramString, 1).b(jdField_a_of_type_Int);
  }
  
  public static void d(int paramInt)
  {
    if (((QQAppInterface)BaseApplicationImpl.a.a()).isBackground_Pause) {}
    while (!a(paramInt)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new dux(paramInt));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), -1, paramInt, 0).b(jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FMToastUtil
 * JD-Core Version:    0.7.0.1
 */