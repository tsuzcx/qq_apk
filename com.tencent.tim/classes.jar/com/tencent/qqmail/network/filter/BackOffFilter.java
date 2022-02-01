package com.tencent.qqmail.network.filter;

import com.tencent.qqmail.utilities.QMMath;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class BackOffFilter
{
  public static final int BUSSINES_TYPE_ACTIVESYNC = 2;
  public static final int BUSSINES_TYPE_LOGIN = 1;
  private static HashMap<Integer, BackOffData> bussinesHashMap = new HashMap();
  
  public static int genActiveSyncBussinesId(int paramInt)
  {
    return QMMath.hashInt("2^" + paramInt);
  }
  
  public static int genLoginBussinesId(int paramInt)
  {
    return QMMath.hashInt("1^" + paramInt);
  }
  
  public static void resetError(int paramInt)
  {
    BackOffData localBackOffData2 = (BackOffData)bussinesHashMap.get(Integer.valueOf(paramInt));
    BackOffData localBackOffData1 = localBackOffData2;
    if (localBackOffData2 == null)
    {
      localBackOffData1 = new BackOffData();
      bussinesHashMap.put(Integer.valueOf(paramInt), localBackOffData1);
    }
    localBackOffData1.errorCount = 0;
  }
  
  public static void setError(int paramInt)
  {
    BackOffData localBackOffData2 = (BackOffData)bussinesHashMap.get(Integer.valueOf(paramInt));
    BackOffData localBackOffData1 = localBackOffData2;
    if (localBackOffData2 == null)
    {
      localBackOffData1 = new BackOffData();
      bussinesHashMap.put(Integer.valueOf(paramInt), localBackOffData1);
    }
    localBackOffData1.errorCount += 1;
    localBackOffData1.errorTime = new Date().getTime();
    localBackOffData1.generateBackOffTime();
  }
  
  public static int whenToRetry(int paramInt, boolean paramBoolean)
  {
    BackOffData localBackOffData2 = (BackOffData)bussinesHashMap.get(Integer.valueOf(paramInt));
    BackOffData localBackOffData1 = localBackOffData2;
    if (localBackOffData2 == null)
    {
      localBackOffData1 = new BackOffData();
      bussinesHashMap.put(Integer.valueOf(paramInt), localBackOffData1);
    }
    if (paramBoolean)
    {
      localBackOffData1.errorCount += 1;
      localBackOffData1.errorTime = new Date().getTime();
      localBackOffData1.generateBackOffTime();
    }
    return localBackOffData1.whenToRetry();
  }
  
  public static int whenToRetryOrAbort(int paramInt, boolean paramBoolean)
  {
    BackOffData localBackOffData2 = (BackOffData)bussinesHashMap.get(Integer.valueOf(paramInt));
    BackOffData localBackOffData1 = localBackOffData2;
    if (localBackOffData2 == null)
    {
      localBackOffData1 = new BackOffData();
      bussinesHashMap.put(Integer.valueOf(paramInt), localBackOffData1);
    }
    if (paramBoolean)
    {
      localBackOffData1.errorCount += 1;
      localBackOffData1.errorTime = new Date().getTime();
      localBackOffData1.generateBackOffTime();
    }
    return localBackOffData1.whenToRetryOrAbort();
  }
  
  static class BackOffData
  {
    static int ERROR_MAX_TIME = 6;
    public long backoffTime = 0L;
    public int errorCount = 0;
    public long errorTime = 0L;
    
    public void generateBackOffTime()
    {
      Random localRandom = new Random(new Date().getTime());
      if (this.errorCount == 0)
      {
        this.backoffTime = 0L;
        return;
      }
      if (this.errorCount > ERROR_MAX_TIME)
      {
        this.backoffTime = -1L;
        return;
      }
      if (this.errorCount == 1)
      {
        l1 = 60000;
        this.backoffTime = (localRandom.nextFloat() * l1);
        return;
      }
      long l1 = (1 << this.errorCount - 2) * 60000;
      long l2 = 60000 * ((1 << this.errorCount - 1) - (1 << this.errorCount - 2));
      this.backoffTime = (((float)l1 + localRandom.nextFloat() * (float)l2));
    }
    
    public int whenToRetry()
    {
      if (this.backoffTime == -1L) {
        return 960;
      }
      long l = this.errorTime + this.backoffTime - new Date().getTime();
      if (l > 0L) {
        return (int)(l / 1000L);
      }
      return 0;
    }
    
    public int whenToRetryOrAbort()
    {
      if (this.backoffTime == -1L) {
        return -1;
      }
      long l = this.errorTime + this.backoffTime - new Date().getTime();
      if (l > 0L) {
        return (int)(l / 1000L);
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.network.filter.BackOffFilter
 * JD-Core Version:    0.7.0.1
 */