package tmsdkdual;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tmsdk.dual.TMSDualSDKContext;

public class a
{
  private static a j = null;
  public SharedPreferences g;
  private SharedPreferences.Editor h;
  private boolean i = false;
  
  private a(Context paramContext)
  {
    this.g = paramContext.getSharedPreferences("ConfigInfo", 0);
  }
  
  public static a b()
  {
    if (j == null) {}
    try
    {
      if (j == null) {
        j = new a(TMSDualSDKContext.getApplicaionContext());
      }
      return j;
    }
    finally {}
  }
  
  public boolean a(int paramInt)
  {
    for (;;)
    {
      try
      {
        long l2 = this.g.getLong("lpt" + paramInt, 0L);
        long l3 = System.currentTimeMillis();
        try
        {
          NetworkInfo localNetworkInfo = ((ConnectivityManager)TMSDualSDKContext.getApplicaionContext().getSystemService("connectivity")).getNetworkInfo(1);
          if (localNetworkInfo == null) {
            break label112;
          }
          boolean bool = localNetworkInfo.isConnected();
          if (!bool) {
            break label112;
          }
          paramInt = 1;
        }
        catch (Exception localException)
        {
          paramInt = 0;
          continue;
          long l1 = 21600000L;
          continue;
        }
        if (paramInt != 0)
        {
          l1 = 10800000L;
          if (l3 - l2 <= l1) {
            continue;
          }
          return true;
        }
        return false;
      }
      catch (Throwable localThrowable)
      {
        return false;
      }
      label112:
      paramInt = 0;
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if (this.h == null) {
      this.h = this.g.edit();
    }
    try
    {
      this.h.putInt(paramString, paramInt);
      if (!this.i)
      {
        boolean bool = this.h.commit();
        return bool;
      }
    }
    catch (Exception paramString) {}
    return true;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    if (this.h == null) {
      this.h = this.g.edit();
    }
    try
    {
      this.h.putLong(paramString, paramLong);
      if (!this.i)
      {
        boolean bool = this.h.commit();
        return bool;
      }
    }
    catch (Exception paramString) {}
    return true;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (this.h == null) {
      this.h = this.g.edit();
    }
    try
    {
      this.h.putString(paramString1, paramString2);
      if (!this.i)
      {
        boolean bool = this.h.commit();
        return bool;
      }
    }
    catch (Exception paramString1) {}
    return true;
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    if (this.h == null) {
      this.h = this.g.edit();
    }
    try
    {
      this.h.putBoolean(paramString, paramBoolean);
      if (!this.i)
      {
        paramBoolean = this.h.commit();
        return paramBoolean;
      }
    }
    catch (Exception paramString) {}
    return true;
  }
  
  public void beginTransaction()
  {
    this.i = true;
  }
  
  public boolean c()
  {
    this.i = false;
    if (this.h != null) {
      return this.h.commit();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     tmsdkdual.a
 * JD-Core Version:    0.7.0.1
 */