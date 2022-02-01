package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.utilities.QMMath;

public class CalendarAccountConfig
{
  private int accountId;
  private String activeSyncKey = "";
  private String authToken = "";
  private String homeSetPath = "";
  private String host = "";
  private int id;
  private boolean isSslSupport = true;
  private String policyKey = "";
  private int protocol = 0;
  private String protocolVersion = "14.1";
  private String pwd;
  private long refreshTime = 0L;
  private String syncToken = "";
  
  public static int generateId(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1).append("^").append(paramInt2);
    return QMMath.hashInt(localStringBuilder.toString());
  }
  
  public int getAccountId()
  {
    return this.accountId;
  }
  
  public String getActiveSyncKey()
  {
    if ((this.activeSyncKey == null) || (this.activeSyncKey.trim().equals(""))) {
      setActiveSyncKey("0");
    }
    return this.activeSyncKey;
  }
  
  public String getAuthToken()
  {
    return this.authToken;
  }
  
  public String getHomeSetPath()
  {
    return this.homeSetPath;
  }
  
  public String getHost()
  {
    return this.host;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getPolicyKey()
  {
    return this.policyKey;
  }
  
  public String getProfileString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(this.host).append("|");
    if (this.isSslSupport) {}
    for (int i = 1;; i = 0)
    {
      localStringBuilder2.append(i).append("|").append(this.policyKey).append("|").append(this.authToken).append("|").append(this.syncToken).append("|").append(this.homeSetPath).append("|").append(this.protocolVersion).append("|").append(this.activeSyncKey);
      return localStringBuilder1.toString();
    }
  }
  
  public int getProtocol()
  {
    return this.protocol;
  }
  
  public String getProtocolVersion()
  {
    return this.protocolVersion;
  }
  
  public String getPwd()
  {
    return this.pwd;
  }
  
  public long getRefreshTime()
  {
    return this.refreshTime;
  }
  
  public String getSyncToken()
  {
    return this.syncToken;
  }
  
  public void initFromProfileString(String paramString)
  {
    paramString = paramString.split("\\|", -1);
    setHost(paramString[0]);
    setIsSslSupport(paramString[1].equals("1"));
    setPolicyKey(paramString[2]);
    setAuthToken(paramString[3]);
    setSyncToken(paramString[4]);
    setHomeSetPath(paramString[5]);
    if (paramString.length > 6) {
      setProtocolVersion(paramString[6]);
    }
    if (paramString.length > 7) {
      setActiveSyncKey(paramString[7]);
    }
  }
  
  public boolean isSslSupport()
  {
    return this.isSslSupport;
  }
  
  public void setAccountId(int paramInt)
  {
    this.accountId = paramInt;
  }
  
  public void setActiveSyncKey(String paramString)
  {
    this.activeSyncKey = paramString;
  }
  
  public void setAuthToken(String paramString)
  {
    this.authToken = paramString;
  }
  
  public void setHomeSetPath(String paramString)
  {
    this.homeSetPath = paramString;
  }
  
  public void setHost(String paramString)
  {
    this.host = paramString;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setIsSslSupport(boolean paramBoolean)
  {
    this.isSslSupport = paramBoolean;
  }
  
  public void setPolicyKey(String paramString)
  {
    this.policyKey = paramString;
  }
  
  public void setProtocol(int paramInt)
  {
    this.protocol = paramInt;
  }
  
  public void setProtocolVersion(String paramString)
  {
    this.protocolVersion = paramString;
  }
  
  public void setPwd(String paramString)
  {
    this.pwd = paramString;
  }
  
  public void setRefreshTime(long paramLong)
  {
    this.refreshTime = paramLong;
  }
  
  public void setSyncToken(String paramString)
  {
    this.syncToken = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.CalendarAccountConfig
 * JD-Core Version:    0.7.0.1
 */