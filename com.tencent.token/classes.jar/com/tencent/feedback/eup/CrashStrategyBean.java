package com.tencent.feedback.eup;

import com.tencent.feedback.common.e;
import java.util.Locale;

public class CrashStrategyBean
  implements Cloneable
{
  public static final String format = "[MSNum:%d ,Wifi:%d,GPRS:%d,ODay:%d,isMerged:%b,AfQ:%b,Silent:%b,mLog:%d,tag:%s,assert:%s, interval:%s, limit:%s]";
  private int a = 10;
  private int b = 10;
  private int c = 3;
  private int d = 10;
  private boolean e = true;
  private boolean f = false;
  private boolean g = true;
  private int h = 100;
  private String i = null;
  private boolean j = false;
  private String k = null;
  private int l = 5000;
  private int m = 3;
  private int n = 100;
  private boolean o = false;
  private int p = 60;
  private int q = 50;
  private boolean r = true;
  private boolean s = false;
  private boolean t = false;
  
  public CrashStrategyBean clone()
    throws CloneNotSupportedException
  {
    try
    {
      CrashStrategyBean localCrashStrategyBean = new CrashStrategyBean();
      localCrashStrategyBean.setEnableAfterQuery(this.f);
      localCrashStrategyBean.setMaxStoredNum(this.a);
      localCrashStrategyBean.setMaxUploadNum_GPRS(this.c);
      localCrashStrategyBean.setMaxUploadNum_Wifi(this.b);
      localCrashStrategyBean.setMerged(this.e);
      localCrashStrategyBean.setRecordOverDays(this.d);
      localCrashStrategyBean.setSilentUpload(this.g);
      localCrashStrategyBean.setMaxLogRow(this.h);
      localCrashStrategyBean.setOnlyLogTag(this.i);
      localCrashStrategyBean.setAssertEnable(this.o);
      localCrashStrategyBean.setAssertTaskInterval(this.p);
      localCrashStrategyBean.setAssertLimitCount(this.q);
      return localCrashStrategyBean;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getAssertLimitCount()
  {
    try
    {
      int i1 = this.q;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getAssertTaskInterval()
  {
    try
    {
      int i1 = this.p;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getCrashSdcardMaxSize()
  {
    try
    {
      int i1 = this.l;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getMaxLogRow()
  {
    try
    {
      int i1 = this.h;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getMaxStackFrame()
  {
    try
    {
      int i1 = this.m;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getMaxStackLine()
  {
    try
    {
      int i1 = this.n;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getMaxStoredNum()
  {
    try
    {
      int i1 = this.a;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getMaxUploadNum_GPRS()
  {
    try
    {
      int i1 = this.c;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getMaxUploadNum_Wifi()
  {
    try
    {
      int i1 = this.b;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getOnlyLogTag()
  {
    try
    {
      String str = this.i;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getRecordOverDays()
  {
    try
    {
      int i1 = this.d;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getStoreDirectoryPath()
  {
    try
    {
      String str = this.k;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isAssertOn()
  {
    try
    {
      boolean bool = this.o;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isBroadcast()
  {
    try
    {
      boolean bool = this.s;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isEnableAfterQuery()
  {
    try
    {
      boolean bool = this.f;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isMerged()
  {
    try
    {
      boolean bool = this.e;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isOpenANR()
  {
    try
    {
      boolean bool = this.r;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isReceiveBroadcast()
  {
    try
    {
      boolean bool = this.t;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isSilentUpload()
  {
    try
    {
      boolean bool = this.g;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isStoreCrashSdcard()
  {
    try
    {
      boolean bool = this.j;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setAssertEnable(boolean paramBoolean)
  {
    try
    {
      this.o = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setAssertLimitCount(int paramInt)
  {
    if (paramInt < 50) {}
    for (;;)
    {
      try
      {
        e.a("rqdp{The trigger count of the assert store is smaller than the default count.} [%s]", new Object[] { Integer.valueOf(paramInt) });
      }
      finally {}
      this.q = paramInt;
      return;
      paramInt = 50;
      continue;
      if (paramInt <= 0) {}
    }
  }
  
  public void setAssertTaskInterval(int paramInt)
  {
    if (paramInt < 60) {}
    for (;;)
    {
      try
      {
        e.a("rqdp{The interval of assert check task is smaller than the default time.} [%s s]", new Object[] { Integer.valueOf(paramInt) });
      }
      finally {}
      this.p = paramInt;
      return;
      paramInt = 60;
      continue;
      if (paramInt <= 0) {}
    }
  }
  
  public void setBroadcast(boolean paramBoolean)
  {
    try
    {
      this.s = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setCrashSdcardMaxSize(int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      this.l = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setEnableAfterQuery(boolean paramBoolean)
  {
    try
    {
      this.f = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setMaxLogRow(int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      this.h = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setMaxStackFrame(int paramInt)
  {
    try
    {
      this.m = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setMaxStackLine(int paramInt)
  {
    try
    {
      this.n = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setMaxStoredNum(int paramInt)
  {
    if ((paramInt > 0) && (paramInt <= 20)) {}
    try
    {
      this.a = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setMaxUploadNum_GPRS(int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      this.c = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setMaxUploadNum_Wifi(int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      this.b = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setMerged(boolean paramBoolean)
  {
    try
    {
      this.e = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setOnlyLogTag(String paramString)
  {
    try
    {
      this.i = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setOpenANR(boolean paramBoolean)
  {
    try
    {
      this.r = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setReceiveBroadcast(boolean paramBoolean)
  {
    try
    {
      this.t = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setRecordOverDays(int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      this.d = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setSilentUpload(boolean paramBoolean)
  {
    try
    {
      this.g = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setStoreCrashSdcard(boolean paramBoolean)
  {
    try
    {
      this.j = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setStoreDirectoryPath(String paramString)
  {
    try
    {
      this.k = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public String toString()
  {
    try
    {
      String str1 = String.format(Locale.US, "[MSNum:%d ,Wifi:%d,GPRS:%d,ODay:%d,isMerged:%b,AfQ:%b,Silent:%b,mLog:%d,tag:%s,assert:%s, interval:%s, limit:%s]", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), Boolean.valueOf(this.e), Boolean.valueOf(this.f), Boolean.valueOf(this.g), Integer.valueOf(this.h), this.i, Boolean.valueOf(this.o), Integer.valueOf(this.q), Integer.valueOf(this.p) });
      return str1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (!e.a(localThrowable)) {
          localThrowable.printStackTrace();
        }
        String str2 = "error";
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.CrashStrategyBean
 * JD-Core Version:    0.7.0.1
 */