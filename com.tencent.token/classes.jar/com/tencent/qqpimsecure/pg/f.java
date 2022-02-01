package com.tencent.qqpimsecure.pg;

import android.content.Context;
import com.tencent.qqpimsecure.taiji.c;
import tmsdk.common.module.pgsdk.manager.ITaijiPreferenceManager;

public class f
{
  public static int a(Context paramContext)
  {
    return c.a().a(paramContext, "pgd_sp", 4).getInt("t_t_s", 2);
  }
  
  public static long a(Context paramContext, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("s");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("ct");
    localObject = ((StringBuilder)localObject).toString();
    return c.a().a(paramContext, "pgd_sp", 4).getLong((String)localObject, 0L);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    c.a().a(paramContext, "pgd_sp", 4).putInt("t_t_s", paramInt);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pg");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("s");
    localObject = ((StringBuilder)localObject).toString();
    c.a().a(paramContext, "pgd_sp", 4).putInt((String)localObject, paramInt2);
  }
  
  public static void a(Context paramContext, long paramLong1, long paramLong2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("s");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append("ct");
    localObject = ((StringBuilder)localObject).toString();
    c.a().a(paramContext, "pgd_sp", 4).putLong((String)localObject, paramLong2);
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    c.a().a(paramContext, "pgd_sp", 4).putBoolean("fg_v", paramBoolean);
  }
  
  public static int b(Context paramContext)
  {
    return c.a().a(paramContext, "pgd_sp", 4).getInt("f_w_c", 2);
  }
  
  public static void b(Context paramContext, int paramInt)
  {
    c.a().a(paramContext, "pgd_sp", 4).putInt("f_w_c", paramInt);
  }
  
  public static void b(Context paramContext, long paramLong)
  {
    c.a().a(paramContext, "pgd_sp", 4).putLong("f_w_m_t", paramLong);
  }
  
  public static int c(Context paramContext, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pg");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("s");
    localObject = ((StringBuilder)localObject).toString();
    return c.a().a(paramContext, "pgd_sp", 4).getInt((String)localObject, 0);
  }
  
  public static long c(Context paramContext)
  {
    return c.a().a(paramContext, "pgd_sp", 4).getLong("f_w_m_t", 0L);
  }
  
  public static boolean d(Context paramContext)
  {
    return c.a().a(paramContext, "pgd_sp", 4).getBoolean("fg_v", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.pg.f
 * JD-Core Version:    0.7.0.1
 */