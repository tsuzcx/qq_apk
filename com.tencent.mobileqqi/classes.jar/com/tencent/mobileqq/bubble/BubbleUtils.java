package com.tencent.mobileqq.bubble;

import android.content.res.Resources;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;

public class BubbleUtils
{
  public static final int a = 0;
  public static BubbleInfo a = new BubbleInfo(0);
  public static final int b = 100000;
  public static BubbleInfo b = new BubbleInfo(100000, 2130839099, 2130839098);
  
  public static BubbleInfo a(int paramInt, QQAppInterface paramQQAppInterface, Resources paramResources, BaseAdapter paramBaseAdapter)
  {
    if (paramInt == 100000) {
      return b;
    }
    return a;
  }
  
  public static void a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleUtils
 * JD-Core Version:    0.7.0.1
 */