package com.tencent.moai.mailsdk.model;

import java.util.ArrayList;

public class State
{
  private int accountId;
  private int activeSyncFilterType;
  private ArrayList<String> deleteUidList = new ArrayList();
  private ArrayList<String> existUidList = new ArrayList();
  private int initLoadCount;
  private boolean isReceiveNewOnly;
  private boolean isWithoutSession;
  private long lastMailUtc;
  private int loadMoreCount;
  private int updateCount;
  
  public int getAccountId()
  {
    return this.accountId;
  }
  
  public int getActiveSyncFilterType()
  {
    return this.activeSyncFilterType;
  }
  
  public ArrayList<String> getDeleteUidList()
  {
    return this.deleteUidList;
  }
  
  public ArrayList<String> getExistUidList()
  {
    return this.existUidList;
  }
  
  public int getInitLoadCount()
  {
    return this.initLoadCount;
  }
  
  public long getLastMailUtc()
  {
    return this.lastMailUtc;
  }
  
  public int getLoadMoreCount()
  {
    return this.loadMoreCount;
  }
  
  public int getUpdateCount()
  {
    return this.updateCount;
  }
  
  public boolean isReceiveNewOnly()
  {
    return this.isReceiveNewOnly;
  }
  
  public boolean isWithoutSession()
  {
    return this.isWithoutSession;
  }
  
  public void setAccountId(int paramInt)
  {
    this.accountId = paramInt;
  }
  
  public void setActiveSyncFilterType(int paramInt)
  {
    this.activeSyncFilterType = paramInt;
  }
  
  public void setDeleteUidList(ArrayList<String> paramArrayList)
  {
    this.deleteUidList = paramArrayList;
  }
  
  public void setExistUidList(ArrayList<String> paramArrayList)
  {
    this.existUidList = paramArrayList;
  }
  
  public void setInitLoadCount(int paramInt)
  {
    this.initLoadCount = paramInt;
  }
  
  public void setIsWithoutSession(boolean paramBoolean)
  {
    this.isWithoutSession = paramBoolean;
  }
  
  public void setLastMailUtc(long paramLong)
  {
    this.lastMailUtc = paramLong;
  }
  
  public void setLoadMoreCount(int paramInt)
  {
    this.loadMoreCount = paramInt;
  }
  
  public void setReceiveNewOnly(boolean paramBoolean)
  {
    this.isReceiveNewOnly = paramBoolean;
  }
  
  public void setUpdateCount(int paramInt)
  {
    this.updateCount = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.model.State
 * JD-Core Version:    0.7.0.1
 */