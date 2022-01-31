package com.tencent.mobileqq.model;

import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.OpenTroopInfo;
import com.tencent.mobileqq.data.TroopInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.manager.Manager;

public abstract interface FriendManager
  extends Manager
{
  public static final int a = -100;
  
  public abstract int a();
  
  public abstract int a(String paramString);
  
  public abstract Card a(String paramString);
  
  public abstract DiscussionInfo a(String paramString);
  
  public abstract DiscussionMemberInfo a(String paramString1, String paramString2);
  
  public abstract ExtensionInfo a(String paramString);
  
  public abstract Friends a(String paramString);
  
  public abstract Groups a(String paramString);
  
  public abstract OpenTroopInfo a(String paramString);
  
  public abstract TroopInfo a(String paramString);
  
  public abstract String a(String paramString);
  
  public abstract ArrayList a();
  
  public abstract ArrayList a(String paramString);
  
  public abstract List a();
  
  public abstract void a(OpenTroopInfo paramOpenTroopInfo, boolean paramBoolean);
  
  public abstract void a(String paramString, ArrayList paramArrayList);
  
  public abstract void a(String paramString, Set paramSet);
  
  public abstract void a(String paramString, boolean paramBoolean);
  
  public abstract void a(Map paramMap);
  
  public abstract boolean a(String paramString);
  
  public abstract boolean a(String paramString, long paramLong);
  
  public abstract int b(String paramString);
  
  public abstract String b(String paramString);
  
  public abstract ArrayList b();
  
  public abstract List b();
  
  public abstract boolean b();
  
  public abstract boolean b(String paramString);
  
  public abstract int c(String paramString);
  
  public abstract Friends c(String paramString);
  
  public abstract String c(String paramString);
  
  public abstract ArrayList c();
  
  public abstract boolean c();
  
  public abstract boolean c(String paramString);
  
  public abstract String d(String paramString);
  
  public abstract String d(String paramString1, String paramString2);
  
  public abstract ArrayList d();
  
  public abstract boolean d(String paramString);
  
  public abstract String e(String paramString);
  
  public abstract boolean e(String paramString);
  
  public abstract void f();
  
  public abstract void f(String paramString);
  
  public abstract boolean f(String paramString);
  
  public abstract String g(String paramString);
  
  public abstract void g(String paramString);
  
  public abstract boolean g(String paramString);
  
  public abstract String h(String paramString);
  
  public abstract void h(String paramString);
  
  public abstract boolean h(String paramString);
  
  public abstract void i(String paramString);
  
  public abstract boolean i(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.model.FriendManager
 * JD-Core Version:    0.7.0.1
 */