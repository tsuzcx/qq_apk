package com.tencent.mm.sdk.platformtools;

import android.os.SystemClock;
import java.util.ArrayList;

public class TimeLogger
{
  private String bm;
  private String bn;
  private boolean bo;
  ArrayList<Long> bp;
  ArrayList<String> bq;
  
  public TimeLogger(String paramString1, String paramString2)
  {
    reset(paramString1, paramString2);
  }
  
  public void addSplit(String paramString)
  {
    if (this.bo) {
      return;
    }
    long l = SystemClock.elapsedRealtime();
    this.bp.add(Long.valueOf(l));
    this.bq.add(paramString);
  }
  
  public void dumpToLog()
  {
    if (this.bo) {
      return;
    }
    String str = this.bm;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.bn);
    ((StringBuilder)localObject).append(": begin");
    Log.d(str, ((StringBuilder)localObject).toString());
    long l2 = ((Long)this.bp.get(0)).longValue();
    int i = 1;
    long l1 = l2;
    while (i < this.bp.size())
    {
      l1 = ((Long)this.bp.get(i)).longValue();
      str = (String)this.bq.get(i);
      long l3 = ((Long)this.bp.get(i - 1)).longValue();
      localObject = this.bm;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.bn);
      localStringBuilder.append(":      ");
      localStringBuilder.append(l1 - l3);
      localStringBuilder.append(" ms, ");
      localStringBuilder.append(str);
      Log.d((String)localObject, localStringBuilder.toString());
      i += 1;
    }
    str = this.bm;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.bn);
    ((StringBuilder)localObject).append(": end, ");
    ((StringBuilder)localObject).append(l1 - l2);
    ((StringBuilder)localObject).append(" ms");
    Log.d(str, ((StringBuilder)localObject).toString());
  }
  
  public void reset()
  {
    this.bo = false;
    if (this.bo) {
      return;
    }
    ArrayList localArrayList = this.bp;
    if (localArrayList == null)
    {
      this.bp = new ArrayList();
      this.bq = new ArrayList();
    }
    else
    {
      localArrayList.clear();
      this.bq.clear();
    }
    addSplit(null);
  }
  
  public void reset(String paramString1, String paramString2)
  {
    this.bm = paramString1;
    this.bn = paramString2;
    reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.TimeLogger
 * JD-Core Version:    0.7.0.1
 */