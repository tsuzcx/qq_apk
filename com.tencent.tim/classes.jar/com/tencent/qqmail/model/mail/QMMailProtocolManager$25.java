package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.mail.callback.SearchMailCallback;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.SearchInfo;
import com.tencent.qqmail.protocol.ItemBodyStructureHelper.MailItemBodyStructureInfo;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolManager$25
  implements SearchMailCallback
{
  QMMailProtocolManager$25(QMMailProtocolManager paramQMMailProtocolManager, SearchInfo paramSearchInfo, SearchMailQueueHandler.SearchMailCallback paramSearchMailCallback, Profile paramProfile) {}
  
  public void onSearchComplete(int paramInt, int[] paramArrayOfInt)
  {
    if (paramInt <= paramArrayOfInt[0]) {
      if (this.val$searchCallbacks != null) {
        this.val$searchCallbacks.handleOnComplete(this.val$searchInfo);
      }
    }
    while ((paramArrayOfInt[1] == 0) || (this.val$searchCallbacks == null)) {
      return;
    }
    this.val$searchCallbacks.handleOnMoveOn(this.val$searchInfo, new long[0]);
  }
  
  public void onSearchError(SearchInfo paramSearchInfo, QMProtocolError paramQMProtocolError)
  {
    if (this.val$searchCallbacks != null) {
      this.val$searchCallbacks.handleOnError(paramSearchInfo, paramQMProtocolError);
    }
  }
  
  public void onSearchMail(Mail paramMail)
  {
    int i = 0;
    SQLiteDatabase localSQLiteDatabase = QMMailProtocolManager.access$000(this.this$0).getWritableDatabase();
    if (!QMMailProtocolManager.access$000(this.this$0).mail.isSearchMailExist(localSQLiteDatabase, paramMail.getInformation().getId()))
    {
      QMMailProtocolManager.access$000(this.this$0).mail.insertRemoteSearchMails(localSQLiteDatabase, this.val$searchInfo.getAccountId(), paramMail, false);
      if (this.val$searchCallbacks != null) {
        this.val$searchCallbacks.handleOnProcess(this.val$searchInfo, paramMail.getInformation().getId());
      }
    }
    if (!QMMailProtocolManager.access$000(this.this$0).mail.isSearchMailInSearchTypeExist(localSQLiteDatabase, paramMail.getInformation().getId(), this.val$searchInfo.getSearchType())) {
      QMMailProtocolManager.access$000(this.this$0).mail.insertTmpSearchUtc(localSQLiteDatabase, paramMail.getInformation().getId(), this.val$searchInfo.getSearchType());
    }
    if (this.val$profile.protocolType == 1)
    {
      ItemBodyStructureHelper.MailItemBodyStructureInfo[] arrayOfMailItemBodyStructureInfo = paramMail.getInformation().getBodyStructureInfos();
      int j = arrayOfMailItemBodyStructureInfo.length;
      while (i < j)
      {
        ItemBodyStructureHelper.MailItemBodyStructureInfo localMailItemBodyStructureInfo = arrayOfMailItemBodyStructureInfo[i];
        QMMailProtocolManager.access$000(this.this$0).mail.insertMailPartInfo(localSQLiteDatabase, paramMail.getInformation().getId(), localMailItemBodyStructureInfo);
        i += 1;
      }
    }
  }
  
  public void onSearchSuccess(int paramInt, int[] paramArrayOfInt)
  {
    if ((paramInt == 0) || (paramArrayOfInt[1] == 0)) {
      if (this.val$searchCallbacks != null) {
        this.val$searchCallbacks.handleOnEmpty(this.val$searchInfo);
      }
    }
    while (this.val$searchCallbacks == null) {
      return;
    }
    this.val$searchCallbacks.handleOnSuccess(this.val$searchInfo, new long[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolManager.25
 * JD-Core Version:    0.7.0.1
 */