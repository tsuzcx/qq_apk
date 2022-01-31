package com.tencent.mm.sdk.platformtools;

import android.os.SystemClock;
import java.util.ArrayList;

public class TimeLogger
{
  private String bm;
  private String bn;
  private boolean bo;
  ArrayList bp;
  ArrayList bq;
  
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
    Log.d(this.bm, this.bn + ": begin");
    long l2 = ((Long)this.bp.get(0)).longValue();
    int i = 1;
    long l1 = l2;
    while (i < this.bp.size())
    {
      l1 = ((Long)this.bp.get(i)).longValue();
      String str = (String)this.bq.get(i);
      long l3 = ((Long)this.bp.get(i - 1)).longValue();
      Log.d(this.bm, this.bn + ":      " + (l1 - l3) + " ms, " + str);
      i += 1;
    }
    Log.d(this.bm, this.bn + ": end, " + (l1 - l2) + " ms");
  }
  
  public void reset()
  {
    this.bo = false;
    if (this.bo) {
      return;
    }
    if (this.bp == null)
    {
      this.bp = new ArrayList();
      this.bq = new ArrayList();
    }
    for (;;)
    {
      addSplit(null);
      return;
      this.bp.clear();
      this.bq.clear();
    }
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