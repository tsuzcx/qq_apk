package com.tencent.qqmail.model.alias;

import com.tencent.qqmail.model.qmdomain.ComposeData.ComposeDataSender;

public class AliasItem
{
  private int accountId;
  private String alias = "";
  private String aliasNick;
  private boolean indep;
  private boolean isProtocol = false;
  
  public int getAccountId()
  {
    return this.accountId;
  }
  
  public String getAlias()
  {
    return this.alias;
  }
  
  public String getAliasNick()
  {
    return this.aliasNick;
  }
  
  public boolean getIndependent()
  {
    return this.indep;
  }
  
  public void initByComposeData(ComposeData.ComposeDataSender paramComposeDataSender, int paramInt)
  {
    if (paramComposeDataSender == null) {
      return;
    }
    setAccountId(paramInt);
    if (paramComposeDataSender.getAlias() == null)
    {
      setAlias("");
      if (paramComposeDataSender.getNick() != null) {
        break label60;
      }
      setAliasNick("");
    }
    for (;;)
    {
      if (paramComposeDataSender.getSignvalid() != null) {
        break label71;
      }
      setIndependent(false);
      return;
      setAlias(paramComposeDataSender.getAlias());
      break;
      label60:
      setAliasNick(paramComposeDataSender.getNick());
    }
    label71:
    setIndependent(paramComposeDataSender.getSignvalid().equals("1"));
  }
  
  public boolean isProtocol()
  {
    return this.isProtocol;
  }
  
  public void setAccountId(int paramInt)
  {
    this.accountId = paramInt;
  }
  
  public void setAlias(String paramString)
  {
    this.alias = paramString;
  }
  
  public void setAliasNick(String paramString)
  {
    this.aliasNick = paramString;
  }
  
  public void setIndependent(boolean paramBoolean)
  {
    this.indep = paramBoolean;
  }
  
  public void setIsProtocol(boolean paramBoolean)
  {
    this.isProtocol = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append("alias: ").append(this.alias);
    localStringBuilder.append(", accountId: ").append(this.accountId);
    localStringBuilder.append(", aliasNick: ").append(this.aliasNick);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.alias.AliasItem
 * JD-Core Version:    0.7.0.1
 */