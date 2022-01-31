package com.tencent.mobileqq.data;

public class FriendDetail
{
  private String alias = "";
  private long datetime;
  private int detalStatusFlag;
  public boolean enable;
  private short faceid;
  private int groupid = -1;
  private boolean isMqqOnLine;
  private byte memberLevel;
  private String name = "";
  private String pyAll = "";
  private String pyFirst = "";
  private String selfuin = "";
  private byte sqqOnLineState;
  private byte sqqtype;
  private byte status;
  private String uin = "";
  
  public int detalStatusFlag()
  {
    return this.detalStatusFlag;
  }
  
  public String getAlias()
  {
    return this.alias;
  }
  
  public long getDatetime()
  {
    return this.datetime;
  }
  
  public short getFaceid()
  {
    return this.faceid;
  }
  
  public int getGroupid()
  {
    return this.groupid;
  }
  
  public byte getMemberLevel()
  {
    return this.memberLevel;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getPyAll()
  {
    return this.pyAll;
  }
  
  public String getPyFirst()
  {
    return this.pyFirst;
  }
  
  public String getSelfuin()
  {
    return this.selfuin;
  }
  
  public byte getSqqOnLineState()
  {
    return this.sqqOnLineState;
  }
  
  public byte getSqqtype()
  {
    return this.sqqtype;
  }
  
  public byte getStatus()
  {
    return this.status;
  }
  
  public String getUin()
  {
    return this.uin;
  }
  
  public boolean isMqqOnLine()
  {
    return this.isMqqOnLine;
  }
  
  public void setAlias(String paramString)
  {
    this.alias = paramString;
  }
  
  public void setDatetime(long paramLong)
  {
    this.datetime = paramLong;
  }
  
  public void setFaceid(short paramShort)
  {
    this.faceid = paramShort;
  }
  
  public void setGroupid(int paramInt)
  {
    this.groupid = paramInt;
  }
  
  public void setMemberLevel(byte paramByte)
  {
    this.memberLevel = paramByte;
  }
  
  public void setMqqOnLine(boolean paramBoolean)
  {
    this.isMqqOnLine = paramBoolean;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setPyAll(String paramString)
  {
    this.pyAll = paramString;
  }
  
  public void setPyFirst(String paramString)
  {
    this.pyFirst = paramString;
  }
  
  public void setSelfuin(String paramString)
  {
    this.selfuin = paramString;
  }
  
  public void setSqqOnLineState(byte paramByte)
  {
    this.sqqOnLineState = paramByte;
  }
  
  public void setSqqtype(byte paramByte)
  {
    this.sqqtype = paramByte;
  }
  
  public void setStatus(byte paramByte)
  {
    this.status = paramByte;
  }
  
  public void setUin(String paramString)
  {
    this.uin = paramString;
  }
  
  public void setdetalStatusFlag(int paramInt)
  {
    this.detalStatusFlag = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.FriendDetail
 * JD-Core Version:    0.7.0.1
 */