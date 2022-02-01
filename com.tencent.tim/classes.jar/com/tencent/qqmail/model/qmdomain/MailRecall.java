package com.tencent.qqmail.model.qmdomain;

import com.tencent.qqmail.utilities.QMMath;

public class MailRecall
  extends QMDomain
{
  public static final int STATUS_INIT = 0;
  public static final int STATUS_LOCAL = 5;
  public static final int STATUS_NOTFOUND = 4;
  public static final int STATUS_OK = 2;
  public static final int STATUS_PROCESS = 1;
  public static final int STATUS_READ = 3;
  private long id;
  private long mid;
  private String receiver;
  private int status;
  
  public static long generateId(long paramLong, String paramString, int paramInt)
  {
    return QMMath.hashLong(paramLong + "_r_" + paramString + "_s_" + paramInt);
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public long getMid()
  {
    return this.mid;
  }
  
  public String getReceiver()
  {
    return this.receiver;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public void setId(long paramLong)
  {
    this.id = paramLong;
  }
  
  public void setMid(long paramLong)
  {
    this.mid = paramLong;
  }
  
  public void setReceiver(String paramString)
  {
    this.receiver = paramString;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.MailRecall
 * JD-Core Version:    0.7.0.1
 */