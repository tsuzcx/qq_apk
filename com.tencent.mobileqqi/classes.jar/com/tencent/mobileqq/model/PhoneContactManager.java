package com.tencent.mobileqq.model;

import SecurityAccountServer.RespondQueryQQBindingStat;
import com.tencent.mobileqq.activity.voip.VoipContact;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Hashtable;
import java.util.List;
import mqq.manager.Manager;

public abstract interface PhoneContactManager
  extends Manager
{
  public static final String a = "PhoneContactManager";
  public static final int b = -1;
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  public static final int g = 4;
  public static final int h = 5;
  public static final int i = 6;
  public static final int j = 7;
  public static final int k = 8;
  public static final int l = 9;
  public static final int m = 10;
  public static final int n = 11;
  public static final int o = 0;
  public static final int p = 1;
  public static final int q = 2;
  public static final int r = 3;
  
  public abstract RespondQueryQQBindingStat a();
  
  public abstract VoipContact a(String paramString1, String paramString2, String paramString3);
  
  public abstract PhoneContact a(int paramInt);
  
  public abstract PhoneContact a(String paramString);
  
  public abstract Hashtable a();
  
  public abstract List a();
  
  public abstract void a(long paramLong1, long paramLong2, List paramList1, List paramList2);
  
  public abstract void a(RespondQueryQQBindingStat paramRespondQueryQQBindingStat);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void a(String paramString1, String paramString2, int paramInt);
  
  public abstract void a(List paramList, long paramLong);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void a(byte[] paramArrayOfByte);
  
  public abstract int b();
  
  public abstract PhoneContact b(String paramString);
  
  public abstract String b();
  
  public abstract String b(String paramString);
  
  public abstract List b();
  
  public abstract void b();
  
  public abstract void b(String paramString1, String paramString2);
  
  public abstract void b(String paramString1, String paramString2, int paramInt);
  
  public abstract void b(List paramList);
  
  public abstract void b(List paramList, long paramLong);
  
  public abstract PhoneContact c(String paramString);
  
  public abstract String c();
  
  public abstract String c(String paramString);
  
  public abstract List c();
  
  public abstract void c();
  
  public abstract void c(String paramString1, String paramString2);
  
  public abstract PhoneContact d(String paramString);
  
  public abstract List d();
  
  public abstract void d();
  
  public abstract void d(String paramString1, String paramString2);
  
  public abstract boolean d();
  
  public abstract PhoneContact e(String paramString);
  
  public abstract void e();
  
  public abstract boolean e();
  
  public abstract PhoneContact f(String paramString);
  
  public abstract boolean f();
  
  public abstract boolean g();
  
  public abstract void h();
  
  public abstract boolean h();
  
  public abstract void j();
  
  public abstract void k();
  
  public abstract void l();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.model.PhoneContactManager
 * JD-Core Version:    0.7.0.1
 */