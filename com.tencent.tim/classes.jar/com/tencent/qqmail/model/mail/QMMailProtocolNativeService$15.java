package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.callback.MailListCallback;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;
import com.tencent.qqmail.utilities.qmnetwork.QMProxyUtil;
import com.tencent.qqmail.utilities.sharedpreference.QMSharedPreferenceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class QMMailProtocolNativeService$15
  extends SimpleOnProtocolListener
{
  QMMailProtocolNativeService$15(QMMailProtocolNativeService paramQMMailProtocolNativeService, int paramInt1, MailListCallback paramMailListCallback, Profile paramProfile, int paramInt2, Account paramAccount, QMFolder paramQMFolder, ArrayList paramArrayList, boolean paramBoolean) {}
  
  public void onExchangeSyncFolderFinished(int paramInt, String paramString, ProtocolResult paramProtocolResult)
  {
    QMLog.log(4, "QMMailProtocolNativeService", "onRetrieveMail onExchangeSyncFolderFinished folderId:" + paramInt + " syncState:" + paramString);
    if (paramString == null) {
      return;
    }
    QMFolderManager.sharedInstance().updateFolderSyncState(paramInt, paramString);
  }
  
  public void onExchangeSyncFolderReadStatusFinished(int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String[] paramArrayOfString4, ProtocolResult paramProtocolResult)
  {
    QMLog.log(4, "QMMailProtocolNativeService", "onRetrieveMail onExchangeSyncFolderReadStatusFinished folderId:" + paramInt);
    QMMailManager.sharedInstance().updateMailInfo(paramInt, paramArrayOfString1, paramArrayOfString2, paramArrayOfString3, paramArrayOfString4);
    QMFolderManager.sharedInstance().updateLocalMailUnreadCountIntoFolder(paramInt);
  }
  
  public void onRetrieveMail(com.tencent.qqmail.protocol.Mail paramMail, ProtocolResult paramProtocolResult)
  {
    QMLog.log(4, "QMMailProtocolNativeService", "fetchMailList onRetrieveMail error_code_: " + paramProtocolResult.error_code_ + ", detail_error_: " + paramProtocolResult.detail_code_ + ", detail_msg_: " + paramProtocolResult.detail_msg_);
    if (paramMail == null) {
      QMLog.log(6, "QMMailProtocolNativeService", "onRetrieveMail error, mail is null!");
    }
    do
    {
      return;
      paramMail = QMMailProtocolNativeService.access$400(this.this$0, paramMail, this.val$protocol);
      if (this.val$callback != null) {
        this.val$callback.onRetrieveMail(paramMail);
      }
    } while (paramProtocolResult.error_code_ != 0);
    switch (this.val$profile.protocolType)
    {
    default: 
      return;
    }
    this.this$0.saveActiveSync(this.val$accountId, paramProtocolResult);
  }
  
  public void onRetrieveMailComplete(int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString1, String[] paramArrayOfString2, ProtocolResult paramProtocolResult)
  {
    QMLog.log(4, "QMMailProtocolNativeService", "fetchMailList onRetrieveMailComplete, errorCode: " + paramProtocolResult.error_code_ + ", detailCode: " + paramProtocolResult.detail_code_ + ", detailMsg: " + paramProtocolResult.detail_msg_);
    boolean bool;
    if ((paramProtocolResult.error_code_ == 0) || (paramProtocolResult.error_code_ == 12)) {
      if (paramProtocolResult.error_code_ == 12)
      {
        bool = true;
        if (this.val$callback != null)
        {
          MailListCallback localMailListCallback = this.val$callback;
          if (this.val$profile.protocolType != 0) {
            break label203;
          }
          paramArrayOfString1 = new String[0];
          label115:
          localMailListCallback.onRetrieveSuccess(paramInt2, bool, paramArrayOfString2, new String[0], paramArrayOfString1);
        }
        if (this.val$profile.protocolType == 4) {
          this.this$0.saveActiveSync(this.val$accountId, paramProtocolResult);
        }
        if (this.val$profile.isOauth) {
          QMSharedPreferenceManager.getInstance().setGmailErrorMsgShow(false);
        }
      }
    }
    for (;;)
    {
      if (paramProtocolResult.error_code_ != 0) {
        break label577;
      }
      QMMailProtocolNativeService.access$100(this.this$0, this.val$profile, "fetchMailList", true);
      return;
      bool = false;
      break;
      label203:
      break label115;
      if (paramProtocolResult.error_code_ == 3001)
      {
        QMLog.log(6, "QMMailProtocolNativeService", "fetchMailList token expire");
        if (this.val$profile.isOauth) {
          LoginManager.shareInstance().refreshGmailAccessToken(this.val$account.getId(), this.val$account.getRefreshToken(), new QMMailProtocolNativeService.15.1(this));
        }
      }
      else if (paramProtocolResult.error_code_ == 3000)
      {
        QMLog.log(6, "QMMailProtocolNativeService", "fetchMailList token revoked");
      }
      else if (paramProtocolResult.error_code_ == 13)
      {
        QMLog.log(6, "QMMailProtocolNativeService", "fetchMailList wipe account: " + this.val$accountId);
        QMPrivateProtocolManager.sharedInstance().triggerWipeAppWatcher(this.val$accountId);
      }
      else if (paramProtocolResult.error_code_ == 4)
      {
        QMLog.log(6, "QMMailProtocolNativeService", "fetchMailList auth err : " + this.val$accountId);
        PasswordErrHandler.saveStateAndShowErr(this.val$accountId, -1);
        paramArrayOfString1 = new QMProtocolError(paramProtocolResult.error_code_);
        if (this.val$callback != null) {
          this.val$callback.onRetrieveError(paramArrayOfString1);
        }
      }
      else if (paramProtocolResult.error_code_ == 1006)
      {
        QMLog.log(6, "QMMailProtocolNativeService", "fetchMailList need folder sync");
        paramArrayOfString1 = "active_sync_need_sync_folder" + this.val$accountId;
        if (!RequestFilter.isRequestOnRunning(paramArrayOfString1))
        {
          RequestFilter.setRequestRunningState(paramArrayOfString1);
          QMMailManager.sharedInstance().sync(this.val$accountId);
        }
      }
      else
      {
        QMLog.log(6, "QMMailProtocolNativeService", "fetchMailList error");
        if ((this.val$profile.isOauth) && ((paramProtocolResult.error_code_ == 3) || (paramProtocolResult.error_code_ == 15)) && (QMProxyUtil.isClosed())) {
          QMSharedPreferenceManager.getInstance().setGmailErrorMsgShow(true);
        }
        paramArrayOfString1 = new QMProtocolError(paramProtocolResult.error_code_);
        if (this.val$callback != null) {
          this.val$callback.onRetrieveError(paramArrayOfString1);
        }
      }
    }
    label577:
    QMMailProtocolNativeService.access$100(this.this$0, this.val$profile, "fetchMailList", false);
  }
  
  public void onUpdateComplete(HashMap<String, com.tencent.qqmail.protocol.Mail[]> paramHashMap, ProtocolResult paramProtocolResult)
  {
    int j = 0;
    QMLog.log(4, "QMMailProtocolNativeService", "fetchMailList onUpdateComplete error_code_: " + paramProtocolResult.error_code_ + ", detail_error_: " + paramProtocolResult.detail_code_ + ", detail_msg_: " + paramProtocolResult.detail_msg_);
    paramProtocolResult = new ArrayList();
    if (paramHashMap != null)
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        com.tencent.qqmail.protocol.Mail[] arrayOfMail = (com.tencent.qqmail.protocol.Mail[])((Map.Entry)paramHashMap.next()).getValue();
        int k = arrayOfMail.length;
        i = 0;
        while (i < k)
        {
          com.tencent.qqmail.protocol.Mail localMail = arrayOfMail[i];
          paramProtocolResult.add(QMMailProtocolNativeService.access$400(this.this$0, localMail, this.val$protocol));
          i += 1;
        }
      }
    }
    paramHashMap = new com.tencent.qqmail.model.qmdomain.Mail[paramProtocolResult.size()];
    int i = j;
    while (i < paramProtocolResult.size())
    {
      paramHashMap[i] = ((com.tencent.qqmail.model.qmdomain.Mail)paramProtocolResult.get(i));
      i += 1;
    }
    if (this.val$callback != null) {
      this.val$callback.onRetrieveStatus(paramHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolNativeService.15
 * JD-Core Version:    0.7.0.1
 */