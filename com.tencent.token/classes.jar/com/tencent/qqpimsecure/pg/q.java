package com.tencent.qqpimsecure.pg;

import android.content.Context;
import com.tencent.qqpimsecure.taiji.f;
import tmsdk.common.module.pgsdk.manager.ITaijiPreferenceManager;

public class q
{
  public static int a(Context paramContext)
  {
    return f.a().a(paramContext, "pgd_sp", 4).getInt("t_t_s", 2);
  }
  
  public static long a(Context paramContext, long paramLong)
  {
    String str = "s" + paramLong + "ct";
    return f.a().a(paramContext, "pgd_sp", 4).getLong(str, 0L);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    f.a().a(paramContext, "pgd_sp", 4).putInt("t_t_s", paramInt);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    String str = "pg" + paramInt1 + "s";
    f.a().a(paramContext, "pgd_sp", 4).putInt(str, paramInt2);
  }
  
  public static void a(Context paramContext, long paramLong1, long paramLong2)
  {
    String str = "s" + paramLong1 + "ct";
    f.a().a(paramContext, "pgd_sp", 4).putLong(str, paramLong2);
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    f.a().a(paramContext, "pgd_sp", 4).putBoolean("fg_v", paramBoolean);
  }
  
  public static int b(Context paramContext)
  {
    return f.a().a(paramContext, "pgd_sp", 4).getInt("f_w_c", 2);
  }
  
  public static void b(Context paramContext, int paramInt)
  {
    f.a().a(paramContext, "pgd_sp", 4).putInt("f_w_c", paramInt);
  }
  
  public static void b(Context paramContext, long paramLong)
  {
    f.a().a(paramContext, "pgd_sp", 4).putLong("f_w_m_t", paramLong);
  }
  
  public static int c(Context paramContext, int paramInt)
  {
    String str = "pg" + paramInt + "s";
    return f.a().a(paramContext, "pgd_sp", 4).getInt(str, 0);
  }
  
  public static long c(Context paramContext)
  {
    return f.a().a(paramContext, "pgd_sp", 4).getLong("f_w_m_t", 0L);
  }
  
  public static boolean d(Context paramContext)
  {
    return f.a().a(paramContext, "pgd_sp", 4).getBoolean("fg_v", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.pg.q
 * JD-Core Version:    0.7.0.1
 */