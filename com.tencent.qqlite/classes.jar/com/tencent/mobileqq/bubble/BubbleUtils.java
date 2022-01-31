package com.tencent.mobileqq.bubble;

import android.content.res.Resources;
import android.os.SystemClock;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class BubbleUtils
{
  public static final int a = 0;
  public static BubbleInfo a = new BubbleInfo(0);
  
  public static BubbleInfo a(int paramInt, QQAppInterface paramQQAppInterface, Resources paramResources, BaseAdapter paramBaseAdapter)
  {
    return a(paramInt, paramQQAppInterface, paramResources, paramBaseAdapter, true);
  }
  
  public static BubbleInfo a(int paramInt, QQAppInterface paramQQAppInterface, Resources paramResources, BaseAdapter paramBaseAdapter, boolean paramBoolean)
  {
    long l = SystemClock.elapsedRealtime();
    if (paramInt < 1) {
      paramQQAppInterface = a;
    }
    do
    {
      return paramQQAppInterface;
      paramResources = ((BubbleManager)paramQQAppInterface.getManager(40)).a(paramInt, paramBoolean);
      if (paramResources == null) {
        break;
      }
      paramQQAppInterface = paramResources;
    } while (!QLog.isColorLevel());
    QLog.d("bubble_performance", 2, "getBubbleInfo time " + (SystemClock.elapsedRealtime() - l));
    return paramResources;
    if (QLog.isColorLevel()) {
      QLog.d("bubble_performance", 2, "getBubbleInfo time default" + (SystemClock.elapsedRealtime() - l));
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleUtils
 * JD-Core Version:    0.7.0.1
 */