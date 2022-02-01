package com.tencent.qqmail.attachment.model;

import com.tencent.qqmail.model.qmdomain.QMDomain;

public class LockInfo
  extends QMDomain
{
  private static final long serialVersionUID = 1L;
  private int mAccountId;
  private String mEmail;
  private int mFolderId;
  private boolean mUnLock = false;
  private int personaCnt = 0;
  
  public LockInfo(int paramInt1, int paramInt2, String paramString)
  {
    this.mAccountId = paramInt1;
    this.mFolderId = paramInt2;
    this.mEmail = paramString;
  }
  
  public LockInfo(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    this(paramInt1, paramInt2, paramString);
    this.personaCnt = paramInt3;
  }
  
  public int getAccountId()
  {
    return this.mAccountId;
  }
  
  public String getEmail()
  {
    return this.mEmail;
  }
  
  public int getFolderId()
  {
    return this.mFolderId;
  }
  
  public int getPersonaCnt()
  {
    return this.personaCnt;
  }
  
  public boolean isUnLock()
  {
    return this.mUnLock;
  }
  
  public void setAccountId(int paramInt)
  {
    this.mAccountId = paramInt;
  }
  
  public void setEmail(String paramString)
  {
    this.mEmail = paramString;
  }
  
  public void setFolderId(int paramInt)
  {
    this.mFolderId = paramInt;
  }
  
  public void setUnLock(boolean paramBoolean)
  {
    this.mUnLock = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.model.LockInfo
 * JD-Core Version:    0.7.0.1
 */