package com.tencent.mobileqq.newfriend;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public class NewFriendMessage
  implements Comparable
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 0;
  public static final int g = 1;
  public static final int h = 3;
  public static final int i = 4;
  public static final int j = 5;
  public static final int k = 0;
  public static final int l = 1;
  public long a;
  public Object a;
  public String a;
  public boolean a;
  protected int m = 0;
  public int n;
  public int o;
  private int p = 0;
  
  public NewFriendMessage(int paramInt)
  {
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    this.n = paramInt;
    a();
  }
  
  public NewFriendMessage(int paramInt1, int paramInt2)
  {
    this(paramInt1);
    this.o = paramInt2;
  }
  
  public NewFriendMessage(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this(paramInt1);
    this.o = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public NewFriendMessage(int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    this.n = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.o = paramInt2;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public int a()
  {
    return this.m;
  }
  
  public int a(NewFriendMessage paramNewFriendMessage)
  {
    int i1 = 1;
    if (this.n == paramNewFriendMessage.n) {
      i1 = 0;
    }
    do
    {
      do
      {
        return i1;
        if (this.p != paramNewFriendMessage.p) {
          break;
        }
      } while (this.jdField_a_of_type_Long < paramNewFriendMessage.jdField_a_of_type_Long);
      return -1;
    } while (this.p > paramNewFriendMessage.p);
    return -1;
  }
  
  public View a(ViewGroup paramViewGroup, View paramView)
  {
    return null;
  }
  
  public void a()
  {
    switch (this.n)
    {
    case 2: 
    default: 
      this.p = 0;
      return;
    case 1: 
    case 4: 
      this.p = 0;
      return;
    }
    this.p = 1;
  }
  
  public void a(int paramInt)
  {
    this.n = paramInt;
    a();
  }
  
  public int b()
  {
    return this.n;
  }
  
  public void b(int paramInt)
  {
    this.p = paramInt;
  }
  
  public int c()
  {
    return this.p;
  }
  
  public void c(int paramInt)
  {
    this.o = paramInt;
  }
  
  public int d()
  {
    return this.o;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.NewFriendMessage
 * JD-Core Version:    0.7.0.1
 */