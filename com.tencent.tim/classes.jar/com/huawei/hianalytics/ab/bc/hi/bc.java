package com.huawei.hianalytics.ab.bc.hi;

import com.huawei.hianalytics.ab.bc.ef.ab;
import java.util.Calendar;
import java.util.UUID;

public class bc
{
  private long ab = 1800000L;
  private long bc = 30000L;
  private volatile boolean cd = false;
  private volatile long de = 0L;
  private ab ef = null;
  
  public String ab()
  {
    if (this.ef == null)
    {
      ab.cd("SessionWrapper", "getSessionName(): session not prepared. onEvent() must be called first.");
      return "";
    }
    return this.ef.ab;
  }
  
  void ab(long paramLong)
  {
    if (this.ef == null)
    {
      ab.bc("SessionWrapper", "Session is first flush");
      this.ef = new ab(paramLong);
      return;
    }
    this.ef.ab(paramLong);
  }
  
  public boolean bc()
  {
    if (this.ef == null)
    {
      ab.cd("SessionWrapper", "isFirstEvent(): session not prepared. onEvent() must be called first.");
      return false;
    }
    return this.ef.bc;
  }
  
  public void cd()
  {
    this.ef = null;
    this.de = 0L;
    this.cd = false;
  }
  
  class ab
  {
    String ab = UUID.randomUUID().toString().replace("-", "");
    boolean bc;
    private long de;
    
    ab(long paramLong)
    {
      this.ab = (this.ab + "_" + paramLong);
      this.de = paramLong;
      this.bc = true;
      bc.ab(bc.this, false);
    }
    
    private boolean ab(long paramLong1, long paramLong2)
    {
      Calendar localCalendar1 = Calendar.getInstance();
      localCalendar1.setTimeInMillis(paramLong1);
      Calendar localCalendar2 = Calendar.getInstance();
      localCalendar2.setTimeInMillis(paramLong2);
      return (localCalendar1.get(1) != localCalendar2.get(1)) || (localCalendar1.get(6) != localCalendar2.get(6));
    }
    
    private void bc(long paramLong)
    {
      ab.bc("SessionWrapper", "getNewSession() session is flush!");
      this.ab = UUID.randomUUID().toString();
      this.ab = this.ab.replace("-", "");
      this.ab = (this.ab + "_" + paramLong);
      this.de = paramLong;
      this.bc = true;
    }
    
    private boolean bc(long paramLong1, long paramLong2)
    {
      return paramLong2 - paramLong1 >= bc.bc(bc.this);
    }
    
    void ab(long paramLong)
    {
      if (bc.ab(bc.this))
      {
        bc.ab(bc.this, false);
        bc(paramLong);
        return;
      }
      if ((bc(this.de, paramLong)) || (ab(this.de, paramLong)))
      {
        bc(paramLong);
        return;
      }
      this.de = paramLong;
      this.bc = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.hi.bc
 * JD-Core Version:    0.7.0.1
 */