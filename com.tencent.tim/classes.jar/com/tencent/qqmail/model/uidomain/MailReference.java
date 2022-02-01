package com.tencent.qqmail.model.uidomain;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.model.qmdomain.QMDomain;

public class MailReference
  extends QMDomain
{
  public static final int CONV_CHILD_LOADING = 100;
  private static final long serialVersionUID = 1L;
  private int accountId;
  private int folderId;
  private boolean folderLocked = false;
  private int folderType;
  private boolean isNextConvMailParent;
  private boolean isPrevConvMailParent;
  private MailReferenceNav next;
  private MailReferenceNav prev;
  
  public int getAccountId()
  {
    return this.accountId;
  }
  
  public int getFolderId()
  {
    return this.folderId;
  }
  
  public MailReferenceNav getNext()
  {
    return this.next;
  }
  
  public MailReferenceNav getPrev()
  {
    return this.prev;
  }
  
  public boolean isFolderLocked()
  {
    return this.folderLocked;
  }
  
  public int isFolderType()
  {
    return this.folderType;
  }
  
  public boolean isLocked()
  {
    QQMailAccount localQQMailAccount = (QQMailAccount)AccountManager.shareInstance().getAccountList().getAccountById(this.accountId);
    String str = localQQMailAccount.getEncryptedFolderPwd();
    if ((str == null) || ("".equals(str))) {}
    for (int i = 1; (this.folderLocked) && (i != 0) && (((this.folderType == -8) && (localQQMailAccount.getUserLock("fldpop"))) || ((this.folderType == -7) && (localQQMailAccount.getUserLock("fldmy")))); i = 0) {
      return true;
    }
    return false;
  }
  
  public void setAccountId(int paramInt)
  {
    this.accountId = paramInt;
  }
  
  public void setFolderId(int paramInt)
  {
    this.folderId = paramInt;
  }
  
  public void setFolderLocked(boolean paramBoolean)
  {
    this.folderLocked = paramBoolean;
  }
  
  public void setFolderType(int paramInt)
  {
    this.folderType = paramInt;
  }
  
  public void setNext(MailReferenceNav paramMailReferenceNav)
  {
    this.next = paramMailReferenceNav;
  }
  
  public void setPrev(MailReferenceNav paramMailReferenceNav)
  {
    this.prev = paramMailReferenceNav;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.uidomain.MailReference
 * JD-Core Version:    0.7.0.1
 */