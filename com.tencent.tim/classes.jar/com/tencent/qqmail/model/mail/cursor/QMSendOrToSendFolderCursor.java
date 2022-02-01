package com.tencent.qqmail.model.mail.cursor;

import com.tencent.qqmail.model.mail.QMMailCGIManager;
import com.tencent.qqmail.model.mail.QMMailProtocolManager;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;

public class QMSendOrToSendFolderCursor
  extends QMDraftFolderCursor
{
  public QMSendOrToSendFolderCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, QMMailCGIManager paramQMMailCGIManager, QMMailProtocolManager paramQMMailProtocolManager, int paramInt)
  {
    super(paramQMMailSQLiteHelper, paramQMMailCGIManager, paramQMMailProtocolManager, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMSendOrToSendFolderCursor
 * JD-Core Version:    0.7.0.1
 */